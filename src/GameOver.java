import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

public class GameOver extends JPanel
{	
	public JFrame over;
    public GameOver(JFrame over)
	{
		this.over = over;
		ImageIcon loader = new ImageIcon(getClass().getResource("img/GO.png"));
        ImageIcon loader2 = new ImageIcon(getClass().getResource("img/Tag.gif"));

        loader.getImage();
        JLabel lblNewLabel_1 = new JLabel();
        setLayout(null);
        lblNewLabel_1.setBounds(331, 389, 186, 42);
        lblNewLabel_1.setIcon(loader2);
        add(lblNewLabel_1);
        
        JLabel label = new JLabel("");
		label.setIcon(loader);
		label.setBounds(0, 0, 564, 639);
		add(label);
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() 
        {
        public void mouseClicked(MouseEvent e) {
        	over.setVisible(false);
            JFrame game = new JFrame("PokeRock Pushing GAME");
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setSize(580, 678);
            game.add(new StartScene(game),BorderLayout.CENTER);
            game.setVisible(true);
            
            }
        });
        
    
	}
    
}