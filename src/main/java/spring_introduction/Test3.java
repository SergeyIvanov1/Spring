package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("personID", Person.class);
        person.callYourPet();
        System.out.println(person.getAge());
        System.out.println(person.getPet());
        System.out.println(person.getSurname());
        context.close();
    }
}
