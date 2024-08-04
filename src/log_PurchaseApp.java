
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.*;

class PurchaseWin implements ActionListener{
    JFrame f1;
    FlowLayout flw,flw1;
    JPanel p1,p2,p3,p4;
    GridLayout gl64,gl212;
    Box vb,hb;

    Font fnt1,fnt2,fnt3;
    Color clrAll,clrfont,clrWhite,clrText;
    Border bl;

    JLabel lblHeader,lblPurchaseNo,lblOrderNo,lblCName,lblLocality,lblCity,lblState,lblPDate,lblODate,lblPType,lblSlno,lblPCode,lblPName,lblSize,lblPrice,lblPQuant,lblAmt,lblDisPer,lblDisAmt,lblGSTper,lblGSTAmt,lblNetAmt,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8;


    JTextField txtPurchaseNo,txtCName,txtLocality,txtCity,txtState,txtPDate,txtODate,txtSlno,txtPName,txtSize,txtPrice,txtPQuant,txtAmt,txtDisPer,txtDisAmt,txtGStper,txtGSTAmt,txtNetAmt;

    JComboBox comboORDNO,comboPCode,comboPType;
    String Payment[]={"--Select--","Cradit","Cash"};

    ImageIcon imgClear,imgSave,imgNext,imgPrevious,imgDelete,imgUpdate,imgClose,imgSelect,imgFirst,imgLast;

    JButton btnClear,btnSave,btnNext,btnPrevious,btnDelete,btnUpdate,btnClose,btnSelect,btnFirst,btnLast;
    //Dialogs
    JOptionPane dlg,dlgIn,dlgCd;
    int option=1, i=1;
    float quant,amt,price,percent,taxable,total;

    Connection conn;
    Statement stmSelect,stmComboORDNO,stmComboPCode,stmCombo,stmSave,stmDelete,stmSearching,stmUpdate,stmStockUP,stmStockNew;
    ResultSet rsUser,rsComboORDNO,rsComboPCode,rsCombo,rsSearching,rsStockUP;
    String str,str1,str2,str3,strComboORDNO,strComboPCode,strPurchaseNo,strORDNO,strCName,strPType,strLocality,strCity,strState,strPDate,strODate,strSLNO,strPCode,strPName,strSize,strPrice,strPQuant,strAmt,strSearching,strDisPer,strDisAmt,strGSTPer,strGSTAmt,strNetAmt,strPur1,strPCode1,strPCode2,strORDNO1;
    int intPQant,intPQant1;


