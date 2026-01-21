package Personalized_Meal_Plan_Generator_System;

// class for Vegan Meal implementing MealPlan interface
public class KetoMeal implements MealPlan {
    String userName;

    public KetoMeal(String userName) {
        this.userName = userName;
    }

    public void showPlan() {
        System.out.println(userName + "Keto Plan: Eggs + Chicken + Nuts");
    }
}

