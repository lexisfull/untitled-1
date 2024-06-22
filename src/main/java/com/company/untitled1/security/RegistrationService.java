package com.company.untitled1.security;

import com.company.untitled1.entity.User;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.security.role.assignment.RoleAssignmentRoleType;
import io.jmix.securitydata.entity.RoleAssignmentEntity;
import org.springframework.stereotype.Component;

@Component
public class RegistrationService {

    private final UnconstrainedDataManager unconstrainedDataManager;


    public RegistrationService(UnconstrainedDataManager unconstrainedDataManager) {
        this.unconstrainedDataManager = unconstrainedDataManager;
    }

    public void register(User user) {
        RoleAssignmentEntity roleAssignment = unconstrainedDataManager.create(RoleAssignmentEntity.class);
        roleAssignment.setUsername(user.getUsername());
        roleAssignment.setRoleCode(MinimalRedactorRole.CODE);
        roleAssignment.setRoleType(RoleAssignmentRoleType.RESOURCE);

        unconstrainedDataManager.save(user, roleAssignment);

    }
}
