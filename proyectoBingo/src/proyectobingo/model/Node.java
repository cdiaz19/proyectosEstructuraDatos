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
public class Node<T> {

    private int data;
    private Node<T> next;
    private Node<T> prev;
    private Node<T> topRight;
    private Node<T> topleft;
    private Node<T> bottomRight;
    private Node<T> bottomLeft;
    private Node<T> up;
    private Node<T> down;
    private Boolean state;

    public Node(Node<T> up, Node<T> topRight, Node<T> next, Node<T> bottomRight, 
            Node<T> down, Node<T> bottomLeft, Node<T> prev, Node<T> topLeft, int data) {
        this.data = data;

        this.next = next;
        this.prev = prev;
        this.topRight = topRight;
        this.topleft = topleft;
        this.bottomRight = bottomRight;
        this.bottomLeft = bottomLeft;
        this.up = up;
        this.down = down;
        
        this.state = false;

    }

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the next
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * @return the prev
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * @param prev the prev to set
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * @return the topRight
     */
    public Node<T> getTopRight() {
        return topRight;
    }

    /**
     * @param topRight the topRight to set
     */
    public void setTopRight(Node<T> topRight) {
        this.topRight = topRight;
    }

    /**
     * @return the topleft
     */
    public Node<T> getTopleft() {
        return topleft;
    }

    /**
     * @param topleft the topleft to set
     */
    public void setTopleft(Node<T> topleft) {
        this.topleft = topleft;
    }

    /**
     * @return the bottomRight
     */
    public Node<T> getBottomRight() {
        return bottomRight;
    }

    /**
     * @param bottomRight the bottomRight to set
     */
    public void setBottomRight(Node<T> bottomRight) {
        this.bottomRight = bottomRight;
    }

    /**
     * @return the bottomLeft
     */
    public Node<T> getBottomLeft() {
        return bottomLeft;
    }

    /**
     * @param bottomLeft the bottomLeft to set
     */
    public void setBottomLeft(Node<T> bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    /**
     * @return the up
     */
    public Node<T> getUp() {
        return up;
    }

    /**
     * @param up the up to set
     */
    public void setUp(Node<T> up) {
        this.up = up;
    }

    /**
     * @return the down
     */
    public Node<T> getDown() {
        return down;
    }

    /**
     * @param down the down to set
     */
    public void setDown(Node<T> down) {
        this.down = down;
    }

    /**
     * @return the state
     */
    public Boolean getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(Boolean state) {
        this.state = state;
    }
}
