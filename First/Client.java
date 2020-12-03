import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.net.InetAddress;
import java.lang.ClassNotFoundException;

public class Client extends Thread {
    Socket socket;
    ObjectOutputStream outputStream;
    String text;
    ObjectInputStream inputStream;

    public void run(){
        try{
            Scanner sc1 = new Scanner(System.in);
            System.out.println("enter the local IP");
            text = sc1.nextLine();
            socket = new Socket(InetAddress.getByName(text), 8080);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            text = sc.nextLine();
            outputStream.writeObject(text);
            inputStream = new ObjectInputStream(socket.getInputStream());
            text = inputStream.readObject().toString();
            System.out.println("Server : " + text);
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}