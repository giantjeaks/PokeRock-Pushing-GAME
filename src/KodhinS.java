import java.awt.*;
import javax.swing.*;

public class KodhinS extends GameObject
{
	private GameScene scene;
	private Image image;
    private int x, y;
    public KodhinS(GameScene scene, int x, int y) 
    {
    	this.scene = scene;
    	this.x = x ;
        this.y = y ;
	}
	@Override
    public boolean update() 
    {
        return true;
    }
    @Override
    public void draw(Graphics g) 
    {
        g.drawImage(image, x, y, scene);
    }
    @Override
    public Rectangle getBounds()
    {
    	return new Rectangle(x,y,73,80);
    }
	@Override
	public int getX() {

		return 0;
	}
	@Override
	public int getY() {

		return 0;
	}
	@Override
	public int getSpeedX() {

		return 0;
	}
	@Override
	public int getSpeedY() {

		return 0;
	}
}