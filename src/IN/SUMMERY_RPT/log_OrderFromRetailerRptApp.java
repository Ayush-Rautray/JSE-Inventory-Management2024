package IN.SUMMERY_RPT;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class OrderFromRetailerRptWin implements ActionListener{
    JFrame f1;
    JPanel p1;
    JLabel lblHead,add1,add2,add3;
    JButton btnClose;
    Object dataCompany[][];
    JTable gridCompany;
    JScrollPane jspCompany;
    Connection conn;
    Statement stmSelect;
    ResultSet rs;
    int slno,rw,tot;
    Font fnt1;
    String colHead[]={"Slno", "Order Number","Order Date","Retailer Name","Locality","State","City","Slno","Product Code","Product Name","Size","MRP","Retailer Quantity","Amount"};


    public OrderFromRetailerRptWin(){

        f1=new JFrame("Logistic Solution " );
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        lblHead=new JLabel("ORDER FROM RETAILER",JLabel.CENTER);
        add1=new JLabel("Kasana ");
        add2=new JLabel("Madhupatna");
        add3=new JLabel("Cuttack");
        fnt1=new Font("Times New Roman",Font.BOLD,24);
        btnClose=new JButton("Close");
        btnClose.addActionListener(this);
        lblHead.setFont(fnt1);
        lblHead.setForeground(Color.red);
        p1.setLayout(new GridLayout (4,1));
        p1.add(lblHead);
        p1.add(add1);
        p1.add(add2);
        p1.add(add3);
        doConnect();

        gridCompany=new JTable(dataCompany,colHead);
        jspCompany=new JScrollPane(gridCompany);
        f1.setLayout(new BorderLayout());
        f1.add(p1,BorderLayout.NORTH);
        f1.add(btnClose,BorderLayout.SOUTH);
        f1.add(jspCompany,BorderLayout.CENTER);
        f1.setSize(1700,850);
        f1.setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==btnClose){
            f1.setVisible(false);
            f1.dispose();
        }
    }

    public void doConnect() {
        try {//step2
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Unable to Load Connection");
        }
        try {//step3
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
            stmSelect=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs=stmSelect.executeQuery("select * from   LOG_TBLORDERFROMRETAILER  ");
            rs.last();
            tot=rs.getRow();
            dataCompany=new Object[tot][14];
            slno=1;
            rw=0;
            rs.beforeFirst();
            while(rs.next()){

                dataCompany[rw][0]=slno;
                dataCompany[rw][1]=rs.getString("ORDNO");
                dataCompany[rw][2]=rs.getString("ODATE");
                dataCompany[rw][3]=rs.getString("RNAME");
                dataCompany[rw][4]=rs.getString("LOCALITY");
                dataCompany[rw][5]=rs.getString("CITY");
                dataCompany[rw][6]=rs.getString("STATE");
                dataCompany[rw][7]=rs.getString("SLNO");
                dataCompany[rw][8]=rs.getString("PCODE");
                dataCompany[rw][9]=rs.getString("PNAME");
                dataCompany[rw][10]=rs.getString("SIZE1");
                dataCompany[rw][11]=rs.getString("MRP");
                dataCompany[rw][12]=rs.getString("RQUANT");
                dataCompany[rw][13]=rs.getString("AMT");
                rw=rw+1;
                slno=slno+1;
            }
        } catch (SQLException se) {
            System.out.println("Unable to connect REPORT ");
        }
    }//do connect

}

class log_OrderFromRetailerRptApp{
    public static void main(String []args){
        OrderFromRetailerRptWin obj;
        obj =new  OrderFromRetailerRptWin();
    }

}



