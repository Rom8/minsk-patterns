package observer.subscribers;

import observer.Post;

/**
 * Created by Jeka on 26/09/2015.
 */
public interface Subscriber {
    void notify(Post post);
}
