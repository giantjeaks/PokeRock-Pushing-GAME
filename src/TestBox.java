import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TestBox extends JFrame
{
	
    public static void main(String[] args) 
    {
    	
    	JFrame start = new JFrame("PokeRock Pushing GAME");
        start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        start.setSize(580,678);
        start.add(new StartScene(start),BorderLayout.CENTER);
        start.setVisible(true);
	}
	


}
