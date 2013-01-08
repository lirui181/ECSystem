package ecsystem;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


//�û�ɾ������
public class UserDelete extends JFrame implements ActionListener{

     DBManager db=new DBManager();
     ResultSet rs;
     DefaultTableModel model =new DefaultTableModel();
     JTable jTable=new JTable(model);
     JScrollPane jScroll=new JScrollPane(jTable);
     JLabel jLab2=new JLabel("�ʻ�ID��");
     JLabel jLab1=new JLabel("���ı�����������Ҫɾ�����ʻ�ID��");
     Vector temp=new Vector(1,1);
     String sql;

     JTextField jText1=new JTextField();

     JButton jBtn1=new JButton("ɾ��");
     JButton jBtn2=new JButton("�˳�");




//�������粼�����ַ���
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



//���幹�췽��
private void jbInit() throws Exception {
        setResizable(false);
        setTitle("�ʻ���Ϣɾ��");
        setSize(500,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


GridBagLayout gridbag = new GridBagLayout();
GridBagConstraints constraints = new GridBagConstraints();
JPanel pane = new JPanel();
pane.setLayout(gridbag);



//���粼������
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

model.addColumn("�û�ID��");
        model.addColumn("�û��ʻ�");
        model.addColumn("�û�����");
        model.addColumn("�û�Ȩ��");
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

//��Ӱ�ť������
jBtn1.addActionListener(this);
jBtn2.addActionListener(this);



// Content Pane
        pane.setBackground(new Color(175, 210, 250));
setContentPane(pane);
validate();



//����¼�
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
            JOptionPane.showMessageDialog(null,"���ݿ����ݲ������ʻ���Ϣ");
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


//����¼�
public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == jBtn1) {
            try {
                sql = "delete from System where UID=" +Integer.parseInt(jText1.getText().trim());
            } catch (Exception e1) {}

            if (db.executeSql(sql)) {
                JOptionPane.showMessageDialog(null, "ɾ����Ϣ�ɹ������ȷ������");
                sql = "select * from System";
                rs = db.getResult(sql);
                boolean isexist = false;
                try {
                    isexist = rs.first();
                } catch (SQLException e1) {}

                if (!isexist) {
                    JOptionPane.showMessageDialog(null, "���ݿ����ݲ������ʻ���Ϣ");
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
                JOptionPane.showMessageDialog(null, "ɾ����Ϣʧ�ܣ���ȷ����Ϣ������");
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
