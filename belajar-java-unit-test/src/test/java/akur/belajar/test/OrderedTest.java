package akur.belajar.test;

import org.junit.jupiter.api.*;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // bisa menggunakan before all dan after all tanpa static
//@TestMethodOrder(MethodOrderer.DisplayName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {
    private int counter = 0;

    @Test
    @Order(2)
    void test3() {
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(3)
    void test2() {
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(1)
    void test1() {
        counter++;
        System.out.println(counter);
    }
}
