package Utitlities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SeleniumDatabaseTesting {
	// Connection object
	static Connection con = null;
	// Statement object
	private static Statement stmt;
	// Constant for Database URL
	public static String DB_URL = "jdbc:mysql://172.30.16.15:3306/lportal";
	//Database User name
	public static String DB_USER = "vil-uatnew";
	// Database Password
	public static String DB_PASSWORD = "wYjujZsSOVxXQ7OtxYFi4oikXqX2gc";

	@BeforeTest
	public void setUp() throws Exception {
		try{
			// Database connection
			String dbClass = "com.mysql.cj.jdbc.Driver";
			Class.forName(dbClass).newInstance();
			// Get connection to DB
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// Statement object to send the SQL statement to the Database
			stmt = con.createStatement();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//SELECT customerID ,status  from VIL_Customer WHERE msisdn = 9373737606 and status = 0;
	@Test
	public void test() {
		try{
			String query = "SELECT responseData  , callingTime  from VIL_ApiLogging where request LIKE '%2100012123456111111%' and url like '%/o/vil-headless-create-order/v1.0/createOrder%';";
			// Get the contents of userinfo table from DB
			ResultSet res = stmt.executeQuery(query);
			// Print the result untill all the records are printed
			// res.next() returns true if there is any next record else returns false
			//System.out.println(" " + res);
			while (res.next())
			{
				System.out.println(res.getString(1));
				System.out.println(" " + res.getString(2));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		// Close DB connection
		if (con != null) {
			con.close();
		}
	}
}
