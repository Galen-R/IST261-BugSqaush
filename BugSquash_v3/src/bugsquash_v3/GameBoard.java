/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugsquash_v3;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JFrame {

    
    private final List<Card> cards;
    private Card selectedCard;
    private Card c1;
    private Card c2;
    private final Timer t;
    View  bugControl;
    JLabel points;
    int score = 0;
    
    public GameBoard(View passedVar) {
        //int pairs = 6;
        bugControl = passedVar;
        List<Card> cardsList = new ArrayList<>();
        List<Integer> cardVals = new ArrayList<>();
        

        switch (bugControl.gridSizeBox.getSelectedItem().toString()) {
//Easy            
            case "easy":
                for (int i = 0; i < 8; i++) {
                    cardVals.add(i);
                    cardVals.add(i);
                }
                Collections.shuffle(cardVals);

        for (int val : cardVals) {
            Card c = new Card();
            c.setIcon(new ImageIcon(getClass().getResource("/bugsquash_v3/items/CardBack(Small)biggestest.png")));
            c.setOpaque(false);
            c.setContentAreaFilled(false);
            c.setBorderPainted(false);
            c.setId(val);
            c.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    selectedCard = c;
                    doTurn();
                }
            });
            cardsList.add(c);
        }
                break;
//Medium
            case "Medium":
                for (int i = 0; i < 12; i++) {
                    cardVals.add(i);
                    cardVals.add(i);
                }
                Collections.shuffle(cardVals);

        for (int val : cardVals) {
            Card c = new Card();
            c.setIcon(new ImageIcon(getClass().getResource("/bugsquash_v3/items/CardBack(Small)biggestest.png")));
            c.setOpaque(false);
            c.setContentAreaFilled(false);
            c.setBorderPainted(false);
            c.setId(val);
            c.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    selectedCard = c;
                    doTurn();
                }
            });
            cardsList.add(c);
        }
                break;
//Hard                
            case "Hard":
                for (int i = 0; i < 20; i++) {
                    cardVals.add(i);
                    cardVals.add(i);
                }
                break;
//default
            default:
                for (int i = 0; i < 14; i++) {
                    cardVals.add(i);
                    cardVals.add(i);
                }
                Collections.shuffle(cardVals);

        for (int val : cardVals) {
            Card c = new Card();
            c.setIcon(new ImageIcon(getClass().getResource("/bugsquash_v3/items/CardBack(Small)biggestest.png")));
            c.setOpaque(false);
            c.setContentAreaFilled(false);
            c.setBorderPainted(false);
            c.setId(val);
            c.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    selectedCard = c;
                    doTurn();
                }
            });
            cardsList.add(c);
        }
                break;
        }
        
        this.cards = cardsList;
        //set up the timer
        t = new Timer(550, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                checkCards();
            }
        });

        t.setRepeats(false);

        //set up the board itself
        Container pane = getContentPane();
  
        points = new JLabel("Points: 0");  
       
        pane.add(points);
        
        pane.setLayout(new GridLayout(4, 4));
        for (Card c : cards) {
            pane.add(c);
        }
        setTitle("Bug Squash");
    } 

    public void doTurn() {
        if (c1 == null && c2 == null) {
            c1 = selectedCard;
            c1.setText(String.valueOf(c1.getId()));
        }

        if (c1 != null && c1 != selectedCard && c2 == null) {
            c2 = selectedCard;
            c2.setText(String.valueOf(c2.getId()));
            t.start();

        }
    }

    public void checkCards() {
        if (c1.getId() == c2.getId()) {//match condition
            c1.setEnabled(false); //disables the button
            c2.setEnabled(false);
            c1.setMatched(true); //flags the button as having been matched
            score++;
            points.setText("Score: " + score);
            c2.setMatched(true);
            if (this.isGameWon()) {
                JOptionPane.showMessageDialog(this, "You won with: " + score + " points");
                System.exit(0);
            }
        } else {
            c1.setText(""); //'hides' text
            c2.setText("");
        }
        c1 = null; //reset c1 and c2
        c2 = null;
    }

    public boolean isGameWon() {
        for (Card c : this.cards) {
            if (c.getMatched() == false) {
                return false;
            }
        }
        return true;
    }
    
}
