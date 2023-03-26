package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    //Nome do usuário no banco
    private static final String USERNAME = "root";
    //Senha do usuário para acesso
    private static final String PASSWORD = "";
    //Caminho do banco, porta e nome do database
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
    
    //Conexão com o banco
    public static Connection crateConnectionToMySQL() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        
        return connection;   
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        //Para recuperar a conexão com o banco:
        Connection con = crateConnectionToMySQL();
        
        if(con!= null){
            System.out.println("Conexão criada com sucesso!");
            con.close();
        }
        
    }
    
}
