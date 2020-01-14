package CapaDatos;
    import java.io.IOException;
    import java.io.ObjectOutputStream;
    import java.io.OutputStream;
    /*
     * En esta clase se sobrescribe la clase ObjectOutputStream de manera que
     * el método writeStreamHeader() no haga ninguna acción, pues este método en la clase
     * super, cada vez que abre el archivo para escritura(output) graba encabezados del
     * registro y por tanto, una vez que se cierra el archivo, si lo abrimos de tipo input,
     * al recorrer los registros desde el inicio en forma secuencial se detendrá al encontrar
     * la segunda fila de encabezados.
     * De esta forma cuando el archivo no existe y se va a crear por primera vez, se utiliza
     * la clase super con el fin de que cree la primer fila de encabezados, pero si ya
     * el archivo existe, entonces se utiliza la subclase MiObjectOutputStream para que no
     * escriba los encabezados cada vez que abre el archivo.
     */
    public class MiObjectOutputStream extends ObjectOutputStream
    {
        /** Constructor que recibe OutputStream */
        public MiObjectOutputStream(OutputStream out) throws IOException
        {
            super(out); //Ejecuta el constructor de ObjectOutputString
        }

       

        /** Redefinición del método que escribe el encabezado de manera que no haga nada. */
        protected void writeStreamHeader() throws IOException
        {
        }
}
