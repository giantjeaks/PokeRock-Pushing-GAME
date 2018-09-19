
import java.awt.*;

import javax.swing.*;

import java.util.*;

public class Py extends GameObject
{
	private GameScene scene;
	private Image image;
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
    private Rock rck1;
	private Rock rck2;
	private Rock rck3;
	private Rock rck4;
	private Rock rck5;
	private Rock rck6;
	 private ArrayList<GameObject> rocks = new ArrayList<GameObject>();





    public Py(GameScene scene, int x, int y) 
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
        rocks.add(rck1 = new Rock(scene , 200 ,165));
 		rocks.add(rck2 = new Rock(scene , 358 ,165));
 		rocks.add(rck3 = new Rock(scene , 200 ,299));
 		rocks.add(rck4 = new Rock(scene , 358 ,299));
 		rocks.add(rck5 = new Rock(scene , 200 ,425));
 		rocks.add(rck6 = new Rock(scene , 358 ,425));



    	ImageIcon front = new ImageIcon(getClass().getResource("img/R.gif"));
    	image = front.getImage();
        

    	this.x = x - image.getWidth(null) / 2;
        this.y = y - image.getHeight(null) / 2;
        


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
                ImageIcon back = new ImageIcon(getClass().getResource("img/frontAnim.gif"));
                image = back.getImage();
                y += speedY;
              //ËÔ¹ª¹ËÔ¹
           	 for (int i=0 ; i<rocks.size() ; i++){ 
                	int i1=0;
                	int i2=0;
                	int i3=0;
                	int i4=0;
                	int i5=0;
                	if(i==0){
                		i1 = 1; i2=2; i3=3; i4=4; i5=5;
                	} else if(i==1){
                		i1 = 0; i2=2; i3=3; i4=4; i5=5;
                	}else if(i==2){
                		i1 = 0; i2=1; i3=3; i4=4; i5=5;
                	}else if(i==3){
                		i1 = 0; i2=1; i3=2; i4=4; i5=5;
                	}else if(i==4){
                		i1 = 0; i2=1; i3=2; i4=3; i5=5;
                	}else if(i==5){
                		i1 = 0; i2=1; i3=2; i4=3; i5=4;
                	}
                    if (collideWith(rocks.get(i))){
                   	if (rocks.get(i).getY() >555 && rocks.get(i).getX()<355 || rocks.get(i).collideWith(k1) || rocks.get(i).collideWith(k2)||rocks.get(i).collideWith(k3)
                   			|| rocks.get(i).collideWith(k4)|| rocks.get(i).collideWith(ks1)|| rocks.get(i).collideWith(ks2)||
                   			rocks.get(i).collideWith(ks3)|| rocks.get(i).collideWith(ks4)||rocks.get(i).collideWith(km1)|| 
                   			rocks.get(i).collideWith(km2)||rocks.get(i).collideWith(km3)|| rocks.get(i).collideWith(kl1)|| 
                   			rocks.get(i).collideWith(kl2)|| rocks.get(i).collideWith(kl3)||rocks.get(i).collideWith(rocks.get(i1))
                   			||rocks.get(i).collideWith(rocks.get(i2))||rocks.get(i).collideWith(rocks.get(i3))||rocks.get(i).collideWith(rocks.get(i4))||
                   			rocks.get(i).collideWith(rocks.get(i5))){
                   		
                   		
                   		y-= speedY;
                   	}
                   	else{
                   		rocks.get(i).update();
                   	 }
                   	}
                    
               	}
                    
