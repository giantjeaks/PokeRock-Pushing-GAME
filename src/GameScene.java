import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

public class GameScene extends JPanel implements ActionListener, KeyListener
{
	public static final int KEY_UP = 0;
    public static final int KEY_DOWN = 1;
    public static final int KEY_LEFT = 2;
    public static final int KEY_RIGHT = 3;
    private int t = 20;
    private int f = 0;
   
    
    private boolean[] keyStates = new boolean[4];
	private Py player;
	
	private Image image;
    private Timer timer;
    private JFrame gamesc;
    
	public GameScene(JFrame gamesc)
	{
		this.gamesc =gamesc;
		ImageIcon loader = new ImageIcon(getClass().getResource("img/mappp.png"));
        image = loader.getImage();
        ImageIcon loader2 = new ImageIcon(getClass().getResource("img/Youwin.gif"));
        loader2.getImage();
        
		setDoubleBuffered(true);
		
		
		
		player = new Py(this, 75, 80);
		setFocusable(true);
		addKeyListener(this);
		timer = new Timer(1000/50, this);
		timer.start();
    
	}

	@Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawImage(image,0,0,null);
        player.draw(g);
        g.setFont(new Font("Arial",Font.PLAIN,20));
        g.setColor(Color.WHITE);
       
        if (f==50){
        	t-=1;
        	f =0;
        }
        f+=1;
        
        g.drawString("Time: 00:"+t,20,20);
        
        
	}
	public void update() {
        player.update();
        repaint();
        if (t==0){
        	timer.stop();
        	gamesc.setVisible(false);
            JFrame game = new JFrame("PokeRock Pushing GAME");
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setSize(580, 678);
            game.add(new GameOver(game),BorderLayout.CENTER);
            game.setVisible(true);
            
        }
        if (player.getY() > 555){
        	timer.stop();
        	gamesc.setVisible(false);
        	JFrame vicc = new JFrame("PokeRock Pushing GAME");
            vicc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vicc.setSize(580, 678);
            vicc.add(new VictoryScene(vicc),BorderLayout.CENTER);
            vicc.setVisible(true);
        }
    }
    public boolean getKeyState(int key) 
    {
        return keyStates[key];
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        update();
    }
     @Override
    public void keyTyped(KeyEvent e) 
    {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                keyStates[KEY_UP] = true;
                break;
            case KeyEvent.VK_DOWN:
                keyStates[KEY_DOWN] = true;
                break;
            case KeyEvent.VK_LEFT:
                keyStates[KEY_LEFT] = true;
                break;
            case KeyEvent.VK_RIGHT:
                keyStates[KEY_RIGHT] = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                keyStates[KEY_UP] = false;
                break;
            case KeyEvent.VK_DOWN:
                keyStates[KEY_DOWN] = false;
                break;
            case KeyEvent.VK_LEFT:
                keyStates[KEY_LEFT] = false;
                break;
            case KeyEvent.VK_RIGHT:
                keyStates[KEY_RIGHT] = false;
                break;
        }
    }
}