package observer;

import factory.ObjectFactory;
import observer.subscribers.AndreySubscriber;
import observer.subscribers.YanaSubscriber;

/**
 * Created by Jeka on 26/09/2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BlogEngine blogEngine = ObjectFactory.getInstance().createObject(BlogEngine.class);
        YanaSubscriber yanaSubscriber = new YanaSubscriber();
        AndreySubscriber andreySubscriber = new AndreySubscriber();
        blogEngine.addSubscriber(yanaSubscriber);
        blogEngine.addSubscriber(andreySubscriber);
        Post post = new Post(new Author("Putin"), "Rubl will be 1:30");
        blogEngine.publishPost(post);
    }
}
