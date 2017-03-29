package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnection {
    private static Connection con=null;
    
        private DataConnection(){
    
}
        public static Connection getConnection(){
            try{
                if(con==null){
                    Class.forName("com.mysql.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_suite","root","admin");
                }return con;
            }catch(Exception ex){
                System.out.println(ex);
                return null;       
                }
        }
        public static void CloseConnection(){
            try{
                if(con!=null){
                    con.close();
                }
                con=null;
            }catch(Exception ex){
                
            }
        }
}
