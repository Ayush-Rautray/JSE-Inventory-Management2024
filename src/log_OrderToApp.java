import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.*;


class OrderToWin implements ActionListener {
    //FRAME PANEL LAYOUT_MANAGER
    JFrame f1;
    FlowLayout flw,flw1;
    JPanel p1,p2,p3,p4;
    GridLayout gl54,gl27;

    //COLOUR AND FONT AND BORDER
    Font fnt1,fnt2;
    Color clrAll,clrfont,clrWhite,clrText;
    Border bl;

    //LABLES DECLARATIONS
    JLabel lblHeader,lblOrderNo,lblCName,lblLocality,lblCity,lblStateTerri,lblDate,lblSLNo,lblPCode,lblPName,lblSize,lblPrice,lblOrQ,lblAmt,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10;

    //TEXTFIELD DECLARATIONS
    JTextField txtOrderNo,txtCName,txtLocality,txtCity,txtStateTeri,txtDate,txtSLNo,txtPName,txtSize,txtPrice,txtOrQ,txtAmt;

    //COMBOBOX DECLARATIONS
    JComboBox comboCName,comboPCode;

    //IMAGE_ICONS DECLARATIONS
    ImageIcon imgClear,imgSave,imgNext,imgPrevious,imgDelete,imgUpdate,imgClose,imgSelect,imgFirst,imgLast;

    //BUTTONS DECLARATIONS
    JButton btnClear,btnSave,btnNext,btnPrevious,btnDelete,btnUpdate,btnClose,btnSelect,btnFirst,btnLast;

    //Dialogs
    JOptionPane dlg,dlgIn,dlgCd;
    int amt,option=1,price,quant;

    //Box Vertical horizontal
    Box vb,hb;
    Connection conn;
    Statement stmSelect,stmComboCName,stmComboPCode,stmCombo,stmSave,stmDelete,stmSearching,stmUpdate;
    ResultSet rsUser,rsComboCName,rsComboPCode,rsCombo,rsSearching;
    String strComboCName,strComboPCode,str,str1,str2,str3,strCName,strCName1,strOrNo,strOrNo1,strLocality,strCity,strStateTerri,strDate,strSLNO,strSLNO1,strPCode,strPCode1,strPCode2,strPName,strSize,strPrice,strOq,strAmt,strSearching;
    int i;


