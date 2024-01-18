package com;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


import com.user.model.User;
import com.user.repository.UserRepository;

//to fix - failed to load application context error
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("haydenpoon28@gmail.com");
        user.setPassword("testpassword");
        user.setUsername("Hayden28");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        //assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

        assertEquals(user.getEmail(),existUser.getEmail());

        
    }
}