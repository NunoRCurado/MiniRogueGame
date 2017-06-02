/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEndGraphic;

import MR_Game_Logic.ObservableGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Nuno
 */
public class PanelCartasEventos extends JPanel implements Observer {


    private ObservableGame game;
    private JButton button = new JButton("Select");
    private JButton button1 = new JButton("Select");
    private JButton button2= new JButton("Select");
    private JButton button3= new JButton("Select");
    private JButton button4= new JButton("Select");
    private JButton button5= new JButton("Select");
    private JButton button6= new JButton("Select");
    private ImageIcon imageIcon;
    private ImageIcon imageIcon1;
    private JLabel  jLabel;
    private JLabel  jLabel1;
    private JLabel  jLabel2;
    private JLabel  jLabel3;
    private JLabel  jLabel4;
    private JLabel  jLabel5;
    private JLabel  jLabel6;
    
    
    
    public PanelCartasEventos(ObservableGame g){
        
        game= g;
        setup();
        game.addObserver(this); 
    }
   
    @Override
    public void update(Observable o, Object o1) {
       
    }

    public void drawEventosStandard(){
       
        
        imageIcon = new ImageIcon(getClass().getResource("\\backCard.jpg"));
        imageIcon1 = new ImageIcon(getClass().getResource("\\bossmonster.jpg"));
      
        jLabel = new JLabel(imageIcon);
        jLabel1 = new JLabel(imageIcon);
        jLabel2 = new JLabel(imageIcon);
        jLabel3 = new JLabel(imageIcon);
        jLabel4 = new JLabel(imageIcon);
        jLabel5 = new JLabel(imageIcon);
        jLabel6 = new JLabel(imageIcon1);
        
    }
    private void setup() {
    
        
        
        drawEventosStandard();
        
        
        setLayout(new GridBagLayout());
        GridBagConstraints gridBag=new GridBagConstraints();
        gridBag.fill=GridBagConstraints.BOTH;
       
        
       
        
        //1
        
        gridBag.anchor=GridBagConstraints.SOUTH;
        gridBag.gridx=0;
        gridBag.gridy=2;
        add(jLabel,gridBag);
        
        gridBag.anchor=GridBagConstraints.NORTH;
        gridBag.gridx=0;
        gridBag.gridy=3;
        gridBag.fill=GridBagConstraints.HORIZONTAL;
        add(button,gridBag);
        
    
        //2
     
        gridBag.anchor=GridBagConstraints.SOUTH;
        gridBag.gridx=1;
        gridBag.gridy=1;
        add(jLabel1,gridBag);
        
        
        gridBag.anchor=GridBagConstraints.NORTH;
        gridBag.gridx=1;
        gridBag.gridy=2;
        add(button1,gridBag);
        
        gridBag.anchor=GridBagConstraints.SOUTH;
        gridBag.gridx=1;
        gridBag.gridy=3;
        add(jLabel2,gridBag);
        
        gridBag.anchor=GridBagConstraints.NORTH;
        gridBag.gridx=1;
        gridBag.gridy=4;
        add(button2,gridBag);
        //3
        gridBag.anchor=GridBagConstraints.SOUTH;
        gridBag.gridx=2;
        gridBag.gridy=2;
        add(jLabel3,gridBag);
        
        gridBag.anchor=GridBagConstraints.NORTH;
        gridBag.gridx=2;
        gridBag.gridy=3;
        add(button3,gridBag);
        //4
        gridBag.anchor=GridBagConstraints.SOUTH;
        gridBag.gridx=3;
        gridBag.gridy=1;
        add(jLabel4,gridBag);
        
        gridBag.anchor=GridBagConstraints.NORTH;
        gridBag.gridx=3;
        gridBag.gridy=2;
        add(button4,gridBag);
        
        gridBag.anchor=GridBagConstraints.SOUTH;
        gridBag.gridx=3;
        gridBag.gridy=3;
        add(jLabel5,gridBag);
        
        gridBag.anchor=GridBagConstraints.NORTH;
        gridBag.gridx=3;
        gridBag.gridy=4;
        add(button5,gridBag);
        //5
        
        gridBag.anchor=GridBagConstraints.SOUTH;
        gridBag.gridx=4;
        gridBag.gridy=2;
        add(jLabel6,gridBag);
      
        gridBag.anchor=GridBagConstraints.NORTH;
        gridBag.gridx=4;
        gridBag.gridy=3;
        add(button6,gridBag);
   }

    
    
}