    public OrderToWin(){

        ////FRAME PANEL LAYOUT_MANAGER
        f1=new JFrame("Logistic Solution");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flw= new FlowLayout();
        flw1=new FlowLayout();
        p1= new JPanel();
        p2= new JPanel();
        p3= new JPanel();
        p4= new JPanel();
        gl27=new GridLayout(2,7);
        gl54=new GridLayout(5,4);
        vb=Box.createVerticalBox();
        hb=Box.createHorizontalBox();

        //COLOUR AND FONT AND BORDER
        fnt1=new Font("Castellar",Font.BOLD,30);
        fnt2=new Font("Bahnschrift SemiLight",Font.BOLD,15);
        clrAll=new Color (157, 174, 204);
        clrfont=new Color(87, 111, 153);
        clrWhite=new Color(255,255,255);
        clrText=new Color(245, 243, 242);
        bl=BorderFactory.createLineBorder(Color.red);

        //Lables
        lblHeader= new JLabel ("ORDER TO COMPANY");
        lblHeader.setFont(fnt1);
        lblHeader.setForeground(clrfont);
        lblOrderNo=new JLabel ("Order Number: ");
        lblOrderNo.setFont(fnt2);
        lblCName=new JLabel("Company Name:");
        lblCName.setFont(fnt2);
        lblLocality=new JLabel("Locality:");
        lblLocality.setFont(fnt2);
        lblCity=new JLabel("City:");
        lblCity.setFont(fnt2);
        lblStateTerri=new JLabel("State/Territory:");
        lblStateTerri.setFont(fnt2);
        lblDate=new JLabel("                                    Order date:");
        lblDate.setFont(fnt2);
        lblSLNo=new JLabel("  SlNo:");
        lblSLNo.setFont(fnt2);
        lblPCode=new JLabel("  Product Code:");
        lblPCode.setFont(fnt2);
        lblPName=new JLabel ("  Product Name:");
        lblPName.setFont(fnt2);
        lblSize=new JLabel ("  Size:");
        lblSize.setFont(fnt2);
        lblPrice=new JLabel("  Price:");
        lblPrice.setFont(fnt2);
        lblOrQ= new JLabel("  Order Quantity:" );
        lblOrQ.setFont(fnt2);
        lblAmt=new JLabel("  Amount:");
        lblAmt.setFont(fnt2);

        lbl1=new JLabel("");
        lbl2=new JLabel("");
        lbl3=new JLabel("");
        lbl4=new JLabel("");
        lbl5=new JLabel("");
        lbl6=new JLabel("");
        lbl7=new JLabel("");
        lbl8=new JLabel("");

        //TextField
        txtOrderNo= new JTextField(20);
        txtOrderNo.setBackground(clrText);
        txtOrderNo.setFont(fnt2);
        txtCName= new JTextField(20);
        txtCName.setBackground(clrText);
        txtCName.setFont(fnt2);
        txtLocality= new JTextField(20);
        txtLocality.setBackground(clrText);
        txtLocality.setFont(fnt2);
        txtCity= new JTextField(20);
        txtCity.setBackground(clrText);
        txtCity.setFont(fnt2);
        txtStateTeri= new JTextField(20);
        txtStateTeri.setBackground(clrText);
        txtStateTeri.setFont(fnt2);
        txtDate=new JTextField(20);
        txtDate.setBackground(clrText);
        txtDate.setFont(fnt2);
        txtSLNo=new JTextField(20);
        txtSLNo.setBackground(clrText);
        txtSLNo.setFont(fnt2);
        txtPName= new JTextField(20);
        txtPName.setBackground(clrText);
        txtPName.setFont(fnt2);
        txtSize= new JTextField(20);
        txtSize.setBackground(clrText);
        txtSize.setFont(fnt2);
        txtPrice= new JTextField(20);
        txtPrice.setBackground(clrText);
        txtPrice.setFont(fnt2);
        txtOrQ= new JTextField(20);
        txtOrQ.setBackground(clrText);
        txtOrQ.setFont(fnt2);
        txtAmt= new JTextField(20);
        txtAmt.setBackground(clrText);
        txtAmt.setFont(fnt2);


        //ComboBox
        comboCName= new JComboBox();
        comboCName.setBackground(clrText);
        comboPCode= new JComboBox();
        comboPCode.setBackground(clrText);

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

        //Button ActionListener
        comboCName.addActionListener(this);
        comboPCode.addActionListener(this);
        txtOrQ.addActionListener(this);
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

        //Dialogs
        dlg=new JOptionPane();
        dlgIn=new JOptionPane();
        dlgCd=new JOptionPane();

        p1.setLayout(flw);
        p1.setBorder(bl);
        p1.add(lblHeader);

        p2.setLayout(gl54);
        p2.add(lblOrderNo);
        p2.add(txtOrderNo);
        p2.add(lblDate);
        p2.add(txtDate);

        p2.add(lblCName);
        p2.add(comboCName);
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

        p2.add(lblStateTerri);
        p2.add(txtStateTeri);
        p2.add(lbl7);
        p2.add(lbl8);

        p3.setLayout(gl27);
        p3.add(lblSLNo);
        p3.add(lblPCode);
        p3.add(lblPName);
        p3.add(lblSize);
        p3.add(lblPrice);
        p3.add(lblOrQ);
        p3.add(lblAmt);
        p3.add(txtSLNo);
        p3.add(comboPCode);
        p3.add(txtPName);
        p3.add(txtSize);
        p3.add(txtPrice);
        p3.add(txtOrQ);
        p3.add(txtAmt);

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
        //Box and Strut
        vb.add(Box.createVerticalStrut(20));
        vb.add(p1);
        vb.add(Box.createVerticalStrut(20));
        vb.add(p2);
        vb.add(Box.createVerticalStrut(1));
        vb.add(p3);
        vb.add(Box.createVerticalStrut(20));
        vb.add(p4);
        vb.add(Box.createVerticalStrut(20));

        hb.add(Box.createHorizontalStrut(20));
        hb.add(vb);
        hb.add(Box.createHorizontalStrut(20));


        //Frame
        f1.add(hb);
        f1.setBounds(230,170,1075,500);
        doConnect();
        getCombCName();
        getComboPCode();
        f1.setResizable(false);
        f1.setVisible(true);
    }//constructor end

