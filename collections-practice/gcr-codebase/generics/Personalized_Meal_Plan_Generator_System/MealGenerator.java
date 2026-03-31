package Personalized_Meal_Plan_Generator_System;

// Meal Generator class
public class MealGenerator {

    // Generic method (validate + generate)
    public static <T extends MealPlan> Meal<T> generateMealPlan(T plan) {
        if (plan == null) {
            throw new IllegalArgumentException("Meal plan can't be null");
        }
        return new Meal<>(plan);
    }
}

