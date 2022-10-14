import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    
    List<String> list = new ArrayList<>();
  
    public String handleRequest(URI url) {

        if (url.getPath().equals("/")) {
            return "Nothing show off";
        } 
        else {
            System.out.println("Path: " + url.getPath());
                if(url.getPath(). contains("/add")) {
                    
                    String[] parameters = url.getPath().split("=");
                    if (parameters[0].equals("s")){
                        
                        list.add(parameters[1]);
                        return String.formate(format:"%s has already been added", parameter[1]);
                }
                if(url.getPath().contains("/search")) {
                    String[] parameters = url.getQuery().split("=");
                    if (parameters[0].equals("s")) {
                        String empty = " ";
                        for (String s: list){

                            if (s.contains(parameters[1])){

                                empty += s;
                                empty += " ";
                            }
                        }

                    return empty;

            }
            return "404 Not Found!";
        }
    }
}

class SearchEngine{
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
