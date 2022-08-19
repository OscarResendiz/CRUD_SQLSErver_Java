package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
	public static Connection getConexion() throws SQLException, ClassNotFoundException
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=escuela;TrustServerCertificate=true;","oscar","Resendiz123");
			return con;
		}
		catch(SQLException ex)
		{
			System.out.print(ex.getMessage());
			throw ex;
			//return null;
		}
	}

}
