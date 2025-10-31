-- enable UUID extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE tenants (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

    -- company info
    legal_name VARCHAR(200) NOT NULL,
    trade_name VARCHAR(200),
    tax_id VARCHAR(20) NOT NULL,
    state_registration VARCHAR(20),
    municipal_registration VARCHAR(20),

    -- contact 
    email VARCHAR(150) NOT NULL,
    phone_number VARCHAR(20),
    mobile_number VARCHAR(20),
    website VARCHAR(200),

    -- address 
    address_postal_code VARCHAR(10),
    address_street VARCHAR(200),
    address_number VARCHAR(20),
    address_complement VARCHAR(100),
    address_neighborhood VARCHAR(100),
    address_city VARCHAR(100),
    address_state CHAR(2),

    -- audit 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

-- partial index to soft delete
-- only one active tenant with same tax_id or email
CREATE UNIQUE INDEX uk_tenants_tax_id_active ON tenants(tax_id)
    WHERE deleted_at IS NULL;

CREATE UNIQUE INDEX uk_tenants_email_active ON tenants(email)
    WHERE deleted_at IS NULL;

-- search indexes
CREATE INDEX idx_tenants_tax_id ON tenants(tax_id);
CREATE INDEX idx_tenants_deleted_at ON tenants(deleted_at) WHERE deleted_at IS NULL;
