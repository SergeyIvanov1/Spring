package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOne_BiDirection {
    public static void main(String[] args) {

//        createAndSaveObjects();
//        getObjectsFromDataBase();
//        deleteObjectFromDataBase();
        deleteDetailObjWithoutDeletingEmployee();
    }

    private static void deleteObjectFromDataBase(){
        try (SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Detail.class)
                    .buildSessionFactory();
                Session session = factory.getCurrentSession()){


            session.beginTransaction();
            Employee employee = session.get(Employee.class, 4);
            session.delete(employee);
            session.getTransaction().commit();

        }
    }

    private static void deleteDetailObjWithoutDeletingEmployee(){
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()){

// here changed CascadeType from All to Persist and Refresh. Here Cascade.Delete is not exist
            session.beginTransaction();
            Detail detail = session.get(Detail.class, 1);
            detail.getEmployee().setEmpDetail(null); //at first destroy relationship between detail and employee.
            //otherwise will be exception because MuSQL don't give to delete object together with relationship
            session.delete(detail);
            session.getTransaction().commit();

        }
    }

    public static void getObjectsFromDataBase(){
        try (SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Detail.class)
                    .buildSessionFactory();
                Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            Detail detail = session.get(Detail.class, 4);
            System.out.println(detail.getEmployee());
            session.getTransaction().commit();
            System.out.println("Done!");
        }


    }

    private static void createAndSaveObjects() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession()){

            Employee employee = new Employee("Nikolay", "Ivanov", "HR", 850);
            Detail detail = new Detail("new York", "9698498", "Nikolay@gmail.com");
            employee.setEmpDetail(detail); //need save detail to employee
            detail.setEmployee(employee); //and to save employee to the detail, otherwise "details_id" will be null

            session.beginTransaction();
            session.save(detail);
            session.getTransaction().commit();
        }
    }
}
