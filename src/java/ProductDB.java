
import java.sql.*;
public class ProductDB 
{
            String driver ="oracle.jdbc.OracleDriver";
            String url ="jdbc:oracle:thin:@DESKTOP-FEAHRH8:1521:xe";
            String query="Select * from product_master where pname=?";
            public boolean check(String search)
            {
            try{
                Connection con=null;
        
                Class.forName(driver);
                //System.out.println("Driver Loaded");
                con=DriverManager.getConnection(url,"system","basit");
                //System.out.println("Connection Established");
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1,search);
                ResultSet rs=st.executeQuery();
            
                 //Statement st = con.createStatement();
                 //ResultSet rs=st.executeQuery(query);
                 if(rs.next()) return true;     
            }
            catch(Exception e){};
            return false;
            }
}
