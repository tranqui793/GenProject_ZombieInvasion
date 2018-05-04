package net.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class Client {

    //----------------Server connection member-------------------
    private static final Logger LOG = Logger.getLogger(Client.class.getName());
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private boolean connected;
    private Gson gson;
    private int role;

    //---------------Constructor---------------------------------
    public Client() {
        this.connected = false;
        role = 0;

        //Prépare le moteur gson
        gson = new GsonBuilder().setPrettyPrinting().create();
    }


    //---------------Methods-------------------------------------

    public void auth(String username, String password) throws IOException{
        if(!connected)
            connect(Protocol.DEFAULT_ADDRESS, Protocol.DEFAULT_PORT);
        gson.toJson(new UserJson(username, password), out);
        out.flush();
        role = Integer.parseInt(in.readLine());
    }

    public void connect(String server, int port) throws IOException {
        socket = new Socket(server, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());
        connected = true;
    }

    public void disconnect() throws IOException {

        if(socket != null) {
            socket.close();
        }
        if(in != null) {
            in.close();
        }
        if(out != null) {
            out.close();
        }

        connected = false;
    }

    public boolean isConnected() {
        return connected && (socket != null);

    }

    public String readServer() throws IOException{
        return in.readLine();
    }

    public void writeServer(String str){
        out.write(str + '\n');
        out.flush();
    }
}