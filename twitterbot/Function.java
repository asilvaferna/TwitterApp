package twitterbot;

import java.util.List;
import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * This class is related to all the functionalities of the app.
 * @author adri
 */
public class Function {

    private static final Twitter twitter = TwitterFactory.getSingleton();

    /**
     * Publish a tweet with a certain 'latestStatus' message.
     * @param latestStatus
     */
    public static void tweet(String latestStatus) {

        try {
            Status status = twitter.updateStatus(latestStatus);

            System.out.println("Cambiado el estado satisfactoriamente [" + status.getText() + "].");
        } catch (TwitterException ex) {
            System.out.println("Error al actualizar el estado");
        }

    }
    
    /**
     * Gets the timeline of the user.
     */

    public static void getTimeline() {

        try {
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Timeline: ");
            // functional for each
            statuses.stream().forEach((status) -> {
                System.out.println(status.getUser().getName() + ":" + status.getText());
            });
        } catch (TwitterException ex) {
            System.out.println("Timeline no disponible");
        }

    }

    /**
     * Sends a direct message 'content' to a user 'recipientId'.
     * @param recipientId
     * @param content 
     */
    
    public static void directMessage(String recipientId, String content) {

        try {
            DirectMessage message = twitter.sendDirectMessage(recipientId, content);

            System.out.println("Enviado: " + message.getText() + " to @" + message.getRecipientScreenName());
        } catch (TwitterException ex) {
            System.out.println("No se pudo enviar el mensaje");
        }

    }

}
