import javax.swing.JFrame;

/**
 * This class contains the main method.
 * @author carlosrivera
 *
 */
public class Main{
	public static void main(String[] args){
		 JFrame f=new JFrame();
		    f.setSize(1200,900);
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    RotateWheel wheel=new RotateWheel();
		    wheel.setSize(1200, 900);
		    f.add(wheel);
		    f.addMouseListener(wheel);
		    f.addMouseMotionListener(wheel);
		    f.setVisible(true);
		}
	
	
}