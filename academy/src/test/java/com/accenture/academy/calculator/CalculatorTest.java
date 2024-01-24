package com.accenture.academy.calculator;

import com.accenture.academy.calculator.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;
    @BeforeEach
   void prepareCalculatorForTest(){
        calculator = new Calculator();
    }
    @Test
  //  @DisplayName("When adding two numbers then correct result is returned")
    void whenAddTwoNumbersThenReturnTheirSum(){

        //Given (dane do testow np tworzymy obiekty)

        //When
        int result = calculator.add(2,3);
        //Then
        Assertions.assertEquals(5, result); // expected i porownujemy z resultem

    }
@Test
    void testAddingNumbersOutOfRange(){

        Assertions.assertThrows(IllegalArgumentException.class, ()-> calculator.add(101,101));
    }


    @Test
    void whenSubstractTwoNumbersThenReturnTheirSubstraction(){

        //When
        int result = calculator.substract(10,7);
        //Then
        Assertions.assertEquals(3, result); // expected i porownujemy z resultem

    }

    @Test
    void testSubstractNumbersOutOfRange(){

        Assertions.assertThrows(IllegalArgumentException.class, ()-> calculator.substract(101,99));
    }

    @Test
    void whenMultiplyTwoNumbersThenReturnTheirMultiplication(){

        //When
        int result = calculator.multiply(2,3);
        //Then
        Assertions.assertEquals(6, result); // expected i porownujemy z resultem

    }

    @Test
    void testMultiplyTwoNumbersOutOfRange(){

        Assertions.assertThrows(IllegalArgumentException.class, ()->calculator.multiply(40,0));

    }

    @Test
    void whenDivideTwoNumbersThenReturnTheirDivision(){

        //When
        int result = calculator.divide(12,3);
        //Then
        Assertions.assertEquals(4, result); // expected i porownujemy z resultem

    }

    @Test
    void testDivideByZero(){

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, ()->calculator.divide(12,0)); // executable lambda ktora nic nie przyjmuje ale zwraca

    }

    @Test
    void testDivideNumbersOutOfRange(){

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, ()->calculator.divide(0, -10)); // executable lambda ktora nic nie przyjmuje ale zwraca

    }

    @ParameterizedTest
    @CsvFileSource(resources = "calculator-parameterized-test-add.csv")
    void whenAddTwoNumbersThenReturnTheirSum_CsvFileParameter(int x, int y, int expected){

        Assertions.assertEquals(calculator.add(x,y),expected);
    }

    @ParameterizedTest
    @MethodSource("argumentsMethod")
    void whenAddTwoNumbersThenReturnTheirSum_MethodParameter(int x, int y, int expected){

        Assertions.assertEquals(calculator.add(x,y),expected);
    }

    private static Stream<Arguments> argumentsMethod(){
        return Stream.of(
                Arguments.of(2,3,5),
                Arguments.of(2,8,10),
                Arguments.of(2,7,9)
        );
    }

    @ParameterizedTest
    @CsvSource({"2,3,5","10,10,20"})
    void whenAddTwoNumbersThenReturnTheirSum_AnnotationParameter(int x, int y, int expected){

        Assertions.assertEquals(calculator.add(x,y),expected);
    }

}