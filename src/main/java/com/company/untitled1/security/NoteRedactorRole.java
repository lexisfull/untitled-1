package com.company.untitled1.security;

import com.company.untitled1.entity.Note;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "NoteRedactor", code = NoteRedactorRole.CODE)
public interface NoteRedactorRole {
    String CODE = "note-redactor";

    @EntityAttributePolicy(entityClass = Note.class, attributes = "id", action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = Note.class, attributes = {"owner", "name", "text"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Note.class, actions = EntityPolicyAction.ALL)
    void note();

    @MenuPolicy(menuIds = "Note.list")
    @ViewPolicy(viewIds = {"Note.list", "Note.detail", "User.detail"})
    void screens();
}