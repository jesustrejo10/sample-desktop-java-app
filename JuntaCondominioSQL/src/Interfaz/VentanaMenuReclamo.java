/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Controlador.VentanaMenuReclamoControlador ;
import Controlador.VentanaMenuJuntaCondominioControlador;
import Controlador.VentanaMenuPropietarioControlador;
import static Interfaz.MenuBienesRaices.ModeloApartamentosComprados;
import static Interfaz.MenuBienesRaices.Opcion;
import static Interfaz.VentanaMenuPropietario.ClaveMunicipio;
import static Interfaz.VentanaMenuPropietario.ClaveParroquia;
import static Interfaz.VentanaMenuPropietario.Opcion;
import Modelo.ConexionOracle;
import Modelo.Util;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Luis
 */
public class VentanaMenuReclamo extends javax.swing.JFrame {
    DateFormat df = DateFormat.getDateInstance();
 public static DefaultTableModel ModeloPropietarios = new DefaultTableModel();
 public static DefaultTableModel ModeloApartamentosComprados = new DefaultTableModel();
 public static int Opcion;
 public static int contAPT= 0;
 public static int cont= 0;
 public static String DESCRIPCION;
 public static String TITULO;
 public static int fase = 1;
public static String ClaveOficina; 
 public static String ForaneaApartamentoSeleccionado = null;
public static String TituloReclamoSeleccionado =null;
public static String DescripcionReclamoSeleccionado =null;
public static Date prueba;


   public VentanaMenuReclamo() {
        
        initComponents();
        PanelComprados.setVisible(false);
        jButton3.setVisible(false);
        PanelPropietarios.setVisible(false);
        PanelReclamo.setVisible(false); 
        jButton4.setVisible(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconbuil.png")).getImage() );
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/fondo.jpg"));
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        this.PanelPrincipal.add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());    
   }
     
      public void CargarInterfazApartamentosComprados(){
        String x[][]={};
        String columnas[]={"Edificio","Medidas","Alicuota","Piso","Codigo","Precio"};
        ModeloApartamentosComprados = new DefaultTableModel(x, columnas);
        TablaComprados.setModel(ModeloApartamentosComprados);
     }
          public void cargarInterfazPropietarios(){
        String x[][]={}; 
        String columnas[]={"Identificacion","Nombre","Apellido"};
        ModeloPropietarios = new DefaultTableModel(x, columnas);
        TablaPropietarios.setModel(ModeloPropietarios);
     }
       
          public void cargarInterfazReclamos(){
        String x[][]={}; 
        String columnas[]={"Identificacion","TITULO"};
        ModeloApartamentosComprados = new DefaultTableModel(x, columnas);
        TablaComprados.setModel(ModeloApartamentosComprados);
     }     
public static void LimpiarJTable(DefaultTableModel Nombremodelo){
          int a =Nombremodelo.getRowCount()-1;
          for(int i=a;i>=0;i--){ 
                    Nombremodelo.removeRow(i);
          }
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        PanelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        ComboOpcion = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        PanelReclamo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TXTDESCRIPCION = new javax.swing.JTextArea();
        TXTTITULO = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CampoFechaInicio = new com.toedter.calendar.JDateChooser();
        PanelPropietarios = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaPropietarios = new javax.swing.JTable();
        PanelComprados = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaComprados = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipal.setPreferredSize(new java.awt.Dimension(1300, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione la Operacion que desea Realizar"));

        ComboOpcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Crear Reclamo", "Mostrar Reclamo" }));
        ComboOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboOpcionActionPerformed(evt);
            }
        });

