package akur.belajar.test;

import akur.belajar.test.resolver.RandomParameterResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
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

    @DisplayName("Test calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10})
    void testWithParameter(int value){
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }

    public static List<Integer> parameterSource(){
        return List.of(1,2,3,4,5);
    }

    @DisplayName("Test calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @MethodSource({"parameterSource"})
    void testWithMethodSource(Integer value){
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }
}
