package net.microservices.course.springboot;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

import net.microservices.course.springboot.service.UserServiceImpl;

public class LombokTest {

    @Test
    void shouldGenerateConstructor() {
        assertThat(UserServiceImpl.class.getConstructors().length).isGreaterThan(0);
    }
}
