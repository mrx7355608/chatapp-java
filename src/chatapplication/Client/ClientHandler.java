/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapplication.Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author fawad
 */
public class ClientHandler implements Runnable {

    private Socket socket;
    private DataInputStream din;
    private JTextArea textArea;

    public ClientHandler(Socket s, JTextArea textArea) {
        this.socket = s;
        this.din = null;
        this.textArea = textArea;
    }

    public void receiveMessageFromServer() throws IOException {
        this.din = new DataInputStream(this.socket.getInputStream());
        
        while (true) {
            if (this.din.available() > 0) {
                this.textArea.append(this.din.readUTF() + "\n");
            }
        }
    }

    @Override
    public void run() {
        try {
            this.receiveMessageFromServer();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
