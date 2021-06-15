package sample.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
    private String usuario="root";
    private String password="";
    private String bd="tienda";
    private String servidor="localhost";
    public Connection conexion;

    public Conexion(){
        try {
            conexion= DriverManager.getConnection("jdbc:mysql://"+servidor+":3306/"+bd+"?useUnicode=true&useJDBCCompliantTimeZoneShift=useLegacyDatetimeCode&serverTimeZone=UTC",usuario,password);
            System.out.println("Conectado correctamente");
        } catch (Exception e) {
            System.out.println("No se pudo conectar con el servidor "+ e.getMessage());
        }
    }//llave constructor


    public ResultSet Consulta(String consulta){
        ResultSet resultado=null;
        try {
            Statement st= conexion.createStatement();
            resultado=st.executeQuery(consulta);
        } catch (Exception e) {
            System.out.println("Error en la consulta "+e.getMessage());
        }
        return resultado;
    }

    public void insmodel(String consulta){
        try {
            Statement st=conexion.createStatement();
            st.executeUpdate(consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