    public void doConnect() {
        try {//step2
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Unable to Load Connection");
        }
        try {//step3
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
            stmSelect=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rsUser=stmSelect.executeQuery("select * from  LOG_TBLORDERTO order by SLNO");   //order by PCODE
        } catch (SQLException se) {
            System.out.println("Unable to connect");
        }
    }
    public void getCombCName(){
        try{
            stmComboCName=conn.createStatement();
            rsComboCName=stmComboCName.executeQuery("select * from LOG_TBLCOMPANY order by CCODE");
            str="--select--";
            comboCName.addItem(str);
            while(rsComboCName.next()){
                strComboCName=rsComboCName.getString("CNAME");
                strComboCName=strComboCName.trim();
                comboCName.addItem(strComboCName);

            }
        } catch (SQLException se){
            System.out.println("Unable to get Data");
        }
    }

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

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==btnClear){
            str="";
            i=0;
            comboCName.setSelectedIndex(i);
            comboPCode.setSelectedIndex(i);
            //txtOrderNo.setText("");
            txtDate.setText("");
            txtLocality.setText("");
            txtCity.setText("");
            txtStateTeri.setText("");
            txtSLNo.setText("");
            txtPName.setText("");
            txtSize.setText("");
            txtPrice.setText("");
            txtOrQ.setText("");
            txtAmt.setText("");

        } else if (ae.getSource()==btnSave) {
            strOrNo=txtOrderNo.getText();
            strOrNo=strOrNo.trim();
            strDate=txtDate.getText();
            strDate=strDate.trim();
            strCName=comboCName.getSelectedItem().toString();
            strCName=strCName.trim();
            strLocality=txtLocality.getText();
            strLocality=strLocality.trim();
            strCity=txtCity.getText();
            strCity=strCity.trim();
            strStateTerri=txtStateTeri.getText();
            strStateTerri=strStateTerri.trim();
            strSLNO=txtSLNo.getText();
            strSLNO=strSLNO.trim();
            strPCode=comboPCode.getSelectedItem().toString();
            strPCode=strPCode.trim();
            strPName=txtPName.getText();
            strPName=strPName.trim();
            strSize=txtSize.getText();
            strSize=strSize.trim();
            strPrice=txtPrice.getText();
            strOq=txtOrQ.getText();
            strAmt=txtAmt.getText();

            try{
                stmSave= conn.createStatement();
                stmSave.executeUpdate("insert into LOG_TBLORDERTO  values ('"+strOrNo+"','"+strDate+"','"+strCName+"','"+strLocality+"','"+strCity+"','"+strStateTerri+"','"+strSLNO+"','"+strPCode+"','"+strPName+"','"+strSize+"','"+strPrice+"','"+strOq+"','"+strAmt+"' )");

                dlg.showMessageDialog(f1,"One Record Saved","Message",1);
            }
            catch(SQLException se){
                //System.out.println("Unable to save"+se);
                dlg.showMessageDialog(f1,"Not Saved "+se,"Message",2);
            }
        }


        else if(ae.getSource()==btnNext){
            try {
                if (rsUser.isLast()) {
                    dlg.showMessageDialog(f1, "Last Record ", "Message", 1);

                } else {
                    rsUser.next();
                    strOrNo=rsUser.getString("ORDERNO");
                    strOrNo1=rsUser.getString("ORDERNO");
                    strDate=rsUser.getString("DATEE");
                    strCName=rsUser.getString("CNAME");
                    strCName1=rsUser.getString("CNAME");
                    strLocality=rsUser.getString("LOCALITY");
                    strCity=rsUser.getString("CITY");
                    strStateTerri=rsUser.getString("STATE");
                    strSLNO=rsUser.getString("SLNO");
                    strSLNO1=rsUser.getString("SLNO");
                    strPCode=rsUser.getString("PCODE");
                    strPCode1=rsUser.getString("PCODE");
                    strPName=rsUser.getString("PNAME");
                    strSize=rsUser.getString("PSIZE");
                    strPrice=rsUser.getString("PPRICE");
                    strOq=rsUser.getString("ORQ");
                    strAmt=rsUser.getString("AMT");

                    txtOrderNo.setText(strOrNo);
                    txtDate.setText(strDate);
                    strCName=strCName.trim();
                    strCName1=strCName1.trim();
                    comboCName.setSelectedItem(strCName);
                    strLocality=strLocality.trim();
                    txtLocality.setText(strLocality);
                    strCity=strCity.trim();
                    txtCity.setText(strCity);
                    strStateTerri= strStateTerri.trim();
                    txtStateTeri.setText(strStateTerri);
                    strSLNO=strSLNO.trim();
                    txtSLNo.setText(strSLNO);
                    strPCode=strPCode.trim();
                    comboPCode.setSelectedItem(strPCode);
                    strPName=strPName.trim();
                    txtPName.setText(strPName);
                    strSize=strSize.trim();
                    txtSize.setText(strSize);
                    txtPrice.setText(strPrice);
                    txtOrQ.setText(strOq);
                    txtAmt.setText(strAmt);
                }
            }
            catch(SQLException se){
                // System.out.println("Unable to go next"+se);
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
                    strOrNo=rsUser.getString("ORDERNO");
                    strOrNo1=rsUser.getString("ORDERNO");
                    strDate=rsUser.getString("DATEE");
                    strCName=rsUser.getString("CNAME");
                    strCName1=rsUser.getString("CNAME");
                    strLocality=rsUser.getString("LOCALITY");
                    strCity=rsUser.getString("CITY");
                    strStateTerri=rsUser.getString("STATE");
                    strSLNO=rsUser.getString("SLNO");
                    strSLNO1=rsUser.getString("SLNO");
                    strPCode=rsUser.getString("PCODE");
                    strPCode1=rsUser.getString("PCODE");
                    strPName=rsUser.getString("PNAME");
                    strSize=rsUser.getString("PSIZE");
                    strPrice=rsUser.getString("PPRICE");
                    strOq=rsUser.getString("ORQ");
                    strAmt=rsUser.getString("AMT");

                    txtOrderNo.setText(strOrNo);
                    txtDate.setText(strDate);
                    strCName=strCName.trim();
                    strCName1=strCName1.trim();
                    comboCName.setSelectedItem(strCName);
                    strLocality=strLocality.trim();
                    txtLocality.setText(strLocality);
                    strCity=strCity.trim();
                    txtCity.setText(strCity);
                    strStateTerri= strStateTerri.trim();
                    txtStateTeri.setText(strStateTerri);
                    strSLNO=strSLNO.trim();
                    txtSLNo.setText(strSLNO);
                    strPCode=strPCode.trim();
                    comboPCode.setSelectedItem(strPCode);
                    strPName=strPName.trim();
                    txtPName.setText(strPName);
                    strSize=strSize.trim();
                    txtSize.setText(strSize);
                    txtPrice.setText(strPrice);
                    txtOrQ.setText(strOq);
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
                strOrNo=rsUser.getString("ORDERNO");
                strOrNo1=rsUser.getString("ORDERNO");
                strDate=rsUser.getString("DATEE");
                strCName=rsUser.getString("CNAME");
                strCName1=rsUser.getString("CNAME");
                strLocality=rsUser.getString("LOCALITY");
                strCity=rsUser.getString("CITY");
                strStateTerri=rsUser.getString("STATE");
                strSLNO=rsUser.getString("SLNO");
                strSLNO1=rsUser.getString("SLNO");
                strPCode=rsUser.getString("PCODE");
                strPCode1=rsUser.getString("PCODE");
                strPName=rsUser.getString("PNAME");
                strSize=rsUser.getString("PSIZE");
                strPrice=rsUser.getString("PPRICE");
                strOq=rsUser.getString("ORQ");
                strAmt=rsUser.getString("AMT");

                txtOrderNo.setText(strOrNo);
                txtDate.setText(strDate);
                strCName=strCName.trim();
                strCName1=strCName1.trim();
                comboCName.setSelectedItem(strCName);
                txtLocality.setText(strLocality);
                txtCity.setText(strCity);
                txtStateTeri.setText(strStateTerri);
                strSLNO=strSLNO.trim();
                txtSLNo.setText(strSLNO);
                strPCode=strPCode.trim();
                comboPCode.setSelectedItem(strPCode);
                strPName=strPName.trim();
                txtPName.setText(strPName);
                strSize=strSize.trim();
                txtSize.setText(strSize);
                txtPrice.setText(strPrice);
                txtOrQ.setText(strOq);
                txtAmt.setText(strAmt);
            }
            catch(SQLException se){
                // System.out.println("Unable to go previous"+se);
                dlg.showMessageDialog(f1,"unable to go First"+se,"Message",2);
            }

        }
        else if(ae.getSource()==btnLast){
            try{
                rsUser.last();
                strOrNo=rsUser.getString("ORDERNO");
                strOrNo1=rsUser.getString("ORDERNO");
                strDate=rsUser.getString("DATEE");
                strCName=rsUser.getString("CNAME");
                strCName1=rsUser.getString("CNAME");
                strLocality=rsUser.getString("LOCALITY");
                strCity=rsUser.getString("CITY");
                strStateTerri=rsUser.getString("STATE");
                strSLNO=rsUser.getString("SLNO");
                strSLNO1=rsUser.getString("SLNO");
                strPCode=rsUser.getString("PCODE");
                strPCode1=rsUser.getString("PCODE");
                strPName=rsUser.getString("PNAME");
                strSize=rsUser.getString("PSIZE");
                strPrice=rsUser.getString("PPRICE");
                strOq=rsUser.getString("ORQ");
                strAmt=rsUser.getString("AMT");

                txtOrderNo.setText(strOrNo);
                txtDate.setText(strDate);
                strCName=strCName.trim();
                strCName1=strCName1.trim();
                comboCName.setSelectedItem(strCName);
                txtLocality.setText(strLocality);
                txtCity.setText(strCity);
                txtStateTeri.setText(strStateTerri);
                strSLNO=strSLNO.trim();
                txtSLNo.setText(strSLNO);
                strPCode=strPCode.trim();
                comboPCode.setSelectedItem(strPCode);
                strPName=strPName.trim();
                txtPName.setText(strPName);
                strSize=strSize.trim();
                txtSize.setText(strSize);
                txtPrice.setText(strPrice);
                txtOrQ.setText(strOq);
                txtAmt.setText(strAmt);
            }
            catch(SQLException se){
                // System.out.println("Unable to go previous"+se);
                dlg.showMessageDialog(f1,"unable to go First"+se,"Message",2);
            }
        }
        //DELETE
        else if(ae.getSource()==btnDelete){
            try{
                option=dlgCd.showConfirmDialog(f1,"Sure to Delete","Alert",2);
                if(option==0){
                    stmDelete=conn.createStatement();
                    stmDelete.executeUpdate("delete from LOG_TBLORDERTO where ORDERNO='"+strOrNo1+"'and PCODE='"+strPCode1+"'");
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
            strSearching= dlg.showInputDialog(f1,"Enter Order Number","Searching ",3);
            strPCode2= dlg.showInputDialog(f1,"Enter Product Code ","Searching ",3);
            try{
                stmSearching=conn.createStatement();
                rsSearching=stmSearching.executeQuery("select * from LOG_TBLORDERTO where ORDERNO='"+strSearching+"' and PCODE= '"+strPCode2+"'");

                if(rsSearching.next()){
                    strOrNo=rsSearching.getString("ORDERNO");
                    strDate=rsSearching.getString("DATEE");
                    strCName=rsSearching.getString("CNAME");
                    strLocality=rsSearching.getString("LOCALITY");
                    strCity=rsSearching.getString("CITY");
                    strStateTerri=rsSearching.getString("STATE");
                    strSLNO=rsSearching.getString("SLNO");
                    strPCode=rsSearching.getString("PCODE");
                    strPName=rsSearching.getString("PNAME");
                    strSize=rsSearching.getString("PSIZE");
                    strPrice=rsSearching.getString("PPRICE");
                    strOq=rsSearching.getString("ORQ");
                    strAmt=rsSearching.getString("AMT");

                    txtOrderNo.setText(strOrNo);
                    txtDate.setText(strDate);
                    strCName=strCName.trim();
                    comboCName.setSelectedItem(strCName);
                    txtLocality.setText(strLocality);
                    txtCity.setText(strCity);
                    txtStateTeri.setText(strStateTerri);
                    strSLNO=strSLNO.trim();
                    txtSLNo.setText(strSLNO);
                    strPCode=strPCode.trim();
                    comboPCode.setSelectedItem(strPCode);
                    strPName=strPName.trim();
                    txtPName.setText(strPName);
                    strSize=strSize.trim();
                    txtSize.setText(strSize);
                    txtPrice.setText(strPrice);
                    txtOrQ.setText(strOq);
                    txtAmt.setText(strAmt);

                }
                else{
                    dlg.showMessageDialog(f1,"Record Not Found","Message",2);
                }
            }
            catch(SQLException se){
                // System.out.println("ERROR"+se);
                dlg.showMessageDialog(f1,"ERROR"+se,"Message",2);
            }
        }


        //UPDATE
        else if(ae.getSource()==btnUpdate){

            strOrNo=txtOrderNo.getText();
            strOrNo=strOrNo.trim();
            strDate=txtDate.getText();
            strDate=strDate.trim();
            strCName=comboCName.getSelectedItem().toString();
            strCName=strCName.trim();
            strLocality=txtLocality.getText();
            strLocality=strLocality.trim();
            strCity=txtCity.getText();
            strCity=strCity.trim();
            strStateTerri=txtStateTeri.getText();
            strStateTerri=strStateTerri.trim();
            strSLNO=txtSLNo.getText();
            strSLNO=strSLNO.trim();
            strPCode=comboPCode.getSelectedItem().toString();
            strPCode=strPCode.trim();
            strPName=txtPName.getText();
            strPName=strPName.trim();
            strSize=txtSize.getText();
            strSize=strSize.trim();
            strPrice=txtPrice.getText();
            strOq=txtOrQ.getText();
            strAmt=txtAmt.getText();

            try {
                stmUpdate = conn.createStatement();
                option=dlgCd.showConfirmDialog(f1,"Sure to Update","Alert",2);
                if(option==0){
                    strPCode1=strPCode1.trim();
                    System.out.println(strPCode1+"h");
                    System.out.println(strPCode+"h");

                    if(!strPCode.equals(strPCode1)&&!strCName.equals(strCName1)){
                        dlg.showMessageDialog(f1," Can't change Company Name and Product Code at once   ","Updating",1);
                    }
                    else if(strPCode.equals(strPCode1)){
                        System.out.println("Same");
                        stmUpdate.executeUpdate("update LOG_TBLORDERTO set ORDERNO='"+strOrNo+"', DATEE ='"+strDate+"', CNAME='"+strCName+"',LOCALITY='"+strLocality+"', CITY='"+strCity+"', STATE='"+strStateTerri+"',ORQ='"+strOq+"',AMT='"+strAmt+"' where ORDERNO = '"+strOrNo1+"'and PCODE='"+strPCode1+"'");//
                        dlg.showMessageDialog(f1,"Record Updated  ","Updating",1);

                    }
                    else if(!strPCode.equals(strPCode1)){
                        System.out.println("Not Same");
                        stmUpdate.executeUpdate("update LOG_TBLORDERTO set ORDERNO='"+strOrNo+"', DATEE ='"+strDate+"', SLNO='"+strSLNO+"',PCODE='"+strPCode+"',PNAME='"+strPName+"', PSIZE='"+strSize+"',PPRICE='"+strPrice+"',ORQ='"+strOq+"',AMT='"+strAmt+"' where ORDERNO = '"+strOrNo1+"'and CNAME= '"+strCName1+"'");
                        dlg.showMessageDialog(f1,"Record Updated  ","Updating",1);
                    }
                }
            }
            catch(SQLException  se){
                // System.out.println("Unable to go Update"+se);
                dlg.showMessageDialog(f1,"unable to Update "+se,"Message",2);
            }

        }
        else if (ae.getSource()==comboCName) {

            str=comboCName.getSelectedItem().toString();
            try{
                stmCombo=conn.createStatement();
                rsCombo= stmCombo.executeQuery("Select * from LOG_TBLCOMPANY where CNAME='" + str + "'");
                if(rsCombo.next()){
                    str1=rsCombo.getString("LOCALITY");
                    str1=str1.trim();
                    txtLocality.setText(str1);
                    str2=rsCombo.getString("CITY");
                    str2=str2.trim();
                    txtCity.setText(str2);
                    str3=rsCombo.getString("STATE");
                    str3=str3.trim();
                    txtStateTeri.setText(str3);
                }
            }catch(SQLException se){
                // System.out.println("ERROR"+se);
                dlg.showMessageDialog(f1,"ERROR"+se,"Message",2);
            }

        } else if (ae.getSource()==comboPCode){
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
                }
            }catch(SQLException se){
                // System.out.println("ERROR"+se);
                dlg.showMessageDialog(f1,"ERROR"+se,"Message",2);
            }
        }else if(ae.getSource()==txtOrQ){
            price=Integer.parseInt(txtPrice.getText());
            quant=Integer.parseInt(txtOrQ.getText());
            amt=price*quant;
            str=String.valueOf(amt);
            txtAmt.setText(str);
            btnSave.requestFocus(true);
        }

        //CLOSE
        else if(ae.getSource()==btnClose){
            option=dlgCd.showConfirmDialog(f1,"Sure to end","Alert",2);
            if(option==0){
                f1.setVisible(false);
                f1.dispose();
            }
        }
    }
}


//Main Method
class log_OrderToApp{
    public static void main(String []args){
        OrderToWin obj;
        obj =new OrderToWin();
    }
}

