/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobingo.model;

import java.util.ArrayList;

/**
 *
 * @author cristian
 */
public class Player {

    private int id;
    private ArrayList<ListBoard> boards = new ArrayList();

    /**
     *
     */
    public Player(int id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param boards
     */
    public Player(int id, ArrayList<ListBoard> boards) {
        this.id = id;
        this.boards = boards;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the boards
     */
    public ArrayList<ListBoard> getBoards() {
        return boards;
    }

    /**
     * @param boards the boards to set
     */
    public void setBoards(ArrayList<ListBoard> boards) {
        this.boards = boards;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String str = "Jugador #" + getId()
                + "\nTableros del Jugador \n";
        return str;
    }

    /**
     * Information for HTML
     */
    public void information() {
        System.out.print(toString());

        getBoards().forEach((lb) -> {
            System.out.println(lb.printBoard());
        });
    }
}
