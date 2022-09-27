package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOne_UniDirection {
    public static void main(String[] args) {

//        try (SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Employee.class)
//                .addAnnotatedClass(Detail.class)
//                .buildSessionFactory();
//             Session session = factory.getCurrentSession()) {
//
//            Employee employee = new Employee("Sergey", "Ivanov", "IT", 500);
//            Detail detail = new Detail("Samara", "89631651511", "email@mail.ru");
//            employee.setEmpDetail(detail); //assignment details to employee
//
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit();
//
//            System.out.println("Done!");
//        }

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {


            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee.getEmpDetail()); //getting details through employee. Because OneToOne
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
