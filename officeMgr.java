import java.util.Scanner;
public class officeMgr extends LoginAccount{

      
   public officeMgr(String userName, String passWord, String firstName, String lastName, long phoneNum, String email){
      super(userName, passWord, firstName, lastName, phoneNum, email);
   }
   
   Scanner scan = new Scanner(System.in);
   private String userName;
   private String passWord;
   private String firstName;
   private String lastName;
   private long phoneNum;
   private String email;
   
   public void officeMgr(String userName, String passWord, String firstName, String lastName, long phoneNum, String email){
      this.userName = userName;
      this.passWord = passWord;
      this.firstName = firstName;
      this.lastName = lastName;
      this.phoneNum = phoneNum;
      this.email = email;
   }//end constuctor 
   
   
   
   public void setUserName(String userName){
      this.userName = userName;
   }//end setUserName
   
   public void setPassWord(String passWord){
      this.passWord = passWord;
   }//end setPassWord
   
   public void setFirstName(String firstName){
      this.firstName = firstName;
   }//setFirstName
   
   public void setLastName(String lastName){
      this.lastName = lastName;
   }//end setLastName
   
   public void setPhoneNum(long phoneNum){
      this.phoneNum = phoneNum;
   }//end setPhoneNum
   
   public void setEmail(String email){
      this.email = email;
   }//end setEmail
   
   public String getUserName(){
      return userName;
   }//end getUserName
   
   public String getPassWord(){
      return passWord;
   }//end getPassWord
   
   public String getFirstName(){
      return firstName;
   }//end getFirstName
   
   public String getLastName(){
      return lastName;
   }//end getLastName
   
   public long getPhoneNum(){
      return phoneNum;
   }//end getPhoneNum
   
   public String getEmail(){
      return email;
   }//end getEmail

   public void orderParts(){
     /******************
      for(int min : ){
       System.out.println();
       //search for less than min/qty
      }//end for/each loop
      return name;
      *****************/
   }//end orderParts

   public String viewInvoice(){
      
   }//end viewInvoice
   
   public String createPaycheck(){
   /************************************************************
       Scanner input = new Scanner( System.in);
          calcpayCheck salesAssociate = new calcPayCheck();

          String name = input.nextLine();
          salesAssociate.setsalesAssociate( name );

          System.out.print( "Enter how many days worked: " );
          int days = input.nextInt();

          System.out.print( "Enter hourly rate: " );
          double rate = input.nextInt();

          salesAssociate.calculatePay( hours, rate );
          salesAssociate.displaySalesAssociate();

          System.out.println();
    ************************************************************/
   }//end createPaycheck
 
}//end class