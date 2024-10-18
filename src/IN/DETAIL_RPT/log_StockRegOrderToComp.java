package IN.DETAIL_RPT;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
class StockRegOrderToCompWin implements ActionListener{

    JFrame f1;
    JPanel p1;
    JLabel lblHead,add1,add2,add3;
    JButton btnClose;
    Object dataCompany[][];
    JTable gridCompany;
    JScrollPane jspCompany;
    Connection conn;
    Statement stmSelect,stmComboCName;
    ResultSet rs,rsComboCName;
    int slno,rw,tot;
    JPanel p2;
    FlowLayout flw;

    Font fnt1;
    String colHead[]={ "SLNO","Order Number","Date","Company Name","Locality","City","State","Slno","Product Code","Product Name","Product Size","Product Price","Order Quantity","Amount"};
    String comp, strComboCName;
    int i,n;
    JOptionPane dlg;
    String company[];

    public StockRegOrderToCompWin(){

        f1=new JFrame("Logistic Solution " );
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flw= new FlowLayout();
        p1=new JPanel();
        p2=new JPanel();
        lblHead=new JLabel("ORDER TO COMPANY",JLabel.CENTER);
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

            stmComboCName=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rsComboCName=stmComboCName.executeQuery("select * from LOG_TBLCOMPANY order by CCODE");
            rsComboCName.last();
            n=rsComboCName.getRow()+1;
            company=new String[n];
            rsComboCName.beforeFirst();
            company[0]="--select--";
            i=1;

            while(rsComboCName.next()){
                strComboCName=rsComboCName.getString("CNAME");
                strComboCName=strComboCName.trim();
                company[i]=strComboCName;
                i=i+1;
            }

            comp=(String)dlg.showInputDialog(f1,"Enter Company Name","Searching",1,null,company,null);
            lblHead.setText("ORDER TO COMPANY "+" [ "+comp+" ]");

            rs=stmSelect.executeQuery("select * from  LOG_TBLORDERTO where CNAME='"+comp+"' ");
            rs.last();
            tot=rs.getRow();
            dataCompany=new Object[tot][14];
            slno=1;
            rw=0;
            rs.beforeFirst();
            while(rs.next()){
                dataCompany[rw][0]=slno;
                dataCompany[rw][0]=slno;
                dataCompany[rw][1]=rs.getString("ORDERNO");
                dataCompany[rw][2]=rs.getString("DATEE");
                dataCompany[rw][3]=rs.getString("CNAME");
                dataCompany[rw][4]=rs.getString("LOCALITY");
                dataCompany[rw][5]=rs.getString("CITY");
                dataCompany[rw][6]=rs.getString("STATE");
                dataCompany[rw][7]=rs.getString("SLNO");
                dataCompany[rw][8]=rs.getString("PCODE");
                dataCompany[rw][9]=rs.getString("PNAME");
                dataCompany[rw][10]=rs.getString("PSIZE");
                dataCompany[rw][11]=rs.getString("PPRICE");
                dataCompany[rw][12]=rs.getString("ORQ");
                dataCompany[rw][13]=rs.getString("AMT");
                rw=rw+1;
                slno=slno+1;
            }

        }catch (SQLException se) {
            System.out.println("Unable to connect REPORT "+se);
        }
    }
}
class log_StockRegOrderToComp{
    public static void main(String []args){
        StockRegOrderToCompWin obj;
        obj =new  StockRegOrderToCompWin();
    }

}