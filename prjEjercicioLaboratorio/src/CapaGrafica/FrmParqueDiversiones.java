package CapaGrafica;

import CapaDatos.CompraBD;
import CapaDatos.TiqueteBD;

import CapaLogica.Anual;
import CapaLogica.Compra;

import CapaLogica.Entrada;

import CapaLogica.Especial;

import CapaLogica.Regular;

import CapaLogica.Tiquete;

import java.awt.Dimension;

import javax.swing.JFrame;


import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;


public class FrmParqueDiversiones extends JFrame {
    private JButton jBtnLimpiar = new JButton();
    private JButton jBtnSalir = new JButton();
    private JLabel jLblTiquets = new JLabel();
    private JComboBox jCmbTiquetes = new JComboBox();
    private JCheckBox jChkCodPromo = new JCheckBox();
    private JButton jBtnAgregar = new JButton();
    private JLabel jLabel5 = new JLabel();
    private JTextField jTxtGranTotal = new JTextField();
    private JSeparator jSeparator2 = new JSeparator();
    private JLabel jLabel6 = new JLabel();
    private JTextField jTxtNumCompra = new JTextField();
    private JList jList1 = new JList();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JList jLstTiquetes = new JList();
    private JLabel jLlbListado = new JLabel();
    private JButton jBtnAgregarTiq = new JButton();
    private JRadioButton jRdbEspecial = new JRadioButton();
    private JRadioButton jRdbRegular = new JRadioButton();
    private JButton jBtnLimpiarEntrada = new JButton();
    private JButton jBtnGuardar = new JButton();
    private JSeparator jSeparator1 = new JSeparator();
    private JSeparator jSeparator3 = new JSeparator();
    private JTextField jTxtFecha = new JTextField();
    private JLabel jLabel8 = new JLabel();
    private JRadioButton jRdbAnual = new JRadioButton();
    private JTextField jTxtCodAnual = new JTextField();
    private JLabel jLblCodigo = new JLabel();
    private DefaultTableModel modeloTabla; //Declara un modelo para la tabla
    // Para manejar el grupo de Radio Button
    private ButtonGroup grupoBotones = new ButtonGroup();
    private DefaultListModel modeloListaTiquetes = new DefaultListModel();
    private JButton jBtnComprobante = new JButton();
    

    private Compra miCompra;
    private Entrada mientrada;
    private ArrayList arrayTiquete = new ArrayList();
    private JTable jTblEntradas = new JTable();

