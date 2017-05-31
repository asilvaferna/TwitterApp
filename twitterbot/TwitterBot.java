/*
 * This is a really simple Twitter Bot for Java.
 * All credits to Yusuke Yamamoto creator of the Twitter4j library.
 */
package twitterbot;

/**
 * Main class of the app, we call to the Function class methods.
 * @author adri
 */
public class TwitterBot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String message = "";
        Function.tweet(message);
        
        Function.getTimeline();
        
        String user = "";
        String privMessage = "";
        Function.directMessage(user, privMessage);
    }
    
}
