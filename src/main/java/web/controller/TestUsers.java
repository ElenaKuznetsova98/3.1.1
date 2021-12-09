package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class TestUsers {

     private final UserService userService;
     private final RoleService roleService;

     @Autowired
     public TestUsers(UserService userService, RoleService roleService) {
          this.userService = userService;
          this.roleService = roleService;
     }

     @PostConstruct
     public void testUsers (){
          roleService.saveRole(new Role("ROLE_ADMIN"));
          roleService.saveRole(new Role("ROLE_USER"));

          Set <Role> roles1 = new HashSet<>();
          roles1.add(roleService.findRoleByName("ROLE_USER"));
          roles1.add(roleService.findRoleByName("ROLE_ADMIN"));

          User user = new User();
          user.setUsername("admin");
          user.setPassword("admin");
          user.setEmail("132@mail.ru");
          user.setRoles(roles1);
          userService.saveUser(user);

          Set<Role> roles2 = new HashSet<>();
          roles2.add(roleService.findRoleByName("ROLE_USER"));

          User user1 = new User();
          user1.setUsername("user");
          user1.setPassword("user");
          user1.setEmail("user@mail.ru");
          user1.setRoles(roles2);
          userService.saveUser(user1);

     }
}
