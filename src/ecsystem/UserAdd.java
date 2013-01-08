package ecsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

/**
 * @author 李新忠、徐琴芳、范茂林、刘书齐
 * @version 1.0
 */
public class UserAdd extends JFrame implements ActionListener{
    DBManager db=new DBManager();
    ResultSet rs;
    JLabel jLab2=new JLabel("登陆帐户");
    JLabel jLab3=new JLabel("登陆密码");
    JLabel jLab4=new JLabel("确认密码");
    JLabel jLab5=new JLabel("用户权限");
    JLabel jLab1=new JLabel("欢迎您登陆,请添加以下用户信息");

    JTextField jText1=new JTextField();
    JPasswordField jText2=new JPasswordField();
    JPasswordField jText3=new JPasswordField();
    JComboBox jCom1=new JComboBox();

    JButton jBtn1=new JButton("确定");
    JButton jBtn2=new JButton("取消");

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



    public UserAdd() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        setResizable(false);
        setTitle("帐户信息添加");
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel pane = new JPanel();
        pane.setLayout(gridbag);

//网络布袋布局
       buildConstraints(constraints, 0, 0, 2, 1, 0, 25);
       constraints.fill = GridBagConstraints.NONE;
       constraints.anchor = GridBagConstraints.NORTHWEST;
       gridbag.setConstraints(jLab1, constraints);
        jText1.setSelectionEnd(10);
        pane.add(jLab1);


        buildConstraints(constraints, 0, 1, 1, 1, 25, 15);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        gridbag.setConstraints(jLab2, constraints);
        pane.add(jLab2);




     buildConstraints(constraints, 0, 2, 1, 1, 0, 15);
     constraints.fill = GridBagConstraints.NONE;
     constraints.anchor = GridBagConstraints.CENTER;
     gridbag.setConstraints(jLab3, constraints);
     pane.add(jLab3);


    buildConstraints(constraints, 0, 3, 1, 1, 0, 15);
    constraints.fill = GridBagConstraints.NONE;
    constraints.anchor = GridBagConstraints.CENTER;
    gridbag.setConstraints(jLab4, constraints);
    pane.add(jLab4);


   buildConstraints(constraints, 0, 4, 1, 1, 0, 15);
   constraints.fill = GridBagConstraints.NONE;
   constraints.anchor = GridBagConstraints.CENTER;
   gridbag.setConstraints(jLab5, constraints);
   pane.add(jLab5);


   buildConstraints(constraints, 1, 1, 1, 1, 65,0);
   constraints.fill = GridBagConstraints.HORIZONTAL;
   constraints.anchor = GridBagConstraints.CENTER;
   gridbag.setConstraints(jText1, constraints);
   pane.add(jText1);

   buildConstraints(constraints, 1, 2, 1, 1, 0, 0);
   constraints.fill = GridBagConstraints.HORIZONTAL;
   constraints.anchor = GridBagConstraints.CENTER;
   gridbag.setConstraints(jText2, constraints);
   pane.add(jText2);


   buildConstraints(constraints, 1, 3, 1, 1, 0, 0);
   constraints.fill = GridBagConstraints.HORIZONTAL;
   constraints.anchor = GridBagConstraints.CENTER;
   gridbag.setConstraints(jText3, constraints);
   pane.add(jText3);

   jCom1.addItem("系统管理员");
   jCom1.addItem("一般管理员");
  buildConstraints(constraints, 1, 4, 1, 1, 0, 0);
  constraints.fill = GridBagConstraints.HORIZONTAL;
  constraints.anchor = GridBagConstraints.CENTER;
  gridbag.setConstraints(jCom1, constraints);
  pane.add(jCom1);




   buildConstraints(constraints, 0, 5, 1, 1, 0, 15);
   constraints.fill = GridBagConstraints.NONE;
   constraints.anchor = GridBagConstraints.EAST;
   gridbag.setConstraints(jBtn1, constraints);
   pane.add(jBtn1);
   jBtn1.setBackground(new Color(175, 210, 250));



  buildConstraints(constraints, 1, 5, 1, 1, 0, 0);
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
}//添加事件
public void actionPerformed(ActionEvent e)
   {
       String strSQL;
       if(e.getSource()==jBtn1)
       {
           if (jText1.getText().trim().equals("")) {
               JOptionPane.showMessageDialog(null, "登陆帐户不能为空");
               return;
           }
           if (jText2.getText().trim().equals("")) {
               JOptionPane.showMessageDialog(null, "登陆密码不能为空");
               return;
           }
           if (jText3.getText().trim().equals("")) {
               JOptionPane.showMessageDialog(null, "确认密码不能为空");
               return;
           }
           if (!jText2.getText().trim().equals(jText3.getText().trim())) {
               JOptionPane.showMessageDialog(null, "登录密码和确认密码不一致");
               return;
           }

           strSQL = "select * from System where Uname='" +jText1.getText().trim() + "'";
           rs = db.getResult(strSQL);
           boolean isexist = false;
           try {
               isexist = rs.first();
           } catch (SQLException ex1) {
           }
           //若用户名存在，提示警告信息
           if (isexist)

           {
               JOptionPane.showMessageDialog(null, "用户名已存在！");
           } else {
               //然后执行插入操作
               strSQL = "insert into System(Uname,Upassword,Upower) values('";
               strSQL = strSQL + jText1.getText().trim() + "','";

               strSQL = strSQL + jText2.getText().trim() + "','";
               strSQL = strSQL +jCom1.getSelectedItem().toString().trim() +"')";
               //由数据库操作对象执行数据库操作，并返回操作成功失败的提示信息
               if (db.executeSql(strSQL)) {
                   JOptionPane.showMessageDialog(null, "添加信息成功，请点击确定继续");
               } else {
                   JOptionPane.showMessageDialog(null, " 添加信息失败，请确认后重试！");
               }
           }
       }
       if(e.getSource()==jBtn2)
       {
           this.dispose();
       }
   }

   public static void main(String[] args) {

           UserAdd useradd = new UserAdd();


       }

}

