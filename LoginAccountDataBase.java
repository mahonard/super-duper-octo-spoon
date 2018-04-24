import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BikePartDatabase.WareHouse;

public class LoginAccountDataBase
{
    private List<LoginAccount> laDataBase = new ArrayList<LoginAccount>();
    
    public LoginAccount loginAccountMain()
    {
        LoginAccount mainLA = new LoginAccount("sysadmin", "admin", "nimad", "Default", "User", 123456789, "admin@bpwh.com");
        laDataBase.add(mainLA);
        return mainLA;
    }

    public List<LoginAccount> getLADB()
    {
        return laDataBase;
    }

    public ArrayList<LoginAccount> getAllLA()
    {
        ArrayList<LoginAccount> laDB = new ArrayList<LoginAccount>();
        for (LoginAccount lA : laDataBase)
        {
            laDB.add(lA);
        }
        return laDB;
    }

    public String showAllLA()
    {
        String listLA = "";
        for (LoginAccount wh : laDataBase)
        {
            listLA += wh.getUserName() + "\n";
        }
        return listLA;
    }

    public LoginAccount addToLA(String userType, String userName, String passWord, String firstName, String lastName, long phoneNum, String email) throws FileNotFoundException
    {
        LoginAccount newLA = new LoginAccount(userType, userName, passWord, firstName, lastName, phoneNum, email);
        newLA.createLoginAccountFile(userName);
        laDataBase.add(newLA);
        return newLA;
    }

    public LoginAccount getLoginAccount(String laName)
    {
        LoginAccount lA = new LoginAccount(null, null, null, null, null, 0, null);
        for (LoginAccount loginAccount : laDataBase)
        {
            if (loginAccount.getUserName().equals(laName))
            {
                lA = loginAccount;
            }
        }
        return lA;
    }

    public void readLoginAccountDB(String fileName) throws FileNotFoundException
    {
        Scanner readStuff = new Scanner(new File(fileName));
        String userName = "admin";

        if (readStuff.hasNextLine() == false)
        {
            return;
        }
        while (readStuff.hasNextLine())
        {
            userName = readStuff.nextLine();
            LoginAccount la = addToLA("usertype", userName, "password", "firstname", "lastname", 0, "email");
            la.loginAccountUpdate(userName + ".txt");
        }
    }

    public void saveLoginAccountDB()
    {
        PrintWriter writer = null;
        try
        {
            File saveFile = new File("loginAccountDB.txt");
            writer = new PrintWriter(saveFile, "UTF-8");
            for (LoginAccount lA : laDataBase)
            {
                writer.println(lA.getUserName());
            }
        }
        catch (IOException e)
        {
            System.out.println("file error!");
            e.printStackTrace();
        }
        finally
        {
            if (writer != null)
            {
                writer.close();
            }
        }
    }

	public List<LoginAccount> removeAccount(String userName) {
		
		LoginAccount lA = getLoginAccount(userName);
		laDataBase.remove(lA);
		return laDataBase;
	}
}