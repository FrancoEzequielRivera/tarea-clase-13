package org.example;

import java.sql.*;
import java.util.ArrayList;

public class ConectorAMySQL {
    public void cargarClase() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    }

    public void consultarAlgo(){
        Statement stnt = null;
        ResultSet rs = null;
        try{
            cargarClase();
            //Connection conn = DriverManager.getConnection("jbdc:mysql://db4free.net/homeworkclass12", "franco_rivera", "miNuevaContrasenia");
            Connection conn = DriverManager.getConnection("jdbc:mysql://db4free.net/homeworkclass12", "franco_rivera", "miNuevaContrasenia");
            stnt = conn.createStatement();

            //Punto 3 A
            stnt.execute("INSERT INTO empleados (dni, nombre, apellido, nacionalidad, departamento) VALUES\n" +
                    "('55555555', 'Lucas', 'Test', 'argentino', 's1')");

            //Punto 3 B
            stnt.execute("UPDATE empleados SET nacionalidad = 'uruguayo' WHERE nombre = 'Lucas'");

            //Punto 3 C
            stnt.execute("DELETE FROM departamentos WHERE id = 'c1'");

            //Punto 3 D
            rs = stnt.executeQuery("SELECT * FROM empleados e WHERE departamento = 'l1'");

            while (rs.next()) {
                for (int x = 1; x <= rs.getMetaData().getColumnCount();x++)
                    System.out.print(rs.getString(x) + "\t");
                    System.out.println();
            }

            //Punto 3 E

            rs = stnt.executeQuery("SELECT * FROM departamentos d ORDER BY nombre ASC;");

            while (rs.next()) {
                for (int x = 1; x <= rs.getMetaData().getColumnCount();x++)
                    System.out.print(rs.getString(x) + "\t");
                    System.out.println();
            }



        } catch (Exception e){
            System.out.println("ERROR" + e.getMessage());
        }
        finally {
            if (rs != null){
                try {
                    rs.close();
                }catch (SQLException e) {}
            }
        }



    }





}
