/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlitelab;
import java.sql.*;

/**
 *
 * @author tcr5168
 */
public class SQLiteLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            //setting up database connection
            Class.forName("org.sqlite.JDBC");
            Connection dbConnection = DriverManager.getConnection("jdbc:sqlite:src/lib/sample.sqlite3", "app", "app"); //first app is username and second is password
            
            //test query
            Statement stmt = dbConnection.createStatement();
            String testQuery = "SELECT * FROM CUSTOMER";
            ResultSet results;
            
            results = stmt.executeQuery(testQuery);
            
            //processing results
            while(results.next()){
                System.out.println("Result: " + results.getString("NAME"));
                //System.out.println("This is working");
            }
            
            results.close();
            stmt.close();
            dbConnection.close();
        }
        catch(SQLException e){
            System.out.println("Cannot connect to database. \n" + e.getMessage());
        }
        catch(ClassNotFoundException e){
            System.out.println("Cannot create an instance of the database driver. \n" + e.getMessage());
        }
    }
    
}
