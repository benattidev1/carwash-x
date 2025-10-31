package com.benattidev.carwashx.modules.tenant.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benattidev.carwashx.modules.tenant.domain.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, UUID> {

    Optional<Tenant> findByTaxId(String taxId);

    Optional<Tenant> findByEmail(String email);

}
