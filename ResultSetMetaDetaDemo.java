import java.sql.*;

class ResultSetMetaDataDemo{
    public static void main(String[] args) {
        

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","System");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from players_data");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("First Column "+ rsmd.getColumnName(1));
            System.out.println("second column: "+rsmd.getColumnName(2));
            System.out.println("Third column: "+rsmd.getColumnName(3));
            System.out.println("Fourth column: "+rsmd.getColumnName(4));
        } catch(ClassNotFoundException c){
            System.out.println(c);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}