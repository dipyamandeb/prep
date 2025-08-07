import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/list")
public class EmployeeController {

    @getMapping("/employeeHavingAnniversay")
    public List<Employee> getAllEmployees() {
        // Logic to retrieve all employees
        List<Employee> employeeList = new ArrayList<>();

        Employee employee = new Employee(1, "John Doe", new Date());
        employeeList.add(employee);
        Employee employee2 = new Employee(2, "John Doe2", Date.from(Instant.from(LocalDate.of(2023, Month.AUGUST, 1))));
        employeeList.add(employee2);
        Employee employee3 = new Employee(3, "John Doe3", Date.from(Instant.from(LocalDate.of(2023, Month.AUGUST, 1))));
        employeeList.add(employee3);

        CurrentDate currentDate = new CurrentDate();
        Month currentMonth = currentDate.getCurrentDate().getMonth();

        List<Employee>result = new ArrayList<>();

        for (Employee emp: employeeList)  {
            if (emp.getJoiningDate().getMonth() == currentMonth.getValue()) {
                result.add(emp);
            }
        }

    return result;

    }

    // Builder pattern
    //

}