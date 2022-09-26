package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        Dog dog = context.getBean("myPet", Dog.class);
        Dog dog2 = context.getBean("myPet", Dog.class);

        System.out.println(dog2);
        System.out.println(dog);

        context.close();
    }
}
