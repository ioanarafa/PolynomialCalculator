package model;

import java.util.*;

public class Polynomial {
    //Stocam monoamele in ordine descrescatoare a gradului
    public TreeMap<Integer, Float> polyMap = new TreeMap<>(Collections.reverseOrder());
    public String text;

    public Polynomial() {

    }

    public void addTerm(float coefficient, int grad) {
        if (polyMap.containsKey(grad)) { //Daca gradul exista in polinom
            float existingCoefficient = polyMap.get(grad);
            float newCoefficient = existingCoefficient + coefficient;
            polyMap.put(grad, newCoefficient);
        }
        else { //Daca gradul nu exista in polinom
            polyMap.put(grad, coefficient);
        }
    }

    public String toString() {
        StringBuilder print = new StringBuilder(" ");
        for (Map.Entry<Integer, Float> entry : polyMap.entrySet()) {
            float coefficient = entry.getValue();
            int grad = entry.getKey();
            if (coefficient >= 0)
                print.append(" +").append(coefficient).append("x^").append(grad);
            else
                print.append(" ").append(coefficient).append("x^").append(grad);
        }
        return print.toString();
    }

    public void freeP() {
        polyMap.clear();
    }

    public void removeZeroCoefficients() {
        Iterator<Map.Entry<Integer, Float>> iterator = polyMap.entrySet().iterator(); //Facem un iterator pt a parcurge elem. din polyMap
        while (iterator.hasNext()) {
            Map.Entry<Integer, Float> entry = iterator.next();
            if (entry.getValue() == 0) { //Verificam daca coeficientul este 0
                iterator.remove();// Daca elem ii 0 il stergem din polyMap
            }
        }
    }
}