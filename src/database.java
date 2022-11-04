
import com.mysql.jdbc.*;
import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.util.concurrent.ExecutionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class database {
    String url = "jdbc:mysql://swiftsjh.tplinkdns.com:3306/insta";
    String userName = "dmz";
    String password = "1234";
    Connection con = null;
    Statement statement = null;
    PreparedStatement preparedstatement = null;
    ResultSet result=null;

    database() {
        try {
            con = DriverManager.getConnection(url, userName, password);
            statement = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Boolean logincheck(String idclient, String pwdclient) {
        String sq = "select * from user";
        try {
            result = statement.executeQuery(sq);
            while(result.next()){
                String pwdfromdb=result.getString(4);
                if(pwdfromdb.equals(pwdclient)){
                    System.out.println("Correct ID and Password");
                    return true;
                }
            }
            System.out.println("no correct password or id");
            return false;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;


    }
}
