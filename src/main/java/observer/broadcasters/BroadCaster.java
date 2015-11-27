package observer.broadcasters;

import observer.Post;

/**
 * Created by Jeka on 26/09/2015.
 */
public interface BroadCaster {
    void publish(Post post);
}
