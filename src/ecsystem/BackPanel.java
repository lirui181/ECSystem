package ecsystem;

import java.awt.*;
import java.awt.Graphics.*;
import javax.swing.*;

public class BackPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = Toolkit.getDefaultToolkit().getImage("EC.jpg");
		g.drawImage(img, 0, 0, null, this);
	}

	public BackPanel() {
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
	}
}
