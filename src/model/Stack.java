package model;

public class Stack<T> {
    
    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(T data) {
        Node<T> element = new Node<>(data);
        element.setNext(top);
        top = element;
        size++;
    }

    public T pop() {
        Node<T> trash = top;
        top = top.next();
        size--;
        return trash.data();
    }

    public T top() {
        return top.data();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> head = top;
        sb.append("(");
        String prefix = "";
        while (head != null) {
            sb.append(prefix).append(head.data());
            prefix = ", ";
            head = head.next();
        }
        sb.append(")");
        return sb.toString();
    }

    public Stack<T> reverse() {
        Stack<T> reversed = new Stack<>();
        while (!isEmpty()) {
            reversed.push(pop());
        }
        return reversed;
    }
}
