package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveDataToBase {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Sergey", "Ivanov", "IT", 500);
            session.beginTransaction();
            session.save(emp); //hibernate here create sql code (insert) data to the base
            session.getTransaction().commit();
        } finally {
            factory.close();
        }



    }
}
