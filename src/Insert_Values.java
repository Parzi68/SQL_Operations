import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert_Values {
   public static void main(String args[]) {
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/demodb",
            "postgres", "smit123");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO EMPLOYEE (ID,empNAME,SALARY) "
            + "VALUES (1, 'test', 32000.00 );";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO EMPLOYEE (ID,empNAME,SALARY) "
            + "VALUES (2, 'Allen', 15000.00 );";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO EMPLOYEE (ID,empNAME,SALARY) "
            + "VALUES (3, 'Teddy', 20000.00 );";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO EMPLOYEE (ID,empNAME,SALARY) "
            + "VALUES (4, 'Mark', 65000.00 );";
         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
}