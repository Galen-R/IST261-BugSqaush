/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugsquash_v3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.io.InputStream;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class View extends JFrame{
    private JPanel titlePanel;
    private JPanel buttonPanel;
    private JPanel topButtonPanel;
    private JPanel musicButtonPanel;
    private Stage primaryStage;
    int index = 0;
    int currentValue = 0;
    int locationInArray = 0;
    JComboBox gridSizeBox;
    private final Controller bugControl;


    public View(Controller bugControl2) {
        this.bugControl = bugControl2;

        criterParts();
    }

    protected void criterParts() {
        setTitle("Bug Squash");
        setResizable(false);
        setSize(425, 350);
        setLocationRelativeTo(null);  // center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        topButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        musicButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JLabel title = new JLabel();
        title.setIcon(new ImageIcon(getClass().getResource("/bugsquash_v3/items/TitleImage.png")));
        
        JButton newGameButton = new JButton("New Game");
        
        String size[] = {"newGame", "easy", "medium", "hard"};// array of string contating grid size 
        gridSizeBox = new JComboBox(size); // create checkbox 
        gridSizeBox.setSelectedIndex(0);
            
        JButton instructionButton = new JButton("Instructions");
        
        JToggleButton musicButton = new JToggleButton(new ImageIcon(getClass().getResource("/bugsquash_v3/items/VolumeOn(Small).png")));
        musicButton.setOpaque(false);
        musicButton.setContentAreaFilled(false);
        musicButton.setBorderPainted(false);

        try {

            InputStream inputStream = getClass().getResourceAsStream("/bugsquash_v3/items/TitleMusicWAV.wav");
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Audio file not found!");
        }

        titlePanel.add(title);
        buttonPanel.add(instructionButton);
        buttonPanel.add(newGameButton);
        buttonPanel.add(gridSizeBox);
        topButtonPanel.add(musicButton);

        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(topButtonPanel, BorderLayout.NORTH);
        getContentPane().add(titlePanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        instructionButton.addActionListener(event -> bugControl.showInstructions());
        newGameButton.addActionListener(event -> bugControl.newGame(gridSizeBox.getSelectedItem().toString()));
        
        
    }
    
}

