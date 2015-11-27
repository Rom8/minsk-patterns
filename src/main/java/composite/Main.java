package composite;

/**
 * Created by Jeka on 27/09/2015.
 */
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(10);
        Book book2 = new Book(20);
        Shelf shelf = new Shelf(100);
        shelf.add(book1);
        shelf.add(book2);
        Cupboard cupboard = new Cupboard(1000);
        cupboard.add(shelf);
        Room room = new Room(10000);
        room.add(cupboard);
        System.out.println(shelf.getPrice());

    }
}
