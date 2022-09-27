package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Update4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 1);
//            emp.setSalary(1500); //changing salary

            session.createQuery("update Employee set salary = 1000 where name = 'Oleg'")
                    .executeUpdate(); // UPDATE ALL Olegs salary on 1000
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }



    }
}
