package chatting;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class ListeningThread extends Thread { // 서버에서 보낸 메세지 읽는 Thread
	Socket socket = null;
	ArrayList<String> myroom_list = new ArrayList<>();

	public ListeningThread(Socket socket,ArrayList<String> myroom_list) { // 생성자
		this.socket = socket; // 받아온 Socket Parameter를 해당 클래스 Socket에 넣기
		this.myroom_list=myroom_list;
	}

	public ArrayList<String> get_myroom_list() {
		return myroom_list;
	}
	public void run() {

		try {
			InputStream input = socket.getInputStream();
			while(true){
				ObjectInputStream ois = new ObjectInputStream(input);
				protocol t = (protocol) ois.readObject();
				if(t.getTypeofrequest() == 1){

				}
				else if(t.getTypeofrequest() == 2) {
				}
				else if(t.getTypeofrequest() == 4){
					String timenow = t.getTime();
					timenow = timenow.substring(8, 10) + ":" + timenow.substring(10, 12);
					System.out.println("방 번호 : " + t.getRoomnumber());
					System.out.println("현재 시간 : " + timenow);
					System.out.println("보낸 사람 : " + t.getSender());
					System.out.println("메시지 : " +  t.getMessege());
					System.out.println("파일 존재 여부 : " + t.isFile_exist());
					System.out.println("파일명 : " + t.getFile_name());
				}else if(t.getTypeofrequest() == 12) {
					myroom_list=t.getList();
					System.out.println("서버의 방목록 업데이트 결과가 도착했습니다.");
				}
				else{
					System.out.println("잘못된 요청입니다.");
				}
			}
		} catch (SocketException e){
			System.out.println("로그아웃 하였습니다.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}