package IN.fORMS;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.event.*;
import java.sql.*;

//MASTER_FILE-->
class CompanyWin implements ActionListener{

    //FRAME PANEL LAYOUT_MANAGER
    JFrame f1;
    FlowLayout flw,flw1;
    JPanel p1,p2,p3,p4;
    GridLayout gl62,gl24;


    //COLOUR AND FONT AND BORDER
    Font fnt1,fnt2;
    Color clrAll,clrfont,clrBtn,clrWhite,clrText;
    Border bl,ebUp,ebDw,bbUp,bbDw;


    //LABLES DECLARATIONS
    JLabel  lblHeader,lblComCode,lblComName,lblContNo,lblLocality,lblCity,
            lblStateTeri,lblPhNo,lblMail,lblGSTNO,lblGSTDate;


    //TEXTFIELDS DECLARATIONS
    JTextField txtComName,txtComCode,txtContNo,txtLocality,txtCity,
            txtPhNo,txtMail,txtGSTNO,txtGSTDate;

    //IMAGE_ICONS DECLARATIONS
    ImageIcon imgClear,imgSave,imgNext,imgPrevious,imgDelete,imgUpdate,imgClose,imgSelect,imgFirst,imgLast;

    //BUTTONS DECLARATIONS
    JButton btnClear,btnSave,btnNext,btnPrevious,btnDelete,btnUpdate,btnClose,btnSelect,btnFirst,btnLast;

    //COMBOBOX STATE
    JComboBox comboStaTeri;
    String state[]={"-Select-",
            "Andhra Pradesh",
            "Andaman and Nicobar Islands",
            "Arunachal Pradesh",
            "Assam",
            "Bihar",
            "Chhattisgarh",
            "Chandigarh",
            "Dadra and Nagar Haveli",
            "Daman and Diu",
            "Delhi",
            "Goa",
            "Gujarat",
            "Haryana",
            "Himachal Pradesh",
            "Jammu and Kashmir",
            "Jharkhand",
            "Karnataka",
            "Kerala",
            "Lakshadweep",
            "Madhya Pradesh",
            "Maharashtra",
            "Manipur",
            "Meghalaya",
            "Mizoram",
            "Nagaland",
            "Odisha",
            "Punjab",
            "Puducherry",
            "Rajasthan",
            "Sikkim",
            "Tamil Nadu",
            "Telangana",
            "Tripura",
            "Uttarakhand",
            "Uttar Pradesh",
            "West Bengal",
    };

    //Dialogs
    JOptionPane dlg,dlgIn,dlgCd;
    int i,x=1,option=1;

    //Box Vertical horizontal
    Box vb,hb;

    //DataBase Requirements
    Connection conn;
    Statement stmSave,stmSelect, stmSearching, stmDelete,stmUpdate;//,stmFirst,stmLast;
    ResultSet rsUser,rsComCode;
    String strComCode,strComCode1,strComName,strContNo,strLocality,strCity,strStateTerr,
            strPhno,strMail,strGST,strGSTDate,strSearching,str2;


//156, 177, 214

