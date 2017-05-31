/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterbot;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * @author adri
 */
public class Function {

    private static final Twitter twitter = TwitterFactory.getSingleton();

    ;
 
    public static void tweet() {
        try {
            String latestStatus = "Prueba bot 1";
            Status status = twitter.updateStatus(latestStatus);

            System.out.println("Cambiado el estado satisfactoriamente [" + status.getText() + "].");
        } catch (TwitterException ex) {
            System.out.println("Error al actualizar el estado");
        }
    }

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

}
