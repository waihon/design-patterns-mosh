package com.waihon.designpatterns.mosh.abstractfactory.exercise;

public class WeightLossFactory implements GoalFactory {
    @Override
    public WorkoutPlan createWorkoutPlan() {
        return new WeightLossWorkoutPlan();
    }

    @Override
    public MealPlan createMealPlan() {
        return new WeightLossMealPlan();
    }
}
