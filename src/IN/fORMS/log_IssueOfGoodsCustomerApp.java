package IN.fORMS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.*;

class IssueOfGoodsCustomerWin implements ActionListener   {
    JFrame f1;
    FlowLayout flw,flw1;
    JPanel p1,p2,p3,p4;
    GridLayout gl64,gl212;
    Box vb,hb;

    Font fnt1,fnt2,fnt3;
    Color clrAll,clrfont,clrWhite,clrText;
    Border bl;

    JLabel lblHeader,lblInvoiceNo,lblCustomerID,lblCusName,lblLocality,lblCity,lblState,lblIDate,lblODate,lblPType,lblSlno,lblPCode,lblPName,lblSize,lblMRP,lblIQuant,lblAmt,lblDisPer,lblDisAmt,lblGSTper,lblGSTAmt,lblNetAmt,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8;


    JTextField txtInvoiceNo,txtCustomerID,txtCusName,txtLocality,txtCity,txtState,txtIDate,txtODate,txtSlno,txtPName,txtSize,txtMRP,txtIQuant,txtAmt,txtDisPer,txtDisAmt,txtGStper,txtGSTAmt,txtNetAmt;

    JComboBox comboPCode,comboPType;
    String Payment[]={"--Select--","Cash","Cradit"};

    ImageIcon imgClear,imgSave,imgNext,imgPrevious,imgDelete,imgUpdate,imgClose,imgSelect,imgFirst,imgLast;

    JButton btnClear,btnSave,btnNext,btnPrevious,btnDelete,btnUpdate,btnClose,btnSelect,btnFirst,btnLast;
    //Dialogs
    JOptionPane dlg,dlgCd;
    int option=1, i=1;
    float quant,amt,price,percent,taxable,total;

    Connection conn;
    Statement stmSelect,stmComboPCode,stmCombo,stmSave,stmDelete,stmSearching,stmUpdate,stmStockdown,stmStockNew,stmProduct1,stmGetSlno;
    ResultSet rsUser,rsComboPCode,rsCombo,rsSearching,rsStockdown,rsProduct,rsGetSlno;
    String str,str1,str2,str3,strCustomerID,strComboPCode,strInvoiceNo,strCusName,strPType,strLocality,strCity,strState,strIDate,strODate,strSLNO,strPCode,strPName,strSize,strMrp,strIVQuant,strAmt,strSearching,strDisPer,strDisAmt,strGSTPer,strGSTAmt,strNetAmt,strInvoice1,strPCode1,strPCode2,strPhno;
    int intIVQant,intIVQant1,inttemp;


