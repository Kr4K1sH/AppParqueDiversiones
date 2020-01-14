package CapaLogica;

import CapaDatos.TiqueteBD;

import java.io.Serializable;

import java.util.ArrayList;

public class Regular extends Entrada implements Serializable {
    private final double PRECIO_BASICO =2000;
        public Regular(String tipoEntrada, boolean codPromo) {
            super(tipoEntrada,codPromo);
        }
    
    public double calcularPrecioEntrada() {
        double precio=0;
        for ( Tiquete ti : super.getArrayTiquete() ){
            precio += ti.getPrecio();
        }
      double tot = precio+this.PRECIO_BASICO;
      return tot;
    }
        public String toString(){
            return "Precio de la Entrada es de: "+this.calcularPrecioEntrada()+"\n"+
                   "Precio Base: "+this.PRECIO_BASICO;
        }

}
