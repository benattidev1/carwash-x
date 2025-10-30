package com.benattidev.carwashx.modules.tenant.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "legal_name", nullable = false, length = 200)
    private String legalName;

    @Column(name = "trade_name", length = 200)
    private String tradeName;

    @Column(name = "tax_id", nullable = false, length = 20)
    private String taxId;

    @Column(name = "state_registration", length = 20)
    private String stateRegistration;

    @Column(name = "municipal_registration", length = 20)
    private String municipalRegistration;

    // conntact
    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "mobile_number", length = 20)
    private String mobileNumber;

    @Column(name = "website", length = 200)
    private String website;

    // address
    @Column(name = "address_postal_code", length = 10)
    private String postalCode;

    @Column(name = "address_street", length = 200)
    private String street;

    @Column(name = "address_number", length = 20)
    private String number;

    @Column(name = "address_complement", length = 100)
    private String complement;

    @Column(name = "address_neighborhood", length = 100)
    private String neighborhood;

    @Column(name = "address_city", length = 100)
    private String city;

    @Column(name = "address_state", length = 2)
    private String state;

    // audit
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt; // soft delete

}
