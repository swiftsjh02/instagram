import javax.swing.*;
import display.*;
import chatting.*;
public class Main {
    public static void main(String[] args) {
        Login mylogin = new Login();
        //mainFeed a = new mainFeed();
         chatting_client client = new chatting_client("user_id");
         client.run();
//         client.send_messege();
//         client.invite_room();
//         client.make_room();
//         client.exit_room();
//         client.logout();
//         client.send_file();

    }
}
