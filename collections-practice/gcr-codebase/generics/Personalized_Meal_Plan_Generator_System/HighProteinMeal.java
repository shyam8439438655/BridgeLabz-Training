package Personalized_Meal_Plan_Generator_System;

// class for High-Protein Meal implementing MealPlan interface
public class HighProteinMeal implements MealPlan {
    String userName;

    public HighProteinMeal(String userName) {
        this.userName = userName;
    }

    public void showPlan() {
        System.out.println(userName + "High-Protein Plan: Soya + Milk + Sprouts");
    }
}

