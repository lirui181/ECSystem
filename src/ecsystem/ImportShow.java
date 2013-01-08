package ecsystem;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

/**
 * @author 李新忠、徐琴芳、范茂林、刘书齐
 * @version 1.0
 */
public class ImportShow extends JFrame implements ActionListener {
	DBManager db = new DBManager();

	ResultSet rs;

	Iselect select;
	JLabel jLab1 = new JLabel("您可以在文本框中输入您要查询的货品ID号");
	JLabel jLab2 = new JLabel("货品ID");
	JButton jBtn1 = new JButton("查询删除");
	JButton jBtn2 = new JButton("查询修改");
	JTextField jText = new JTextField();

	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel pan100 = new JPanel();
	JScrollPane jScroll = new JScrollPane();
	GridBagLayout gbc = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();
	FlowLayout flow = new FlowLayout();
	Container con = getContentPane();
	Vector arr = new Vector(1, 1);
	DefaultTableModel model = new DefaultTableModel();
	JTable jTable = new JTable(model);

	public ImportShow() {
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
		setTitle("采购信息货品一览");
		pan1.setBackground(new Color(175, 210, 250));
		pan1.setPreferredSize(new Dimension(450, 40));
		pan100.setBackground(new Color(175, 210, 250));
		pan100.setPreferredSize(new Dimension(450, 300));
		pan1.setLayout(gbc);
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 20, 5, 200);
		pan2.setBackground(new Color(175, 210, 250));
		jBtn1.setBackground(new Color(175, 210, 250));
		pan1.add(jLab1, c);

		jScroll.setPreferredSize(new Dimension(430, 160));
		model.addColumn("ID号");
		model.addColumn("名称");

		model.addColumn("价格");
		model.addColumn("数量");
		model.addColumn("类别");
		model.addColumn("其他");
		model.addColumn("年");
		model.addColumn("月");
		model.addColumn("日");
		model.addColumn("总额");
		jScroll.getViewport().add(jTable);

		pan2.setPreferredSize(new Dimension(450, 50));
		jText.setPreferredSize(new Dimension(100, 20));
		pan2.setLayout(flow);
		flow.setVgap(10);
		pan2.add(jLab2);
		pan2.add(jText);
		pan2.add(jBtn1);
		pan2.add(jBtn2);
		pan100.add(pan1, BorderLayout.NORTH);
		pan100.add(jScroll, BorderLayout.CENTER);
		pan100.add(pan2, BorderLayout.SOUTH);
		con.add(pan100);
		validate();
		jBtn2.addActionListener(this);
		jBtn1.addActionListener(this);
	}

	public void showResult(ResultSet rs) {
		try {
			rs.beforeFirst();
			while (rs.next()) {
				Vector temp = new Vector(1, 1);
				temp.add(rs.getString("ID"));
				temp.add(rs.getString("Gname"));
				temp.add(rs.getString("Gprice"));
				temp.add(rs.getString("Gnumber"));
				temp.add(rs.getString("Gtype"));
				temp.add(rs.getString("Tfee"));
				temp.add(rs.getInt("GIyear"));
				temp.add(rs.getInt("GImonth"));
				temp.add(rs.getInt("GIday"));
				temp.add(rs.getInt("Pfee"));
				model.addRow(temp);
			}
		} catch (SQLException e1) {

		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jBtn1) {
			String sql;
			if (jText.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "ID号不能为空");
			}
			if (!jText.getText().trim().equals("")) {
				sql = "select * from Purchase where ID="
						+ Integer.parseInt(jText.getText().trim());
				rs = db.getResult(sql);
				boolean isexist = false;
				try {
					isexist = rs.first();
				} catch (SQLException e3) {

				}

				if (!isexist) {
					JOptionPane
							.showMessageDialog(null, "查找信息与数据库中信息不符，请确认后再输入");
				} else {
					ImportDelete100 importdelete = new ImportDelete100();

					Dimension frmSize = getSize();
					Dimension dlgSize = importdelete.getSize();
					Point loc = getLocation();
					importdelete.setLocation((frmSize.width - dlgSize.width)
							/ 2 + loc.x, (frmSize.height - dlgSize.height) / 2
							+ loc.y);

					importdelete.showResults(rs);
				}

			}
		}

		if (e.getSource() == jBtn2) {
			String sql;
			if (jText.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "ID号不能为空");
			}
			if (!jText.getText().trim().equals("")) {
				sql = "select * from Purchase where ID="
						+ Integer.parseInt(jText.getText().trim());
				rs = db.getResult(sql);
				boolean isexist = false;
				try {
					isexist = rs.first();
				} catch (SQLException e3) {

				}

				if (!isexist) {
					JOptionPane
							.showMessageDialog(null, "查找信息与数据库中信息不符，请确认后再输入");
				} else {
					ImportUpdate100 importupdate = new ImportUpdate100();

					Dimension frmSize = getSize();
					Dimension dlgSize = importupdate.getSize();
					Point loc = getLocation();
					importupdate.setLocation((frmSize.width - dlgSize.width)
							/ 2 + loc.x, (frmSize.height - dlgSize.height) / 2
							+ loc.y);

					importupdate.showResults(rs);
				}

			}
		}
	}

	public static void main(String[] args) {
		ImportShow importshow = new ImportShow();
	}

}
