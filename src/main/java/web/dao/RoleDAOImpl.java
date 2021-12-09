package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDAOImpl implements RoleDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);

    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);

    }

    @Override
    public void removeRoleById(int id) {
        entityManager.remove(entityManager.find(Role.class, id));
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role findRoleByName(String roleName) {
        return  (Role) entityManager.createQuery("from Role r where r.name=:role")
                .setParameter("role", roleName)
                .getSingleResult();
    }

    @Override
    public HashSet getSetOfRoles(String[] rolesNames) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : rolesNames) {
            roleSet.add(findRoleByName(role));
        }
        return (HashSet) roleSet;
    }

}