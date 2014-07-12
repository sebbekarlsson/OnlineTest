import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ServerFrame{
	
	
	int WIDTH = 640;
	int HEIGHT = 480;
	
	
	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	public JLabel connectionsLabel = new JLabel("connections: 0");
	public JTextArea consoleText = new JTextArea();
	public JScrollPane console = new JScrollPane(consoleText);
	public int connections = 0;
	
	public ServerFrame(){
		frame.setSize(WIDTH,HEIGHT);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		console.setPreferredSize(new Dimension(WIDTH,HEIGHT-100));
		
		frame.add(panel);
		panel.add(connectionsLabel);
		panel.add(console);
	}
	
	
	public void addConnection(){
		
		connections += 1;
		connectionsLabel.setText("Connections: "+connections);
	}
	
	public void writeToConsole(String text){
		consoleText.append(text);
	}
	
}
