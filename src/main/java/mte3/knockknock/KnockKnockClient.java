// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 2
// Filename: KnockKnockClient.java (inside knockknock package)

package mte3.knockknock;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class KnockKnockClient {
    public static int PORT = 54322;
    public static String SERVER = "localhost";

    public static void sendAndReceive(PrintWriter writer, String message, Scanner scanner) {
        writer.println(message);
        writer.flush();
        System.out.println("Sent: " + message);

        String in = "";
        while(scanner.hasNext()) {
            in += scanner.next();
        }
        System.out.println("Recieved: " + in);
    } // sendAndReceive() method closed
    

    public static void joke(String who,String punchLine) throws IOException {
        Socket client = new Socket(SERVER, PORT);
        PrintWriter pw = new PrintWriter(client.getOutputStream());
        Scanner sc = new Scanner(client.getInputStream());

        sendAndReceive(pw, "Knock, knock", sc);
        sendAndReceive(pw, who, sc);
        sendAndReceive(pw, punchLine, sc);
        
        sc.close();
        pw.close();
        client.close();
    } // joke() method closed

    public static void main(String[] args) throws IOException {

        String[][] jokes = {{"Tank","You're welcome!"},
                            {"Nobel","Nobel...that's why I knocked!"},
                            {"Says","Says me!"},
                            {"Hawaii","I'm good. Hawaii you?"},
                            {"Lettuce","Lettuce in, it's cold out here!"},
                            {"Cow says","No, a cow says moooooo!"},
                            {"Otto","Otto know. I forgot."}
                        };
        int i = new Random().nextInt(jokes.length);
        joke(jokes[i][0],jokes[i][1]);

    } // main() method closed

    // hint: please run KnockKnockServer first and then run KnockKnockClient

} // KnockKnockClient { } class closed