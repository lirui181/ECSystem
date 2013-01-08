package ecsystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.Font;

/**
 * @author �����ҡ����ٷ�����ï�֡�������
 * @version 1.0
 */
public class MainWindow extends JFrame implements WindowListener,
		ActionListener {
	Container con = this.getContentPane();

	BackPanel pan99 = new BackPanel();
	JMenuBar jMenuBar = new JMenuBar();
	JMenu jMe1 = new JMenu("ϵͳ����");
	JMenuItem jMi1 = new JMenuItem("�û���½", new ImageIcon("��½.gif"));
	JMenuItem jMi2 = new JMenuItem("�ͻ�ע��", new ImageIcon("ע��.gif"));
	JMenuItem jMi3 = new JMenuItem("�뿪ϵͳ", new ImageIcon("�뿪.gif"));
	JMenuItem jMi4 = new JMenuItem("�û�ɾ��", new ImageIcon("ɾ��.gif"));

	JMenu jMe2 = new JMenu("��������");
	JMenuItem jMi5 = new JMenuItem("��Ʒ���", new ImageIcon("���.gif"));
	JMenuItem jMi6 = new JMenuItem("��Ʒ�޸�", new ImageIcon("�޸�.gif"));
	JMenuItem jMi7 = new JMenuItem("��Ʒɾ��", new ImageIcon("ɾ��.gif"));

	JMenu jMe3 = new JMenu("���۹���");
	JMenuItem jMi8 = new JMenuItem("������Ϣ��ѯ", new ImageIcon("��ѯ.gif"));
	JMenuItem jMi9 = new JMenuItem("���۴���", new ImageIcon("���.gif"));

	JMenu jMe4 = new JMenu("����ͳ��");
	JMenuItem jMi10 = new JMenuItem("������Ϣ��ѯ", new ImageIcon("��ѯ.gif"));
	JMenuItem jMi12 = new JMenuItem("������Ϣ���", new ImageIcon("���.gif"));
	JMenuItem jMi13 = new JMenuItem("֧����Ϣ���", new ImageIcon("���.gif"));

	JMenu jMe5 = new JMenu("����");
	JMenuItem jMi11 = new JMenuItem("��Ϣһ��", new ImageIcon("����.gif"));

	void buildConstraints(GridBagConstraints gbc, int gx, int gy, int gw,
			int gh, int wx, int wy) {
		gbc.gridx = gx;
		gbc.gridy = gy;
		gbc.gridwidth = gw;
		gbc.gridheight = gh;
		gbc.weightx = wx;
		gbc.weighty = wy;
	}

	public MainWindow() {
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {

		setSize(new Dimension(700, 525));
		setTitle("С�����۹���ϵͳ");
		con.setForeground(Color.black);
		jMi1.setFont(new java.awt.Font("����", Font.PLAIN, 15));
		jMi12.setFont(new java.awt.Font("����", Font.PLAIN, 15));
		jMi13.setFont(new java.awt.Font("����", Font.PLAIN, 15));
		jMenuBar.add(jMe1);
		jMe1.add(jMi1);
		jMe1.add(jMi2);
		jMe1.add(jMi4);
		jMe1.add(jMi3);

		jMenuBar.add(jMe2);
		jMe2.add(jMi5);
		jMe2.add(jMi6);
		jMe2.add(jMi7);

		jMenuBar.add(jMe3);
		jMe3.add(jMi8);
		jMe3.add(jMi9);

		jMenuBar.add(jMe4);
		jMe4.add(jMi10);
		jMe4.add(jMi12);
		jMe4.add(jMi13);

		jMenuBar.add(jMe5);
		jMe5.add(jMi11);

		jMe1.setFont(new java.awt.Font("��Բ", Font.PLAIN, 16));
		jMe2.setFont(new java.awt.Font("��Բ", Font.PLAIN, 16));
		jMe3.setFont(new java.awt.Font("��Բ", Font.PLAIN, 16));
		jMe4.setFont(new java.awt.Font("��Բ", Font.PLAIN, 16));
		jMe5.setFont(new java.awt.Font("��Բ", Font.PLAIN, 16));

		jMi2.setFont(new java.awt.Font("����", Font.PLAIN, 15));
		jMi3.setFont(new java.awt.Font("����", Font.PLAIN, 15));
		jMi4.setFont(new java.awt.Font("����", Font.PLAIN, 15));
		jMi5.setFont(new java.awt.Font("����", Font.PLAIN, 15));
		jMi6.setFont(new java.awt.Font("����", Font.PLAIN, 15));
		jMi7.setFont(new java.awt.Font("����", Font.PLAIN, 15));
		jMi8.setFont(new java.awt.Font("����", Font.PLAIN, 15));
		jMi9.setFont(new java.awt.Font("����", Font.PLAIN, 15));
		jMi10.setFont(new java.awt.Font("����", Font.PLAIN, 15));
		jMi11.setFont(new java.awt.Font("����", Font.PLAIN, 15));
		setContentPane(pan99);
		setJMenuBar(jMenuBar);
		validate();
		setVisible(true);
		this.addWindowListener(this);
		jMi1.addActionListener(this);
		jMi2.addActionListener(this);
		jMi3.addActionListener(this);
		jMi4.addActionListener(this);
		jMi5.addActionListener(this);
		jMi6.addActionListener(this);
		jMi7.addActionListener(this);
		jMi8.addActionListener(this);
		jMi9.addActionListener(this);
		jMi10.addActionListener(this);
		jMi11.addActionListener(this);
		jMi12.addActionListener(this);
		jMi13.addActionListener(this);
	}

	public void setEnable(String power) {
		if (power.equals("ϵͳ����Ա")) {
			jMe1.setEnabled(true);
			jMe2.setEnabled(true);
			jMe3.setEnabled(true);
			jMe4.setEnabled(true);
			jMe5.setEnabled(true);
		} else {
			jMe2.setEnabled(false);
			jMe3.setEnabled(false);
			jMe4.setEnabled(true);
			jMe5.setEnabled(true);
		}

	}

	public void windowOpened(WindowEvent e) {
		Userlogin dlg = new Userlogin(this);
		Dimension frmSize = getSize();
		Dimension dlgSize = dlg.getSize();
		Point loc = getLocation();
		dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
				(frmSize.height - dlgSize.height) / 2 + loc.y);
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		JOptionPane.showMessageDialog(null, "ллʹ��");
		System.exit(0);
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jMi1) {
			Userlogin dlg = new Userlogin(this);
			Dimension frmSize = getSize();
			Dimension dlgSize = dlg.getSize();
			Point loc = getLocation();
			dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
					(frmSize.height - dlgSize.height) / 2 + loc.y);
		}
		if (e.getSource() == jMi2) {
			UserAdd dlg = new UserAdd();
			Dimension frmSize = getSize();
			Dimension dlgSize = dlg.getSize();
			Point loc = getLocation();
			dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
					(frmSize.height - dlgSize.height) / 2 + loc.y);
		}
		if (e.getSource() == jMi3) {
			JOptionPane.showMessageDialog(null, "ллʹ�ñ�ϵͳ");
			System.exit(0);
		}
		if (e.getSource() == jMi4) {
			UserDelete dlg = new UserDelete();
			Dimension frmSize = getSize();
			Dimension dlgSize = dlg.getSize();
			Point loc = getLocation();
			dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
					(frmSize.height - dlgSize.height) / 2 + loc.y);

		}
		if (e.getSource() == jMi5) {
			ImportAdd dlg = new ImportAdd();
			Dimension frmSize = getSize();
			Dimension dlgSize = dlg.getSize();
			Point loc = getLocation();
			dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
					(frmSize.height - dlgSize.height) / 2 + loc.y);
		}
		if (e.getSource() == jMi6) {
			ImportUpdate dlg = new ImportUpdate();
			Dimension frmSize = getSize();
			Dimension dlgSize = dlg.getSize();
			Point loc = getLocation();
			dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
					(frmSize.height - dlgSize.height) / 2 + loc.y);

		}
		if (e.getSource() == jMi7) {
			ImportDelete dlg = new ImportDelete();
			Dimension frmSize = getSize();
			Dimension dlgSize = dlg.getSize();
			Point loc = getLocation();
			dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
					(frmSize.height - dlgSize.height) / 2 + loc.y);

		}
		if (e.getSource() == jMi8) {
			SSelect dlg = new SSelect();
			Dimension frmSize = getSize();
			Dimension dlgSize = dlg.getSize();
			Point loc = getLocation();
			dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
					(frmSize.height - dlgSize.height) / 2 + loc.y);

		}
		if (e.getSource() == jMi9) {
			SellWindow dlg = new SellWindow();
			Dimension frmSize = getSize();
			Dimension dlgSize = dlg.getSize();
			Point loc = getLocation();
			dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
					(frmSize.height - dlgSize.height) / 2 + loc.y);

		}
		if (e.getSource() == jMi10) {
			ProfitSee dlg = new ProfitSee();
			Dimension frmSize = getSize();
			Dimension dlgSize = dlg.getSize();
			Point loc = getLocation();
			dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
					(frmSize.height - dlgSize.height) / 2 + loc.y);

		}
		if (e.getSource() == jMi12) {
			IncomeAdd dlg = new IncomeAdd();
			Dimension frmSize = getSize();
			Dimension dlgSize = dlg.getSize();
			Point loc = getLocation();
			dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
					(frmSize.height - dlgSize.height) / 2 + loc.y);

		}
		if (e.getSource() == jMi13) {
			CostAdd dlg = new CostAdd();
			Dimension frmSize = getSize();
			Dimension dlgSize = dlg.getSize();
			Point loc = getLocation();
			dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
					(frmSize.height - dlgSize.height) / 2 + loc.y);

		}

		if (e.getSource() == jMi11) {
			About dlg = new About();
			Dimension frmSize = getSize();
			Dimension dlgSize = dlg.getSize();
			Point loc = getLocation();
			dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
					(frmSize.height - dlgSize.height) / 2 + loc.y);
		}

	}
}
