package chatapplication.Client;

import java.io.*;
import java.net.*;

/*

    This class is responsible for connecting to server
    and sending and receving messages to and from server

*/

public class Client {

    private Socket socket;
    private DataOutputStream dout;
    
    public Client() {
        this.socket = null;
        this.dout = null;
    }

    public Socket connect() throws IOException  {
        this.socket = new Socket("your-ip", 5555);
        return this.socket;
    }

    public void sendMessage(String message) throws IOException {
        this.dout = new DataOutputStream(this.socket.getOutputStream());
        dout.writeUTF(message);
        dout.flush();
    }
    
    public boolean isConnected() {
        return this.socket.isConnected();
    }
    
    public void disconenct() throws IOException {
        this.socket.close();
    }
}
