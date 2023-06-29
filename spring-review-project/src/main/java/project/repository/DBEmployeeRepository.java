package project.repository;

import project.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{

    @Override
    public int getHourlyRate() {
        Employee emp = new Employee("Steve", "IT", 23);

        return emp.getHourlyRate();
    }
}
