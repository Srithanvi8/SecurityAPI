package org.form.security.service;
import org.form.security.dao.repo.RoleRepository;
import org.form.security.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Optional<Role> findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
