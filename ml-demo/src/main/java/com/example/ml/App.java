package com.example.ml;

import smile.data.DataFrame;
import smile.data.formula.Formula;
import smile.data.vector.DoubleVector;
import smile.data.vector.IntVector;
import smile.regression.LinearModel;

public class App {

    public static void main(String[] args) {
        // Create a dataset
        int[] x = {1, 2, 3, 4, 5};
        double[] y = {2.0, 4.1, 6.1, 8.3, 10.4};

        // Build a DataFrame
        DataFrame data = DataFrame.of(
                IntVector.of("X", x),
                DoubleVector.of("Y", y)
        );

        // Display the dataset
        System.out.println("Dataset:");
        System.out.println(data);

        // Train a linear regression model
        LinearModel model = new LinearModel(
                Formula.lhs("Y"), // Define the target variable
                data.schema(), // Schema of the predictors
                data.select("X").toMatrix(), // Convert the predictor column to a matrix
                data.column("Y").toDoubleArray(), // Target column as an array
                new double[]{1.0}, // Initial weights
                0.0 // Initial intercept
        );

        // Display the model's coefficients
        System.out.println("\nModel Coefficients:");
        System.out.println("Intercept: " + model.intercept());
        System.out.println("Slope: " + model.coefficients()[0]);

        // Predict for a new value
        double prediction = model.predict(new double[]{6});
        System.out.println("\nPrediction for X=6: " + prediction);
    }
}
