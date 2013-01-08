package ecsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 * @author 李新忠、徐琴芳、范茂林、刘书齐
 * @version 1.0
 */
public class Userlogin extends JDialog implements ActionListener {
    MainWindow MM;
    DBManager db=new DBManager();
    ResultSet rs;
    JLabel jLab1=new JLabel("用户名");
    JLabel jLab2=new JLabel("密 码");
    JTextField jText1=new JTextField();
    JPasswordField jText2=new JPasswordField();
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


    public Userlogin(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public Userlogin() {
        this(new Frame(), "Userlogin", false);
    }
    public Userlogin(MainWindow mm) {
            this(new Frame(), "Userlogin", false);
            MM=mm;
        }

    private void jbInit() throws Exception {
        setVisible(true);
        setResizable(false);
        setTitle("用户登陆");
        setSize(250,180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel pane = new JPanel();
      pane.setLayout(gridbag);

    //网络布袋布局
     buildConstraints(constraints, 0, 0, 1, 1, 40, 30);
     constraints.fill = GridBagConstraints.NONE;
     constraints.anchor = GridBagConstraints.CENTER;
     gridbag.setConstraints(jLab1, constraints);
     pane.add(jLab1);


      buildConstraints(constraints, 0, 1, 1, 1, 0, 30);
      constraints.fill = GridBagConstraints.NONE;
      constraints.anchor = GridBagConstraints.CENTER;
      gridbag.setConstraints(jLab2, constraints);
      pane.add(jLab2);

     buildConstraints(constraints, 1, 0, 1, 1, 60, 0);
     constraints.fill = GridBagConstraints.NONE;
     constraints.anchor = GridBagConstraints.WEST;
     gridbag.setConstraints(jText1, constraints);
     pane.add(jText1);
     jText1.setPreferredSize(new Dimension(100,20));


    buildConstraints(constraints, 1, 1, 1, 1, 0, 0);
    constraints.fill = GridBagConstraints.NONE;
    constraints.anchor = GridBagConstraints.WEST;
    gridbag.setConstraints(jText2, constraints);
    pane.add(jText2);
   jText2.setPreferredSize(new Dimension(100,20));

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
   }



//添加事件
   public void actionPerformed(ActionEvent e)
           {
               if(e.getSource()==jBtn1)
               {
                   if(jText1.getText().trim().equals(""))
                   {
                       JOptionPane.showMessageDialog(null,"用户名不能为空");
                       return;
                   }
                   String s = new String(jText2.getPassword());
                   if(s.trim().equals(""))
                   {
                       JOptionPane.showMessageDialog(null,"密码不能为空");
                       return;
                   }

                   String sql="select * from System where Uname='"+jText1.getText().trim()+"'and Upassword='"+jText2.getText().trim()+"'";
                   rs=db.getResult(sql);
                   boolean isexist=true;
                   try{
                       isexist=rs.first();
                   }
                   catch(Exception eh)
                   {
                      JOptionPane.showMessageDialog(null,"操作异常");
                   }
                   if(isexist)
                   {
                       try{
                       rs.first();
                       MM.setEnable(rs.getString("Upower").trim());
                       JOptionPane.showMessageDialog(null,"登陆成功!");
                       this.dispose();}
                       catch(Exception e4)
                       {}


                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null,"用户名或密码错误!");
                       MM.setEnable("else");
                        return;

                   }

               }
               if(e.getSource()==jBtn2)
               {
                   MM.setEnable("else");
                   dispose();
               }
           }


   }


