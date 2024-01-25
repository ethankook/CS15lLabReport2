import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {

    int num = 0;
    String str = "";

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return str;
        }
        else {
            if (url.getPath().contains("/add")) {
                String[] message = url.getQuery().split("&");   //[0] = s=Hello, [1] = user=jpolitz
                String[] User1 = message[0].split("=");     //[0] = s, [1] = Hello
                String[] User2 = message[1].split("=");     //[0] = user, [1] = jpolitz

                if (User1[0].equals("s") && User2[0].equals("user")) {
                    str += String.format("%s: %s \n", User2[1], User1[1]);
                    return str;
                }
            }
            return "404 Not Found!";
        }
    }
}


class ChatServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
