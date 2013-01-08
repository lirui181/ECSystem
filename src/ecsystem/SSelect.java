package ecsystem;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

/**
 * @author 李新忠、徐琴芳、范茂林、刘书齐
 * @version 1.0
 */
public class SSelect extends JFrame implements ActionListener  {
    DBManager db=new DBManager();
    ResultSet rs;
    Container con=getContentPane();
    JPanel pan1=new JPanel();
    JPanel pan2=new JPanel();
    JPanel pan3=new JPanel();
    JPanel pan4=new JPanel();
    JPanel pan5=new JPanel();
    JPanel pan100=new JPanel();
    JLabel jLab1=new JLabel("请填写相应的查询信息");
    JLabel jLab2=new JLabel("商品名称");
   JLabel jLab3=new JLabel("商品类别");
    JLabel jLab4=new JLabel("采购时间");
   JLabel jLab5=new JLabel("年");
   JLabel jLab6=new JLabel("月");
   JLabel jLab7=new JLabel("日");
   JLabel jLab8=new JLabel("至");
   JLabel jLab9=new JLabel("年");
   JLabel jLab10=new JLabel("月");
   JLabel jLab11=new JLabel("日");
   JButton jBtn1=new JButton("确定");
   JButton jBtn2=new JButton("清空");
   JButton jBtn3=new JButton("退出");
   JTextField jText1=new JTextField();
  JComboBox jCom=new JComboBox();
  JTextField jText3=new JTextField();
  JTextField jText4=new JTextField();
  JTextField jText5=new JTextField();
  JTextField jText6=new JTextField();
  JTextField jText7=new JTextField();
  JTextField jText8=new JTextField();
   GridBagLayout gbc=new GridBagLayout();
  GridBagConstraints c=new GridBagConstraints();
    FlowLayout flow=new FlowLayout();

    public SSelect() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        setVisible(true);
      setSize(400,300);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setTitle("销售信息查询");
      jText1.setPreferredSize(new Dimension(75,20));
        jCom.setPreferredSize(new Dimension(75,20));
  jText3.setPreferredSize(new Dimension(50,20));
  jText4.setPreferredSize(new Dimension(25,20));
  jText5.setPreferredSize(new Dimension(25,20));
  jText6.setPreferredSize(new Dimension(50,20));
   jText7.setPreferredSize(new Dimension(25,20));
   jText8.setPreferredSize(new Dimension(25,20));
        pan1.setBackground(new Color(175, 210, 250));
        pan1.setPreferredSize(new Dimension(350,40));
        pan2.setBackground(new Color(175, 210, 250));
        pan2.setPreferredSize(new Dimension(350,40));
        pan3.setBackground(new Color(175, 210, 250));
        pan3.setPreferredSize(new Dimension(350,60));//````````````
        pan4.setBackground(new Color(175, 210, 250));
        pan4.setPreferredSize(new Dimension(350,130));
        pan5.setBackground(new Color(175, 210, 250));
        pan5.setPreferredSize(new Dimension(350,165));
        pan100.setBackground(new Color(175, 210, 250));
        pan100.setPreferredSize(new Dimension(400,250));
      pan1.setLayout(flow);
   flow.setAlignment(FlowLayout.LEFT);
   flow.setVgap(20);
   flow.setHgap(15);
        jBtn1.setBackground(new Color(175, 210, 250));
        jBtn2.setBackground(new Color(175, 210, 250));
        jBtn3.setBackground(new Color(175, 210, 250));
        pan1.add(jLab1);
   pan2.setLayout(gbc);
   c.gridwidth=1;
   c.gridheight=1;
   c.gridx=0;
   c.gridy=1;
   c.insets=new Insets(15,1,1,1);
   pan2.add(jLab2,c);
   c.gridx=1;
   c.gridy=1;
   c.insets=new Insets(15,1,1,15);
   pan2.add(jText1,c);
   c.gridx=2;
   c.gridy=1;
   c.insets=new Insets(15,15,1,1);
   pan2.add(jLab3,c);
   c.gridx=3;
    c.gridy=1;
    c.insets=new Insets(15,1,1,5);
     jCom.addItem("");
    jCom.addItem("数码产品");
    jCom.addItem("虚拟用品");
    jCom.addItem("护肤产品");
    jCom.addItem("休闲服饰");
    pan2.add(jCom,c);//pan2加载完毕~~~~~~~~
    pan4.setLayout(gbc);
    c.gridwidth=1;
   c.gridheight=1;
    c.gridx=1;
     c.gridy=0;
     c.insets=new Insets(5,5,5,1);
     pan4.add(jLab4,c);
     c.gridx=2;
     c.gridy=0;
     c.insets=new Insets(5,1,5,1);
     pan4.add(jText3,c);
     c.gridx=3;
     c.gridy=0;
     c.insets=new Insets(5,1,5,1);
     pan4.add(jLab5,c);
     c.gridx=4;
     c.gridy=0;
     c.insets=new Insets(5,1,5,1);
     pan4.add(jText4,c);
     c.gridx=5;
     c.gridy=0;
     c.insets=new Insets(5,1,5,1);
     pan4.add(jLab6,c);
     c.gridx=6;
     c.gridy=0;
     c.insets=new Insets(5,1,5,1);
     pan4.add(jText5,c);
     c.gridx=7;
     c.gridy=0;
     c.insets=new Insets(5,1,5,1);
     pan4.add(jLab7,c);

