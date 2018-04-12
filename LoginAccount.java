public class LoginAccount{
   private String userName;
   private String passWord;
   private String firstName;
   private String lastName;
   private long phoneNum;
   private String email;
   
   public LoginAccount(String userName, String passWord, String firstName, String lastName, long phoneNum, String email){
      this.userName = userName;
      this.passWord = passWord;
      this.firstName = firstName;
      this.lastName = lastName;
      this.phoneNum = phoneNum;
      this.email = email;
   }//end constuctor 
   
   public void setUserName(String userName){
      this.userName = userName;
   }
   
   public void setPassWord(String passWord){
      this.passWord = passWord;
   }
   
   public void setFirstName(String firstName){
      this.firstName = firstName;
   }
   
   public void setLastName(String lastName){
      this.lastName = lastName;
   }
   
   public void setPhoneNum(long phoneNum){
      this.phoneNum = phoneNum;
   }
   
   public void setEmail(String email){
      this.email = email;
   }
   
   public String getUserName(){
      return userName;
   }
   
   public String getPassWord(){
      return passWord;
   }
   
   public String getFirstName(){
      return firstName;
   }
   
   public String getLastName(){
      return lastName;
   }
   
   public long getPhoneNum(){
      return phoneNum;
   }
   
   public String getEmail(){
      return email;
   }
   
   public String toString()
	{
		return firstName + " " + lastName + ", " + userName + ", " +  + phoneNum + "; " + email;
	}
   
}