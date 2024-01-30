package akur.belajar.test;

import akur.belajar.test.resolver.RandomParameterResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;

import java.util.Random;

//@Extensions({
//        @ExtendWith(RandomParameterResolver.class)
//})
public class RandomCalculatorTest extends ParentCalculatorTest {
    @Test
    void testRandom(Random random, TestInfo info){
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test random calculator")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    void testRandomRepeat(Random random, TestInfo info){
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test random calculator")
    @RepeatedTest(value = 10, name = "{displayName}")
    void testRandomRepeatInfo(Random random, TestInfo info, RepetitionInfo repetitionInfo){
        System.out.printf("%s ke %s dari %s\n", info.getDisplayName(), repetitionInfo.getCurrentRepetition(), repetitionInfo.getTotalRepetitions());

        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }
}
