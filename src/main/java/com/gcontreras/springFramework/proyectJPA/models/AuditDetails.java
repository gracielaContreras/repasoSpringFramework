package com.gcontreras.springFramework.proyectJPA.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuditDetails {
    private String roleName;
    private String createdBy;

    public AuditDetails(String roleName, String createdBy){
        this.roleName = roleName;
        this.createdBy = createdBy;
    }
}
