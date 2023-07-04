public class Candidate {
    private String id;
    private String name;
    private String address;
    private String priority;
    private Group group;

    public Candidate(String id, String name, String address, String priority, Group group) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.priority = priority;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "id:" + this.id
        + " name:" + this.name
        + " address:" + this.address
        + " priority:" + this.priority
        + " group:" + this.group + "-" + this.group.getSubjects();
    }
}
