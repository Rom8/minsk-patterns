package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeka on 27/09/2015.
 */
public class AbstractContainer extends AbstractComponent implements Container{

    private List<Component> components = new ArrayList<>();

    public AbstractContainer(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        int total = super.getPrice();
        for (Component component : components) {
            total += component.getPrice();
        }
        return total;

    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

}
