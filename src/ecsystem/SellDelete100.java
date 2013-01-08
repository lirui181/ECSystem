package ecsystem;

import java.awt.*;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

/**
 * @author �����ҡ����ٷ�����ï�֡�������
 * @version 1.0
 */
public class SellDelete100 extends JFrame implements ActionListener {
	DBManager db = new DBManager();
	ResultSet rs;
	Container con = getContentPane();
	JLabel jLab1 = new JLabel("����ɾ������������Ϣ����ɾ��");
	JLabel jLab2 = new JLabel("��Ʒ��");
	JLabel jLab3 = new JLabel("���");

	JLabel jLab4 = new JLabel("����");
	JLabel jLab5 = new JLabel("�ؼ�");
	JLabel jLab6 = new JLabel("����");
	JLabel jLab7 = new JLabel(new ImageIcon());
	JTextField jText1 = new JTextField();
	JTextField jText2 = new JTextField();
	JTextField jText3 = new JTextField();
	JTextArea jArea = new JTextArea(3, 26);
	JComboBox jCom = new JComboBox();
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel pan3 = new JPanel();
	JPanel pan100 = new JPanel();
	JButton jBtn1 = new JButton("��ѯ");
	JButton jBtn2 = new JButton("ɾ��");
	JButton jBtn3 = new JButton("��һ��");
	JButton jBtn4 = new JButton("��һ��");
	JButton jBtn5 = new JButton("�˳�");

	GridBagLayout gbc = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();

	public SellDelete100() {
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		setVisible(true);
		setSize(450, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("������Ϣɾ��");
		jCom.addItem("�����Ʒ");
		jCom.addItem("������Ʒ");
		jCom.addItem("������Ʒ");
		jCom.addItem("���з���");
		jText1.setPreferredSize(new Dimension(75, 20));
		jText2.setPreferredSize(new Dimension(75, 20));
		jText3.setPreferredSize(new Dimension(75, 20));
		jCom.setPreferredSize(new Dimension(75, 20));
		pan1.setPreferredSize(new Dimension(450, 50));
		pan2.setPreferredSize(new Dimension(450, 250));
		pan3.setPreferredSize(new Dimension(450, 50));
		pan100.setPreferredSize(new Dimension(450, 50));
		jText1.setEditable(false);
		jText2.setEditable(false);
		jText3.setEditable(false);
		jArea.setEditable(false);

		pan1.setLayout(gbc);
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(20, 15, 5, 200);
		pan1.add(jLab1, c);

		pan2.setLayout(gbc);
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(1, 1, 15, 1);
		pan2.add(jLab2, c);
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(1, 1, 15, 5);
		pan2.add(jText1, c);

		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5, 1, 15, 1);
		pan2.add(jLab3, c);
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(5, 1, 15, 1);
		pan2.add(jCom, c);
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(5, 1, 15, 1);
		pan2.add(jLab4, c);
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(5, 1, 15, 1);
		pan2.add(jText2, c);
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(5, 1, 15, 1);
		pan2.add(jLab5, c);
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(5, 1, 15, 1);
		pan2.add(jText3, c);
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(5, 1, 5, 1);
		pan2.add(jLab6, c);
		c.gridwidth = 5;
		c.gridheight = 2;
		c.gridx = 1;
		c.gridy = 5;
		c.insets = new Insets(5, 1, 5, 1);
		pan2.add(jArea, c);
		c.gridwidth = 6;
		c.gridheight = 4;
		c.gridx = 2;
		c.gridy = 0;
		c.insets = new Insets(1, 1, 5, 15);
		pan2.add(jLab7, c);// ����ͼƬ

		pan3.setLayout(new FlowLayout());
		pan3.add(jBtn1);
		pan3.add(jBtn2);

		pan3.add(jBtn5);

		pan100.add(pan1, BorderLayout.NORTH);
		pan100.add(pan2, BorderLayout.CENTER);
		pan100.add(pan3, BorderLayout.SOUTH);
		con.add(pan100);
		validate();
		jBtn1.addActionListener(this);
		jBtn2.addActionListener(this);
		jBtn3.addActionListener(this);
		jBtn4.addActionListener(this);
		jBtn5.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jBtn1) {
			SSelect s = new SSelect();
			Dimension frmSize = getSize();
			Dimension dlgSize = s.getSize();
			Point loc = getLocation();
			s.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
					(frmSize.height - dlgSize.height) / 2 + loc.y);

		}

		if (e.getSource() == jBtn2) {
			String sql;
			sql = "select *  from Sell where Fname=";
			sql += "'" + jText1.getText().trim() + "'";
			rs = db.getResult(sql);
			boolean isexist = false;
			try {
				isexist = rs.first();
			} catch (SQLException ek) {

			}
			if (isexist) {
				sql = "delete from Sell where Fname='";
				sql += jText1.getText().trim() + "'";
				if (db.executeSql(sql)) {
					JOptionPane.showMessageDialog(null, "ɾ����Ϣ�ɹ������ȷ���������");
				} else {
					JOptionPane.showMessageDialog(null, "ɾ����Ϣʧ�ܣ���ȷ�������ԣ�");
				}

			} else {
				JOptionPane.showMessageDialog(null, "�����ڸ���Ʒ");
			}
		}
		if (e.getSource() == jBtn5) {
			dispose();
		}

	}

	public void showResults(ResultSet rs) {
		try {
			jText1.setText(rs.getString("Fname"));
			jCom.setSelectedItem(rs.getString("Ftype"));
			jText2.setText(rs.getString("Fprice"));
			jText3.setText(rs.getString("Fsprice"));
			jArea.setText(rs.getString("Fremark"));
			jLab7.setIcon(new ImageIcon(rs.getString("strPath")));

		} catch (SQLException ec) {

		}
	}

	public static void main(String[] args) {
		SellDelete100 sellupdate = new SellDelete100();
	}
}
