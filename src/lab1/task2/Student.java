package lab1.task2;

public class Student {
    private String name;
    private Double grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
    //Y
}
