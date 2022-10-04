import model.Cart;
import model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();


        Cart cart1 = new Cart("20","cart 1");
        Cart cart2 = new Cart("25","cart 2");

        List<Cart> cartList = new ArrayList<>(Arrays.asList(cart1,cart2));

        Item item1 = new Item("10");
        Item item2 = new Item("10");

        List<Item> itemList = new ArrayList<>(Arrays.asList(item1,item2,new Item("11")));

        cart1.addItem(item1);
        cart1.addItem(item2);

        cart2.addItem(item1);

        item1.addCart(cart1);
        item1.addCart(cart2);

        item2.addCart(cart2);

//        session.save(cartList);
//        session.save(itemList);

        session.save(item1);
        session.save(item2);

        session.save(cart1);
        session.save(cart2);

        transaction.commit();
        session.close();





//        Query<Cart> query = session.createQuery("select с from Cart с", Cart.class);
//        List<Cart> resultList = query.getResultList();
//        resultList.forEach(System.out::println);
//
//        session.close();
    }

    public static Session getSession(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory.openSession();
    }


}
