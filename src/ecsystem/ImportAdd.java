package ecsystem;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import java.sql.*;
import java.util.*;

/**
 * @author 李新忠、徐琴芳、范茂林、刘书齐
 * @version 1.0
 */
public class ImportAdd extends JFrame implements ActionListener {
	DBManager db = new DBManager();
	ResultSet rs;
	Container con = getContentPane();
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel pan3 = new JPanel();
	JPanel pan100 = new JPanel();
	JLabel jLab1 = new JLabel("请填写以下信息");
	JLabel jLab2 = new JLabel("货品名称");
	JLabel jLab3 = new JLabel("货品价格");
	JLabel jLab4 = new JLabel("采购数量");
	JLabel jLab5 = new JLabel("货品类别");
	JLabel jLab6 = new JLabel("其他费用");
	JLabel jLab7 = new JLabel("采购总额");
	JLabel jLab8 = new JLabel("供应商");
	JLabel jLab9 = new JLabel("备注");
	JTextField jText1 = new JTextField();
	JTextField jText2 = new JTextField();
	JTextField jText3 = new JTextField();
	JComboBox jCom = new JComboBox();
	JTextField jText5 = new JTextField();
	JTextField jText6 = new JTextField();
	JTextField jText7 = new JTextField();
	JButton jBtn1 = new JButton("计算");
	JButton jBtn2 = new JButton("添加");
	JButton jBtn3 = new JButton("清空");
	JButton jBtn4 = new JButton("退出");
	JTextArea jTArea = new JTextArea(3, 26);// 注意一下还没有设置行数
	GridBagLayout gbc = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();

