package web.dao;

import web.model.Role;
import java.util.HashSet;
import java.util.List;

public interface RoleDAO {

    void saveRole(Role role);

    void updateRole(Role role);

    void removeRoleById(int id);

    List <Role> getAllRoles();

    Role findRoleByName(String name);

    HashSet<Role> getSetOfRoles(String[] roleSet);
}