/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.MenuBienesRaices;
import Interfaz.VentanaMenuTrabajo;
import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jesus
 */
public class VentanaMenuTrabajoControlador {
    
public static void RellenaTablaEdificiosQL() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Rif="";
        String Nombre="";
        int foranea =1;
        VentanaMenuTrabajo.cont = 0;
        ResultSet Valores= st.executeQuery("select EDI.EDI_RIF, EDI.EDI_NOMBRE, LUG.LUG_NOMBRE\n" +
                                                                           "FROM EDIFICIO EDI, LUGAR LUG\n" +
                                                                           "WHERE LUG.LUG_CLAVE = EDI.EDI_FK_LUGAR");
            while (Valores.next()){
                    Rif=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    VentanaMenuTrabajo.ModeloEdificios.insertRow(VentanaMenuTrabajo.cont, new Object[]{});
                    VentanaMenuTrabajo.ModeloEdificios.setValueAt(Rif,VentanaMenuTrabajo.cont,0);
                    VentanaMenuTrabajo.ModeloEdificios.setValueAt(Nombre,VentanaMenuTrabajo.cont,1);
                    VentanaMenuTrabajo.ModeloEdificios.setValueAt(Valores.getString(3),VentanaMenuTrabajo.cont,2);
                    
                    VentanaMenuTrabajo.cont++;
            }
 
            
            
    };
    
public static void RellenaTablaProveedores() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Rif="";
        String Nombre="";
        int foranea =1;
        VentanaMenuTrabajo.cont = 0;
        ResultSet Valores= st.executeQuery("select * from PROVEEDORSERVICIO");
            while (Valores.next()){ 
                    Rif=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    VentanaMenuTrabajo.ModeloProveedor.insertRow(VentanaMenuTrabajo.cont, new Object[]{});
                    VentanaMenuTrabajo.ModeloProveedor.setValueAt(Rif,VentanaMenuTrabajo.cont,0);
                    VentanaMenuTrabajo.ModeloProveedor.setValueAt(Nombre,VentanaMenuTrabajo.cont,1);
                    VentanaMenuTrabajo.ModeloProveedor.setValueAt(Valores.getString(3),VentanaMenuTrabajo.cont,2);
                    
                    VentanaMenuTrabajo.cont++;
            }
 
            
            
    };
    
public static void RellenaTablaAreaComun(String rif) throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Rif="";
        String Nombre="";
        int foranea =1;
        VentanaMenuTrabajo.cont = 0;
        ResultSet Valores= st.executeQuery(" select AC.AC_NOMBRE, AD.AD_CLAVE , E.EDI_NOMBRE\n" +
                                                                            " FROM AREACOMUN AC, AREA_DET AD, EDIFICIO E\n" +
                                                                            " WHERE AC.AC_CLAVE = AD.AD_FK_AREACOMUN AND AD.AD_FK_EDIFICIO = E.EDI_CLAVE\n" +
                                                                            " AND E.EDI_RIF = '"+rif+"'");
            while (Valores.next()){ 
                    Rif=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    VentanaMenuTrabajo.ModeloAreaComun.insertRow(VentanaMenuTrabajo.cont, new Object[]{});
                    VentanaMenuTrabajo.ModeloAreaComun.setValueAt(Rif,VentanaMenuTrabajo.cont,1);
                    VentanaMenuTrabajo.ModeloAreaComun.setValueAt(Nombre,VentanaMenuTrabajo.cont,0);
                    VentanaMenuTrabajo.ModeloAreaComun.setValueAt(Valores.getString(3),VentanaMenuTrabajo.cont,2);
                    VentanaMenuTrabajo.cont++;
            }
    }

public static void InsertarTrabajoSQL(String fk_proveedor ,String f1, String f2) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          //DEBERIA INSERTAR EN EL LIBRO DE UNA VEZ!...
          PreparedStatement pst=  Con.prepareStatement(" insert into TRABAJO (TRA_CLAVE, TRA_DESCRIPCION, TRA_MONTO , TRA_CLASIFICACION , TRA_TIPO , TRA_SUSCEPTIBLE , TRA_FK_PROVEEDORSERVICIO,TRA_F_PROPUESTO , TRA_F_REALIZADO,TRA_REALIZADO) \n" +
                                                                                                      "VALUES ("
                  + "                                                                              SQ_PK_TRABAJO.NEXTVAL,"
                  + "                                                                              '"+VentanaMenuTrabajo.Descripcion+"',"
                  + "                                                                              "+VentanaMenuTrabajo.Monto+","
                  + "                                                                              '"+VentanaMenuTrabajo.Clasificacion+"',"
                  + "                                                                              '"+VentanaMenuTrabajo.tipo+"',"
                  + "                                                                              '"+VentanaMenuTrabajo.suceptible+"',"
                  + "                                                                              "+fk_proveedor+","
                  + "                                                                              TO_DATE('"+f1+"','YYYYMMDD'),"
                  + "                                                                              TO_DATE('"+f2+"','YYYYMMDD'),"
                  + "                                                                              'NO' )");
          pst.executeUpdate();    
}

}