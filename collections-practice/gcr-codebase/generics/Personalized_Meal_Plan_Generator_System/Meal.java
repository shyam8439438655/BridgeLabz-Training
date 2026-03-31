package Personalized_Meal_Plan_Generator_System;

// Generic Meal class
public class Meal<T extends MealPlan> {
    T plan;

    public Meal(T plan) {
        this.plan = plan;
    }

    public void showMeal() {
        plan.showPlan();
    }
}

