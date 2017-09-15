/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobingo.model;

import java.util.Random;

/**
 *
 * @author cristian
 * @param <T>
 */
public final class ListBoard<T> {

    private Node<T> root;

    public ListBoard() {
        root = null;
        generateBoard();
        //System.out.println(printBoard());
    }

    /**
     * 
     * @param current
     * @param number
     * @param isMax 
     */
    public void bindNodesB(Node<T> current, int number, Boolean isMax) {
        Node<T> newNode;
        int aux = current.getData();

        newNode = new Node<T>(current, null, null, null, current.getDown(), null,
                null, null, number);

        if (current.getDown() != null) {
            current.getDown().setUp(newNode);
        }
        current.setDown(newNode);

        if (isMax == true) {
            current.setData(newNode.getData());
            newNode.setData(aux);
        }
    }

    /**
     * 
     * @param currentColumThis
     * @param currentColumPrev
     * @param number
     * @param isMax 
     */
    public void bindNodesINGO(Node<T> currentColumThis, Node<T> currentColumPrev,
            int number, Boolean isMax) {
        Node<T> newNode;
        int aux = currentColumThis.getData();
        newNode = new Node<T>(currentColumThis, null, null, null, currentColumThis.getDown(),
                currentColumPrev.getDown().getDown(), currentColumPrev.getDown(),
                currentColumPrev, number);

        if (currentColumThis.getDown() != null) {
            currentColumThis.getDown().setUp(newNode);
        }
        currentColumThis.setDown(newNode);
        currentColumPrev.setBottomRight(newNode);
        currentColumPrev.getDown().setNext(newNode);
        currentColumPrev.getDown().setBottomRight(newNode.getDown());

        if (currentColumPrev.getDown().getDown() != null) {
            currentColumPrev.getDown().getDown().setTopRight(newNode);
        }

        if (isMax == true && newNode.getDown() == null) {
            currentColumThis.setData(newNode.getData());
            newNode.setData(aux);
        } else if (isMax == true && newNode.getDown() != null) {
            currentColumThis.setData(newNode.getData());
            newNode.setData(aux);
            newNode.getDown().setTopleft(newNode.getPrev());
            newNode.getDown().setPrev(newNode.getBottomLeft());
            newNode.getDown().setBottomLeft(newNode.getBottomLeft().getDown());
            newNode.getPrev().setBottomRight(newNode.getDown());
            newNode.getBottomLeft().setNext(newNode.getDown());

            if (newNode.getBottomLeft().getDown() != null) {
                newNode.getBottomLeft().getDown().setTopRight(newNode.getDown());
            }
        }
    }

    /**
     * 
     * @param number 
     */
    public void addElementsB(int number) {
        Node<T> current = root;

        if (root == null) {
            root = new Node<T>(root, root, root, root, root, root, root, root, number);
        } else {
            while (current.getDown() != null && current.getData() < number) {
                current = current.getDown();
            }

            if (current.getDown() != null && !(current.getData() < number)) {
                bindNodesB(current, number, true);
            } else if (current.getDown() == null && current.getData() < number) {
                bindNodesB(current, number, false);
            } else {
                bindNodesB(current, number, true);
            }
        }
    }

    /**
     * 
     * @param number
     * @param firstPrev 
     */
    public void addElementsINGO(int number, Node<T> firstPrev) {
        Node<T> currentPrev = firstPrev;
        Node<T> firstThis = firstPrev.getNext();
        Node<T> currentThis = firstThis;

        if (firstThis == null) {
            firstThis = new Node(firstThis, firstThis, firstThis, firstThis, firstThis,
                    firstPrev.getDown(), firstPrev, firstThis, number);
            firstPrev.setNext(firstThis);
            firstPrev.getDown().setTopRight(firstThis);
        } else {
            while (currentThis.getDown() != null && currentThis.getData() < number) {
                currentPrev = currentPrev.getDown();
                currentThis = currentThis.getDown();
            }

            if (currentThis.getDown() != null && !(currentThis.getData() < number)) {
                bindNodesINGO(currentThis, currentPrev, number, true);
            } else if (currentThis.getDown() == null && currentThis.getData() < number) {
                bindNodesINGO(currentThis, currentPrev, number, false);
            } else {
                bindNodesINGO(currentThis, currentPrev, number, true);
            }
        }
    }

