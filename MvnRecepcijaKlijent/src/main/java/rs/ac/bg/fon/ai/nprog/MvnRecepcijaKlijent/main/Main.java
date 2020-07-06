/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.main;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.forme.LoginForma;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.kontroler.Kontroler;

/**
 *
 * @author Jelena Sreckovic
 */
public class Main {
    public static void main(String[] args) {
        Kontroler.getInstanca().poveziSE();
        Kontroler.getInstanca().pokreni();
    }
}
