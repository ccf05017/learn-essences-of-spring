package moviebuddy.learningtest;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class CaffeineLearningTest {

   @DisplayName("카페인 기본 사용법")
   @Test
   void simpleTest() throws InterruptedException {
       Cache<String, Object> cache = Caffeine.newBuilder()
               .expireAfterWrite(200, TimeUnit.MILLISECONDS)
               .maximumSize(100)
               .build();

       String key = "springrunner";
       Object value = new Object();

       cache.put(key, value);
       Assertions.assertEquals(value, cache.getIfPresent(key));

       TimeUnit.MILLISECONDS.sleep(100);
       Assertions.assertEquals(value, cache.getIfPresent(key));

       TimeUnit.MILLISECONDS.sleep(100);
       Assertions.assertNull(cache.getIfPresent(key));
   }

}
