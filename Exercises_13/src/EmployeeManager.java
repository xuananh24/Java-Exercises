import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entity.Employee;
import entity.Experience;
import entity.Fresher;
import entity.Intern;

public class EmployeeManager {
    private List<Employee> employees;
    
    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void add(Employee employee) {
        this.employees.add(employee);
    }

    public Employee findById(String id) {
        return employees.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
    }
    
    public boolean update(String id, Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                employees.set(i, employee);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(String id) {
        Employee employee = findById(id);
        if (employee != null) {
            this.employees.remove(employee);
            return true;
        }
        return false;
    }

    public List<Employee> findIntern() {
        return employees.stream().filter(o -> o instanceof Intern).collect(Collectors.toList());
    }

    public List<Employee> findExperience() {
        return employees.stream().filter(o -> o instanceof Experience).collect(Collectors.toList());
    }

    public List<Employee> findFresher() {
        return employees.stream().filter(o -> o instanceof Fresher).collect(Collectors.toList());
    }
}
