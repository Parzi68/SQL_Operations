import java.sql.*;
public class join {
    public static void main(String[] args) {
    Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/demodb",
            "postgres", "smit123");
        c.setAutoCommit(false);
        System.out.println("Opened Database Successfully");
        stmt = c.createStatement();

        // String sql="select empname from company c, employee e where e.salary=c.salary and address='Texas';";
        // stmt.executeUpdate(sql);
        ResultSet rs = stmt.executeQuery( "select name from company c, employee e where c.name=e.empname and address='Texas';" );
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String  name = rs.getString("name");
            float salary = rs.getFloat("salary");
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            System.out.println( "SALARY = " + salary );
            System.out.println();
         }
         rs.close();
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Operation done successfully");
   }
}
 
