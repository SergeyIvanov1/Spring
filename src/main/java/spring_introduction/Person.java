package spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//@Component("personBean")
public class Person {
//        @Autowired
//    @Qualifier("catBean ")
    private Pet pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;

    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }
    //    @Autowired
//    public Person(@Qualifier("dog")Pet pet) {
//        System.out.println("Person bean is created");
//        this.pet = pet;
//    }
//    public Person() {
//        System.out.println("Person bean is created");
//    }

    public Pet getPet() {
        return pet;
    }

    //    @Autowired
//    @Qualifier("catBean")
    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        System.out.println("Class Person: get age");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }
}
