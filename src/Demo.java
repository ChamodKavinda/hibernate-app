import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        //saveCustomer();
        //getAllCustomers();
        //getCustomer(1);
        //deleteCustomerById(1);
        //deleteCustomerByObject(2);
        //updateCustomer();

    }

    private static void updateCustomer() {
        Customer c1 = new Customer(2L,"Nimal","Colombo",20000);

        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(c1);
        transaction.commit();
        session.close();
    }

    private static void deleteCustomerById(long id) {

        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE Customer WHERE customer_id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
    }

    private static void deleteCustomerByObject(long id) {

        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(Customer.class, id));
        transaction.commit();
    }

    private static void getCustomer(long id) {

        Session session =HibernateUtil.openSession();

        Customer customer = session.get(Customer.class, id);
        System.out.println(customer);
    }

    private static void getAllCustomers() {
        Customer c1 = new Customer(2L,"Bandara","Panadura",40000);

        Session session = HibernateUtil.openSession();
        Query query = session.createQuery("FROM Customer");
        List list = query.list();
        System.out.println(list);

    }

    public static void saveCustomer(){
        Customer c1 = new Customer(3L,"Bandara","Panadura",40000);

        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(c1);
        transaction.commit();
        session.close();

    }

}
