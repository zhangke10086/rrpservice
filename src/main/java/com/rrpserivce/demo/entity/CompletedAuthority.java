package com.rrpserivce.demo.entity;

import java.util.List;

public class CompletedAuthority {
    private List<RoleMenuOperation> authorityArray;
    private Role toAddRole;

    public List<RoleMenuOperation> getAuthorityArray() {
        return authorityArray;
    }

    public Role getToAddRole() {
        return toAddRole;
    }

    public void setAuthorityArray(List<RoleMenuOperation> authorityArray) {
        this.authorityArray = authorityArray;
    }

    public void setToAddRole(Role toAddRole) {
        this.toAddRole = toAddRole;
    }
}
