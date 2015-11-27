package observer.broadcasters;

import observer.Post;

/**
 * Created by Jeka on 26/09/2015.
 */
public class FacebookBroadCaster implements BroadCaster {
    @Override
    public void publish(Post post) {
        System.out.println("Facebook publishing new post: "+post);
    }
}
