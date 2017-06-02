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
public class PanelDungeon extends JPanel implements Observer{

    private ObservableGame game;
     private String imageFile="\\dungeon.jpg";
    private BufferedImage image;
    
    
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
        int xp = game.getXp(),armor = game.getArmor(), hp = game.getHP(), gold= game.getGold(), food= game.getFood();
        boolean fire = false;
        boolean ice = false;
        boolean poison = false;
        boolean heal = false;
        double x = 0, y;
        
        Graphics2D g2=(Graphics2D) g;
        g2.setColor(Color.blue);
        g2.setStroke(new BasicStroke(3));
        y=41;
        switch (hp){
            case 1:
                x= 93;
                break;
            case 2:
                x= 93;
                break;
            case 3:
                x= 93;
                break;
            case 4:
                 x= 93;
                break;
            case 5:
                 x= 93;
                break;
            case 6:
                x= 93;
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
    
        }
        g2.drawOval((int) ((x/383)*r.width), (int) ((y/274)*r.height), (int) (r.width/40), (int) (r.height/40));
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
