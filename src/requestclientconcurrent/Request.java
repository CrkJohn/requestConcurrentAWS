package requestclientconcurrent;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author crkjohn
 */
public class Request {

    /**
     * @param args the command line arguments
     */
    final static double second = 1e9;

    public static void main(String[] args) {
        int numberOfTimes = Integer.parseInt(args[0]);
        int numberRequest = Integer.parseInt(args[1]);
        String url = args[2];
        for (int i = 0; i < numberOfTimes; ++i) {
            ThreadRequest[] threadRequest = new ThreadRequest[numberRequest];
            long startTime = System.currentTimeMillis();
            for (int j = 0; j < numberRequest; j++) {
                threadRequest[i] = new ThreadRequest(url);
                threadRequest[i].start();
            }
            for (int j = 0; j < numberRequest; ++j) {
                try {
                    threadRequest[i].join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            long endTime = System.currentTimeMillis();
            double duration = (endTime - startTime)/1000.0; 
            System.err.println("Execution time :  " + duration);
        }

    }
}


    