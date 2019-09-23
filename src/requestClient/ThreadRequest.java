/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requestClient;

import java.net.URL;
import java.io.*;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author crkjohn
 */
public class ThreadRequest extends Thread{

    private  String urls;

    public ThreadRequest(String url){
        this.urls = url;    
    }
    
    public void setUrl(String url){
        this.urls =  url;
    }

    

    @Override
    public void run(){
        URL url = null;
        try {
            url = new URL(this.urls);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (Exception ex) {
            Logger.getLogger(ThreadRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}

 




