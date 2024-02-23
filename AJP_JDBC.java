
import java.util.Scanner;
import java.sql.*;

public class AJP_JDBC {
    public static void main(String[] args){

        try{
            Scanner sc = new Scanner(System.in);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","System");
            Statement st = conn.createStatement();
            try {
                st.executeUpdate("create table std(id number(5),name varchar2(15),gender varchar2(2))");
            } catch (Exception e) {
            }
            while(true){
                System.out.println("1.Insert 2.delete 3.Update 4.Display 5.Exit(Drops the table)");
                System.out.print("Enter your choice : ");
                int choice = sc.nextInt();
                switch(choice){
                    case 1:
                        System.out.print("Enter id : ");
                        int id = sc.nextInt();
                        System.out.print("Enter name : ");
                        String name = sc.next();
                        System.out.print("Enter gender : ");
                        String gender = sc.next();
                        String q = "insert into std values(?,?,?)";
                        PreparedStatement pr = conn.prepareStatement(q);
                        pr.setInt(1,id);
                        pr.setString(2,name);
                        pr.setString(3,gender);
                        pr.executeUpdate();
                        System.out.println("insertion complete");
                        break;
                    case 2:
                        System.out.print("Enter id to delete : ");
                        int delid = sc.nextInt();
                        String delq = "delete from std where id ="+delid;
                        st.executeUpdate(delq);
                        System.out.println("Deleted row with id : "+delid);
                        break;

                    case 3:
                        System.out.print("Enter id to update : ");
                        int id1 = sc.nextInt();
                        System.out.print("Enter column to update: ");
                        String col = sc.next();
                        System.out.print("Enter value : ");
                        String val = sc.next();
                        String x ="'"+ val+"'";
                        String s = "update std set "+col+"="+x+" where id ="+id1+"";
                        st.executeUpdate(s);
                        break;
                    case 4:
                        ResultSet rs = st.executeQuery("select * from std");
                        if(rs == null){
                            System.out.println("no rows selected");
                            break;
                        }
                        // rs.previous();
                        while(rs.next()){
                            System.out.println("id: "+rs.getInt(1) + " name : "+rs.getString(2)+" Gender: "+rs.getString(3));
                        }
                        break;
                    case 5:
                        st.executeUpdate("delete table std");
                        sc.close();
                        System.exit(0);
                }
                
            }

        } catch(Exception e){
            System.out.println(e);
        }
    }
}
