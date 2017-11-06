/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoavl;

import java.io.IOException;
import proyectoavl.controller.Controller;
import proyectoavl.model.Book;

/**
 *
 * @author cristian
 */
public class ProyectoAVL {

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        Controller ctl = new Controller(); 
                        
        ctl.printNivels();
    }
}
