package documentation.examples;

import java.util.function.Predicate;

import org.livingdoc.fixture.api.decisiontable.AfterRow;
import org.livingdoc.fixture.api.decisiontable.AfterTable;
import org.livingdoc.fixture.api.decisiontable.BeforeFirstCheck;
import org.livingdoc.fixture.api.decisiontable.BeforeRow;
import org.livingdoc.fixture.api.decisiontable.BeforeTable;
import org.livingdoc.fixture.api.decisiontable.Check;
import org.livingdoc.fixture.api.decisiontable.DecisionTableFixture;
import org.livingdoc.fixture.api.decisiontable.Input;


@DecisionTableFixture("Example")
@DecisionTableFixture({ "Beispiel", "Ejemplo" })
public class ExampleDecisionTableFixture {

    static Calculator sut;

    @BeforeTable
    static void beforeTable() {
        sut = new Calculator();
    }

    @BeforeRow
    void beforeRow() {

    }

    Long firstInput;

    @Input("second")
    @Input({ "zweiter", "segundo" })
    Long secondInput;

    @Input("first")
    @Input({ "erste", "primero" })
    void setFirstInput(Long value) {
        this.firstInput = value;
    }

    @BeforeFirstCheck
    void beforeFirstCheck() {

    }

    @Check("added?")
    @Check({ "addiert?", "adicional?" })
    void checkAddition(Predicate<Long> expectation) {
        long result = sut.add(firstInput, secondInput);
        //assertThat(result).as("actual: " + result).matches(expectation);
    }

    @AfterRow
    void afterRow() {

    }

    @AfterTable
    static void afterTable() {

    }

    private static class Calculator {

        long add(long a, long b) {
            return a + b;
        }

    }
}
