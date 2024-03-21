package controller;
import model.Polynomial;
import java.util.Map;

public class Logic {
    public Polynomial additionPolynomial(Polynomial polinom1, Polynomial polinom2) {
        Polynomial rez = new Polynomial();

        // Adaugam termenii primului polinom la rezultat
        for (Map.Entry<Integer, Float> entry : polinom1.polyMap.entrySet())
            rez.polyMap.put(entry.getKey(), entry.getValue());

        //Adaugam termenii celui de-al doilea polinom la rezultat
        for (Map.Entry<Integer, Float> entry : polinom2.polyMap.entrySet()) {
            int grad = entry.getKey();
            float coef = entry.getValue();
            //Daca gradul exista deja în rezultat, adunam coeficientul
            if (rez.polyMap.containsKey(grad)) {
                float sum = rez.polyMap.get(grad) + coef;
                rez.polyMap.put(grad, sum);
            }
            else {
                rez.polyMap.put(grad, coef);
            }
        }
        return rez;

    }

    public Polynomial subtractionPolynomial(Polynomial polinom1, Polynomial polinom2) {
        Polynomial rez = new Polynomial();

        for (Map.Entry<Integer, Float> entry : polinom1.polyMap.entrySet())
            rez.polyMap.put(entry.getKey(), entry.getValue());

        for (Map.Entry<Integer, Float> entry : polinom2.polyMap.entrySet()) {
            int grad = entry.getKey();
            float coef = entry.getValue();
            if (rez.polyMap.containsKey(grad)) {
                float diff = rez.polyMap.get(grad) - coef;
                rez.polyMap.put(grad, diff);
            } else {
                rez.polyMap.put(grad, -coef);
            }
        }
        // Stegem termenii cu coeficienti zero
        rez.removeZeroCoefficients();
        return rez;
    }

    public Polynomial multiplicationPolynomial(Polynomial polinom1, Polynomial polinom2)
    {
        Polynomial rez = new Polynomial();
        // Inmulțim fiecare termen din primul polinom cu fiecare termen din al doilea polinom
        for (Map.Entry<Integer, Float> entry1 : polinom1.polyMap.entrySet()) {
            int grad1 = entry1.getKey();
            float coef1 = entry1.getValue();
            for (Map.Entry<Integer, Float> entry2 : polinom2.polyMap.entrySet()) {
                int grad2 = entry2.getKey();
                float coef2 = entry2.getValue();
                int newGrad = grad1 + grad2;
                float newCoef = coef1 * coef2;
                rez.addTerm(newCoef, newGrad);
            }
        }

        return rez;
    }

    public Polynomial divisionPolynomial(Polynomial polinom1, Polynomial polinom2) {
       return null;
    }

    public Polynomial derivativePolynomial(Polynomial polinom1)
    {
        Polynomial rez = new Polynomial();
        //Derivam fiecare termen din polinom
        for (Map.Entry<Integer, Float> entry : polinom1.polyMap.entrySet()) {
            int grad = entry.getKey();
            float coef = entry.getValue();

            //Verif. daca  gradul este mai mare decat 0 ca sa evitam monomul cu gradul 0
            if (grad > 0) {
                float newCoef = coef * grad;
                int newGrad = grad - 1;
                rez.addTerm(newCoef, newGrad);
            }
        }
        return rez;
    }

    public Polynomial integrationPolynomial(Polynomial polinom1)
    {
        Polynomial rez = new Polynomial();

        //Integram fiecare termen din polinom
        for (Map.Entry<Integer, Float> entry : polinom1.polyMap.entrySet()) {
            int grad = entry.getKey();
            float coef = entry.getValue();
            float newCoef = coef / (grad + 1);
            int newGrad = grad + 1;
            if (newCoef != 0) rez.addTerm(newCoef, newGrad );
        }
        return rez;
    }
}