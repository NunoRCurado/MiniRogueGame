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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    
    
    private ImageIcon imageIcon = new ImageIcon(getClass().getResource("\\backCard.jpg"));
    private ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("\\bossmonster.jpg"));
    private ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("\\event.jpg"));
    private ImageIcon imageIcon3 = new ImageIcon(getClass().getResource("\\merchant.jpg"));
    private ImageIcon imageIcon4 = new ImageIcon(getClass().getResource("\\resting.jpg"));
    private ImageIcon imageIcon5 = new ImageIcon(getClass().getResource("\\trap.jpg"));
    private ImageIcon imageIcon6 = new ImageIcon(getClass().getResource("\\treasure.jpg"));
    private ImageIcon imageIcon7 = new ImageIcon(getClass().getResource("\\monster.jpg"));
    
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
        
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String nome;
               int numero;
               nome =  game.getCurrentDeck().get(0).getName();
               numero = drawCard(nome);
               switch(numero){
                   case 7:
                       jLabel.setIcon(imageIcon5);
                       break;
                   case 6:
                       jLabel.setIcon(imageIcon1);
                       break;
                   case 5:
                       jLabel.setIcon(imageIcon7);
                       break;
                   case 4:
                       jLabel.setIcon(imageIcon3);
                       break;
                   case 3:
                       jLabel.setIcon(imageIcon4);
                       break;
                   case 2:
                       jLabel.setIcon(imageIcon2);
                       break;
                   case 1:
                       jLabel.setIcon(imageIcon6);
                       break;
               }
               game.resolveCard(nome);
            }
        
        });
        
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String nome;
               int numero;
               nome =  game.getCurrentDeck().get(1).getName();
               numero = drawCard(nome);
               switch(numero){
                   case 7:
                       jLabel1.setIcon(imageIcon5);
                       break;
                   case 6:
                       jLabel1.setIcon(imageIcon1);
                       break;
                   case 5:
                       jLabel1.setIcon(imageIcon7);
                       break;
                   case 4:
                       jLabel1.setIcon(imageIcon3);
                       break;
                   case 3:
                       jLabel1.setIcon(imageIcon4);
                       break;
                   case 2:
                       jLabel1.setIcon(imageIcon2);
                       break;
                   case 1:
                       jLabel1.setIcon(imageIcon6);
                       break;
               }
               game.resolveCard(nome);
            }
        });
        
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome;
               int numero;
               nome =  game.getCurrentDeck().get(2).getName();
               numero = drawCard(nome);
               switch(numero){
                   case 7:
                       jLabel2.setIcon(imageIcon5);
                       break;
                   case 6:
                       jLabel2.setIcon(imageIcon1);
                       break;
                   case 5:
                       jLabel2.setIcon(imageIcon7);
                       break;
                   case 4:
                       jLabel2.setIcon(imageIcon3);
                       break;
                   case 3:
                       jLabel2.setIcon(imageIcon4);
                       break;
                   case 2:
                       jLabel2.setIcon(imageIcon2);
                       break;
                   case 1:
                       jLabel2.setIcon(imageIcon6);
                       break;
               }
                game.resolveCard(nome);
            }
        });
        
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome;
               int numero;
               nome =  game.getCurrentDeck().get(3).getName();
               numero = drawCard(nome);
               switch(numero){
                   case 7:
                       jLabel3.setIcon(imageIcon5);
                       break;
                   case 6:
                       jLabel3.setIcon(imageIcon1);
                       break;
                   case 5:
                       jLabel3.setIcon(imageIcon7);
                       break;
                   case 4:
                       jLabel3.setIcon(imageIcon3);
                       break;
                   case 3:
                       jLabel3.setIcon(imageIcon4);
                       break;
                   case 2:
                       jLabel3.setIcon(imageIcon2);
                       break;
                   case 1:
                       jLabel3.setIcon(imageIcon6);
                       break;
               }
                game.resolveCard(nome);
            }
        });
        
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome;
               int numero;
               nome =  game.getCurrentDeck().get(4).getName();
               numero = drawCard(nome);
               switch(numero){
                   case 7:
                       jLabel4.setIcon(imageIcon5);
                       break;
                   case 6:
                       jLabel4.setIcon(imageIcon1);
                       break;
                   case 5:
                       jLabel4.setIcon(imageIcon7);
                       break;
                   case 4:
                       jLabel4.setIcon(imageIcon3);
                       break;
                   case 3:
                       jLabel4.setIcon(imageIcon4);
                       break;
                   case 2:
                       jLabel4.setIcon(imageIcon2);
                       break;
                   case 1:
                       jLabel4.setIcon(imageIcon6);
                       break;
               }
                game.resolveCard(nome);
            }
        });
        
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome;
               int numero;
               nome =  game.getCurrentDeck().get(5).getName();
               numero = drawCard(nome);
               switch(numero){
                   case 7:
                       jLabel5.setIcon(imageIcon5);
                       break;
                   case 6:
                       jLabel5.setIcon(imageIcon1);
                       break;
                   case 5:
                       jLabel5.setIcon(imageIcon7);
                       break;
                   case 4:
                       jLabel5.setIcon(imageIcon3);
                       break;
                   case 3:
                       jLabel5.setIcon(imageIcon4);
                       break;
                   case 2:
                       jLabel5.setIcon(imageIcon2);
                       break;
                   case 1:
                       jLabel5.setIcon(imageIcon6);
                       break;
               }
                game.resolveCard(nome);
            }
        });
        
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String nome;
              
               nome =  game.getCurrentDeck().get(6).getName();
               jLabel6.setIcon(imageIcon1);
               game.resolveCard(nome);
            }
        });
    }
   
    @Override
    public void update(Observable o, Object o1) {
       
    }

    public void drawEventosStandard(){
        
        jLabel = new JLabel(imageIcon);
        jLabel1 = new JLabel(imageIcon);
        jLabel2 = new JLabel(imageIcon);
        jLabel3 = new JLabel(imageIcon);
        jLabel4 = new JLabel(imageIcon);
        jLabel5 = new JLabel(imageIcon);
        jLabel6 = new JLabel(imageIcon1);
        
        
    }
    public void setup() {
    
        
        
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
        if(game.getArena()!=2 || game.getArena()!=4 || game.getArena()!=7 ||game.getArena()!= 10|| game.getArena()!= 14 ){
             jLabel6.setVisible(false);
             button6.setVisible(false);
        }else{
            jLabel6.setVisible(true);
             button6.setVisible(true);
        }
        gridBag.anchor=GridBagConstraints.SOUTH;
        gridBag.gridx=4;
        gridBag.gridy=2;
        add(jLabel6,gridBag);
       
        gridBag.anchor=GridBagConstraints.NORTH;
        gridBag.gridx=4;
        gridBag.gridy=3;
        add(button6,gridBag);
   }

    public int drawCard(String carta){
        if(carta.equals("Boss Monster")){
            return 6;
        
    }else if(carta.equals("Monster")){
        return 5;
        
    }else if(carta.equals("Merchant")){
        return 4;
        
    }else if(carta.equals("Resting")){
        return 3;
        
    }else if(carta.equals("Event")){
        return 2;
        
    }else if(carta.equals("Treasure")){
        return 1;
        
    }else if(carta.equals( "Trap")){
        return 7;
        
    }
        return 0;
    }
    
  
    
}
