
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

    //데이터베이스 접속 정보 저장하는 변수
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
        String sq = "select email,password from User";
        try {
            result = statement.executeQuery(sq);
            while(result.next()){
                String pwdfromdb=result.getString(2);
                if(pwdfromdb.equals(pwdclient)){
                    System.out.println("Correct email and Password");
                    return true;
                }
            }
            System.out.println("no correct password or email");
            return false;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;


    }

    public boolean dupllicate_email_check(String email){
        String sq = "select email from User";
        try{
            result= statement.executeQuery(sq);
            while (result.next()){
                String emailfromdb=result.getString(1);
                if(emailfromdb.equals(email)){
                    System.out.println("email already exists");
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            System.out.println(e);
        }

        return false;
    }

    public Boolean register(String email,String pwdclient) {


        String sq = "insert into User(email,password) values(?,?)";
        try {
            preparedstatement =con.prepareStatement(sq);
            if(dupllicate_email_check(email)==false){
                preparedstatement.setString(1,email);
                preparedstatement.setString(2,pwdclient);
                int count = preparedstatement.executeUpdate();
                if (count == 0) {
                    System.out.println("데이터 입력 실패");
                    return false;
                } else {
                    System.out.println("데이터 입력 성공");
                    return true;
                }
            }else{
                System.out.println("중복된 아이디 존재");
                return false;
            }


        }catch (Exception e){
            System.out.println(e);
        }
        return false;


    }
}
