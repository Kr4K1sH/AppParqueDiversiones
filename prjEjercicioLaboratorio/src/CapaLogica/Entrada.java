package CapaLogica;

import CapaDatos.TiqueteBD;

import java.io.Serializable;

import java.util.ArrayList;

public abstract class Entrada implements Serializable {
    
    private final double DESC = 0.50;
    ArrayList<Tiquete> arrayTiquete=null;
    private int codigo;
    private boolean codigoPromo;
    private static int numeroCodigo;
    private String tipoEntrada;

    public String toString(){
        String hilera ="";
        hilera += "Codigo: "+this.codigo+
                  "\n Codigo promocional: "+this.codigoPromo+
                  "\n"+"Tipo Entrada : "+this.tipoEntrada
            +"\n Costo Tiquetes: "+this.calculaTotalTiquete()+
                  "\nCosto Entrada: "+this.calcularPrecioEntrada()+
                  "\nCosto Total: "+this.calculaTotalEntrada(); 
        return hilera;
        }
    public Entrada(String tipoEntrada,boolean codigoPromo ) {
        
        this.codigoPromo = codigoPromo;
        this.tipoEntrada = tipoEntrada;
    }
    public void agregarTiquete(Tiquete tiquete){
        arrayTiquete.add(tiquete);
    }
    public abstract double calcularPrecioEntrada();
    
    public double calculaTotalEntrada(){
        double total=0;
        if(isCodigoPromo()){
       total+=calcularPrecioEntrada()*DESC;
        }else{
            total+=calculaTotalEntrada();
        }
       return total;
    }
    public double calculaTotalTiquete(){
        double pr =0;
      
       for(int i=0; i<arrayTiquete.size(); i++){
          pr+= arrayTiquete.get(i).getPrecio();
       }
        return pr;
    
    }
    public ArrayList<Tiquete> getArrayTiquete() {
        return arrayTiquete;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigoPromo(boolean codigoPromo) {
        this.codigoPromo = codigoPromo;
    }

    public boolean isCodigoPromo() {
        return codigoPromo;
    }

    public static void setNumeroCodigo(int numeroCodigo) {
        Entrada.numeroCodigo = numeroCodigo;
    }

    public static int getNumeroCodigo() {
        return numeroCodigo;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setArrayTiquete(ArrayList<Tiquete> arrayTiquete) {
        this.arrayTiquete = arrayTiquete;
    }
}
