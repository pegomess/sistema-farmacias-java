/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Pedro
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() {
        try {
          return DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/sistema_vendas",
    "java",
    "123456"
);         } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
