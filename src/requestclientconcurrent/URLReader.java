package requestclientconcurrent;

import java.io.*; 
import java.net.*; 
public class URLReader { 
  public static void main(String[] args) throws Exception { 
      System.err.println(args[1]);
      URL url = new URL(args[2]); 
      try (BufferedReader reader = new BufferedReader(
          new InputStreamReader(url.openStream()))) { 
            String inputLine = null; 
            while ((inputLine = reader.readLine()) != null) { 
                  System.out.println(inputLine); 
             } 
       } catch (IOException x) { 
               System.err.println(x); 
       } 
    } 
}
