package CapaGrafica;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import utilitarioVentanas.UtilitarioVentana;

public class jFrmVentanaPrincipal extends JFrame {
    private JMenuBar jMnuMenuPrincipal = new JMenuBar();
    private JMenu jMnuSistema = new JMenu();
    private JMenuItem jmnuManteniminento = new JMenuItem();
    private JMenuItem jMnuSistemaSalir = new JMenuItem();
    private JMenu jMnuEjercicios = new JMenu();
    private JMenuItem jMnuEjerciciosEjercicio1 = new JMenuItem();    
    private JMenu jMnuAyuda = new JMenu();
    private JMenuItem jMnuAyudaAcercaDe = new JMenuItem();
    
    //Variable privada para manejar los objetos Panel
    private JDesktopPane oEscritorioPane = new JDesktopPane();

    public jFrmVentanaPrincipal() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        //this.getContentPane().setLayout( null );
        this.add(oEscritorioPane);
        
        this.setSize(new Dimension(800, 600));
        this.setTitle( "Ejemplos Gráficos en Java" );
        this.setJMenuBar(jMnuMenuPrincipal);
        this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    this_windowClosing(e);
                }
            });
        jMnuSistema.setText("Sistema");
        jmnuManteniminento.setText("Mantenimiento");
        jmnuManteniminento.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jmnuManteniminento_actionPerformed(e);
                }
            });
        jMnuSistemaSalir.setText("Salir");
        jMnuSistemaSalir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jMnuSistemaSalir_actionPerformed(e);
                }
            });
        jMnuAyuda.setText("Ayuda");
        jMnuAyudaAcercaDe.setText("Acerca de...");
       
        jMnuEjercicios.setText("Ejercicios");
        jMnuEjerciciosEjercicio1.setText("Ejercicio 1");
        jMnuEjerciciosEjercicio1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jMnuEjerciciosEjercicio1_actionPerformed(e);
                }
            });
        jMnuSistema.add(jmnuManteniminento);
        jMnuSistema.add(jMnuSistemaSalir);
        jMnuMenuPrincipal.add(jMnuSistema);
        jMnuEjercicios.add(jMnuEjerciciosEjercicio1);
        jMnuMenuPrincipal.add(jMnuEjercicios);
        jMnuAyuda.add(jMnuAyudaAcercaDe);
        jMnuMenuPrincipal.add(jMnuAyuda);
    }

    private void this_windowClosing(WindowEvent e) {
        System.exit(0);
    }

    private void jMnuSistemaSalir_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

   

//    private void jMnuEjemplosJTextField_actionPerformed(ActionEvent e) {
//        //Crear el objeto JPanel del jPanEjemploTextField
//        jPanEjemploTextField ojPanEjemploTextField = new jPanEjemploTextField();
//        
//        //Invocar el métod de UtilitarioVentanas que permite crear un JInternalFrame
//        //para agregarle el objeto JPanel y desplegarlo en el centro del objeto JFrame
//        //principal
//        UtilitarioVentana.centrarVentanaJPanel(this, 
//                                               "Ejemplo de objetos JTextField",
//                                               ojPanEjemploTextField,
//                                               this.oEscritorioPane);
//    }

    private void jMnuEjerciciosEjercicio1_actionPerformed(ActionEvent e) {
        FrmParqueDiversiones p = new FrmParqueDiversiones();
        p.setVisible(true);
        p.setLocationRelativeTo(null);
        }

    private void jmnuManteniminento_actionPerformed(ActionEvent e) {
        MantenimientoTiquetes p = new   MantenimientoTiquetes();
        p.setVisible(true);
        p.setLocationRelativeTo(null);
    }
}
