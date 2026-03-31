package Personalized_Meal_Plan_Generator_System;

// class for Vegetarian Meal implementing MealPlan interface
public class VegetarianMeal implements MealPlan {
    String userName;

    public VegetarianMeal(String userName) {
        this.userName = userName;
    }

    public void showPlan() {
        System.out.println(userName + "Vegetarian Plan: Paneer + Dal + Salad");
    }
}

