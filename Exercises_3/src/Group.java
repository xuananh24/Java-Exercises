public enum Group {
    A("Toan-Ly-Hoa"),
    B("Toan-Hoa-Sinh"),
    C("Van-Su-Dia");

    private String subjects;
    private Group(String subjects) {
        this.subjects = subjects;
    }

    public String getSubjects() {
        return subjects;
    }
}
