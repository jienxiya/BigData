/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monggoDB;

/**
 *
 * @author pallerma_sd2082
 */
public class Main {

    public static void main(String args[]) {
        WithoutConnection wayKoneksyon = new WithoutConnection();
//        wayKoneksyon.insertNumbers();
//        wayKoneksyon.delete();
//        wayKoneksyon.getAVGPerColumn();
        wayKoneksyon.getAVGInternalFunction();

        WithConnection konek = new WithConnection();
//        konek.insertNumbers();
//        konek.delete();
    }
}
