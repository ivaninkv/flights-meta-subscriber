package com.github.ivaninkv.fms.repository;

import com.github.ivaninkv.fms.repository.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("Integrated test for User Repository")
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Sql(scripts = {"/sql/CLearUser.sql", "/sql/InsertUser.sql"})
    @Test
    public void shouldProperlyActiveUserCount() {
        List<User> users = userRepository.findAllByIsActiveTrue();
        Assertions.assertNotNull(users);
        Assertions.assertEquals(5, users.size());
    }

    @Sql(scripts = {"/sql/CLearUser.sql", "/sql/InsertUser.sql"})
    @Test
    public void shouldProperlyInActiveUserCount() {
        List<User> users = userRepository.findAllByIsActiveFalse();
        Assertions.assertNotNull(users);
        Assertions.assertEquals(1, users.size());
    }
}
