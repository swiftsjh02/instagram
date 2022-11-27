package chatting;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class wow extends Thread {

    boolean running = true;
    BufferedInputStream reader = null;

    public static void main(String[] args) throws FileNotFoundException {
        wow tw = new wow();
        tw.reader = new BufferedInputStream(new FileInputStream("chatting_data\\65ae42cb8042dfefdc124bfdfb7e5038.txt"));
        tw.start();
    }

    public void run() {

        int i=0;
        byte[] b = new byte[100000];
        while (running) {
            try {
                if (reader.available() > 0) {
                    byte tmp = (byte)reader.read();
                    if(tmp==13 || tmp==10){
                        String s = new String(b, StandardCharsets.UTF_8);
                        s=s.substring(0,i);
                        System.out.println(s);
                        b= new byte[100000];
                        i=0;
                    }else{
                        b[i]=tmp;
                        i++;
                    }
                } else {
                    try {
                        sleep(100);
                    } catch (InterruptedException ex) {
                        running = false;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}