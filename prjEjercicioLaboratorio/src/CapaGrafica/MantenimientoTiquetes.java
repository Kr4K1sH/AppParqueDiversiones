package CapaGrafica;

import CapaDatos.TiqueteBD;

import CapaLogica.Tiquete;

import java.awt.Dimension;

import java.awt.GridLayout;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class MantenimientoTiquetes extends JFrame {
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JToolBar jToolBar1 = new JToolBar();
    private JButton jbtnAgregar = new JButton();
    private JButton jbtnSalir = new JButton();
    private GridLayout gridLayout1 = new GridLayout();
    private JTable jtblListaTiquetes = new JTable();
    private DefaultTableModel modeloTabla;
    
    private static Tiquete miTiquete=null;
    
    
    public MantenimientoTiquetes() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(405, 274));
        jScrollPane1.setBounds(new Rectangle(15, 105, 365, 110));
        jToolBar1.setBounds(new Rectangle(20, 15, 355, 75));
        jToolBar1.setLayout(gridLayout1);
        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbtnAgregar_actionPerformed(e);
                }
            });


        jbtnSalir.setText("Salir");
        jbtnSalir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbtnSalir_actionPerformed(e);
                }
            });
        jToolBar1.add(jbtnAgregar, null);
        jToolBar1.add(jbtnSalir, null);
        this.getContentPane().add(jToolBar1, null);
        jScrollPane1.getViewport().add(jtblListaTiquetes, null);
        this.getContentPane().add(jScrollPane1, null);
        titulos();
    }
    private void titulos(){
        String ti[]= {"Descripcion","Precio"};
       this.modeloTabla = new DefaultTableModel(ti,0);
       this.jtblListaTiquetes.setModel(modeloTabla);
       this.jtblListaTiquetes.setRowSelectionAllowed(true);
    }
    private void llenaTabla(){
        this.modeloTabla.setRowCount(0);
        String dat[] = new String [2];
        ArrayList<Tiquete> lista = null;
        
        try{
            lista= TiqueteBD.getInstance().listaDeTiquetes();
        }catch(Exception ex){
            
        }
        for (Tiquete ti : lista){
            dat[0]= ti.getDescripcion();
            dat[1]= ti.getPrecio()+"";
        this.modeloTabla.addRow(dat);
        }
        
    }
    private void jbtnAgregar_actionPerformed(ActionEvent e) {
    jdlgTiquetes p = new  jdlgTiquetes ('A');
    p.setModal(true);
    p.setLocationRelativeTo(null);
    p.setVisible(true);
    
    if(this.miTiquete!=null){
        try{
            Tiquete.agregarTipo(miTiquete); ;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Error al guardar el tiquete");
        }
        llenaTabla();
    }
    }
    private void jbtnSalir_actionPerformed(ActionEvent e) {
    this.dispose();
    }


    public static void setMiTiquete(Tiquete miTiquete) {
        MantenimientoTiquetes.miTiquete = miTiquete;
    }

    public static Tiquete getMiTiquete() {
        return miTiquete;
    }
}
