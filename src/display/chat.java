package display;

import chatting.chatting_client;
import chatting.protocol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class chat extends JFrame{
    private JPanel main;
    private JPanel message;
    private JTextField textField1;
    private JButton send;
    private JPanel message_user;
    private JScrollPane log_Scroll;
    private JPanel scroll_panel;
    private JTextArea jta;
    private String room_id;
    private String my_id;

    private chatting_client client;

    boolean running = true;
    BufferedInputStream reader = null;


    private class read extends Thread{

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
                            jta.append(s);
                            jta.append("\n");
                            jta.setCaretPosition(jta.getDocument().getLength());
                            // jta.requestFocus();
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


    class JFrameWindowClosingEventHandler extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            JFrame frame = (JFrame)e.getWindow();
            frame.dispose();
            client.logout(5,my_id);
            System.out.println("LogOut");
        }
    }

    public chat(chatting_client client, String my_id, String room_id){

        try {
            reader = new BufferedInputStream(new FileInputStream("chatting_data\\"+room_id+".txt"));
        }catch (Exception e){
            e.printStackTrace();
        }

        new read().start();


        textField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    send.doClick();
                    textField1.setText("");
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });

        this.client = client;
        this.room_id = room_id;
        this.my_id = my_id;

        setContentPane(main);

        setSize(850, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0,0,850,1000);
        this.addWindowListener(new JFrameWindowClosingEventHandler());

        log_Scroll.getVerticalScrollBar().setUnitIncrement(15);

        GridBagLayout Gbag = new GridBagLayout();
        scroll_panel.setLayout(Gbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        int text_line = 0;
        //client에 my_id, room_id 보내주기
        //text 받아오기 cashing .txt파일
//        while(/*cashing text의 모든 라인을 읽어 드릴 때까지*/){
//            //의진: message / user_id = 의진 , user_message = message
//
//            message_log pane = new message_log(user_id, user_messsage);
//            gbc.fill = GridBagConstraints.BOTH;
//            gbc.ipadx = 850;
//            gbc.ipady = 100;
//            gbc.gridx = 0;
//            gbc.gridy = text_line*100;
//            Gbag.setConstraints(pane,gbc);
//            scroll_panel.add(pane);
//            scroll_panel.updateUI();
//            text_line += 1;
//        }
        log_Scroll.setViewportView(scroll_panel);
        log_Scroll.setVisible(true);
        scroll_panel.setVisible(true);
//
//        //만약 listener에서 message를 받아오면 String(형태 user_id : message)

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = textField1.getText();
                protocol time = new protocol();
                time.setTime();
                //client에 message와 room_id보내기
                client.send_messege(4,room_id,my_id,message,time.getTime(),false,time.getTime());
            }
        });

    }

    public class message_log extends JPanel{
        private JLabel log;
        private String message;
        private String user_id;
        public message_log(String user_id,String message){
            this.user_id = user_id;
            this.message = message;

            setSize(850,100);
            if(this.user_id == my_id){
                setLayout(new FlowLayout(FlowLayout.RIGHT));
                log.setText(message);
                add(log);
            }
            else{
                setLayout(new FlowLayout(FlowLayout.LEFT));
                log.setText(user_id + ": " + message);
                add(log);
            }
            setVisible(true);
        }
    }
   }

