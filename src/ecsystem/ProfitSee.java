package ecsystem;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import java.util.*;

public class ProfitSee extends JFrame implements ActionListener{
     DBManager db=new DBManager();
     float[] oursize={0,0,0,0,0,0,0};

     ResultSet rs;
     GridBagConstraints gbc=new GridBagConstraints();
     JLabel jLab1=new JLabel("销售收入");
     JLabel jLab2=new JLabel("采购支出");
     JLabel jLab3=new JLabel("其他收入");
     JLabel jLab4=new JLabel("其他支出");
     JLabel jLab5=new JLabel("总 收 入");
     JLabel jLab6=new JLabel("总 支 出");
     JLabel jLab7=new JLabel("总 利 润");
     JLabel jLab8=new JLabel("年");
     JLabel jLab9=new JLabel("月");

     JLabel jLab100=new JLabel("输入相应的条件，点击确定查询");
     Calendar calendar=Calendar.getInstance();


     JTextField jText1=new JTextField();
     JTextField jText2=new JTextField();
     JTextField jText3=new JTextField();
     JTextField jText4=new JTextField();
     JTextField jText5=new JTextField();
     JTextField jText6=new JTextField();
     JTextField jText7=new JTextField();
     JTextField jText8=new JTextField();
     JTextField jText9=new JTextField();



     JButton jBtn1=new JButton("确定");
     JButton jBtn2=new JButton("退出");



     FlowLayout f=new FlowLayout(FlowLayout.LEFT,20,20);
     JPanel pan1=new JPanel(f);
     JPanel pan2=new JPanel();
     JPanel pan3=new JPanel();
     JPanel pan4=new JPanel();
     JPanel pan5=new JPanel();


    public ProfitSee() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        setResizable(false);
        setTitle("利润信息查看");
        setSize(350,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container con=this.getContentPane();
        pan2.setLayout(new BorderLayout());
        pan4.setLayout(new GridBagLayout());
        pan5.setLayout(new GridBagLayout());
        jText1.setEditable(false);
        jText1.setHorizontalAlignment(JTextField.RIGHT);
        jText2.setEditable(false);
        jText2.setHorizontalAlignment(JTextField.RIGHT);
        jText3.setEditable(false);
        jText3.setHorizontalAlignment(JTextField.RIGHT);
        jText4.setEditable(false);
        jText4.setHorizontalAlignment(JTextField.RIGHT);
        jText5.setEditable(false);
        jText5.setHorizontalAlignment(JTextField.RIGHT);
        jText6.setEditable(false);
        jText6.setHorizontalAlignment(JTextField.RIGHT);
        jText7.setEditable(false);
        jText7.setHorizontalAlignment(JTextField.RIGHT);
        jText8.setEditable(true);
        jText8.setHorizontalAlignment(JTextField.RIGHT);
        jText9.setEditable(true);
        jText9.setHorizontalAlignment(JTextField.RIGHT);
        jText1.setPreferredSize(new Dimension(75,20));
        jText2.setPreferredSize(new Dimension(75,20));
        jText3.setPreferredSize(new Dimension(75,20));
        jText4.setPreferredSize(new Dimension(75,20));
        jText5.setPreferredSize(new Dimension(75,20));
        jText6.setPreferredSize(new Dimension(75,20));
        jText7.setPreferredSize(new Dimension(75,20));

        jText8.setPreferredSize(new Dimension(40,20));
        jText9.setPreferredSize(new Dimension(30,20));
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.insets=new Insets(5,5,5,1);
        pan1.setBackground(new Color(175, 210, 250));
        pan2.setBackground(new Color(175, 210, 250));
        pan3.setBackground(new Color(175, 210, 250));
        jBtn1.setBackground(new Color(175, 210, 250));
        jBtn2.setBackground(new Color(175, 210, 250));
        pan4.add(jLab1,gbc);

        gbc.gridwidth=1;
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.insets=new Insets(5,1,5,5);
        pan4.add(jText1,gbc);

        gbc.gridwidth=1;
        gbc.gridx=2;
        gbc.gridy=0;
        gbc.insets=new Insets(5,5,5,1);
        pan4.add(jLab2,gbc);

        gbc.gridx=3;
        gbc.gridy=0;
        gbc.insets=new Insets(5,1,5,5);
        pan4.add(jText2,gbc);

        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.insets=new Insets(5,5,5,1);
        pan4.add(jLab3,gbc);

        gbc.gridwidth=1;
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.insets=new Insets(5,1,5,5);
        pan4.add(jText3,gbc);

        gbc.gridwidth=1;
        gbc.gridx=2;
        gbc.gridy=1;
        gbc.insets=new Insets(5,5,5,1);
        pan4.add(jLab4,gbc);

        gbc.gridx=3;
        gbc.gridy=1;
        gbc.insets=new Insets(5,1,5,5);
        pan4.add(jText4,gbc);

        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.insets=new Insets(5,5,5,1);
        pan4.add(jLab5,gbc);

        gbc.gridwidth=1;
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.insets=new Insets(5,1,5,5);
        pan4.add(jText5,gbc);

        gbc.gridwidth=1;
        gbc.gridx=2;
        gbc.gridy=2;
        gbc.insets=new Insets(5,5,5,1);
        pan4.add(jLab6,gbc);

        gbc.gridx=3;
        gbc.gridy=2;
        gbc.insets=new Insets(5,1,5,5);
        pan4.add(jText6,gbc);

        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.insets=new Insets(5,5,5,1);
        pan4.add(jLab7,gbc);

        gbc.gridwidth=1;
        gbc.gridx=1;
        gbc.gridy=3;
        gbc.insets=new Insets(5,1,5,5);
        pan4.add(jText7,gbc);
        pan4.setBackground(new Color(175, 210, 250));

        pan5.add(jText8);
        pan5.add(jLab8);
        pan5.add(jText9);
        pan5.add(jLab9);
        pan5.setBackground(new Color(175, 210, 250));


        pan1.add(jLab100);
        pan3.setPreferredSize(new Dimension(400,50));
        pan2.add(pan4,BorderLayout.CENTER);
        pan2.add(pan5,BorderLayout.SOUTH);
        pan3.add(jBtn1);
        pan3.add(jBtn2);

        jBtn1.addActionListener(this);
        jBtn2.addActionListener(this);


        con.add(pan1,BorderLayout.NORTH);
        con.add(pan2,BorderLayout.CENTER);
        con.add(pan3,BorderLayout.SOUTH);
        validate();

    }

