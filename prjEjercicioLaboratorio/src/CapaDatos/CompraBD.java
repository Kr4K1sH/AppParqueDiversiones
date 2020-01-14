package CapaDatos;

import CapaLogica.Compra;
import CapaLogica.Tiquete;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

public class CompraBD {
    private String rutaArchivo = ".\\ArchivosCompra\\Compra.txt";
       private String rutaArchivoTemporal= ".\\ArchivosCompra\\CompraTemp.txt";
       private ObjectOutputStream oArchivoOOS= null;
       private ObjectOutputStream oArchivoTempOOS= null;
       private ObjectInputStream oArchivoOIS= null;
       
       //Instancia privada de la misma clase
       //implementa el patrón Singleton
       private static  CompraBD oCompraBD= null;
       
       //Constructor privado, se implementa el patrón Singleton
       private CompraBD() {
           rutaArchivo = ".\\ArchivosCompra\\Compra.txt";
           rutaArchivoTemporal = ".\\ArchivosCompra\\CompraTemp.txt";
           oArchivoTempOOS = null;
           oArchivoOOS= null;
           oArchivoOIS= null;
       }
       
       //Método público que retorna una única instancia de la 
       //clase, únicamnete se construye la primera vez.
       public static CompraBD getInstance(){
           if(oCompraBD == null){
               oCompraBD = new CompraBD();
           }
           return oCompraBD;
       }
       
       //OJO: este tipo de comentario genera la ayuda del método
       /**
        * Abre y retorna el archivo de datos, para escritura (de tipo output) al final del archivo
        * Tipo de Archivo: Secuencial.
        * Lanza la Exception al nivel donde fue llamado
        * @param rutaArchivo String ruta del archivo
        * @return ObjectOutputStream
        */
       public  ObjectOutputStream abrirArchivoOutput(String rutaArchivo) throws Exception {
           ObjectOutputStream oArchivoOutput = null;
           FileOutputStream oArchivoFOS;
              //Abrir el archivo
           try{
           File oArchivo = new File(rutaArchivo);
              if(!oArchivo.exists()){
                //Abrir el archivo de Acceso Secuencial para  escritura
                //La primera vez incluye la cabecera del archivo
                //true indica que se agregarán registros al final
               
                oArchivoFOS = new FileOutputStream(rutaArchivo,true);
                oArchivoOutput = new ObjectOutputStream(oArchivoFOS);
               
              }
              else{
                //Abrir el archivo de Acceso Secuencial para  escritura
                //La primera vez incluye la cabecera del archivo
                 oArchivoFOS = new FileOutputStream(rutaArchivo,true);
                 oArchivoOutput = new MiObjectOutputStream(oArchivoFOS);
              }  
           }catch(Exception e){
               throw e;
           }
           return oArchivoOutput;
       }

       /**
        * Abre y retorna el archivo de datos, para lectura (de tipo input)
        * El apuntador del archivo se coloca al inicio del archivo
        * Tipo de Archivo: Secuencial.
        * @param rutaArchivo String ruta del archivo
        * @return ObjectInputStream
        */
       public  ObjectInputStream abrirArchivoInput(String rutaArchivo) throws Exception {
       
           FileInputStream oArchivoFIS;
           ObjectInputStream oArchivoInput = null;    
           //Abrir el archivo
         try{    
           oArchivoFIS = new FileInputStream(rutaArchivo);
           oArchivoInput = new ObjectInputStream(oArchivoFIS);
         }
         catch(Exception e){
            throw e;
         }
         return oArchivoInput;
       }

       
       /**
        * Permite cerrar el archivo de datos que se abrió de salida
       */
       public  void cerrarArchivoOutput(ObjectOutputStream oArchivo) throws Exception { 
           try{
           if (oArchivo != null) {
               oArchivo.close();
               oArchivo = null;
           }  
           }
           catch(Exception e){
              throw e;
           }
       }

       private void cerrarArchivoInput(ObjectInputStream archivo) throws Exception {
           try{     
                if (archivo != null) {
                   archivo.close();
                   archivo = null;
                }
           }
           catch(Exception e){
              throw e;
           }
       }


       /**
        * Lista de todos los Departamentos que se encuentran en el archivo
        * @return ArrayList
        */
        public ArrayList listaDeCompra() throws Exception{
           ArrayList listaDeCompra= new ArrayList();
           //Ya que habrá bloque finally se debe encerrar el bloque try
           //el throws del encabezado lanza la excepción del finally
           try {         
               oArchivoOIS = abrirArchivoInput(rutaArchivo);
              
              //Si al leer del archivo no hay objeto sucede la excepción
               while(true){
                   Compra miCompra = (Compra)oArchivoOIS.readObject();                  
                   listaDeCompra.add(miCompra);
               }
            } //No se indica el catch ya que no se hará nada, solamente se lanzará por medio del throws  
           catch(Exception ex ){
               
           }
            finally{
               //Ocurra o no ocurra la excepción se cierra el archivo
               cerrarArchivoInput(oArchivoOIS);
              
            }
           return listaDeCompra;
           
       }

