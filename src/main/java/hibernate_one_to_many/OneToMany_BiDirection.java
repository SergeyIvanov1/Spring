package hibernate_one_to_many;

import hibernate_one_to_many.entity.Department;
import hibernate_one_to_many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToMany_BiDirection {
    public static void main(String[] args) {
//        createDepartmentAndEmployeesAndAddToDB();
//        getDepartmentAndAllEmployeesFromDB();
        getEmployeeAndAutogetDepartmentFromDB();
    }

    private static void createDepartmentAndEmployeesAndAddToDB() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            Department dep = new Department("IT", 300, 1200);
            Employee emp1 = new Employee("Sergey", "Ivanov", 800);
            Employee emp2 = new Employee("Elena", "Smirnova", 1000);

            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);

            session.save(dep);

            session.getTransaction().commit();
        }
    }

    private static void getDepartmentAndAllEmployeesFromDB() {
        try (SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Department.class)
                    .buildSessionFactory();
                 Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            Department department = session.get(Department.class, 1);
            System.out.println(department);
            System.out.println(department.getEmps());
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }

    private static void getEmployeeAndAutogetDepartmentFromDB() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee);
            System.out.println(employee.getDepartment());
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }

    private static void deleteEmployeeAndDepartmentFromDB() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            session.delete(employee); //this code deletes employee from DB. But because cascade = CascadeType.ALL
            // inside Department and Employee, will be delete related string from DB departments and all strings employee,
            // what related with department

            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