	public ImportAdd() {
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
		setVisible(true);
		setSize(450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("采购信息添加");
		jCom.addItem("");
		jCom.addItem("数码产品");
		jCom.addItem("休闲服饰");
		jCom.addItem("虚拟用品");
		jCom.addItem("护肤产品");

		jText1.setPreferredSize(new Dimension(75, 20));
		jText2.setPreferredSize(new Dimension(75, 20));
		jText3.setPreferredSize(new Dimension(75, 20));
		jCom.setPreferredSize(new Dimension(75, 20));
		jCom.addActionListener(new ImportAdd_jCom_actionAdapter(this));
		jText5.setPreferredSize(new Dimension(75, 20));
		jText6.setPreferredSize(new Dimension(75, 20));
		jText7.setPreferredSize(new Dimension(290, 20));
		pan1.setBackground(new Color(175, 210, 250));
		pan1.setPreferredSize(new Dimension(450, 40));
		pan2.setBackground(new Color(175, 210, 250));
		pan2.setPreferredSize(new Dimension(450, 170));
		pan3.setBackground(new Color(175, 210, 250));
		pan3.setPreferredSize(new Dimension(450, 40));
		pan100.setBackground(new Color(175, 210, 250));
		pan100.setPreferredSize(new Dimension(450, 300));
		jText6.setEditable(false);
		pan1.setLayout(gbc);
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(20, 5, 5, 300);
		jBtn1.setBackground(new Color(175, 210, 250));
		jBtn2.setBackground(new Color(175, 210, 250));
		jBtn3.setBackground(new Color(175, 210, 250));
		jBtn4.setBackground(new Color(175, 210, 250));
		pan1.add(jLab1, c);
		pan2.setLayout(gbc);
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 1, 5, 1);
		pan2.add(jLab2, c);
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(5, 1, 5, 5);
		pan2.add(jText1, c);
		c.gridx = 2;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 5, 1);
		pan2.add(jLab3, c);
		c.gridx = 3;
		c.gridy = 0;
		c.insets = new Insets(5, 1, 5, 5);
		pan2.add(jText2, c);
		c.gridx = 4;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 5, 1);
		pan2.add(jLab4, c);
		c.gridx = 5;
		c.gridy = 0;
		pan2.add(jText3, c);
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5, 1, 5, 1);
		pan2.add(jLab5, c);
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(5, 1, 5, 1);
		pan2.add(jCom, c);
		c.gridx = 2;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 1);
		pan2.add(jLab6, c);
		c.gridx = 3;
		c.gridy = 1;
		c.insets = new Insets(5, 1, 5, 5);
		pan2.add(jText5, c);
		c.gridx = 4;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 1);
		pan2.add(jLab7, c);
		c.gridx = 5;
		c.gridy = 1;
		c.insets = new Insets(5, 1, 5, 1);
		pan2.add(jText6, c);
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(5, 1, 5, 1);
		pan2.add(jLab8, c);
		c.gridwidth = 4;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(5, 1, 5, 1);
		pan2.add(jText7, c);
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(5, 1, 5, 1);
		pan2.add(jLab9, c);
		c.gridwidth = 4;
		c.gridheight = 2;
		c.gridx = 1;
		c.gridy = 4;
		c.insets = new Insets(5, 1, 5, 1);
		pan2.add(jTArea, c);

		pan3.setLayout(gbc);// pan3
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 15, 1);
		pan3.add(jBtn1, c);
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(5, 1, 15, 1);
		pan3.add(jBtn2, c);
		c.gridx = 2;
		c.gridy = 0;
		c.insets = new Insets(5, 1, 15, 1);
		pan3.add(jBtn3, c);
		c.gridx = 3;
		c.gridy = 0;
		c.insets = new Insets(5, 1, 15, 1);
		pan3.add(jBtn4, c);
		pan100.add(pan1, BorderLayout.NORTH);
		pan100.add(pan2, BorderLayout.CENTER);
		pan100.add(pan3, BorderLayout.SOUTH);
		con.add(pan100);
		con.validate();
		validate();
		jBtn1.addActionListener(this);
		jBtn2.addActionListener(this);
		jBtn3.addActionListener(this);
		jBtn4.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jBtn4) {
			this.dispose();
		}
		if (e.getSource() == jBtn3) {
			jText1.setText("");
			jText2.setText("");
			jText3.setText("");
			jCom.setSelectedItem("");
			jText5.setText("");
			jText6.setText("");
			jText7.setText("");
			jTArea.setText("");
		}
		if (e.getSource() == jBtn1) {

			int a = Integer.parseInt(jText2.getText());
			int b = Integer.parseInt(jText3.getText());
			int c = Integer.parseInt(jText5.getText());
			String s = String.valueOf(a * b + c);
			jText6.setText(s);
			JOptionPane.showMessageDialog(null, "操作成功！");

		}
		if (e.getSource() == jBtn2) {
			if (jText1.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "货品名称不能为空");
			}
			if (jCom.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(null, "货品类别不能为空");
			}
			if (jText2.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "货品价格不能为空");
			}
			if (jText3.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "货品数量不能为空");
			}

			else {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new java.util.Date());
				String year = String.valueOf(calendar.get(Calendar.YEAR));
				String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
				String day = String
						.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
				String sql;
				sql = "insert into Purchase(Gname,Gprice,Gnumber,Gtype,Tfee,Pfee,Supplier,GRemark,GIyear,GImonth,GIday)";
				sql += "values('" + jText1.getText().trim() + "','";
				sql += jText2.getText().trim() + "','";
				sql += jText3.getText().trim() + "',";
				sql += "'" + jCom.getSelectedItem() + "','";
				sql += jText5.getText().trim() + "','";
				sql += jText6.getText().trim() + "',";
				sql += "'" + jText7.getText().trim() + "',";
				sql += "'" + jTArea.getText().trim() + "',";
				sql += "'" + year + "','" + month + "','" + day + "')";
				if (db.executeSql(sql)) {
					JOptionPane.showMessageDialog(null, "添加信息成功，点击确定继续！");
				} else {
					JOptionPane.showMessageDialog(null, "添加信息失败，请确认后重试！");
				}

			}

		}
	}

	public static void main(String args[]) {
		new ImportAdd();
	}

	public void jCom_actionPerformed(ActionEvent e) {

	}
}

class ImportAdd_jCom_actionAdapter implements ActionListener {
	private ImportAdd adaptee;

	ImportAdd_jCom_actionAdapter(ImportAdd adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jCom_actionPerformed(e);
	}
}
