package project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {

    String name;
    String department;
    int hourlyRate;
}
