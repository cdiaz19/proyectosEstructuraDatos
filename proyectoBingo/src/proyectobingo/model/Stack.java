/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobingo.model;

/**
 *
 * @author cristian
 * @param <T>
 */
public class Stack<T> {

    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    public void push(int element) {
        Node<T> newTop = new Node(null, null, null, null, top, null, null,
                null, element);
        top = newTop;
    }

    public int pop() {
        Node<T> aux;
        int numOut;

        if (top == null) {
            return -1;
        } else {
            aux = top;
            numOut = top.getData();
            top = aux.getDown();
            aux = null;
            return numOut;
        }
    }

    public String printPila() {
        Node<T> current = top;
        String stack;
        if (top == null) {
            return "Pila empty";
        } else {
            stack = "Numeros que han salido \n";
            while (current != null) {
                stack += current.getData() + "\n";
                current = current.getDown();
            }
        }
        return stack;
    }

    public Boolean existElement(int number) {
        Node<T> current = top;
        if (top == null) {
            return false;
        } else {
            while (current != null && number != current.getData()) {
                current = current.getDown();
            }

            return (current == null) ? false : true;
        }
    }
}