    public PurchaseWin(){
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

        lblHeader=new JLabel("Purchese Of Goods");
        lblHeader.setFont(fnt1);
        lblHeader.setForeground(clrfont);
        lblPurchaseNo=new JLabel(" Purchase Number ");
        lblPurchaseNo.setFont(fnt3);
        lblOrderNo=new JLabel(" Order Number");
        lblOrderNo.setFont(fnt3);
        lblCName=new JLabel(" Company Name");
        lblCName.setFont(fnt3);
        lblLocality=new JLabel(" Locality");
        lblLocality.setFont(fnt3);
        lblCity=new JLabel(" City");
        lblCity.setFont(fnt3);
        lblState=new JLabel(" State");
        lblState.setFont(fnt3);
        lblPDate=new JLabel("                                                        Purchase Date");
        lblPDate.setFont(fnt3);
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
        lblPrice=new JLabel(" Price");
        lblPrice.setFont(fnt2);
        lblPQuant=new JLabel(" Purchase Quantity");
        lblPQuant.setFont(fnt2);
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

        comboORDNO=new JComboBox();
        comboORDNO.setBackground(clrText);
        comboPCode=new JComboBox();
        comboPCode.setBackground(clrText);
        comboPType=new JComboBox(Payment);
        comboPType.setBackground(clrText);

        txtPurchaseNo= new JTextField(20);
        txtPurchaseNo.setBackground(clrText);
        txtPurchaseNo.setFont(fnt3);
        txtCName= new JTextField(20);
        txtCName.setBackground(clrText);
        txtCName.setFont(fnt3);
        txtLocality= new JTextField(20);
        txtLocality.setBackground(clrText);
        txtLocality.setFont(fnt3);
        txtCity= new JTextField(20);
        txtCity.setBackground(clrText);
        txtCity.setFont(fnt3);
        txtState= new JTextField(20);
        txtState.setBackground(clrText);
        txtState.setFont(fnt3);
        txtPDate= new JTextField(20);
        txtPDate.setBackground(clrText);
        txtPDate.setFont(fnt3);
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
        txtPrice= new JTextField(20);
        txtPrice.setBackground(clrText);
        txtPrice.setFont(fnt2);
        txtPQuant= new JTextField(20);
        txtPQuant.setBackground(clrText);
        txtPQuant.setFont(fnt2);
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

        //Button ActionListener
        txtDisPer.addActionListener(this);
        txtPQuant.addActionListener(this);
        comboORDNO.addActionListener(this);
        comboPCode.addActionListener(this);
        txtPQuant.addActionListener(this);
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

        p2.add(lblPurchaseNo);
        p2.add(txtPurchaseNo);
        p2.add(lblPDate);
        p2.add(txtPDate);

        p2.add(lblOrderNo);
        p2.add(comboORDNO);
        p2.add(lblODate);
        p2.add(txtODate);

        p2.add(lblCName);
        p2.add(txtCName);
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
        p3.add(lblPrice);
        p3.add(lblPQuant);
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
        p3.add(txtPrice);
        p3.add(txtPQuant);
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
        f1.setBounds(0,170,1540,540);
        f1.setResizable(false);
        doConnect();
        getComboPCode();
        getComboORDNO();
        f1.setVisible(true);

    }//end Constructor
    //DATABASE CONNECTION -->
    public void doConnect() {
        try {//step2
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Unable to Load Connection");
        }
        try {//step3
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
            stmSelect=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rsUser=stmSelect.executeQuery("select * from  LOG_TBLPURCHASE order by PURNAME");
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
            System.out.println("Unable to get Data");
        }
    }
    //ORDER NUMBER COMBO-->
    public void getComboORDNO(){
        try{
            stmComboORDNO=conn.createStatement();
            rsComboORDNO=stmComboORDNO.executeQuery("select * from  LOG_TBLORDERTO order by ORDERNO");
            str="--select--";
            comboORDNO.addItem(str);
            while(rsComboORDNO.next()){
                strComboORDNO=rsComboORDNO.getString("ORDERNO");
                strComboORDNO=strComboORDNO.trim();
                comboORDNO.addItem(strComboORDNO);
            }}catch (SQLException se){
            System.out.println("Unable to get Data");
        }
    }

