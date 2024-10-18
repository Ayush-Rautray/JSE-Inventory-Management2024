package IN.DETAIL_RPT;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class StockRptIssueOfGoodsINWin implements ActionListener{
    JFrame f1;
    JPanel p1;
    JLabel lblHead,add1,add2,add3;
    JButton btnClose;

    JTable gridCompany;
    JScrollPane jspCompany;
    Connection conn;

    int slno,rw,tot;

    String colHead[]={"Invoice Number","Invoice Date","Order Number","Order Date","Retailer Name","Locality","City","State","Product Type","Slno","Product Code","Product Name","Product Size","MRP","Invoice Quantity","Amount","Discount%","Discount Amount","GST%","GST Amount","Net Amount" };

    //**
    Font fnt1;
    Object data[][];
    Statement stmSelect,stmCombo;
    ResultSet rs,rsCombo;
    String value, strCombo;
    int i,n;
    JOptionPane dlg;
    String string[];
    //**

    public StockRptIssueOfGoodsINWin(){

        f1=new JFrame("Logistic Solution " );
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        lblHead=new JLabel("ISSUE OF GOODS",JLabel.CENTER);
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



            stmCombo=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rsCombo=stmCombo.executeQuery("select * from LOG_TBLISSUEOFGOODS ");
            rsCombo.last();
            n=rsCombo.getRow()+1;
            string=new String[n];
            rsCombo.beforeFirst();
            string[0]="--select--";
            i=1;

            while(rsCombo.next()){
                strCombo=rsCombo.getString("IVNUM");
                strCombo=strCombo.trim();
                string[i]=strCombo;
                i=i+1;
            }
            value=(String)dlg.showInputDialog(f1,"Enter Invoice Number ","Searching",1,null,string,null);
            lblHead.setText("Issue Of Goods "+" [ "+value+" ]");
            rs=stmSelect.executeQuery("select * from   LOG_TBLISSUEOFGOODS where IVNUM='"+value+"'  ");
            rs.last();
            tot=rs.getRow();
            data=new Object[tot][23];
            slno=1;
            rw=0;
            rs.beforeFirst();
            while(rs.next()){

                data[rw][0]=slno;
                data[rw][1]=rs.getString("IVNUM");
                data[rw][2]=rs.getString("IVDATE");
                data[rw][3]=rs.getString("ORDNO");
                data[rw][4]=rs.getString("ODATE");
                data[rw][5]=rs.getString("RNAME");
                data[rw][6]=rs.getString("LOCALITY");
                data[rw][7]=rs.getString("CITY");
                data[rw][8]=rs.getString("STATE");
                data[rw][9]=rs.getString("PTYPE");
                data[rw][10]=rs.getString("SLNO");
                data[rw][11]=rs.getString("PCODE");
                data[rw][12]=rs.getString("PNAME");
                data[rw][13]=rs.getString("PSIZE");
                data[rw][14]=rs.getString("MRP");
                data[rw][15]=rs.getString("IVQUANT");
                data[rw][16]=rs.getString("AMT");
                data[rw][17]=rs.getString("DISPER");
                data[rw][18]=rs.getString("DISAMT");
                data[rw][19]=rs.getString("GSTPER");
                data[rw][20]=rs.getString("GSTAMT");
                data[rw][21]=rs.getString("NETAMT");
                rw=rw+1;
                slno=slno+1;
            }
        } catch (SQLException se) {
            System.out.println("Unable to connect REPORT ");
        }
    }//do connect

}

class log_StockRptIssueOfGoodsINApp{
    public static void main(String []args){
        StockRptIssueOfGoodsINWin obj;
        obj =new  StockRptIssueOfGoodsINWin();
    }

}



