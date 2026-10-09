package W5.Interface;

public class GoodsDriver {
    public static void main(String[] args) {
        Food apple = new Food("Apple", 1.5, 95);
        Toy actionFigure = new Toy("Action Figure", 15.0, 5);
        Book javaBook = new Book("Java Programming", 45.0, "John Doe");

        System.out.println("--- Food Info ---");
        apple.display();
        
        System.out.println("\n--- Toy Info ---");
        actionFigure.display();
        
        System.out.println("\n--- Book Info ---");
        javaBook.display();
    }
}