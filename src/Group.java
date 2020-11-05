import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Group implements MilitaryСommissar {
    private Student[] group = new Student[10];

    public Group(Student[] group, String groupName) {

        this.group = group;
    }

    public Group() {

    }

    public Student[] getGroup() {

        return group;
    }

    public void setGroup(Student[] group) {

        this.group = group;
    }

    public void addStudent(Student student) throws MyException {
        for (int i = 0; i < this.group.length; i++) {
            if (this.group[i] == null) {
                this.group[i] = student;
                return;
            }
        }
        throw new MyException("Exceeded the maximum number of students");
    }

    public void removeStudent(Student student) {
        for (int i = 0; i < this.getGroup().length; i++) {
            if (this.getGroup()[i].getAcademicPerformance() == (student.getAcademicPerformance())
                    && this.getGroup()[i].getAge() == student.getAge()
                    && this.getGroup()[i].getName().equalsIgnoreCase(student.getName())
                    && this.getGroup()[i].getSurname().equalsIgnoreCase(student.getSurname())
                    && this.getGroup()[i].getScholarship() == student.getScholarship()) {
                this.getGroup()[i] = null;
                return;
            }
        }
    }

    public void searchStudent(String surname) {
        List<Student> foundStudent = new ArrayList<>();
        for (int i = 0; i < this.group.length; i++) {
            if (this.group[i] != null) {
                if (this.group[i].getSurname().equalsIgnoreCase(surname)) {
                    foundStudent.add(this.group[i]);
                }
            }
        }
        if (foundStudent.isEmpty()) {
            System.out.println("There is no student with the specified surname in the grouper");
            return;
        }
        for (Student student : foundStudent) {
            System.out.println(student.toString());
        }
    }

    @Override
    public String toString() {
        Comparator<Student> comparato = new StudentSurnameComparator().thenComparing(new StudentNameComparator());
        Arrays.sort(this.group, comparato);
        String rezult = "";
        for (int i = 0; i < this.group.length; i++) {

            if (this.group[i] == null) {
                continue;
            } else {
                rezult = rezult + this.group[i].toString() + "\n";
            }
        }
        return rezult;
    }

    @Override
    public Student[] potentialSoldiers() {
        Student[] studentsForArmy = new Student[1];
        for (int i = 0; i < this.group.length; i++) {

            if (this.group[i] == null) {
                continue;
            }
            if (this.group[i].getAge() > 18 && this.group[i].getGender() == "man") {
                if (studentsForArmy.length == 1 && studentsForArmy[0] == null) {
                    studentsForArmy[0] = this.group[i];
                } else {
                    Student[] foundStudentTemp = Arrays.copyOf(studentsForArmy, studentsForArmy.length + 1);
                    foundStudentTemp[foundStudentTemp.length - 1] = this.group[i];
                    studentsForArmy = Arrays.copyOf(foundStudentTemp, foundStudentTemp.length);
                }
            }
        }
        return studentsForArmy;
    }
}
