package com.github.ivaninkv.fms.repository;

import com.github.ivaninkv.fms.repository.entity.UserContactType;
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
@DisplayName("Integrated test for UserContactType Repository")
class UserContactTypeRepositoryTest {
    @Autowired
    private UserContactTypeRepository userContactTypeRepository;

    @Sql(scripts = {"/sql/ClearUserContactType.sql", "/sql/InsertUserContactType.sql"})
    @Test
    public void shouldProperlyActiveUserContactTypeCount() {
        List<UserContactType> userContactTypes = userContactTypeRepository.findAllByIsActiveTrue();
        Assertions.assertNotNull(userContactTypes);
        Assertions.assertEquals(4, userContactTypes.size());
    }

    @Sql(scripts = {"/sql/ClearUserContactType.sql", "/sql/InsertUserContactType.sql"})
    @Test
    public void shouldProperlyInActiveUserContactTypeCount() {
        List<UserContactType> userContactTypes = userContactTypeRepository.findAllByIsActiveFalse();
        Assertions.assertNotNull(userContactTypes);
        Assertions.assertEquals(1, userContactTypes.size());
    }
}
