/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoavl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import proyectoavl.model.Book;
import proyectoavl.model.controller.Controller;

/**
 *
 * @author cristian
 */
public class ProyectoAVL {

    public static void main(String[] args) throws UnsupportedEncodingException, IOException {

        Controller ctl = new Controller();

        Random rnd = new Random();

        ctl.add(new Book("La Ilíada", "3010", "Homero", "Bachillerato",
                rnd.nextInt(3) + 1));

        ctl.add(new Book("Don Quijote", "3011", "Cervantes", "Novela",
                rnd.nextInt(3) + 1));
        ctl.add(new Book("Don Quijote", "3012", "Cervantes", "Novela",
                rnd.nextInt(3) + 1));
        ctl.add(new Book("Don Quijote", "3013", "Cervantes", "Novela",
                rnd.nextInt(3) + 1));
        ctl.add(new Book("Don Quijote", "3014", "Cervantes", "Novela",
                rnd.nextInt(3) + 1));
        ctl.add(new Book("Don Quijote", "3015", "Cervantes", "Novela",
                rnd.nextInt(3) + 1));
        ctl.add(new Book("Don Quijote", "3016", "Cervantes", "Novela",
                rnd.nextInt(3) + 1));

    }
}
