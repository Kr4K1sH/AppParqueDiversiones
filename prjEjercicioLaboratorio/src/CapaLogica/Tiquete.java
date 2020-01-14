 package CapaLogica;

import CapaDatos.TiqueteBD;

import java.io.Serializable;

import java.util.ArrayList;

public class Tiquete implements Serializable{
    private String descripcion;
    private double precio;

    public Tiquete(String descripcion, double precio) {
    
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public static ArrayList listaTipo()throws Exception{
       ArrayList lista= TiqueteBD.getInstance().listaDeTiquetes();
    return lista;
    }
   
    public static void agregarTipo(Tiquete tipo)throws Exception{
    TiqueteBD.getInstance().agregarTiquete(tipo);
    }   
    public static Tiquete consultarTipo(String descripcion)throws Exception{
        return TiqueteBD.getInstance().consultarTiquete(descripcion);
    }
    public static void eliminarTipo(String descripcion)throws Exception{
        TiqueteBD.getInstance().eliminarTiquete(descripcion);
    }
   
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
    public String toString(){
        return "Descripcion:" +this.descripcion+" \nPrecio: "+this.precio;
    }
}
