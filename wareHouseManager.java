import java.util.Scanner;
public class wareHouseManager {
    private String userName = "";
    private String passWord = "";
    public String name;
    public int number;
    public double price;
    public double salesPrice;
    public boolean onSale;
    Scanner scnr = new java.util.Scanner(System.in);

    public wareHouseManager(String name, int number, double price, double salesPrice, boolean onSale) {
        this.name = name;
        this.number = number;
        this.price = price;
        this.salesPrice = salesPrice;
        this.onSale = onSale;
    }

    public String getName() {
        return name;        }
    public void setName(String name) {
        this.name = name;            }

    public int getNumber() {
        return number;     }
    public void setNumber(int number) {
        this.number = number;         }

    public double getPrice() {
        return price;        }
    public void setPrice(double price) {
        this.price = price;            }

    public double getSalesPrice() {
        return salesPrice;        }
    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;            }

    public boolean isOnSale() {
        return onSale;    }
    public void setOnSale(boolean onSale) {
        this.onSale = onSale;    }

    public void inventoryUpdate(String partName, double partPrice, int qty)
    {
    }

    public void examinePart(String name, int number, double price, double salesPrice, boolean onSale)
    {
    }
}