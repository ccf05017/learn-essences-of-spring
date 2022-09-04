package moviebuddy.learningtest;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionLearningTest {

    // 솔직히 실습을 위해서 쓰는 것
    // Reflection은 대단히 위험하기 때문에 이렇게 마구 사용하지 않는 걸 권장
    @Test
    void reflectionTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Normal type of using Java code
        Duck duck = new Duck();
        duck.quack();

        Class<?> duckClass = Class.forName("moviebuddy.learningtest.ReflectionLearningTest$Duck");
        Object duckObject = duckClass.getDeclaredConstructor().newInstance();
        Method quackMethod = duckObject.getClass().getDeclaredMethod("quack", new Class<?>[0]);
        quackMethod.invoke(duckObject);
    }

    static class Duck {
        void quack() {
            System.out.println("Quack!");
        }
    }

}
