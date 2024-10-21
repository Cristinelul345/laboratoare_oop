package lab1.task2;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Internship {
    private String name;
    private String minGrade;

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String getMinGrade() {
        return minGrade;
    }

    public void setMinGrade(String minGrade) {
        this.minGrade = minGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Student[] students = new Student[3];
    Random random = new Random();


    public Internship(String name, String minGrade) {
        this.name = name;
        this.minGrade = minGrade;
    }


    public Student chooseCandidateRandomly(Student[] listStuds) {
        // Generate a random index
        int randomIndex = random.nextInt(listStuds.length);

        // Return the student at the random index
        return listStuds[randomIndex];
    }

    public Internship chooseCandidatesForInterview(Student[] listStuds, Internship internship) {
        for (int i = 0; i < listStuds.length; i++) {
            if( listStuds[i].getGrade() >= Double.parseDouble(internship.getMinGrade()) ) {
                System.out.println("Candidate: " +  listStuds[i].getName() + " got a phone interview at " + internship.getName());
            }
        }
        return null;
    }
    //a
}
