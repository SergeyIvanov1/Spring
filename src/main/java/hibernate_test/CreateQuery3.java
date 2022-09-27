package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CreateQuery3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

//            session.beginTransaction();
//            List<Employee> emps = session.createQuery("from Employee").getResultList();

            session.beginTransaction();
            List<Employee> emps = session.createQuery("from Employee where name = 'Sergey' and salary > 450").getResultList();
            for (Employee employee: emps) {
                System.out.println(employee);
            }
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }



    }
}
