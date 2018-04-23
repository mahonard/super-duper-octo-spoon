import java.util.Scanner;
public class OfficeMgr extends LoginAccount
{
   public OfficeMgr(String loginType, String userName, String passWord, String firstName, String lastName, long phoneNum, String email)
   {
      super(loginType, userName, passWord, firstName, lastName, phoneNum, email);
   }
   
   Scanner scan = new Scanner(System.in);
   private String loginType = "officemgr";
   private String userName;
   private String passWord;
   private String firstName;
   private String lastName;
   private long phoneNum;
   private String email;
   
   public void setUserName(String userName)
   {
      this.userName = userName;
   }
   
   public void setPassWord(String passWord)
   {
      this.passWord = passWord;
   }
   
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }
   
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }
   
   public void setPhoneNum(long phoneNum)
   {
      this.phoneNum = phoneNum;
   }
   
   public void setEmail(String email)
   {
      this.email = email;
   }
   
   public String getUserName()
   {
      return userName;
   }
   
   public String getPassWord()
   {
      return passWord;
   }
   
   public String getFirstName()
   {
      return firstName;
   }
   
   public String getLastName()
   {
      return lastName;
   }
   
   public long getPhoneNum()
   {
      return phoneNum;
   }
   
   public String getEmail()
   {
      return email;
   }

   public void orderParts()
   {
	   
   }
   
   public String getUserType()
   {
	   return loginType;
   }
   
   public String viewInvoice()
   {
      return "";
   }
   
   public String createPaycheck()
   {
      return "";
   }
 
}