import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	MyPanel panel;
	
	MyFrame(){
		
		panel = new MyPanel();		
		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(new FlowLayout());
	}
}
