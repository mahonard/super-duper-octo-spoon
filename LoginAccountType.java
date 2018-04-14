public class LoginAccountType extends LoginAccount{
    private String userName;
    private String passWord;
    public LoginAccountType(String userName, String passWord){
//has you log in then directs you to the proper account
        // ex: the sales associates get their options
        public void setUserName(String userName){
            this.userName = userName;           }
        public String getUserName(){
                return userName;   }

        public void setpassWord(String passWord){
            this.passWord = passWord;           }
        public String getpassWord(){
            return passWord;       }
//systemsAdmin
        public void createSalesAssociate()
        {
        }
        public void createWareHouseManager()
        {
        }
        public void createOffiveManager()
        {
        }
        public void resetPaycheck()
        {
        }
// salesAssociate
       System.out.println( "salesVanLoad" + salesVanLoad + "createInvoice" + createInvoice);
        public void salesVanLoad()
        {
        }
        public void createInvoice(String partName, double partPrice, int qty)
        {
        }
//wareHouseManager
        public void inventoryUpdate(String partName, double partPrice, int qty)
        {
        }
        public void examinePart(String name, int number, double price, double salesPrice, boolean onSale)
        {
        }
//officeManager
        public void examinePart()
        {
        }
        public void orderPart(String name, int number, double price, int qty)
        {
        }
        public void viewInvoice()
        {
        }
        public void createPaycheck()
        {
        }
    }