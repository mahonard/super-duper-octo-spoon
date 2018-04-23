import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginAccountDataBase
{

    private List<LoginAccount> laDataBase = new ArrayList<LoginAccount>();

    public LoginAccount loginAccounttMain()
    {
        LoginAccount mainLA = new LoginAccount("mainLA");
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
        for (LoginAccount w : laDataBase)
        {
            laDB.add(w);
        }
        return laDB;
    }

    public String showAllLA()
    {
        String listLA = "";
        for (LoginAccount wh : laDataBase)
        {
            listLA += wh.getLoginAccountName() + "\n";
        }
        return listLA;
    }

    public LoginAccount addToLA(String laName) throws FileNotFoundException
    {
        LoginAccount newLA = new LoginAccount(laName);
        newLA.createLoginAccountFile(laName);
        laDataBase.add(newLA);
        return newLA;
    }

    public LoginAccount getLoginAccount(String laName)
    {
        LoginAccount w = new LoginAccount("");
        for (LoginAccount loginAccount : laDataBase)
        {
            if (loginAccount.getLoginAccountName().equals(laName))
            {
                lA = loginAccount;
            }
        }
        return lA;
    }

    public void readLoginAccountDB(String fileName) throws FileNotFoundException
    {
        Scanner readStuff = new Scanner(new File(fileName));
        String laName = "";

        if (readStuff.hasNextLine() == false)
        {
            return;
        }
        while (readStuff.hasNextLine())
        {
            laName = readStuff.nextLine();
            LoginAccount la = addToLA(laName);
            la.loginAccountUpdate(laName + ".txt");
        }
    }

    public void saveLoginAccountDB()
    {
        PrintWriter writer = null;
        try
        {
            File saveFile = new File("loginAccountDB.txt");
            writer = new PrintWriter(saveFile, "UTF-8");
            for (LoginAccount w : laDataBase)
            {
                writer.println(w.getLoginAccountName());
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
}