     c.gridx=4;
     c.gridy=1;
      c.insets=new Insets(1,1,1,1);
      pan4.add(jLab8,c);//```````
      c.gridx=2;
     c.gridy=2;
      c.insets=new Insets(1,5,1,1);
      pan4.add(jText6,c);
      c.gridx=3;
      c.gridy=2;
       c.insets=new Insets(1,1,5,1);
       pan4.add(jLab9,c);
       c.gridx=4;
       c.gridy=2;
       c.insets=new Insets(1,1,5,1);
       pan4.add(jText7,c);
       c.gridx=5;
       c.gridy=2;
       c.insets=new Insets(1,1,5,1);
       pan4.add(jLab10,c);
       c.gridx=6;
       c.gridy=2;
       c.insets=new Insets(1,1,5,1);
        pan4.add(jText8,c);
        c.gridx=7;
       c.gridy=2;
        c.insets=new Insets(1,1,5,1);
        pan4.add(jLab11,c);
        pan5.add(pan2);
        pan5.add(pan4);
        pan3.setLayout(gbc);//pan3
          c.gridwidth=1;
          c.gridheight=1;
      c.gridx=0;
      c.gridy=0;
      c.insets=new Insets(5,5,15,10);
      pan3.add(jBtn1,c);
       c.gridx=1;
       c.gridy=0;
       c.insets=new Insets(5,10,15,10);
        pan3.add(jBtn2,c);
        c.gridx=2;
            c.gridy=0;
            c.insets=new Insets(5,10,15,1);
       pan3.add(jBtn3,c);

    pan100.add(pan1,BorderLayout.NORTH);
     pan100.add(pan5,BorderLayout.NORTH);
      pan100.add(pan3,BorderLayout.SOUTH);
      con.add(pan100);
      validate();
      jBtn1.addActionListener(this);
      jBtn2.addActionListener(this);
      jBtn3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
         String sql;
      if(e.getSource()==jBtn1)
      {if(jText1.getText().equals("")&&jCom.getSelectedItem().equals("")&&jText3.getText().equals("")&&
               jText4.getText().equals("")&&jText5.getText().equals("")&&jText6.getText().equals("")&&
               jText7.getText().equals(""))
          {
            JOptionPane.showMessageDialog(null,"查询条件不能全为空");
            return;
        }
        sql="select * from Sell where  ";
         boolean isfirst=true;
          if(!jText1.getText().trim().equals(""))
          {
              sql+="Fname='"+jText1.getText().trim()+"'";
               isfirst=false;
          }
          if(!jCom.getSelectedItem().equals(""))
        {
            if(!isfirst)
          {
              sql+="and Ftype='"+jCom.getSelectedItem()+"'";
          }
           else
            {
                sql+="Ftype='"+jCom.getSelectedItem()+"'";
            }
               isfirst=false;
            }

           if(!jText3.getText().trim().equals("") )
           {
              if(!isfirst)
              {
               sql+="and Fsyear>="+Integer.parseInt(jText3.getText().trim());
              }
              else
              {
                sql+="Fsyear>="+Integer.parseInt(jText3.getText().trim());
              }
              isfirst=false;
           }

           if(!jText4.getText().trim().equals("") )
         {
            if(!isfirst)
            {
             sql+="and Fsmonth>="+Integer.parseInt(jText4.getText().trim());
            }
            else
            {
              sql+="Fsmonth>="+Integer.parseInt(jText4.getText().trim());
            }
            isfirst=false;
         }

         if(!jText5.getText().trim().equals("") )
         {
            if(!isfirst)
            {
             sql+="and Fsday>="+Integer.parseInt(jText5.getText().trim());
            }
            else
            {
              sql+="Fsday>="+Integer.parseInt(jText5.getText().trim());
            }
            isfirst=false;
         }
         if(!jText6.getText().trim().equals("") )
          {
             if(!isfirst)
             {
              sql+="and Fsyear<="+Integer.parseInt(jText6.getText().trim());
             }
             else
             {
               sql+="Fsyear<="+Integer.parseInt(jText6.getText().trim());
             }
             isfirst=false;
          }

          if(!jText7.getText().trim().equals("") )
          {
             if(!isfirst)
             {
              sql+="and Fsmonth<="+Integer.parseInt(jText7.getText().trim());
             }
             else
             {
               sql+="Fsmonth<="+Integer.parseInt(jText7.getText().trim());
             }
             isfirst=false;
          }
          if(!jText8.getText().trim().equals("") )
        {
           if(!isfirst)
           {
            sql+="and Fsday<="+Integer.parseInt(jText8.getText().trim());
           }
           else
           {
             sql+="Fsdayr<="+Integer.parseInt(jText8.getText().trim());
           }

        }

        rs=db.getResult(sql);
       boolean isexist=false;
       try{
           isexist=rs.first();
       }
       catch(SQLException e3)
       {

       }
       if(!isexist)
       {
           JOptionPane.showMessageDialog(null,"查找信息与数据库中信息不符，请确认后再输入");
       }
       else
       {
        SellShow sellshow=new SellShow();
        Dimension frmSize = getSize();
              Dimension dlgSize = sellshow.getSize();
              Point loc = getLocation();
              sellshow.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                              (frmSize.height - dlgSize.height) / 2 + loc.y);

         sellshow.showResultss(rs);
       }

    }
    if(e.getSource()==jBtn2 )
    {
      jText1.setText("");

        jText3.setText("");
     jText4.setText("");
      jText5.setText("");
     jText6.setText("");
      jText7.setText("");
       jText8.setText("");
    }

  if(e.getSource()== jBtn3)
  {this.dispose(); }

  }

   public static void main(String[] args) {
        SSelect sellselect = new SSelect();
    }
}
