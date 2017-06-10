/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEndGraphic;

import MR_Game_Logic.ObservableGame;
import MR_Game_Logic.States.AwaitBeginning;
import MR_Game_Logic.States.AwaitCardSelection;
import MR_Game_Logic.States.AwaitDiceOption;
import MR_Game_Logic.States.AwaitDiceRoll;
import MR_Game_Logic.States.AwaitRest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import static java.awt.SystemColor.text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Nuno
 */
public class GraphicalUserInterface extends JFrame implements Observer{

    private ObservableGame game;
   
 
    
    private PanelCharacterStats panelCharacterStats;
    private PanelDungeon panelDungeon;
    private PanelRollDice panelRollDice;
    private PanelCartasEventos panelCartasEventos;
    private PanelComprareVender panelComprareVender;
    private PanelRest panelRest;
    private PanelCombat panelCombat;
    
    
    
    private JMenuBar menuMain;
    private JMenu menuFile;
    private JMenu menuAbout;
    private JMenuItem menuLoad;
    private JMenuItem menuSettings;
    private JMenuItem menuStart;
    private JMenuItem menuSave;
    private JMenuItem menuCredits;
    
    
    @Override
    public void update(Observable o, Object o1) {
     
        
     }
    
   
    
    public GraphicalUserInterface(ObservableGame g){
        super("MiniRogueGame");
        game = g;
        
        menuMain = new JMenuBar();
        menuAbout = new JMenu("About");
        menuFile = new JMenu("File");
        menuLoad = new JMenuItem("Load");
        menuSave = new JMenuItem ("Save");
        menuSettings = new JMenuItem ("Settings");
        menuStart = new JMenuItem ("Start Game");
        menuCredits = new JMenuItem("Credits");
      
        menuMain.add(menuFile);
        menuMain.add(menuAbout);
        menuFile.add(menuStart);
        menuFile.add(menuSettings);
        menuFile.add(menuSave);
        menuFile.add(menuLoad);
        menuAbout.add(menuCredits);
       
        
        setJMenuBar(menuMain);
        
        
      
          menuCredits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JOptionPane.showMessageDialog(null, "\nNuno Curado - Nº21210595\nPedro Martins - Nº21230150\n ISEC - DEIS", "Credits", JOptionPane.INFORMATION_MESSAGE);
            }
        });
         
         menuLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
         
        menuSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dificuldade = 0;
                String nome;
                
                dificuldade = Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha a dificuldade: "));
                game.setDifficulty(dificuldade);
                dificuldade  = game.getDifficulty();
                nome = JOptionPane.showInputDialog(null,"Nome do jogador: ");
                game.setName(nome);
                
                System.out.println("dificuldade = " + game.getDifficulty());
            }
        });
        
         
        menuStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  setup();
                  game.startGame();
 
            }
        });
        
        
        setSize(1400,1000);
        setMinimumSize(new Dimension(1400,1000));
        setVisible(true);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();//?
        game.addObserver(this); //?
        
    }

     private void setup() {
        
        
        
        panelCharacterStats = new PanelCharacterStats(game);
        panelDungeon = new PanelDungeon(game);
        panelRollDice = new PanelRollDice(game);
        panelCartasEventos = new PanelCartasEventos(game);
        panelComprareVender = new PanelComprareVender(game);
        panelRest = new PanelRest(game);
        panelCombat = new PanelCombat(game);
        
        
       // imageIcon = new ImageIcon(getClass().getResource("\\startcard.jpg"));
       // jLabel = new JLabel(imageIcon);
       // add(jLabel);
       
                 
                 Container cp=getContentPane();
                 setLayout(new FlowLayout());
                 
                 cp.setLayout(new GridBagLayout());
                 GridBagConstraints gridBag=new GridBagConstraints();
                 gridBag.fill=GridBagConstraints.BOTH;
                
                 
                 panelCharacterStats.setBorder(new LineBorder(Color.black));
                 gridBag.gridx=0;
                 gridBag.gridy=0;
                 gridBag.weighty=0.6;
                 gridBag.weightx=0.6;
                 cp.add(panelCharacterStats,gridBag);
                 
                 panelDungeon.setBorder(new LineBorder(Color.black));
                 gridBag.gridx=1;
                 gridBag.gridy=0;
                 gridBag.weighty=0.6;
                 gridBag.weightx=0.6;
                 cp.add(panelDungeon, gridBag);   
                 
                 
                 panelCartasEventos.setBorder(new LineBorder(Color.black));
                 gridBag.gridx=0;
                 gridBag.gridy=1;
                 gridBag.weighty=0.2;
                 gridBag.weightx=0.7;
                 cp.add(panelCartasEventos, gridBag);
                 
                 panelCombat.setBorder(new LineBorder(Color.black));
                 gridBag.gridx=2;
                 gridBag.gridy=0;
                 gridBag.weighty=0.6;
                 gridBag.weightx=0.4;
                 cp.add(panelCombat, gridBag);
                 
                 panelComprareVender.setBorder(new LineBorder(Color.black));
                 gridBag.gridx=1;
                 gridBag.gridy=1;
                 gridBag.weighty=0.2;
                 gridBag.weightx=0.2;
                 cp.add(panelComprareVender, gridBag); 
                // panelComprareVender.setVisible(false);
                 
                 panelRest.setBorder(new LineBorder(Color.black));
                 gridBag.gridx=2;
                 gridBag.gridy=1;
                 gridBag.weighty=0.1;
                 gridBag.weightx=0.1;
                 cp.add(panelRest, gridBag);
                 
                 
                 
                 panelRollDice.setBorder(new LineBorder(Color.black));
                 gridBag.weighty=0.1;
                 gridBag.weightx=1;
                 gridBag.gridx=0;
                 gridBag.gridy=2;
                 gridBag.gridwidth=1;
                 cp.add(panelRollDice, gridBag);   
    
                 setVisible(true);
    }
   
}
