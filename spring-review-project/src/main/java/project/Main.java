package project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.config.SalaryConfig;
import project.service.SalaryService;

import java.io.ObjectInputFilter;

public class Main {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(SalaryConfig.class);

        SalaryService ss = container.getBean(SalaryService.class);

        ss.calculateRegularSalary();

    }
}
