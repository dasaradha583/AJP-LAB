import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class TCPServerClientDemo {
    public static void main(String[] args){
        try {
            ServerSocket serversocket = new ServerSocket(3546);
            Socket socket = serversocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String request = "";
            String response = " ";
            do {
                request = dis.readUTF();
                System.out.println("Client : "+request);
                // if(!request.equalsIgnoreCase("stop"))
                if(request.equalsIgnoreCase("stop")){
                    System.exit(0);
                }
                System.out.print("Enter a message to client : ");
                response = scanner.nextLine();
                
                dos.writeUTF(response);
            } while (!(request.equalsIgnoreCase("stop") || response.equalsIgnoreCase("ok")));



            scanner.close();
            dos.close();
            dis.close();
            serversocket.close();
            socket.close();
        } catch (Exception e) {
            
        }
        
    }
    
}
