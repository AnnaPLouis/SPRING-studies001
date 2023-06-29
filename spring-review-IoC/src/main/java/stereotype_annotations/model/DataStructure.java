package stereotype_annotations.model;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor //or @Data
public class DataStructure {


    private final ExtraHours xtra;  // dependency insert (needed for the method)

    public void getTotalHours(){

        System.out.println("Total hours: "+(20+ xtra.getHours()));

    }


}