    //CONSTRUCTOR BEGIN
    public CompanyWin(){
        //frame Panel LayoutManager Box
        f1=new JFrame("Logistic Solution  ");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        gl62= new GridLayout(6,2);
        gl24= new GridLayout(2,4);
        flw= new FlowLayout();
        flw1= new FlowLayout();
        vb=Box.createVerticalBox();
        hb=Box.createHorizontalBox();

        //Font and Colors and Border
        fnt1=new Font("Castellar",Font.BOLD,30);//Times New Roman//Castellar
        fnt2=new Font("Bahnschrift SemiLight",Font.BOLD,15);//copperplategothic// Bahnschrift SemiLight//Bookman Old Style
        clrAll=new Color (157, 174, 204);//panel
        clrfont=new Color(87, 111, 153);// Blue//122, 5, 20 //11, 89, 46
        clrWhite=new Color(255,255,255);//white  //255,255,255
        clrText=new Color(245, 243, 242);//textfield
        bl=BorderFactory.createLineBorder(Color.red);
        ebUp=BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        ebDw=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        bbUp=BorderFactory.createRaisedBevelBorder();
        bbDw=BorderFactory.createLoweredBevelBorder();



        //Lables font and colors
        lblHeader= new JLabel("COMPANY INFORMATION");
        lblHeader.setFont(fnt1);
        lblHeader.setForeground(clrfont);
        lblComCode= new JLabel("Company Code:");
        lblComCode.setFont(fnt2);
        lblComName=new JLabel("Company Name:");
        lblComName.setFont(fnt2);
        lblContNo=new JLabel("Contact Person:");
        lblContNo.setFont(fnt2);
        lblLocality=new JLabel("Locality:");
        lblLocality.setFont(fnt2);
        lblCity=new JLabel("City:");
        lblCity.setFont(fnt2);
        lblStateTeri=new JLabel("State/Territory:");
        lblStateTeri.setFont(fnt2);
        lblPhNo=new JLabel("Phone Number:");
        lblPhNo.setFont(fnt2);
        lblMail=new JLabel("  Mail-id:");
        lblMail.setFont(fnt2);
        lblGSTNO=new JLabel("GST Number:");
        lblGSTNO.setFont(fnt2);
        lblGSTDate=new JLabel("  GST Date:");
        lblGSTDate.setFont(fnt2);

        //TextFilds and colors
        txtComCode= new JTextField(20);
        txtComCode.setBackground(clrText);
        txtComCode.setFont(fnt2);
        txtComName= new JTextField(50);
        txtComName.setBackground(clrText);
        txtComName.setFont(fnt2);
        txtContNo= new JTextField(50);
        txtContNo.setBackground(clrText);
        txtContNo.setFont(fnt2);
        txtLocality= new JTextField(50);
        txtLocality.setBackground(clrText);
        txtLocality.setFont(fnt2);
        txtCity= new JTextField(50);
        txtCity.setBackground(clrText);
        txtCity.setFont(fnt2);
        txtPhNo= new JTextField(20);
        txtPhNo.setBackground(clrText);
        txtPhNo.setFont(fnt2);
        txtMail= new JTextField(50);
        txtMail.setBackground(clrText);
        txtMail.setFont(fnt2);
        txtGSTNO= new JTextField(20);
        txtGSTNO.setBackground(clrText);
        txtGSTNO.setFont(fnt2);
        txtGSTDate= new JTextField(20);
        txtGSTDate.setFont(fnt2);
        txtGSTDate.setBackground(clrText);
        txtGSTDate.setFont(fnt2);

        //Combo box and colors
        comboStaTeri=new JComboBox(state);
        comboStaTeri.setBackground(clrText);

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

        //Adding components to Panel p1,p2,p3,p4 and colors
        p1.setLayout(flw);
        // p1.setBackground(clrAll);
        p1.setBorder(bl);
        p1.add(lblHeader);

        p2.setLayout(gl62);
        p2.add(lblComCode);
        p2.add(txtComCode);
        p2.add(lblComName);
        p2.add(txtComName);
        p2.add(lblContNo);
        p2.add(txtContNo);
        p2.add(lblLocality);
        p2.add(txtLocality);
        p2.add(lblCity);
        p2.add(txtCity);
        p2.add(lblStateTeri);
        p2.add(comboStaTeri);

        p3.setLayout(gl24);
        p3.add(lblPhNo);
        p3.add(txtPhNo);
        p3.add(lblMail);
        p3.add(txtMail);
        p3.add(lblGSTNO);
        p3.add(txtGSTNO);
        p3.add(lblGSTDate);
        p3.add(txtGSTDate);

        p4.setLayout(flw1);
        //p4.setBackground(clrAll);
        //p4.setBorder(bbDw);
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
        vb.add(Box.createVerticalStrut(1));
        vb.add(p3);
        vb.add(Box.createVerticalStrut(20));
        vb.add(p4);
        vb.add(Box.createVerticalStrut(20));

        hb.add(Box.createHorizontalStrut(30));
        hb.add(vb);
        hb.add(Box.createHorizontalStrut(30));

        //Frame
        f1.add(hb);
        f1.setBounds(230,170,1075,500);//200 100 1000 600 //200,100,1100,700 //300,100,1000,450
        doConnect();//Method Calling
        f1.setResizable(false);
        f1.setVisible(true);

    }//Constructor ends

