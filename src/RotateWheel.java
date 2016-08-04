import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;


/**
 * This class contains all the drawing and animation of the project.
 * This class reacts to various MouseListeners and MouseMotionListener methods to create the animation. 
 * @author carlosrivera
 *
 */
public class RotateWheel extends JPanel implements MouseListener, MouseMotionListener {
	String[] strBuffer = new String[100];
	int i = 1,x2 = 0, y2 = 180;
	int a=0,b=0,meter = 300,coord = 50,gasoline = 500,mx,my,degree = -360, x0 = 0,x1 = 225;
	int[] countString = {0,0,0,0,0,0};
	//Image image;
	//Graphics graphics;
	boolean mousePressed = false, mouseDragged = false,add = false;
	
	/**
	 * Class constructor.
	 */
	public RotateWheel(){
		init();
		start();
		stop();
		destroy();
		}
	
	/**
	 *  init stands for initialize, this is the first method which gets called when Applet starts. 
	 */
	public void init() {
		
		addMouseMotionListener(this);
		addMouseListener(this);
		addItem("initializing the applet ");
		this.setSize(1200, 700);
	}
	/**
	 *  Start method executes after the init() and it can be used anywhere in the class if required.
	 */
	public void start() {
		addItem("starting the applet ");
	}
	/**
	 *  As name indicates this method is called when applet stops 
	 */
	public void stop() {
		addItem("stopping the applet ");
		
	}
	/**
	 *  This is the last method which is executed by JVM before destroying the applet.
	 */
	public void destroy() {
		addItem("unloading the applet");
	}
	/**
	 * This method prints the String used as parameter. 
	 * @param word
	 */
	private void addItem(String word) {
		strBuffer[i] = word;
		System.out.println(strBuffer[i]);
		i += 1;
	}
	
/**
 *This method updates the movement of the wheel when called.
 */
public void updateTire() {
		//code to update the position of graphics or to change the behavior of the wheel 
	x2 =(x2-b);
	y2 =(y2-b);
	
	try {
		//repaints every 25 milliseconds
		Thread.sleep(25);
	     } catch (InterruptedException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
			}
repaint();

	}
/**
 * This method updates the speed controller's button when dragged or pressed.
 */
public void updateController(){
	coord = mx - 1;
	try {
		Thread.sleep(25);
	     } catch (InterruptedException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
			}
repaint();
}
/**
 * This method updates the speedometer, marking the revolutions per minute of the wheel. 
 */
public void updateSpeedometer(){
	x1 = (int) (-138 - a*12.19);

	
	
	try {
		Thread.sleep(25);
	     } catch (InterruptedException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
			}
repaint();
}

/**
 * This method updates the revolutions counter every time the wheel completes one revolution.
 */
public void updateCounter(){
	if(countString[5] < 10){
	countString[5]++;
		if(countString[5] == 10){
			countString[5] = 0;
			countString[4]++;
			if(countString[4] == 10){
				countString[4] = 0;
				countString[3]++;
				if(countString[3] == 10){
					countString[3] = 0;
					countString[2]++;
					if(countString[2] == 10){
						countString[2] = 0;
						countString[1]++;
						if(countString[1] == 10){
							for(int j=0;j<6;j++){
								countString[j] = 0;
							}
						}
					}
				}
				
			}
	}
	}
	
	//degree is later used to mark the revolutions per minute of the wheel 
	degree = degree - 360;
	
	
	try {
		Thread.sleep(25);
	     } catch (InterruptedException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
			}
repaint();
}





//below are the different Mouse Event listeners
/**
 * This method belongs to the MouseListener interface and reacts every time the mouse is entered in the applet window.
 */
public void mouseEntered(MouseEvent event) {
	
}

/**
 * This method belongs to the MouseListener interface and reacts every time the mouse is exited in the applet window.
 */
public void mouseExited(MouseEvent event) {
	System.out.println("mouse exited");
}
/**
 * This method belongs to the MouseListener interface and reacts every time the mouse is pressed in the applet window.
 */
public void mousePressed(MouseEvent event) {
	
		 	mx = event.getX();
		    my = event.getY();
		   //when the add gas button is pressed the gas tank starts to fill up 
		    if(mx >= 900 && mx <= 1025 && my >= 550 && my <= 570){
		  	  add = true;
		  } 
		    //updates the controller if you press the mouse within the coordinates of the controller
		    if (mx > 50 && mx<=445 && my >= 400 && my < 425){
		    	
		    	updateController();
		    	if(gasoline < 500){
		    		mousePressed = true;
		    			b = (mx / 20);
		    			a = mx / 20;
		    			add = false;
		    	}
		     }
		    
		    //if you press all the way to the left in the controller, the wheel will stop since 
		    //this is the lowest velocity it can reach.
		   if(mx <= 50){
			   b = 0;
			   a = 0;
			   mx = 130;
			   coord = mx - 1;
			   }
		   
		 
		   updateTire();
		   updateSpeedometer();
	System.out.println("mouse pressed");
	
}

/**
 * This method belongs to the MouseListener interface and reacts every time the mouse is released in the applet window.
 */
public void mouseReleased(MouseEvent event) {
	
	System.out.println("mouse released");


}

/**
 * This method belongs to the MouseListener interface and reacts every time the mouse is clicked in the applet window.
 */
public void mouseClicked(MouseEvent e) {
	
	addItem("mouse clicked!");	
	}

/**
 * This method belongs to the MouseMotionListener interface and reacts every time the mouse is dragged in 
 * the applet window.
 */
@Override
public void mouseDragged(MouseEvent event) {
	// TODO Auto-generated method stub

 	mx = event.getX();
    my = event.getY();
   //if the mouse is dragged inside the speed controller then the button that controls the speed will be updated 
    //and will move to the spot it what dragged to inside the speed controller
    if (mx > 50 && mx<=445 && my >= 400 && my < 425){
    	
    	updateController();
    	if(gasoline < 500){
    		mousePressed = true;
    			b = (mx / 20);
    			a = mx / 20;
    			add = false; 			
    	}
    	
    }
    //if the button is dragged to this x axis coordinate then the wheel will stop 
   if(mx <= 50){
	   b = 0;
	   a = 0;
	   mx = 50;
	   coord = mx - 1;
	   
   }
 
   updateTire();
   updateSpeedometer();
	System.out.print("mouse dragged");
}
/**
 * This method belongs to the MouseMotionListener interface and reacts every time the mouse is moved 
 * in the applet window.
 */
@Override
public void mouseMoved(MouseEvent event) {
	System.out.print("mouse moved"); 
  } 



public void paint(Graphics g){ 

	super.paint(g);
	drawTire(g);
	drawController(g);
	drawTank(g);
	drawCounter(g);
	drawSpeedmeter(g);
	drawFuelMeter(g);
}
/**
 * This method draws the wheel. 
 * @param g variable to which methods for drawing the wheel are called on.
 */
public void drawTire(Graphics g){
	
	g.drawString("WHEEL", 200, 40);
	g.drawArc(75, 50, 300, 300, 0, 360);
	g.setColor(Color.black);
	g.fillArc(75, 50, 300, 300, 0, 360);
	
	g.setColor(Color.white);
	
	g.drawArc(100, 75, 250, 250,0,360);
	g.fillArc(100, 75, 250, 250,0,360);
	
	
	
	g.setColor(Color.yellow);
	
	g.fillArc(100, 75, 250, 250, - 5, 20);//this will help the user see when and where are the revolutions taking place
	
	
	g.setColor(Color.black);
	g.drawArc(200, 177, 50, 50, 0, 360);
	
	
	
	g.setColor(Color.MAGENTA);
	g.fillArc(100, 75, 250, 250, x2 - 5, 20); //it draws the Arc at(0 - 5)  i.e 355 degree
	g.setColor(Color.gray);
	g.fillArc(100, 75, 250, 250, x2 + 85, 20);// it draws the Arc at (0 + 85) i.e 85 degree 
	
	g.setColor(Color.gray);
	g.drawArc(200, 177, 50, 50, 0, 360);
	g.fillArc(200, 177, 50, 50, 0, 360);
	
	
	//x2 and y2 are just variable having initial value 0 & 180.
			// below lines will draw Arc starting at given x2-5 angle which could be between 0 to 360 degree starting from the right side (horizontally).
	g.setColor(Color.gray);
	g.fillArc(100, 75, 250, 250, x2 + 45, 20);
	g.fillArc(100, 75, 250, 250, x2 - 45, 20);

	// below lines will draw Arc starting at given y2-5 angle which could be between 0 to 360 degree starting from the right side (horizontally).

	g.fillArc(100, 75, 250, 250, y2 - 5, 20); //  it draws the Arc at(180 - 5)  i.e 175degree
	g.fillArc(100, 75, 250, 250, y2 + 85,20);
	g.fillArc(100, 75, 250, 250, y2 + 45, 20);
	g.fillArc(100, 75, 250, 250, y2 - 45, 20); 
	
	
	
	//this decision is affected by the implemented methods of the MouseListener and the MouseMotionListener
	if(mousePressed){
		
		updateTire();
		updateSpeedometer();

		
	}
	
	//this decision will determine what happens when the gas tank is empty
	if(gasoline >= 500){
		mousePressed = false;//will stop the wheel from turning 
		//this add variable will be true if we push the add gas button in the applet window
		//add varible is affected by the MouseListener Events
		if(add){
			mousePressed = true;
		}
		a = 0;
		b = 0;
		gasoline = 500;
		updateSpeedometer();
		updateTire();
		
	}
	//this explains what happens when the gas tank is not full, it does not mean the tank is empty
	if(gasoline > 0){
		// if add is true then the tank will begin to fill up 
		if(add){
			gasoline = gasoline - 5;
			a=0;
			b=0;//keeps the wheel from turning
			meter = meter - 3;
			coord = 50;
	 
		}
		//determines what happens when the gas tank is full 
	}else if(gasoline <= 0){
		add = false;//this means that if the tank is full you cannot add any more gas 
		g.setColor(Color.red);
		g.drawString("<---TANK FULL!", 990, 60);//lets you know that the tank is full
	}
	if(gasoline == 500){
		g.setColor(Color.red);
		g.drawString("GAS TANK IS EMPTY", 990, 60);
		g.drawString("FILL TANK!",990,80);
	}
}
/**
 * This method draws the speed meter that will tell the user the revolutions per minute of the wheel. 
 * @param g variable to which methods for drawing the speed meter are called on.
 */
public void drawSpeedmeter(Graphics g){
	g.setColor(Color.black);
	g.drawString("SPEEDOMETER", 610, 40);
	g.drawArc(500, 50, 300, 300, 0, 360);
	g.drawLine(650, 50, 650, 70);
	g.drawString("30",640,90);
	g.drawLine(650, 350, 650, 330);
	g.drawString("RPM", 635, 320);
	g.drawLine(500,200,520,200);
	g.drawString("10", 530, 205);
	g.drawLine(800, 200, 780, 200);
	g.drawString("50", 750, 205);
	g.drawLine(545, 95, 560, 110);
	g.drawString("20",560,130);
	g.drawLine(755, 95, 740, 110);
	g.drawString("40", 720, 130);
	g.drawLine(545, 305, 560, 290);
	g.drawString("0", 565, 290);
	g.drawLine(755, 305, 740, 290);
	g.drawString("60", 720, 290);
	g.drawOval(635, 185, 30, 30);
	g.fillOval(635, 185, 30, 30);
	g.setColor(Color.red);
	g.fillArc(500, 50, 300, 300, x1, 3); 
	
}
/**
 * This method draws the revolutions counter of the wheel's revolutions.
 * @param g variable to which methods for drawing the revolutions counter are called on.
 */
public void drawCounter(Graphics g){
	g.setColor(Color.black);
	g.drawString("REVOLUTIONS COUNTER", 325,515);
	g.drawRect(270, 525, 250, 50);
	int space = 290;
	g.drawRect(270,525, 50, 50);
	
	//this loop is used to draw every digit of the counter, which values are in an array 
	for(int j=0;j<6;j++){
		g.drawString(String.valueOf(countString[j]), space, 555);
		space = space + 50;
	}
	if(x2 <= degree){
		updateCounter();
		gasoline = gasoline + 5;
		meter = meter + 3;
	}
	g.drawRect(270,525,100,50);
	g.drawRect(270, 525, 150, 50);
	g.drawRect(270,525,200,50);
	g.drawRect(270, 525, 250, 50);
	g.drawRect(270, 525, 300, 50);
	}
/**
 * This method draws the gas tank.
 * @param g variable to which methods for drawing the gas tank are called on.
 */
public void drawTank(Graphics g){
	g.drawString("GAS TANK", 905,20);
	g.drawRect(900, gasoline + 30, 80, 500-gasoline);
	g.setColor(Color.orange);
	g.fillRect(900, gasoline + 30, 80, 500-gasoline);
	g.setColor(Color.black);
	g.drawRect(900, 30, 80, 500);
	g.drawRect(900, 550, 75, 20);
	g.setColor(Color.cyan);
	g.fillRect(900, 550, 75, 20);
	g.drawRect(900, 550, 75, 20);
	g.setColor(Color.black);
	g.drawString("Add Gas", 912, 565);
	

}
/**
 * This method draws the speed controller.
 * @param g variable to which methods for drawing the speed control are called on.
 */
public void drawController(Graphics g){
	g.setColor(Color.black);
	g.drawString("SPEED CONTROLLER", 50, 390);
	g.drawRect(45, 400, 410, 30);
	g.drawLine(55,415,445,415);
	g.drawRect(coord, 405, 5, 20);
	g.setColor(Color.BLUE);
	g.fillRect(coord, 405, 5, 20);
	g.drawString("low", 45, 450);
	g.drawLine(55, 405, 55, 425);
	g.drawLine(230, 405, 230, 425);
	g.drawLine(445, 405, 445, 425);
	g.drawString("medium", 215, 450);
	g.drawString("high", 445, 450);

	}
/**
 * This method draws the fuel meter.
 * @param g variable to which methods for drawing the fuel meter are called on.
 */
public void drawFuelMeter(Graphics g){
	g.setColor(Color.black);
	g.drawString("FUEL METER",500,390);
	g.drawRect(480, 400, 370, 35);
	g.fillRect(480, 400, 370, 35);
	g.setColor(Color.white);
	g.drawString("E", 490, 420);
	g.drawString("F", 820, 420);
	g.drawRect(510, 410, 300, 15);
	g.setColor(Color.white);
	g.fillRect(510, 410, 300, 15);
	if(meter >= 250){
	g.setColor(Color.red);
	}else{
		g.setColor(Color.green);
	}
	g.fillRect(510, 410, 300-meter, 15);
}
}

