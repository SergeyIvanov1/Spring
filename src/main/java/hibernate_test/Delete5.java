package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();
            /*Employee emp = session.get(Employee.class, 1);
            session.delete(emp); //delete specified obj*/

            session.createQuery("delete Employee where name = 'Oleg'").executeUpdate(); //delete all strings inside
                // table, where name == Oleg. If delete Employee, when will delete all string
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }



    }
}