                //¤¹à´Ô¹ä»áººäÁèÁÕËÔ¹
                if (y > 555 && x < 355 || collideWith(k1) || collideWith(k2)|| collideWith(k3)|| collideWith(k4)|| 
                    collideWith(ks1)|| collideWith(ks2)|| collideWith(ks3)|| collideWith(ks4)||
                    collideWith(km1)|| collideWith(km2)|| collideWith(km3)|| 
                    collideWith(kl1)|| collideWith(kl2)|| collideWith(kl3)) {
                	y-= speedY;
                }
                if (y > 555 && x > 375 || collideWith(k1) || collideWith(k2)|| collideWith(k3)|| collideWith(k4)|| 
                    collideWith(ks1)|| collideWith(ks2)|| collideWith(ks3)|| collideWith(ks4)||
                    collideWith(km1)|| collideWith(km2)|| collideWith(km3)|| 
                    collideWith(kl1)|| collideWith(kl2)|| collideWith(kl3)) {
                	y -= speedY;
                }
            }
            else if (scene.getKeyState(GameScene.KEY_DOWN)==false)
            {
                ImageIcon back = new ImageIcon(getClass().getResource("img/front.gif"));
                image = back.getImage();
            }
            break;
            case 1 : if (scene.getKeyState(GameScene.KEY_UP)==true) 
            {
                ImageIcon front = new ImageIcon(getClass().getResource("img/backAnim.gif"));
                image = front.getImage();
                y -= speedY;
              //ËÔ¹ª¹ËÔ¹
           	 for (int i=0 ; i<rocks.size() ; i++){ 
                	int i1=0;
                	int i2=0;
                	int i3=0;
                	int i4=0;
                	int i5=0;
                	if(i==0){
                		i1 = 1; i2=2; i3=3; i4=4; i5=5;
                	} else if(i==1){
                		i1 = 0; i2=2; i3=3; i4=4; i5=5;
                	}else if(i==2){
                		i1 = 0; i2=1; i3=3; i4=4; i5=5;
                	}else if(i==3){
                		i1 = 0; i2=1; i3=2; i4=4; i5=5;
                	}else if(i==4){
                		i1 = 0; i2=1; i3=2; i4=3; i5=5;
                	}else if(i==5){
                		i1 = 0; i2=1; i3=2; i4=3; i5=4;
                	}
                    if (collideWith(rocks.get(i))){
                   	if (rocks.get(i).getY() < 37 || rocks.get(i).collideWith(k1) || rocks.get(i).collideWith(k2)||rocks.get(i).collideWith(k3)
                   			|| rocks.get(i).collideWith(k4)|| rocks.get(i).collideWith(ks1)|| rocks.get(i).collideWith(ks2)||
                   			rocks.get(i).collideWith(ks3)|| rocks.get(i).collideWith(ks4)||rocks.get(i).collideWith(km1)|| 
                   			rocks.get(i).collideWith(km2)||rocks.get(i).collideWith(km3)|| rocks.get(i).collideWith(kl1)|| 
                   			rocks.get(i).collideWith(kl2)|| rocks.get(i).collideWith(kl3)||rocks.get(i).collideWith(rocks.get(i1))
                   			||rocks.get(i).collideWith(rocks.get(i2))||rocks.get(i).collideWith(rocks.get(i3))||rocks.get(i).collideWith(rocks.get(i4))||
                   			rocks.get(i).collideWith(rocks.get(i5))){
                   		
                   		
                   		y+= speedY;
                   	}
                   	else{
                   		rocks.get(i).update();
                   	 }
                   	}
                    
               	}
                if (y < 37 || collideWith(k1) || collideWith(k2)|| collideWith(k3)|| collideWith(k4)|| 
                    collideWith(ks1)|| collideWith(ks2)|| collideWith(ks3)|| collideWith(ks4)||
                    collideWith(km1)|| collideWith(km2)|| collideWith(km3)|| 
                    collideWith(kl1)|| collideWith(kl2)|| collideWith(kl3)){
                	y += speedY;
                }
            }
            else if (scene.getKeyState(GameScene.KEY_UP)==false)
            {
                ImageIcon front = new ImageIcon(getClass().getResource("img/back.gif"));
                image = front.getImage();
            }
            break;
            case 2 : if (scene.getKeyState(GameScene.KEY_LEFT)==true) 
            {
                ImageIcon left = new ImageIcon(getClass().getResource("img/LeftAnim.gif"));
                image = left.getImage();
            	x -= speedX;
            	//ËÔ¹ª¹ËÔ¹
           	 for (int i=0 ; i<rocks.size() ; i++){ 
                	int i1=0;
                	int i2=0;
                	int i3=0;
                	int i4=0;
                	int i5=0;
                	if(i==0){
                		i1 = 1; i2=2; i3=3; i4=4; i5=5;
                	} else if(i==1){
                		i1 = 0; i2=2; i3=3; i4=4; i5=5;
                	}else if(i==2){
                		i1 = 0; i2=1; i3=3; i4=4; i5=5;
                	}else if(i==3){
                		i1 = 0; i2=1; i3=2; i4=4; i5=5;
                	}else if(i==4){
                		i1 = 0; i2=1; i3=2; i4=3; i5=5;
                	}else if(i==5){
                		i1 = 0; i2=1; i3=2; i4=3; i5=4;
                	}
                    if (collideWith(rocks.get(i))){
                   	if (rocks.get(i).getX() < 65 || rocks.get(i).collideWith(k1) || rocks.get(i).collideWith(k2)||rocks.get(i).collideWith(k3)
                   			|| rocks.get(i).collideWith(k4)|| rocks.get(i).collideWith(ks1)|| rocks.get(i).collideWith(ks2)||
                   			rocks.get(i).collideWith(ks3)|| rocks.get(i).collideWith(ks4)||rocks.get(i).collideWith(km1)|| 
                   			rocks.get(i).collideWith(km2)||rocks.get(i).collideWith(km3)|| rocks.get(i).collideWith(kl1)|| 
                   			rocks.get(i).collideWith(kl2)|| rocks.get(i).collideWith(kl3)||rocks.get(i).collideWith(rocks.get(i1))
                   			||rocks.get(i).collideWith(rocks.get(i2))||rocks.get(i).collideWith(rocks.get(i3))||rocks.get(i).collideWith(rocks.get(i4))||
                   			rocks.get(i).collideWith(rocks.get(i5))){
                   		
                   		
                   		x+= speedX;
                   	}
                   	else{
                   		rocks.get(i).update();
                   	 }
                   	}
                    
               	}
            	if (x<40 || collideWith(k1) || collideWith(k2)|| collideWith(k3)|| collideWith(k4)|| 
                    collideWith(ks1)|| collideWith(ks2)|| collideWith(ks3)|| collideWith(ks4)||
                    collideWith(km1)|| collideWith(km2)|| collideWith(km3)|| 
                    collideWith(kl1)|| collideWith(kl2)|| collideWith(kl3)){
            	x += speedX;}
            	
            }
            else if(scene.getKeyState(GameScene.KEY_LEFT)==false)
            {
                ImageIcon front = new ImageIcon(getClass().getResource("img/L.gif"));
                image = front.getImage();
            }
            break;
            case 3 : if (scene.getKeyState(GameScene.KEY_RIGHT)==true) 
            {
                ImageIcon right = new ImageIcon(getClass().getResource("img/RightAnim.gif"));
                image = right.getImage();
            	x += speedX;
            	//ËÔ¹ª¹ËÔ¹
            	 for (int i=0 ; i<rocks.size() ; i++){ 
                 	int i1=0;
                 	int i2=0;
                 	int i3=0;
                 	int i4=0;
                 	int i5=0;
                 	if(i==0){
                 		i1 = 1; i2=2; i3=3; i4=4; i5=5;
                 	} else if(i==1){
                 		i1 = 0; i2=2; i3=3; i4=4; i5=5;
                 	}else if(i==2){
                 		i1 = 0; i2=1; i3=3; i4=4; i5=5;
                 	}else if(i==3){
                 		i1 = 0; i2=1; i3=2; i4=4; i5=5;
                 	}else if(i==4){
                 		i1 = 0; i2=1; i3=2; i4=3; i5=5;
                 	}else if(i==5){
                 		i1 = 0; i2=1; i3=2; i4=3; i5=4;
                 	}
                     if (collideWith(rocks.get(i))){
                    	if (rocks.get(i).getX() >460 || rocks.get(i).collideWith(k1) || rocks.get(i).collideWith(k2)||rocks.get(i).collideWith(k3)
                    			|| rocks.get(i).collideWith(k4)|| rocks.get(i).collideWith(ks1)|| rocks.get(i).collideWith(ks2)||
                    			rocks.get(i).collideWith(ks3)|| rocks.get(i).collideWith(ks4)||rocks.get(i).collideWith(km1)|| 
                    			rocks.get(i).collideWith(km2)||rocks.get(i).collideWith(km3)|| rocks.get(i).collideWith(kl1)|| 
                    			rocks.get(i).collideWith(kl2)|| rocks.get(i).collideWith(kl3)||rocks.get(i).collideWith(rocks.get(i1))
                    			||rocks.get(i).collideWith(rocks.get(i2))||rocks.get(i).collideWith(rocks.get(i3))||rocks.get(i).collideWith(rocks.get(i4))||
                    			rocks.get(i).collideWith(rocks.get(i5))){
                    		
                    		
                    		x-= speedX;
                    	}
                    	else{
                    		rocks.get(i).update();
                    	 }
                    	}
                     
                	}
            	if (x>460 || collideWith(k1) || collideWith(k2)|| collideWith(k3)|| collideWith(k4)|| 
                    collideWith(ks1)|| collideWith(ks2)|| collideWith(ks3)|| collideWith(ks4)||
                    collideWith(km1)|| collideWith(km2)|| collideWith(km3)|| 
                    collideWith(kl1)|| collideWith(kl2)|| collideWith(kl3)){
            	x -= speedX;}
            }
            else if (scene.getKeyState(GameScene.KEY_RIGHT)==false)
            {
                ImageIcon front = new ImageIcon(getClass().getResource("img/R.gif"));
                image = front.getImage();
            }
            break;
        }
        return true;
    }
    @Override
    public void draw(Graphics g) 
    {
        g.drawImage(image, x, y, scene);
        rck1.draw(g);
        rck2.draw(g);
        rck3.draw(g);
        rck4.draw(g);
        rck5.draw(g);
        rck6.draw(g);
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getSpeedX(){
        return this.speedX;  
    }
    public int getSpeedY(){
        return this.speedY;
    }

    @Override
    public Rectangle getBounds()
    {
    	return new Rectangle(x+10,y+20,30,30);
    }
}