    //ACTION LISTENER-->
    public void actionPerformed(ActionEvent ae){
        //CLEAR-->
        if (ae.getSource()==btnClear){
            i=0;
            txtSlno.setText("");
            // txtPurchaseNo.setText("");
            //comboORDNO.setSelectedIndex(i);
            //txtCName.setText("");
            // txtLocality.setText("");
            // txtCity.setText("");
            // txtState.setText("");
            txtPDate.setText("");
            txtODate.setText("");
            comboPType.setSelectedIndex(i);
            txtSlno.setText("");
            comboPCode.setSelectedIndex(i);
            txtPName.setText("");
            txtSize.setText("");
            txtPrice.setText("");
            txtPQuant.setText("");
            txtAmt.setText("");
            txtDisPer.setText("");
            txtDisAmt.setText("");
            txtGStper.setText("");
            txtGSTAmt.setText("");
            txtNetAmt.setText("");
            i=1;//for not saving same record again and again
        }
        //SAVE-->
        if (ae.getSource()==btnSave){
            strPurchaseNo=txtPurchaseNo.getText();
            strPurchaseNo=strPurchaseNo.trim();
            strPDate=txtPDate.getText();
            strPDate= strPDate.trim();
            strORDNO=comboORDNO.getSelectedItem().toString();
            strORDNO=strORDNO.trim();
            strODate=txtODate.getText();
            strODate= strODate.trim();
            strCName=txtCName.getText();
            strCName= strCName.trim();
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
            strPrice=txtPrice.getText();
            strPrice=strPrice.trim();
            strPQuant=txtPQuant.getText();
            strPQuant=strPQuant.trim();
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


            try{
                if(i==1){
                    stmSave= conn.createStatement();
                    stmSave.executeUpdate("insert into LOG_TBLPURCHASE  values ('"+strPurchaseNo+"','"+strPDate+"','"+strORDNO+"','"+strODate+"','"+strCName+"','"+strLocality+"','"+strCity+"','"+strState+"','"+strPType+"','"+strSLNO+"','"+strPCode+"','"+strPName+"','"+strSize+"','"+strPrice+"','"+strPQuant+"','"+strAmt+"','"+strDisPer+"','"+strDisAmt+"','"+strGSTPer+"','"+strGSTAmt+"','"+strNetAmt+"')");
                    //UPDATTING STOCK IN PRODUCT TABLE-->
                    intPQant=Integer.parseInt(strPQuant);
                    stmStockUP=conn.createStatement();
                    stmStockUP.executeUpdate("update LOG_TBLPRODUCT set OPSTK=OPSTK+'"+intPQant+"' where PCODE='"+strPCode+"'");
                    dlg.showMessageDialog(f1,"One Record Saved","Message",1);
                    i++;//For not saving same record again and again
                }
                else{
                    dlg.showMessageDialog(f1,"This Record already Saved","Message",1);
                    return;
                }
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
                    strPurchaseNo=rsUser.getString("PURNAME");
                    strPur1=strPurchaseNo;
                    strPDate=rsUser.getString("PDATE");
                    strORDNO=rsUser.getString("ORDNO");
                    strORDNO=strORDNO.trim();
                    strORDNO1=strORDNO;
                    strODate=rsUser.getString("ODATE");
                    strCName=rsUser.getString("CNAME");
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
                    strPrice=rsUser.getString("PRICE");
                    strPQuant=rsUser.getString("PERQUANT");
                    intPQant1=Integer.parseInt(strPQuant);
                    strAmt=rsUser.getString("AMT");
                    strDisPer=rsUser.getString("DISPER");
                    strDisAmt=rsUser.getString("DISAMT");
                    strGSTPer=rsUser.getString("GSTPER");
                    strGSTAmt=rsUser.getString("GSTAMT");
                    strNetAmt=rsUser.getString("NETAMT");

                    txtPurchaseNo.setText(strPurchaseNo);
                    txtPDate.setText(strPDate);
                    comboORDNO.setSelectedItem(strORDNO);
                    txtODate.setText(strODate);
                    txtCName.setText(strCName);
                    txtLocality.setText(strLocality);
                    txtCity.setText(strCity);
                    txtState.setText(strState);
                    comboPType.setSelectedItem(strPType);
                    txtSlno.setText(strSLNO);
                    comboPCode.setSelectedItem(strPCode);
                    txtPName.setText(strPName);
                    txtSize.setText(strSize);
                    txtPrice.setText(strPrice);
                    txtPQuant.setText(strPQuant);
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
        //PREVIOUS-->
        else if(ae.getSource()==btnPrevious){
            try{
                if(rsUser.isFirst()){
                    dlg.showMessageDialog(f1,"First Record ","Message",1);
                }
                else{
                    rsUser.previous();
                    strPurchaseNo=rsUser.getString("PURNAME");
                    strPur1=strPurchaseNo;
                    strPDate=rsUser.getString("PDATE");
                    strORDNO=rsUser.getString("ORDNO");
                    strORDNO=strORDNO.trim();
                    strORDNO1=strORDNO;
                    strODate=rsUser.getString("ODATE");
                    strCName=rsUser.getString("CNAME");
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
                    strPrice=rsUser.getString("PRICE");
                    strPQuant=rsUser.getString("PERQUANT");
                    intPQant1=Integer.parseInt(strPQuant);
                    strAmt=rsUser.getString("AMT");
                    strDisPer=rsUser.getString("DISPER");
                    strDisAmt=rsUser.getString("DISAMT");
                    strGSTPer=rsUser.getString("GSTPER");
                    strGSTAmt=rsUser.getString("GSTAMT");
                    strNetAmt=rsUser.getString("NETAMT");

                    txtPurchaseNo.setText(strPurchaseNo);
                    txtPDate.setText(strPDate);
                    comboORDNO.setSelectedItem(strORDNO);
                    txtODate.setText(strODate);
                    txtCName.setText(strCName);
                    txtLocality.setText(strLocality);
                    txtCity.setText(strCity);
                    txtState.setText(strState);
                    comboPType.setSelectedItem(strPType);
                    txtSlno.setText(strSLNO);
                    comboPCode.setSelectedItem(strPCode);
                    txtPName.setText(strPName);
                    txtSize.setText(strSize);
                    txtPrice.setText(strPrice);
                    txtPQuant.setText(strPQuant);
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
                strPurchaseNo=rsUser.getString("PURNAME");
                strPur1=strPurchaseNo;
                strPDate=rsUser.getString("PDATE");
                strORDNO=rsUser.getString("ORDNO");
                strORDNO=strORDNO.trim();
                strORDNO1=strORDNO;
                strODate=rsUser.getString("ODATE");
                strCName=rsUser.getString("CNAME");
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
                strPrice=rsUser.getString("PRICE");
                strPQuant=rsUser.getString("PERQUANT");
                intPQant1=Integer.parseInt(strPQuant);
                strAmt=rsUser.getString("AMT");
                strDisPer=rsUser.getString("DISPER");
                strDisAmt=rsUser.getString("DISAMT");
                strGSTPer=rsUser.getString("GSTPER");
                strGSTAmt=rsUser.getString("GSTAMT");
                strNetAmt=rsUser.getString("NETAMT");

                txtPurchaseNo.setText(strPurchaseNo);
                txtPDate.setText(strPDate);
                comboORDNO.setSelectedItem(strORDNO);
                txtODate.setText(strODate);
                txtCName.setText(strCName);
                txtLocality.setText(strLocality);
                txtCity.setText(strCity);
                txtState.setText(strState);
                comboPType.setSelectedItem(strPType);
                txtSlno.setText(strSLNO);
                comboPCode.setSelectedItem(strPCode);
                txtPName.setText(strPName);
                txtSize.setText(strSize);
                txtPrice.setText(strPrice);
                txtPQuant.setText(strPQuant);
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
                strPurchaseNo=rsUser.getString("PURNAME");
                strPur1=strPurchaseNo;
                strPDate=rsUser.getString("PDATE");
                strORDNO=rsUser.getString("ORDNO");
                strORDNO=strORDNO.trim();
                strORDNO1=strORDNO;
                strODate=rsUser.getString("ODATE");
                strCName=rsUser.getString("CNAME");
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
                strPrice=rsUser.getString("PRICE");
                strPQuant=rsUser.getString("PERQUANT");
                intPQant1=Integer.parseInt(strPQuant);
                strAmt=rsUser.getString("AMT");
                strDisPer=rsUser.getString("DISPER");
                strDisAmt=rsUser.getString("DISAMT");
                strGSTPer=rsUser.getString("GSTPER");
                strGSTAmt=rsUser.getString("GSTAMT");
                strNetAmt=rsUser.getString("NETAMT");

                txtPurchaseNo.setText(strPurchaseNo);
                txtPDate.setText(strPDate);
                comboORDNO.setSelectedItem(strORDNO);
                txtODate.setText(strODate);
                txtCName.setText(strCName);
                txtLocality.setText(strLocality);
                txtCity.setText(strCity);
                txtState.setText(strState);
                comboPType.setSelectedItem(strPType);
                txtSlno.setText(strSLNO);
                comboPCode.setSelectedItem(strPCode);
                txtPName.setText(strPName);
                txtSize.setText(strSize);
                txtPrice.setText(strPrice);
                txtPQuant.setText(strPQuant);
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
        //DELETE-->
        else if(ae.getSource()==btnDelete){
            strPQuant=txtPQuant.getText();
            strPQuant=strPQuant.trim();


            try{

                option=dlgCd.showConfirmDialog(f1,"Sure to Delete","Alert",2);

                intPQant=Integer.parseInt(strPQuant);
                stmStockUP=conn.createStatement();
                stmStockUP.executeUpdate("update LOG_TBLPRODUCT set OPSTK=OPSTK-'"+intPQant+"' where PCODE='"+strPCode1+"'");

                if(option==0){
                    stmDelete=conn.createStatement();
                    stmDelete.executeUpdate("delete from LOG_TBLPURCHASE where PURNAME='"+strPur1+"'and PCODE='"+strPCode1+"'");
                    dlg.showMessageDialog(f1,"Record Deleted  ","Message",1);
                }
            }
            catch(SQLException se){
                dlg.showMessageDialog(f1,"unable to go Delete"+se,"Message",2);
            }
        }
        //SELECT-->
        else if(ae.getSource()==btnSelect){
            strSearching= dlg.showInputDialog(f1,"Enter Purchase Number","Searching ",3);
            strPCode2= dlg.showInputDialog(f1,"Enter Product Code ","Searching ",3);

            try{
                stmSearching=conn.createStatement();
                rsSearching=stmSearching.executeQuery("select * from LOG_TBLPURCHASE where PURNAME='"+strSearching+"' and  PCODE='"+strPCode2+"'"  );

                if(rsSearching.next()){

                    strPurchaseNo=rsSearching.getString("PURNAME");
                    // System.out.println(strPurchaseNo);
                    strPur1=strPurchaseNo;
                    strPur1=strPur1.trim();
                    strPDate=rsSearching.getString("PDATE");
                    strORDNO=rsSearching.getString("ORDNO");
                    strODate=rsSearching.getString("ODATE");
                    strCName=rsSearching.getString("CNAME");
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
                    strPrice=rsSearching.getString("PRICE");
                    strPQuant=rsSearching.getString("PERQUANT");
                    intPQant1=Integer.parseInt(strPQuant);
                    strAmt=rsSearching.getString("AMT");
                    strDisPer=rsSearching.getString("DISPER");
                    strDisAmt=rsSearching.getString("DISAMT");
                    strGSTPer=rsSearching.getString("GSTPER");
                    strGSTAmt=rsSearching.getString("GSTAMT");
                    strNetAmt=rsSearching.getString("NETAMT");

                    txtPurchaseNo.setText(strPurchaseNo);
                    txtPDate.setText(strPDate);
                    strORDNO=strORDNO.trim();
                    comboORDNO.setSelectedItem(strORDNO);
                    txtODate.setText(strODate);
                    txtCName.setText(strCName);
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
                    txtPrice.setText(strPrice);
                    txtPQuant.setText(strPQuant);
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
            strPurchaseNo=txtPurchaseNo.getText();
            strPurchaseNo=strPurchaseNo.trim();
            strPDate=txtPDate.getText();
            strPDate= strPDate.trim();
            strORDNO=comboORDNO.getSelectedItem().toString();
            strORDNO=strORDNO.trim();
            strODate=txtODate.getText();
            strODate= strODate.trim();
            strCName=txtCName.getText();
            strCName= strCName.trim();
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
            strPrice=txtPrice.getText();
            strPrice=strPrice.trim();
            strPQuant=txtPQuant.getText();
            intPQant=Integer.parseInt(strPQuant);
            strPQuant=strPQuant.trim();
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
                strPur1=strPur1.trim();
                stmUpdate = conn.createStatement();
                option=dlgCd.showConfirmDialog(f1,"Sure to Update","Alert",2);
                if(option==0){
                    if(!strPurchaseNo.equals(strPur1)){
                        dlg.showMessageDialog(f1," Can't change Purchase Code ","Updating",1);
                        return ;
                    }if (intPQant1!=intPQant) {
                        stmStockUP=conn.createStatement();
                        stmStockUP.executeUpdate("update LOG_TBLPRODUCT set OPSTK=OPSTK-'"+intPQant1+"'  where PCODE='"+strPCode1+"'");
                        stmStockUP.executeUpdate("update LOG_TBLPRODUCT set OPSTK=OPSTK+'"+intPQant+"'  where  PCODE='"+strPCode1+"'");

                    }


                    stmUpdate.executeUpdate("update LOG_TBLPURCHASE set PDATE ='"+strPDate+"', ORDNO='"+strORDNO+"',LOCALITY='"+strLocality+"', CITY='"+strCity+"', STATE='"+strState+"',PTYPE='"+strPType+"',SLNO='"+strSLNO+"',PCODE='"+strPCode+"',PNAME='"+strPName+"',PSIZE='"+strSize+"',PRICE='"+strPrice+"',PERQUANT='"+strPQuant+"',AMT='"+strAmt+"',DISPER='"+strDisPer+"',DISAMT='"+strDisAmt+"',GSTPER='"+strGSTPer+"',GSTAMT='"+strGSTAmt+"',NETAMT='"+strNetAmt+"' where PURNAME = '"+strPur1+"'");
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
                    str2=rsCombo.getString("PSIZE");
                    str2=str2.trim();
                    txtSize.setText(str2);
                    str3=rsCombo.getString("PPRICE");
                    str3=str3.trim();
                    txtPrice.setText(str3);
                    str2=rsCombo.getString("GSTSLAP");
                    str2=str2.trim();
                    txtGStper.setText(str2);
                }
            }catch(SQLException se){
                // System.out.println("ERROR"+se);
                dlg.showMessageDialog(f1,"ERROR"+se,"Message",2);
            }
        }else if (ae.getSource()==comboORDNO){
            str=comboORDNO.getSelectedItem().toString();
            try{
                stmCombo=conn.createStatement();
                rsCombo= stmCombo.executeQuery("Select * from LOG_TBLORDERTO where ORDERNO='" + str + "'");
                if(rsCombo.next()){
                    str1=rsCombo.getString("CNAME");
                    str1=str1.trim();
                    txtCName.setText(str1);
                    str2=rsCombo.getString("LOCALITY");
                    str2=str2.trim();
                    txtLocality.setText(str2);
                    str3=rsCombo.getString("CITY");
                    str3=str3.trim();
                    txtCity.setText(str3);
                    str3=rsCombo.getString("STATE");
                    str3=str3.trim();
                    txtState.setText(str3);
                }
            }catch(SQLException se){
                // System.out.println("ERROR"+se);
                dlg.showMessageDialog(f1,"ERROR"+se,"Message",2);
            }
        }
        else if (ae.getSource()==btnClose){
            option=dlgCd.showConfirmDialog(f1,"Sure to end","Alert",2);
            if(option==0){
                f1.setVisible(false);
                f1.dispose();
            }

        }else if(ae.getSource()==txtPQuant){
            price=Float.parseFloat(txtPrice.getText());
            quant=Float.parseFloat(txtPQuant.getText());
            amt=price*quant;
            str=String.valueOf(amt);
            txtAmt.setText(str);
            txtDisPer.requestFocus(true);
        }
        else if(ae.getSource()==txtDisPer){
            percent=Float.parseFloat(txtDisPer.getText());
            amt=Float.parseFloat(txtAmt.getText());

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
    }

}



//Main Method
class log_PurchaseApp{
    public static void main(String []args){
        PurchaseWin obj;
        obj= new  PurchaseWin();
    }
}

