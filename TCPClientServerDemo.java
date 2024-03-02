import java.net.Socket;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class TCPClientServerDemo {
    public static void main(String[] args) {
    
        try{
            Socket socket = new Socket("localhost",3546);
            Scanner scanner = new Scanner(System.in);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String request = "";
            String response = " ";
            do {
                System.out.print("client : ");
                request = scanner.nextLine();
                dos.writeUTF(request);
                response = dis.readUTF();
                if(request.equalsIgnoreCase("stop")){
                    System.exit(0);
                }
                System.out.println("Server says : "+response);

            } while (!(request.equalsIgnoreCase("stop") || response.equalsIgnoreCase("ok")));





            dis.close();
            dos.close();
            scanner.close();
            socket.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
