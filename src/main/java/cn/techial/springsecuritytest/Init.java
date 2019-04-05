package cn.techial.springsecuritytest;

import cn.techial.springsecuritytest.dao.UserRepository;
import cn.techial.springsecuritytest.domain.Role;
import cn.techial.springsecuritytest.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author techial
 */
@Component
@Slf4j
public class Init implements CommandLineRunner {

    private final UserRepository userRepository;

    public Init(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0L) {
            log.info(userRepository.save(new User().setUsername("admin").setPassword("{noop}admin").setRoles(Collections.singleton(Role.ADMIN))).toString());
        }
        log.info("init success");
    }

}