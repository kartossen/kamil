import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements ActionListener{
	final int PANEL_WITDTH = 1400;
	final int PANEL_HEIGHT = 770;
	Image Kamil;
	Image background;
	Timer timer;
	double radianVelocity = 0.0625;
	double radius = 20;
	int xVelocity = 1;
	int yVelocity = 1;
	double y = 250;
	double x = 450;
	short dirSwap=1;
	
	double angx = Math.toRadians(radianVelocity);
	double angy = Math.toRadians(radianVelocity);
	
	MyPanel(){
		this.setPreferredSize(new Dimension(PANEL_WITDTH, PANEL_HEIGHT));
		this.setBounds(0, 0, PANEL_WITDTH, PANEL_HEIGHT);
		this.setBackground(Color.black);
		Kamil = new ImageIcon("kamilek.png").getImage();
		background = new ImageIcon("jweb.jpg").getImage();
		timer = new Timer(10, this);
		timer.start();
	
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(background, 0, 0, null);
		g2D.drawImage(Kamil, (int)x,(int)y , null);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		x = x + radius * Math.cos(angx)*dirSwap;
		y = y + radius * Math.sin(angy)*dirSwap;
		x = x + xVelocity;
		y = y + yVelocity;
		if(x > PANEL_WITDTH - Kamil.getWidth(null) || x < 0) {
			xVelocity *= -1;
			dirSwap*=-1;
		}
		if(y > PANEL_HEIGHT - Kamil.getHeight(null) || y < 0) {
			yVelocity *= -1;
			dirSwap*=-1;
		}
		angx += 0.0625;
		angy += 0.0625;
		
		
		repaint();	
	}
}
