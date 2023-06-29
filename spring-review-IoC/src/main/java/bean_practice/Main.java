package bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(Config.class,NewConfig.class);

        FullTimeEmployee ft = container.getBean(FullTimeEmployee.class);
        PartTimeEmployee pt = container.getBean(PartTimeEmployee.class);

        ft.createAccount();
        pt.createAccount();

        String wc = container.getBean("welcome",String.class);

        String pr = container.getBean("practice", String.class);

        System.out.println(wc);
        System.out.println(pr);





    }
}
