package ecsystem;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

/**
 * @author 李新忠、徐琴芳、范茂林、刘书齐
 * @version 1.0
 */
public class ImportDelete extends JFrame implements ActionListener {
	DBManager db = new DBManager();
	ResultSet rs;
	Container con = getContentPane();
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel pan3 = new JPanel();
	JPanel pan100 = new JPanel();
	JLabel jLab1 = new JLabel("请填写以下删除信息");
	JLabel jLab2 = new JLabel("货品名称");
	JLabel jLab3 = new JLabel("货品价格");
	JLabel jLab4 = new JLabel("采购数量");
	JLabel jLab5 = new JLabel("货品类别");
	JLabel jLab6 = new JLabel("其他费用");
	JLabel jLab7 = new JLabel("ID号");
	JLabel jLab8 = new JLabel("供应商");
	JLabel jLab9 = new JLabel("备注");
	JTextField jText1 = new JTextField();
	JTextField jText2 = new JTextField();
	JTextField jText3 = new JTextField();
	JComboBox jCom = new JComboBox();
	JTextField jText5 = new JTextField();
	JTextField jText6 = new JTextField();
	JTextField jText7 = new JTextField();
	JButton jBtn1 = new JButton("查询");
	JButton jBtn2 = new JButton("删除");
	JButton jBtn3 = new JButton("上一条");
	JButton jBtn4 = new JButton("下一条");
	JButton jBtn5 = new JButton("退出");
	JTextArea jTArea = new JTextArea(3, 26);// 注意一下还没有设置行数
	GridBagLayout gbc = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();

	FlowLayout flow = new FlowLayout();

	public ImportDelete() {
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		setVisible(true);
		setSize(450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("采购信息删除");
		jCom.addItem("");
		jCom.addItem("数码产品");
		jCom.addItem("休闲服饰");
		jCom.addItem("虚拟用品");
		jCom.addItem("护肤产品");

		jText1.setEditable(false);
		jText2.setEditable(false);
		jText3.setEditable(false);
		jCom.setEditable(false);
		jText5.setEditable(false);
		jText6.setEditable(false);
		jText7.setEditable(false);
		jTArea.setEditable(false);
		jText1.setPreferredSize(new Dimension(75, 20));
		jText2.setPreferredSize(new Dimension(75, 20));
		jText3.setPreferredSize(new Dimension(75, 20));
		jCom.setPreferredSize(new Dimension(75, 20));
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
		pan1.setLayout(flow);
		flow.setAlignment(FlowLayout.LEFT);
		flow.setVgap(20);
		flow.setHgap(15);
		jBtn1.setBackground(new Color(175, 210, 250));
		jBtn2.setBackground(new Color(175, 210, 250));
		jBtn5.setBackground(new Color(175, 210, 250));
		pan1.add(jLab1);
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
		pan3.add(jBtn5, c);
		pan100.add(pan1, BorderLayout.NORTH);
		pan100.add(pan2, BorderLayout.CENTER);
		pan100.add(pan3, BorderLayout.SOUTH);
		con.add(pan100);
		validate();
		jBtn1.addActionListener(this);
		jBtn2.addActionListener(this);

		jBtn5.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jBtn1) {
			Iselect dlg = new Iselect();
			Dimension frmSize = getSize();
			Dimension dlgSize = dlg.getSize();
			Point loc = getLocation();
			dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
					(frmSize.height - dlgSize.height) / 2 + loc.y);
		}
		if (e.getSource() == jBtn2) {
			String sql;
			sql = "delete from Purchase where ID=";
			sql += jText6.getText().trim();
			if (db.executeSql(sql)) {
				JOptionPane.showMessageDialog(null, "删除信息成功，请点击确定后继续！");
			} else {
				JOptionPane.showMessageDialog(null, "删除信息失败，请确定信息后重试！");
			}
		}

		if (e.getSource() == jBtn5) {
			this.dispose();
		}

	}

	public void showResull(ResultSet rs) {
		try {
			jText1.setText(rs.getString("Gname"));
			jText2.setText(rs.getString("Gprice"));
			jText3.setText(rs.getString("Gnumber"));
			jCom.setSelectedItem(rs.getString("Gtype"));
			jText5.setText(rs.getString("Tfee"));
			jText6.setText(rs.getString("ID"));
			jText7.setText(rs.getString("Supplier"));
			jTArea.setText(rs.getString("GRemark"));

		} catch (SQLException e1) {

		}
	}

	public void showResults(ResultSet rs) {
		try {

			jText1.setText(rs.getString("Gname"));
			jText2.setText(rs.getString("Gprice"));
			jText3.setText(rs.getString("Gnumber"));
			jCom.setSelectedItem(rs.getString("Gtype"));
			jText5.setText(rs.getString("Tfee"));
			jText6.setText(rs.getString("ID"));
			jText7.setText(rs.getString("Supplier"));
			jTArea.setText(rs.getString("GRemark"));

		} catch (SQLException d) {
		}

	}

	public static void main(String[] args) {
		ImportDelete importdelete = new ImportDelete();
	}
}
