package ecsystem;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author ¿Ó–¬÷“°¢–Ï«Ÿ∑º°¢∑∂√Ø¡÷°¢¡ı È∆Î
 * @version 1.0
 */
public class ECSystem extends JFrame {
	JPanel contentPane;
	BorderLayout borderLayout1 = new BorderLayout();

	public ECSystem() {
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Component initialization.
	 * 
	 * @throws java.lang.Exception
	 */
	private void jbInit() throws Exception {
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(borderLayout1);
		setSize(new Dimension(400, 300));
		setTitle("ECSystem");
	}
}