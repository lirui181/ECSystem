package ecsystem;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author �����ҡ����ٷ�����ï�֡�������
 * @version 1.0
 */
public class About extends JFrame {
	JPanel pan1 = new JPanel();
	JLabel jLab1 = new JLabel("      Java������ƴ���ҵ");
	JLabel jLab2 = new JLabel("ѧԺ�����ѧԺ");
	JLabel jLab3 = new JLabel("��Ŀ����С�����۹���ϵͳ");
	JLabel jLab4 = new JLabel("�����ˣ����ٷ� ��ï�� ������ ������");
	JLabel jLab5 = new JLabel("�汾��Version 1.01");
	GridBagConstraints gbc = new GridBagConstraints();

	public About() {
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		setTitle("��Ϣһ��");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(250, 200);
		Container con = this.getContentPane();
		pan1.setLayout(new GridBagLayout());
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		con.setBackground(new Color(175, 210, 250));
		jLab1.setBackground(new Color(175, 210, 250));
		pan1.add(jLab1, gbc);

		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		pan1.add(jLab2, gbc);

		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		pan1.add(jLab3, gbc);

		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		pan1.add(jLab4, gbc);

		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		pan1.add(jLab5, gbc);
		pan1.setBackground(new Color(175, 210, 250));
		con.add(pan1, BorderLayout.NORTH);
		validate();
	}

	public static void main(String args[]) {
		About about = new About();
	}

}
