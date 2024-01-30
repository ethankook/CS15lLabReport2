# Lab Report 2 - Servers and SSH Keys (Week 3)
**PART 1**
```import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {

    int num = 0;
    String str = "";

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return str;
        }
        else {
            if (url.getPath().contains("/add-message")) {
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
```

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
![Image](LR2SS1.png)
![Image](LR2SS2.png)

*1. Which methods in your code are called?*

The method `handleRequest` is called.

*2. What are the relevant arguments to those methods, and the values of any relevant fields of the class?*
The relevant argument for the method `handleRequest` is the url
*3. How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.*


