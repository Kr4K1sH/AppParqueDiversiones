package CapaLogica;

import java.io.Serializable;

public class Especial extends Entrada implements Serializable {
    private final double PRECIO_BASICO=5000;
      
        public  Especial(String tipoEntrada, boolean codPromo) {
            super(tipoEntrada,codPromo);
        }
        public double calculaPrecioEntrada(){
        return  0;
        }
        public String toString(){
            return "Precio de la Entrada es de: "+this.calculaPrecioEntrada()+"\n"+
                   "Precio Base: "+this.PRECIO_BASICO;
        }


      
        public double getPRECIO_BASICO() {
            return PRECIO_BASICO;
        }


    public double calcularPrecioEntrada() {
        return this.getPRECIO_BASICO();
    }
}
