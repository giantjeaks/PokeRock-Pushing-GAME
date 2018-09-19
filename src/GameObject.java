import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public abstract class GameObject
{
	public abstract boolean update();
	
	public abstract void draw(Graphics g);

	public abstract Rectangle getBounds();
	
	public abstract int getX();

    public abstract int getY();

    public abstract int getSpeedX();
  
    
    public abstract int getSpeedY();

	public boolean collideWith(GameObject other){
		return getBounds().intersects(other.getBounds());
	}
}