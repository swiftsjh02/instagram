package chatting;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.time.LocalDate;
import java.time.LocalDate;
import java.io.Serializable;

public class chatting_client {
    public void chat_message(protocol content){
        try{
            var socket = new Socket("swiftsjh.tplinkdns.com", 25588);
            var out = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);

            // LocalDate now = LocalDate.now();
            oos.writeObject(content);
            oos.flush();
        }
        catch(Exception e){}
    }
    // 방 생성인 경우
    public void make_room(int typeofrequest, ArrayList<String> list){
        protocol content = new protocol(typeofrequest, list);
        chat_message(content);
    }

    // 방 초대
    public void invite_room(int typeofrequest, String roomnumber, ArrayList<String> list){
        protocol content = new protocol(typeofrequest, roomnumber, list);
        chat_message(content);
    }

    // 방 제거
    public void delete_room(int typeofrequest, String roomnumber){
        protocol content = new protocol(typeofrequest, roomnumber);
        chat_message(content);
    }

    // 메시지 보내기
    public void send_messege(int typeofrequest, String roomnumber, int sender, String messege, String time, boolean file_exist, String file_path){
        protocol content = new protocol(typeofrequest, roomnumber, sender, messege, time, file_exist, file_path);
        chat_message(content);
    }

}
