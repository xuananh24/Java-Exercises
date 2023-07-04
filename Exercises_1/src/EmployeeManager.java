import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManager {
    private List<Employee> listEmployees;

    public EmployeeManager() {
        this.listEmployees = new ArrayList<>();
    }

    public List<Employee> getListEmployees() {
        return listEmployees;
    }

    public void setListEmployees(List<Employee> listEmployees) {
        this.listEmployees = listEmployees;
    }

    public void addEmployee(Employee employee) {
        listEmployees.add(employee);
    } 

    public List<Employee> searchByName(String name) {
        return listEmployees.stream().filter(employee -> employee.getName().equals(name)).collect(Collectors.toList());
    }

    public void showInfor() {
        listEmployees.forEach(employee -> System.out.println(employee.toString()));
    }
}
