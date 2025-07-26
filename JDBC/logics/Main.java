package WorkingOut.JDBC.logics;

import java.sql.*;
import java.util.*;

public class Main {
    Scanner inputs = new Scanner(System.in);
    public final String url = "jdbc:mysql://localhost:3306/learn";
    public final String name = "root";
    public final String pass = "1269";

    public static void main(String[] args) throws SQLException {
        Main ob = new Main();
        System.out.println("Before insertion");
        ob.readTable();
        System.out.println();
        ob.insertTable();
        System.out.println("After insertion");
        ob.readTable();
        System.out.println("\nNow Insert using PST");
        ob.insertUsingPreparedStatement();
        System.out.println("After insertion using PST");
        ob.readTable();
        System.out.println("Deletion");
        ob.deleteFromTable();
        System.out.println("After Deletion(s)");
        ob.readTable();
    }

    public void readTable() throws SQLException {
        Connection fc = DriverManager.getConnection(url, name, pass);
        String query = "select * from test";
        Statement st = fc.createStatement();
        st.executeQuery(query);
        ResultSet rs = st.getResultSet(); //getResultSet() returns the ResultSet object for the executed query
        while (rs.next()) {
            System.out.println("\nID : " + rs.getInt(1));
            System.out.println("Student Name : " + rs.getString(2));
            System.out.println("GPA : " + rs.getFloat(3));
        }

        fc.close();
        st.close();
    }

    public void insertTable() throws SQLException {
        Connection fc = DriverManager.getConnection(url, name, pass);
        System.out.print("\nEnter ID: ");
        int id = inputs.nextInt();
        inputs.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String nameInput = inputs.nextLine();
        System.out.print("Enter Marks: ");
        double marks = inputs.nextDouble();
        inputs.nextLine(); // Consume newline
        String query = "insert into test values(" + id + ", '" + nameInput + "', " + marks + ");";
        Statement st = fc.createStatement();
        int affectedRows = st.executeUpdate(query); // executeUpdate() returns the number of rows affected by the query
        System.out.println("\nPassed Query : " + query);
        System.out.println("Number of rows affected : " + affectedRows + "\n");
        fc.close();
        st.close();
    }

    public void insertUsingPreparedStatement() throws SQLException {
        Connection fc = DriverManager.getConnection(url, name, pass);
        System.out.print("\nEnter ID: ");
        int Id = inputs.nextInt();
        inputs.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String NameInput = inputs.nextLine();
        System.out.print("Enter Marks: ");
        double Marks = inputs.nextDouble();
        inputs.nextLine(); // Consume newline
        String query = "insert into test values(?,?,?);";
        PreparedStatement pst = fc.prepareStatement(query);
        pst.setInt(1, Id);
        pst.setString(2, NameInput);
        pst.setDouble(3, Marks);
        int affectedRows = pst.executeUpdate(); // executeUpdate() returns the number of rows affected by the query
        System.out.println("\nPassed Query : " + pst.toString());
        System.out.println("Number of rows affected : " + affectedRows + "\n");
        fc.close();
        pst.close();
    }

    public void deleteFromTable() throws SQLException {
        Connection fc = DriverManager.getConnection(url, name, pass);
        System.out.print("\nEnter ID to delete: ");
        int id = inputs.nextInt();
        inputs.nextLine(); // Consume newline
        String query = "delete from test where id = ?;";
        PreparedStatement pst = fc.prepareStatement(query);
        pst.setInt(1, id);
        int affectedRows = pst.executeUpdate(); // executeUpdate() returns the number of rows affected by the query
        System.out.println("\nPassed Query : " + pst.toString());
        System.out.println("Number of rows affected : " + affectedRows + "\n");
        fc.close();
    }
}