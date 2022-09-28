package hibernate_one_to_many.entity_for_BiDirection;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class EmployeeBi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "salary")
    private int salary;
//    @ManyToOne(cascade = {CascadeType.PERSIST,
//            CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE}) //for right delete objects. was not cascade delete
    @ManyToOne(cascade = CascadeType.ALL) //because employees is many, but department is single because foreign key is located at the table employees, this table called source table
    @JoinColumn(name = "department_id")
    DepartmentBi department;

    public EmployeeBi() {
    }

    public EmployeeBi(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DepartmentBi getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentBi department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
