package hibernate_one_to_many;

import hibernate_one_to_many.entity_for_BiDirection.DepartmentBi;
import hibernate_one_to_many.entity_for_BiDirection.EmployeeBi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirection {
    public static void main(String[] args) {
//        createDepartmentAndEmployeesAndAddToDB();
        getDepartmentAndAllEmployeesFromDB();
//        getEmployeeAndAutogetDepartmentFromDB();
    }

    private static void createDepartmentAndEmployeesAndAddToDB() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeBi.class)
                .addAnnotatedClass(DepartmentBi.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            DepartmentBi dep = new DepartmentBi("Sales", 800, 1500);
            EmployeeBi emp1 = new EmployeeBi("Sergey", "Ivanov", 800);
            EmployeeBi emp2 = new EmployeeBi("Elena", "Smirnova", 1500);
            EmployeeBi emp3 = new EmployeeBi("Anton", "Sidorov", 1200);

            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            dep.addEmployeeToDepartment(emp3);

            session.save(dep);

            session.getTransaction().commit();
        }
    }

    private static void getDepartmentAndAllEmployeesFromDB() {
        try (SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(EmployeeBi.class)
                    .addAnnotatedClass(DepartmentBi.class)
                    .buildSessionFactory();
                 Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            DepartmentBi department = session.get(DepartmentBi.class, 3);
            System.out.println(department);
            System.out.println(department.getEmps());
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }

    private static void getEmployeeAndAutogetDepartmentFromDB() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeBi.class)
                .addAnnotatedClass(DepartmentBi.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            EmployeeBi employee = session.get(EmployeeBi.class, 1);
            System.out.println(employee);
            System.out.println(employee.getDepartment());
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }

    private static void deleteEmployeeAndDepartmentFromDB() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeBi.class)
                .addAnnotatedClass(DepartmentBi.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            EmployeeBi employee = session.get(EmployeeBi.class, 1);
            session.delete(employee); //this code deletes employee from DB. But because cascade = CascadeType.ALL
            // inside Department and Employee, will be delete related string from DB departments and all strings employee,
            // what related with department

            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
