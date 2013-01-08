package ecsystem;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
/**
 * @author 李新忠、徐琴芳、范茂林、刘书齐
 * @version 1.0
 */
public class SellWindow extends JFrame implements ActionListener,ItemListener  {
 DBManager db=new DBManager();
  ResultSet rs;
 JTabbedPane jpane=new JTabbedPane();
 JComboBox jCom1=new JComboBox();
 JComboBox jCom2=new JComboBox();
 JComboBox jCom3=new JComboBox();
 JComboBox jCom4=new JComboBox();
 JPanel pan1=new JPanel();

 JPanel pan2=new JPanel();//固定

 JPanel pan3=new JPanel();//虚拟

 JPanel pan4=new JPanel();//护肤

 JPanel pan5=new JPanel();//服饰

 JLabel jLab1=new JLabel("单价");
 JLabel jLab2=new JLabel("特价");
 JLabel jLab3=new JLabel("数量");
 JLabel jLab31=new JLabel("金额");

 JLabel jLab4=new JLabel("总金额");

 JLabel jLab5=new JLabel("单价");
 JLabel jLab6=new JLabel("特价");
 JLabel jLab7=new JLabel("数量");
 JLabel jLab71=new JLabel("金额");

 JLabel jLab8=new JLabel("单价");
 JLabel jLab9=new JLabel("特价");
 JLabel jLab10=new JLabel("数量");
 JLabel jLab101=new JLabel("金额");

 JLabel jLab11=new JLabel("单价");
 JLabel jLab12=new JLabel("特价");
 JLabel jLab13=new JLabel("数量");
 JLabel jLab131=new JLabel("金额");





 JTextField jText1=new JTextField("0");
 JTextField jText2=new JTextField("0");
 JTextField jText3=new JTextField();
 JTextField jText31=new JTextField("0");

 JTextField jText4=new JTextField();//固定

 JTextField jText5=new JTextField("0");//数码
 JTextField jText6=new JTextField("0");
 JTextField jText7=new JTextField();
  JTextField jText71=new JTextField("0");

 JTextField jText8=new JTextField("0");//虚拟
 JTextField jText9=new JTextField("0");
 JTextField jText10=new JTextField();
 JTextField jText101=new JTextField("0");

 JTextField jText11=new JTextField("0");//护肤
 JTextField jText12=new JTextField("0");
 JTextField jText13=new JTextField();
 JTextField jText131=new JTextField("0");








 JCheckBox jCheck1=new JCheckBox("特价商品");//服饰
 JCheckBox jCheck2=new JCheckBox("VIP功能");
 JButton jBtn1=new JButton("添加");

 JButton jBtn2=new JButton("清空");
 JButton jBtn3=new JButton("添加");
 JButton jBtn4=new JButton("添加");
 JButton jBtn5=new JButton("添加");
 Container con=getContentPane();
 FlowLayout flow=new FlowLayout();
 GridBagLayout gbc=new GridBagLayout();
 GridBagConstraints c=new GridBagConstraints();




