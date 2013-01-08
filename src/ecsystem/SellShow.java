package ecsystem;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
/**
 * @author �����ҡ����ٷ�����ï�֡�������
 * @version 1.0
 */
public class SellShow extends JFrame implements ActionListener  {

     DBManager db=new DBManager();
     ResultSet rs;
    JLabel jLab1=new JLabel("���������ı�����������Ҫ��ѯ�Ĳ�ƷID��");
     JLabel jLab2=new JLabel("��ƷID");
     JButton jBtn1=new JButton("��ѯɾ��");
     JButton jBtn2=new JButton("��ѯ�޸�");
     JTextField jText=new JTextField();


    JPanel pan1=new JPanel();
    JPanel pan2=new JPanel();
    JPanel pan100=new JPanel();
    JScrollPane jScroll=new JScrollPane();
    GridBagLayout gbc=new GridBagLayout();
    GridBagConstraints c=new GridBagConstraints();
    FlowLayout flow=new FlowLayout();
    Container con=getContentPane();
    Vector arr=new Vector(1,1);
    DefaultTableModel model =new DefaultTableModel();
    JTable jTable=new JTable(model);


    public SellShow() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        setVisible(true);
    setSize(450,300);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setTitle("���۲�Ʒ��Ϣһ��");
        pan1.setBackground(new Color(145, 210, 250));
        pan1.setPreferredSize(new Dimension(450,40));
        pan100.setBackground(new Color(175, 210, 250));
        pan100.setPreferredSize(new Dimension(450,300));
    pan1.setLayout(gbc);
    c.gridwidth=1;
   c.gridheight=1;
   c.gridx=0;
   c.gridy=0;
   c.insets=new Insets(10,20,5,200);
        jScroll.setPreferredSize(new Dimension(430,165));
      model.addColumn("ID��");
       model.addColumn("����");
       model.addColumn("���");
       model.addColumn("�۸�");
       model.addColumn("����");
       model.addColumn("�ؼ�");
       model.addColumn("��");
       model.addColumn("��");
       model.addColumn("��");
       model.addColumn("�ܶ�");
        pan2.setBackground(new Color(175, 210, 250));
        pan2.setPreferredSize(new Dimension(450,40));
       jText.setPreferredSize(new Dimension(100,20));
       pan2.setLayout(flow);
       flow.setVgap(10);
       pan2.add(jLab2);
       pan2.add(jText);
       pan2.add(jBtn1);
       pan2.add(jBtn2);

    pan100.add(pan1,BorderLayout.NORTH);
        pan100.add(jLab1);
        pan100.add(jScroll,BorderLayout.CENTER);
        jScroll.getViewport().add(jTable);
        pan100.add(pan2,BorderLayout.SOUTH);
    con.add(pan100);
        validate();
    jBtn1.addActionListener(this);
      jBtn2.addActionListener(this);
   }
     public void actionPerformed(ActionEvent e)
     {
         if (e.getSource()==jBtn1)
              {
                  String sql;
                  if (jText.getText().trim().equals(""))
                     {
                      JOptionPane.showMessageDialog(null, "ID�Ų���Ϊ��");
                     }
                  if (!jText.getText().trim().equals(""))
                  {
                      sql = "select * from Sell where FID=" +Integer.parseInt(jText.getText().trim());
                      rs = db.getResult(sql);
                      boolean isexist = false;
                      try
                      {
                          isexist = rs.first();
                      }
                      catch (SQLException e3) {

                      }


                  if (!isexist)
                  {
                      JOptionPane.showMessageDialog(null, "������Ϣ�����ݿ�����Ϣ��������ȷ�Ϻ�������");
                  }
                  else
                  {
                      SellDelete100 selldelete= new SellDelete100();
                      Dimension frmSize = getSize();
                Dimension dlgSize = selldelete.getSize();
                Point loc = getLocation();
                selldelete.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                                (frmSize.height - dlgSize.height) / 2 + loc.y);



                      selldelete.showResults(rs);
                  }

              }
          }

              if (e.getSource()==jBtn2)
              {
                  String sql;
                  if (jText.getText().trim().equals(""))
                     {
                      JOptionPane.showMessageDialog(null, "ID�Ų���Ϊ��");
                     }
                  if (!jText.getText().trim().equals(""))
                  {
                      sql = "select * from Sell where FID=" +Integer.parseInt(jText.getText().trim());
                      rs = db.getResult(sql);
                      boolean isexist = false;
                      try
                      {
                          isexist = rs.first();
                      }
                      catch (SQLException e3) {

                      }


                  if (!isexist)
                  {
                      JOptionPane.showMessageDialog(null, "������Ϣ�����ݿ�����Ϣ��������ȷ�Ϻ�������");
                  }
                  else
                  {
                      SellUpdate100 sellupdate100 = new SellUpdate100();
                      Dimension frmSize = getSize();
                      Dimension dlgSize = sellupdate100 .getSize();
                      Point loc = getLocation();
                      sellupdate100 .setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                                   (frmSize.height - dlgSize.height) / 2 + loc.y);


                      sellupdate100.showR(rs);
                  }

              }
          }


     }
    public void  showResultss(ResultSet rs)
    {
        try{
                  rs.beforeFirst();
                  while(rs.next())
                  {
                      Vector temp=new Vector(1,1);
                      temp.add(rs.getString("FID"));
                      temp.add(rs.getString("Fname"));
                      temp.add(rs.getString("Ftype"));
                      temp.add(rs.getString("Fprice"));
                      temp.add(rs.getString("Fnumber"));
                      temp.add(rs.getString("Fsprice"));
                      temp.add(rs.getInt("Fsyear"));
                      temp.add(rs.getInt("Fsmonth"));
                      temp.add(rs.getInt("Fsday"));
                      temp.add(rs.getInt("Ffee"));
                      model.addRow(temp);
                  }
              }
              catch(SQLException e1)
              {

              }

    }

  public static void main(String[] args) {
        SellShow sellshow = new SellShow();
    }
}