        jButton1.setText("Continuar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        PanelReclamo.setBackground(new java.awt.Color(255, 255, 255));
        PanelReclamo.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario de Reclamo"));

        TXTDESCRIPCION.setColumns(20);
        TXTDESCRIPCION.setRows(5);
        jScrollPane2.setViewportView(TXTDESCRIPCION);

        TXTTITULO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTTITULOActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha Reclamo");

        jLabel3.setText("Titulo Reclamo");

        javax.swing.GroupLayout PanelReclamoLayout = new javax.swing.GroupLayout(PanelReclamo);
        PanelReclamo.setLayout(PanelReclamoLayout);
        PanelReclamoLayout.setHorizontalGroup(
            PanelReclamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReclamoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelReclamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelReclamoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(PanelReclamoLayout.createSequentialGroup()
                        .addGroup(PanelReclamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addGroup(PanelReclamoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelReclamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXTTITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))))
        );
        PanelReclamoLayout.setVerticalGroup(
            PanelReclamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelReclamoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(PanelReclamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTTITULO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(PanelReclamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelPropietarios.setBackground(new java.awt.Color(255, 255, 255));
        PanelPropietarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla Propietarios"));

        TablaPropietarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaPropietarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPropietariosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablaPropietarios);

        javax.swing.GroupLayout PanelPropietariosLayout = new javax.swing.GroupLayout(PanelPropietarios);
        PanelPropietarios.setLayout(PanelPropietariosLayout);
        PanelPropietariosLayout.setHorizontalGroup(
            PanelPropietariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPropietariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelPropietariosLayout.setVerticalGroup(
            PanelPropietariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPropietariosLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        PanelComprados.setBackground(new java.awt.Color(255, 255, 255));
        PanelComprados.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla x"));

        TablaComprados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaComprados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCompradosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaComprados);

        javax.swing.GroupLayout PanelCompradosLayout = new javax.swing.GroupLayout(PanelComprados);
        PanelComprados.setLayout(PanelCompradosLayout);
        PanelCompradosLayout.setHorizontalGroup(
            PanelCompradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCompradosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelCompradosLayout.setVerticalGroup(
            PanelCompradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCompradosLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Finalizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Siguiente");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Menu Reclamo\n");

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4)
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(PanelPropietarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PanelComprados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(PanelReclamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PanelReclamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelComprados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelPropietarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 1088, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Opcion = ComboOpcion.getSelectedIndex();
        if (Opcion==0){
          jButton3.setVisible(true);   
          jButton4.setVisible(false);
          PanelComprados.setVisible(false);
          PanelPropietarios.setVisible(true);
          PanelReclamo.setVisible(false);
            cargarInterfazPropietarios();
            try {
                VentanaMenuReclamoControlador.RellenaTablaPropietariosSQL();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
            }
            }        // TODO add your handling code here:
         if (Opcion==1){
            
            jButton3.setVisible(false); 
             PanelComprados.setVisible(false);
             PanelPropietarios.setVisible(true);
             PanelReclamo.setVisible(false);
             jButton4.setVisible(false);
             cargarInterfazPropietarios();
              TXTTITULO.setText("");
             //  CampoFechaInicio.setText("");
               TXTDESCRIPCION.setText("");
             //CargarInterfazApartamentosComprados();
         try {
                VentanaMenuReclamoControlador.RellenaTablaPropietariosSQL();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
            }
      /*  try {
                VentanaMenuReclamoControlador.RellenaTablaReclamosSQL();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
            } 
    */
    }    
    }//GEN-LAST:event_jButton1ActionPerformed

        
    private void ComboOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboOpcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboOpcionActionPerformed

    private void TXTTITULOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTTITULOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTTITULOActionPerformed

    private void TablaPropietariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPropietariosMouseClicked
          if ((Opcion == 0) &&  ( TablaPropietarios.getSelectedRows().length > 0 )){
              PanelComprados.setVisible(true);
              PanelReclamo.setVisible(true);
                    //cargarInterfazPropietarios();
                    //                    PanelTablaPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Edifcicios con Apartamentos en Venta"));

                   CargarInterfazApartamentosComprados();
                    try{
                    int num2 = TablaPropietarios.getSelectedRow();
                    String ClavePropietario2 =((String)TablaPropietarios.getValueAt(num2,0));
                    VentanaMenuReclamoControlador.RellenaTablaApartamentosCompradosSQL(ClavePropietario2);
                    PanelComprados.setBorder(javax.swing.BorderFactory.createTitledBorder("Apartamentos Comprados"));
                    }catch(Exception e){
                              JOptionPane.showMessageDialog(PanelComprados,"error al asignar la columnaasdasdas"+e);
                    }
                    
                        

                    
          }      
            if ((Opcion == 1) &&  ( TablaPropietarios.getSelectedRows().length > 0 )){
                jButton4.setVisible(true);
                PanelComprados.setVisible(true);
                         CargarInterfazApartamentosComprados();
                    try{
                    int num2 = TablaPropietarios.getSelectedRow();
                    String ClavePropietario2 =((String)TablaPropietarios.getValueAt(num2,0));
                     PanelComprados.setBorder(javax.swing.BorderFactory.createTitledBorder("Apartamentos Comprados"));
                    VentanaMenuReclamoControlador.RellenaTablaApartamentosCompradosSQL(ClavePropietario2);
                    }catch(Exception e){
                              JOptionPane.showMessageDialog(PanelComprados,"error al asignar la columnaasdasdas"+e);
                    }
                  //  jLabel2.setVisible(true);
                    fase = 1;    

                    
          }     
                
                /*      //cargarInterfazPropietarios();
                    if (fase == 0){
                     CargarInterfazApartamentosComprados();
                    try{
                    int num2 = TablaPropietarios.getSelectedRow();
                    String ClavePropietario2 =((String)TablaPropietarios.getValueAt(num2,0));
                    VentanaMenuReclamoControlador.RellenaTablaApartamentosCompradosSQL(ClavePropietario2);
                    }catch(Exception e){
                              JOptionPane.showMessageDialog(PanelComprados,"error al asignar la columnaasdasdas"+e);
                    }
                    fase = 1;
                    }
                    if (fase == 1) {
                    //LimpiarJTable();
                    cargarInterfazReclamos();
                    try{
                    int num2 = TablaComprados.getSelectedRow();
                    String ClaveReclamo2 =((String)TablaComprados.getValueAt(num2,0));
                    VentanaMenuReclamoControlador.RellenaTablaReclamosSQL(ClaveReclamo2);
                    }catch(Exception e){
                              JOptionPane.showMessageDialog(PanelComprados,"error al asignar la columnaasdasdas"+e);
                    }
                    fase = 0;
                    }
                        
*/
                      // TODO add your handling code here:
          
    }//GEN-LAST:event_TablaPropietariosMouseClicked
   public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) { //CONVIERTE UTIL.DATE A SQL.DATE
        return new java.sql.Date(date.getTime()); 
   }

    public  String ConvierteFechas(String FechaInicio){
          try{
                                        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy"); 
                                        java.util.Date fecha=sdf.parse(FechaInicio); 
                                        java.sql.Date FechaNegociacion = convertJavaDateToSqlDate(fecha); //CONVERSIONES A TIPO SQL.DATE
                                        String intento;
                                        intento = (String) FechaNegociacion.toString();
                                        String[] intento2 =intento.split("-");
                                        String intento3 = intento2[0]+intento2[1]+intento2[2];
                                        return (intento3);
          }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error al convertir la fecha."+e.getMessage());
          }                        
        return null;
    
        
       //insert into RECLAMO VALUES (SQ_PK_RECLAMO.NEXTVAL,'"+VARIABLE+"',TO_DATE('20150525','YYYYMMDD'),2,1,'TITULO');
        
    };
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
         if (Opcion == 0){
            String TITULO = TXTTITULO.getText();
            String DESCRIPCION = TXTDESCRIPCION.getText();
            String FechaInicio = df.format(CampoFechaInicio.getDate());
            String FechaInicioString = ConvierteFechas(FechaInicio);
             System.out.println(FechaInicio);
             System.out.println(FechaInicioString);
            // int ColumnaSeleccionadaTablaPropietario = TablaPropietarios.getSelectedRow();
            //String ClavePropietarioSeleccionado = (String)TablaPropietarios.getValueAt(ColumnaSeleccionadaTablaPropietario,0);
            int ColumnaSeleccionadaTablaComprados = TablaComprados.getSelectedRow();
            String ClaveApartamentoSeleccionado = Integer.toString((Integer)TablaComprados.getValueAt(ColumnaSeleccionadaTablaComprados,4));
           // JOptionPane.showMessageDialog(PanelComprados,"Titulo->"+TITULO);
            //JOptionPane.showMessageDialog(PanelComprados,"Descripcion->"+DESCRIPCION);
            //JOptionPane.showMessageDialog(PanelComprados,"FECHA->"+FechaInicioString);
            //JOptionPane.showMessageDialog(PanelComprados,"Clave Prop->"+ClaveApartamentoSeleccionado);
            VentanaMenuReclamoControlador.CalculaClaveOficina(ClaveApartamentoSeleccionado);
            
                VentanaMenuReclamoControlador.InsertarReclamoSQL(TITULO,DESCRIPCION,FechaInicioString,ClaveApartamentoSeleccionado);
        }
                          JOptionPane.showMessageDialog(rootPane,"Reclamo Agregado Correctamente");
        
        if (Opcion == 1){
        jButton3.setVisible(false);
        
        }
        
        
        
        }
          catch (SQLException e) {
                 Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, e);
        }
                          
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TablaCompradosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCompradosMouseClicked
                 if ((Opcion == 1) && (fase == 2)){
                  PanelReclamo.setVisible(true);
                  jButton4.setVisible(false);
                   PanelComprados.setBorder(javax.swing.BorderFactory.createTitledBorder("Reclamos"));
            //cargarInterfazReclamos ();
           int ColumnaSeleccionadaTablaComprados = TablaComprados.getSelectedRow();
          
                    String ClaveReclamoSeleccionado = (String)TablaComprados.getValueAt(ColumnaSeleccionadaTablaComprados,0); 
                    String TITULO=(String)TablaComprados.getValueAt(ColumnaSeleccionadaTablaComprados,1);
                  // String DECSRIPCION=(String)TablaComprados.getValueAt(ColumnaSeleccionadaTablaComprados,0);
                  //  String FechaInicio=(String)TablaComprados.getValueAt(ColumnaSeleccionadaTablaComprados,);
                    this.TXTTITULO.setText(TITULO);
                    this.CampoFechaInicio.setDate(prueba);
// this.TXTDESCRIPCION.setText(DESCRIPCION);
                     try {
                              VentanaMenuReclamoControlador.RellenaCamposFaltantes(ClaveReclamoSeleccionado);
                    }catch (SQLException ex) {
                              JOptionPane.showMessageDialog(rootPane,"Error al ejecutar la consulta 'rellena campos faltantes' ->"+ex);
                              Logger.getLogger(VentanaMenuReclamo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       this.TXTDESCRIPCION.setText(DESCRIPCION);
                       //this.CampoFechaInicio.setText(FechaInicio);
                    //fase= 1;
                   // jLabel2.setVisible(false);
       }  
    }//GEN-LAST:event_TablaCompradosMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (((Opcion == 1)) && (fase ==1)) {
            jButton4.setVisible(true);
            PanelReclamo.setVisible(true);
            
           
            try{
                int num2 = TablaComprados.getSelectedRow();
                String ClaveAPT2 = Integer.toString((Integer)TablaComprados.getValueAt(num2,4));
                 PanelComprados.setBorder(javax.swing.BorderFactory.createTitledBorder("Reclamos"));

                 //System.out.print(ClaveAPT2);
                //LimpiarJTable(ModeloApartamentosComprados);
                 cargarInterfazReclamos(); 
                 fase = 2;
                 //jLabel2.setVisible(false);
                VentanaMenuReclamoControlador.RellenaTablaReclamosSQL(ClaveAPT2);          
            }catch(Exception e){
                JOptionPane.showMessageDialog(PanelComprados,"error al asignar la columnaasdasdas"+e);
            }
                    

        }
        

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  JOptionPane.showMessageDialog(rootPane,"Todos los cambios no guardados han sido borrados.");
        try {
            VentanaMenuPrincipal cambio = new VentanaMenuPrincipal();
            cambio.setVisible(true);
           
        } catch (SQLException ex) {
                        //Logger.getLogger(VentanaMenuReclamo.class.getName()).log(Level.SEVERE, null, ex);
                     JOptionPane.showMessageDialog(PanelComprados,"Error, debe ingresar desde el LogIg para cargar Permisos"+ex.getMessage());
                     VentanaLogIn nueva = new VentanaLogIn();
                     nueva.setVisible(true);
        }
        this.dispose();       // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
 
      public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuReclamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuReclamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuReclamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuReclamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMenuReclamo().setVisible(true);
            }
        });
   
     }
  
       
        
          

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser CampoFechaInicio;
    private javax.swing.JComboBox ComboOpcion;
    private javax.swing.JPanel PanelComprados;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelPropietarios;
    private javax.swing.JPanel PanelReclamo;
    private javax.swing.JTextArea TXTDESCRIPCION;
    private javax.swing.JTextField TXTTITULO;
    private javax.swing.JTable TablaComprados;
    private javax.swing.JTable TablaPropietarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
