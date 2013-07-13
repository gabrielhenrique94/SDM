package ProcessosBD;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao{
    private String connectionString;
    private String driverName = "com.mysql.jdbc.Driver"; 
    private String database;
    private String user;
    private String password;
    private String host;
    private Connection connection = null;
     
    public Conexao( String host, String database, String user, String password ) {
 
        this.host = host; 
        this.database = database; 
        this.user = user; 
        this.password = password; 
        
        connectionString = "jdbc:mysql://" + this.host + ":3306/" + this.database;        
    } 
   
    public Connection connect(){
        
    	try {   
    		Class.forName(this.driverName);   
                
            this.connection = DriverManager.getConnection( connectionString, this.user, this.password );        
            return this.connection;            
        }
        catch (ClassNotFoundException ex){
           ex.printStackTrace();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }        
	return connection;		
    }
    
    public void close() throws SQLException{
        
    	try {
            connection.close();
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }        
    }    
}