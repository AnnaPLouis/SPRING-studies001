package stereotype_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.config.Config;
import stereotype_annotations.model.DataStructure;
import stereotype_annotations.model.Microservice;

public class Main {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(Config.class);

        DataStructure ds = container.getBean(DataStructure.class);
        Microservice ms = container.getBean(Microservice.class);

        ds.getTotalHours();
        ms.getTotalHours();


    }
}
