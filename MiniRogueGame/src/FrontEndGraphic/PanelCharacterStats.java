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
                x= 77;
                y=206;
                break;
            case 2:
                x= 77;
                y=188;
                break;
            case 3:
                 x= 77;
                y=170;
                break;
            case 4:
                 x= 77;
                y=152;
                break;
            case 5:
                 x= 77;
                y=134;
                break;
            case 6:
               x= 77;
                y=115;
                break;
            case 7:
                x= 77;
                y=95;
                break;
            case 8:
              x= 77;
                y=75;
                break;
            case 9:
                x= 77;
                y=59;
                break;
            case 10:
                x= 77;
                y=39;
                break;
            case 11:
                x= 60;
                y=206;
                break;
            case 12:
                x= 60;
                y=188;
                break;
            case 13:
               x= 60;
               y=170;
                break;
            case 14:
               x= 60;
                 y=152;
                break;
            case 15:
                x= 60;;
                y=134;
                break;
            case 16:
                x= 60;
               y=115;
                break;
            case 17:
                x= 60;;
                y=95;
                break;
            case 18:
                x= 60;
                y=75;
                break;
            case 19:
                x= 60;
               y=59;
                break;
            case 20:
                x= 60;
                y=39;
                break;
        }
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/30), (int) (r.height/30));
       
        switch (gold){
            case 0:
                 x= 113;
                  y=226;
                 break;
            case 1:
                x= 113;
                y=206;
                break;
            case 2:
                x= 113;
                y=188;
                break;
            case 3:
                x= 113;
                y=170;
                break;
            case 4:
                x= 113;
                y=152;
                break;
            case 5:
                x= 113;
                y=134;
                break;
            case 6:
                x= 113;
                y=115;
                break;
            case 7:
                x= 113;
                y=95;
                break;
            case 8:
                x= 113;
                y=75;
                break;
            case 9:
                x= 113;
                 y=59;
                break;
            case 10:
                x= 113;
               y=39;
                break;
            case 11:
               x= 96;
                y=206;
                break;
            case 12:
                x= 96;
                y=188;
                break;
            case 13:
                x= 96;
               y=170;
                break;
            case 14:
               x= 96;
                y=152;
                break;
            case 15:
              x= 96;
                y=134;
                break;
            case 16:
                x= 96;
               y=115;
                break;
            case 17:
                x= 96;
                y=95;
                break;
            case 18:
               x= 96;
                y=75;
                break;
            case 19:
                x= 96;
                 y=59;
                break;
            case 20:
              x= 96;
                y=39;
                break;
        }
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/30), (int) (r.height/30));
       
        switch (food){
            case 0:
                  x= 133;
                  y=152;
                 break;
            case 1:
                 x= 133;
                 y=134;
                break;
            case 2:
                 x= 133;
                y=115;
                break;
            case 3:
                x= 133;
                y=95;
                break;
            case 4:
                x= 133;
                 y=75;
                break;
            case 5:
                x= 133;
                y=59;
                break;
             case 6:
                 x= 133; 
                y=39;
                break;
        }
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/30), (int) (r.height/30));
   
        switch (armor){
            case 0:
                  x= 40;
                  y=134;
                 break;
            case 1:
               x= 40;
                 y=115;
                break;
            case 2:
                 x= 40;
                 y=95;
                break;
            case 3:
                 x= 40;
                  y=75;
                break;
            case 4:
                 x= 40;
                  y=59;;
                break;
            case 5:
                x= 40;
               y=39;
                break;
        }
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/30), (int) (r.height/30));
  
        switch (rank){
         
            case 1:
                x= 5;
                y=125;
                 break;
            case 2:
               x= 5;
                y=125;
                 break;
            case 3:
                 x= 5;
                y=85;
                 break;
            case 4:
                 x= 5;
                y=45;
                 break;
        }
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/15), (int) (r.height/15));
       
        if(fire==true){
            x= 40;
            y=170;
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/30), (int) (r.height/30));
        }
        
         if(ice==true){
             x= 40;
           y=190;
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/30), (int) (r.height/30));
        }
        
           if(poison==true){
             x= 40;
            y=209;
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/30), (int) (r.height/30));
        }
      
          if(heal==true){
            x= 40;
            y=228;
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/30), (int) (r.height/30));
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
