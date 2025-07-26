package WorkingOut.JDBC.logics;

import java.sql.*;
import java.util.*;

public class Main {
    Scanner inputs = new Scanner(System.in);
    public final String url = "jdbc:mysql://localhost:3306/learn";
    public final String name = "root";
    public final String pass = "1269";

    public static void main(String[] args) throws SQLException {
        Main start = new Main();
        System.out.println("Student's Test Database");
        start.choice();
    }

    public void choice() throws SQLException {
        Main ob = new Main();
        System.out.println("\n1. Read Table");
        System.out.println("2. Insert into Table");
        System.out.println("3. Insert using PreparedStatement");
        System.out.println("4. Delete from Table");
        System.out.println("5. Update Table");
        System.out.println("6. Exit");
        int ch = 0;
        try {
            System.out.print("Enter the number corresponding to your choice : ");
            ch = inputs.nextInt();
            inputs.nextLine();
        }

        catch (InputMismatchException e) {
            inputs.nextLine(); // Clear the invalid input
            ob.inputMismatch();
            ob.choice(); // Recursive call to allow user to try again
        }

        switch(ch) {
            case 1:
                System.out.println("\nRead\n");
                ob.readTable();
                break;
            case 2:
                System.out.println("\nInsertion\n");
                ob.insertIntoTable();
                break;
            case 3:
                System.out.println("\nInsertion (Using Prepared Statement Class)\n");
                ob.insertUsingPreparedStatement();
                break;
            case 4:
                System.out.println("\nDeletion\n");
                ob.deleteFromTable();
                break;
            case 5:
                System.out.println("\nUdpate\n");
                ob.updateTable();
                break;
            case 6:
                System.out.println("\nExit");
                System.exit(0);
            default:
                ob.inputMismatch();
                ob.choice(); // Recursive call to allow user to try again
                break;
        }
    }

    public void inputMismatch() {
        System.out.println("\nInvalid choice. Enter a valid NUMBER corresponding to your choice\n");
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

        this.choice();
    }

    public void insertIntoTable() throws SQLException {
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

        this.choice();
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

        this.choice();
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

        this.choice();
    }

    public void updateTable() throws SQLException {
        Connection fc = DriverManager.getConnection(url, name, pass);
        System.out.print("\nEnter ID to update: ");
        int id = inputs.nextInt();
        inputs.nextLine(); // Consume newline
        System.out.print("Enter new Marks: ");
        double newMarks = inputs.nextDouble();
        inputs.nextLine(); // Consume newline
        String query = "update test set gpa = ? where id = ?;";
        PreparedStatement pst = fc.prepareStatement(query);
        pst.setDouble(1, newMarks);
        pst.setInt(2, id);
        int affectedRows = pst.executeUpdate(); // executeUpdate() returns the number of rows affected by the query
        System.out.println("\nPassed Query : " + pst.toString());
        System.out.println("Number of rows affected : " + affectedRows + "\n");
        fc.close();

        this.choice();
    }
}