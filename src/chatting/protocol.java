package chatting;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class protocol implements Serializable {
    private int typeofrequest;
    private ArrayList<String> list = new ArrayList<>();
    private int sender;
    private String roomnumber;
    private String messege;
    private String time;
    private boolean file_exist;
    private String file_path;

    public protocol(){

    }
    // 방 생성인 경우
    public protocol(int typeofrequest, ArrayList<String> list){
        this.typeofrequest = typeofrequest;
        this.list = list;
    }

    // 방 초대
    public protocol(int typeofrequest, String roomnumber, ArrayList<String> list){
        this.typeofrequest = typeofrequest;
        this.roomnumber = roomnumber;
        this.list = list;
    }

    // 방 제거
    public protocol(int typeofrequest, String roomnumber){
        this.typeofrequest = typeofrequest;
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
}
