/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoavl;

import proyectoavl.model.AVLTree;
import proyectoavl.model.Book;

/**
 *
 * @author cristian
 */
public class ProyectoAVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        AVLTree<String> tree = new AVLTree<>();
        for (int i = 1; i <= 7; i++) {
            tree.insert(String.valueOf(new Book("Name", "Code", "Author", "Description", i)));
            System.err.println(i);
        }

        tree.PrintTree();
        }
}
