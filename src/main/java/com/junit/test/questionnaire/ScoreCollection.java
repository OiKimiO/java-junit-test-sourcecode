package com.junit.test.questionnaire;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ScoreCollection {
    private List<Scoreable> scores = new ArrayList<>();

    public void add(Scoreable scorable){
        scores.add(scorable);
    }

    public int arithmeticMean(){
        Stream<Scoreable> stream = scores.stream();
        IntStream intStream = stream.mapToInt(Scoreable::getScore);
        int total = intStream.sum();
        return total / scores.size();
    }
}
