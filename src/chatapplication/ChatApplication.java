package chatapplication;

import chatapplication.Server.Server;
import java.io.IOException;

public class ChatApplication {

    public static void main(String[] args) {
        
        Server server = new Server();
        try {
            server.start();
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

}
