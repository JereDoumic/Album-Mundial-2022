package Clases;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class Db_cuentas {

    public void Db_status(){
        try
        {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db_cuentas","root","");

            System.out.println("Connected");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void Db_cargaCuenta(Cuenta c){
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/db_cuentas","root","");
            PreparedStatement pst = cn.prepareStatement("insert into cuentas values (?,?,?,?,?,?)");

            pst.setString(1,c.getNombre().trim());
            pst.setString(2,c.getApellido().trim());
            pst.setString(3,c.getDni().trim());
            pst.setString(4,c.getEmail().trim());
            pst.setString(5,c.getUsuario().trim());
            pst.setString(6,c.getPassword().trim());

            pst.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void Db_eliminarCuenta(String nombreUsuari){
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/db_cuentas","root","");
            PreparedStatement pst = cn.prepareStatement("DELETE FROM `cuentas` WHERE `usuarioC` = '" + nombreUsuari + "'");

            pst.executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