    public FrmParqueDiversiones() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        this.setSize(new Dimension(831, 487));
        this.setTitle("La Tierra de Nunca Jamas- Parque de Diversiones");
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                    this_windowOpened(e);
                }
        });
        jBtnLimpiar.setText("Nueva Compra");
        jBtnLimpiar.setBounds(new Rectangle(540, 415, 135, 30));
        jBtnLimpiar.setFont(new Font("Dialog", 1, 12));
        jBtnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBtnLimpiar_actionPerformed(e);
            }
        });
        jBtnSalir.setText("Salir");
        jBtnSalir.setBounds(new Rectangle(680, 415, 135, 30));
        jBtnSalir.setFont(new Font("Dialog", 1, 12));
        jBtnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBtnSalir_actionPerformed(e);
            }
        });
        jLblTiquets.setText("Tiquetes");
        jLblTiquets.setBounds(new Rectangle(10, 220, 90, 15));
        jLblTiquets.setFont(new Font("Dialog", 1, 11));
        jCmbTiquetes.setBounds(new Rectangle(10, 240, 125, 25));
      
        jChkCodPromo.setText("Codigo Promocional");
        jChkCodPromo.setBounds(new Rectangle(120, 130, 145, 20));
        jChkCodPromo.setFont(new Font("Dialog", 1, 11));
        jBtnAgregar.setText("Incluir Entrada");
        jBtnAgregar.setBounds(new Rectangle(120, 60, 130, 30));
        jBtnAgregar.setFont(new Font("Dialog", 1, 12));
        jBtnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBtnAgregar_actionPerformed(e);
            }
        });
        jLabel5.setText("Total Pagar");
        jLabel5.setBounds(new Rectangle(625, 255, 65, 15));
        jLabel5.setFont(new Font("Dialog", 1, 11));
        jTxtGranTotal.setBounds(new Rectangle(700, 250, 110, 20));
        jTxtGranTotal.setFont(new Font("Dialog", 1, 15));
        jTxtGranTotal.setHorizontalAlignment(JTextField.RIGHT);
        jSeparator2.setBounds(new Rectangle(5, 40, 830, 15));
        jLabel6.setText("Compra #");
        jLabel6.setBounds(new Rectangle(20, 20, 65, 15));
        jLabel6.setFont(new Font("Dialog", 1, 11));
        jTxtNumCompra.setBounds(new Rectangle(95, 15, 55, 20));
        jList1.setBounds(new Rectangle(475, 150, 0, 0));
        this.getContentPane().add(jBtnComprobante, null);
        this.getContentPane().add(jLblCodigo, null);
        this.getContentPane().add(jTxtCodAnual, null);
        this.getContentPane().add(jRdbAnual, null);
        this.getContentPane().add(jLabel8, null);
        this.getContentPane().add(jTxtFecha, null);
        this.getContentPane().add(jSeparator3, null);
        this.getContentPane().add(jSeparator1, null);
        this.getContentPane().add(jBtnGuardar, null);
        this.getContentPane().add(jBtnLimpiarEntrada, null);
        this.getContentPane().add(jRdbRegular, null);
        this.getContentPane().add(jRdbEspecial, null);
        this.getContentPane().add(jBtnAgregarTiq, null);
        this.getContentPane().add(jLlbListado, null);
        jScrollPane2.getViewport().add(jTblEntradas, null);
        this.getContentPane().add(jScrollPane2, null);
        jScrollPane1.getViewport().add(jLstTiquetes, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jList1, null);
        this.getContentPane().add(jTxtNumCompra, null);
        this.getContentPane().add(jLabel6, null);
        this.getContentPane().add(jSeparator2, null);
        this.getContentPane().add(jTxtGranTotal, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jBtnAgregar, null);
        this.getContentPane().add(jChkCodPromo, null);
        this.getContentPane().add(jCmbTiquetes, null);
        this.getContentPane().add(jLblTiquets, null);
        this.getContentPane().add(jBtnSalir, null);
        this.getContentPane().add(jBtnLimpiar, null);
        jScrollPane1.setBounds(new Rectangle(10, 290, 190, 100));
        jScrollPane2.setBounds(new Rectangle(310, 60, 500, 180));
        jLlbListado.setText("ListadoTiquetes");
        jLlbListado.setBounds(new Rectangle(10, 270, 140, 15));
        jLlbListado.setFont(new Font("Dialog", 1, 12));
        jBtnAgregarTiq.setText("Agregar Tiquete");
        jBtnAgregarTiq.setBounds(new Rectangle(135, 240, 140, 25));
        jBtnAgregarTiq.setFont(new Font("Dialog", 1, 12));
        jBtnAgregarTiq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBtnAgregarTiq_actionPerformed(e);
            }
        });
        jRdbEspecial.setText("Especial");
        jRdbEspecial.setBounds(new Rectangle(5, 65, 84, 19));
        jRdbEspecial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jRdbEspecial_actionPerformed(e);
            }
        });
        jRdbRegular.setText("Regular");
        jRdbRegular.setBounds(new Rectangle(5, 95, 84, 19));
        jRdbRegular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jRdbRegular_actionPerformed(e);
            }
        });
        jBtnLimpiarEntrada.setText("Nueva Entrada");
        jBtnLimpiarEntrada.setBounds(new Rectangle(120, 95, 130, 30));
        jBtnLimpiarEntrada.setFont(new Font("Dialog", 1, 12));
        jBtnLimpiarEntrada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //jBtnLimpiarTour_actionPerformed(e);
                    jBtnLimpiarEntrada_actionPerformed(e);
                }
        });
        jBtnGuardar.setText("Guardar Compra");
        jBtnGuardar.setBounds(new Rectangle(260, 415, 135, 30));
        jBtnGuardar.setFont(new Font("Tahoma", 1, 11));
        jBtnGuardar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBtnGuardar_actionPerformed(e);
                }
            });
        jSeparator1.setBounds(new Rectangle(-920, 0, 920, 15));
        jSeparator3.setBounds(new Rectangle(0, 400, 845, 5));
        jTxtFecha.setBounds(new Rectangle(625, 10, 165, 25));
        jLabel8.setText("Fecha: ");
        jLabel8.setBounds(new Rectangle(545, 20, 65, 15));
        jLabel8.setFont(new Font("Dialog", 1, 11));
        jRdbAnual.setText("Anual");
        jRdbAnual.setBounds(new Rectangle(5, 125, 84, 19));
        jRdbAnual.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jRdbAnual_actionPerformed(e);
                }
            });
        jTxtCodAnual.setBounds(new Rectangle(120, 175, 105, 25));
        jLblCodigo.setText("Codigo:");
        jLblCodigo.setBounds(new Rectangle(10, 175, 85, 25));
        jBtnComprobante.setText("Comprobante");
        jBtnComprobante.setBounds(new Rectangle(400, 415, 135, 30));
        jBtnComprobante.setFont(new Font("Dialog", 1, 12));
        jBtnComprobante.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBtnComprobante_actionPerformed(e);
                }
            });

    }

    private void asignaModeloTabla() {
        String[] arregloTitulos = { "Tipo Entrada", "Codigo Promo", "Costo Tiquetes", "Precio Entrada" };
        //Construir y asignar el modelo a la tabla
        //Construye el modelo con los encabezados del arregloTítulos con cero filas
        modeloTabla = new DefaultTableModel(arregloTitulos, 0);
        jTblEntradas.setModel(modeloTabla);
        
        
        this.jLstTiquetes.setModel(modeloListaTiquetes);
    }
    private void llenaTiquete(){
        llenarCmbTiquetes();
        
        for (int i =0 ; i<this.arrayTiquete.size(); i++){
            this.jCmbTiquetes.addItem(arrayTiquete.get(i) );
        }

    }
    private void llenarCmbTiquetes() {
 
  ArrayList<Tiquete> lista = null;
  try{
      lista = Tiquete.listaTipo();
  }catch(Exception ex){
      
  }
  for(int i = 0; i<lista.size(); i++){
      Tiquete mie = lista.get(i);
      arrayTiquete.add(mie);
  }
  }

    private void jRdbEspecial_actionPerformed(ActionEvent e) {
   this.jLblTiquets.setVisible(false);
   this.jLlbListado.setVisible(false);
   this.jCmbTiquetes.setVisible(false);
   this.jLstTiquetes.setVisible(false);
   this.jScrollPane1.setVisible(false);
   this.jBtnAgregarTiq.setVisible(false);
   
   this.jLblCodigo.setVisible(false);
   this.jTxtCodAnual.setVisible(false);
   this.jChkCodPromo.requestFocus(true);
   this.jChkCodPromo.setEnabled(true);
   
   }
    private void jBtnAgregar_actionPerformed(ActionEvent e) {
     boolean promo = false;
     promo  = this.jChkCodPromo.isSelected();
        if(this.jRdbAnual.isSelected()== true)    
            mientrada = new Anual("Anual",promo,this.jTxtCodAnual.getText());  
                else{
                    if(this.jRdbEspecial.isSelected()== true)
                    mientrada = new Especial("Especial", promo );
                else{
            mientrada = new Regular("Regular",promo );
                }  
            }
      
      this.miCompra.agregarEntrada(this.mientrada); 
        String dat[]= new String[4];
        dat[0]= (mientrada instanceof Regular) ? "Regular " : (mientrada instanceof Especial)?" Especial":"Anual";
        dat[1]= this.jTxtCodAnual.getText();
        dat[2]= mientrada.calculaTotalTiquete()+"";
        dat[3]= mientrada.calculaTotalEntrada()+"";
        this.modeloTabla.addRow(dat);
        miCompra.agregarEntrada(mientrada); 
        this.jTxtGranTotal.setText(""+mientrada.calculaTotalEntrada());
        // Deshabilita botón de agregar helado a la orden
        this.jBtnAgregar.setEnabled(false);
        this.jBtnLimpiar.setEnabled(true);
    }


    private void jBtnLimpiar_actionPerformed(ActionEvent e) {
        // limpiar cajas de texto
        
        iniciarCompra();
        this.jTxtNumCompra.setText(""+miCompra.getNumeroCompra());
        this.jTxtGranTotal.setText("");
        this.jChkCodPromo.setSelected(false);
        this.jTxtCodAnual.setText("");
        //Habilita los objetos para formar un helado
        this.jCmbTiquetes.setEnabled(true);
        this.jChkCodPromo.setEnabled(true);
        //limpia los combos
        this.jCmbTiquetes.setSelectedIndex(-1);
        this.jBtnAgregar.setEnabled(true);

        this.modeloListaTiquetes.clear();
        this.modeloTabla.setNumRows(0); //Limpia la tabla
        grupoBotones.clearSelection();
        this.jLblTiquets.setVisible(false);
        this.jLlbListado.setVisible(false);
        this.jCmbTiquetes.setVisible(false);
        this.jLstTiquetes.setVisible(false);
        this.jScrollPane1.setVisible(false);
        this.jBtnAgregarTiq.setVisible(false);
        llenarCmbTiquetes();
        
    }

    private void jBtnLimpiarEntrada_actionPerformed(ActionEvent e) {
    grupoBotones.clearSelection();
    this.jTxtCodAnual.setText("");
    this.jBtnAgregar.setEnabled(true);
    this.modeloListaTiquetes.removeAllElements();
    this.jTxtCodAnual.setText("");
    }

    private void jBtnSalir_actionPerformed(ActionEvent e) {
        this.dispose();
    }
    public void iniciarCompra(){
        miCompra=new Compra();
    }

    private void this_windowOpened(WindowEvent e) {
        //FALTA
        asignaModeloTabla();
        llenaTiquete();
        iniciarCompra();
        SimpleDateFormat formato=new SimpleDateFormat("dd/MMMM/yy");
        this.jTxtNumCompra.setText(""+miCompra.getNumeroCompra());
        this.jTxtFecha.setText(formato.format(miCompra.getFecha()));
        this.jTxtFecha.setEditable(false);
        this.jTxtNumCompra.setEditable(false);
        this.jTxtGranTotal.setEditable(false);
        this.jBtnLimpiar.setEnabled(false);
        
        
        this.jLblTiquets.setVisible(false);
        this.jLlbListado.setVisible(false);
        this.jCmbTiquetes.setVisible(false);
        this.jLstTiquetes.setVisible(false);
        this.jScrollPane1.setVisible(false);
        this.jBtnAgregarTiq.setVisible(false);
        
        grupoBotones.add(this.jRdbAnual);
        grupoBotones.add(this.jRdbRegular);
        grupoBotones.add(this.jRdbEspecial);
        //Llama al método que inicia la orden y muestra en ventana el número
        this.jChkCodPromo.setSelected(false);
        this.jRdbEspecial.requestFocus();
    }

    private void jBtnAgregarTiq_actionPerformed(ActionEvent e) {
        this.modeloListaTiquetes.addElement(this.jCmbTiquetes.getSelectedItem());  
         }

    private void jRdbRegular_actionPerformed(ActionEvent e) {
        //FALTA
        this.jLblTiquets.setVisible(true);
        this.jLlbListado.setVisible(true);
        this.jCmbTiquetes.setVisible(true);
        this.jLstTiquetes.setVisible(true);
        this.jScrollPane1.setVisible(true);
        this.jBtnAgregarTiq.setVisible(true);
        
        this.jLblCodigo.setVisible(false);
        this.jTxtCodAnual.setVisible(false);
        this.jChkCodPromo.setSelected(true);
    }

    private void jRdbAnual_actionPerformed(ActionEvent e) {
        this.jLblTiquets.setVisible(false);
        this.jLlbListado.setVisible(false);
        this.jCmbTiquetes.setVisible(false);
        this.jLstTiquetes.setVisible(false);
        this.jScrollPane1.setVisible(false);
        this.jBtnAgregarTiq.setVisible(false);
        
        this.jLblCodigo.setVisible(true);
        this.jTxtCodAnual.setVisible(true);
        JOptionPane.showMessageDialog(null, "Digite su codigo de usuario");
        this.jTxtCodAnual.requestFocus(true);
        this.jChkCodPromo.setEnabled(false);
        this.jChkCodPromo.setSelected(false);
    }

    private void jBtnComprobante_actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, miCompra.toString());
    }
   
    public void Agregarcompra(){
     jdlgCompra p = new jdlgCompra('A', miCompra);
     p.setModal(true);
     p.setVisible(true);
     p.setLocationRelativeTo(null);
     
        if(miCompra!=null)
            try{
        miCompra.agregarEntrada(mientrada);
             }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Error al grabar la orden"+ "\n"+ ex.toString()+ "\n"+ex.getMessage());
            }
        
        }
    private void jBtnGuardar_actionPerformed(ActionEvent e) {
        jdlgCompra p = new jdlgCompra();
        p.setModal(true);
        p.setLocationRelativeTo(null);
        p.setVisible(true);
    //falta
    }

    
}