 public SellWindow() {
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

     jCom1.setPreferredSize(new Dimension(140, 20));
     jText1.setPreferredSize(new Dimension(75, 20));
     jText2.setPreferredSize(new Dimension(75, 20));
     jText3.setPreferredSize(new Dimension(75, 20));
     jText31.setPreferredSize(new Dimension(75, 20));

     jText4.setPreferredSize(new Dimension(75, 20));

     jCom2.setPreferredSize(new Dimension(140, 20));
     jText5.setPreferredSize(new Dimension(75,20));
     jText6.setPreferredSize(new Dimension(75,20));
     jText7.setPreferredSize(new Dimension(75,20));
      jText71.setPreferredSize(new Dimension(75,20));

      jCom3.setPreferredSize(new Dimension(140, 20));
     jText8.setPreferredSize(new Dimension(75,20));
     jText9.setPreferredSize(new Dimension(75,20));
     jText10.setPreferredSize(new Dimension(75,20));
     jText101.setPreferredSize(new Dimension(75,20));

     jCom4.setPreferredSize(new Dimension(140, 20));
     jText11.setPreferredSize(new Dimension(75,20));
     jText12.setPreferredSize(new Dimension(75,20));
     jText13.setPreferredSize(new Dimension(75,20));
      jText131.setPreferredSize(new Dimension(75,20));
        jBtn1.setBackground(new Color(175, 210, 250));

        jBtn1.setPreferredSize(new Dimension(75,20));
      jBtn3.setPreferredSize(new Dimension(75,20));
      jBtn4.setPreferredSize(new Dimension(75,20));
      jBtn5.setPreferredSize(new Dimension(75,20));
        pan1.setBackground(new Color(175, 210, 250));
        pan1.setPreferredSize(new Dimension(450,250));
        pan2.setBackground(new Color(175, 210, 250));

        pan2.setPreferredSize(new Dimension(450,75));//固定的面板

     pan3 .setPreferredSize(new Dimension(450,250));
     pan3.setBackground(new Color(175, 210, 250));
     pan4.setPreferredSize(new Dimension(450,250));
     pan4.setBackground(new Color(175, 210, 250));
     pan5.setPreferredSize(new Dimension(450,250));
     pan5.setBackground(new Color(175, 210, 250));
     setTitle("销售窗口");









           jCom1.addItem("请选售出的产品");


           jText1.setEditable(false);
           jText2.setEditable(false);
           jText5.setEditable(false);
           jText6.setEditable(false);
           jText8.setEditable(false);
           jText9.setEditable(false);
           jText11.setEditable(false);
           jText12.setEditable(false);
           jText31.setEditable(false);
           jText71.setEditable(false);
           jText101.setEditable(false);
           jText131.setEditable(false);
           pan1.setLayout(gbc);
           c.gridwidth=1;
           c.gridheight=1;
           c.gridx=0;
           c.gridy=0;
           c.insets=new Insets(10,1,5,5);
        jpane.setBackground(new Color(175, 210, 250));
        jCheck1.setBackground(new Color(175, 210, 250));
        jCheck2.setBackground(new Color(175, 210, 250));
        jBtn2.setBackground(new Color(175, 210, 250));
        pan1.add(jCom1,c);
           c.gridx=1;
           c.gridy=0;
           c.insets=new Insets(10,5,5,1);
           pan1.add(jLab1,c);
           c.gridx=2;
           c.gridy=0;
           c.insets=new Insets(10,1,5,10);
           pan1.add(jText1,c);
           c.gridx=3;
           c.gridy=0;
           c.insets=new Insets(10,5,5,1);
           pan1.add(jLab2,c);
           c.gridx=4;
           c.gridy=0;
           c.insets=new Insets(10,1,5,40);
           pan1.add(jText2,c);
           c.gridx=1;
           c.gridy=1;
           c.insets=new Insets(5,5,10,1);
           pan1.add(jLab3,c);
           c.gridx=2;
           c.gridy=1;
           c.insets=new Insets(5,1,10,10);
           pan1.add(jText3,c);
           c.gridx=3;
            c.gridy=1;
            c.insets=new Insets(5,5,10,1);
            pan1.add(jLab31,c);
            c.gridx=4;
            c.gridy=1;
            c.insets=new Insets(5,1,10,40);
            pan1.add(jText31,c);
            c.gridx=4;
           c.gridy=3;
           c.insets=new Insets(25,1,10,40);
           pan1.add(jBtn1,c);
           jpane.add("护肤产品",pan4);


           pan2.setLayout(flow);
           flow.setVgap(20);
           pan2.add(jCheck1);
           pan2.add(jCheck2);
           pan2.add(jLab4);
           pan2.add(jText4);
           pan2.add(jBtn2);

           jpane.add("数码产品",pan1);

           jCom2.addItem("请选择售出的虚拟用品");//虚拟类

          pan3.setLayout(gbc);
          c.gridwidth=1;
          c.gridheight=1;
          c.gridx=0;
          c.gridy=0;
          c.insets=new Insets(10,1,5,5);
          pan3.add(jCom2,c);
          c.gridx=1;
          c.gridy=0;
          c.insets=new Insets(10,5,5,1);
          pan3.add(jLab5,c);
          c.gridx=2;
          c.gridy=0;
          c.insets=new Insets(10,1,5,10);
          pan3.add(jText5,c);
          c.gridx=3;
          c.gridy=0;
          c.insets=new Insets(10,5,5,1);
          pan3.add(jLab6,c);
          c.gridx=4;
          c.gridy=0;
          c.insets=new Insets(10,1,5,40);
          pan3.add(jText6,c);
          c.gridx=1;
          c.gridy=1;
          c.insets=new Insets(5,10,10,1);
          pan3.add(jLab7,c);
          c.gridx=2;
          c.gridy=1;
          c.insets=new Insets(5,1,10,10);
          pan3.add(jText7,c);
          c.gridx=3;
           c.gridy=1;
           c.insets=new Insets(5,5,10,1);
           pan3.add(jLab71,c);
           c.gridx=4;
           c.gridy=1;
           c.insets=new Insets(5,1,10,40);
           pan3.add(jText71,c);
          c.gridx=4;
            c.gridy=3;
            c.insets=new Insets(25,1,10,40);
            pan3.add(jBtn3,c);

          jpane.add("虚拟用品",pan3);

          jCom3.addItem("请选择要售出的护肤产品");//护肤类


          pan4.setLayout(gbc);
          c.gridwidth=1;
          c.gridheight=1;
          c.gridx=0;
          c.gridy=0;
          c.insets=new Insets(10,1,5,5);
          pan4.add(jCom3,c);
          c.gridx=1;
          c.gridy=0;
          c.insets=new Insets(10,5,5,1);
          pan4.add(jLab8,c);
          c.gridx=2;
          c.gridy=0;
          c.insets=new Insets(10,1,5,10);
          pan4.add(jText8,c);
          c.gridx=3;
          c.gridy=0;
          c.insets=new Insets(10,5,5,1);
          pan4.add(jLab9,c);
          c.gridx=4;
          c.gridy=0;
          c.insets=new Insets(10,1,5,40);
          pan4.add(jText9,c);
          c.gridx=1;
          c.gridy=1;
          c.insets=new Insets(5,10,10,1);
          pan4.add(jLab10,c);
          c.gridx=2;
          c.gridy=1;
          c.insets=new Insets(5,1,10,10);
          pan4.add(jText10,c);
          c.gridx=3;
           c.gridy=1;
           c.insets=new Insets(5,5,10,1);
           pan4.add(jLab101,c);
           c.gridx=4;
           c.gridy=1;
           c.insets=new Insets(5,1,10,40);
           pan4.add(jText101,c);
           c.gridx=4;
           c.gridy=3;
           c.insets=new Insets(25,1,10,40);
           pan4.add(jBtn4,c);

          jpane.add("护肤产品",pan4);

          jCom4.addItem("请选择要售出的休闲服饰");//休闲服饰


             pan5.setLayout(gbc);
             c.gridwidth=1;
             c.gridheight=1;
             c.gridx=0;
             c.gridy=0;
             c.insets=new Insets(10,1,5,5);
             pan5.add(jCom4,c);
             c.gridx=1;
             c.gridy=0;
             c.insets=new Insets(10,5,5,1);
             pan5.add(jLab11,c);
             c.gridx=2;
             c.gridy=0;
             c.insets=new Insets(10,1,5,10);
             pan5.add(jText11,c);
             c.gridx=3;
             c.gridy=0;
             c.insets=new Insets(10,5,5,1);
             pan5.add(jLab12,c);
             c.gridx=4;
             c.gridy=0;
             c.insets=new Insets(10,1,5,40);
             pan5.add(jText12,c);
             c.gridx=1;
             c.gridy=1;
             c.insets=new Insets(5,10,10,1);
             pan5.add(jLab13,c);
             c.gridx=2;
             c.gridy=1;
             c.insets=new Insets(5,1,10,10);
             pan5.add(jText13,c);
             c.gridx=3;
           c.gridy=1;
           c.insets=new Insets(5,5,10,1);
           pan5.add(jLab131,c);
           c.gridx=4;
           c.gridy=1;
           c.insets=new Insets(5,1,10,40);
           pan5.add(jText131,c);
           c.gridx=4;
           c.gridy=3;
           c.insets=new Insets(25,1,10,40);
           pan5.add(jBtn5,c);

          jpane.add("护肤产品",pan4);

             jpane.add("休闲服饰",pan5);
            con.add(jpane,BorderLayout.CENTER);
           con.add(pan2,BorderLayout.SOUTH);

           validate();

           addWindowListener(new WindowAdapter()
                        {
                            String sql;
                            public void windowOpened(WindowEvent e)
                            {
                                sql="select * from Fmenu";
                                rs=db.getResult(sql);
                                boolean isexist=false;
                                try{
                                    isexist=rs.first();
                                }
                                catch(SQLException e5)
                                {

                                }
                                if(!isexist)
                                {
                                    JOptionPane.showMessageDialog(null,"该数据库中暂时无信息");
                                }
                                else
                                {

                              try{
                                   rs.beforeFirst();
                                   while(rs.next())
                                {

                                    if(rs.getString("Mtype").equals("数码产品") )
                                   {
                                       jCom1.addItem(rs.getString("Mname"));
                                   }


                                  else if((rs.getString("Mtype").equals("虚拟用品")))

                                    {
                                       jCom2.addItem(rs.getString("Mname"));
                                    }
                                }
                                 rs.beforeFirst();
                                 while(rs.next())
                                    {
                                    if((rs.getString("Mtype").equals("护肤产品")))
                                        {
                                      jCom3.addItem(rs.getString("Mname"));
                                      }


                                else  if((rs.getString("Mtype").equals("休闲服饰")))
                                    {
                                 jCom4.addItem(rs.getString("Mname"));
                                   }
                             }




                                }
               catch(SQLException e1)
               {

               }

                                }
                            }
                        }
                            );




            jBtn1.addActionListener(this);
            jBtn2.addActionListener(this);
            jBtn3.addActionListener(this);

            jBtn4.addActionListener(this);
            jBtn5.addActionListener(this);
            jCom1.addActionListener(this);
            jCom2.addActionListener(this);
            jCom3.addActionListener(this);
            jCom4.addActionListener(this);

            jCheck1.addItemListener(this);
            jCheck2.addItemListener(this);

 }

