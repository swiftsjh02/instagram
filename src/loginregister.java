import java.io.*;
import java.net.*;
import java.util.*;

public class loginregister {

    public static int port=9898;
    public static String host="swiftsjh.tplinkdns.com";

    public int register(String id,String password){
        try{
            Socket socket= new Socket(host,port);
            OutputStream os=socket.getOutputStream();
            DataOutputStream ds= new DataOutputStream(os);
            InputStream is=socket.getInputStream();
            DataInputStream di=new DataInputStream(is);
            PrintWriter pw= new PrintWriter(os);
            int id_len =id.getBytes().length;
            int pwd_len=password.getBytes().length;
            ds.writeInt(100); //100 means register status code
            ds.flush();
            pw.println(id);
            pw.flush();
            pw.println(password);
            pw.flush();
            int register_status=-1;
            register_status = di.readInt(); //get session id
            if(register_status==1){
                System.out.println("회원가입 성공");//
                return  register_status;
            }
            os.close();
            socket.close();

        }catch (Exception e){
            System.out.println(e);
        }

        return 0;
    }
    public int login(String id,String password){
        try{
            Socket socket= new Socket(host,port);
            OutputStream os=socket.getOutputStream();
            InputStream is=socket.getInputStream();
            DataOutputStream ds= new DataOutputStream(os);
            DataInputStream di=new DataInputStream(is);
            PrintWriter pw= new PrintWriter(os);
            int id_len =id.getBytes().length;
            int pwd_len=password.getBytes().length;
            ds.writeInt(200); //200 means register status code
            ds.flush();
            pw.println(id);
            pw.flush();
            pw.println(password);
            pw.flush();
            int session=-1;
            session = di.readInt(); //get session id
            os.close();
            socket.close();
            return  session; //session id from server received
        }catch (Exception e){
            System.out.println(e);
        }

        return -1; //when error occured return -1
    }
}