    public void actionPerformed(ActionEvent e)
    {
        String sql1,sql2;
        ResultSet rs1,rs2;
        float[] size={0,0,0,0,0,0,0};
        if(e.getSource()==jBtn1)
        {
            jText1.setText("");
            jText2.setText("");
            jText3.setText("");
            jText4.setText("");
            jText5.setText("");
            jText6.setText("");
            jText7.setText("");
            if(jText8.getText().trim().equals("")||jText9.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(null,"文本域不能为空，请输入");
                return;
            }
            sql1="select * from Revenue where Styear=";
            sql2="select * from Cost where Styear=";
            sql1+=jText8.getText().trim()+" and Stmonth="+jText9.getText().trim();
            sql2+=jText8.getText().trim()+" and Stmonth="+jText9.getText().trim();
            rs1=db.getResult(sql1);
            rs2=db.getResult(sql2);
            boolean isexist1=false;
            boolean isexist2=false;
            try{
                isexist1=rs1.first();
            }catch(SQLException e1){}
            if(!isexist1)
            {
                JOptionPane.showMessageDialog(null,"收入信息暂时未添加，请稍后重试");
            }
            else
            {
                try{
                    rs1.beforeFirst();
                    while(rs1.next())
                    {
                        size[0]+=rs1.getInt("Ffee");
                        size[1]+=rs1.getInt("Orevenue");
                        size[2]+=rs1.getInt("Trevenue");
                    }
                    jText1.setText(String.valueOf(size[0]));
                    jText3.setText(String.valueOf(size[1]));
                    jText5.setText(String.valueOf(size[2]));
                }catch(SQLException e3){}
            }

            try{
                isexist2=rs2.first();
            }catch(SQLException e1){}
            if(!isexist2)
            {
                JOptionPane.showMessageDialog(null,"支出信息暂时未添加，请稍后重试");
            }
            else
            {
                try{
                    rs2.beforeFirst();
                    while(rs2.next())
                    {
                        size[3]+=rs2.getInt("Pfee");
                        size[4]+=rs2.getInt("Othercost");
                        size[5]+=rs2.getInt("Tcost");
                    }
                    jText2.setText(String.valueOf(size[3]));
                    jText4.setText(String.valueOf(size[4]));
                    jText6.setText(String.valueOf(size[5]));
                }catch(SQLException e3){}
            }
            size[6]=size[2]-size[5];
            jText7.setText(String.valueOf(size[6]));
            oursize=size;

            }

        if(e.getSource()==jBtn2)
        {
            dispose();
        }
    }

    public static void main(String[] args) {
        ProfitSee profitsee = new ProfitSee();
    }
}
