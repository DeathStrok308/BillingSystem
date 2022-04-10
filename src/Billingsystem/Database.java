package Billingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    Connection Connect = null;
    Statement Statement = null;
    ResultSet Result = null;
    boolean ConnectionFlag = false;
    public Database(){
        try{
            Connect = DriverManager.getConnection("jdbc:mysql://159.89.169.20:3306/billingsys?useSSL=false","dbuser","5&Jq26Nimen@");
            Statement = Connect.createStatement();
        }
        catch(SQLException errors){
            errors.printStackTrace();
        }
    }               
        public void runQuery(String query){
            try{
                Statement.executeUpdate(query);                
            }catch(SQLException errors){
                errors.printStackTrace();
            }
        }
        public ResultSet getResult(String query){
            try{
                Result = Statement.executeQuery(query);
            }catch(SQLException errors){
                errors.printStackTrace();
            }
        return Result;
        }

    Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
