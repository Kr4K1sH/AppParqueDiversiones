package CapaLogica;

import java.io.Serializable;

public class Anual extends Entrada implements Serializable  {
    private String codigoA;
   private final double PRECIO_BASICO = 0;
    public Anual(String tipoEntrada,boolean CodPromo, String codigoA){
    super(tipoEntrada, CodPromo);
    this.codigoA = codigoA;
    }
    public double calcularPrecioEntrada() {
       return 0;
    }

    public String toString(){
    return"\n Codigo: "+this.codigoA
            +"\n Precio: "+this.PRECIO_BASICO;
    }
    public void setCodigo(String codigoA) {
        this.codigoA = codigoA;
    }

    public String getCodigoA() {
        return codigoA;
    }
}