 public void actionPerformed(ActionEvent e)
  {       String sql;
       if(e.getSource()==jCom1)
       {

          sql="select * from Fmenu where Mname='"+jCom1.getSelectedItem()+"'";

          rs=db.getResult(sql);
          boolean isexist=false;
           try{
              isexist=rs.first();
              }
           catch (SQLException ek)
           {
              }
       try {   if(isexist)
           { jText1.setText(rs.getString("Mprice"));
             jText2.setText(rs.getString("Msprice"));
           }
           else
           {
            JOptionPane.showMessageDialog(null,"没有所对应的商品");
           }
       }
       catch (SQLException ek)
           {
              }
        }

        if(e.getSource()==jCom2)
       {

          sql="select * from Fmenu where Mname='"+jCom2.getSelectedItem()+"'";
          rs=db.getResult(sql);
          boolean isexist=false;
           try{
              isexist=rs.first();
              }
           catch (SQLException ek)
           {
              }
       try {   if(isexist)
           {
             jText5.setText(rs.getString("Mprice"));
             jText6.setText(rs.getString("Msprice"));
           }
           else
           {
            JOptionPane.showMessageDialog(null,"没有对应的商品");
           }
       }
       catch (SQLException ek)
           {
              }
        }

        if(e.getSource()==jCom3)
      {

         sql="select * from Fmenu where Mname='"+jCom3.getSelectedItem()+"'";
         rs=db.getResult(sql);
         boolean isexist=false;
          try{
             isexist=rs.first();
             }
          catch (SQLException ek)
          {
             }
      try {   if(isexist)
          {
            jText8.setText(rs.getString("Mprice"));
            jText9.setText(rs.getString("Msprice"));
          }
          else
          {
           JOptionPane.showMessageDialog(null,"没有对应的商品");
          }
      }
      catch (SQLException ek)
          {
             }
       }

       if(e.getSource()==jCom4)
  {

     sql="select * from Fmenu where Mname='"+jCom4.getSelectedItem()+"'";
     rs=db.getResult(sql);
     boolean isexist=false;
      try{
         isexist=rs.first();
         }
      catch (SQLException ek)
      {
         }
  try {   if(isexist)
      {
        jText11.setText(rs.getString("Mprice"));
        jText12.setText(rs.getString("Msprice"));
      }
      else
      {
       JOptionPane.showMessageDialog(null,"没有对应的商品");
      }
  }
  catch (SQLException ek)
      {
         }
   }
   if(e.getSource()==jBtn1 )
    {

      int a=Integer.parseInt(jText1.getText());
      int b=Integer.parseInt(jText2.getText());
      int c=Integer.parseInt(jText3.getText());

      if(jCheck1.isSelected())
      {int d1;
         if(jText4.getText().equals(""))
             d1 = 0;
          else d1=Integer.parseInt(jText4.getText());
         jText31.setText(String.valueOf(b*c)) ;
         jText4.setText(String.valueOf(b*c + d1)) ;
      }
    else
        if(jCheck2.isSelected())
      {
          double d1;
          if(jText4.getText().equals(""))
              d1 = 0;
           else d1=Double.parseDouble(jText4.getText());


          jText31.setText(String.valueOf((a*c*0.9)));
          jText4.setText(String.valueOf(a*c*0.9+d1));
      }
     else
       if(!(jCheck1.isSelected()&&jCheck2.isSelected()))
      {
          int d1;
         if(jText4.getText().equals(""))
             d1 = 0;
          else d1=Integer.parseInt(jText4.getText());


          jText31.setText(String.valueOf(a*c)) ;
          jText4.setText(String.valueOf(a*c+d1)) ;
      }
       Calendar calendar=Calendar.getInstance();
       calendar.setTime(new java.util.Date());
       String year=String.valueOf(calendar.get(Calendar.YEAR ));
       String   month=String.valueOf(calendar.get(Calendar.MONTH )+1);
       String   day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

    sql="insert into Sell(Fname,Fprice,Fnumber,Fsyear,Fsmonth,Fsday,Fsprice,Ffee) values('";
    sql+=jCom1.getSelectedItem()+"','";
    sql+=jText1.getText().trim()+"','";
    sql+=jText3.getText().trim()+"',";
    sql+="'"+year+"','"+month+"','"+day+"','";
    sql+=jText2.getText().trim()+"',";
    sql+=Double.parseDouble(jText31.getText())+")";
         if(db.executeSql(sql))
       {JOptionPane.showMessageDialog(null,"操作成功"); }
      else
      {JOptionPane.showMessageDialog(null,"操作失败");}
      }
      if(e.getSource()==jBtn3)
      {
          int d=Integer.parseInt(jText5.getText());
             int n=Integer.parseInt(jText6.getText());
             int f=Integer.parseInt(jText7.getText());



          if(jText31.getText().equals("") )
          {


              if(jCheck1.isSelected())
              {
                  int d2;
              if(jText4.getText().equals(""))
                  d2 = 0;
               else d2=Integer.parseInt(jText4.getText());

            jText71.setText(String.valueOf(n*f));
            jText4.setText(String.valueOf(n*f+d2)) ;
          }

         else  if(jCheck2.isSelected())
         {
             double d2;
         if(jText4.getText().equals(""))
             d2 = 0;
          else d2=Double.parseDouble(jText4.getText());



               jText71.setText(String.valueOf(d*f*0.9)) ;
               jText4.setText(String.valueOf(d*f*0.9+d2)) ;

          }
           else   if(!(jCheck1.isSelected()&&jCheck2.isSelected()))
              {
                  int d2;
           if(jText4.getText().equals(""))
               d2 = 0;
            else d2=Integer.parseInt(jText4.getText());
                   jText71.setText(String.valueOf(d*f)) ;
                   jText4.setText(String.valueOf(d*f+d2));
              }

          }
           if(!jText31.getText().equals(""))//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
           {


               if(jCheck1.isSelected())
               {
                   int d2;
          if(jText4.getText().equals(""))
              d2 = 0;
           else d2=Integer.parseInt(jText4.getText());

                   jText71.setText(String.valueOf(n*f));
                  jText4.setText(String.valueOf(n*f+d2)) ;
               }
              else  if(jCheck2.isSelected())
                {
                    double d2;
              if(jText4.getText().equals(""))
                  d2 = 0;
               else d2=Double.parseDouble(jText4.getText());

                    jText71.setText(String.valueOf(d*f*0.9)) ;
                jText4.setText(String.valueOf(d*f*0.9+d2)) ;
                }
              else
              if(!(jCheck1.isSelected()&&jCheck2.isSelected()))
                 {
                     int d2;
             if(jText4.getText().equals(""))
                 d2 = 0;
              else d2=Integer.parseInt(jText4.getText());

                     jText71.setText(String.valueOf(d*f)) ;
                  jText4.setText(String.valueOf(d*f+d2)) ;
                 }

           }



          Calendar calendar=Calendar.getInstance();
       calendar.setTime(new java.util.Date());
       String year=String.valueOf(calendar.get(Calendar.YEAR ));
       String   month=String.valueOf(calendar.get(Calendar.MONTH )+1);
       String   day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

    sql="insert into Sell(Fname,Fprice,Fnumber,Fsyear,Fsmonth,Fsday,Fsprice,Ffee) values('";
    sql+=jCom2.getSelectedItem()+"','";
    sql+=jText5.getText().trim()+"','";
    sql+=jText7.getText().trim()+"',";
    sql+="'"+year+"','"+month+"','"+day+"','";
    sql+=jText6.getText().trim()+"',";
    sql+=Double.parseDouble(jText71.getText())+")";

          if(db.executeSql(sql))
         {JOptionPane.showMessageDialog(null,"操作成功"); }
        else
        {JOptionPane.showMessageDialog(null,"操作失败");}


          }



      if(e.getSource()==jBtn4 )
      {


   if(!(jText31.getText().equals(""))&&(!(jText71.getText().equals("")) ))

   {      int g=Integer.parseInt(jText8.getText());
           int h=Integer.parseInt(jText9.getText());
           int i=Integer.parseInt(jText10.getText());

          if (jCheck1.isSelected()) {
              int d2;
             if(jText4.getText().equals(""))
                 d2 = 0;
              else d2=Integer.parseInt(jText4.getText());


              jText101.setText(String.valueOf(i*h));

              jText4.setText(String.valueOf(i*h+d2));

          }
         else
         if (jCheck2.isSelected()) {
             double d2;
             if(jText4.getText().equals(""))
                 d2 = 0;
              else d2=Double.parseDouble(jText4.getText());


             jText101.setText(String.valueOf(g*i*0.9));
              jText4.setText(String.valueOf(g*i*0.9+d2));
          }

       else
      if (!(jCheck1.isSelected() && jCheck2.isSelected())) {
          int d2;
             if(jText4.getText().equals(""))
                 d2 = 0;
              else d2=Integer.parseInt(jText4.getText());

          jText101.setText(String.valueOf(g*i));
              jText4.setText(String.valueOf((g*i+d2)));
          }
      }


  else
  if(!jText71.getText().equals("")&&jText31.getText().equals(""))
     {
                 int     g=Integer.parseInt(jText8.getText());
                 int h=Integer.parseInt(jText9.getText());
                 int i=Integer.parseInt(jText10.getText());

         if (jCheck1.isSelected()) {
             int d2;
          if(jText4.getText().equals(""))
              d2 = 0;
           else d2=Integer.parseInt(jText4.getText());


                 jText101.setText(String.valueOf(i*h));

                  jText4.setText(String.valueOf(i*h+d2));

              }
             else
             if (jCheck2.isSelected()) {

                 double d2;
              if(jText4.getText().equals(""))
                  d2 = 0;
               else d2=Double.parseDouble(jText4.getText());
                jText101.setText(String.valueOf(g*i*0.9));
                  jText4.setText(String.valueOf((g*i*0.9 +d2)));
              }

           else
           if (!(jCheck1.isSelected() && jCheck2.isSelected())) {
               int d2;
            if(jText4.getText().equals(""))
                d2 = 0;
             else d2=Integer.parseInt(jText4.getText());


               jText101.setText(String.valueOf(g*i));
                  jText4.setText(String.valueOf((g*i +d2)));
              }
      }

   else  if(!jText31.getText().equals("")&&jText71.getText().equals(""))//!!!!!!!!!!!!
     {
         int g=Integer.parseInt(jText8.getText());
             int h=Integer.parseInt(jText9.getText());
             int i=Integer.parseInt(jText10.getText());

         if (jCheck1.isSelected()) {

             int d2;
         if(jText4.getText().equals(""))
             d2 = 0;
          else d2=Integer.parseInt(jText4.getText());
          jText101.setText(String.valueOf(i*h));

                jText4.setText(String.valueOf(i*h+d2));


            }
           else
           if (jCheck2.isSelected()) {
               double d2;
              if(jText4.getText().equals(""))
                  d2 = 0;
               else d2=Double.parseDouble(jText4.getText());

               jText101.setText(String.valueOf(g*i*0.9));
                jText4.setText(String.valueOf(g*i*0.9 + d2));

            }

         else
         if (!(jCheck1.isSelected() && jCheck2.isSelected())) {
             int d2;
           if(jText4.getText().equals(""))
               d2 = 0;
            else d2=Integer.parseInt(jText4.getText());

             jText101.setText(String.valueOf(g*i));
                jText4.setText(String.valueOf(g*i+d2));

            }


     }

     else  if(jText31.getText().equals("")&&jText71.getText().equals(""))
     {
         int g=Integer.parseInt(jText8.getText());
             int h=Integer.parseInt(jText9.getText());
             int i=Integer.parseInt(jText10.getText());

         if (jCheck1.isSelected()) {
             int d2;
          if(jText4.getText().equals(""))
              d2 = 0;
           else d2=Integer.parseInt(jText4.getText());
                jText101.setText(String.valueOf(i*h));
                jText4.setText(String.valueOf(i*h+d2));


            }
           else
           if (jCheck2.isSelected()) {

               double d2;
                if(jText4.getText().equals(""))
                    d2 = 0;
                 else d2=Double.parseDouble(jText4.getText());
                jText101.setText(String.valueOf(g*i*0.9));
                jText4.setText(String.valueOf((g*i*0.9+d2)));

            }

         else
         if (!(jCheck1.isSelected() && jCheck2.isSelected())) {
             int d2;
          if(jText4.getText().equals(""))
              d2 = 0;
           else d2=Integer.parseInt(jText4.getText());

             jText101.setText(String.valueOf(g*i));
                jText4.setText(String.valueOf((g*i+d2)));

            }


     }

      Calendar calendar=Calendar.getInstance();
              calendar.setTime(new java.util.Date());
              String year=String.valueOf(calendar.get(Calendar.YEAR ));
              String   month=String.valueOf(calendar.get(Calendar.MONTH )+1);
                String   day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));


