package CapaGrafica;

import utilitarioVentanas.UtilitarioVentana;

public class appPrincipal {
    public static void main(String[] args) {
        jFrmVentanaPrincipal oFrmVentanaPrincipal = new jFrmVentanaPrincipal();
        
        //Modificar el Look and Feel 
        UtilitarioVentana.aplicarEstiloVentas(2);
        
        //Centrar la ventana principal y mostrar al usuario
        UtilitarioVentana.centrarVentanaJFrame(oFrmVentanaPrincipal);
    }
}