       //Busca y retorna el objeto Departamento de acuerdo al código que recibe como
       //parámetro, en caso de que no lo encuentre retorna null
       public Compra consultarCompra(int numOrden)throws Exception {
           Compra compradoBuscado= null ;
           try {
                oArchivoOIS = abrirArchivoInput(rutaArchivo);
                //Si va a leer y no hay objeto Departamento se va por el catch
                while(true){
                   compradoBuscado = (Compra)oArchivoOIS.readObject();
                   if (compradoBuscado.getNumeroCompra()==numOrden) {
                       return compradoBuscado;
                   } else {
                      
                   }
               }            
           }catch(Exception e){
               compradoBuscado = null;
               return compradoBuscado;
               
           }
           finally{ //Suceda o no suceda la excepción se deben cerrar los archivos
                cerrarArchivoInput(oArchivoOIS);
           }        
       }


       /**
        * Agregar un nuevo Departamento al final del archivo
        * @param pTopping Objeto Departamento a agregar
        * @return boolean
        */
       public void agregarCompra(Compra pCompra)throws Exception {
           
           try {
               oArchivoOOS= this.abrirArchivoOutput(rutaArchivo);
               if (oArchivoOOS != null) {
                 //Ejecutar la escritura del objeto pDepartamento en el archivo
                  oArchivoOOS.writeObject(pCompra);
                  oArchivoOOS.flush();  //Envía el contenido del buffer al archivo
               }
           
           } catch (Exception e) {
               throw e;
           }
           finally{
               //Ocurra o no la excepción se debe cerrar el archivo
               this.cerrarArchivoOutput(oArchivoOOS); //Cierra el archivo
           }
           
       }

       /**
        * Agregar un nuevo Departamento al archivo
        * @param pTopping Objeto Departamento a agregar
        * @return boolean
        */
         public void modificarTiquete(Tiquete pTiquete) throws Exception{
           try {            
               oArchivoOIS = abrirArchivoInput(rutaArchivo);
               //Declara archivo temporal y lo abre de tipo Output            
               oArchivoTempOOS = abrirArchivoOutput(rutaArchivoTemporal);
                //Si va a leer y no hay objeto Departamento se va por el catch
                //Pasar todos los objetos del archivo al temporal modificando el 
               //objeto que se desea modificar
              Tiquete tiquete=null;
                while(true){
                    tiquete= (Tiquete)oArchivoOIS.readObject(); 
                    if(tiquete.getDescripcion().equalsIgnoreCase(pTiquete.getDescripcion())) {
                      tiquete=pTiquete;
                    }
                    oArchivoTempOOS.writeObject(tiquete);
                }            
           }
           catch(Exception ex){
           }
           finally{
               cerrarArchivoInput(oArchivoOIS);
               cerrarArchivoOutput(oArchivoTempOOS);
               
           }
           pasarArchivoTemporal_ArchivoOriginal();        
       }
       
       public void eliminarTiquete(String descripcion) throws Exception {
           try {            
               oArchivoOIS = abrirArchivoInput(rutaArchivo);
               //Declara archivo temporal y lo abre de tipo Output            
               oArchivoTempOOS = abrirArchivoOutput(rutaArchivoTemporal);
                //Si va a leer y no hay objeto Departamento se va por el catch
                //Pasar todos los objetos del archivo al temporal modificando el 
               //objeto que se desea modificar
                Tiquete tiquete = null;
                while(true){
                    tiquete = (Tiquete)oArchivoOIS.readObject();               
                    if(!tiquete.getDescripcion().equalsIgnoreCase(descripcion)) {
                       oArchivoTempOOS.writeObject(tiquete);
                    }
                }            
           }catch(Exception e){
              
           }
           finally{
                cerrarArchivoInput(oArchivoOIS);
                cerrarArchivoOutput(oArchivoTempOOS);
           }
           pasarArchivoTemporal_ArchivoOriginal();
           
       }
       

       private void pasarArchivoTemporal_ArchivoOriginal() {
          //Se elimina el archivo original y se renombra el temporal igual a este.   
          File archivoTemp = new File(rutaArchivoTemporal);
          File archivoOriginal = new File(rutaArchivo);
          //Si los archvos existen borrar el archivo original para volverlo a llamar            
          if(archivoTemp.exists()&& archivoOriginal.exists()){
            archivoOriginal.delete();
            archivoTemp.renameTo(new File(".\\ArchivosCompra\\Compra.txt"));
          }      
       }  
    

    }
