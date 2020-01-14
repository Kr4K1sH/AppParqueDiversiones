package CapaGrafica;

import CapaLogica.Tiquete;

import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

public class jdlgTiquetes extends JDialog {
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private JEditorPane jtxtDescripcion = new JEditorPane();
    private JEditorPane jtxtPrecio = new JEditorPane();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();

    private String descripcion;
    private char TipoMant;
   
    public jdlgTiquetes(char TipoMant) {
        this(null, "", false);
        this.TipoMant = TipoMant;
    }
    public jdlgTiquetes(char TipoMant, String descripcion) {
        this(null, "", false);
        this.TipoMant = TipoMant;
        this.descripcion = descripcion;
    }

    public jdlgTiquetes(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(403, 230));
        this.getContentPane().setLayout( null );
        this.addWindowListener(new WindowAdapter() {
                public void windowOpened(WindowEvent e) {
                    this_windowOpened(e);
                }
            });
        jButton1.setText("Aceptar");
        jButton1.setBounds(new Rectangle(40, 130, 145, 20));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jButton2.setText("Salir");
        jButton2.setBounds(new Rectangle(220, 130, 145, 20));
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2_actionPerformed(e);
                }
            });
        jtxtDescripcion.setBounds(new Rectangle(110, 30, 235, 30));
        jtxtPrecio.setBounds(new Rectangle(110, 75, 235, 30));
        jLabel1.setText("Descripcion");
        jLabel1.setBounds(new Rectangle(30, 35, 70, 20));
        jLabel2.setText("Precio");
        jLabel2.setBounds(new Rectangle(60, 80, 70, 20));
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jtxtPrecio, null);
        this.getContentPane().add(jtxtDescripcion, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton1, null);
    }


    private void this_windowOpened(WindowEvent e) {
        this.jtxtDescripcion.setText(this.descripcion+"");
        this.jtxtPrecio.setText("");
        switch(TipoMant){
        case 'A':
            this.jtxtDescripcion.setEditable(true);
            this.jtxtDescripcion.setText("");
            this.jtxtPrecio.setText("");
            this.setTitle("Nuevo Tiquete");
            break;
        case 'M':
            this.jtxtDescripcion.setEditable(false);
            this.jtxtPrecio.setText("");
            this.setTitle("Modificar Tiquete");
            break;
        case 'C':
            this.jtxtDescripcion.setEditable(false);
        this.jtxtPrecio.setEditable(false);
            this.setTitle("Consultar Tiquete");
            break;
        }
    }


    private void jButton1_actionPerformed(ActionEvent e) {
        String desc = this.jtxtDescripcion.getText();
     double precio = Double.parseDouble(this.jtxtPrecio.getText());
     
    MantenimientoTiquetes.setMiTiquete(new Tiquete(desc,precio));
     this.dispose();
     
    }

    private void jButton2_actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
