package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Practice {
    public static void main(String[] args) {
//        createSectionAndCascadeFillingTwoTables();
//        createSectionWithoutCascadeALLHereWorkingCascadePersist();
//        persist();
        deleteSectionWithoutCascadeAll();
//        addChildToDBAndCascadeAddingSectionsAndDataToThirdTable_child_section();
//        getSectionFromDBAndCascadeGettingInfoAboutRelateChildren();
//        getChildAndCascadeGettingSections();
//        deleteSection();
    }

    private static void createSectionAndCascadeFillingTwoTables() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()){

            Section section1 = new Section("Football");
            Child child1 = new Child("Sergey", 5);
            Child child2 = new Child("Masha", 7);
            Child child3 = new Child("Vasya", 6);
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();
            session.save(section1);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

    private static void persist() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()){

            Section section1 = new Section("Dance");
            Child child1 = new Child("Olay", 12);
            Child child2 = new Child("Grisha", 8);
            Child child3 = new Child("Pavlic", 9);
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();
            session.persist(section1); //persist and save working by different
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

    private static void createSectionWithoutCascadeALLHereWorkingCascadePersist() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()){

            Section section1 = new Section("Football");
            Child child1 = new Child("Sergey", 5);
            Child child2 = new Child("Masha", 7);
            Child child3 = new Child("Vasya", 6);


            session.beginTransaction();
            session.save(section1);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.save(child1);
            session.save(child2);
            session.save(child3);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

    private static void addChildToDBAndCascadeAddingSectionsAndDataToThirdTable_child_section() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()){

            Section section1 = new Section("Volleyball");
            Section section2 = new Section("Chess");
            Section section3 = new Section("Math");
            Child child = new Child("Igor", 10);

            child.addSectionToChild(section1);
            child.addSectionToChild(section2);
            child.addSectionToChild(section3);

            session.beginTransaction();
            session.save(child);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

    private static void getSectionFromDBAndCascadeGettingInfoAboutRelateChildren() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()){

            session.beginTransaction();
            Section section = session.get(Section.class, 1);
            System.out.println(section);
            System.out.println(section.getChildren());
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

    private static void getChildAndCascadeGettingSections() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()){

            session.beginTransaction();
            Child child = session.get(Child.class, 4);
            System.out.println(child);
            System.out.println(child.getSections());
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

    private static void deleteSection() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()){

            session.beginTransaction();
            Section section = session.get(Section.class, 1);
            session.delete(section);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

    private static void deleteSectionWithoutCascadeAll() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()){

            session.beginTransaction();
            Section section = session.get(Section.class, 8);
            session.delete(section);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
