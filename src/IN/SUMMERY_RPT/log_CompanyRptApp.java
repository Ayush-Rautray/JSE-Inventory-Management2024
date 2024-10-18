package IN.SUMMERY_RPT;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class CompanyRptWin implements ActionListener{

    JFrame f1;
    JPanel p1;
    JLabel lblHead,add1,add2,add3;
    JButton btnClose;
    String colHead[]={ "SLNO"," Company Code ","Company Name","Contact Person","Locality","City","State","Phone Number","Mail-ID","GST Number","GST Date"};
    Object dataCompany[][];
    JTable gridCompany;
    JScrollPane jspCompany;
    Connection conn;
    Statement stmSelect;
    ResultSet rs;
    int slno,rw,tot;
    Font fnt1;
    public CompanyRptWin(){

        f1=new JFrame("Company Report" );
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        lblHead=new JLabel("COMPANY INFORMATION",JLabel.CENTER);
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
            rs=stmSelect.executeQuery("select * from  LOG_TBLCOMPANY order by CCODE ");
            rs.last();
            tot=rs.getRow();
            dataCompany=new Object[tot][11];
            slno=1;
            rw=0;
            rs.beforeFirst();
            while(rs.next()){

                dataCompany[rw][0]=slno;
                dataCompany[rw][1]=rs.getString("CCODE");
                dataCompany[rw][2]=rs.getString("CNAME");
                dataCompany[rw][3]=rs.getString("CONTPER");
                dataCompany[rw][4]=rs.getString("LOCALITY");
                dataCompany[rw][5]=rs.getString("CITY");
                dataCompany[rw][6]=rs.getString("STATE");
                dataCompany[rw][7]=rs.getString("PHNO");
                dataCompany[rw][8]=rs.getString("MAIL");
                dataCompany[rw][9]=rs.getString("GSTNO");
                dataCompany[rw][10]=rs.getString("GSTDATE");
                rw=rw+1;
                slno=slno+1;
            }
        } catch (SQLException se) {
            System.out.println("Unable to connect REPORT ");
        }
    }//do connect


}
class log_CompanyRptApp{
    public static void main(String []args){
        CompanyRptWin obj;
        obj =new  CompanyRptWin();
    }

}
