package CapaGrafica;

import CapaDatos.CompraBD;

import CapaLogica.Compra;

import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class jdlgCompra extends JDialog {
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JButton jbtnCompra = new JButton();
    private JButton jbtnSalir = new JButton();
 private DefaultTableModel modeloTabla= new DefaultTableModel();
    private JTable jtblCompras = new JTable();

   private char tipo;
    private Compra micompra;
    public jdlgCompra() {
        this(null, "", false);
    }
public jdlgCompra(char tipo, Compra micompra) {
        this(null, "", false);
        this.tipo = tipo;
        this.micompra = micompra;
    }

    public jdlgCompra(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(399, 369));
        this.getContentPane().setLayout( null );
        this.addWindowListener(new WindowAdapter() {
                public void windowOpened(WindowEvent e) {
                    this_windowOpened(e);
                }
            });
        jScrollPane1.setBounds(new Rectangle(20, 25, 345, 230));
        jbtnCompra.setText("Ver compra");
        jbtnCompra.setBounds(new Rectangle(35, 285, 140, 20));
        jbtnCompra.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbtnCompra_actionPerformed(e);
                }
            });
        jbtnSalir.setText("Salir");
        jbtnSalir.setBounds(new Rectangle(205, 285, 140, 20));
        jbtnSalir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbtnSalir_actionPerformed(e);
                }
            });
        this.getContentPane().add(jbtnSalir, null);
        this.getContentPane().add(jbtnCompra, null);
        jScrollPane1.getViewport().add(jtblCompras, null);
        this.getContentPane().add(jScrollPane1, null);
        Titulos();
    }
    private void Titulos(){
        String t []= {"Compras"};
        this.modeloTabla = new DefaultTableModel(t,0);
        this.jtblCompras.setModel(this.modeloTabla);
        this.jtblCompras.setRowSelectionAllowed(true);
        }
    private void llenatabla(){
        String d []=new String [1];
        d[0]= micompra.toString()+"";
        modeloTabla.addRow(d);
    }
    private void this_windowOpened(WindowEvent e) {
        this.modeloTabla.setRowCount(0);
        switch(tipo){
        case 'A':
            llenatabla();
        }
    }

    private void jbtnCompra_actionPerformed(ActionEvent e) {
   JOptionPane.showMessageDialog(this,this.micompra.toString());
   this.dispose();
    }

    private void jbtnSalir_actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
