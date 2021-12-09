/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yu_ji
 */
public class Member {
    private String username;
    private String contactnumber;
    private String address;
    private String password;
    private int point=0;
   public void setUsername(String newUsername){
       this.username=newUsername;
   }
   public String getUsername(){
       return username;
   }
   public void setContactnumber(String newContactnumber){
       this.contactnumber=newContactnumber;
   }
   public String getContactnumber(){
       return contactnumber;
   }
   public void setAddress(String newAddress){
       this.address=newAddress;
   }
   public String getAddress(){
       return address; 
   }
   public void setPassword(String newPassword){
       this.password=newPassword;
   }
   public String getPassword(){
       return password;
   }
   public void addPoint(int addedPoint){
       point+=addedPoint;
   }
   public int getPoint(){
       return point;
   }
   
    
}
