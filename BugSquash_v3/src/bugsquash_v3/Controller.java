/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugsquash_v3;

import java.awt.Desktop;
import java.io.IOException;

/**
 *
 * @author clear
 */
public class Controller {

    View titleScreenUI;
    View showInstructions;
    View newGame;

    public Controller() {
        titleScreenUI = new View(this);
        titleScreenUI.setVisible(true);
    }
    protected void showInstructions() {
        try {
            Desktop.getDesktop().open(new java.io.File("src/bugsquash_v3/items/BugSquash_Instructions.pdf"));
        } catch (IOException e) {
        }
    }
    protected void newGame(String size) {
        GameView secondFrame = new GameView(titleScreenUI);
        System.out.println(size);
}
}
