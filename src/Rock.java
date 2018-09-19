import java.awt.*;
import javax.swing.*;

public class Rock extends GameObject
{
	private GameScene scene;
	private Image imagerck;
    private int x, y;
    private int speedX = 5;
    private int speedY = 5;
    private int step;
    private Kodhinyaw k1;
    private Kodhinyaw k2;
    private Kodhinyaw k3;
    private Kodhinyaw k4;
    private KodhinS ks1;
    private KodhinS ks2;
    private KodhinS ks3;
    private KodhinS ks4;
    private KodhinM km1;
    private KodhinM km2;
    private KodhinM km3;
    private KodhinL kl1;
    private KodhinL kl2;
    private KodhinL kl3;

    public Rock(GameScene scene, int x, int y) 
    {
    	this.scene = scene;
         k1 = new Kodhinyaw(scene,55,95);
         k2 = new Kodhinyaw(scene,379,95);
         k3 = new Kodhinyaw(scene,55,445);
         k4 = new Kodhinyaw(scene,379,445);
         ks1 = new KodhinS(scene,379,195);
         ks2 = new KodhinS(scene,97,195);
         ks3 = new KodhinS(scene,97,320);
         ks4 = new KodhinS(scene,379,320);
         km1 = new KodhinM(scene,217,195);
         km2 = new KodhinM(scene,217,68);
         km3 = new KodhinM(scene,217,317);
         kl1 = new KodhinL(scene,217,445);
         kl2 = new KodhinL(scene,25,445);
         kl3 = new KodhinL(scene,410,445);
    	ImageIcon rck = new ImageIcon(getClass().getResource("img/rock.png"));
    	imagerck = rck.getImage();

    	this.x = x - imagerck.getWidth(null) / 2;
        this.y = y - imagerck.getHeight(null) / 2;
	}
	@Override
    public boolean update() 
    {
        

        if (scene.getKeyState(GameScene.KEY_DOWN))
        {
            step = 0;
        }
        if (scene.getKeyState(GameScene.KEY_UP))
        {
            step = 1;
        }
        if (scene.getKeyState(GameScene.KEY_LEFT))
        {
            step = 2;
        }
        if (scene.getKeyState(GameScene.KEY_RIGHT))
        {
            step = 3;
        }
        switch(step){
            case 0 : if (scene.getKeyState(GameScene.KEY_DOWN)==true)
            {
            	
                y += speedY;

                if (y > 555 && x < 355 || collideWith(k1) || collideWith(k2)|| collideWith(k3)|| collideWith(k4)|| 
                    collideWith(ks1)|| collideWith(ks2)|| collideWith(ks3)|| collideWith(ks4)||
                    collideWith(km1)|| collideWith(km2)|| collideWith(km3)|| 
                    collideWith(kl1)|| collideWith(kl2)|| collideWith(kl3) ){ speedY = 0;}
                if (y > 555 && x > 375 || collideWith(k1) || collideWith(k2)|| collideWith(k3)|| collideWith(k4)|| 
                    collideWith(ks1)|| collideWith(ks2)|| collideWith(ks3)|| collideWith(ks4)||
                    collideWith(km1)|| collideWith(km2)|| collideWith(km3)|| 
                    collideWith(kl1)|| collideWith(kl2)|| collideWith(kl3)){speedY = 0;}
            }
           
            break;
            case 1 : if (scene.getKeyState(GameScene.KEY_UP)==true) 
            {
                
                y -= speedY;
                if (y < 37 || collideWith(k1) || collideWith(k2)|| collideWith(k3)|| collideWith(k4)|| 
                    collideWith(ks1)|| collideWith(ks2)|| collideWith(ks3)|| collideWith(ks4)||
                    collideWith(km1)|| collideWith(km2)|| collideWith(km3)|| 
                    collideWith(kl1)|| collideWith(kl2)|| collideWith(kl3)){speedY = 0;}
                
            }
           
            break;
            case 2 : if (scene.getKeyState(GameScene.KEY_LEFT)==true) 
            {

            x -= speedX;
            if (x<60|| collideWith(k1) || collideWith(k2)|| collideWith(k3)|| collideWith(k4)|| 
                    collideWith(ks1)|| collideWith(ks2)|| collideWith(ks3)|| collideWith(ks4)||
                    collideWith(km1)|| collideWith(km2)|| collideWith(km3)|| 
                    collideWith(kl1)|| collideWith(kl2)|| collideWith(kl3)){speedX = 0;}
            
            }
            break;
            case 3 : if (scene.getKeyState(GameScene.KEY_RIGHT)==true) 
            {    
                x += speedX;
                if (x>460|| collideWith(k1) || collideWith(k2)|| collideWith(k3)|| collideWith(k4)|| 
                    collideWith(ks1)|| collideWith(ks2)|| collideWith(ks3)|| collideWith(ks4)||
                    collideWith(km1)|| collideWith(km2)|| collideWith(km3)|| 
                    collideWith(kl1)|| collideWith(kl2)|| collideWith(kl3)){speedX = 0;}
              
            }
            break;
        } 
        return true;
    }
    @Override
    public void draw(Graphics g) 
    {
        g.drawImage(imagerck, x, y, scene);
    }
        public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(x,y+30,20,20);
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