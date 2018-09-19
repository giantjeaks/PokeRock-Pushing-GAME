import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

public class StartScene extends JPanel
{	
	private JFrame start;
    private Image bgImage;
	public StartScene(JFrame start)
	{
		this.start = start;
		ImageIcon loader = new ImageIcon(getClass().getResource("img/Cave.gif"));
        ImageIcon loader2 = new ImageIcon(getClass().getResource("img/Play.png"));
        ImageIcon loader3 = new ImageIcon(getClass().getResource("img/PlayClec.gif"));
        ImageIcon loader4 = new ImageIcon(getClass().getResource("img/Exit.png"));
        ImageIcon loader5 = new ImageIcon(getClass().getResource("img/ExitClec.gif"));
        bgImage = loader.getImage();
         JLabel lblNewLabel_1 = new JLabel();
         JLabel lblNewLabel_2 = new JLabel();
         setLayout(null);
         lblNewLabel_2.setBounds(366, 390,60 , 45);
         lblNewLabel_1.setBounds(366, 290,60 , 45);
         lblNewLabel_2.setIcon(loader4);
         lblNewLabel_1.setIcon(loader2);
         add(lblNewLabel_1);
         add(lblNewLabel_2);
         
         JLabel label = new JLabel("");
 		label.setIcon(loader);
 		label.setBounds(0, 0, 564, 639);
 		add(label);
         
         
         
         
         
         lblNewLabel_2.addMouseListener(new MouseAdapter() 
         {
         public void mouseClicked(MouseEvent e) {
        	 System.exit(0);
             }
         });
         lblNewLabel_2.addMouseListener(new MouseAdapter(){
         	public void mouseEntered(MouseEvent e1){
         		lblNewLabel_2.setIcon(loader5);
         	}
         	public void mouseExited(MouseEvent e2){
         		lblNewLabel_2.setIcon(loader4);
         	}
         });
         
        lblNewLabel_1.addMouseListener(new MouseAdapter() 
        {
        public void mouseClicked(MouseEvent e) {
        	start.setVisible(false);
            JFrame game = new JFrame("PokeRock Pushing GAME");
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setSize(580, 678);
            game.add(new GameScene(game),BorderLayout.CENTER);
            game.setVisible(true);
            
            }
        });
        lblNewLabel_1.addMouseListener(new MouseAdapter(){
        	public void mouseEntered(MouseEvent e1){
        		lblNewLabel_1.setIcon(loader3);
        	}
        	public void mouseExited(MouseEvent e2){
        		lblNewLabel_1.setIcon(loader2);
        	}
        });
        
    
	}
    
}