package chatting;

import java.io.*;
import java.net.Socket;

public class ListeningThread extends Thread { // 서버에서 보낸 메세지 읽는 Thread
	Socket socket = null;

	public ListeningThread(Socket socket) { // 생성자
		this.socket = socket; // 받아온 Socket Parameter를 해당 클래스 Socket에 넣기
	}
	public void run() {
		try {
			InputStream input = socket.getInputStream();

			protocol tmp;
			while(true){
				ObjectInputStream ois = new ObjectInputStream(input);
				protocol t = (protocol) ois.readObject();
				if(t.getTypeofrequest() == 5){

				}else {
					System.out.println(t.getMessege());
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}