    public void doConnect(){
        try{//step2
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Unable to Load Connection"+cnfe);
        }


        try{//step3
            conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
            stmSelect=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rsUser=stmSelect.executeQuery("select * from LOG_TBLCOMPANY order by CCODE");
        }
        catch(SQLException se){
            System.out.println("Unable to connect"+se);
        }
    }
    //Phone Number Validation-->
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


    public void actionPerformed(ActionEvent ae){
        //CLEAR-->
        if (ae.getSource()==btnClear){
            txtComCode.setText("");
            txtComName.setText("");
            txtContNo.setText("");
            txtLocality.setText("");
            txtCity.setText("");
            txtPhNo.setText("");
            txtMail.setText("");
            txtGSTDate.setText("");
            txtGSTNO.setText("");
            i=0;
            comboStaTeri.setSelectedIndex(i);

        }
        //SAVE-->
        else if(ae.getSource()==btnSave){
            strComCode=txtComCode.getText();
            strComName=txtComName.getText();
            strContNo=txtContNo.getText();
            strLocality=txtLocality.getText();
            strCity=txtCity.getText();
            strStateTerr=comboStaTeri.getSelectedItem().toString();
            strPhno=txtPhNo.getText();
            strGST=txtGSTNO.getText();
            strMail=txtMail.getText();
            strGSTDate=txtGSTDate.getText();

            //Phone Number Validation-->
            if(!PhoneNumberValidation(strPhno)){
                dlg.showMessageDialog(f1,"Invalid Phone Number ","Message",2);
                return;
            }
            //Important detailes-->
            if(strComCode.isEmpty()||strComName.isEmpty()||strCity.isEmpty()||strStateTerr.isEmpty()||strPhno.isEmpty()||strGST.isEmpty()||strMail.isEmpty()){
                dlg.showMessageDialog(f1,"You are missing some Star Mark detailes.Please check it ","Message",2);
                return;
            }


            try{
                stmSave=conn.createStatement();
                stmSave.executeUpdate("insert into  LOG_TBLCOMPANY values('"+strComCode+"','"+strComName+"','"+strContNo+"','"+strLocality+"','"+strCity+"','"+strStateTerr+"','"+strPhno+"','"+strMail+"','"+strGST+"','"+strGSTDate+"')");
                //System.out.println("save");
                dlg.showMessageDialog(f1,"One Record Savaed","Message",1);
            }
            catch(SQLException se){
                System.out.println("Unable to save"+se);
                dlg.showMessageDialog(f1,"Not Saved"+se,"Message",2);
            }

        }
        //NEXT-->
        else if(ae.getSource()==btnNext){

            try{
                if(rsUser.isLast()){
                    dlg.showMessageDialog(f1,"Last Record ","Message",1);
                }
                else{
                    rsUser.next();
                    strComCode=rsUser.getString("CCODE");
                    strComCode1=rsUser.getString("CCODE");
                    strComName=rsUser.getString("CNAME");
                    strContNo=rsUser.getString("CONTPER");
                    strLocality=rsUser.getString("LOCALITY");
                    strCity=rsUser.getString("CITY");
                    strStateTerr=rsUser.getString("STATE");
                    strPhno=rsUser.getString("PHNO");
                    strMail=rsUser.getString("MAIL");
                    strGST=rsUser.getString("GSTNO");
                    strGSTDate=rsUser.getString("GSTDATE");

                    txtComCode.setText(strComCode);
                    txtComName.setText(strComName);
                    txtContNo.setText(strContNo);
                    txtLocality.setText(strLocality);
                    txtCity.setText(strCity);
                    strStateTerr=strStateTerr.trim();//trim
                    comboStaTeri.setSelectedItem(strStateTerr);
                    txtPhNo.setText(strPhno);
                    strMail=strMail.trim();//trim
                    txtMail.setText(strMail);
                    txtGSTNO.setText(strGST);
                    txtGSTDate.setText(strGSTDate);
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
                    strComCode=rsUser.getString("CCODE");
                    strComCode1=rsUser.getString("CCODE");
                    strComName=rsUser.getString("CNAME");
                    strContNo=rsUser.getString("CONTPER");
                    strLocality=rsUser.getString("LOCALITY");
                    strCity=rsUser.getString("CITY");
                    strStateTerr=rsUser.getString("STATE");
                    strPhno=rsUser.getString("PHNO");
                    strMail=rsUser.getString("MAIL");
                    strGST=rsUser.getString("GSTNO");
                    strGSTDate=rsUser.getString("GSTDATE");

                    txtComCode.setText(strComCode);
                    txtComName.setText(strComName);
                    txtContNo.setText(strContNo);
                    txtLocality.setText(strLocality);
                    txtCity.setText(strCity);
                    strStateTerr=strStateTerr.trim();//trim
                    comboStaTeri.setSelectedItem(strStateTerr);
                    txtPhNo.setText(strPhno);
                    strMail=strMail.trim();//trim
                    txtMail.setText(strMail);
                    txtGSTNO.setText(strGST);
                    txtGSTDate.setText(strGSTDate);
                }
            }
            catch(SQLException se){
                // System.out.println("Unable to go Previous"+se);
                dlg.showMessageDialog(f1,"unable to go Previous "+se,"Message",2);
            }
        }
        //DELETE-->
        else if(ae.getSource()==btnDelete){
            try{
                option=dlgCd.showConfirmDialog(f1,"Sure to Delete","Alert",2);
                if(option==0){
                    stmDelete=conn.createStatement();
                    stmDelete.executeUpdate("delete from LOG_TBLCOMPANY where CCODE='"+strComCode1+"'");
                    dlg.showMessageDialog(f1,"Record Deleted  ","Message",1);
                }
            }
            catch(SQLException se){
                // System.out.println("Unable to go Delete"+se);
                dlg.showMessageDialog(f1,"unable to go Delete"+se,"Message",2);
            }
        }
        //UPDATE-->
        else if(ae.getSource()==btnUpdate){
            strComCode=txtComCode.getText();
            strComName= txtComName.getText();
            strContNo=txtContNo.getText();
            strLocality=txtLocality.getText();
            strCity=txtCity.getText();
            strPhno=txtPhNo.getText();
            strMail=txtMail.getText();
            strGST=txtGSTNO.getText();
            strGSTDate=txtGSTDate.getText();
            strStateTerr=comboStaTeri.getSelectedItem().toString();
            try {
                stmUpdate = conn.createStatement();
                option=dlgCd.showConfirmDialog(f1,"Sure to Update","Alert",2);
                if(option==0){
                    stmUpdate.executeUpdate("update LOG_TBLCOMPANY set CCODE='"+strComCode+"', CNAME ='"+strComName+"', CONTPER='"+strContNo+"',LOCALITY='"+strLocality+"', CITY='"+strCity+"', STATE='"+strStateTerr+"',PHNO='"+strPhno+"',MAIL='"+strMail+"',GSTNO='"+strGST+"', GSTDATE='"+strGSTDate+"' where CCODE = '"+strComCode1+"'");
                    dlg.showMessageDialog(f1,"Record Updated  ","Updating",1);
                }
            }
            catch(SQLException  se){
                // System.out.println("Unable to go Update"+se);
                dlg.showMessageDialog(f1,"unable to Update "+se,"Message",2);
            }
        }
        //SELECT-->
        else if(ae.getSource()==btnSelect){
            strSearching= dlg.showInputDialog(f1,"Enter Company Code Number","Searching ",3);
            try{
                stmSearching=conn.createStatement();
                rsComCode=stmSearching.executeQuery("select * from LOG_TBLCOMPANY where CCODE='"+strSearching+"'");

                if(rsComCode.next()){

                    strComCode=rsComCode.getString("CCODE");
                    strComName=rsComCode.getString("CNAME");
                    strContNo=rsComCode.getString("CONTPER");
                    strLocality=rsComCode.getString("LOCALITY");
                    strCity=rsComCode.getString("CITY");
                    strStateTerr=rsComCode.getString("STATE");
                    strPhno=rsComCode.getString("PHNO");
                    strMail=rsComCode.getString("MAIL");
                    strGST=rsComCode.getString("GSTNO");
                    strGSTDate=rsComCode.getString("GSTDATE");

                    txtComCode.setText(strComCode);
                    txtComName.setText(strComName);
                    txtContNo.setText(strContNo);
                    txtLocality.setText(strLocality);
                    txtCity.setText(strCity);
                    strStateTerr=strStateTerr.trim();//trim
                    comboStaTeri.setSelectedItem(strStateTerr);
                    txtPhNo.setText(strPhno);
                    strMail=strMail.trim();//trim
                    txtMail.setText(strMail);
                    txtGSTNO.setText(strGST);
                    txtGSTDate.setText(strGSTDate);
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
        //fIRST DATA
        else if(ae.getSource()==btnFirst){
            try{
                rsUser.first();
                strComCode=rsUser.getString("CCode");
                strComCode1=rsUser.getString("CCODE");
                strComName=rsUser.getString("CNAME");
                strContNo=rsUser.getString("CONTPER");
                strLocality=rsUser.getString("LOCALITY");
                strCity=rsUser.getString("CITY");
                strStateTerr=rsUser.getString("STATE");
                strPhno=rsUser.getString("PHNO");
                strMail=rsUser.getString("MAIL");
                strGST=rsUser.getString("GSTNO");
                strGSTDate=rsUser.getString("GSTDATE");

                txtComCode.setText(strComCode);
                txtComName.setText(strComName);
                txtContNo.setText(strContNo);
                txtLocality.setText(strLocality);
                txtCity.setText(strCity);
                strStateTerr=strStateTerr.trim();//trim
                comboStaTeri.setSelectedItem(strStateTerr);
                txtPhNo.setText(strPhno);
                strMail=strMail.trim();//trim
                txtMail.setText(strMail);
                txtGSTNO.setText(strGST);
                txtGSTDate.setText(strGSTDate);
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
                strComCode=rsUser.getString("CCode");
                strComCode1=rsUser.getString("CCODE");
                strComName=rsUser.getString("CNAME");
                strContNo=rsUser.getString("CONTPER");
                strLocality=rsUser.getString("LOCALITY");
                strCity=rsUser.getString("CITY");
                strStateTerr=rsUser.getString("STATE");
                strPhno=rsUser.getString("PHNO");
                strMail=rsUser.getString("MAIL");
                strGST=rsUser.getString("GSTNO");
                strGSTDate=rsUser.getString("GSTDATE");

                txtComCode.setText(strComCode);
                txtComName.setText(strComName);
                txtContNo.setText(strContNo);
                txtLocality.setText(strLocality);
                txtCity.setText(strCity);
                strStateTerr=strStateTerr.trim();//trim
                comboStaTeri.setSelectedItem(strStateTerr);
                txtPhNo.setText(strPhno);
                strMail=strMail.trim();//trim
                txtMail.setText(strMail);
                txtGSTNO.setText(strGST);
                txtGSTDate.setText(strGSTDate);
            }
            catch(SQLException se){
                // System.out.println("Unable to go Last"+se);
                dlg.showMessageDialog(f1,"unable to go Last "+se,"Message",2);
            }
        }
        //CLOSE
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
//Main Method
class log_CompanyApp{
    public static void main(String []args){
        CompanyWin obj;
        obj =new CompanyWin();
    }
}
