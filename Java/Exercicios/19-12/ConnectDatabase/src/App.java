import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class App {
    static Connection connection = null;
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/livraria_2?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "pedro_henr1qq";

        Statement command = null;
        ResultSet result = null;

        connectToDB();
        consultar();
        insert("Pedro", "pedrinho123@gmail.com", 19);

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    static public void connectToDB(){
        String url = "jdbc:mysql://localhost:3306/livraria_2?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "pedro_henr1qq";

        try {
            connection = DriverManager.getConnection(url, user, password);

        }catch (SQLException e){
            System.out.println("DB connection failed!");
            e.printStackTrace();
        }

    }

    public static void consultar(){
        Statement command = null;
        ResultSet result = null;

        try {
            command = connection.createStatement();
            
            String query = "SELECT * from livros";

            result = command.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("id");
                String title = result.getString("titulo");

                System.out.println("ID: "+id + " | "+ title);
            }

        }catch (SQLException e){
            System.out.println("Conexão deu errado");
            e.printStackTrace();
        }finally{
            try {
                if(command != null){
                    command.close();
                }
                if(result != null){
                    result.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insert(String name, String email, int age){
        String query = "INSERT INTO clientes (nome, email, idade) VALUES (?, ?, ?)";

        PreparedStatement command = null;

        try {
            command = connection.prepareStatement(query);
            command.setString(1, name);
            command.setString(2, email);
            command.setString(3, Integer.toString(age));

            command.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(command != null){
                try {
                    command.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
}
