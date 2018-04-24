import java.util.Scanner;
import java.io.FileNotFoundException;
// login and personal info for each whmanager
public class WareHouseManager extends LoginAccount {

   public WareHouseManager(String userType, String userName, String passWord, String firstName, String lastName, long phoneNum, String email) {
      super(userType, userName, passWord, firstName, lastName, phoneNum, email);
   }

   Scanner scan = new Scanner(System.in);
   private String userType = "";
   private String userName = "";
   private String passWord = "";
   private String firstName;
   private String lastName;
   private String email;
   private long phoneNum;

   public void setUserType(String userType) {
      this.userType = userType;
   }

   public String getUserType() {
      return userType;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getUserName() {
      return userName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setPassWord(String passWord) {
      this.passWord = passWord;
   }

   public String getPassWord() {
      return passWord;
   }

   public void setEmail(String email) {
      this.email = email;
   }
   public String getEmail() {
      return email;
   }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }
    public long getPhoneNum() {
        return phoneNum;
    } //remember to add L after the number so that it recognizes it as a long
}

  /* public void orderParts()   {

   }


   public String viewInvoice()   {
      return "";
   }

   public String createPaycheck()   {
      return "";
   }

}
  */