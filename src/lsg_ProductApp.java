import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class ProductWin implements ActionListener{
    //FRAME PANEL LAYOUT_MANAGER
    JFrame f1;
    FlowLayout flw,flw1;
    JPanel p1,p2,p3,p4;
    GridLayout gl62,gl34;


    //COLOUR AND FONT AND BORDER
    Font fnt1,fnt2;
    Color clrAll,clrfont,clrBtn,clrWhite,clrText;
    Border bl,ebUp,ebDw,bbUp,bbDw;


    //LABLES DECLARATIONS
    JLabel  lblHeader,lblCName,lblCCode,lblPCode,lblPName,lblPSize,lblMUnit,
            lblPPrice,lblMRP,lblGSTSOLB,lblOPStk,lblMarginalStk,lbl1,lbl2;


    //TEXTFIELDS DECLARATIONS
    JTextField txtCCode,txtPCode,txtPName,txtMUnit,txtPPrice,txtMRP,txtOPStk,txtMarginalStk;


    //COMBOBOX
    JComboBox comboCName,comboPSize,comboGSTSlob;
    String size[]={"--Select--","XS","S","M","L","XL","XXL"};
    String gst[]={"--Select--","8","12","18","28"};


    //IMAGE_ICONS DECLARATIONS
    ImageIcon imgClear,imgSave,imgNext,imgPrevious,imgDelete,imgUpdate,imgClose,imgSelect,imgFirst,imgLast;

    //BUTTONS DECLARATIONS
    JButton btnClear,btnSave,btnNext,btnPrevious,btnDelete,btnUpdate,btnClose,btnSelect,btnFirst,btnLast;

    //Dialogs
    JOptionPane dlg,dlgIn,dlgCd;
    int i,x=1,option=1,count=0;

    //Box Vertical horizontal
    Box vb,hb;

    //DataBase Requirements//tbldept
    Connection conn;
    Statement stmCompany,stmSelect,stmSave,stmUpdate,stmDelete,stmSearching,stmComboCName;
    ResultSet rsCompany,rsUser,rsComCode,rsCombo;
    String compName,strDcombo,strCName,strCCode,strPCode,strPName,strPSIZE,strMUNIT,strPPRICE,strMRP,strGSTSLAP,strOPSTK,strMARSTK,strCCode1,strSearching;




    public ProductWin(){
        //frame Panel LayoutManager Box
        f1=new JFrame("Logistic Solution   ");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        gl62= new GridLayout(6,2);
        gl34= new GridLayout(3,4);
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
        lblHeader= new JLabel("Product Information  ");
        lblHeader.setFont(fnt1);
        lblHeader.setForeground(clrfont);
        lblCName=new JLabel("Company Name:  ");
        lblCName.setFont(fnt2);
        lblCCode= new JLabel("Company Code:  ");
        lblCCode.setFont(fnt2);
        lblPName=new JLabel("Product Name:  *");
        lblPName.setFont(fnt2);
        lblPSize=new JLabel("Product Size :  *");
        lblPSize.setFont(fnt2);
        lblPCode=new JLabel("Product Code :  *");
        lblPCode.setFont(fnt2);
        lblMUnit=new JLabel("Measuring Unit : ");
        lblMUnit.setFont(fnt2);
        lblPPrice=new JLabel("Purchase Price *");
        lblPPrice.setFont(fnt2);
        lblMRP=new JLabel(" M.R.P: *");
        lblMRP.setFont(fnt2);
        lblGSTSOLB=new JLabel("  GST Slab: *");
        lblGSTSOLB.setFont(fnt2);
        lblOPStk=new JLabel("Opening Stock: ");
        lblOPStk.setFont(fnt2);
        lblMarginalStk=new JLabel(" Marginal Stock:");
        lblMarginalStk.setFont(fnt2);
        lbl1=new JLabel();
        lbl2=new JLabel();

        //TextFilds and colors
        txtCCode= new JTextField(20);
        txtCCode.setBackground(clrText);
        txtCCode.setFont(fnt2);
        txtPCode= new JTextField(20);
        txtPCode.setBackground(clrText);
        txtPCode.setFont(fnt2);
        txtPName= new JTextField(20);
        txtPName.setBackground(clrText);
        txtPName.setFont(fnt2);
        txtMUnit= new JTextField(20);
        txtMUnit.setBackground(clrText);
        txtMUnit.setFont(fnt2);
        txtPPrice= new JTextField(20);
        txtPPrice.setBackground(clrText);
        txtPPrice.setFont(fnt2);
        txtMRP= new JTextField(20);
        txtMRP.setBackground(clrText);
        txtMRP.setFont(fnt2);
        txtOPStk= new JTextField(20);
        txtOPStk.setBackground(clrText);
        txtOPStk.setFont(fnt2);
        txtMarginalStk= new JTextField(20);
        txtMarginalStk.setBackground(clrText);
        txtMarginalStk.setFont(fnt2);

        //Combo box and colors
        comboCName= new JComboBox();
        comboCName.setBackground(clrText);
        comboPSize= new JComboBox(size);
        comboPSize.setBackground(clrText);
        comboGSTSlob= new JComboBox(gst);
        comboGSTSlob.setBackground(clrText);


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
        p2.add(lblCName);
        p2.add(comboCName);
        p2.add(lblCCode);
        p2.add(txtCCode);
        p2.add(lblPCode);
        p2.add(txtPCode);
        p2.add(lblPName);
        p2.add(txtPName);
        p2.add(lblPSize);
        p2.add(comboPSize);
        p2.add(lblMUnit);
        p2.add(txtMUnit);

        p3.setLayout(gl34);
        p3.add(lblPPrice);
        p3.add(txtPPrice);
        p3.add(lblMRP);
        p3.add(txtMRP);
        p3.add(lblGSTSOLB);
        p3.add(comboGSTSlob);
        p3.add(lbl1);
        p3.add(lbl2);
        p3.add(lblOPStk);
        p3.add(txtOPStk);
        p3.add(lblMarginalStk);
        p3.add(txtMarginalStk);

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
        vb.add(Box.createVerticalStrut(1));
        vb.add(p3);
        vb.add(Box.createVerticalStrut(20));
        vb.add(p4);
        vb.add(Box.createVerticalStrut(20));

        hb.add(Box.createHorizontalStrut(30));
        hb.add(vb);
        hb.add(Box.createHorizontalStrut(30));

        //Frame
        doConnect();
        createPNameCombo();
        f1.add(hb);
        f1.setBounds(230,170,1075,500);//200 100 1000 600 //200,100,1100,700 //300,100,1000,450
        f1.setResizable(false);
        f1.setVisible(true);

    }//Constructor ends


    public void doConnect() {
        try {//step2
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Unable to Load Connection");
        }
        try {//step3
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
            stmSelect=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rsUser=stmSelect.executeQuery("select * from LOG_TBLPRODUCT order by PCODE ");   //order by PCODE
        } catch (SQLException se) {
            System.out.println("Unable to connect");
        }
    }

    public void createPNameCombo(){
        //System.out.println("Here...");
        try {
            stmCompany = conn.createStatement();
            rsCompany = stmCompany.executeQuery("select * from LOG_TBLCOMPANY order by CCODE ");   //order by CCODE
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
            txtCCode.setText("");
            txtPName.setText("");
            txtPCode.setText("");
            txtPPrice.setText("");
            txtMRP.setText("");
            txtMUnit.setText("");
            txtOPStk.setText("");
            txtMarginalStk.setText("");
            i = 0;
            comboCName.setSelectedIndex(i);
            comboGSTSlob.setSelectedIndex(i);
            comboPSize.setSelectedIndex(i);
        }

        //SAVE
        else if(ae.getSource() == btnSave){
            strCName=comboCName.getSelectedItem().toString();
            strCCode=txtCCode.getText();
            strPCode=txtPCode.getText();
            strPName=txtPName.getText();
            strPSIZE=comboPSize.getSelectedItem().toString();
            strMUNIT=txtMUnit.getText();
            strPPRICE=txtPPrice.getText();
            strMRP=txtMRP.getText();
            strGSTSLAP=comboGSTSlob.getSelectedItem().toString();
            strOPSTK=txtOPStk.getText();
            strMARSTK=txtMarginalStk.getText();

            try{
                stmSave=conn.createStatement();
                stmSave.executeUpdate("insert into LOG_TBLPRODUCT  values ('"+strCName+"', '"+strCCode+"', '"+strPCode+"', '"+strPName+"', '"+strPSIZE+"', '"+strMUNIT+"', '"+strPPRICE+"', '"+strMRP+"', '"+strGSTSLAP+"', '"+strOPSTK+"', '"+strMARSTK+"' )");
                dlg.showMessageDialog(f1,"One Record Saved","Message",1);
            }
            catch(SQLException se){
                //System.out.println("Unable to save"+se);
                dlg.showMessageDialog(f1,"Not Saved "+se,"Message",2);
            }
        }
        //NEXT
        else if(ae.getSource()==btnNext) {

            try {
                if (rsUser.isLast()) {
                    dlg.showMessageDialog(f1, "Last Record ", "Message", 1);
                } else {
                    rsUser.next();
                    //strComCode=rsUser.getString("CCODE");
                    strCName = rsUser.getString("CCNAME");
                    strCCode = rsUser.getString("CCODE");
                    strPCode = rsUser.getString("PCODE");
                    strPName = rsUser.getString("PNAME");
                    strPSIZE = rsUser.getString("PSIZE");
                    strMUNIT = rsUser.getString("MUNIT");
                    strPPRICE = rsUser.getString("PPRICE");
                    strMRP = rsUser.getString("MRP");
                    strGSTSLAP = rsUser.getString("GSTSLAP");
                    strOPSTK = rsUser.getString("OPSTK");
                    strMARSTK = rsUser.getString("MARSTK");
                    strCCode1= rsUser.getString("CCODE");

                    comboCName.setSelectedItem(strCName);
                    txtCCode.setText(strCCode);
                    txtPCode.setText(strPCode);
                    txtPName.setText(strPName);
                    strPSIZE=strPSIZE.trim();
                    comboPSize.setSelectedItem(strPSIZE);
                    txtMUnit.setText(strMUNIT);
                    txtPPrice.setText(strPPRICE);
                    txtMRP.setText(strMRP);
                    comboGSTSlob.setSelectedItem(strGSTSLAP);
                    txtOPStk.setText(strOPSTK);
                    txtMarginalStk.setText(strMARSTK);

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
                    strCName = rsUser.getString("CCNAME");
                    strCCode = rsUser.getString("CCODE");
                    strPCode = rsUser.getString("PCODE");
                    strPName = rsUser.getString("PNAME");
                    strPSIZE = rsUser.getString("PSIZE");
                    strMUNIT = rsUser.getString("MUNIT");
                    strPPRICE = rsUser.getString("PPRICE");
                    strMRP = rsUser.getString("MRP");
                    strGSTSLAP = rsUser.getString("GSTSLAP");
                    strOPSTK = rsUser.getString("OPSTK");
                    strMARSTK = rsUser.getString("MARSTK");

                    comboCName.setSelectedItem(strCName);
                    txtCCode.setText(strCCode);
                    txtPCode.setText(strPCode);
                    txtPName.setText(strPName);
                    strPSIZE=strPSIZE.trim();
                    comboPSize.setSelectedItem(strPSIZE);
                    txtMUnit.setText(strMUNIT);
                    txtPPrice.setText(strPPRICE);
                    txtMRP.setText(strMRP);
                    comboGSTSlob.setSelectedItem(strGSTSLAP);
                    txtOPStk.setText(strOPSTK);
                    txtMarginalStk.setText(strMARSTK);

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
                strCName = rsUser.getString("CCNAME");
                strCCode = rsUser.getString("CCODE");
                strPCode = rsUser.getString("PCODE");
                strPName = rsUser.getString("PNAME");
                strPSIZE = rsUser.getString("PSIZE");
                strMUNIT = rsUser.getString("MUNIT");
                strPPRICE = rsUser.getString("PPRICE");
                strMRP = rsUser.getString("MRP");
                strGSTSLAP = rsUser.getString("GSTSLAP");
                strOPSTK = rsUser.getString("OPSTK");
                strMARSTK = rsUser.getString("MARSTK");

                comboCName.setSelectedItem(strCName);
                txtCCode.setText(strCCode);
                txtPCode.setText(strPCode);
                txtPName.setText(strPName);
                comboPSize.setSelectedItem(strPSIZE);
                txtMUnit.setText(strMUNIT);
                txtPPrice.setText(strPPRICE);
                txtMRP.setText(strMRP);
                comboGSTSlob.setSelectedItem(strGSTSLAP);
                txtOPStk.setText(strOPSTK);
                txtMarginalStk.setText(strMARSTK);

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
                strCName = rsUser.getString("CCNAME");
                strCCode = rsUser.getString("CCODE");
                strPCode = rsUser.getString("PCODE");
                strPName = rsUser.getString("PNAME");
                strPSIZE = rsUser.getString("PSIZE");
                strMUNIT = rsUser.getString("MUNIT");
                strPPRICE = rsUser.getString("PPRICE");
                strMRP = rsUser.getString("MRP");
                strGSTSLAP = rsUser.getString("GSTSLAP");
                strOPSTK = rsUser.getString("OPSTK");
                strMARSTK = rsUser.getString("MARSTK");

                comboCName.setSelectedItem(strCName);
                txtCCode.setText(strCCode);
                txtPCode.setText(strPCode);
                txtPName.setText(strPName);
                comboPSize.setSelectedItem(strPSIZE);
                txtMUnit.setText(strMUNIT);
                txtPPrice.setText(strPPRICE);
                txtMRP.setText(strMRP);
                comboGSTSlob.setSelectedItem(strGSTSLAP);
                txtOPStk.setText(strOPSTK);
                txtMarginalStk.setText(strMARSTK);


            }
            catch(SQLException se){
                // System.out.println("Unable to go Last"+se);
                dlg.showMessageDialog(f1,"unable to go Last "+se,"Message",2);
            }
        }
        //DELETE
        else if(ae.getSource()==btnDelete){
            try{
                option=dlgCd.showConfirmDialog(f1,"Sure to Delete","Alert",2);
                if(option==0){
                    stmDelete=conn.createStatement();
                    stmDelete.executeUpdate("delete from LOG_TBLPRODUCT where CCODE='"+strCCode+"'");
                    dlg.showMessageDialog(f1,"Record Deleted  ","Message",1);
                }
            }
            catch(SQLException se){
                // System.out.println("Unable to go Delete"+se);
                dlg.showMessageDialog(f1,"unable to go Delete"+se,"Message",2);
            }
        }
        //UPDATE
        else if(ae.getSource()==btnUpdate){

            strCName=comboCName.getSelectedItem().toString();
            strCCode=txtCCode.getText();
            strPCode=txtPCode.getText();
            strPName=txtPName.getText();
            strPSIZE=comboPSize.getSelectedItem().toString();
            strMUNIT=txtMUnit.getText();
            strPPRICE=txtPPrice.getText();
            strMRP=txtMRP.getText();
            strGSTSLAP=comboGSTSlob.getSelectedItem().toString();
            strOPSTK=txtOPStk.getText();
            strMARSTK=txtMarginalStk.getText();

            try {
                stmUpdate = conn.createStatement();
                option=dlgCd.showConfirmDialog(f1,"Sure to Update","Alert",2);
                if(option==0){
                    stmUpdate.executeUpdate("update LOG_TBLPRODUCT set CCNAME='"+strCName+"',CCODE='"+strCCode+"',PCODE='"+strPCode+"',PNAME='"+strPName+"',PSIZE='"+strPSIZE+"',MUnit='"+strMUNIT+"',PPRICE='"+strPPRICE+"',MRP='"+strMRP+"',GSTSLAP='"+strGSTSLAP+"',OPSTK='"+strOPSTK+"',MARSTK='"+strMARSTK+"'");
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
                rsComCode=stmSearching.executeQuery("select * from LOG_TBLPRODUCT where CCODE='"+strSearching+"'");

                if(rsComCode.next()){
                    strCName = rsComCode.getString("CCNAME");
                    strCCode = rsComCode.getString("CCODE");
                    strPCode = rsComCode.getString("PCODE");
                    strPName = rsComCode.getString("PNAME");
                    strPSIZE = rsComCode.getString("PSIZE");
                    strMUNIT = rsComCode.getString("MUNIT");
                    strPPRICE = rsComCode.getString("PPRICE");
                    strMRP = rsComCode.getString("MRP");
                    strGSTSLAP = rsComCode.getString("GSTSLAP");
                    strOPSTK = rsComCode.getString("OPSTK");
                    strMARSTK = rsComCode.getString("MARSTK");

                    comboCName.setSelectedItem(strCName);
                    txtCCode.setText(strCCode);
                    txtPCode.setText(strPCode);
                    txtPName.setText(strPName);
                    comboPSize.setSelectedItem(strPSIZE);
                    txtMUnit.setText(strMUNIT);
                    txtPPrice.setText(strPPRICE);
                    txtMRP.setText(strMRP);
                    comboGSTSlob.setSelectedItem(strGSTSLAP);
                    txtOPStk.setText(strOPSTK);
                    txtMarginalStk.setText(strMARSTK);

                }

            }
            catch(SQLException se){
                // System.out.println("ERROR"+se);
                dlg.showMessageDialog(f1,"ERROR"+se,"Message",2);
            }
        }
        else if(ae.getSource() == comboCName){
            strDcombo = comboCName.getSelectedItem().toString();
            try{
                stmComboCName = conn.createStatement();
                rsCombo= stmComboCName.executeQuery("Select * from LOG_TBLCOMPANY where CNAME='" + strDcombo + "'");

                if (rsCombo.next()) {
                    strCCode=rsCombo.getString("CCODE");
                    strCCode=strCCode.trim();
                    txtCCode.setText(strCCode);
                }
            } catch (SQLException se) {
                System.out.println("Error"+se);
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
class log_ProductApp{
    public static void main(String []args){
        ProductWin obj;
        obj =new ProductWin();
    }
}



