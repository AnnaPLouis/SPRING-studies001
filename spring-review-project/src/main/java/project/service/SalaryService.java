package project.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import project.repository.DBEmployeeRepository;
import project.repository.EmployeeRepository;
import project.repository.HoursRepository;
import project.repository.RegularHours;


@Component
public class SalaryService {

    private final EmployeeRepository employeeRepository;
    private final HoursRepository hoursRepository;

    public SalaryService(EmployeeRepository employeeRepository,@Qualifier("regularHours") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void  calculateRegularSalary(){
        System.out.println(employeeRepository.getHourlyRate()* hoursRepository.getHours());
    }
}
