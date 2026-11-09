package W10.Task2; 

import java.util.ArrayList;

public class GenericStack<T> { 
    private int maxsize;
    private ArrayList<T> items;

    public GenericStack(int maxsize) {
        if (maxsize <= 0) {
            throw new ArrayStackException("Stack size must be positive");
        }
        this.maxsize = maxsize;
        this.items = new ArrayList<>(maxsize);
    }

    public void push(T item) {
        if (items.size() == maxsize) {
            throw new ArrayStackException("Overflow Error: Stack penuh!");
        }
        items.add(item); 
    }

    public T pop() {
        if (isEmpty()) {
            throw new ArrayStackException("Underflow Error: Stack kosong!");
        }
        return items.remove(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public static class ArrayStackException extends RuntimeException {
        public ArrayStackException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>(3);
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        

        System.out.println("=== Hasil Pop dari Stack (LIFO) ===");
        System.out.println(stack.pop()); // Harus mencetak 3
        System.out.println(stack.pop()); // Harus mencetak 2
        System.out.println(stack.pop()); // Harus mencetak 1
        
    }
}