import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class ClientFrame extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	int WIDTH = 640;
	int HEIGHT = WIDTH / 16 * 9;
	int SCALE = 2;
	
	Dimension FRAMESIZE = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	
	public JFrame frame = new JFrame();
	
	
	public ClientFrame(){
		frame.setSize(FRAMESIZE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(this);
	}
	
	
	public void paint(Graphics g){
		g.drawString("Hello!", 120, 120);
	}
	
	
}
