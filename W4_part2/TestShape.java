package W4_part2;

public class TestShape {
    public static void main(String[] args) {

        Shape s1 = new Shape("blue", false);
        System.out.println(s1.toString());
        
        Circle c1 = new Circle(5.5, "red", true);
        System.out.println(c1.toString());
        System.out.println("Circle Area: " + c1.getArea());
        
        Rectangle r1 = new Rectangle(3.0, 4.0, "yellow", false);
        System.out.println(r1.toString());
        System.out.println("Rectangle Perimeter: " + r1.getPerimeter());
        
        Square sq1 = new Square(4.0, "black", true);
        System.out.println(sq1.toString());
        
        sq1.setLength(7.0); 
        System.out.println("Setelah setLength(7.0):");
        System.out.println("Square Width: " + sq1.getWidth());
        System.out.println("Square Length: " + sq1.getLength());
        System.out.println(sq1.toString());
    }
}