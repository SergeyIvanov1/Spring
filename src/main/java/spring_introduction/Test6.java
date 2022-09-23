package spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

//        Pet pet = context.getBean("catBean", Pet.class);
//        Pet pet2 = context.getBean("catBean", Pet.class);
//        pet.say();

        Person person = context.getBean("personBean", Person.class);

        person.callYourPet();

//        System.out.println(person);
//        System.out.println(person2);

        context.close();
    }
}
