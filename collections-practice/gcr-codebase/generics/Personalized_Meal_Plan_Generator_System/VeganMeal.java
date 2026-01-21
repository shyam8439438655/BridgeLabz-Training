package Personalized_Meal_Plan_Generator_System;

// class for Vegan Meal implementing MealPlan interface
public class VeganMeal implements MealPlan {
    String userName;

    public VeganMeal(String userName) {
        this.userName = userName;
    }

    public void showPlan() {
        System.out.println(userName + "Vegan Plan: Tofu + Chana + Fruits");
    }
}

