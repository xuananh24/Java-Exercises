import java.util.List;

public class Family {
    private String address;
    private List<Person> persons;
    
    public Family(String address, List<Person> persons) {
        this.address = address;
        this.persons = persons;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        StringBuilder infor = new StringBuilder("Address: " + address + "\n");
        persons.forEach(person -> {
            infor.append(person.toString() + "\n");
        });
        return infor.toString();
    }
    
    
}
