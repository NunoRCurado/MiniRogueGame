/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEndGraphic;

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
public class PanelCharacterStats extends JPanel implements Observer{
    private ObservableGame game;
    private String imageFile="\\character.jpg";
    private BufferedImage image;
    
    public PanelCharacterStats(ObservableGame g){
        game= g;
        setup();
        game.addObserver(this); 
    }
    
    @Override
    public void paintComponent(Graphics g){
        Rectangle r=getBounds();
        
        super.paintComponent(g);
        g.drawImage(image,0,0,243,340,null);
        int rank = game.getRank(),
                armor = game.getArmor(), 
                hp = game.getHP(), 
                gold= game.getGold(), 
                food= game.getFood();
        boolean fire = game.hasFire();
        boolean ice = game.hasIce();
        boolean poison = game.hasPoison();
        boolean heal = game.hasHealling();
        double x = 0, y=0;
        
        Graphics2D g2=(Graphics2D) g;
        g2.setColor(Color.blue);
        g2.setStroke(new BasicStroke(3));
        

        switch (hp){
            case 1:
                x= 184;
                y=127;
                break;
            case 2:
                x= 184;
                y=117;
                break;
            case 3:
                 x= 184;
                y=106;
                break;
            case 4:
                 x= 184;
                y=94;
                break;
            case 5:
                 x= 184;
                y=83;
                break;
            case 6:
                 x= 184;
                y=70;
                break;
            case 7:
                 x= 184;
                y=59;
                break;
            case 8:
                 x= 184;
                y=47;
                break;
            case 9:
                 x= 184;
                y=36;
                break;
            case 10:
                 x= 184;
                y=24;
                break;
            case 11:
                x= 143;
                y=127;
                break;
            case 12:
                x= 143;
                y=117;
                break;
            case 13:
                x= 143;
               y=106;
                break;
            case 14:
               x= 143;
                 y=94;
                break;
            case 15:
                x= 143;
                y=83;
                break;
            case 16:
                x= 143;
               y=70;
                break;
            case 17:
                x= 143;
                 y=59;
                break;
            case 18:
                x= 143;
                y=47;
                break;
            case 19:
                x= 143;
                y=36;
                break;
            case 20:
                x= 143;
                 y=24;
                break;
        }
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/20), (int) (r.height/40));
       
        switch (gold){
            case 0:
                 x= 267;
                  y=140;
                 break;
            case 1:
                x= 267;
                y=127;
                break;
            case 2:
                 x= 267;
                y=117;
                break;
            case 3:
                 x= 267;
                y=106;
                break;
            case 4:
                 x= 267;
                y=94;
                break;
            case 5:
                 x= 267;
                y=83;
                break;
            case 6:
                 x= 267;
                y=70;
                break;
            case 7:
                 x= 267;
                y=59;
                break;
            case 8:
                 x= 267;
                y=47;
                break;
            case 9:
                 x= 267;
                y=36;
                break;
            case 10:
                 x= 267;
                y=24;
                break;
            case 11:
               x= 229;
                y=127;
                break;
            case 12:
                x= 229;
                y=117;
                break;
            case 13:
                x= 229;
               y=106;
                break;
            case 14:
               x= 229;
                 y=94;
                break;
            case 15:
              x= 229;
                y=83;
                break;
            case 16:
                x= 229;
               y=70;
                break;
            case 17:
                x= 229;
                 y=59;
                break;
            case 18:
               x= 229;
                y=47;
                break;
            case 19:
                x= 229;
                y=36;
                break;
            case 20:
              x= 229;
                 y=24;
                break;
        }
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/20), (int) (r.height/40));
        
        switch (food){
            case 0:
                  x= 310;
                  y=94;
                 break;
            case 1:
                 x= 310;
                 y=83;
                break;
            case 2:
                 x= 310;
                y=70;
                break;
            case 3:
                  x= 310;
                 y=59;
                break;
            case 4:
                  x= 310;
                 y=47;
                break;
            case 5:
                  x= 310;
                y=36;
                break;
             case 6:
                  x= 310;
                y=23;
                break;
        }
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/20), (int) (r.height/40));
       
        switch (armor){
            case 0:
                  x= 98;
                   y=83;
                 break;
            case 1:
                x= 98;
                 y=70;
                break;
            case 2:
                 x= 98;
                y=59;
                break;
            case 3:
                 x= 98;
                 y=47;
                break;
            case 4:
                 x= 98;
                  y=36;
                break;
            case 5:
                x= 98;
               y=23;
                break;
        }
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/20), (int) (r.height/40));
      
        switch (rank){
         
            case 1:
                x= 21;
                y=72;
                 break;
            case 2:
                x= 21;
                y=72;
                 break;
            case 3:
                x= 21;
                y=50;
                 break;
            case 4:
                x= 21;
                y=25;
                 break;
        }
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/7), (int) (r.height/15));
       
        if(fire==true){
            x= 98;
            y=106;
            g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/20), (int) (r.height/40));
        }
        
         if(ice==true){
            x= 98;
           y=117;
           g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/20), (int) (r.height/40));
        }
        
           if(poison==true){
            x= 98;
            y=127;
            g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/20), (int) (r.height/40));
        }
        
      
          if(heal==true){
            x= 98;
            y=137;
            g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/20), (int) (r.height/40));
        }
        
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
