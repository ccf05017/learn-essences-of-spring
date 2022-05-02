package moviebuddy.learningtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

class PropertiesTest {

    @DisplayName("스프링 프로퍼티 파일을 어떻게 쓰는지 학습하는 테스트")
    @Test
    void loadPropertiesTest() throws IOException {
        Properties config = new Properties();
        config.load(Files.newInputStream(Path.of("./src/test/resources/config.properties")));

        Assertions.assertEquals(config.size(), 1);
        Assertions.assertEquals(config.get("name"), "poppo");
    }

}
