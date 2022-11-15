import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.*;

public class loginregister {

    public static int port=9898;
    public static String host="localhost";

    public int register(String id,String password){
        try{
            Socket socket= new Socket(host,port);
            OutputStream os=socket.getOutputStream();
            DataOutputStream ds= new DataOutputStream(os);
            ds.writeInt(100); //100 means register status code
            os.write(id.getBytes());
            os.flush();
            os.write(password.getBytes());
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
            ds.writeInt(200); //200 means register status code
            os.write(id.getBytes());
            os.flush();
            os.write(password.getBytes());
            int session = di.readInt();
            os.close();
            socket.close();
            return  session; //session id from server received
        }catch (Exception e){
            System.out.println(e);
        }

        return -1; //when error occured return -1
    }
}
