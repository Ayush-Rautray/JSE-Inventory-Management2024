package IN.fORMS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.*;

class PaymentVoucherWin implements ActionListener{
    JFrame f1;
    FlowLayout flw,flw1;
    JPanel p1,p2,p3;
    GridLayout gl94;

    Font fnt1,fnt2;
    Color clrAll,clrfont,clrWhite,clrText;
    Border bl;

    JLabel lblHeader,lblVoucherNo,lblCName,lblCode,lblVDate,lblLocality,lblCity,lblState,lblPMode,lblTPayment,lblTDate,lblBName,lblAmt;
    JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12;

    JTextField txtVoucherNo,txtVDate,txtCode,txtLocality,txtState,txtCity,txtTPayment,txtTDate,txtAmt;

    JComboBox comboCName,comboPMode,comboBName;
    String strPMode[]={"--select--","Cash","Cheque","Draft","Online Payment"};
    String strBname[]={"--select--","SBI Bank","HDFC Bank","ICICIBank","Kotak Bank","Union Bank","Axis Bank"};

    ImageIcon imgClear,imgSave,imgNext,imgPrevious,imgDelete,imgUpdate,imgClose,imgSelect,imgFirst,imgLast;

    JButton btnClear,btnSave,btnNext,btnPrevious,btnDelete,btnUpdate,btnClose,btnSelect,btnFirst,btnLast;

    JOptionPane dlg,dlgIn,dlgCd;
    int i,x=1,option=1,count=0,inttemp;

    Box vb,hb;

    //DataBase Requirements//tbldeptS
    Connection conn;
    Statement stmCompany,stmSelect,stmSave,stmUpdate,stmDelete,stmSearching,stmComboCName,stmGetVNum;
    ResultSet rsCompany,rsUser,rsComCode,rsCombo,rsGetVNum;
    String compName,strVNum,strVDate,strCName,strCode,strLocality,strState,strCity,strPPMode,strTrans,strTDate,strBName,strAmt,str,strVNum1,strSearching;


