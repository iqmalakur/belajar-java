package akur.belajar.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test untuk Calculator class")
public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("Test skenario sukses untuk method add(integer, integer)")
    public void testAddSuccess(){
        var result = calculator.add(10, 10);

//        if (result != 20) {
//            throw new RuntimeException("Test gagal");
//        }

        assertEquals(20, result);
    }

    @Test
    public void testDivideSuccess(){
        var result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDivideFailed(){
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

}
