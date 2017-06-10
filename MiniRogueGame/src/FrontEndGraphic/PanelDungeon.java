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
     private int hpActual= 0;
     
   
    
    
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
        hp = hpActual;
        int arena = game.getArena();
       
        
   
        double x = 0, y=0;
        
        Graphics2D g2=(Graphics2D) g;
        g2.setColor(Color.blue);
        g2.setStroke(new BasicStroke(3));
       
       
        switch (hp){
            case 0:
                x= 143;
                y=224;
                break;
            case 1:
                x= 143;
                y=205;
                break;
            case 2:
                x= 143;
                y=186;
                break;
            case 3:
                x= 143;
                y=165;
                break;
            case 4:
                 x= 143;
                 y=146;
                break;
            case 5:
                 x= 143;
                 y=126;
                break;
            case 6:
                x= 143;
                y=106;
                break;
            case 7:
                x= 143;
                 y=86;
                break;
            case 8:
                x= 143;
                y=66;
                break;
            case 9:
                x= 143;
                 y=48;
                break;
            case 10:
                x= 143;
                y=28;
                break;
            case 11:
                x= 121;
                y=205;
                break;
            case 12:
                x= 121;
                y=186;
                break;
                
                case 13:
                    x= 121;
                    y=165;
                break;
                case 14:
                    x= 121;
                    y=146;
                break;
                
                case 15:
                    x= 121;
                    y=126;
                break;
                case 16:
                    x= 121;
                     y=106;
                break;
                case 17:
                    x= 121;
                    y=86;
                break;
                case 18:
                    x= 121;
                     y=66;
                break;
                case 19:
                    x= 121;
                    y=48;
                break;
                case 20:
                    x= 121;
                    y=28;
                break;
                case 21:
                   x= 101;
                    y=205;
                break;
                case 22:
                    x= 101;
                    y=186;
                break;
                case 23:
                    x= 101;
                    y=165;
                break;
                case 24:
                    x= 101;
                    y=146;
                break;
                case 25:
                    x= 101;
                    y=126;
                break;
                case 26:
                    x= 101;
                     y=106;
                break;
                case 27:
                    x= 101;
                    y=86;
                break;
                case 28:
                    x= 101;
                     y=66;
                break;
                case 29:
                    x= 101;
                    y=48;
                break;
                case 30:
                    x= 101;
                    y=28;
                break;
   
    
        }
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/30), (int) (r.height/30));
        
        
        switch(arena){
            case 1:
                x= 13;
                y=98;
                break;
            case 2:
                x= 33;
                y=98;
                break;
            case 3:
                x= 13;
                y=128;
                break;
            case 4:
                 x= 33;
                y=128;
                break;
            case 5:
                 x= 13;
                 y=157;
                break;
            case 6:
               x= 33;
                y=157;
                break;
            case 7:
                x= 53;
                y=157;
               
                break;
            case 8:
                x= 13;
                y=186;
                break;
            case 9:
                x= 33;
                y=186;
                break;
            case 10:
                x= 53;
                y=186;
                break;
            case 11:
                x= 13;
                y=215;
                break;
            case 12:
                x= 33;
                y=215;
                break;
                
                case 13:
                x= 53;
                y=215;
                break;
                case 14:
                x= 71;
                y=215;
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
        if(game.getCurrentCard() != "monster"){
            System.out.println("monster hp: " + 0);
        }else{
            game.monsterHp();
            System.out.println("monster hp: " + game.monsterHp());
            hpActual=game.monsterHp();
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
