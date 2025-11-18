package com.waihon.designpatterns.mosh.abstractfactory.exercise;

public class BuildMuscleFactory implements GoalFactory {
    @Override
    public WorkoutPlan createWorkoutPlan() {
        return new BuildMuscleWorkoutPlan();
    }

    @Override
    public MealPlan createMealPlan() {
        return new BuildMuscleMealPlan();
    }
}
