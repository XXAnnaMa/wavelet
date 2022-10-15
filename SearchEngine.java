import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler
{
    ArrayList<String> strlist = new ArrayList<>();
    String str = "Nothing Show Off!";

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return str;
        } 
        else{
            System.out.println("Path: " + url.getPath());
            if (url.getPath().equals("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    strlist.add(parameters[1]);

                    return String.format("%s has already been added", parameters[1]);
                }
            }
            else if (url.getPath().equals("/search")) 
            {
                System.out.println("Path: " + url.getPath());
                if (url.getPath().contains("/search")){
                  String[] parameters = url.getQuery().split("=");
                  
                  if (parameters[0].equals("s")){
                      ArrayList<String> list = new ArrayList<>();
                      for (String e: strlist){
                        if (e.contains(parameters[1]))
                            list.add(e);
                      }
                        return String.format("" + list);
                    }
                  }
                }
            }
            return "404 Not Found!";
        }
}
    


class SearchEngine
{
    public static void main(String[] args) throws IOException
    {
        if(args.length == 0)
        {
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }
        int port = Integer.parseInt(args[0]);
        Server.start(port, new Handler());
    }
}