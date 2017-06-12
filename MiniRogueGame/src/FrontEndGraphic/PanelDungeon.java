/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEndGraphic;

import MR_Game_Logic.Cards.Monster;
import MR_Game_Logic.ObservableGame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nuno
 */
public class PanelDungeon extends JPanel implements Observer{

    private ObservableGame game;
     private String imageFile="\\dungeon.jpg";
    private BufferedImage image;
     private int hp = 0;
   
     
   
    
    
    public PanelDungeon(ObservableGame g){
        game= g;
        setup();
        game.addObserver(this); 
    }
    
     @Override
    public void paintComponent(Graphics g){
        Rectangle r=getBounds();
        
        super.paintComponent(g);
         g.drawImage(image,0,0,243,340,null);
     
        int arena = game.getArena();
        hp=game.monsterHp();
        
   
        double x = 0, y=0;
        
        Graphics2D g2=(Graphics2D) g;
        g2.setColor(Color.blue);
        g2.setStroke(new BasicStroke(3));
       
       hp = 3;
        switch (hp){
            case 0:
                x= 149;
                y=227;
                break;
            case 1:
                x= 149;
                y=205;
                break;
            case 2:
                x= 149;
                y=186;
                break;
            case 3:
                 x= 149;
                y=165;
                break;
            case 4:
                x= 149;
                 y=146;
                break;
            case 5:
                 x= 149;
                 y=126;
                break;
            case 6:
                 x= 149;
                y=106;
                break;
            case 7:
                 x= 149;
                 y=86;
                break;
            case 8:
                x= 149;
                y=66;
                break;
            case 9:
                x= 149;
                 y=48;
                break;
            case 10:
                 x= 149;
                y=28;
                break;
            case 11:
                x= 123;
                y=205;
                break;
            case 12:
                x= 123;
                y=186;
                break;
                
                case 13:
                    x= 123;
                    y=165;
                break;
                case 14:
                    x= 123;
                    y=146;
                break;
                
                case 15:
                    x= 123;
                    y=126;
                break;
                case 16:
                    x= 123;
                     y=106;
                break;
                case 17:
                    x= 123;
                    y=86;
                break;
                case 18:
                    x= 123;
                     y=66;
                break;
                case 19:
                    x= 123;
                    y=48;
                break;
                case 20:
                    x= 123;
                    y=28;
                break;
                case 21:
                   x= 103;
                    y=205;
                break;
                case 22:
                    x= 103;
                    y=186;
                break;
                case 23:
                    x= 103;
                    y=165;
                break;
                case 24:
                    x= 103;
                    y=146;
                break;
                case 25:
                    x= 103;
                    y=126;
                break;
                case 26:
                    x= 103;
                     y=106;
                break;
                case 27:
                    x= 103;
                    y=86;
                break;
                case 28:
                    x= 103;
                     y=66;
                break;
                case 29:
                    x= 103;
                    y=48;
                break;
                case 30:
                    x= 103;
                    y=28;
                break;
   
    
        }
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/30), (int) (r.height/30));
        
        
        switch(arena){
            case 1:
                x= 13;
                y=100;
                break;
            case 2:
                x= 33;
                y=100;
                break;
            case 3:
                x= 13;
                y=130;
                break;
            case 4:
                 x= 33;
                y=130;
                break;
            case 5:
                 x= 13;
                 y=160;
                break;
            case 6:
               x= 33;
                y=160;
                break;
            case 7:
                x= 53;
               y=160;
               
                break;
            case 8:
                x= 13;
                y=190;
                break;
            case 9:
                x= 33;
                y=190;
                break;
            case 10:
                x= 53;
                y=190;
                break;
            case 11:
                x= 13;
                y=219;
                break;
            case 12:
                x= 33;
                y=219;
                break;
                
                case 13:
                x= 53;
                y=219;
                break;
                case 14:
                x= 71;
                y=219;
                break;
        }
         g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/30), (int) (r.height/30));
            
    }
    
     @Override
    public Dimension getPreferredSize(){
        Rectangle r=getBounds();
        
        if(image!=null){
            return new Dimension(260,260);
        }
        return super.getPreferredSize();
    }
    @Override
    public void update(Observable o, Object o1) {
        if(game.getCurrentCard().equals("Monster")){
             hp=game.monsterHp();
             
        }else if(game.getCurrentCard().equals("boss_monster")) {
             hp=game.monsterHp();
        }else{
            hp = 0;
        }
        repaint();
        
    }

    private void setup() {
           try {
            image=ImageIO.read(this.getClass().getResourceAsStream(imageFile));
        } catch (IOException ex) {
            System.out.println(ex);
        } 
           
         
    }
    
}
