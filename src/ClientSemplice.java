import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientSemplice {
    public static void main(String[] args){
        final String hostname = "127.0.0.1"; //LocalHost
        final int port = 12345;

        try(Socket socket = new Socket(hostname, port)){ //se ce connessione...
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);

            System.out.println("Connesso al server. Scrivi qualcosa:");
            String userInput;
            while((userInput = scanner.nextLine()) != null){
                out.println(userInput); //invia al server
                System.out.println("Risposta: "+ in.readLine()); // leggi dal server
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
