//import IN.fORMS.*;
//import IN.SUMMERY_RPT.*;
//import IN.DETAIL_RPT.*;
//
//import java.awt.*;
//import javax.swing.*;
//import java.awt.event.*;
//class MainWin implements ActionListener{
//
//    Font fnt1,fnt2;
//    JFrame f1;
//    JMenuBar MBar;
//    JMenu mast,mgnt,srpt,drpt,help,quit;
//    JMenuItem CInfo,PInfo,RInfo,UserMan,Chpw,yes,no,OTC,POG,OFR,IOG,IOGC,PV,RV;
//    JMenuItem rCInfo,rPInfo,rRInfo,rOTC,rPOG,rOFR,rIOG,rIOGC,rPV,rRV;
//    JMenuItem  sPI_CN,sOTC_CN,sOTC_PC,sPOG_PuN,sPOG_PuD,sPOG_CN,sPOG_PC,sOFR_RN,sOFR_PC,sIOGC_IN,sIOGC_ID,sIOGC_PC,sIOGC_CI,sIOG_IN,sIOG_ID,sIOG_RN,sIOG_PC,sPV_CN,sRV_RN;
//    BorderLayout bl;
//    public MainWin() {
//        f1 = new JFrame("Logistic Solution [Garments]");
//        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        fnt1=new Font("Bahnschrift SemiLight",Font.BOLD,15);
//        fnt2=new Font("Bahnschrift SemiLight",Font.BOLD,13);
//
//        bl=new BorderLayout();
//        MBar=new JMenuBar();
//        mast=new JMenu("Master  ");
//        mast.setFont(fnt1);
//        mgnt=new JMenu("Managment  ");
//        mgnt.setFont(fnt1);
//        srpt=new JMenu("Summary Report");
//        srpt.setFont(fnt1);
//        drpt=new JMenu("Detail Report  ");
//        drpt.setFont(fnt1);
//        help=new JMenu("Help  ");
//        help.setFont(fnt1);
//        quit=new JMenu("Quit ");
//        quit.setFont(fnt1);
//
//        CInfo=new JMenuItem("Company Information");
//        CInfo.setFont(fnt2);
//        PInfo=new JMenuItem("Product Information");
//        PInfo.setFont(fnt2);
//        RInfo=new JMenuItem("Retailer Information");
//        RInfo.setFont(fnt2);
//        UserMan=new JMenuItem("User Manual");
//        UserMan.setFont(fnt2);
//        Chpw=new JMenuItem("Change Password");
//        Chpw.setFont(fnt2);
//        yes=new JMenuItem("Yes!Please");
//        yes.setFont(fnt2);
//        no=new JMenuItem("No!Thank you");
//        no.setFont(fnt2);
//        OTC=new JMenuItem("Order To Company");
//        OTC.setFont(fnt2);
//        POG=new JMenuItem("Purchase Of Goods");
//        POG.setFont(fnt2);
//        OFR=new JMenuItem("Order From Retailer");
//        OFR.setFont(fnt2);
//        IOG=new JMenuItem("Issue Of Goods");
//        IOG.setFont(fnt2);
//        IOGC=new JMenuItem("Issue Of Goods Customer");
//        IOG.setFont(fnt2);
//        PV=new JMenuItem("Payment Voucher");
//        PV.setFont(fnt2);
//        RV=new JMenuItem("Receipt Voucher ");
//        RV.setFont(fnt2);
//
//
//        // summary report menu items begins
//        rCInfo=new JMenuItem("Company Information");
//        rCInfo.setFont(fnt2);
//        rPInfo=new JMenuItem("Product Information");
//        rPInfo.setFont(fnt2);
//        rRInfo=new JMenuItem("Retailer Information");
//        rRInfo.setFont(fnt2);
//        rOTC=new JMenuItem("Order To Company");
//        rOTC.setFont(fnt2);
//        rPOG=new JMenuItem("Purchase Of Goods");
//        rPOG.setFont(fnt2);
//        rOFR=new JMenuItem("Order From Retailer");
//        rOFR.setFont(fnt2);
//        rIOG=new JMenuItem("Issue Of Goods");
//        rIOG.setFont(fnt2);
//        rIOGC=new JMenuItem("Issue Of Goods Customer");
//        rIOG.setFont(fnt2);
//        rPV=new JMenuItem("Payment Voucher");
//        rPV.setFont(fnt2);
//        rRV=new JMenuItem("Receipt Voucher ");
//        rRV.setFont(fnt2);
//        // summary report menu items ends
//
//
//        //detail report menu items start
//
//
//        sPI_CN=new JMenuItem("Product Informstion (Company Name) ");
//        sOTC_CN=new JMenuItem("Order to Company (Company Name) ");
//        sOTC_PC=new JMenuItem("Order to Company (Product Code)");
//        sPOG_PuN=new JMenuItem(" Purchase Of Goods (Purchase Number)");
//        sPOG_PuD=new JMenuItem("Purchase of Goods (Purchase Date)");
//        sPOG_CN=new JMenuItem(" Purchase of Goods (Company Name) ");
//        sPOG_PC=new JMenuItem(" Purchase Of Goods (Product Code)");
//        sOFR_RN=new JMenuItem(" Order from Retailer (Retailer Name ");
//        sOFR_PC=new JMenuItem("Order from Retailer (Product Code  ");
//        sIOG_IN=new JMenuItem("Issue Of Goods (Invoice Number) ");
//        sIOG_ID=new JMenuItem(" Issue Of Goods (Invoice Date)");
//        sIOG_RN=new JMenuItem(" Issue Of Goods(Retaler Name ");
//        sIOG_PC=new JMenuItem("Issue Of Goods (Product Code  ");
//        sIOGC_IN=new JMenuItem("Issue Of Goods Customer (Invoice Number)");
//        sIOGC_ID=new JMenuItem("Issue Of Goods Customer (Invoice Date)  ");
//        sIOGC_CI=new JMenuItem("Issue Of Goods Customer (Customer Id)  ");
//        sIOGC_PC=new JMenuItem(" Issue Of Goods Customer (Product Code ) ");
//        sPV_CN=new JMenuItem("Payment Voucher (Companny Name) ");
//        sRV_RN=new JMenuItem(" Receipt Voucher (Retailer Name");
//
//        //detail report menu items end
//        yes.addActionListener(this);
//        CInfo.addActionListener(this);
//        PInfo.addActionListener(this);
//        RInfo.addActionListener(this);
//        OTC.addActionListener(this);
//        POG.addActionListener(this);
//        OFR.addActionListener(this);
//        IOG.addActionListener(this);
//        IOGC.addActionListener(this);
//        PV.addActionListener(this);
//        RV.addActionListener(this);
//
//        rCInfo.addActionListener(this);
//        rPInfo.addActionListener(this);
//        rRInfo.addActionListener(this);
//        rOTC.addActionListener(this);
//        rPOG.addActionListener(this);
//        rOFR.addActionListener(this);
//        rIOG.addActionListener(this);
//        rIOGC.addActionListener(this);
//        rPV.addActionListener(this);
//        rRV.addActionListener(this);
//
//
//        sPI_CN.addActionListener(this);
//        sOTC_CN.addActionListener(this);
//        sOTC_PC.addActionListener(this);
//        sPOG_PuN.addActionListener(this);
//        sPOG_PuD.addActionListener(this);
//        sPOG_CN.addActionListener(this);
//        sPOG_PC.addActionListener(this);
//        sOFR_RN.addActionListener(this);
//        sOFR_PC.addActionListener(this);
//        sIOG_IN.addActionListener(this);
//        sIOG_ID.addActionListener(this);
//        sIOG_RN.addActionListener(this);
//        sIOG_PC.addActionListener(this);
//        sIOGC_IN.addActionListener(this);
//        sIOGC_ID.addActionListener(this);
//        sIOGC_CI.addActionListener(this);
//        sIOGC_PC.addActionListener(this);
//        sPV_CN.addActionListener(this);
//        sRV_RN.addActionListener(this);
//
//
//
//
//        mast.add(CInfo);
//        mast.add(PInfo);
//        mast.add(RInfo);
//
//        mgnt.add(OTC);
//        mgnt.add(POG);
//        mgnt.add(OFR);
//        mgnt.add(IOG);
//        mgnt.add(IOGC);
//        mgnt.add(PV);
//        mgnt.add(RV);
//
//        srpt.add(rCInfo);
//        srpt.add(rPInfo);
//        srpt.add(rRInfo);
//        srpt.addSeparator();
//        srpt.add(rOTC);
//        srpt.add(rPOG);
//        srpt.add(rOFR);
//        srpt.add(rIOG);
//        srpt.add(rIOGC);
//        srpt.add(rPV);
//        srpt.add(rRV);
//
//
//
//
//        drpt.add(sPI_CN);
//        drpt.addSeparator();
//        drpt.add(sOTC_CN);
//        drpt.add(sOTC_PC);
//        drpt.addSeparator();
//        drpt.add(sPOG_PuN);
//        drpt.add(sPOG_PuN);
//        drpt.add(sPOG_PuD);
//        drpt.add(sPOG_CN);
//        drpt.add(sPOG_PC);
//        drpt.addSeparator();
//        drpt.add(sOFR_RN);
//        drpt.add(sOFR_PC);
//        drpt.addSeparator();
//        drpt.add(sIOGC_IN);
//        drpt.add(sIOGC_ID);
//        drpt.add(sIOGC_PC);
//        drpt.add(sIOGC_CI);
//        drpt.addSeparator();
//        drpt.add(sIOG_IN);
//        drpt.add(sIOG_ID);
//        drpt.add(sIOG_RN);
//        drpt.add(sIOG_PC);
//        drpt.addSeparator();
//        drpt.add(sPV_CN);
//        drpt.addSeparator();
//        drpt.add(sRV_RN);
//
//
//        help.add(UserMan);
//        help.add(Chpw);
//
//        quit.add(yes);
//        quit.add(no);
//
//
//        MBar.add(mast);
//        MBar.add(mgnt);
//        MBar.add(srpt);
//        MBar.add(drpt);
//        MBar.add(help);
//        MBar.add(quit);
//
//        f1.setLayout(bl);
//        f1.add(MBar,BorderLayout.NORTH);
//        f1.setSize(2000,1000);
//        f1.setVisible(true);
//    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==CInfo){
//            CompanyWin obj;
//            obj =new CompanyWin();
//        }
//
//        else if(ae.getSource()==PInfo){
//            ProductWin obj;
//            obj =new ProductWin();
//
//        }
//
//        else if(ae.getSource()==RInfo){
//            RetailerWin obj;
//            obj =new RetailerWin();
//
//        }
//
//        else if(ae.getSource()==POG){
//            PurchaseWin obj;
//            obj= new  PurchaseWin();
//
//        }
//
//        else if(ae.getSource()==IOG){
//            IssueOfGoodsWin obj;
//            obj= new  IssueOfGoodsWin();
//
//        }
//
//        else if(ae.getSource()==OTC){
//            OrderToWin obj;
//            obj =new OrderToWin();
//
//        }
//
//        else if(ae.getSource()==OFR){
//            OrderToRetailerWin obj;
//            obj =new OrderToRetailerWin();
//        }
//
//
//        else if(ae.getSource()==IOGC){
//            IssueOfGoodsCustomerWin obj;
//            obj= new  IssueOfGoodsCustomerWin();
//
//        }
//
//        else if(ae.getSource()==RV){
//            ReceiptVoucherWin obj;
//            obj =new ReceiptVoucherWin();
//
//        }
//
//        else if(ae.getSource()==PV){
//            PaymentVoucherWin obj;
//            obj =new PaymentVoucherWin();
//
//        }
//        //Summery Report
//
//        if(ae.getSource()==rCInfo){
//            CompanyRptWin obj;
//            obj =new  CompanyRptWin();
//        }
//
//        else if(ae.getSource()==rPInfo){
//            ProductRptWin obj;
//            obj =new  ProductRptWin();
//        }
//
//        else if(ae.getSource()==rRInfo){
//            RetailerRptWin obj;
//            obj =new  RetailerRptWin();
//
//        }
//
//        else if(ae.getSource()==rPOG){
//            PurchaseRptWin obj;
//            obj =new  PurchaseRptWin();
//
//        }
//
//        else if(ae.getSource()==rIOG){
//            IssueOfGoodsRptWin obj;
//            obj =new  IssueOfGoodsRptWin();
//
//        }
//
//        else if(ae.getSource()==rOTC){
//            OrderToCompanyRptWin obj;
//            obj =new  OrderToCompanyRptWin();
//
//        }
//
//        else if(ae.getSource()==rOFR){
//            OrderFromRetailerRptWin obj;
//            obj =new  OrderFromRetailerRptWin();
//        }
//
//
//        else if(ae.getSource()==rIOGC){
//            IssueOfGoodsCustomerRptWin obj;
//            obj =new  IssueOfGoodsCustomerRptWin();
//
//        }
//
//        else if(ae.getSource()==rRV){
//            ReceiptVoucherRptWin obj;
//            obj =new  ReceiptVoucherRptWin();
//        }
//
//        else if(ae.getSource()==rPV){
//            PaymentVoucherRptWin obj;
//            obj =new  PaymentVoucherRptWin();
//
//        }
//        //Detailed Report
//        else if(ae.getSource()==sPI_CN){
//
//
//        }
//        else if(ae.getSource()==sOTC_CN){
//
//
//        }
//        else if(ae.getSource()==sOTC_PC){
//
//
//        }
//        else if(ae.getSource()==sPOG_PuN){
//
//
//        }
//        else if(ae.getSource()==sPOG_PuD){
//
//
//        }
//        else if(ae.getSource()==sPOG_CN){
//
//
//        }
//        else if(ae.getSource()==sPOG_PC){
//
//
//        }
//        else if(ae.getSource()==sOFR_RN){
//
//
//        }
//        else if(ae.getSource()==sOFR_PC){
//
//
//        }
//        else if(ae.getSource()==sIOG_IN){
//
//
//        }
//        else if(ae.getSource()==sIOG_ID){
//
//
//        }
//        else if(ae.getSource()==sIOG_RN){
//
//
//        }
//        else if(ae.getSource()==sIOG_PC){
//
//
//        }
//        else if(ae.getSource()==sIOGC_IN){
//
//
//        }
//
//        else if(ae.getSource()==sIOGC_ID){
//
//
//        }
//        else if(ae.getSource()==sIOGC_CI){
//
//
//        }
//
//        else if(ae.getSource()==sIOGC_PC){
//
//
//        }
//        else if(ae.getSource()==sPV_CN){
//
//
//        }
//        else if(ae.getSource()==sRV_RN){
//
//
//        }
//        else if (ae.getSource()==yes) {
//            f1.setVisible(false);
//            f1.dispose();
//
//        }
//    }
//}
//
//public class MainApp {
//    public static void main(String []args){
//        MainWin obj;
//        obj= new  MainWin();
//    }
//}
