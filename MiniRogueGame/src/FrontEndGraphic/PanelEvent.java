/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEndGraphic;

import MR_Game_Logic.Card;
import MR_Game_Logic.ObservableGame;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nuno
 */
public class PanelEvent extends JPanel implements Observer{

    
   
    private ObservableGame game;
    private ImageIcon imageIcon;
    private JLabel  jLabel;

    

    public PanelEvent(ObservableGame g){
        game = g;
        setup();
        game.addObserver(this); 
    }
    @Override
    public void update(Observable o, Object o1) {
        Image();
    }

    private void setup() {
        imageIcon = new ImageIcon(getClass().getResource("\\backcard.jpg"));
        jLabel = new JLabel(imageIcon);
        add(jLabel);
        
    }
    
    private void Image(){
       
    }
    
    
}
