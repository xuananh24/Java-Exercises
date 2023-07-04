public class Student {
    private String name;
    private int age;
    private String homeTown;
    private String clazz;
    
    public Student(String name, int age, String homeTown, String clazz) {
        this.name = name;
        this.age = age;
        this.homeTown = homeTown;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", homeTown=" + homeTown + ", clazz=" + clazz + "]";
    }
    
}
