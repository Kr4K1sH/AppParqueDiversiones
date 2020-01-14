package CapaLogica;

import CapaDatos.CompraBD;

import java.util.ArrayList;
import java.util.Date;

public class Compra {
    private ArrayList<Entrada>arrayEntradas;
    private static int cantOrdenes=1;
    private Date fecha;
    private int numeroCompra;
    
    public Compra(){
        this.arrayEntradas=new ArrayList<Entrada>();
        this.numeroCompra=cantOrdenes++;
        this.fecha=new Date();
    }
    public String toStrirng(){
        return "Orden: "+this.numeroCompra+
               "\n Fecha: "+this.fecha+
               "\nCosto Compra: "+this.calculaTotalCompra()+
               "\nEntradas: "+this.arrayEntradas.toString();
    }
    public void agregarEntrada(Entrada entrada){
        arrayEntradas.add(entrada);
    }
    public double calculaTotalCompra(){
        double total=0; 

        for (Entrada entrada : arrayEntradas) {
            
            total+=entrada.calculaTotalEntrada();
        }
        return total;
    }

    public void setNumeroCompra(int numeroCompra) {
        this.numeroCompra = numeroCompra;
    }

    public int getNumeroCompra() {
        return numeroCompra;
    }

    public void setArrayEntradas(ArrayList<Entrada> arrayEntradas) {
        this.arrayEntradas = arrayEntradas;
    }

    public ArrayList<Entrada> getArrayEntradas() {
        return arrayEntradas;
    }

    public static int getCantOrdenes() {
        return cantOrdenes;
    }

    public Date getFecha() {
        return fecha;
    }
}