    /**
     * 
     * @param innerLimit
     * @return 
     */
    public int generateNumber(int innerLimit) {
        Random rand = new Random();
        return innerLimit + (rand.nextInt(15));
    }

    /**
     * 
     * @param number
     * @return 
     */
    public Boolean existNumberB(int number) {
        Node<T> current = root;
        if (root == null) {
            return false;
        } else {
            while (current.getDown() != null && current.getData() != number) {
                current = current.getDown();
            }
            if (current.getData() == number) {
                if (current.getNext() != null) {
                    current.setState(true);
                }
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 
     * @param number
     * @param firstPrev
     * @return 
     */
    public Boolean existNumberINGO(int number, Node<T> firstPrev) {
        Node<T> firstThis = firstPrev.getNext();
        Node<T> current = firstThis;

        if (firstThis == null) {
            return false;
        } else {
            while (current.getDown() != null && current.getData() != number) {
                current = current.getDown();
            }

            if (current.getData() == number) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Generate number in board
     */
    public void generateBoard() {
        Node<T> firstI = null;
        Node<T> firstN = null;
        Node<T> firstG = null;
        Node<T> firstO = null;
        int x = 0;

        //Generate and Insert number in Column B
        for (int i = 0; i < 5; i++) {
            x = generateNumber(1);
            while (existNumberB(x)) {
                x = generateNumber(1);
            }
            addElementsB(x);
        }

        //Generate and Insert number in Column I
        for (int i = 0; i < 5; i++) {
            x = generateNumber(16);
            while (existNumberINGO(x, root) == true) {
                x = generateNumber(16);
            }
            addElementsINGO(x, root);
        }

        //Generate and Insert number in Column N
        firstI = root.getNext();
        for (int i = 0; i < 5; i++) {
            x = generateNumber(31);
            while (existNumberINGO(x, firstI)) {
                x = generateNumber(31);
            }
            addElementsINGO(x, firstI);
        }

        //Generate and Insert number in Column G
        firstN = firstI.getNext();
        for (int i = 0; i < 5; i++) {
            x = generateNumber(46);
            while (existNumberINGO(x, firstN)) {
                x = generateNumber(46);
            }
            addElementsINGO(x, firstN);
        }

        //Generate and Insert number in Column O
        firstG = firstN.getNext();
        for (int i = 0; i < 5; i++) {
            x = generateNumber(61);
            while (existNumberINGO(x, firstG)) {
                x = generateNumber(61);
            }
            addElementsINGO(x, firstG);
        }
    }

    /**
     * 
     * @param firstThis 
     */
    public void sort(Node<T> firstThis) {
        Node<T> current = firstThis;
        int aux = 0;
    }

    /**
     * 
     * @return print board
     */
    public String printBoard() {
        Node<T> firstI = root.getNext();
        Node<T> firstN = firstI.getNext();
        Node<T> firstG = firstN.getNext();
        Node<T> firstO = firstG.getNext();
        Node<T> currentB = root;
        Node<T> currentI = firstI;
        Node<T> currentN = firstN;
        Node<T> currentG = firstG;
        Node<T> currentO = firstO;

        if (root == null) {
            return "Board Empty";
        } else {
            String board
                    = "----------------- \n"
                    + "B   I   N   G   O \n";
            while (currentB != null) {
                board += currentB.getData() + "  "
                        + currentI.getData() + "  "
                        + currentN.getData() + "  "
                        + currentG.getData() + "  "
                        + currentO.getData() + "  "
                        + "\n";

                currentB = currentB.getDown();
                currentI = currentI.getDown();
                currentN = currentN.getDown();
                currentG = currentG.getDown();
                currentO = currentO.getDown();
            }

            return board;
        }
    }
}
