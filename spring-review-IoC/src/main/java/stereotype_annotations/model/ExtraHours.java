package stereotype_annotations.model;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ExtraHours {

    public int getHours(){
        return 10;
    }
}
