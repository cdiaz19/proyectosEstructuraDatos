/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoavl.controller;

import proyectoavl.model.Book;
import proyectoavl.model.Model;
import proyectoavl.model.Node;

/**
 *
 * @author cristian
 */
public class Controller {

    Model model = new Model();

    public Controller() {
        this.model = model;
    }

    public void add(Book book) {
        model.addAVL(book);
    }
    
    public void searchByCode(String Code) {
        model.searchByCode(Code);
    }
    
    public void completeTree() {
        model.complete();
    }

    public void perfectTree() {
        model.perfect();
    }
    
    public void emptyTree() {
        model.emptyTree();
    }
    
    public void printNivels() {
        model.printNivels();
    }

    public int treeWeight() {
        return model.treeWeight();
    }

    public void heightTree() {
        model.height();
    }

}
