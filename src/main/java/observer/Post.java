package observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by Jeka on 26/09/2015.
 */
@Data
@AllArgsConstructor
public class Post {
    private Author author;
    private String message;

}
