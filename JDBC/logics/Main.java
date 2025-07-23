package WorkingOut.JDBC.logics;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner inputs = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/learn";
        String name = "root";
        String pass = "1269";
        Connection fc = DriverManager.getConnection(url, name, pass);
        String query = "select * from marks";
        Statement st = fc.createStatement();
        st.executeQuery(query);
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt(1));
            System.out.println("Name: " + rs.getString(2));
            System.out.println("Marks: " + rs.getInt(3));
        }
        fc.close();
        inputs.close();
        st.close();
    }
}