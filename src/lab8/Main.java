package lab8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskId = scanner.nextInt();
        scanner.close();

        /* Do not modify */
        Student s1 = new Student("Maria", "Popescu", 3L, 8.5);
        Student s2 = new Student("Ion", "Grigorescu", 2L, 8.0);
        Student s3 = new Student("Ana", "Enescu", 7L, 7.0);
        Student s4 = new Student("Mihai", "Eminovici", 1L, 4.45);
        Student s5 = new Student("Andrei", "Radu", 12L, 2.0);

        List<Student> students = new ArrayList<>(List.of(s1, s2, s3, s4, s5));
        List<Student> copyStudents = new ArrayList<>(students);
        List<Student> anotherCopyStudents = new ArrayList<>(students);

        List<Integer> numbers = List.of(10, 20, 5, 243, 5556, 312, 566, 245, 122, 5556, 5, 10, 20, 122);
        ArrayList<String> subjects = new ArrayList<>(List.of("PP", "PA", "PCOM", "IOCLA", "AA",
                "SO", "CPL", "EP", "RL", "LFA"));
        Random random = new Random(12);
        /* End of unmodifiable zone */

        switch (taskId) {
            /* ------------------------- Task 1 ------------------------- */
            /* --------- Sort using Comparable<Student> interface ------- */
            case 1:
                Collections.sort(students);
                System.out.println(students);
                break;
            /* ------------------------- Task 2 ------------------------- */
            /* -------------- Sort using a lambda expression ------------ */
            case 2:
                copyStudents.sort((Student::compareTo));
                System.out.println(copyStudents);
                break;
            /* ------------------------- Task 3 ------------------------- */
            /* ----------- Implement your priority queue here ----------- */
            /* --------------- Use Comparator.comparing() --------------- */
            case 3:
                PriorityQueue<Student> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(student -> student.id));
                priorityQueue.addAll(anotherCopyStudents);
                System.out.println(priorityQueue);
                break;
            /* ------------------------- Task 4 ------------------------- */
            case 4:
                Map<Student, LinkedList<String>> studentMap = new HashMap<>();
                students.forEach(s -> studentMap.putIfAbsent(s, new LinkedList<>()));
                /*----Add 4 random elements from subjects array in each LinkedList ----*/
                /*
                 * As index use the previously declared random object and use subjects.size() as
                 * your
                 * bound. Use addFirst() method to add elements in the LinkedList
                 */
                for (Student student : students) {
                    LinkedList<String> subjectList = studentMap.get(student);
                    for (int i = 0; i < 4; i++) {
                        String randomSubject = subjects.get(random.nextInt(subjects.size()));
                        subjectList.addFirst(randomSubject);
                    }
                }
                System.out.println(studentMap);
                break;
            /* ------------------------- Task 5 ------------------------- */
            /* ------------- No need to add or modify here -------------- */
            case 5:
                System.out.println(numbers);
                LinkedEvenSet linked = new LinkedEvenSet();
                linked.addAll(numbers);

                EvenSet set = new EvenSet();
                set.addAll(numbers);

                TreeEvenSet tree = new TreeEvenSet();
                tree.addAll(numbers);

                System.out.println(linked);
                System.out.println(set);
                System.out.println(tree);
            default:
                break;
        }

    }
}

class Student implements Comparable<Student> {
    /* ------------------------- Task 1 ------------------------- */
    /* Add student properties */
    /* Generate getters and setters */
    public String name;
    public String surname;
    public Long id;
    public Double averageGrade;

    public Student(String name, String surname, Long id, Double averageGrade) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public int compareTo(Student o) {
        if (this.averageGrade > o.averageGrade) {
            return 1;
        } else if (this.averageGrade < o.averageGrade) {
            return -1;
        } else {
            int surnameCompare = this.surname.compareTo(o.surname);
            if (surnameCompare != 0) {
                return surnameCompare;
            } else {
                return this.name.compareTo(o.name);
            }
        }
    }


    @Override
    public String toString() {
        return "Student {name=" + name + ", surname=" + surname + ", id=" + id + ", averageGrade=" + averageGrade + "}";
    }

    /* ------------------------- Task 4 ------------------------- */
    /* Override `equals` and `hashCode` methods */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class EvenSet extends HashSet<Integer> {
    /* Task 5 - Make it that it only accepts even Integers */
    @Override
    public boolean add(Integer number) {
        if (number % 2 == 0) {
            return super.add(number);
        }
        return false;
    }
}

class LinkedEvenSet extends LinkedHashSet<Integer> {
    /* Task 5 - Make it that it only accepts even Integers */
    @Override
    public boolean add(Integer number) {
        if (number % 2 == 0) {
            return super.add(number);
        }
        return false;
    }
}

class TreeEvenSet extends TreeSet<Integer> {
    /* Task 5 - Make it that it only accepts even Integers */
    @Override
    public boolean add(Integer number) {
        if (number % 2 == 0) {
            return super.add(number);
        }
        return false;
    }
}