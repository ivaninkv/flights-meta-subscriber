package com.github.ivaninkv.fms.repository;

import com.github.ivaninkv.fms.repository.entity.UserContact;
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
@DisplayName("Integrated test for UserContact Repository")
class UserContactRepositoryTest {
    @Autowired
    private UserContactRepository userContactRepository;

    @Sql(scripts = {"/sql/ClearUserContact.sql",
            "/sql/ClearUserContactType.sql",
            "/sql/CLearUser.sql",
            "/sql/InsertUser.sql",
            "/sql/InsertUserContactType.sql",
            "/sql/InsertUserContact.sql"})
    @Test
    public void shouldProperlyActiveUserContactCount() {
        List<UserContact> userContacts = userContactRepository.findAllByIsActiveTrue();
        Assertions.assertNotNull(userContacts);
        Assertions.assertEquals(5, userContacts.size());
    }

    @Sql(scripts = {"/sql/ClearUserContact.sql",
            "/sql/ClearUserContactType.sql",
            "/sql/CLearUser.sql",
            "/sql/InsertUser.sql",
            "/sql/InsertUserContactType.sql",
            "/sql/InsertUserContact.sql"})
    @Test
    public void shouldProperlyInActiveUserContactCount() {
        List<UserContact> userContacts = userContactRepository.findAllByIsActiveFalse();
        Assertions.assertNotNull(userContacts);
        Assertions.assertEquals(1, userContacts.size());
    }

}
