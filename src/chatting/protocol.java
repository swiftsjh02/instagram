package chatting;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class protocol implements Serializable {
    private int typeofrequest;
    private ArrayList<String> list;
    private String sender;
    private String roomnumber;
    private String messege;
    private String time;

    private int follow_num;

    private int follower_num;

    private int post_num;
    private boolean file_exist;
    private String file_name;
    private String error_type;

    private String following;
    private String follow;

    private boolean follow_yes_or_no;

    public protocol(){}

    // 요청 프로토콜
    // 방 생성인 경우 (방 생성 요청) type = 1
    // 방 초대인 경우 (방 초대 요청) type = 2
    // 방에서 나가기인 경우 (방 나가기 요청) type = 3
    // 메시지 보내기인 경우 (메시지 보내기 요청) type = 4
    // 로그아웃인 경우 (로그아웃 요청) type = 5

    // 체팅방 유저 목록 불러오기 (유저 정보가 담긴 list 요청) = 6
    // 팔로우 하기 (팔로우 요청) = 7

    // 팔로잉 정보 불러오기 (팔로잉 정보가 담긴 list 요청) = 8
    // 유저가 속한 방 목록 불러오기 (방 정보가 담긴 list 요청) = 11
    // 유저가 속한 방 목록 불러오기 (방 정보가 담긴 list 요청) = 12
    // 파일 전송 요청 = 13

    // 방 생성인 경우 1 or 유저가 속한 방 목록 불러오기
    public protocol(int typeofrequest, String sender, ArrayList<String> list){
        this.sender = sender;
        this.typeofrequest = typeofrequest;
        this.list = list;
    }

    // 방 초대 2
    public protocol(int typeofrequest, String sender, String roomnumber, ArrayList<String>list){
        this.typeofrequest = typeofrequest;
        this.sender = sender;
        this.roomnumber = roomnumber;
        this.list = list;
    }

    // 방에서 나가기 3, 팔로우 요청 7 ,팔로우 여부 확인 9
    public protocol(int a, String b, String c){
        this.typeofrequest = a;
        this.sender = b;
        this.roomnumber = c;
        this.follow = c;
    }

    public protocol(int typeofrequest,int post_num){
        this.typeofrequest = typeofrequest;
        this.post_num = post_num;
    }

    // 메시지 보내기 4
    public protocol(int typeofrequest, String roomnumber, String sender, String messege, String time, boolean file_exist, String file_name){
        this.typeofrequest = typeofrequest;
        this.roomnumber = roomnumber;
        this.sender = sender;
        this.messege = messege;
        this.time = time;
        this.file_exist = file_exist;
        this.file_name = file_name;
    }

    // 로그아웃 5, 팔로워, 팔로잉 목록 불러오기 요청 9, 10
    public protocol(int typeofrequest, String sender) {
        this.typeofrequest = typeofrequest;
        this.sender = sender;
    }


    public protocol(String error_type) {
        this.error_type = error_type;
    }

    //make getter function
    public int getTypeofrequest() {
        return typeofrequest;
    }
    public ArrayList<String> getList() {
        return list;
    }
    public String getSender() {
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
    public String getFile_name() {
        return file_name;
    }

    public int get_follower_num() {
        return follower_num;
    }

    public int getFollow_num(){
        return follow_num;
    }


    public boolean getFollowExist(){return follow_yes_or_no;}
    public String getFollow() {
        return follow;
    }

    public int getPostNum(){
        return post_num;
    }
    public String getFollowing() {
        return following;
    }

    //make setter function
    public void setTypeofrequest(int typeofrequest) {
        this.typeofrequest = typeofrequest;
    }
    public void setList(ArrayList<String> list) {
        this.list = list;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }
    public void setMessege(String messege) {
        this.messege = messege;
    }
    public void setTime() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        this.time = now.format(formatter);
    }
    public void setFile_exist(boolean file_exist) {
        this.file_exist = file_exist;
    }
    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

}


