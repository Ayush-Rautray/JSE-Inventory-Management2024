import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class GSTInvoiceWin{
    JFrame f1;
    JPanel p1,p2,p3,p4,p5,p6,p7;
    FlowLayout flw,flw1;
    Box vb,hb,vb1,hb1,vb2,hb2;
    Border bl;

    JTable gridCompany;
    JScrollPane jspCompany;
    Connection conn;
    int slno,rw,tot;
    int amt,amt1,disAmt,gstPer,net;

    Font fnt1;
    Color clrfont;
    Object data[][];
    Statement stmSelect,stmCombo;
    ResultSet rs,rsCombo;
    String value, strCombo;
    int i,n;
    JOptionPane dlg;
    String string[];

    String colHead[]={"Slno","Product Code","Product Name","Size","MRP","Quantity","Amount","Dis%","DisAmt"+"GST%","GSTAmt","NetAmt"};
    GridLayout gl83,gl111,gl11,gl12,gl21,gl25;
    String str,str1,str2;

    JLabel lblHead,lblAd1,lblAd2,lblAd3,lblAd4,lblAd5,lblAd6,lblBd1,lblBd2,lblBd3,lblBd4,lblBd5,lblBd6,lblBd7;
    JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11 ,lbl12,lbl13,lbl14,lbl15,lbl16,lbl17,lbl18,lbl19,lbl20,lbl21,lbl22,lbl23,lbl24,lbl25;
    JLabel lblTotal,lblAmt,lblDisAmt,lblGstPer,lblNet,lblTAIW,lblWord,lblInst1,lblInst2,lblReceiverSign,lblCheckedBy,lblAuthorisedBy;

    public GSTInvoiceWin(){

        f1=new JFrame("Logistic Solution " );
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p5=new JPanel();
        p6=new JPanel();
        p7=new JPanel();

        flw= new FlowLayout();
        flw1= new FlowLayout();
        gl83=new GridLayout(8,3);
        gl111=new GridLayout(1,11);
        gl11=new GridLayout(1,1);
        gl12=new GridLayout(1,1);
        gl21=new GridLayout(2,1);
        gl25=new GridLayout(2,1);
        vb=Box.createVerticalBox();
        hb=Box.createHorizontalBox();
        vb1=Box.createVerticalBox();
        hb1=Box.createHorizontalBox();
        vb2=Box.createVerticalBox();
        hb2=Box.createHorizontalBox();
        fnt1=new Font("Castellar",Font.BOLD,30);
        clrfont=new Color(87, 111, 153);
        bl=BorderFactory.createLineBorder(Color.red);


        lblHead=new JLabel("GST INVOICE",JLabel.CENTER);
        lblHead.setFont(fnt1);
        lblHead.setForeground(clrfont);

        lblAd1=new JLabel("OMNI APPARALS ");
        lblAd2=new JLabel("MADHUPATNA");
        lblAd3=new JLabel("CUTTACK 753010");
        lblAd4=new JLabel("PHNO 9238452951 ");
        lblAd5=new JLabel(" GST No 07AAECR2971C1Z ");
        lblAd6=new JLabel(" email omniapparals56@gmail.com");

        lblBd1=new JLabel("BUYER DETAILS ");
        lblBd2=new JLabel("RETAILER NAME "+str );
        lblBd3=new JLabel("LOCALITY "+str+"CITY"+ str);
        lblBd4=new JLabel("PHNO "+str);
        lblBd5=new JLabel("GST NO "+str);
        lblBd6=new JLabel("INVOICE NUMBER "+str+"INVOICE DATE "+str);
        lblBd7=new JLabel("ORDER NUMBER "+str+"ORDER DATE"+str);

        lblTotal=new JLabel("Total");
        lblAmt=new JLabel("");
        lblDisAmt=new JLabel("");
        lblGstPer=new JLabel("");
        lblNet=new JLabel("");
        lblTAIW=new JLabel("Total Amount In Words-");
        lblWord=new JLabel("");
        lblInst1=new JLabel("*Goods once sold cannot be returned");
        lblInst2=new JLabel("*All Dispatch are object to Cuttack Judiciation");
        lblReceiverSign=new JLabel("  Receiver Sign");
        lblCheckedBy=new JLabel("CheckedBy");
        lblAuthorisedBy=new JLabel("AuthorisedBy");

        lbl1=new JLabel("");
        lbl2=new JLabel("");
        lbl3=new JLabel("");
        lbl4=new JLabel("");
        lbl5=new JLabel("");
        lbl6=new JLabel("");
        lbl7=new JLabel("");
        lbl8=new JLabel("");
        lbl9=new JLabel("");
        lbl10=new JLabel("");
        lbl11=new JLabel("");
        lbl12=new JLabel("");
        lbl13=new JLabel("");
        lbl14=new JLabel("");
        lbl15=new JLabel("");
        lbl16=new JLabel("");
        lbl17=new JLabel("");
        lbl18=new JLabel("");
        lbl19=new JLabel("");
        lbl20=new JLabel("_______________");
        lbl21=new JLabel("");
        lbl22=new JLabel("_________________");
        lbl23=new JLabel("");
        lbl24=new JLabel("_________________");
        lbl25=new JLabel("");
        doConnect();


        p2.setLayout(flw);
        p2.add(lblHead);
        p2.setBorder(bl);

        p1.setLayout(gl83);

        p1.add(lblAd1);
        p1.add(lbl1);
        p1.add(lblBd1);

        p1.add(lblAd2);
        p1.add(lbl2);
        p1.add(lblBd2);

        p1.add(lblAd3);
        p1.add(lbl3);
        p1.add(lblBd3);

        p1.add(lblAd4);
        p1.add(lbl4);
        p1.add(lblBd4);

        p1.add(lblAd5);
        p1.add(lbl5);
        p1.add(lblBd5);

        p1.add(lblAd6);
        p1.add(lbl6);
        p1.add(lblBd6);

        p1.add(lbl7);
        p1.add(lbl8);
        p1.add(lblBd7);

        p1.add(lbl9);
        p1.add(lbl10);
        p1.add(lbl11);

        p3.setLayout(gl111);
        p3.add(lbl12);
        p3.add(lbl13);
        p3.add(lbl14);
        p3.add(lbl15);
        p3.add(lbl16);
        p3.add(lbl25);
        p3.add(lblTotal);
        p3.add(lblAmt);
        p3.add(lblDisAmt);
        p3.add(lblGstPer);
        p3.add(lblNet);

        gridCompany=new JTable(data,colHead);
        jspCompany=new JScrollPane(gridCompany);

        p4.setLayout(gl11);
        p4.add(jspCompany);

        p5.setLayout(gl12);
        p5.add(lblTAIW);
        p5.add(lblWord);

        p6.setLayout(gl21);
        p6.add(lblInst1);
        p6.add(lblInst2);

        p7.setLayout(gl25);
        p7.add(lblReceiverSign);
        p7.add(lbl18);
        p7.add(lblCheckedBy);
        p7.add(lbl19);
        p7.add(lblAuthorisedBy);

        p7.add(lbl20);
        p7.add(lbl21);
        p7.add(lbl22);
        p7.add(lbl23);
        p7.add(lbl24);






        vb.add(Box.createVerticalStrut(40));
        vb.add(p2);
        vb.add(Box.createVerticalStrut(20));
        vb.add(p1);
        hb.add(Box.createHorizontalStrut(60));
        hb.add(vb);
        hb.add(Box.createHorizontalStrut(60));

        vb1.add(Box.createVerticalStrut(0));
        vb1.add(p4);
        vb1.add(Box.createVerticalStrut(0));
        vb1.add(p3);
        vb1.add(Box.createVerticalStrut(0));
        vb1.add(p5);

        hb1.add(Box.createHorizontalStrut(0));
        hb1.add(vb1);
        hb1.add(Box.createHorizontalStrut(0));

        vb2.add(Box.createVerticalStrut(0));
        vb2.add(p6);
        vb2.add(Box.createVerticalStrut(0));
        vb2.add(p7);
        hb2.add(Box.createHorizontalStrut(0));
        hb2.add(vb2);
        hb2.add(Box.createHorizontalStrut(0));







        f1.setLayout(new BorderLayout());
        f1.add(hb,BorderLayout.NORTH);

        f1.add(hb1,BorderLayout.CENTER);
        f1.add(hb2,BorderLayout.SOUTH);

        f1.setSize(1700,810);
        f1.setVisible(true);

    }

    public int[] reverse(int a[], int n) {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
        return a;
    }

    public int length(int n){
        int l=0;
        int []num=new int[22];
        while(n>0){
            num[i]=n%10;
            n=n/10;
            i++;l++;
        }
        return l;
    }
    public void NumWord(int nu,int len){
        String[] Digit ={" ","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String []Tens={" "," ","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String word="";
        int []num=new int[len];
        //nu=4000;
        int n=nu;
        int i=0;
        int length=len;
        int val=0;
        while(n>0){
            num[i]=n%10;
            n=n/10;
            i++;
        }
        num= reverse(num, length);//Returning Array
        i=0;
        if(length==6){
            val=num[i];
            word=word+Digit[val]+"Lakh";
            length--;
            i++;

        }
        if(length==5){
            if(num[i]==1) {
                val = num[i] * 10 + num[i + 1];
                word = word + Digit[val]+"Thousend";
                length = length - 2;
            }
            else{
                val=num[i];
                word=word+Tens[val];
                length--;
                i++;
                val=num[i];
                word=word+Digit[val]+"Thousend";
                length--;
                i++;
            }
        }
        if(length==4) {
            val = num[i];
            word = Digit[val] + "Thousent";
            length--;
            i++;
        }
        if(length==3) {
            val = num[i];
            if(val==0){
                length--;
                i++;

            }else{
                word = word + Digit[val] + "Hundred";
                length--;
                i++;
            }
            if(length==2&&num[i]==1){
                val=num[i]*10+num[i+1];
                word=word+Digit[val];
                length= 0;
            }
            else if(length==2){
                val=num[i];
                word=word+Tens[val];
                length--;
                i++;

                if(length==1){
                    val=num[i];
                    word=word+Digit[val];
                }
            }
        }

        lblWord.setText(word+"only");
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
            lblHead.setText("GST INVOICE ");
            rs=stmSelect.executeQuery("select * from   LOG_TBLISSUEOFGOODS where IVNUM='"+value+"'  ");
            rs.last();
            tot=rs.getRow();
            data=new Object[tot][23];
            slno=1;
            rw=0;
            rs.beforeFirst();
            while(rs.next()){
                data[rw][0]=slno;
                data[rw][1]=rs.getString("PCODE");
                data[rw][2]=rs.getString("PNAME");
                data[rw][3]=rs.getString("PSIZE");
                data[rw][4]=rs.getString("MRP");
                data[rw][5]=rs.getString("IVQUANT");
                data[rw][6]=rs.getString("AMT");
                data[rw][7]=rs.getString("DISPER");
                data[rw][8]=rs.getString("DISAMT");
                data[rw][9]=rs.getString("GSTPER");
                data[rw][10]=rs.getString("GSTAMT");
                data[rw][11]=rs.getString("NETAMT");

                str1=rs.getString("RNAME");
                lblBd2=new JLabel("RETAILER NAME: "+str1 );
                //System.out.println(str1);
                str1=rs.getString("LOCALITY");
                str2=rs.getString("CITY");
                lblBd3=new JLabel("LOCALITY: "+str1+"CITY: "+ str1);
                str1=rs.getString("IVNUM");
                str2=rs.getString("IVDATE");
                lblBd6=new JLabel("INVOICE NUMBER "+str1+"INVOICE DATE "+str1);
                str1=rs.getString("ORDNO");
                str2=rs.getString("ODATE");
                lblBd7=new JLabel("ORDER NUMBER "+str1+"ORDER DATE"+str1);


				/*
		lblBd1=new JLabel("BUYER DETAILS ");


        lblBd4=new JLabel("PHNO "+str);
        lblBd5=new JLabel("GST NO "+str);
        lblBd6=new JLabel("INVOICE NUMBER "+str+"INVOICE DATE "+str);
         lblBd7=new JLabel("ORDER NUMBER "+str+"ORDER DATE"+str);

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
				data[rw][21]=rs.getString("NETAMT");*/

                rw=rw+1;
                slno=slno+1;

                amt=disAmt=gstPer=net=0;
                str=rs.getString("AMT");
                amt=amt + Integer.parseInt(str);
                str=rs.getString("DISAMT");
                disAmt=disAmt+Integer.parseInt(str);
                str=rs.getString("GSTPER");
                gstPer=Integer.parseInt(str);
                str=rs.getString("NETAMT");
                net=net+Integer.parseInt(str);
            }
            amt1=net;
            str=Integer.toString(amt);
            lblAmt.setText(str);
            str=Integer.toString(disAmt);
            lblDisAmt.setText(str);
            str=Integer.toString(gstPer);
            lblGstPer.setText(str);
            str=Integer.toString(net);
            lblNet.setText(str);



            NumWord(amt1,length(amt1));

        } catch (SQLException se) {
            System.out.println("Unable to connect REPORT ");
        }
    }//do connect



}

public class log_GSTInvoice {
    public static void main(String []args){
        GSTInvoiceWin obj;
        obj= new  GSTInvoiceWin();
    }
}
