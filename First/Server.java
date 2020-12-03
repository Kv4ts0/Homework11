import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server extends Thread{
    Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    String text;

    public void run(){
        try {
            ServerSocket ss = new ServerSocket(8080);
            socket = ss.accept();
            inputStream = new ObjectInputStream(socket.getInputStream());
            text = inputStream.readObject().toString();
            System.out.println("Client : " + text);
            Scanner sc = new Scanner(System.in);
            text = sc.nextLine();
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(text);
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
