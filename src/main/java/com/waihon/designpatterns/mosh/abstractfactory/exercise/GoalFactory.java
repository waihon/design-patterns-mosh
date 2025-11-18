package com.waihon.designpatterns.mosh.abstractfactory.exercise;

public interface GoalFactory {
    WorkoutPlan createWorkoutPlan();
    MealPlan createMealPlan();
}
