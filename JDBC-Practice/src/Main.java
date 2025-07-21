import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {

        /*
        import package
        load and register
        create connection
        create statement
        execute statement
        process the results
        close


        */
        preparedStatement();


    }

    public static void statement() throws Exception{
        String url = "jdbc:postgresql://localhost:5433/demo";
        String uname = "postgres";
        String pass = "1234";


        String sql = "select * from student"; // show all entries
        String sql2 = "delete from student where roll = 1";  // delete rows
        int roll=5;
        String name="Ranjan";
        String sec="A";
        String sql3 = "insert into student values ("+roll+",'"+name+"', '"+sec+"')";  // insert entry

        // Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection established");
        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery(sql);
//        while (rs.next()) {
//            System.out.print(rs.getInt(1) + " - ");
//            System.out.print(rs.getString(2) + " - ");
//            System.out.println(rs.getString(3));
//        }

        st.execute(sql3);

        con.close();
        System.out.println("Connection closed");
    }

    public static void preparedStatement() throws Exception{
        int roll = 104;
        String name = "Apple";
        String sec = "E";

        String url = "jdbc:postgresql://localhost:5433/demo";
        String uname = "postgres";
        String pass = "1234";

        String sql = "insert into student values (?,?,?)";
        String select = "select * from student"; // show all entries


        Connection con = DriverManager.getConnection(url, uname, pass);
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, roll);
        st.setString(2, name);
        st.setString(3, sec);
        st.execute();

        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(select);

        while (rs.next()) {
            System.out.print(rs.getInt(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.println(rs.getString(3));
        }

        con.close();
    }
}
