package composite;

/**
 * Created by Jeka on 27/09/2015.
 */
public abstract class AbstractComponent implements Component {

    private final int price;

    public AbstractComponent(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
