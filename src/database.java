import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.concurrent.ExecutionException;

public class database {
    String url = "jdbc:mysql://swiftsjh.tplinkdns.com:3306/insta";
    String userName= "dmz";
    String password="jiho0304";
    Connection con=null;
    Statement statement=null;
    PreparedStatement preparedstatement=null;
    Resultset result=null;

    database() {
        try {
            con = DriverManager.getConnection(url, userName, password);
            statement = con.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Boolean logincheck(String id,String password){
        String sq="Select id,password from user where id="+id;
        try {
            result = preparedstatement.execute(sq);
            return Boolean.TRUE;
        }catch (Exception e){
            System.out.println(e);
        }
        return Boolean.FALSE;
    }


}
