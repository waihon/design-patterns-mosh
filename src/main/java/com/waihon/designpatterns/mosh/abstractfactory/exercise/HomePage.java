package com.waihon.designpatterns.mosh.abstractfactory.exercise;

public class HomePage {
    public void setGoal(GoalFactory factory) {
        factory.createWorkoutPlan().follow();
        factory.createMealPlan().follow();
    }
}
