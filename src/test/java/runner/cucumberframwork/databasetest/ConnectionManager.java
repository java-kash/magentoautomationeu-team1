package runner.cucumberframwork.databasetest;

import com.unitedcoder.magentoautomationtest.utility.TestBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager{

    public Connection connectToDatabaseServer(){


        String  configFile="config-qa.properties";
        String dburl= TestBase.readFromConfigProperties(configFile,"dburl");
        String dbPort= TestBase.readFromConfigProperties(configFile,"dbPort");
        String defaultSchema= TestBase.readFromConfigProperties(configFile,"defaultSchema");
        String dbUserName= TestBase.readFromConfigProperties(configFile,"dbUserName");
        String dbPassword= TestBase.readFromConfigProperties(configFile,"dbPassword");

        Connection connection=null;
        String MYSql_Driver="com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(MYSql_Driver).newInstance();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String mySQLConnectionUrl = "jdbc:mysql://" + dburl + ":" + dbPort + "/" + defaultSchema + "?useSSL=false";
        try {
            connection = DriverManager.getConnection(mySQLConnectionUrl, dbUserName, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(!connection.isClosed()){
                System.out.println("Database connection is established ! ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }



    public void closeDatabaseConnection(Connection connection){

        try {
            if(connection.isClosed()){
                System.out.println("Connection has already been closed!!");
            }else{
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
