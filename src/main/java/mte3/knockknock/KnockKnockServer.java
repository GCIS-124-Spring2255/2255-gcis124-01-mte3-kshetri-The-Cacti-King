// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 2
// Filename: KnockKnockServer.java (inside knockknock package)

package mte3.knockknock;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class KnockKnockServer {
    public static int PORT = 54322;

    public static void receiveAndSend(Scanner scanner,String message,PrintWriter writer,boolean concat) {
        String in = "";
            while(scanner.hasNext()) {
            in += scanner.next();
        }
        System.out.println("Recieved: " + in);

        if(concat == true) {
            writer.println("temp" + " " + message);
        } else {writer.println(message);}
        writer.flush();
        System.out.println("Sent: " + message);
    } // receiveAndSend() method closed
    
    public static void main(String args[]) throws IOException {
        ServerSocket ss = new ServerSocket(PORT);
        Socket client = ss.accept();
        Scanner sc = new Scanner(client.getInputStream());
        PrintWriter pw = new PrintWriter(client.getOutputStream());

        receiveAndSend(sc, "Who's there?", pw, false);
        receiveAndSend(sc, "who?", pw, true);
        receiveAndSend(sc, "haha", pw, false);

        pw.close();
        sc.close();
        client.close();
        ss.close();
    } // main() method closed
}