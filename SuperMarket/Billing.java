package SuperMarket;

import java.sql.*;


import java.util.*;


public class Billing {
    int id;
     String proName;
    float Price;
  static   Scanner sc=new Scanner(System.in);
    static ArrayList<Billing>list=new ArrayList<Billing>();
    public Billing(int id,String name,float price) {
        this.id = id;
        this.proName=name;
        this.Price=price;
    }
    public static void madisp(Billing[] arr){
        System.out.printf("%-5s | %-20s | %-8s%n","Id","Product","Price");
        System.out.println("---------------------------------------");
       for (Billing mas:arr){
           System.out.printf("%-5d | %-20s | %-8.2f%n",mas.id,mas.proName,mas.Price);
       }
    }

    public static void getInp(Billing[] masala,Billing[] mil,Billing[] sna,String name) throws SQLException {


        while (true){
            System.out.println("Here is the list of product......");
        System.out.printf("1.Masala Product\n2.Snacks Product\n3.Milk Product\n4.Show Chart\n5.Check out\n");
        System.out.println("Enter your Choices:");
        int num = sc.nextInt();
            switch (num) {
                case 1:
                    madisp(masala);
                    purchase(masala);
                    break;
                case 2:
                    madisp(sna);
                    purchase(sna);
                    break;
                case 3:
                    madisp(mil);
                    purchase(mil);
                    break;
                case 4:
                    if (!list.isEmpty()) {
                        disp(list);
                    }

                    break;
                case 5:
                    if (!list.isEmpty()) {
                        //count(list,masala,mil,sna);
                        dispbil(list, name);
                    }
                    return;
                default:
                    System.out.println("Please give valid number");
                    break;
            }
            }


    }


    public static void count(ArrayList<Billing> cart,Billing[] masala,Billing[] mil,Billing[] sna) {
        int masco = 0, milco = 0, snaco = 0;
        if (!cart.isEmpty()) {
            for (Billing item : cart) {
                for (Billing mas : masala) {
                    if (item.equals(mas)) {
                        masco++;
                    }
                }
                for (Billing milk : mil) {
                    if (item.equals(milk)) {
                        milco++;
                    }
                }
                for (Billing snack : sna) {
                    if (cart.contains(snack)) {
                        snaco++;
                    }
                }
            }

            System.out.println("Masala count" + masco);
            System.out.println("Milk count" + milco);
            System.out.println("snack" + snaco);
        }
    }

    public static void purchase(Billing[] pr) {
        while (true) {
            System.out.println("Enter the Product Id you want to purchase(0 for go back)");
            int nu = sc.nextInt();
            if (nu == 0) {
                System.out.println("************************************");
                System.out.println("Returning to Main menu");
                System.out.println("************************************");
                break;
            }

            for (Billing var : pr) {
                if (var.id == nu) {
                    list.add(var);

                    System.out.println("The product are add to the cart");
                }
            }
        }

    }
    public static void saveDb(String name,double gtotal,double total,int procount)throws SQLException {

            String url = "jdbc:mysql://localhost:3306/billing";
            String user = "root";
            String pass = "Muthu001";
            String query = "insert into bills (Username,Product_count,total_price,Grant_total)values (?,?,?,?);";
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setInt(2,procount);
            pst.setDouble(3,total);
            pst.setDouble(4,gtotal);
            pst.executeUpdate();

    }
    public static void disp(ArrayList<Billing> cart){
        System.out.println("*******************************************************");
        System.out.printf("%-5s | %-20s | %-8s%n","Id","Product","Price");
        System.out.println("-------------------------------------------------------");
        for(Billing bill:cart){
            System.out.printf("%-5d | %-20s | %-8.2f%n",bill.id,bill.proName,bill.Price);
        }
        System.out.println("*******************************************************");

    }
    public static void dispbil(ArrayList<Billing> cart,String name) throws SQLException {
        if(cart.isEmpty()){
            System.out.println("Your cart is Empty");
            return;
        }
        System.out.println("==================Mk Supermarket Bill==================");
        double total=0;
        System.out.printf("%-5s | %-20s | %-8s%n","Id","Product","Price");
        System.out.println("-------------------------------------------------------");
        for(Billing bill:cart){
            System.out.printf("%-5d | %-20s | %-8.2f%n",bill.id,bill.proName,bill.Price);
            total+=bill.Price;
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("Subtotal: ₹%-70.2f%n",total);
        double tax=total*0.05;
        System.out.printf("Tax(5%%): ₹%-70.2f%n",tax);
        System.out.println("-------------------------------------------------------");
       double grandtotal=total+tax;
        System.out.printf("Grandtotal: ₹%-70.2f%n",grandtotal);
        System.out.printf("Payment Mode: %-30s%n","Cash");
        System.out.println("--------------------------------------------------------");

        System.out.println("Thank you for Wisting us......:)");
        int procou=0;
        for (Billing item:cart){
            procou++;
        }
        //System.out.println(procou);
        saveDb(name,grandtotal,total,procou);

    }
}
