package Personalized_Meal_Plan_Generator_System;

// Meal Plan Main Class 
public class MealPlanMain {
    public static void main(String[] args) {

        Meal<VegetarianMeal> m1 = MealGenerator.generateMealPlan(new VegetarianMeal("Shyam"));
        Meal<VeganMeal> m2 = MealGenerator.generateMealPlan(new VeganMeal("Aman"));
        Meal<KetoMeal> m3 = MealGenerator.generateMealPlan(new KetoMeal("Neha"));
        Meal<HighProteinMeal> m4 = MealGenerator.generateMealPlan(new HighProteinMeal("Ravi"));

        m1.showMeal();
        m2.showMeal();
        m3.showMeal();
        m4.showMeal();
    }
}

