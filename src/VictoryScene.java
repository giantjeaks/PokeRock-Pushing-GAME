import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

public class VictoryScene extends JPanel
{	
	public JFrame rara;
    private Image bgImage;
	public VictoryScene(JFrame Vic)
	{
		this.rara = Vic;
		ImageIcon loader = new ImageIcon(getClass().getResource("img/Pag.png"));
        ImageIcon loader2 = new ImageIcon(getClass().getResource("img/Youwin.gif"));
        ImageIcon loader3 = new ImageIcon(getClass().getResource("img/PagClec.gif"));

        bgImage = loader.getImage();
        setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(33, 496, 165, 46);
		lblNewLabel.setIcon(loader);
		add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(loader2);
		label.setBounds(0, 0, 564, 639);
		add(label);
		
		lblNewLabel.addMouseListener(new MouseAdapter() 
        {
        public void mouseClicked(MouseEvent e) {
        	rara.setVisible(false);
            JFrame game = new JFrame("PokeRock Pushing GAME");
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setSize(580, 678);
            game.add(new StartScene(game),BorderLayout.CENTER);
            game.setVisible(true);
            
            }
        });
		lblNewLabel.addMouseListener(new MouseAdapter(){
        	public void mouseEntered(MouseEvent e1){
        		lblNewLabel.setIcon(loader3);
        	}
        	public void mouseExited(MouseEvent e2){
        		lblNewLabel.setIcon(loader);
        	}
        });
        
    
	}
    
}