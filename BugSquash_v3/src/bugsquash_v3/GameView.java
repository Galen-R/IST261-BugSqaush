/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugsquash_v3;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author clear
 */

public class GameView extends JFrame{

    View bugSquashView;
    
    

   
    public GameView (View passedVar) {
        
        GameBoard b = new GameBoard(passedVar);
        b.setPreferredSize(new Dimension(1200,600));
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.setResizable(false);
        b.pack();
        b.setVisible(true);
       
        
       
    }
}
