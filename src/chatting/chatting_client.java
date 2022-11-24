package chatting;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.Scanner;
import chatting.file_client;
import java.time.format.DateTimeFormatter;
import java.time.*;

public class chatting_client {
    public static Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    private DataOutputStream dos;

    // chatting_client client = new chatting_client(); 소켓 연결
    // client.make_room(1, user_id, 참여자리스트); 방 생성
    // client.invite_room(2, user_id, 방번호, 참여자리스트); 방 초대
    // client.delete_room(3, user_id, 방번호); 방 제거
    // client.send_messege(4, 방번호, user_id, 메시지, 시간, 파일유무, 파일경로); 메시지 보내기

    public chatting_client(int user_id) {
        try {
            this.socket = new Socket("swiftsjh.tplinkdns.com", 25588);
            this.oos = new ObjectOutputStream(socket.getOutputStream());
            this.ois = new ObjectInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            dos.writeInt(user_id);

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
    public void make_room(int typeofrequest, int sender, ArrayList<Integer> list){
        protocol content = new protocol(typeofrequest, sender, list);
        chat_message(content);
    }

    // 방 초대
    public void invite_room(int typeofrequest, int sender, String roomnumber, ArrayList<Integer> list){
        protocol content = new protocol(typeofrequest, sender, roomnumber, list);
        chat_message(content);
    }

    // 방에서 나가기
    public void exit_room(int typeofrequest, int sender, String roomnumber){
        protocol content = new protocol(typeofrequest, sender, roomnumber);
        chat_message(content);
        sockt_close();
    }

    // 메시지 보내기
    public void send_messege(int typeofrequest, String roomnumber, int sender, String messege, String time, boolean file_exist, String file_path){
        protocol content = new protocol(typeofrequest, roomnumber, sender, messege, time, file_exist, file_path);
        chat_message(content);
    }

    // 로그아웃
    public void logout(int typeofrequest, int sender){
        protocol content = new protocol(typeofrequest, sender);
        chat_message(content);
        sockt_close();
    }

    // 파일 보내는 경우
    public void send_file(int typeofrequest, String roomnumber, String file_path){
        protocol content = new protocol(typeofrequest, roomnumber, file_path);
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

        String roomnumber;

        // user_id 입력받기
        System.out.println("user_id를 입력하세요");
        int user_id = keyboard.nextInt();

        // chatting_client 객체 생성
        chatting_client client = new chatting_client(user_id);

        // ListeningThread 객체 생성
        ListeningThread t1 = new ListeningThread(socket);
        t1.start(); // ListeningThread 시작

        while(true) {
            System.out.println("1. 방 생성");
            System.out.println("2. 방 초대");
            System.out.println("3. 방에서 나가기");
            System.out.println("4. 메시지 보내기");
            System.out.println("5. 로그아웃");
            int type = keyboard.nextInt();

            if (type == 1) { // 방 생성
                System.out.println("참여자 리스트를 입력하세요, 0을 입력하면 종료합니다.");
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (true) {
                    int user = keyboard.nextInt();
                    if (user == 0) {
                        break;
                    }
                    list.add(user);
                }
                try {
                    client.make_room(type, user_id, list);
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (type == 2) { // 방에 초대하기
                System.out.println("방 번호를 입력하세요");
                roomnumber = keyboard.next().trim();
                System.out.println("참여자 리스트를 입력하세요, 0을 입력하면 종료합니다.");
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (true) {
                    int user = keyboard.nextInt();
                    if (user == 0) {
                        break;
                    }
                    list.add(user);
                }
                try {
                    client.invite_room(type, user_id, roomnumber, list);
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (type == 3) { // 방에서 나가기
                System.out.println("방 번호를 입력하세요");
                roomnumber = keyboard.next().trim();
                try {
                    client.exit_room(type, user_id, roomnumber);
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (type == 4) { // 메시지 보내기
                file_client file = new file_client();
                String time = file.getServerDateTime();
                System.out.println("메시지 보내기 입니다.");
                System.out.println("roomnumber를 입력하세요");
                roomnumber = keyboard.next().trim();
                boolean file_exist = false;
                while (true) {
                    try {
                        String messege = keyboard.nextLine();
                        if (messege.equals("exit")) {
                            break;
                        } else if (messege.equals("file")) {
                            file_exist = true;
                        }
                        if (file_exist) {
                            client.send_messege(type, roomnumber, user_id, null, time, file_exist, time);
                            file_exist = false;
                        } else {
                            client.send_messege(type, roomnumber, user_id, messege, time, file_exist, null);
                        }
                        // client.send_messege(4, roomnumber, user_id, messege, "시간", false, "경로");
                    } catch (Exception e) {
                    }
                }
            } if (type == 5) { // 로그아웃
                System.out.println("로그아웃 입니다");
                try {
                    client.logout(5, user_id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}