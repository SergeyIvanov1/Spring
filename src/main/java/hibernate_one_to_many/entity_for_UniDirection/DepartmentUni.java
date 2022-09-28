package hibernate_one_to_many.entity_for_UniDirection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class DepartmentUni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //because foreign key is refers from the table employees, table department called target table
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "max_Salary")
    private int maxSalary;
    @Column(name = "min_Salary")
    private int minSalary;
//    @OneToMany(cascade = {CascadeType.PERSIST,
//            CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE}, mappedBy = "department") //for right delete objects. was not cascade delete
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private List<EmployeeUni> emps;

    public DepartmentUni() {
    }

    public DepartmentUni(String name, int maxSalary, int minSalary) {
        this.name = name;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public void addEmployeeToDepartment(EmployeeUni employee){
        if (emps == null){
            emps = new ArrayList<>();
        }
        emps.add(employee);
//        employee.setDepartment(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<EmployeeUni> getEmps() {
        return emps;
    }

    public void setEmps(List<EmployeeUni> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                '}';
    }
}
