package com.benattidev.carwashx.modules.tenant.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tenants", indexes = {
        @Index(name = "idx_tenant_tax_id", columnList = "taxId")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {

    private UUID id;
    private String legalName;
    private String tradeName;
    private String taxId;
    private String stateRegistration;
    private String municipalRegistration;

    // conntact
    private String email;
    private String phoneNumber;
    private String mobileNumber;
    private String website;

    // address
    private String postalCode;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;

    // audit
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt; // soft delete

}
