import org.graalvm.compiler.lir.CompositeValue;

import java.time.Month;
import java.util.Date;

public class Employee {
    int employeeId;
    String name;
    public Date joiningDate;


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Employee(int employeeId, String name, Date joiningDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.joiningDate = new Date(); // Default to current date
    }
}
