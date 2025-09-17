package SuperMarket;

import java.sql.SQLException;

import static SuperMarket.Billing.*;

public class Product{
    public static void main(String[] args) throws SQLException {
        Billing[] masala = {
                new Billing(1, "Turmeric Powder", 30.00f),
                new Billing(2, "Red Chili Powder", 50.00f),
                new Billing(3, "Coriander Powder", 40.00f),
                new Billing(4, "Garam Masala", 60.00f),
                new Billing(5, "Cumin Seeds", 45.00f),
                new Billing(6, "Black Pepper", 80.00f),
                new Billing(7, "Cardamom", 120.00f)
        };

        Billing[] snack = {
                new Billing(8, "Potato Chips", 50.00f),
                new Billing(9, "Chocolate Bar", 40.00f),
                new Billing(10, "Cookies (Pack)", 60.00f),
                new Billing(11, "Popcorn (Small)", 30.00f),
                new Billing(12, "Nachos (Pack)", 70.00f),
                new Billing(13, "Instant Noodles", 45.00f),
                new Billing(14, "Energy Bar", 35.00f)
        };
        Billing[] milk = {
                new Billing(15, "Full Cream Milk (1L)", 60.00f),
                new Billing(16, "Toned Milk (1L)", 50.00f),
                new Billing(17, "Skimmed Milk (1L)", 45.00f),
                new Billing(18, "Butter (500g)", 250.00f),
                new Billing(19, "Cheese (200g)", 100.00f),
                new Billing(20, "Curd (500g)", 40.00f),
                new Billing(21, "ghee (200g)", 80.00f)

        };

        System.out.println("------------------WELCOME TO MK SUPERMARKET--------------------");
        System.out.println("Enter your User Name:");
        String str=sc.nextLine();

        getInp(masala, milk, snack,str);
    }

}
