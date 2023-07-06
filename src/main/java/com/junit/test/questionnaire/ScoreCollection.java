package com.junit.test.questionnaire;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ScoreCollection {
    private List<Scorable> scores = new ArrayList<>();

    public void add(Scorable scorable){
        scores.add(scorable);
    }

    public int arithmeticMean(){
        Stream<Scorable> stream = scores.stream();
        IntStream intStream = stream.mapToInt(Scorable::getScore);
        int total = intStream.sum();
        return total / scores.size();
    }
}
