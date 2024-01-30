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
```
![Image](LR2SS1.png)
![Image](LR2SS2.png)

*1. Which methods in your code are called?*

For both screenshots above, the method `handleRequest` is called.

*2. What are the relevant arguments to those methods, and the values of any relevant fields of the class?*

For the both screenshots shown above, the relevant argument for the method `handleRequest` is `URI url`, which is the path given in the url. The relevant fields are `String str` (the string that lists all of the messages and the user that said it), `String s` (the string given in the path of the url), and the three string arrays `String[] message`, `String[] User1`, and `String[] User2`. If the URL path contains `/add-message`, then the query following it is split into two different strings and appended to the array `message[]` in the 0 and 1 indexes. The string in `message[0]` is the message given in the query, while the string in `message[`]` is the name of the user who gave the message. In the first screenshot, `message[0]` is `"s=Hello"` and `message[1]` is `"user=Ethan"`.

*3. How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.*