   sql="insert into Sell(Fname,Fprice,Fnumber,Fsyear,Fsmonth,Fsday,Fsprice,Ffee) values('";
   sql+=jCom3.getSelectedItem()+"','";
   sql+=jText8.getText().trim()+"','";
   sql+=jText10.getText().trim()+"',";
   sql+="'"+year+"','"+month+"','"+day+"','";
   sql+=jText9.getText().trim()+"',";
   sql+=Double.parseDouble(jText101.getText())+")";
   if(db.executeSql(sql))
         {JOptionPane.showMessageDialog(null,"操作成功"); }
        else
        {JOptionPane.showMessageDialog(null,"操作失败");}


      }


      if(e.getSource()==jBtn5)
      {    int j=Integer.parseInt(jText11.getText());
                int k=Integer.parseInt(jText12.getText());
                int l=Integer.parseInt(jText13.getText());


          if(!(jText31.getText().equals("")&&jText71.getText().equals("")&&jText101.getText().equals("")))
          {

              if(jCheck1.isSelected())
              {
                  int d2;
         if(jText4.getText().equals(""))
             d2 = 0;
          else d2=Integer.parseInt(jText4.getText());

                  jText131.setText(String.valueOf(k * l));
                  jText4.setText(String.valueOf(k*l+d2));
              }

          else
          if (jCheck2.isSelected()) {
              double d2;
               if(jText4.getText().equals(""))
                   d2 = 0;
                else d2=Double.parseDouble(jText4.getText());

              jText131.setText(String.valueOf((j * l * 0.9)));
                  jText4.setText(String.valueOf(j * l * 0.9 +d2));
              }

           else
           if (!(jCheck1.isSelected() && jCheck2.isSelected())) {
               int d2;
          if(jText4.getText().equals(""))
              d2 = 0;
           else d2=Integer.parseInt(jText4.getText());

               jText131.setText(String.valueOf(j * l));

                  jText4.setText(String.valueOf(j * l +d2));
              }
          }

     else if(!(jText31.getText().equals("")&&jText71.getText().equals(""))&&jText101.getText().equals(""))

  {


            if(jCheck1.isSelected())
             {
                 int d2;
         if(jText4.getText().equals(""))
             d2 = 0;
          else d2=Integer.parseInt(jText4.getText());

                 jText131.setText(String.valueOf(k*l));
                 jText4.setText(String.valueOf(k*l+d2));

             }

            else
            if (jCheck2.isSelected()) {
                double d2;
               if(jText4.getText().equals(""))
                   d2 = 0;
                else d2=Double.parseDouble(jText4.getText());

                jText131.setText(String.valueOf((j*l*0.9)));
                 jText4.setText(String.valueOf(j*l*0.9+d2));

             }

            else
            if (!(jCheck1.isSelected() && jCheck2.isSelected())) {
                int d2;
         if(jText4.getText().equals(""))
             d2 = 0;
          else d2=Integer.parseInt(jText4.getText());

                jText131.setText(String.valueOf(j*l));
                 jText4.setText(String.valueOf(j*l+d2));



             }


        }
     else if(!jText31.getText().equals("")&&(jText71.getText().equals("")&&jText101.getText().equals("")))
     {

            if(jCheck1.isSelected())
            {int d2;
      if(jText4.getText().equals(""))
         d2 = 0;
       else d2=Integer.parseInt(jText4.getText());

                    jText131.setText(String.valueOf(k*l));
                    jText4.setText(String.valueOf(k*l+d2));
               }

               else
               if (jCheck2.isSelected()) {
                   double d2;
               if(jText4.getText().equals(""))
                   d2 = 0;
                else d2=Double.parseDouble(jText4.getText());

                   jText131.setText(String.valueOf((j*l*0.9)));
                    jText4.setText(String.valueOf(j*l*0.9+d2));
             }

               else
               if (!(jCheck1.isSelected() && jCheck2.isSelected())) {
                   int d2;
          if(jText4.getText().equals(""))
              d2 = 0;
           else d2=Integer.parseInt(jText4.getText());
              jText131.setText(String.valueOf(j*l));

                    jText4.setText(String.valueOf(j*l+d2));
             }
   }
  else if(!jText71.getText().equals("")&&(jText31.getText().equals("")&&jText101.getText().equals("")))
  {
    if(jCheck1.isSelected())
    {int d2;
 if(jText4.getText().equals(""))
     d2 = 0;
  else d2=Integer.parseInt(jText4.getText());

                jText131.setText(String.valueOf(k*l));
                jText4.setText(String.valueOf(k*l+d2));

            }

        else
        if (jCheck2.isSelected()) {
            double d2;
            if(jText4.getText().equals(""))
                d2 = 0;
             else d2=Double.parseDouble(jText4.getText());

            jText131.setText(String.valueOf((j*l*0.9)));
                jText4.setText(String.valueOf((j*l*0.9)+d2));

            }

         else
         if (!(jCheck1.isSelected() && jCheck2.isSelected())) {
             int d2;
        if(jText4.getText().equals(""))
            d2 = 0;
         else d2=Integer.parseInt(jText4.getText());

             jText131.setText(String.valueOf(j*l));

                jText4.setText(String.valueOf(j*l+d2));

            }

            }
     else if(!(jText71.getText().equals("")&&jText101.getText().equals(""))&&jText31.getText().equals(""))
  {


      if(jCheck1.isSelected())
      {int d2;
if(jText4.getText().equals(""))
    d2 = 0;
 else d2=Integer.parseInt(jText4.getText());

                   jText131.setText(String.valueOf(k*l));
                   jText4.setText(String.valueOf(k*l+d2));
            }

           else
           if (jCheck2.isSelected()) {
               double d2;
            if(jText4.getText().equals(""))
                d2 = 0;
             else d2=Double.parseDouble(jText4.getText());

               jText131.setText(String.valueOf((j*l*0.9)));
                   jText4.setText(String.valueOf((j*l*0.9)+d2));
             }

            else
            if (!(jCheck1.isSelected() && jCheck2.isSelected())) {
                int d2;
        if(jText4.getText().equals(""))
            d2 = 0;
         else d2=Integer.parseInt(jText4.getText());
  jText131.setText(String.valueOf(j*l));

                   jText4.setText(String.valueOf(j*l+d2));
              }

      }
  else if(!(jText31.getText().equals("")&&jText101.getText().equals(""))&&jText71.getText().equals(""))
  {

      if(jCheck1.isSelected())
      {int d2;
if(jText4.getText().equals(""))
d2 = 0;
else d2=Integer.parseInt(jText4.getText());

                       jText131.setText(String.valueOf(k*l));
                       jText4.setText(String.valueOf(k*l+d2));
                }

               else
               if (jCheck2.isSelected()) {
                   double d2;
             if(jText4.getText().equals(""))
                 d2 = 0;
              else d2=Double.parseDouble(jText4.getText());

                   jText131.setText(String.valueOf((j*l*0.9)));
                       jText4.setText(String.valueOf((j*l*0.9) +d2));
                 }

                else
                if (!(jCheck1.isSelected() && jCheck2.isSelected())) {
                    int d2;
         if(jText4.getText().equals(""))
             d2 = 0;
          else d2=Integer.parseInt(jText4.getText());

                    jText131.setText(String.valueOf(j*l));

                       jText4.setText(String.valueOf(j*l+d2));

                   }

        }
  else if(jText31.getText().equals("")&&jText101.getText().equals("")&&jText71.getText().equals(""))
  {
      if(jCheck1.isSelected())
      {int d2;
if(jText4.getText().equals(""))
d2 = 0;
else d2=Integer.parseInt(jText4.getText());

                       jText131.setText(String.valueOf(k*l));
                       jText4.setText(String.valueOf(k*l+d2));



                   }

               else
               if (jCheck2.isSelected()) {
                   double d2;
           if(jText4.getText().equals(""))
               d2 = 0;
            else d2=Double.parseDouble(jText4.getText());

                   jText131.setText(String.valueOf((j*l*0.9)));
                       jText4.setText(String.valueOf((j*l*0.9+d2)));
                   }

                else
                if (!(jCheck1.isSelected() && jCheck2.isSelected())) {
                    int d2;
         if(jText4.getText().equals(""))
             d2 = 0;
          else d2=Integer.parseInt(jText4.getText());

                    jText131.setText(String.valueOf(j*l));

                       jText4.setText(String.valueOf(j*l+d2));
                   }
}

         else if(!jText101.getText().equals("")&&(jText31.getText().equals("")&&jText71.getText().equals("")))
         {


          if(jCheck1.isSelected())
          {int d2;
if(jText4.getText().equals(""))
d2 = 0;
else d2=Integer.parseInt(jText4.getText());

                           jText131.setText(String.valueOf(k*l));
                           jText4.setText(String.valueOf(k*l+d2));
                       }

                   else
                   if (jCheck2.isSelected()) {
                       double d2;
              if(jText4.getText().equals(""))
                  d2 = 0;
               else d2=Double.parseDouble(jText4.getText());

                       jText131.setText(String.valueOf((j*l*0.9)));
                           jText4.setText(String.valueOf(j*l*0.9+d2));
                       }

                    else
                    if (!(jCheck1.isSelected() && jCheck2.isSelected())) {
                        int d2;
      if(jText4.getText().equals(""))
          d2 = 0;
       else d2=Integer.parseInt(jText4.getText());

                        jText131.setText(String.valueOf(j*l));

                           jText4.setText(String.valueOf(j*l+d2));
                       }
          }

      Calendar calendar=Calendar.getInstance();
             calendar.setTime(new java.util.Date());
             String year=String.valueOf(calendar.get(Calendar.YEAR ));
             String   month=String.valueOf(calendar.get(Calendar.MONTH )+1);
             String   day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

  sql="insert into Sell(Fname,Fprice,Fnumber,Fsyear,Fsmonth,Fsday,Fsprice,Ffee) values('";
  sql+=jCom4.getSelectedItem()+"','";
  sql+=jText11.getText().trim()+"','";
  sql+=jText13.getText().trim()+"',";
  sql+="'"+year+"','"+month+"','"+day+"','";
  sql+=jText12.getText().trim()+"',";
  sql+=Double.parseDouble(jText131.getText())+")";
  if(db.executeSql(sql))
        {JOptionPane.showMessageDialog(null,"操作成功"); }
       else
       {JOptionPane.showMessageDialog(null,"操作失败");}


     }




    if(e.getSource()==jBtn2 )
  {
      jText1.setText("");
      jText2.setText("");
      jText3.setText("");
      jText31.setText("0");
      jText4.setText("");
      jText5.setText("");
      jText6.setText("");
      jText7.setText("");
       jText71.setText("0");
      jText8.setText("");
      jText9.setText("");
      jText10.setText("");
      jText101.setText("0");
      jText11.setText("");
      jText12.setText("");
      jText13.setText("");
      jText131.setText("0");
   }
  }
 public void itemStateChanged(ItemEvent ex)
 {
     if(jCheck1.isSelected()&&jCheck2.isSelected() )
    {JOptionPane.showMessageDialog(null,"VIP功能不能享受特价商品") ;}
  }
   public static void main(String[] args) {
        SellWindow sellwidow = new SellWindow();
    }
}