    public IssueOfGoodsCustomerWin(){
        f1=new JFrame("Logistic Solution");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flw= new FlowLayout();
        flw1=new FlowLayout();
        p1= new JPanel();
        p2= new JPanel();
        p3= new JPanel();
        p4= new JPanel();
        gl212=new GridLayout(2,12);
        gl64=new GridLayout(6,4);
        vb=Box.createVerticalBox();
        hb=Box.createHorizontalBox();

        fnt1=new Font("Castellar",Font.BOLD,30);
        fnt2=new Font("Bahnschrift SemiLight",Font.BOLD,12);
        fnt3=new Font("Bahnschrift SemiLight",Font.BOLD,15);
        clrAll=new Color (157, 174, 204);
        clrfont=new Color(87, 111, 153);
        clrWhite=new Color(255,255,255);
        clrText=new Color(245, 243, 242);
        bl=BorderFactory.createLineBorder(Color.red);

        lblHeader=new JLabel(" ISSUE OF GOODS  [ CUSTOMER ]");
        lblHeader.setFont(fnt1);
        lblHeader.setForeground(clrfont);
        lblInvoiceNo=new JLabel(" Invoice Number ");
        lblInvoiceNo.setFont(fnt3);
        lblCustomerID=new JLabel(" Customer ID");
        lblCustomerID.setFont(fnt3);
        lblCusName=new JLabel(" Customer  Name");
        lblCusName.setFont(fnt3);
        lblLocality=new JLabel(" Locality");
        lblLocality.setFont(fnt3);
        lblCity=new JLabel(" City");
        lblCity.setFont(fnt3);
        lblState=new JLabel(" State");
        lblState.setFont(fnt3);
        lblIDate=new JLabel("                                                        Invoice Date");
        lblIDate.setFont(fnt3);
        lblODate=new JLabel("                                                        Order Date");
        lblODate.setFont(fnt3);
        lblPType=new JLabel("                                                          Purchase type");
        lblPType.setFont(fnt3);
        lblSlno=new JLabel(" Slno");
        lblSlno.setFont(fnt2);
        lblPCode=new JLabel(" Product Code");
        lblPCode.setFont(fnt2);
        lblPName=new JLabel(" Product Name");
        lblPName.setFont(fnt2);
        lblSize=new JLabel(" Size");
        lblSize.setFont(fnt2);
        lblMRP=new JLabel(" MRP");
        lblMRP.setFont(fnt2);
        lblIQuant=new JLabel(" Issue Quantity");
        lblIQuant.setFont(fnt2);
        lblAmt=new JLabel(" Amount");
        lblAmt.setFont(fnt2);
        lblDisPer=new JLabel("Discount Percentage");
        lblDisPer.setFont(fnt2);
        lblDisAmt=new JLabel("    Discount Amount");
        lblDisAmt.setFont(fnt2);
        lblGSTper=new JLabel(" GST Percentage");
        lblGSTper.setFont(fnt2);
        lblGSTAmt=new JLabel(" GST Amount");
        lblGSTAmt.setFont(fnt2);
        lblNetAmt=new JLabel(" Net Amount");
        lblNetAmt.setFont(fnt2);
        lbl1=new JLabel("");
        lbl2=new JLabel("");
        lbl3=new JLabel("");
        lbl4=new JLabel("");
        lbl5=new JLabel("");
        lbl6=new JLabel("");
        lbl7=new JLabel("");
        lbl8=new JLabel("");


        comboPCode=new JComboBox();
        comboPCode.setBackground(clrText);
        comboPType=new JComboBox(Payment);
        comboPType.setBackground(clrText);

        txtInvoiceNo= new JTextField(20);
        txtInvoiceNo.setBackground(clrText);
        txtInvoiceNo.setFont(fnt3);
        txtIDate= new JTextField(20);
        txtIDate.setBackground(clrText);
        txtIDate.setFont(fnt3);
        txtCustomerID=new JTextField(20);
        txtCustomerID.setBackground(clrText);
        txtCustomerID.setFont(fnt3);
        txtCusName= new JTextField(20);
        txtCusName.setBackground(clrText);
        txtCusName.setFont(fnt3);
        txtLocality= new JTextField(20);
        txtLocality.setBackground(clrText);
        txtLocality.setFont(fnt3);
        txtCity= new JTextField(20);
        txtCity.setBackground(clrText);
        txtCity.setFont(fnt3);
        txtState= new JTextField(20);
        txtState.setBackground(clrText);
        txtState.setFont(fnt3);
        txtIDate= new JTextField(20);
        txtIDate.setBackground(clrText);
        txtIDate.setFont(fnt3);
        txtODate= new JTextField(20);
        txtODate.setBackground(clrText);
        txtODate.setFont(fnt3);
        txtSlno= new JTextField(20);
        txtSlno.setBackground(clrText);
        txtSlno.setFont(fnt2);
        txtPName= new JTextField(20);
        txtPName.setBackground(clrText);
        txtPName.setFont(fnt2);
        txtSize= new JTextField(20);
        txtSize.setBackground(clrText);
        txtSize.setFont(fnt2);
        txtMRP= new JTextField(20);
        txtMRP.setBackground(clrText);
        txtMRP.setFont(fnt2);
        txtIQuant= new JTextField(20);
        txtIQuant.setBackground(clrText);
        txtIQuant.setFont(fnt2);
        txtAmt= new JTextField(20);
        txtAmt.setBackground(clrText);
        txtAmt.setFont(fnt2);
        txtDisPer= new JTextField(20);
        txtDisPer.setBackground(clrText);
        txtDisPer.setFont(fnt2);
        txtDisAmt= new JTextField(20);
        txtDisAmt.setBackground(clrText);
        txtDisAmt.setFont(fnt2);
        txtGStper= new JTextField(20);
        txtGStper.setBackground(clrText);
        txtGStper.setFont(fnt2);
        txtGSTAmt= new JTextField(20);
        txtGSTAmt.setBackground(clrText);
        txtGSTAmt.setFont(fnt2);
        txtNetAmt= new JTextField(20);
        txtNetAmt.setBackground(clrText);
        txtNetAmt.setFont(fnt2);

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
        btnSelect=new JButton("SEARCH",imgSelect);
        btnSelect.setBackground(clrWhite);
        btnSelect.setToolTipText("Searching record ");
        btnFirst=new JButton ("FIRST",imgFirst);
        btnFirst.setBackground(clrWhite);
        btnFirst.setToolTipText("Show First Record ");
        btnLast=new JButton("LAST",imgLast);
        btnLast.setBackground(clrWhite);
        btnLast.setToolTipText(" Show Last Record ");

        txtDisPer.addActionListener(this);
        txtIQuant.addActionListener(this);
        comboPCode.addActionListener(this);
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


        p1.setLayout(flw);
        p1.setBorder(bl);
        p1.add(lblHeader);

        p2.setLayout(gl64);

        p2.add(lblInvoiceNo);
        p2.add(txtInvoiceNo);
        p2.add(lblIDate);
        p2.add(txtIDate);

        p2.add(lblCustomerID);
        p2.add(txtCustomerID);
        p2.add(lblODate);
        p2.add(txtODate);

        p2.add(lblCusName);
        p2.add(txtCusName);
        p2.add(lbl1);
        p2.add(lbl2);

        p2.add(lblLocality);
        p2.add(txtLocality);
        p2.add(lbl3);
        p2.add(lbl4);

        p2.add(lblCity);
        p2.add(txtCity);
        p2.add(lbl5);
        p2.add(lbl6);

        p2.add(lblState);
        p2.add(txtState);
        p2.add(lblPType);
        p2.add(comboPType);

        p3.setLayout(gl212);

        p3.add(lblSlno);
        p3.add(lblPCode);
        p3.add(lblPName);
        p3.add(lblSize);
        p3.add(lblMRP);
        p3.add(lblIQuant);
        p3.add(lblAmt);
        p3.add(lblDisPer);
        p3.add(lblDisAmt);
        p3.add(lblGSTper);
        p3.add(lblGSTAmt);
        p3.add(lblNetAmt);

        p3.add(txtSlno);
        p3.add(comboPCode);
        p3.add(txtPName);
        p3.add(txtSize);
        p3.add(txtMRP);
        p3.add(txtIQuant);
        p3.add(txtAmt);
        p3.add(txtDisPer);
        p3.add(txtDisAmt);
        p3.add(txtGStper);
        p3.add(txtGSTAmt);
        p3.add(txtNetAmt);

        p4.setLayout(flw1);
        p4.add(btnClear);
        p4.add(btnSave);
        p4.add(btnNext);
        p4.add(btnPrevious);
        p4.add(btnDelete);
        p4.add(btnUpdate);
        p4.add(btnSelect);
        p4.add(btnFirst);
        p4.add(btnLast);
        p4.add(btnClose);

        //Box and Strut
        vb.add(Box.createVerticalStrut(20));
        vb.add(p1);
        vb.add(Box.createVerticalStrut(20));
        vb.add(p2);
        vb.add(Box.createVerticalStrut(5));
        vb.add(p3);
        vb.add(Box.createVerticalStrut(20));
        vb.add(p4);
        vb.add(Box.createVerticalStrut(20));

        hb.add(Box.createHorizontalStrut(20));
        hb.add(vb);
        hb.add(Box.createHorizontalStrut(20));


        //Frame

        f1.add(hb);
        doConnect();
        getComboPCode();
        f1.setBounds(0,170,1540,540);
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
            rsUser=stmSelect.executeQuery("select * from  LOG_TBLISSUEOFGOODSCUSTOMER order by IVNUM");
        } catch (SQLException se) {
            System.out.println("Unable to connect");
        }
    }
    //PCODE COMBO BOX-->
    public void getComboPCode(){
        try{
            stmComboPCode=conn.createStatement();
            rsComboPCode=stmComboPCode.executeQuery("select * from  LOG_TBLPRODUCT order by PCODE");
            str="--select--";
            comboPCode.addItem(str);
            while(rsComboPCode.next()){
                strComboPCode=rsComboPCode.getString("PCODE");
                strComboPCode=strComboPCode.trim();
                comboPCode.addItem(strComboPCode);
            }
        } catch (SQLException se){
            System.out.println("Unable to get Data"+se);
        }
    }

    public boolean IQuant(){

        try{
            strIVQuant=txtIQuant.getText();
            strIVQuant=strIVQuant.trim();
            strPCode=comboPCode.getSelectedItem().toString();
            strPCode=strPCode.trim();
            intIVQant=Integer.parseInt( strIVQuant);

            //OPSTK VALIDATION-->
            stmStockdown=conn.createStatement();
            rsStockdown=stmStockdown.executeQuery("select OPSTK from  LOG_TBLPRODUCT where PCODE='"+strPCode+"'");

            while(rsStockdown.next()){
                str1=rsStockdown.getString("OPSTK");
                i=Integer.parseInt(str1);

                if(intIVQant>i){
                    dlg.showMessageDialog(f1,"Insufficient Stock! Avalable Stock  "+i,"Message",1);
                    return false;
                }
            }
        }catch(SQLException se){
            // System.out.println("ERROR"+se);
            dlg.showMessageDialog(f1,"ERROR"+se,"Message",2);
        }
        return true;
    }

    public boolean PhoneNumberValidation( String strPhno){
        int count=0;//for counting PHNO digits;

        if (strPhno.length()<10){// PHNO can never be less then 10
            return false ;
        }
        for(i=0;i<strPhno.length();i++){

            str2= String.valueOf(strPhno.charAt(i));//character to string

            if(str2.equals("0")||str2.equals("1")||str2.equals("2")||str2.equals("3")||str2.equals("4")||str2.equals("5")|| str2.equals("6")||str2.equals("7")||str2.equals("8")||str2.equals("9")){

                count=count+1;  //PHNO digit counting
                if(count>10){  //PHNO should countain 10 digits
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }

    //ACTION LISTENER-->
    public void actionPerformed(ActionEvent ae){
        //CLEAR-->
        if (ae.getSource()==btnClear){

            txtCustomerID.setText("");
            txtCusName.setText("");
            txtLocality.setText("");
            txtCity.setText("");
            txtState.setText("");
            txtIDate.setText("");
            txtODate.setText("");

            txtSlno.setText("");
            txtPName.setText("");
            txtSize.setText("");
            txtMRP.setText("");
            txtIQuant.setText("");
            txtAmt.setText("");
            txtDisPer.setText("");
            txtDisAmt.setText("");
            txtGStper.setText("");
            txtGSTAmt.setText("");
            txtNetAmt.setText("");

        }

        //SAVE-->
        if (ae.getSource()==btnSave){
            strInvoiceNo=txtInvoiceNo.getText();
            strInvoiceNo=strInvoiceNo.trim();
            strIDate=txtIDate.getText();
            strIDate= strIDate.trim();
            strCustomerID=txtCustomerID.getText();
            strCustomerID=strCustomerID.trim();
            strODate=txtODate.getText();
            strODate= strODate.trim();
            strCusName=txtCusName.getText();
            strCusName= strCusName.trim();
            strLocality=txtLocality.getText();
            strLocality= strLocality.trim();
            strCity=txtCity.getText();
            strCity= strCity.trim();
            strState=txtState.getText();
            strState= strState.trim();
            strPType=comboPType.getSelectedItem().toString();
            strPType=strPType.trim();
            strSLNO=txtSlno.getText();
            strSLNO=strSLNO.trim();
            strPCode=comboPCode.getSelectedItem().toString();
            strPCode=strPCode.trim();
            strPName=txtPName.getText();
            strPName=strPName.trim();
            strSize=txtSize.getText();
            strSize=strSize.trim();
            strMrp=txtMRP.getText();
            strMrp=strMrp.trim();
            strIVQuant=txtIQuant.getText();
            strIVQuant=strIVQuant.trim();
            strAmt=txtAmt.getText();
            strAmt=strAmt.trim();
            strDisPer=txtDisPer.getText();
            strDisPer=strDisPer.trim();
            strDisAmt=txtDisAmt.getText();
            strDisAmt=strDisAmt.trim();
            strGSTPer=txtDisPer.getText();
            strGSTPer=strDisPer.trim();
            strGSTAmt=txtGSTAmt.getText();
            strGSTAmt=strGSTAmt.trim();
            strNetAmt=txtNetAmt.getText();
            strNetAmt=strNetAmt.trim();

            if(!PhoneNumberValidation( strCustomerID)){
                dlg.showMessageDialog(f1,"Invalid Customer ID  ","Message",2);
                return;
            }
            try{

                //SAVING-->
                stmSave= conn.createStatement();
                stmSave.executeUpdate("insert into  LOG_TBLISSUEOFGOODSCUSTOMER values ('"+strInvoiceNo+"','"+strIDate+"','"+strCustomerID+"','"+strODate+"','"+strCusName+"','"+strLocality+"','"+strCity+"','"+strState+"','"+strPType+"','"+strSLNO+"','"+strPCode+"','"+strPName+"','"+strSize+"','"+strMrp+"','"+strIVQuant+"','"+strAmt+"','"+strDisPer+"','"+strDisAmt+"','"+strGSTPer+"','"+strGSTAmt+"','"+strNetAmt+"')");
                dlg.showMessageDialog(f1,"One Record Saved","Message",1);
            }
            catch(SQLException se){
                dlg.showMessageDialog(f1,"Not Saved "+se,"Message",2);
            }
        }
        //NEXT-->
        else if (ae.getSource()==btnNext){

            try {
                if (rsUser.isLast()) {
                    dlg.showMessageDialog(f1, "Last Record ", "Message", 1);

                } else {
                    rsUser.next();
                    strInvoiceNo=rsUser.getString("IVNUM");
                    strInvoice1=strInvoiceNo;
                    strIDate=rsUser.getString("IVDATE");
                    strCustomerID=rsUser.getString("CUSID");
                    strCustomerID=strCustomerID.trim();

                    strODate=rsUser.getString("ODATE");
                    strCusName=rsUser.getString("CUSNAME");
                    strLocality=rsUser.getString("LOCALITY");
                    strCity=rsUser.getString("CITY");
                    strState=rsUser.getString("STATE");
                    strPType=rsUser.getString("PTYPE");
                    strPType=strPType.trim();
                    strSLNO=rsUser.getString("SLNO");
                    strSLNO=strSLNO.trim();
                    strPCode=rsUser.getString("PCODE");
                    strPCode=strPCode.trim();
                    strPCode1=strPCode;
                    strPName=rsUser.getString("PNAME");
                    strPName=strPName.trim();
                    strSize=rsUser.getString("PSIZE");
                    strSize=strSize.trim();
                    strMrp=rsUser.getString("MRP");
                    strIVQuant=rsUser.getString("IVQUANT");
                    intIVQant1=Integer.parseInt(strIVQuant);
                    strAmt=rsUser.getString("AMT");
                    strDisPer=rsUser.getString("DISPER");
                    strDisAmt=rsUser.getString("DISAMT");
                    strGSTPer=rsUser.getString("GSTPER");
                    strGSTAmt=rsUser.getString("GSTAMT");
                    strNetAmt=rsUser.getString("NETAMT");

                    txtInvoiceNo.setText(strInvoiceNo);
                    txtIDate.setText(strIDate);
                    txtCustomerID.setText(strCustomerID);
                    txtODate.setText(strODate);
                    txtCusName.setText(strCusName);
                    txtLocality.setText(strLocality);
                    txtCity.setText(strCity);
                    txtState.setText(strState);
                    comboPType.setSelectedItem(strPType);
                    txtSlno.setText(strSLNO);
                    comboPCode.setSelectedItem(strPCode);
                    txtPName.setText(strPName);
                    txtSize.setText(strSize);
                    txtMRP.setText(strMrp);
                    txtIQuant.setText(strIVQuant);
                    txtAmt.setText(strAmt);
                    txtDisPer.setText(strDisPer);
                    txtDisAmt.setText(strDisAmt);
                    txtGStper.setText(strGSTPer);
                    txtGSTAmt.setText(strGSTAmt);
                    txtNetAmt.setText(strNetAmt);
                }
            }
            catch(SQLException se){
                dlg.showMessageDialog(f1,"unable to go next"+se,"Message",2);
            }
        }

        else if(ae.getSource()==btnPrevious){
            try{
                if(rsUser.isFirst()){
                    dlg.showMessageDialog(f1,"First Record ","Message",1);
                }
                else{
                    rsUser.previous();
                    strInvoiceNo=rsUser.getString("IVNUM");
                    strInvoice1=strInvoiceNo;
                    strIDate=rsUser.getString("IVDATE");
                    strCustomerID=rsUser.getString("CUSID");

                    strODate=rsUser.getString("ODATE");
                    strCusName=rsUser.getString("CUSNAME");
                    strLocality=rsUser.getString("LOCALITY");
                    strCity=rsUser.getString("CITY");
                    strState=rsUser.getString("STATE");
                    strPType=rsUser.getString("PTYPE");
                    strPType=strPType.trim();
                    strSLNO=rsUser.getString("SLNO");
                    strSLNO=strSLNO.trim();
                    strPCode=rsUser.getString("PCODE");
                    strPCode=strPCode.trim();
                    strPCode1=strPCode;
                    strPName=rsUser.getString("PNAME");
                    strPName=strPName.trim();
                    strSize=rsUser.getString("PSIZE");
                    strSize=strSize.trim();
                    strMrp=rsUser.getString("MRP");
                    strIVQuant=rsUser.getString("IVQUANT");
                    intIVQant1=Integer.parseInt(strIVQuant);
                    strAmt=rsUser.getString("AMT");
                    strDisPer=rsUser.getString("DISPER");
                    strDisAmt=rsUser.getString("DISAMT");
                    strGSTPer=rsUser.getString("GSTPER");
                    strGSTAmt=rsUser.getString("GSTAMT");
                    strNetAmt=rsUser.getString("NETAMT");

                    txtInvoiceNo.setText(strInvoiceNo);
                    txtIDate.setText(strIDate);
                    txtCustomerID.setText(strCustomerID);
                    txtODate.setText(strODate);
                    txtCusName.setText(strCusName);
                    txtLocality.setText(strLocality);
                    txtCity.setText(strCity);
                    txtState.setText(strState);
                    comboPType.setSelectedItem(strPType);
                    txtSlno.setText(strSLNO);
                    comboPCode.setSelectedItem(strPCode);
                    txtPName.setText(strPName);
                    txtSize.setText(strSize);
                    txtMRP.setText(strMrp);
                    txtIQuant.setText(strIVQuant);
                    txtAmt.setText(strAmt);
                    txtDisPer.setText(strDisPer);
                    txtDisAmt.setText(strDisAmt);
                    txtGStper.setText(strGSTPer);
                    txtGSTAmt.setText(strGSTAmt);
                    txtNetAmt.setText(strNetAmt);
                }
            }
            catch(SQLException se){
                dlg.showMessageDialog(f1,"unable to go Previous "+se,"Message",2);
            }
        }

        //FIRST-->
        else if(ae.getSource()==btnFirst){
            try{
                rsUser.first();
                strInvoiceNo=rsUser.getString("IVNUM");
                strInvoice1=strInvoiceNo;
                strIDate=rsUser.getString("IVDATE");
                strCustomerID=rsUser.getString("CUSID");

                strODate=rsUser.getString("ODATE");
                strCusName=rsUser.getString("CUSNAME");
                strLocality=rsUser.getString("LOCALITY");
                strCity=rsUser.getString("CITY");
                strState=rsUser.getString("STATE");
                strPType=rsUser.getString("PTYPE");
                strPType=strPType.trim();
                strSLNO=rsUser.getString("SLNO");
                strSLNO=strSLNO.trim();
                strPCode=rsUser.getString("PCODE");
                strPCode=strPCode.trim();
                strPCode1=strPCode;
                strPName=rsUser.getString("PNAME");
                strPName=strPName.trim();
                strSize=rsUser.getString("PSIZE");
                strSize=strSize.trim();
                strMrp=rsUser.getString("MRP");
                strIVQuant=rsUser.getString("IVQUANT");
                intIVQant1=Integer.parseInt(strIVQuant);
                strAmt=rsUser.getString("AMT");
                strDisPer=rsUser.getString("DISPER");
                strDisAmt=rsUser.getString("DISAMT");
                strGSTPer=rsUser.getString("GSTPER");
                strGSTAmt=rsUser.getString("GSTAMT");
                strNetAmt=rsUser.getString("NETAMT");

                txtInvoiceNo.setText(strInvoiceNo);
                txtIDate.setText(strIDate);
                txtCustomerID.setText(strCustomerID);
                txtODate.setText(strODate);
                txtCusName.setText(strCusName);
                txtLocality.setText(strLocality);
                txtCity.setText(strCity);
                txtState.setText(strState);
                comboPType.setSelectedItem(strPType);
                txtSlno.setText(strSLNO);
                comboPCode.setSelectedItem(strPCode);
                txtPName.setText(strPName);
                txtSize.setText(strSize);
                txtMRP.setText(strMrp);
                txtIQuant.setText(strIVQuant);
                txtAmt.setText(strAmt);
                txtDisPer.setText(strDisPer);
                txtDisAmt.setText(strDisAmt);
                txtGStper.setText(strGSTPer);
                txtGSTAmt.setText(strGSTAmt);
                txtNetAmt.setText(strNetAmt);
            }
            catch(SQLException se){
                dlg.showMessageDialog(f1,"unable to go First"+se,"Message",2);
            }

        }
        //LAST-->
        else if(ae.getSource()==btnLast){

            try{
                rsUser.last();
                strInvoiceNo=rsUser.getString("IVNUM");
                strInvoice1=strInvoiceNo;
                strIDate=rsUser.getString("IVDATE");
                strCustomerID=rsUser.getString("CUSID");

                strODate=rsUser.getString("ODATE");
                strCusName=rsUser.getString("CUSNAME");
                strLocality=rsUser.getString("LOCALITY");
                strCity=rsUser.getString("CITY");
                strState=rsUser.getString("STATE");
                strPType=rsUser.getString("PTYPE");
                strPType=strPType.trim();
                strSLNO=rsUser.getString("SLNO");
                strSLNO=strSLNO.trim();
                strPCode=rsUser.getString("PCODE");
                strPCode=strPCode.trim();
                strPCode1=strPCode;
                strPName=rsUser.getString("PNAME");
                strPName=strPName.trim();
                strSize=rsUser.getString("PSIZE");
                strSize=strSize.trim();
                strMrp=rsUser.getString("MRP");
                strIVQuant=rsUser.getString("IVQUANT");
                intIVQant1=Integer.parseInt(strIVQuant);
                strAmt=rsUser.getString("AMT");
                strDisPer=rsUser.getString("DISPER");
                strDisAmt=rsUser.getString("DISAMT");
                strGSTPer=rsUser.getString("GSTPER");
                strGSTAmt=rsUser.getString("GSTAMT");
                strNetAmt=rsUser.getString("NETAMT");

                txtInvoiceNo.setText(strInvoiceNo);
                txtIDate.setText(strIDate);
                txtCustomerID.setText(strCustomerID);
                txtODate.setText(strODate);
                txtCusName.setText(strCusName);
                txtLocality.setText(strLocality);
                txtCity.setText(strCity);
                txtState.setText(strState);
                comboPType.setSelectedItem(strPType);
                txtSlno.setText(strSLNO);
                comboPCode.setSelectedItem(strPCode);
                txtPName.setText(strPName);
                txtSize.setText(strSize);
                txtMRP.setText(strMrp);
                txtIQuant.setText(strIVQuant);
                txtAmt.setText(strAmt);
                txtDisPer.setText(strDisPer);
                txtDisAmt.setText(strDisAmt);
                txtGStper.setText(strGSTPer);
                txtGSTAmt.setText(strGSTAmt);
                txtNetAmt.setText(strNetAmt);
            }
            catch(SQLException se){
                // System.out.println("Unable to go previous"+se);
                dlg.showMessageDialog(f1,"unable to go First"+se,"Message",2);
            }
        }

        else if(ae.getSource()==btnDelete){

            try{

                option=dlgCd.showConfirmDialog(f1,"Sure to Delete","Alert",2);

                if(option==0){
                    //RECORD DELETE-->
                    stmDelete=conn.createStatement();
                    stmDelete.executeUpdate("delete from   LOG_TBLISSUEOFGOODSCUSTOMER where IVNUM='"+strInvoice1+"'and PCODE='"+strPCode1+"'");
                    dlg.showMessageDialog(f1,"Record Deleted  ","Message",1);
                }
            }
            catch(SQLException se){
                dlg.showMessageDialog(f1,"unable to go Delete"+se,"Message",2);
            }
        }

        //SELECT-->
        else if(ae.getSource()==btnSelect){
            strSearching= dlg.showInputDialog(f1,"Enter Issue Number","Searching ",3);
            strPCode2= dlg.showInputDialog(f1,"Enter Product Code ","Searching ",3);

            try{
                stmSearching=conn.createStatement();
                rsSearching=stmSearching.executeQuery("select * from  LOG_TBLISSUEOFGOODSCUSTOMER where IVNUM='"+strSearching+"' and  PCODE='"+strPCode2+"'"  );

                if(rsSearching.next()){

                    strInvoiceNo=rsSearching.getString("IVNUM");
                    strInvoice1=strInvoiceNo;
                    strInvoice1=strInvoice1.trim();
                    strIDate=rsSearching.getString("IVDATE");
                    strCustomerID=rsSearching.getString("CUSID");
                    strODate=rsSearching.getString("ODATE");
                    strCusName=rsSearching.getString("CUSNAME");
                    strLocality=rsSearching.getString("LOCALITY");
                    strCity=rsSearching.getString("CITY");
                    strState=rsSearching.getString("STATE");
                    strPType=rsSearching.getString("PTYPE");
                    strSLNO=rsSearching.getString("SLNO");
                    strPCode=rsSearching.getString("PCODE");
                    strPCode1=strPCode;
                    strPCode1=strPCode1.trim();
                    strPName=rsSearching.getString("PNAME");
                    strSize=rsSearching.getString("PSIZE");
                    strMrp=rsSearching.getString("MRP");
                    strIVQuant=rsSearching.getString("IVQUANT");
                    intIVQant1=Integer.parseInt(strIVQuant);
                    strAmt=rsSearching.getString("AMT");
                    strDisPer=rsSearching.getString("DISPER");
                    strDisAmt=rsSearching.getString("DISAMT");
                    strGSTPer=rsSearching.getString("GSTPER");
                    strGSTAmt=rsSearching.getString("GSTAMT");
                    strNetAmt=rsSearching.getString("NETAMT");

                    txtInvoiceNo.setText(strInvoiceNo);
                    txtODate.setText(strODate);
                    strCustomerID=strCustomerID.trim();
                    txtCustomerID.setText(strCustomerID);
                    txtODate.setText(strODate);
                    txtCusName.setText(strCusName);
                    txtLocality.setText(strLocality);
                    txtCity.setText(strCity);
                    txtState.setText(strState);
                    strPType=strPType.trim();
                    comboPType.setSelectedItem(strPType);
                    strSLNO=strSLNO.trim();
                    txtSlno.setText(strSLNO);
                    strPCode=strPCode.trim();
                    comboPCode.setSelectedItem(strPCode);
                    strPName=strPName.trim();
                    txtPName.setText(strPName);
                    strSize=strSize.trim();
                    txtSize.setText(strSize);
                    txtMRP.setText(strMrp);
                    txtIQuant.setText(strIVQuant);
                    txtAmt.setText(strAmt);
                    txtDisPer.setText(strDisPer);
                    txtDisAmt.setText(strDisAmt);
                    txtGStper.setText(strGSTPer);
                    txtGSTAmt.setText(strGSTAmt);
                    txtNetAmt.setText(strNetAmt);
                }
                else{
                    dlg.showMessageDialog(f1,"Record Not Found","Message",2);
                }
            }
            catch(SQLException se){
                dlg.showMessageDialog(f1,"ERROR"+se,"Message",2);
            }
        }

        //UPDATE-->
        else if (ae.getSource()==btnUpdate){
            strInvoiceNo=txtInvoiceNo.getText();
            strInvoiceNo=strInvoiceNo.trim();
            strIDate=txtIDate.getText();
            strIDate= strIDate.trim();
            strCustomerID=txtCustomerID.getText();
            strCustomerID=strCustomerID.trim();
            strODate=txtODate.getText();
            strODate= strODate.trim();
            strCusName=txtCusName.getText();
            strCusName= strCusName.trim();
            strLocality=txtLocality.getText();
            strLocality= strLocality.trim();
            strCity=txtCity.getText();
            strCity= strCity.trim();
            strState=txtState.getText();
            strState= strState.trim();
            strPType=comboPType.getSelectedItem().toString();
            strPType=strPType.trim();
            strSLNO=txtSlno.getText();
            strSLNO=strSLNO.trim();
            strPCode=comboPCode.getSelectedItem().toString();
            strPCode=strPCode.trim();
            strPName=txtPName.getText();
            strPName=strPName.trim();
            strSize=txtSize.getText();
            strSize=strSize.trim();
            strMrp=txtMRP.getText();
            strMrp=strMrp.trim();
            strIVQuant=txtIQuant.getText();
            intIVQant=Integer.parseInt(strIVQuant);
            strIVQuant=strIVQuant.trim();
            strAmt=txtAmt.getText();
            strAmt=strAmt.trim();
            strDisPer=txtDisPer.getText();
            strDisPer=strDisPer.trim();
            strDisAmt=txtDisAmt.getText();
            strDisAmt=strDisAmt.trim();
            strGSTPer=txtDisPer.getText();
            strGSTPer=strDisPer.trim();
            strGSTAmt=txtGSTAmt.getText();
            strGSTAmt=strGSTAmt.trim();
            strNetAmt=txtNetAmt.getText();
            strNetAmt=strNetAmt.trim();

            try {
                strInvoice1=strInvoice1.trim();
                stmUpdate = conn.createStatement();
                option=dlgCd.showConfirmDialog(f1,"Sure to Update","Alert",2);
                if(option==0){
                    if(!strInvoiceNo.equals(strInvoice1)){
                        dlg.showMessageDialog(f1," Can't change INVOICE CODE ","Updating",1);
                        return ;
                    }

                    stmUpdate.executeUpdate("update  LOG_TBLISSUEOFGOODSCUSTOMER set IVDATE ='"+strIDate+"', CUSID='"+strCustomerID+"',LOCALITY='"+strLocality+"', CITY='"+strCity+"', STATE='"+strState+"',PTYPE='"+strPType+"',SLNO='"+strSLNO+"',PCODE='"+strPCode+"',PNAME='"+strPName+"',PSIZE='"+strSize+"',MRP='"+strMrp+"',IVQUANT='"+strIVQuant+"',AMT='"+strAmt+"',DISPER='"+strDisPer+"',DISAMT='"+strDisAmt+"',GSTPER='"+strGSTPer+"',GSTAMT='"+strGSTAmt+"',NETAMT='"+strNetAmt+"' where IVNUM = '"+strInvoice1+"'");
                    dlg.showMessageDialog(f1,"Record Updated  ","Updating",1);

                }
            }
            catch(SQLException  se){
                // System.out.println("Unable to go Update"+se);
                dlg.showMessageDialog(f1,"ERROR "+se,"Message",2);
            }
        }

        else if (ae.getSource()==comboPCode){
            str=comboPCode.getSelectedItem().toString();
            try{
                stmCombo=conn.createStatement();
                rsCombo= stmCombo.executeQuery("Select * from LOG_TBLPRODUCT where PCODE='" + str + "'");
                if(rsCombo.next()){
                    str1=rsCombo.getString("PNAME");
                    str1=str1.trim();
                    txtPName.setText(str1);
                    txtPName.setEditable(false);
                    str2=rsCombo.getString("PSIZE");
                    str2=str2.trim();
                    txtSize.setText(str2);
                    txtSize.setEditable(false);
                    str3=rsCombo.getString("MRP");
                    str3=str3.trim();
                    txtMRP.setText(str3);
                    //txtMRP.setEditable(false);
                    str2=rsCombo.getString("GSTSLAP");
                    str2=str2.trim();
                    txtGStper.setText(str2);
                    //txtGStper.setEditable(false);
                }
            }catch(SQLException se){
                // System.out.println("ERROR"+se);
                dlg.showMessageDialog(f1,"ERROR"+se,"Message",2);
            }
        }

        else if(ae.getSource()==txtIQuant){

            if(IQuant()) {
                price = Float.parseFloat(txtMRP.getText());
                quant = Float.parseFloat(txtIQuant.getText());
                amt = price * quant;
                str = String.valueOf(amt);
                txtAmt.setText(str);
                txtDisPer.requestFocus(true);
            }
        }

        else if(ae.getSource()==txtDisPer){
            str=txtDisPer.getText();
            if(!str.isEmpty()){
                percent=Float.parseFloat(txtDisPer.getText());
                amt=Float.parseFloat(txtAmt.getText());
            }
            else{
                percent=0.0F;
                str="0.0";
                txtDisPer.setText(str);
                amt=Float.parseFloat(txtAmt.getText());
            }
            percent=(percent*amt)/100;
            taxable=amt-percent;
            taxable=(taxable*18)/100;
            total=(amt-percent)+taxable;
            str=String.valueOf(percent);
            txtDisAmt.setText(str);

            str1=String.valueOf(taxable);
            txtGSTAmt.setText(str1);

            str1=String.valueOf(total);
            txtNetAmt.setText(str1);
        }

        else if (ae.getSource()==btnClose){
            option=dlgCd.showConfirmDialog(f1,"Sure to end","Alert",2);
            if(option==0){
                f1.setVisible(false);
                f1.dispose();
            }
        }
    }
}

class log_IssueOfGoodsCustomerApp{
    public static void main(String []args){
        IssueOfGoodsCustomerWin obj;
        obj= new  IssueOfGoodsCustomerWin();
    }
}

/*
create table LOG_TBLISSUEOFGOODSCUSTOMER(IVNUM char(20),IVDATE char(20),CUSID char(20),ODATE char(20),CUSNAME char(20),LOCALITY char(20),CITY char(20),STATE char(20),PTYPE char(20),SLNO char(20),PCODE char(20),PNAME char(20),PSIZE char(20),MRP number(7,2),,IVQUANT number(7,2),,AMT number(7,2),,DISPER number(7,2),,DISAMT number(7,2),,GSTPER number(7,2),GSTAMT number(7,2),NETAMT number(7,2));
 */