public class Main {
    public static void main(String[] args){
        Client cl = new Client();
        Server srv = new Server();
        cl.start();
        srv.start();
    }
}
