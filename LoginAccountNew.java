import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BikePartDatabase.BikePart;
import BikePartDatabase.Inventory;

public class LoginAccount
{
   private List<String> loginAccount; 
   private String userName;
   private String passWord;
   private String firstName;
   private String lastName;
   private long phoneNum;
   private String email;
   private String loginType;
   private String fileName;
   
   public LoginAccount(String userType, String userName, String passWord, String firstName, String lastName, long phoneNum, String email)
   {
	  loginAccount = new ArrayList<String>();
	  this.loginType = userType;
      this.userName = userName;
      this.passWord = passWord;
      this.firstName = firstName;
      this.lastName = lastName;
      this.phoneNum = phoneNum;
      this.email = email;
      fileName = userName + ".txt";
   }
   
   private void setLoginType(String loginType)
   {
	   this.loginType = loginType;
   }
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
   
   public String getLoginType()
   {
	   return loginType;
   }

   public String toString()
   {
		return "" + loginType + "," + firstName + "," + lastName + "," + userName + "," +  + phoneNum + "," + email;
   }
   
   public void loginAccountUpdate(String fileName) throws FileNotFoundException 
   {
	   Scanner readStuff = new Scanner(new File(fileName));
	   LoginAccount lA = new LoginAccount(null, null, null, null, null, 0, null);
		
	   while (readStuff.hasNextLine())
	   {
			String line = readStuff.nextLine();
			String[] parts = line.split(",");
			String type = parts[0];
			String username = parts[1];
			String password = parts[2];
			String firstName = parts[3];
			String lastName = parts[4];
			long phone = Long.parseLong(parts[5]);
			String email = parts[6];
			updateUser(type, username, password, firstName, lastName, phone, email);
	   }
   }
   
   public void saveUserFile(String fileName) 
	{
		PrintWriter writer = null;
		try
	    {
			writer = new PrintWriter(fileName, "UTF-8");
	        writer.println(getLoginType() + "," +
	                	   getUserName() + "," +
	                	   getPassWord() + "," +
	                	   getFirstName() + "," +
	                	   getLastName() + "," +
	                       getPhoneNum() + "," + 
	                       getEmail());
	    }
	 
		catch (IOException e) 
	    {
			System.out.println("file error!");
			e.printStackTrace();
	    }
		finally
		{
			if (writer != null)
	            writer.close();
		}
	}

   	private List<String> getUserInfo()
   	{
   		return loginAccount;
   	}
   	
   	public void laDBUpdate(String fileName) throws FileNotFoundException
   	{
   		Scanner readInfo = new Scanner(new File(fileName) + ".txt");
   		while (readInfo.hasNextLine())
   		{
   			String userName = readInfo.nextLine();
   			String[] names = userName.split("\n");
   			String userFile = names[0];
   			LoginAccount lA = new LoginAccount(null, userFile, null, null, null, 0, null);
   		}
   	}

	public void createLoginAccountFile(String fileName) 
		{
			new File(fileName);
			return;
		}
	private void updateUser(String userType, String userName, String passWord, String firstName, String lastName, long phoneNum, String email)
	{
		setLoginType(userType);
		setUserName(userName);
		setPassWord(passWord);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNum(phoneNum);
		setEmail(email);
	}
   
}