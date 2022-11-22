package chatting;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.time.LocalDate;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Scanner;

public class chatting_client {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    // chatting_client client = new chatting_client(); 소켓 연결
    // client.make_room(1, user_id, 참여자리스트); 방 생성
    // client.invite_room(2, user_id, 방번호, 참여자리스트); 방 초대
    // client.delete_room(3, user_id, 방번호); 방 제거
    // client.send_messege(4, 방번호, user_id, 메시지, 시간, 파일유무, 파일경로); 메시지 보내기

    public chatting_client() {
        try {
            this.socket = new Socket("swiftsjh.tplinkdns.com", 25588);
            this.oos = new ObjectOutputStream(socket.getOutputStream());
            this.ois = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void chat_message(protocol content){
        try{
            this.oos.writeObject(content);
            this.oos.flush();
        }
        catch(Exception e2){
            System.out.println(e2);
        }
    }
    // 방 생성인 경우
    public void make_room(int typeofrequest, int sender, ArrayList<String> list){
        protocol content = new protocol(typeofrequest, sender, list);
        chat_message(content);
    }

    // 방 초대
    public void invite_room(int typeofrequest, int sender, String roomnumber, ArrayList<String> list){
        protocol content = new protocol(typeofrequest, sender, roomnumber, list);
        chat_message(content);
    }

    // 방 제거
    public void delete_room(int typeofrequest, int sender, String roomnumber){
        protocol content = new protocol(typeofrequest, sender, roomnumber);
        chat_message(content);
        sockt_close();
    }

    // 메시지 보내기
    public void send_messege(int typeofrequest, String roomnumber, int sender, String messege, String time, boolean file_exist, String file_path){
        protocol content = new protocol(typeofrequest, roomnumber, sender, messege, time, file_exist, file_path);
        chat_message(content);
    }

    // 연결 끊기
    public void sockt_close(){
        try{
            this.oos.close();
            this.ois.close();
            this.socket.close();
        }
        catch(Exception e3){
            System.out.println(e3);
        }
    }
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        chatting_client client = new chatting_client();
        ArrayList<String> list = new ArrayList<>();
        list.add("태완");
        list.add("지호");
        client.make_room(1, 6974, list);
        while(true) {
            try {
                String messege = keyboard.nextLine();
                client.send_messege(4, "5000", 6974, messege, "시간", true, "경로");
            } catch (Exception e) {
            }
        }
    }
}
