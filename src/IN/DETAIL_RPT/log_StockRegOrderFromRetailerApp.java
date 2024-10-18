package IN.DETAIL_RPT;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class StockRegOrderFromRetailerWin implements ActionListener{
    JFrame f1;
    JPanel p1;
    JLabel lblHead,add1,add2,add3;
    JButton btnClose;

    JTable gridCompany;
    JScrollPane jspCompany;
    Connection conn;

    int slno,rw,tot;

    String colHead[]={"Slno", "Order Number","Order Date","Retailer Name","Locality","State","City","Slno","Product Code","Product Name","Size","MRP","Retailer Quantity","Amount"};

    //**
    Font fnt1;
    Object data[][];
    Statement stmSelect,stmComboRName;
    ResultSet rs,rsComboRName;
    String rname, strComboRName;
    int i,n;
    JOptionPane dlg;
    String retailer[];
    //**


    public StockRegOrderFromRetailerWin(){

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

        gridCompany=new JTable(data,colHead);
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



            //**


            stmComboRName=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rsComboRName=stmComboRName.executeQuery("select * from LOG_TBLRETAILER order by RCODE");
            rsComboRName.last();
            n=rsComboRName.getRow()+1;
            retailer=new String[n];
            rsComboRName.beforeFirst();
            retailer[0]="--select--";
            i=1;

            while(rsComboRName.next()){
                strComboRName=rsComboRName.getString("RNAME");
                strComboRName=strComboRName.trim();
                retailer[i]=strComboRName;
                i=i+1;
            }
            rname=(String)dlg.showInputDialog(f1,"Enter retailer Code ","Searching",1,null,retailer,null);
            lblHead.setText("ORDER FROM RETAILER "+" [ "+rname+" ]");
            rs=stmSelect.executeQuery("select * from   LOG_TBLORDERFROMRETAILER  where RNAME='"+rname+"' ");

            //**




            rs.last();
            tot=rs.getRow();
            data=new Object[tot][14];
            slno=1;
            rw=0;
            rs.beforeFirst();
            while(rs.next()){

                data[rw][0]=slno;
                data[rw][1]=rs.getString("ORDNO");
                data[rw][2]=rs.getString("ODATE");
                data[rw][3]=rs.getString("RNAME");
                data[rw][4]=rs.getString("LOCALITY");
                data[rw][5]=rs.getString("CITY");
                data[rw][6]=rs.getString("STATE");
                data[rw][7]=rs.getString("SLNO");
                data[rw][8]=rs.getString("PCODE");
                data[rw][9]=rs.getString("PNAME");
                data[rw][10]=rs.getString("SIZE1");
                data[rw][11]=rs.getString("MRP");
                data[rw][12]=rs.getString("RQUANT");
                data[rw][13]=rs.getString("AMT");
                rw=rw+1;
                slno=slno+1;
            }
        } catch (SQLException se) {
            System.out.println("Unable to connect REPORT "+se);
        }
    }//do connect

}

class log_StockRegOrderFromRetailerApp{
    public static void main(String []args){
        StockRegOrderFromRetailerWin obj;
        obj =new  StockRegOrderFromRetailerWin();
    }

}



