package chatting;

import java.io.Serializable;
import java.util.ArrayList;

public class protocol implements Serializable {
    private int typeofrequest;
    private ArrayList<Integer> list = new ArrayList<>();
    private int sender;
    private String roomnumber;
    private String messege;
    private String time;
    private boolean file_exist;
    private String file_path;

    public protocol(){

    }
    // 방 생성인 경우
    public protocol(int typeofrequest, int sender, ArrayList<Integer> list){
        this.sender = sender;
        this.typeofrequest = typeofrequest;
        this.list = list;
    }

    // 방 초대
    public protocol(int typeofrequest, int sender, String roomnumber, ArrayList<Integer>list){
        this.typeofrequest = typeofrequest;
        this.sender = sender;
        this.roomnumber = roomnumber;
        this.list = list;
    }

    // 방에서 나가기
    public protocol(int typeofrequest, int sender, String roomnumber){
        this.typeofrequest = typeofrequest;
        this.sender = sender;
        this.roomnumber = roomnumber;
    }

    // 메시지 보내기
    public protocol(int typeofrequest, String roomnumber, int sender, String messege, String time, boolean file_exist, String file_path){
        this.typeofrequest = typeofrequest;
        this.roomnumber = roomnumber;
        this.sender = sender;
        this.messege = messege;
        this.time = time;
        this.file_exist = file_exist;
        this.file_path = file_path;
    }

    // 로그아웃
    public protocol(int typeofrequest, int sender){
        this.typeofrequest = typeofrequest;
        this.sender = sender;
    }

    //make getter function
    public int getTypeofrequest() {
        return typeofrequest;
    }
    public ArrayList<Integer> getList() {
        return list;
    }
    public int getSender() {
        return sender;
    }
    public String getRoomnumber() {
        return roomnumber;
    }
    public String getMessege() {
        return messege;
    }
    public String getTime() {
        return time;
    }
    public boolean isFile_exist() {
        return file_exist;
    }
    public String getFile_path() {
        return file_path;
    }
}