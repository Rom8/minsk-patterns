package observer.subscribers;

import observer.Post;

/**
 * Created by Jeka on 26/09/2015.
 */
public class AndreySubscriber implements Subscriber {
    @Override
    public void notify(Post post) {
        System.out.println(post.getAuthor().getName()+" sucks!");
    }
}
