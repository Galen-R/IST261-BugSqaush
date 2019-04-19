/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugsquash_v3;

import javax.swing.JButton;

/**
 *
 * @author clear
 */
public class Card extends JButton{
    private int id;
    private boolean matched = false;


    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }


    public void setMatched(boolean matched){
        this.matched = matched;
    }

    public boolean getMatched(){
        return this.matched;
    }
}
