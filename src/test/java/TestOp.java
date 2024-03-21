import controller.Logic;
import model.Polynomial;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestOp {
    @Test
    public void testAddition() {
        Logic logic = new Logic();

        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial();
        poly1.addTerm(1, 3);
        poly1.addTerm(6, 2);
        poly2.addTerm(2, 3);

        Polynomial expectedResult = new Polynomial();
        expectedResult.addTerm(3, 3);
        expectedResult.addTerm(6, 2);

        Polynomial result = logic.additionPolynomial(poly1, poly2);

        assertEquals(expectedResult.toString(), result.toString());
    }

    @Test
    public void testSubtraction() {
        Logic logic = new Logic();

        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial();
        poly1.addTerm(2, 3);
        poly1.addTerm(1, 0);
        poly2.addTerm(2, 3);
        poly2.addTerm(3, 4);

        Polynomial expectedResult = new Polynomial();
        expectedResult.addTerm(1, 0);
        expectedResult.addTerm(-3, 4);

        Polynomial result = logic.subtractionPolynomial(poly1, poly2);

        assertEquals(expectedResult.toString(), result.toString());
    }

    @Test
    public void testMultiplication() {
        Logic logic = new Logic();

        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial();
        poly1.addTerm(1, 2);
        poly1.addTerm(-2, 3);
        poly2.addTerm(3, 2);

        Polynomial expectedResult = new Polynomial();
        expectedResult.addTerm(3, 4);
        expectedResult.addTerm(-6, 5);

        Polynomial result = logic.multiplicationPolynomial(poly1, poly2);

        assertEquals(expectedResult.toString(), result.toString());
    }

    @Test
    public void testDerivative() {
        Logic logic = new Logic();

        Polynomial poly = new Polynomial();
        poly.addTerm(1, 0);
        poly.addTerm(3, 4);
        poly.addTerm(2, 1);

        Polynomial expectedResult = new Polynomial();
        expectedResult.addTerm(2, 0);
        expectedResult.addTerm(12, 3);

        Polynomial result = logic.derivativePolynomial(poly);

        assertEquals(expectedResult.toString(), result.toString());
    }

    @Test
    public void testIntegration() {
        Logic logic = new Logic();

        Polynomial poly = new Polynomial();
        poly.addTerm(2, 1);
        poly.addTerm(9, 2);
        poly.addTerm(5, 1);

        Polynomial expectedResult = new Polynomial();
        expectedResult.addTerm(1, 2);
        expectedResult.addTerm(3, 3);
        expectedResult.addTerm(2.5F, 2);

        Polynomial result = logic.integrationPolynomial(poly);

        assertEquals(expectedResult.toString(), result.toString());
    }
}
