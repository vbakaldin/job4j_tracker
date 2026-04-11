package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0.0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum = sum + subject.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0.0;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                sum = sum + subject.score();
                count++;
            }
            labels.add(new Label(pupil.name(), sum / count));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> scores = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scores.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue +  subject.score());
            }
        }

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            labels.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }

        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0.0;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                sum = sum + subject.score();
                count++;
            }
            labels.add(new Label(pupil.name(), sum));
        }
        Collections.sort(labels, Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> scores = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scores.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue +  subject.score());
            }
        }

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            labels.add(new Label(entry.getKey(), entry.getValue()));
        }

        Collections.sort(labels, Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}