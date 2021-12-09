
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yu_ji
 */
import javax.swing.*;
import java.util.ArrayList;
public class Program {

    /**
     * @param args the command line arguments
     */
    public static String Password;
    public static String Username;
    public static ArrayList<Member> member=new ArrayList<Member>();
    public static int tempMember;
    public static ArrayList<Pizza> order=new ArrayList<Pizza>();
    public static int isMember=0;
    public static int count=0;
    public static int TotalPrice;
    public static String receipt;
    public static String Address;
    public static int enterManually=0;
    public static void main(String[] args) {
        
        member.add(new Member());
        Member a=member.get(0);
        a.setAddress("NO12,Jalan Jenawi,81800 Ulu Tiram");
        a.setUsername("admin");
        a.setPassword("admin");
        a.addPoint(5000);
        a.setContactnumber("011-11481639");
        MainMenu();
       
        
    }
    public static void MainMenu(){
         int member=JOptionPane.showConfirmDialog(null,"Member?","Pizza Ordering System",JOptionPane.YES_NO_OPTION);
         if(member==0){
            EnterUsername();
        }else if(member==-1){
            System.exit(0);
        }else if(member==1){
              JOptionPane.showMessageDialog(null, "Welcome guest.","Welcome", JOptionPane.QUESTION_MESSAGE);
            order.add(new Pizza());
            OrderMenu();
        }
    }
    public static void EnterUsername(){
         Username=JOptionPane.showInputDialog("Username?");
         if(Username==null){
             MainMenu();}
         else if (Username!=null){
             for(int a=0;a<member.size();a++){
             if(Username.equals(member.get(a).getUsername())){
                EnterPassword(member.get(a).getUsername(),member.get(a).getPassword());
                tempMember=a;
            }else{
        JOptionPane.showMessageDialog(null, "Invalid Username!Press ok to main menu.", "Error", JOptionPane.QUESTION_MESSAGE);
        MainMenu();
             }
          }
         }
         
    }
     public static void EnterPassword(String name,String passwords){
         JPasswordField pwd = new JPasswordField(10);
         int action = JOptionPane.showConfirmDialog(null, pwd,"Enter Password or 0 to go to mainmenu.",JOptionPane.OK_CANCEL_OPTION);
         String password=String.valueOf(pwd.getPassword());
         if(passwords.equals(password)){
             JOptionPane.showMessageDialog(null, "Welcome back "+name+" !", "Welcome", JOptionPane.QUESTION_MESSAGE);
             isMember=1;
             order.add(new Pizza());
             OrderMenu();
         }else if(password.equals("0")){
             MainMenu();
         }else{
             JOptionPane.showMessageDialog(null, "Wrong Password!" , "Error", JOptionPane.QUESTION_MESSAGE);
             MainMenu();
         }
         }
    
    public static void OrderMenu(){
        JDialog.setDefaultLookAndFeelDecorated(true);
    Object[] selectionValues = { "Small", "Medium", "Large" };
    String initialSelection = "Size";
    Object selection = JOptionPane.showInputDialog(null, "Size of pizza?",
        "Size selection", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
    if(selection==null){
        OrderMenu();
    }else {
            switch(selection.toString()){
                case"Small":
                    order.get(count).setSize(1);
                    addTopping();
                    break;
                case"Medium":
                    order.get(count).setSize(2);
                    addTopping();
                    break;
                case"Large":
                    order.get(count).setSize(3);
                    addTopping();
                    break;
                    
        }
     }
    }
    public static void addTopping(){
       String[]name={"Pepperoni","Sausage","Mushroom "};
       for(int a=0;a<name.length;a++){
       int member=JOptionPane.showConfirmDialog(null,"Add "+name[a]+"?","Pizza Ordering System",JOptionPane.YES_NO_OPTION);
       if(member==0){
           order.get(count).addTopping(a);
       }
       
       }
       
       TotalPrice+=order.get(count).getPrice();
       orderMore();
    }
    public static void orderMore(){
        int more=JOptionPane.showConfirmDialog(null,"Order more?","Pizza Ordering System",JOptionPane.YES_NO_OPTION);
       if(more==1){
           if(isMember==1){
           member.get(tempMember).addPoint(TotalPrice);
           
       }
           address();
       }
       else if(more==0){
           count++;
           order.add(new Pizza());
           OrderMenu();
       }else{
           orderMore();
       }
    }
    public static void address(){
        if(isMember==1){
            int defaultAddress=JOptionPane.showConfirmDialog(null,"Use default address "+member.get(tempMember).getAddress()+"?","Pizza Ordering System",JOptionPane.YES_NO_OPTION);
            System.out.print(defaultAddress);
            if(defaultAddress==-1){
                order.remove(count);
                count--;
                orderMore();
                 }else if(defaultAddress==0){
                     receipt();
                 }
            else if(defaultAddress==1){
                     enterManually=1;
                 }
        }else if(isMember==0){
            enterManually=1;
        }
        if(enterManually==1){
            enterAddress();
        }
    }
      public static void enterAddress(){
          
          Address=JOptionPane.showInputDialog("Address?");
          System.out.print(Address);
          if(Address==null){
              orderMore();
          }else {
             receipt();
                  
              }
          }
      public static void receipt(){
           if(isMember==1&&enterManually==0){
                  receipt="Receipt\n------------------\nUsername: "+member.get(tempMember).getUsername()+"\nTotal Points: "+member.get(tempMember).getPoint()+"(+"+TotalPrice+")\nTotal Prices: RM"+TotalPrice+"\nAddress: "+member.get(tempMember).getAddress()+"\nContact number:"+member.get(tempMember).getContactnumber();
            }else if(isMember==1&&enterManually==1){
                  receipt="Receipt\n------------------\nUsername: "+member.get(tempMember).getUsername()+"\nTotal Points: "+member.get(tempMember).getPoint()+"(+"+TotalPrice+")\nTotal Prices: RM"+TotalPrice+"\nAddress: "+Address+"\nContact number:"+member.get(tempMember).getContactnumber();
            }else if(isMember==0){
                receipt="Receipt\n------------------\nUsername :  Guest"+"\nTotal Prices: RM"+TotalPrice+"\nAddress: "+Address;  
            }
           JOptionPane.showMessageDialog(null, receipt, "Receipt", JOptionPane.QUESTION_MESSAGE);
                  receipt="";
                  isMember=0;
                  
                    MainMenu();
        }
 }


    



