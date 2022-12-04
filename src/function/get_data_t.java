//package function;
//
//import chatting.protocol;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.*;
//import java.net.Socket;
//import java.util.ArrayList;
//
//public class get_data_t extends Thread{
//    public void request(protocol content){
//        try{
//            this.oos.writeObject(content); // 프로토콜로 담은 내용 전송
//            this.oos.flush();
//        }
//        catch(Exception e2){
//            System.out.println(e2);
//        }
//    }
//    private InputStream is;
//    private OutputStream os;
//    private DataInputStream di;
//    private DataOutputStream ds;
//    private PrintWriter pw;
//    private ObjectOutputStream oos;
//    private ObjectInputStream ois;
//    private DataOutputStream dos;
//    private BufferedOutputStream bos;
//    private String feed_id;
//    private String message;
//    private ArrayList<String> Tag_list;
//    private String file_name;
//
//    public get_data_t(String feed_id, String message, ArrayList<String> Tag_list, String file_name){
//        this.feed_id = feed_id;
//        this.message = message;
//        this.Tag_list = Tag_list;
//        this.file_name = file_name;
//    }
//    public void run(){
//        try {
//            Socket socket = new Socket("swiftsjh.tplinkdns.com", 9998);
//            System.out.println("서버 연결 성공");
//            this.is = socket.getInputStream();
//            this.os = socket.getOutputStream();
//            this.di = new DataInputStream(is);
//            this.ds = new DataOutputStream(os);
//            this.pw = new PrintWriter(os);
//            this.oos = new ObjectOutputStream(os);
//            this.dos = new DataOutputStream(os);
//            this.bos = new BufferedOutputStream(os);
//            this.pw = new PrintWriter(bos);
//            this.ois = new ObjectInputStream(is);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        protocol p = new protocol(18, feed_id);
//        request(p);
//        while(true){
//            try{
//                protocol t = (protocol) ois.readObject();
//                if(t.getTypeofrequest() == 18){
//                    feed_id = t.getSender();
//                    message = t.getMessage();
//                    Tag_list = t.getList();
//                    file_name = t.getFile_name();
//                    System.out.println("feed_id: " + feed_id + "\tmessage: " + message + "\tTag_list: " + Tag_list + "\tfile_name: " + file_name);
//                    GridBagLayout Gbag = new GridBagLayout();
//                    setLayout(Gbag);
//                    GridBagConstraints gbc = new GridBagConstraints();
//                    poster = new JLabel(writer);
//                    img = new JLabel();
//                    feedMessage = new JTextArea();
//                    get_data feed_data = new get_data();
//                    feed_data.setType21(21,feed_id);
//                    feed_data.start();
//                    writer = feed_data.getposter_id();
//                    File img_tmp=new File("post/"+writer+"/"+file_name);
//                    if(img_tmp.exists()==false){
//                        imgdownload tmp = new imgdownload(writer,file_name);
//                    }
//
//                    setSize(600,800);
//                    setBackground(new Color(0,0,0));
//
//
//                    gbc.weightx = 1.0;
//                    gbc.weighty = 1.0;
//                    gbc.fill = GridBagConstraints.BOTH;
//
//
//                    poster.setForeground(new Color(255,255,255));
//                    gbc.gridx = 0;
//                    gbc.gridy = 0;
//                    gbc.gridwidth = 8;
//                    gbc.gridheight = 1;
//                    gbc.weightx = 1.0;
//                    gbc.weighty = 0.1;
//                    gbc.ipadx = 0;
//                    gbc.ipady = 0;
//                    add(poster,gbc);
//
//                    //이미지 추가
//
//                    img.setSize(600,400);
//                    ImgSetSize image = new ImgSetSize("post/"+writer+"/"+file_name, 800, 400);
//                    img.setIcon(image.getImg());
//                    gbc.gridx = 0;
//                    gbc.gridy = 1;
//                    gbc.gridwidth = 8;
//                    gbc.gridheight = 7;
//                    gbc.weightx = 1.0;
//                    gbc.weighty = 0.7;
//                    gbc.ipadx = 0;
//                    gbc.ipady = 0;
//                    add(img,gbc);
//
//                    //메세지 추가
//
//                    feedMessage.setSize(600,200);
//                    feedMessage.setText(message);
//                    gbc.gridx = 0;
//                    gbc.gridy = 8;
//                    gbc.gridwidth = 8;
//                    gbc.gridheight = 4;
//                    gbc.weightx = 1.0;
//                    gbc.weighty = 0.1;
//                    gbc.ipadx = 0;
//                    gbc.ipady = 0;
//                    add(feedMessage,gbc);
//
//                    //태그 추가
//                    feedTag = new JTextArea();
//                    feedTag.setSize(600,100);
//                    feedTag.setText("");
//                    for(int i = 0;i<Tag.size();i++){
//                        feedTag.setText(feedTag.getText() + "#" + Tag.get(i) + " ");
//                    }
//                    gbc.gridx = 0;
//                    gbc.gridy = 12;
//                    gbc.gridwidth = 8;
//                    gbc.gridheight = 2;
//                    gbc.weightx = 1.0;
//                    gbc.weighty = 0.04;
//                    gbc.ipadx = 0;
//                    gbc.ipady = 0;
//                    add(feedTag,gbc);
//
//                    //댓글 창 추가
//                    comment = new JTextField();
//                    comment.setSize(450,100);
//                    gbc.gridx = 0;
//                    gbc.gridy = 14;
//                    gbc.gridwidth = 6;
//                    gbc.gridheight = 2;
//                    gbc.weightx = 0.75;
//                    gbc.weighty = 0.06;
//                    gbc.ipadx = 0;
//                    gbc.ipady = 0;
//                    add(comment,gbc);
//
//                    //댓글 버튼
//                    comment_button = new JButton("comment");
//                    comment_button.setSize(150,100);
//                    gbc.gridx = 6;
//                    gbc.gridy = 14;
//                    gbc.gridwidth = 1;
//                    gbc.gridheight = 1;
//                    gbc.weightx = 0.125;
//                    gbc.weighty = 0.06;
//                    gbc.ipadx = 0;
//                    gbc.ipady = 0;
//                    add(comment_button,gbc);
//                    comment_button.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            String a = comment.getText();
//                            //댓글 보내기
//                        }
//                    });
//
//                    like_button = new JButton("like");
//                    like_button.setSize(150,100);
//                    gbc.gridx = 7;
//                    gbc.gridy = 14;
//                    gbc.gridwidth = 1;
//                    gbc.gridheight = 1;
//                    gbc.weightx = 0.125;
//                    gbc.weighty = 0.06;
//                    gbc.ipadx = 0;
//                    gbc.ipady = 0;
//                    add(like_button,gbc);
//
//                    get_data Data = new get_data();
//                    Data.setType49(49, user_id, this.feed_id);
//                    Data.start();
//
//                    if(Data.getHeart_yes_or_no().equals("true")){
//                        like_button.setText("unlike");
//                        like_button.setBackground(new Color(255,0,0));
//                    }
//                    else{
//                        like_button.setBackground(new Color(255,255,255));
//                        like_button.setText("like");
//                    }
//                    like_button.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            if(Data.getHeart_yes_or_no().equals("false")){
//                                get_data Data1 = new get_data();
//                                Data1.setType50(50,user_id,feed_id);
//                                Data1.start();
//                                get_data Data = new get_data();
//                                Data.setType49(49, user_id,feed_id);
//                                Data.start();
//                                if(Data.getHeart_yes_or_no().equals("true")){
//                                    like_button.setText("unlike");
//                                    like_button.setBackground(new Color(255,0,0));
//                                }
//                                else{
//                                    like_button.setBackground(new Color(255,255,255));
//                                    like_button.setText("like");
//                                }
//                            }
//                            else{
//                                get_data Data1 = new get_data();
//                                Data1.setType50(50,user_id,feed_id);
//                                Data1.start();
//                                get_data Data = new get_data();
//                                Data.setType49(49, user_id,feed_id);
//                                Data.start();
//                                if(Data.getHeart_yes_or_no().equals("true")){
//                                    like_button.setText("unlike");
//                                    like_button.setBackground(new Color(255,0,0));
//                                }
//                                else{
//                                    like_button.setBackground(new Color(255,255,255));
//                                    like_button.setText("like");
//                                }
//                            }
//                        }
//                    });
//                }
//                    break;
//                } catch(Exception e){
//                    System.out.println(e);
//            }
//        }
//    }
//}