    public PaymentVoucherWin(){
        f1=new JFrame("Logistic Solution   ");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        gl94= new GridLayout(9,4);
        flw= new FlowLayout();
        flw1= new FlowLayout();
        vb=Box.createVerticalBox();
        hb=Box.createHorizontalBox();

        fnt1=new Font("Castellar",Font.BOLD,30);
        fnt2=new Font("Bahnschrift SemiLight",Font.BOLD,14);
        clrAll=new Color (157, 174, 204);
        clrfont=new Color(87, 111, 153);
        clrWhite=new Color(255,255,255);
        clrText=new Color(245, 243, 242);
        bl=BorderFactory.createLineBorder(Color.red);

        lblHeader= new JLabel("Payment Voucher  ");
        lblHeader.setFont(fnt1);
        lblHeader.setForeground(clrfont);
        lblVoucherNo= new JLabel(" Voucher Number ");
        lblVoucherNo.setFont(fnt2);
        lblCName=new JLabel("Company Name  ");
        lblCName.setFont(fnt2);
        lblCode=new JLabel("                                   Code");
        lblCode.setFont(fnt2);
        lblVDate=new  JLabel("                                   	Date");
        lblVDate.setFont(fnt2);
        lblLocality=new JLabel("Locality");
        lblLocality.setFont(fnt2);
        lblCity=new JLabel("City");
        lblCity.setFont(fnt2);
        lblState=new JLabel("State");
        lblState.setFont(fnt2);
        lblTPayment=new JLabel("CHQ/DO/TXN NO ");
        lblTPayment.setFont(fnt2);
        lblTDate=new JLabel("                                    Date");
        lblTDate.setFont(fnt2);
        lblAmt=new JLabel("Amount ");
        lblAmt.setFont(fnt2);
        lblPMode=new JLabel("Payment Mode");
        lblPMode.setFont(fnt2);
        lblBName=new JLabel("Bank Name ");
        lblBName.setFont(fnt2);


        lbl1=new JLabel();
        lbl2=new JLabel();
        lbl3=new JLabel();
        lbl4=new JLabel();
        lbl5=new JLabel();
        lbl6=new JLabel();
        lbl7=new JLabel();
        lbl8=new JLabel();
        lbl9=new JLabel();
        lbl10=new JLabel();
        lbl11=new JLabel();
        lbl12=new JLabel();

        txtVoucherNo= new JTextField(20);
        txtVoucherNo.setBackground(clrText);
        txtVoucherNo.setFont(fnt2);
        txtVDate= new JTextField(20);
        txtVDate.setBackground(clrText);
        txtVDate.setFont(fnt2);
        txtCode= new JTextField(20);
        txtCode.setBackground(clrText);
        txtCode.setFont(fnt2);
        txtLocality= new JTextField(20);
        txtLocality.setBackground(clrText);
        txtLocality.setFont(fnt2);
        txtState= new JTextField(20);
        txtState.setBackground(clrText);
        txtState.setFont(fnt2);
        txtCity= new JTextField(20);
        txtCity.setBackground(clrText);
        txtCity.setFont(fnt2);
        txtTPayment= new JTextField(20);
        txtTPayment.setBackground(clrText);
        txtTPayment.setFont(fnt2);
        txtTDate= new JTextField(20);
        txtTDate.setBackground(clrText);
        txtTDate.setFont(fnt2);
        txtAmt= new JTextField(20);
        txtAmt.setBackground(clrText);
        txtAmt.setFont(fnt2);

        comboCName= new JComboBox();
        comboCName.setBackground(clrText);
        comboBName=new JComboBox(strBname);
        comboBName.setBackground(clrText);
        comboPMode=new JComboBox(strPMode);
        comboPMode.setBackground(clrText);

        //ImageIcons
        imgClear=new ImageIcon("INew.png");
        imgClose=new ImageIcon("IClose1.png");
        imgDelete=new ImageIcon("IDelete.png");
        imgUpdate= new ImageIcon("INew2.png");
        imgPrevious=new ImageIcon("IPrior.png");
        imgNext= new ImageIcon("INext.png");
        imgSave=new ImageIcon("ISave.png");
        imgSelect=new ImageIcon("ISearch.png");
        imgFirst=new ImageIcon("IPrior1.png");
        imgLast=new ImageIcon("INext1.png");


        //Buttons and colors
        btnClear=new JButton("CLEAR",imgClear);
        btnClear.setBackground(clrWhite);
        btnClear.setToolTipText("Clear data for new entries ");
        btnClose=new JButton("CLOSE",imgClose);
        btnClose.setBackground(clrWhite);
        btnClose.setToolTipText("Close the Application  ");
        btnDelete=new JButton("DELETE",imgDelete);
        btnDelete.setBackground(clrWhite);
        btnDelete.setToolTipText("Delete the current Record   ");
        btnUpdate=new JButton("UPDATE",imgUpdate);
        btnUpdate.setBackground(clrWhite);
        btnUpdate.setToolTipText("Updating Current record ");
        btnPrevious=new JButton("PREVIOUS",imgPrevious);
        btnPrevious.setBackground(clrWhite);
        btnPrevious.setToolTipText("Previous Record ");
        btnNext=new JButton("NEXT",imgNext);
        btnNext.setBackground(clrWhite);
        btnNext.setToolTipText("Next Record ");
        btnSave=new JButton("SAVE",imgSave);
        btnSave.setBackground(clrWhite);
        btnSave.setToolTipText("Save Current Record ");
        btnSelect=new JButton("SELECT",imgSelect);
        btnSelect.setBackground(clrWhite);
        btnSelect.setToolTipText("Searching record ");
        btnFirst=new JButton ("FIRST",imgFirst);
        btnFirst.setBackground(clrWhite);
        btnFirst.setToolTipText("Show First Record ");
        btnLast=new JButton("LAST",imgLast);
        btnLast.setBackground(clrWhite);
        btnLast.setToolTipText(" Show Last Record ");

        btnClear.addActionListener(this);
        btnSave.addActionListener(this);
        btnNext.addActionListener(this);
        btnClose.addActionListener(this);
        btnPrevious.addActionListener(this);
        btnDelete.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnSelect.addActionListener(this);
        btnFirst.addActionListener(this);
        btnLast.addActionListener(this);

        dlg=new JOptionPane();
        dlgIn=new JOptionPane();
        dlgCd=new JOptionPane();

        p1.setLayout(flw);
        p1.setBorder(bl);
        p1.add(lblHeader);

        p2.setLayout(gl94);
        p2.add(lblVoucherNo);
        p2.add(txtVoucherNo);
        p2.add(lblVDate);
        p2.add(txtVDate);
        p2.add(lblCName);
        p2.add(comboCName);
        p2.add(lblCode);
        p2.add(txtCode);
        p2.add(lblLocality);
        p2.add(txtLocality);
        p2.add(lbl1);
        p2.add(lbl2);
        p2.add(lblState);
        p2.add(txtState);
        p2.add(lbl3);
        p2.add(lbl4);
        p2.add(lblCity);
        p2.add(txtCity);
        p2.add(lbl5);
        p2.add(lbl6);
        p2.add(lblPMode);
        p2.add(comboPMode);
        p2.add(lbl7);
        p2.add(lbl8);
        p2.add(lblTPayment);
        p2.add(txtTPayment);
        p2.add(lblTDate);
        p2.add(txtTDate);
        p2.add(lblBName);
        p2.add(comboBName);
        p2.add(lbl9);
        p2.add(lbl10);
        p2.add(lblAmt);
        p2.add(txtAmt);
        p2.add(lbl11);
        p2.add(lbl12);

        p3.setLayout(flw1);
        p3.add(btnClear);
        p3.add(btnSave);
        p3.add(btnNext);
        p3.add(btnPrevious);
        p3.add(btnDelete);
        p3.add(btnUpdate);
        p3.add(btnSelect);
        p3.add(btnFirst);
        p3.add(btnLast);
        p3.add(btnClose);


        vb.add(Box.createVerticalStrut(20));
        vb.add(p1);
        vb.add(Box.createVerticalStrut(20));
        vb.add(p2);
        vb.add(Box.createVerticalStrut(20));
        vb.add(p3);
        vb.add(Box.createVerticalStrut(20));

        hb.add(Box.createHorizontalStrut(30));
        hb.add(vb);
        hb.add(Box.createHorizontalStrut(30));

        f1.add(hb);
        f1.setBounds(230,170,1075,500);
        doConnect();
        getVNum();
        createCNameCombo();
        f1.setResizable(false);
        f1.setVisible(true);



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
            rsUser=stmSelect.executeQuery("select * from  LOG_TBLPAYMENTVOUCHER order by VNUM ");   //order by PCODE
        } catch (SQLException se) {
            System.out.println("Unable to connect");
        }
    }


    public void getVNum(){

        try{

            stmGetVNum=conn.createStatement();
            rsGetVNum=stmGetVNum.executeQuery("select count(VNUM) as VNUM from LOG_TBLPAYMENTVOUCHER");
            rsGetVNum.next();

            str=rsGetVNum.getString("VNUM"); //Getting Voucher Number
            //System.out.println("STR GetVNum "+str);
            inttemp= Integer.parseInt(str);//Converting str to int
            inttemp=inttemp+1;//Updation
            str=String.valueOf(inttemp);//converting int to str
            str=str.trim();
            txtVoucherNo.setText(str);
            txtVoucherNo.setEditable(false);

        } catch (SQLException se) {
            System.out.println("Unable to call getVNum");
        }

    }


    public void createCNameCombo(){
        //System.out.println("Here...");
        try {
            stmCompany = conn.createStatement();
            rsCompany = stmCompany.executeQuery("select * from LOG_TBLCOMPANY order by CCODE ");   //order by CCODE
            str="--select--";
            comboCName.addItem(str);
            while(rsCompany.next()){

                compName = rsCompany.getString("CNAME");
                compName=compName.trim();
                comboCName.addItem(compName);
            }

        } catch (SQLException se) {
            System.out.println("Unable to create combo"+se);
            //dlg.showMessageDialog(f1, "unable to createDeptCombo" + se, "Message", 1);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        //CLEAR-->
        if (ae.getSource() == btnClear) {
            getVNum();
            i=0;
            comboBName.setSelectedIndex(i);
            comboCName.setSelectedIndex(i);
            comboPMode.setSelectedIndex(i);
            txtVDate.setText("");
            txtCode.setText("");
            txtLocality.setText("");
            txtState.setText("");
            txtCity.setText("");
            txtTPayment.setText("");
            txtTDate.setText("");
            txtAmt.setText("");

        }

        else if(ae.getSource() == btnSave){

            strVNum=txtVoucherNo.getText();
            strVNum=strVNum.trim();
            strVDate=txtVDate.getText();
            strVDate=strVDate.trim();
            strCName=comboCName.getSelectedItem().toString();
            strCName=strCName.trim();
            strCode=txtCode.getText();
            strLocality=txtLocality.getText();
            strState=txtState.getText();
            strCity=txtCity.getText();
            strPPMode=comboPMode.getSelectedItem().toString();
            strPPMode=strPPMode.trim();
            strTrans=txtTPayment.getText();
            strTDate=txtTDate.getText();
            strBName=comboBName.getSelectedItem().toString();
            strBName=strBName.trim();
            strAmt=txtAmt.getText();

            try{
                stmSave=conn.createStatement();
                stmSave.executeUpdate("insert into   LOG_TBLPAYMENTVOUCHER values('"+strVNum+"','"+strVDate+"','"+strCName+"','"+strCode+"','"+strLocality+"','"+strState+"','"+strCity+"','"+strPPMode+"','"+strTrans+"','"+strTDate+"','"+strBName+"','"+strAmt+"')");
                //System.out.println("save");
                dlg.showMessageDialog(f1,"One Record Savaed","Message",1);
            }
            catch(SQLException se){
                System.out.println("Unable to save"+se);
                dlg.showMessageDialog(f1,"Not Saved"+se,"Message",2);
            }

        }


        else if(ae.getSource()==btnNext){

            try{
                if(rsUser.isLast()){
                    dlg.showMessageDialog(f1,"Last Record ","Message",1);
                }
                else{
                    rsUser.next();
                    strVNum =rsUser.getString("VNUM");
                    strVDate=rsUser.getString("VDATE");
                    strCName=rsUser.getString("CNAME");
                    strCode=rsUser.getString("CODE");
                    strLocality=rsUser.getString("LOCALITY");
                    strState=rsUser.getString("STATE");
                    strCity=rsUser.getString("CITY");
                    strPPMode=rsUser.getString("PMODE");
                    strTrans=rsUser.getString("TRANS");
                    strTDate=rsUser.getString("TDATE");
                    strBName=rsUser.getString("BNAME");
                    strAmt=rsUser.getString("AMT");

                    strVNum1=strVNum.trim();
                    txtVoucherNo.setText(strVNum);
                    txtVDate.setText(strVDate);
                    strCName=strCName.trim();
                    comboCName.setSelectedItem(strCName);
                    txtCode.setText(strCode);
                    txtLocality.setText(strLocality);
                    txtCity.setText(strCity);
                    txtState.setText(strState);
                    strPPMode=strPPMode.trim();
                    comboPMode.setSelectedItem(strPPMode);
                    txtTPayment.setText(strTrans);
                    txtTDate.setText(strTDate);
                    strBName=strBName.trim();
                    comboBName.setSelectedItem(strBName);
                    txtAmt.setText(strAmt);
                }
            }
            catch(SQLException se){
                // System.out.println("Unable to go next"+se);
                dlg.showMessageDialog(f1,"unable to go next"+se,"Message",2);
            }

        }

        //PREVIOUS-->
        else if(ae.getSource()==btnPrevious){
            try{
                if(rsUser.isFirst()){
                    dlg.showMessageDialog(f1,"First Record ","Message",1);
                }
                else{
                    rsUser.previous();
                    strVNum =rsUser.getString("VNUM");
                    strVDate=rsUser.getString("VDATE");
                    strCName=rsUser.getString("CNAME");
                    strCode=rsUser.getString("CODE");
                    strLocality=rsUser.getString("LOCALITY");
                    strState=rsUser.getString("STATE");
                    strCity=rsUser.getString("CITY");
                    strPPMode=rsUser.getString("PMODE");
                    strTrans=rsUser.getString("TRANS");
                    strTDate=rsUser.getString("TDATE");
                    strBName=rsUser.getString("BNAME");
                    strAmt=rsUser.getString("AMT");

                    strVNum1=strVNum.trim();
                    txtVoucherNo.setText(strVNum);
                    txtVDate.setText(strVDate);
                    strCName=strCName.trim();
                    comboCName.setSelectedItem(strCName);
                    txtCode.setText(strCode);
                    txtLocality.setText(strLocality);
                    txtCity.setText(strCity);
                    txtState.setText(strState);
                    strPPMode=strPPMode.trim();
                    comboPMode.setSelectedItem(strPPMode);
                    txtTPayment.setText(strTrans);
                    txtTDate.setText(strTDate);
                    strBName=strBName.trim();
                    comboBName.setSelectedItem(strBName);
                    txtAmt.setText(strAmt);
                }
            }
            catch(SQLException se){
                // System.out.println("Unable to go Previous"+se);
                dlg.showMessageDialog(f1,"unable to go Previous "+se,"Message",2);
            }
        }


        else if(ae.getSource()==btnFirst){
            try{
                rsUser.first();
                strVNum =rsUser.getString("VNUM");
                strVDate=rsUser.getString("VDATE");
                strCName=rsUser.getString("CNAME");
                strCode=rsUser.getString("CODE");
                strLocality=rsUser.getString("LOCALITY");
                strState=rsUser.getString("STATE");
                strCity=rsUser.getString("CITY");
                strPPMode=rsUser.getString("PMODE");
                strTrans=rsUser.getString("TRANS");
                strTDate=rsUser.getString("TDATE");
                strBName=rsUser.getString("BNAME");
                strAmt=rsUser.getString("AMT");

                strVNum1=strVNum.trim();
                txtVoucherNo.setText(strVNum);
                txtVDate.setText(strVDate);
                strCName=strCName.trim();
                comboCName.setSelectedItem(strCName);
                txtCode.setText(strCode);
                txtLocality.setText(strLocality);
                txtCity.setText(strCity);
                txtState.setText(strState);
                strPPMode=strPPMode.trim();
                comboPMode.setSelectedItem(strPPMode);
                txtTPayment.setText(strTrans);
                txtTDate.setText(strTDate);
                strBName=strBName.trim();
                comboBName.setSelectedItem(strBName);
                txtAmt.setText(strAmt);
            }
            catch(SQLException se){
                // System.out.println("Unable to go previous"+se);
                dlg.showMessageDialog(f1,"unable to go First"+se,"Message",2);
            }
        }
        //LAST DATA
        else if(ae.getSource()==btnLast){
            try{
                rsUser.last();
                strVNum =rsUser.getString("VNUM");
                strVDate=rsUser.getString("VDATE");
                strCName=rsUser.getString("CNAME");
                strCode=rsUser.getString("CODE");
                strLocality=rsUser.getString("LOCALITY");
                strState=rsUser.getString("STATE");
                strCity=rsUser.getString("CITY");
                strPPMode=rsUser.getString("PMODE");
                strTrans=rsUser.getString("TRANS");
                strTDate=rsUser.getString("TDATE");
                strBName=rsUser.getString("BNAME");
                strAmt=rsUser.getString("AMT");

                strVNum1=strVNum.trim();
                txtVoucherNo.setText(strVNum);
                txtVDate.setText(strVDate);
                strCName=strCName.trim();
                comboCName.setSelectedItem(strCName);
                txtCode.setText(strCode);
                txtLocality.setText(strLocality);
                txtCity.setText(strCity);
                txtState.setText(strState);
                strPPMode=strPPMode.trim();
                comboPMode.setSelectedItem(strPPMode);
                txtTPayment.setText(strTrans);
                txtTDate.setText(strTDate);
                strBName=strBName.trim();
                comboBName.setSelectedItem(strBName);
                txtAmt.setText(strAmt);
            }
            catch(SQLException se){
                // System.out.println("Unable to go Last"+se);
                dlg.showMessageDialog(f1,"unable to go Last "+se,"Message",2);
            }
        }


        else if(ae.getSource()==btnDelete){
            try{
                option=dlgCd.showConfirmDialog(f1,"Sure to Delete","Alert",2);
                if(option==0){
                    stmDelete=conn.createStatement();
                    stmDelete.executeUpdate("delete from LOG_TBLPAYMENTVOUCHER where  VNUM='"+strVNum1+"'");
                    dlg.showMessageDialog(f1,"Record Deleted  ","Message",1);
                }
            }
            catch(SQLException se){
                // System.out.println("Unable to go Delete"+se);
                dlg.showMessageDialog(f1,"unable to go Delete"+se,"Message",2);
            }
        }


        //SELECT-->
        else if(ae.getSource()==btnSelect){
            strSearching= dlg.showInputDialog(f1,"Enter Voucher Number","Searching ",3);
            try{
                stmSearching=conn.createStatement();
                rsComCode=stmSearching.executeQuery("select * from LOG_TBLPAYMENTVOUCHER where VNUM='"+strSearching+"'");

                if(rsComCode.next()){

                    strVNum=rsComCode.getString("VNUM");
                    strTDate=rsComCode.getString("VDATE");
                    strCName=rsComCode.getString("CNAME");
                    strCode=rsComCode.getString("CODE");
                    strLocality =rsComCode.getString("LOCALITY");
                    strState=rsComCode.getString("STATE");
                    strCity=rsComCode.getString("CITY");
                    strPPMode=rsComCode.getString("PMODE");
                    strTrans=rsComCode.getString("TRANS");
                    strTDate=rsComCode.getString("TDATE");
                    strBName=rsComCode.getString("BNAME");
                    strAmt=rsComCode.getString("AMT");

                    txtVoucherNo.setText(strVNum);
                    txtVDate.setText(strVDate);
                    comboCName.setSelectedItem(strCName);
                    txtCode.setText(strCode);
                    txtLocality.setText(strLocality);
                    txtCity.setText(strCity);
                    txtState.setText(strState);
                    comboPMode.setSelectedItem(strPPMode);
                    txtTPayment.setText(strTrans);
                    txtTDate.setText(strTDate);
                    comboBName.setSelectedItem(strBName);
                    txtAmt.setText(strAmt);
                }
                //else{
                // dlg.showMessageDialog(f1,"Record Not Found ","Aleart",1);
                //}
            }
            catch(SQLException se){
                // System.out.println("ERROR"+se);
                dlg.showMessageDialog(f1,"ERROR"+se,"Message",2);
            }
        }


        else if(ae.getSource()==btnUpdate){

            strVNum=txtVoucherNo.getText();
            strVNum=strVNum.trim();
            strVDate=txtVDate.getText();
            strVDate=strVDate.trim();
            strCName=comboCName.getSelectedItem().toString();
            strCName=strCName.trim();
            strCode=txtCode.getText();
            strLocality=txtLocality.getText();
            strState=txtState.getText();
            strCity=txtCity.getText();
            strPPMode=comboPMode.getSelectedItem().toString();
            strPPMode=strPPMode.trim();
            strTrans=txtTPayment.getText();
            strTDate=txtTDate.getText();
            strBName=comboBName.getSelectedItem().toString();
            strBName=strBName.trim();
            strAmt=txtAmt.getText();


            try {
                stmUpdate = conn.createStatement();
                option=dlgCd.showConfirmDialog(f1,"Sure to Update","Alert",2);
                if(option==0){
                    stmUpdate.executeUpdate("update LOG_TBLPAYMENTVOUCHER  set VNUM='"+strVNum+"',VDATE='"+strVDate+"',CNAME ='"+strCName+"',CODE ='"+strCode+"',LOCALITY='"+strLocality+"', CITY='"+strCity+"', STATE='"+strState+"',PMODE='"+strPPMode+"',TRANS='"+strTrans+"',BNAME='"+strBName+"', AMT='"+strAmt+"' where VNUM= '"+strVNum1+"'");
                    dlg.showMessageDialog(f1,"Record Updated  ","Updating",1);
                }
            }
            catch(SQLException  se){
                // System.out.println("Unable to go Update"+se);
                dlg.showMessageDialog(f1,"unable to Update "+se,"Message",2);
            }


        }

        else if(ae.getSource()==btnClose){
            option=dlgCd.showConfirmDialog(f1,"Sure to end","Alert",2);
            if(option==0){

                dlg.showMessageDialog(f1,"Have A Good Day ","Message",1);
                f1.setVisible(false);
                f1.dispose();

            }
            else if(option!=1){
                dlg.showMessageDialog(f1,"Thank You  ","Message",1);
            }

        }
    }



}
class log_PaymentVoucherApp{
    public static void main(String []args){
        PaymentVoucherWin obj;
        obj =new PaymentVoucherWin();
    }
}

/*	create table LOG_TBLPAYMENTVOUCHER(VNUM number(7),VDATE char(50),CNAME char(50),CODE char(50),LOCALITY char(50),STATE 	char(50),CITY char(50),PMODE char(50),TRANS char(50),TDATE char(50),BNAME char(50),AMT number(7,2));
 */