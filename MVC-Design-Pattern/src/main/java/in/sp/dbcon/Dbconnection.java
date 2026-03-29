package in.sp.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.tomcat.jakartaee.commons.lang3.ObjectUtils.Null;

public class Dbconnection 
{
	public static Connection getConnection() 
	{
		 Connection con=null;
		try 
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc_db","root","Root@0808");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
