package lab1.task2;
import java.util.ArrayList;

public class JobMarket {
    public static void main(String[] args) {
        Student stud0 = new Student("Gigel", 5.7);
        Student stud1 = new Student("Dorel", 7.7);
        Student stud2 = new Student("Marcel", 9.7);
        Student stud3 = new Student("Ionel", 4.0);

        // equal case
        Student stud4 = new Student("James", 5.7);
        Student stud5 = new Student("James", 5.7);
        if (stud4.equals(stud5)) {
            System.out.println("Student is the same");
        }

        Student[] students = new Student[]{stud0, stud1, stud2, stud3};
        //more changes need to be done in Internshi.java to make arraylis work
//        ArrayList<Student> students = new ArrayList<>();
//        students.add(stud0);
//        students.add(stud1);
//        students.add(stud2);
//        students.add(stud3);

        Internship company1 = new Internship("Google", "8");
        Internship company2 = new Internship("Facebook", "9");
        Internship company3 = new Internship("Amazon", "7");
        Internship company4 = new Internship("Microsoft", "6");


        // Call the chooseCandidateRandomly method and print the result
        Student randomStudent = company1.chooseCandidateRandomly(students);

        System.out.println("Randomly selected student: " + randomStudent.getName());

        company1.chooseCandidatesForInterview(students, company1);
        company2.chooseCandidatesForInterview(students, company2);
        company3.chooseCandidatesForInterview(students, company3);
        company4.chooseCandidatesForInterview(students, company4);
    }
    //a
}
