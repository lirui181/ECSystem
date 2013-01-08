package ecsystem;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


//用户删除窗口
public class UserDelete extends JFrame implements ActionListener{

     DBManager db=new DBManager();
     ResultSet rs;
     DefaultTableModel model =new DefaultTableModel();
     JTable jTable=new JTable(model);
     JScrollPane jScroll=new JScrollPane(jTable);
     JLabel jLab2=new JLabel("帐户ID号");
     JLabel jLab1=new JLabel("在文本框中输入您要删除的帐户ID号");
     Vector temp=new Vector(1,1);
     String sql;

     JTextField jText1=new JTextField();

     JButton jBtn1=new JButton("删除");
     JButton jBtn2=new JButton("退出");




//定义网络布袋布局方法
void buildConstraints(GridBagConstraints gbc, int gx, int gy,
int gw, int gh, int wx, int wy) {
gbc.gridx = gx;
gbc.gridy = gy;
gbc.gridwidth = gw;
gbc.gridheight = gh;
gbc.weightx = wx;
gbc.weighty = wy;
}

public UserDelete() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }



//定义构造方法
private void jbInit() throws Exception {
        setResizable(false);
        setTitle("帐户信息删除");
        setSize(500,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


GridBagLayout gridbag = new GridBagLayout();
GridBagConstraints constraints = new GridBagConstraints();
JPanel pane = new JPanel();
pane.setLayout(gridbag);



//网络布袋布局
buildConstraints(constraints, 0, 0, 3, 1, 0, 20);
constraints.fill = GridBagConstraints.NONE;
constraints.anchor = GridBagConstraints.WEST;
gridbag.setConstraints(jLab1, constraints);
        jScroll.getViewport().setBackground(new Color(175, 210, 250));
        jScroll.setForeground(Color.black);
        jScroll.setAutoscrolls(true);
        jScroll.setToolTipText("");
        pane.add(jLab1);


buildConstraints(constraints, 0, 1, 1, 1, 10, 40);
constraints.fill = GridBagConstraints.NONE;
constraints.anchor = GridBagConstraints.CENTER;
gridbag.setConstraints(jLab2, constraints);
pane.add(jLab2);


buildConstraints(constraints, 1, 1, 1, 1, 10, 0);
constraints.fill = GridBagConstraints.HORIZONTAL;
constraints.anchor = GridBagConstraints.CENTER;
gridbag.setConstraints(jText1, constraints);
pane.add(jText1);

model.addColumn("用户ID号");
        model.addColumn("用户帐户");
        model.addColumn("用户密码");
        model.addColumn("用户权限");
buildConstraints(constraints, 2, 1, 1, 2, 80, 0);
constraints.fill = GridBagConstraints.BOTH;
gridbag.setConstraints(jScroll, constraints);
pane.add(jScroll);

buildConstraints(constraints, 0, 2, 1, 1, 0, 40);
constraints.fill = GridBagConstraints.NONE;
constraints.anchor = GridBagConstraints.EAST;
gridbag.setConstraints(jBtn1, constraints);
pane.add(jBtn1);
jBtn1.setBackground(new Color(175, 210, 250));



buildConstraints(constraints, 1, 2, 1, 1, 0, 0);
constraints.fill = GridBagConstraints.NONE;
constraints.anchor = GridBagConstraints.CENTER;
gridbag.setConstraints(jBtn2, constraints);
pane.add(jBtn2);
jBtn2.setBackground(new Color(175, 210, 250));

//添加按钮监听器
jBtn1.addActionListener(this);
jBtn2.addActionListener(this);



// Content Pane
        pane.setBackground(new Color(175, 210, 250));
setContentPane(pane);
validate();



//添加事件
addWindowListener(new WindowAdapter()
                {
                    public void windowOpened(WindowEvent e)
                    {
                        String sql;
                        sql="select * from System";
                        rs=db.getResult(sql);
                        boolean isexist=false;
        try{
            isexist=rs.first();
        }
        catch(SQLException e1){}

        if(!isexist){
            JOptionPane.showMessageDialog(null,"数据库中暂不存在帐户信息");
            return;
        }
        else
        {
            for(int n=model.getRowCount()-1;n>=0;n--)model.removeRow(n);
            try{rs.beforeFirst();
                while (rs.next()) {
                    temp=new Vector(1, 1);
                    temp.add(rs.getString("UID"));
                    temp.add(rs.getString("Uname"));
                    temp.add(rs.getString("Upassword"));
                    temp.add(rs.getString("Upower"));
                    model.addRow(temp);
                }
            }
            catch(SQLException e1){}
        }

                    }

                }
                    );
        validate();


    }


//添加事件
public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == jBtn1) {
            try {
                sql = "delete from System where UID=" +Integer.parseInt(jText1.getText().trim());
            } catch (Exception e1) {}

            if (db.executeSql(sql)) {
                JOptionPane.showMessageDialog(null, "删除信息成功，点击确定继续");
                sql = "select * from System";
                rs = db.getResult(sql);
                boolean isexist = false;
                try {
                    isexist = rs.first();
                } catch (SQLException e1) {}

                if (!isexist) {
                    JOptionPane.showMessageDialog(null, "数据库中暂不存在帐户信息");
                    return;
                } else {
                    for (int n = model.getRowCount() - 1; n >= 0; n--)
                        model.removeRow(n);
                    try {
                        rs.beforeFirst();
                        while (rs.next()) {
                            temp = new Vector(1, 1);
                            temp.add(rs.getString("UID"));
                            temp.add(rs.getString("Uname"));
                            temp.add(rs.getString("Upassword"));
                            temp.add(rs.getString("Upower"));
                            model.addRow(temp);
                        }
                    } catch (SQLException e1) {}

                }
            } else {
                JOptionPane.showMessageDialog(null, "删除信息失败，请确认信息后重试");
            }
        }
        if(e.getSource()==jBtn2)
        {
            dispose();
        }
    }

public static void main(String[] args) {

        UserDelete userdelete = new UserDelete();
           }
}
