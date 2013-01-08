package ecsystem;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class IncomeAdd extends JFrame implements ActionListener{
    DBManager db=new DBManager();
    ResultSet rs;
    Calendar calendar=Calendar.getInstance();
    GridBagConstraints gbc=new GridBagConstraints();
    JLabel jLab1=new JLabel("ID  号");
    JLabel jLab2=new JLabel("总收入");
    JLabel jLab3=new JLabel("销售收入");
    JLabel jLab4=new JLabel("其他收入");
    JLabel jLab5=new JLabel("备  注");
    JLabel jLab100=new JLabel("请填写以下收入信息");

    JTextField jText1=new JTextField();
    JTextField jText2=new JTextField();
    JTextField jText3=new JTextField();
    JTextField jText4=new JTextField();
    JTextArea  jTArea=new JTextArea(4,20);

    JButton jBtn1=new JButton("计算");
    JButton jBtn2=new JButton("添加");
    JButton jBtn3=new JButton("退出");
    FlowLayout f=new FlowLayout(FlowLayout.LEFT,20,20);
    JPanel pan1=new JPanel(f);
    JPanel pan2=new JPanel();
    JPanel pan3=new JPanel();
     JScrollPane jScroll=new JScrollPane(jTArea);

    public IncomeAdd() {
        super.setTitle("收入信息添加");
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {

        calendar.setTime(new java.util.Date());
        setResizable(false);
        setTitle("收入信息");
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container con=this.getContentPane();
        calendar.setTime(new java.util.Date());
        pan2.setLayout(new GridBagLayout());
        jText1.setEditable(false);
        jText1.setHorizontalAlignment(JTextField.RIGHT);
        jText2.setEditable(false);
        jText2.setHorizontalAlignment(JTextField.RIGHT);
        jText3.setEditable(false);
        jText3.setHorizontalAlignment(JTextField.RIGHT);
        jText4.setHorizontalAlignment(JTextField.RIGHT);
        jTArea.setLineWrap(true);
        pan2.setBackground(new Color(175, 210, 250));
        pan3.setBackground(new Color(175, 210, 250));
        pan1.setBackground(new Color(175, 210, 250));

        pan1.add(jLab100);

       gbc.gridheight=1;
       gbc.gridwidth=1;
       gbc.insets=new Insets(5,5,5,5);
       pan2.add(jLab1,gbc);

        jText1.setPreferredSize(new Dimension(75,20));
        pan2.add(jText1,gbc);

        pan2.add(jLab2,gbc);

        gbc.gridwidth=GridBagConstraints.REMAINDER;
        jText2.setPreferredSize(new Dimension(75,20));
        pan2.add(jText2,gbc);

        gbc.gridwidth=1;
        pan2.add(jLab3,gbc);

        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.fill=GridBagConstraints.BOTH;
        pan2.add(jText3,gbc);


        gbc.gridwidth=1;
        pan2.add(jLab4,gbc);

         gbc.gridwidth=GridBagConstraints.REMAINDER;
         jText4.setPreferredSize(new Dimension(75,20));
         pan2.add(jText4,gbc);

         pan2.add(jLab5,gbc);

         pan2.add(jScroll,gbc);
         pan3.add(jBtn1);
         pan3.add(jBtn2);
         pan3.add(jBtn3);

        pan3.setPreferredSize(new Dimension(400,50));
        con.add(pan1,BorderLayout.NORTH);
        con.add(pan3,BorderLayout.SOUTH);
        con.add(pan2, java.awt.BorderLayout.CENTER);

        jBtn1.addActionListener(this);
        jBtn2.addActionListener(this);
        jBtn3.addActionListener(this);
        validate();



         addWindowListener(new WindowAdapter()
         {
             public void windowOpened(WindowEvent e)
             {
                 String sql1, sql2;
                 ResultSet rs1, rs2;
                 int sum1 = 0, sum2 = 0;
                 sql1 = "select Ffee from Sell where Fsyear=";
                 sql1 += calendar.get(Calendar.YEAR) + " and Fsmonth=";
                 sql1 += calendar.get(Calendar.MONTH) + 1 + " and Fsday=";
                 sql1 += calendar.get(Calendar.DAY_OF_MONTH);
                 rs1 = db.getResult(sql1);
                 boolean isexist = false;
                 try {
                     isexist = rs1.first();
                 } catch (SQLException e1) {}
                 if (!isexist) {
                     JOptionPane.showMessageDialog(null, "今日销售收入暂未添加，请稍后查询");
                     return;
                 } else {
                     try {
                         rs1.beforeFirst();
                         while (rs1.next()) {
                             sum1 += rs1.getInt("Ffee");
                         }
                         jText3.setText(String.valueOf(sum1));
                     } catch (SQLException e11)                    {

                    }
                }

            }
        }

                );
    }

    public void actionPerformed(ActionEvent e)
    {
        String sql;
        if (e.getSource() == jBtn1) {
            if (jText4.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "请在其他收入中输入数值（若没有则输入0)");
                return;
            }
            int sum;
            sum = Integer.parseInt(jText3.getText().trim()) +
                  Integer.parseInt(jText4.getText().trim());
            jText2.setText(String.valueOf(sum));

        }
        if (e.getSource() == jBtn2) {
            if (jText2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "请先点击计算按钮");
                return;
            }
            sql =
                    "insert into Revenue(Trevenue,Ffee,Orevenue,Ins,Styear,Stmonth,Stday) values(";
            sql+=Integer.parseInt(jText2.getText().trim()) + ",";
            sql+=Integer.parseInt(jText3.getText().trim()) + ",";
            sql+=Integer.parseInt(jText4.getText().trim())+",'";
            sql+=jTArea.getText().trim() + "',";
            sql+=calendar.get(Calendar.YEAR) + ",";
            sql+=calendar.get(Calendar.MONTH) + 1 + ",";
            sql+=calendar.get(Calendar.DAY_OF_MONTH) + ")";

            if (db.executeSql(sql)) {
                JOptionPane.showMessageDialog(null, "添加信息成功，请点击确定继续");
            } else {
                JOptionPane.showMessageDialog(null, "添加信息失败，请确认信息后重试");
            } }
            if (e.getSource() == jBtn3) {
                dispose();
            }
        }


    public void showResult(ResultSet rs) {
                 try {
                     jText1.setText(String.valueOf(rs.getInt("ID")));
                     jText2.setText(String.valueOf(rs.getInt("Trevenue")));
                     jText3.setText(String.valueOf(rs.getInt("Ffee")));
                     jText4.setText(String.valueOf(rs.getInt("Orevenue")));
                     jTArea.setText(String.valueOf(rs.getString("Ins")));
                 } catch (SQLException e1) {

                 }
             }

             public void setNull() {
                 jText1.setText("");
                 jText2.setText("");
                 jText3.setText("");
                 jText4.setText("");
                 jTArea.setText("");
             }

    public static void main(String[] args) {
        IncomeAdd incomeadd = new IncomeAdd();
    }
 }
