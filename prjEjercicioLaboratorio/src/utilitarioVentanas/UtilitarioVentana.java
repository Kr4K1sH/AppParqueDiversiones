package utilitarioVentanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class UtilitarioVentana {
    
    /**
     * Método para Centrar una ventana tipo JFrame
     * @param pVentanaJFrame Objeto JFrame a Centrar
     */
    public static void centrarVentanaJFrame(JFrame pVentanaJFrame){
        //Leer las dimensiones de la ventana principal y del cliente
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = pVentanaJFrame.getSize();
        
        //Ajusta el alto y ancho del JFrame principal
        //si es mayor al tamaño del screen del OS cliente
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        
        //Ubicar en el eje X,Y la ventana JFrame
        pVentanaJFrame.setLocation( ( screenSize.width - frameSize.width ) / 2, 
                                    ( screenSize.height - frameSize.height ) / 2 );
        //Al definir DISPOSE_ON_CLOSE implicará que la finalización
        //de la ejecución de la aplicación deberá ser administrada por 
        //otra entidad, ejemplo método main()
        pVentanaJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        pVentanaJFrame.setVisible(true);   
    }
    
    /**
     * Método para Centrar una ventana tipo JPanel con un objeto JInternalFrame
     * @param pVentanaPrincipal Objeto JFrame que contiene los JInternalFrame
     * @param pTituloVentana String del título del JInternalFrame
     * @param pPanel Instancia del objeto Panel a asociar en el JInternalFrame
     * @param pEscritorioPane Objeto JDesktopPane del Frame Principal
     */    
    public static void centrarVentanaJPanel(JFrame pVentanaPrincipal, String pTituloVentana, 
                                            JPanel pPanel, JDesktopPane pEscritorioPane) {        
        JInternalFrame oJInternalFrame = new JInternalFrame(pTituloVentana, true, true, true, true);    
        
        //Leer las dimensiones de la ventana principal y del cliente
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = pVentanaPrincipal.getSize();        
        
        //Ajusta el alto y ancho del JFrame principal
        //si es mayor al tamaño del screen del OS cliente
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }        
        
        //Asociar el objeto Panel al JInternalFrame
        oJInternalFrame.add(pPanel, BorderLayout.CENTER);        
        
        //Ubicar el JInternalFrame en el centro del Frame Principal
        oJInternalFrame.setLocation( ( frameSize.width - pPanel.getWidth() ) / 2, 
                                     ( frameSize.height - pPanel.getHeight() ) / 2 );       
        
        //Definir que al cerrar el JInternalFrame se destruya el objeto de memoria
        oJInternalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oJInternalFrame.pack();        
        
        //Agregar el JInternalFrame el objeto JDesktopPane del Frame Principal
        pEscritorioPane.add(oJInternalFrame);        
        
        //Mostrar el JInternalFrame
        oJInternalFrame.setVisible(true);
    }

    /**
     * Método para Centrar una ventana tipo JDialog
     * Siempre se muestra en forma modal
     * @param pVentanaJDialog Objeto JDialog a Centrar
     */
    public static void centrarVentanaJDialog(JDialog pVentanaJDialog){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = pVentanaJDialog.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        pVentanaJDialog.setLocation( ( screenSize.width - frameSize.width ) / 2, 
                                     ( screenSize.height - frameSize.height ) / 2 );
        pVentanaJDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pVentanaJDialog.setModal(true);
        pVentanaJDialog.setVisible(true);   
    }
    
    /**
     * Recorre los objetos contenidos en un panel para cerrar el 
     * JFrame/JInternalFrame que lo contiene
     * @param oPanel Objeto Panel a buscar el objeto JFrame/JInternalFrame
     */
    public static void cerrarPanel(JPanel oPanel){
       //Leer el padre de un panel en 5 Niveles permite iterar por medio del 
       //método getComponent(x) el objeto JFrame/JInternalFrame que contiene el panel
       //Si existe invoca el dispose de dicho JInternalFrame
       for(int i=0; i < oPanel.getParent().getParent().getParent().getParent().getParent().getComponentCount(); i++){            
          if (oPanel.getParent().getParent().getParent().getParent().getParent().getComponent(i).getClass() == JInternalFrame.class){                    
             ((JInternalFrame)oPanel.getParent().getParent().getParent().getParent().getParent().getComponent(i)).dispose();
             return;
          }else if (oPanel.getParent().getParent().getParent().getParent().getParent().getComponent(i).getClass() == JFrame.class){
             ((JFrame)oPanel.getParent().getParent().getParent().getParent().getParent().getComponent(i)).dispose();
             return;
          }                
       }
    }

    /**
     * Retornar el nombre de la clase que permite modificar el Look and Feel
     * de las ventanas de una aplicación
     * @param pEstilo Número del estilo de 1 hasta el 3
     * @return Nombre del estilo a aplicar
     */
    private static String getEstiloVentana(int pEstilo) {
        String vEstilo = "";

        switch (pEstilo) {
        case 1:
            //System
            vEstilo = UIManager.getSystemLookAndFeelClassName();        
            break;
        case 2:
            //Metal
            vEstilo = UIManager.getCrossPlatformLookAndFeelClassName();
            break;
        case 3:
            //Moti
            vEstilo = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            break;
        default:
            //Aplica el estilo default del Sistema operativo
            vEstilo = UIManager.getSystemLookAndFeelClassName();
        }
        return vEstilo;
    }    

    /**
     * Método que modifica el estilo de las ventanas del ambiente swing
     * @param pEstilo Número del estilo de 1 hasta el 3
     */
    public static void aplicarEstiloVentas(int pEstilo) {
        try {            
            UIManager.setLookAndFeel(getEstiloVentana(pEstilo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
