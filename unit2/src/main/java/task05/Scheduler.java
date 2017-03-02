package task05;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Anton on 02.03.2017.
 */

public interface Scheduler {

    static void addStudent(Student student, ArrayList<Number> studentMarks,
                           Discipline discipline, ArrayList<Group> groupsList){
        groupsList.stream()
                .filter(g -> g.getDiscipline().equals(discipline))
                .forEach(g -> g.addStudent(student, studentMarks));
    }

    static double getAverage(Student student, Discipline discipline,
                             ArrayList<Group> groupsList){
        return groupsList.stream()
                .filter(g -> g.getDiscipline().equals(discipline))
                .mapToDouble(g -> g.getAverageMark(student)).toArray()[0];
    }

    static HashMap<Discipline,Double> getAllAverages(Student student, ArrayList<Group> groupsList) {

        Set<Map.Entry<Discipline,Double>> entry =  groupsList.stream()
                .filter(g -> g.checkStudent(student))
                .collect(Collectors.toMap(
                        Group::getDiscipline,
                        g -> g.getAverageMark(student)
                        )
                ).entrySet();
        HashMap<Discipline,Double> hashMap = new HashMap<>();
        for (Map.Entry<Discipline,Double> e:
                entry) {
            hashMap.put(e.getKey(),e.getValue());
        }
        return hashMap;
    }
}
