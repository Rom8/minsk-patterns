package observer.subscribers;

import observer.Post;

/**
 * Created by Jeka on 26/09/2015.
 */
public class YanaSubscriber implements Subscriber {
    @Override
    public void notify(Post post) {
        System.out.println("WOW!!! this is very interesting "+post.getMessage());
        throw new RuntimeException("");
    }
}
