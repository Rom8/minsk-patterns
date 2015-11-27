package observer;

import factory.annotations.Inject;
import observer.broadcasters.BroadCaster;
import observer.subscribers.Subscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeka on 26/09/2015.
 */
public class BlogEngine {
    @Inject
    private BroadCaster broadCaster;

    private List<Subscriber> subscribers = new ArrayList<>();


    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void publishPost(Post post) {
        broadCaster.publish(post);
        for (Subscriber subscriber : subscribers) {
            try {
                subscriber.notify(post);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
