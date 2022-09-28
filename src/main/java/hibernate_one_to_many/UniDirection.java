package hibernate_one_to_many;

import hibernate_one_to_many.entity_for_UniDirection.DepartmentUni;
import hibernate_one_to_many.entity_for_UniDirection.EmployeeUni;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UniDirection {
    public static void main(String[] args) {
//        addDepartmetToDBAndCascadeAddingEmployees();
//        getEmployeesThroughGettingDepartment();
        deleteDepartamentAndCascadeWillDeleteEmployees();
//        deleteEmployees();
    }

    private static void addDepartmetToDBAndCascadeAddingEmployees() {
        try(SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(DepartmentUni.class)
                .addAnnotatedClass(EmployeeUni.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession()){

            DepartmentUni dep = new DepartmentUni("HR", 500, 1500);
            EmployeeUni emp1 = new EmployeeUni("Oleg", "Ivanov", 800);
            EmployeeUni emp2 = new EmployeeUni("Andrey", "Sydorov", 1000);

            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);

            session.beginTransaction();
            session.save(dep);
            session.getTransaction().commit();
        }
    }

    private static void getEmployeesThroughGettingDepartment() {
        try(SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(DepartmentUni.class)
                .addAnnotatedClass(EmployeeUni.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession()){


            session.beginTransaction();
            DepartmentUni departmentUni = session.get(DepartmentUni.class, 1);
            System.out.println(departmentUni);
            System.out.println(departmentUni.getEmps());
            session.getTransaction().commit();
        }
    }

    private static void deleteDepartamentAndCascadeWillDeleteEmployees() {
        try(SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(DepartmentUni.class)
                .addAnnotatedClass(EmployeeUni.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession()){

            session.beginTransaction();
            DepartmentUni departmentUni = session.get(DepartmentUni.class, 1);
            session.delete(departmentUni);
            session.getTransaction().commit();
        }
    }

    private static void deleteEmployees() {
        try(SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(DepartmentUni.class)
                .addAnnotatedClass(EmployeeUni.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession()){

            session.beginTransaction();
            EmployeeUni employeeUni = session.get(EmployeeUni.class, 2);
            session.delete(employeeUni);
            session.getTransaction().commit();
        }
    }
}
