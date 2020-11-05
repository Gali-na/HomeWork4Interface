import java.util.Arrays;
import java.util.Comparator;

public class SortingGroup {
    public static Group sortSurname(Group groupForSort) {
        Comparator<Student> comparato = new StudentSurnameComparator();
        Arrays.sort(groupForSort.getGroup(), comparato);
        return groupForSort;
    }

    public static Group sortName(Group groupForSort) {
        Comparator<Student> comparato = new StudentNameComparator();
        Arrays.sort(groupForSort.getGroup(), comparato);
        return groupForSort;
    }

    public static Group sortAge(Group groupForSort) {
        Comparator<Student> comparator = new StudentAgeComparator();
        Arrays.sort(groupForSort.getGroup(), comparator);
        return groupForSort;
    }

    public static Group sortAcademicPerformance(Group groupForSort) {
        Comparator<Student> comparator = new StudentAcademicPerformanceComperator();
        Arrays.sort(groupForSort.getGroup(), comparator);
        return groupForSort;
    }

    public static Group sortScholarship(Group groupForSort) {
        Comparator<Student> comparator = new StudentAcademicPerformanceComperator();
        Arrays.sort(groupForSort.getGroup(), comparator);
        return groupForSort;
    }
}
