/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobingo.controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import proyectobingo.model.ListBoard;
import proyectobingo.model.Player;
import proyectobingo.model.Stack;

/**
 *
 * @author cristian
 */
public class Controller {

    private ArrayList<ListBoard> boards;
    private Stack stack = new Stack();
    private Player player;

    /**
     *
     */
    public Controller() {
        initialGame();
    }

    /**
     * 
     */
    public void initialGame() {
        Scanner sc = new Scanner(System.in);
        int nP, nB;
        System.out.print("Introduzca un número Jugadores: ");
        nP = sc.nextInt();
        System.out.print("Introduzca un número Cartones/Jugador: ");
        nB = sc.nextInt();

        createGame(nP, nB);
        //gameStack();
    }
    
    /**
     * 
     * @param numberPlayer
     * @param numberBoard 
     */
    public void createGame(int numberPlayer, int numberBoard) {
        int x = 0;

        while (x < numberPlayer) {
            boards = new ArrayList();

            for (int i = 0; i < numberBoard; i++) {
                ListBoard board = new ListBoard();
                boards.add(board);
            }
            player = new Player(x, boards);   
            player.information();
            x++;
        }
    }

    /**
     *
     */
    public void gameStack() {
        int x = 5;

        //ESTO HAY QUE CAMBIARLO
        while (x > 0) {
            int y = generateNumber();
            if (!stack.existElement(y)) {
                stack.push(y);
            }
            x--;
        }

        System.err.println(stack.printPila());
    }

    /**
     *
     * @return number to Stack
     */
    public int generateNumber() {
        Random rand = new Random();
        return (rand.nextInt(75));
    }
}
