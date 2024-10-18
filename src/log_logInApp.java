import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
class logInWin implements ActionListener{

    JFrame f1;
    FlowLayout flw,flw1;
    JPanel p1,p2,p3;
    GridLayout gl21;
    Box vb,hb;

    Font fnt1,fnt2;
    Color clrAll,clrfont,clrBtn,clrWhite,clrText;
    Border bl,ebUp,ebDw,bbUp,bbDw;

    JLabel  lblHeader,lblUName,lblPassword;

    JTextField txtUName,txtPassword;

    JButton btnLogin,btnCancel;

    JOptionPane dlg,dlgIn,dlgCd;
    int i,x=1,option=1;

    Connection conn;
    Statement stmCheck,stmSelect;
    ResultSet rsUser,rsCheck;
    String unm,pwd;



    public logInWin(){

        f1=new JFrame("Logistic Solution  ");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        gl21= new GridLayout(2,1);
        flw= new FlowLayout();
        flw1= new FlowLayout();


        fnt1=new Font("Castellar",Font.BOLD,30);//Times New Roman//Castellar
        fnt2=new Font("Bahnschrift SemiLight",Font.BOLD,15);//copperplategothic// Bahnschrift SemiLight//Bookman Old Style
        clrAll=new Color (157, 174, 204);//panel
        clrfont=new Color(87, 111, 153);// Blue//122, 5, 20 //11, 89, 46
        clrWhite=new Color(255,255,255);//white  //255,255,255
        clrText=new Color(245, 243, 242);//textfield
        bl=BorderFactory.createLineBorder(Color.red);
        vb=Box.createVerticalBox();
        hb=Box.createHorizontalBox();


        lblHeader= new JLabel("LOG-IN ");
        lblHeader.setFont(fnt1);
        lblHeader.setForeground(clrfont);
        lblUName= new JLabel("User Name:");
        lblUName.setFont(fnt2);
        lblPassword=new JLabel("Password:");
        lblPassword.setFont(fnt2);

        txtUName= new JTextField(50);
        txtUName.setBackground(clrText);
        txtUName.setFont(fnt2);
        txtPassword= new JTextField(20);
        txtPassword.setBackground(clrText);
        txtPassword.setFont(fnt2);

        btnLogin=new JButton ("LogIn");
        btnLogin.setBackground(clrWhite);
        btnLogin.setToolTipText("Show First Record ");
        btnCancel=new JButton("Cancel");
        btnCancel.setBackground(clrWhite);
        btnCancel.setToolTipText(" Show Last Record ");

        p3.setLayout(flw);
        p3.setBorder(bl);
        p3.add(lblHeader);

        p1.setLayout(gl21);
        p1.add(lblUName);
        p1.add(txtUName);
        p1.add(lblPassword);
        p1.add(txtPassword);

        p2.setLayout(flw1);
        p2.add(btnLogin);
        p2.add(btnCancel);
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);

        vb.add(Box.createVerticalStrut(20));
        vb.add(p3);
        vb.add(Box.createVerticalStrut(20));
        vb.add(p1);
        vb.add(Box.createVerticalStrut(1));
        vb.add(p2);

        hb.add(Box.createHorizontalStrut(30));
        hb.add(vb);
        hb.add(Box.createHorizontalStrut(30));

        f1.add(hb);

        doConnect();

        f1.setBounds(530,270,400,240);//200 100 1000 600 //200,100,1100,700 //300,100,1000,450
        //f1.setResizable(false);
        f1.setVisible(true);


    }

    public void doConnect(){
        try{//step2
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Unable to Load Connection"+cnfe);
        }


        try{//step3
            conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
            stmSelect=conn.createStatement();
            rsUser=stmSelect.executeQuery("select * from  LOG_TBLLOGIN");

        }
        catch(SQLException se){
            System.out.println("Unable to connect"+se);
        }
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==btnLogin){
            unm=txtUName.getText();
            pwd=txtPassword.getText();
            pwd=pwd.trim();
            unm=unm.trim();
            try{
                stmCheck=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rsCheck=stmCheck.executeQuery("SELECT * FROM LOG_TBLLOGIN where uname='"+unm+"'and password='"+pwd+"'");
                if(rsCheck.next()){
                    // open menu
                  //  MainWin obj;
                    //obj= new  MainWin();
                }
                else{
                    // Incorrect Uname or Password
                    option=dlgCd.showConfirmDialog(f1,"Incorrect Password","Alert",2);
                }


            } catch (SQLException se){
                System.out.println("Unable to get Data"+se);
            }
        }

        else if(ae.getSource()==btnCancel){
            option=dlgCd.showConfirmDialog(f1,"Sure to end","Alert",2);
            if(option==0){
                f1.setVisible(false);
                f1.dispose();

            }

        }
    }
}

class log_logInApp{
    public static void main(String []args){
        logInWin obj;
        obj =new logInWin();
    }
}