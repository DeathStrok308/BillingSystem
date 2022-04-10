package Billingsystem;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    static Connection Connect = null;
    static Statement Statement = null;
    static ResultSet Result = null;
    boolean ConnectionFlag = false;
    static String[] x = new String[3];
    
    
    Database()
    {
        try{
            File f = new File("credentials.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String[] l = new String[3];
            for(int i =0;i<3;i++)
                l[i] = br.readLine();
            
            for(String s:l)
                System.out.println(s);
            Connect = DriverManager.getConnection("jdbc:mysql://"+l[0]+":3306/billingsys",l[1],l[2]);//?useSSL=false
            Statement = Connect.createStatement();
        }catch(SQLException errors){
            errors.printStackTrace();
        }
        catch(IOException r){
            r.printStackTrace();
        }
            
    }
                       
    public static void runQuery(String query){
        try{
            Statement.executeUpdate(query);                
        }catch(SQLException errors){
            errors.printStackTrace();
        }
    }
    public static ResultSet getResult(String query){
        try{
            Result = Statement.executeQuery(query);
        }catch(SQLException errors){
            errors.printStackTrace();
        }
        return Result;
    }
        
    public static void main(String[] args)
    {
        Database data = new Database();
        
    }
}
