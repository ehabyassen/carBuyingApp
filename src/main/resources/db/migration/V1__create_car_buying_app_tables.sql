-- ============================================
-- Car Buying App – H2 Compatible Flyway Script
-- ============================================

-- ==============================
-- 1. CUSTOMER REQUESTS TABLE
-- ==============================
CREATE TABLE IF NOT EXISTS customer_requests (
    id                   BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id          BIGINT         NOT NULL,
    status               VARCHAR(50)    NOT NULL DEFAULT 'ACTIVE',
    description          CLOB,
    checked_by_company   VARCHAR(50)    NOT NULL,

    created_at           TIMESTAMP      DEFAULT CURRENT_TIMESTAMP(),
    updated_at           TIMESTAMP      DEFAULT CURRENT_TIMESTAMP()
);

-- Index for filtering by status (scale requirement)
CREATE INDEX IF NOT EXISTS idx_customer_requests_status
    ON customer_requests (status);

-- Index for customer-based queries
CREATE INDEX IF NOT EXISTS idx_customer_requests_customer
    ON customer_requests (customer_id);



-- ==============================
-- 2. SUPPLIER OFFERS TABLE
-- ==============================
CREATE TABLE IF NOT EXISTS supplier_offers (
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    supplier_id        BIGINT       NOT NULL,
    request_id         BIGINT       NOT NULL,
    status             VARCHAR(50)  NOT NULL DEFAULT 'PENDING',

    car_details        CLOB,
    price              DECIMAL(12,2) NOT NULL,
    inspection_score   INTEGER,

    created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    updated_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),

    -- Foreign key to customer_requests table
    CONSTRAINT fk_offer_request
        FOREIGN KEY (request_id)
        REFERENCES customer_requests(id)
        ON DELETE CASCADE,

    -- Ensure one offer per supplier per request
    CONSTRAINT uq_supplier_offer UNIQUE (supplier_id, request_id)
);

-- Index for fetching offers by request
CREATE INDEX IF NOT EXISTS idx_offers_request
    ON supplier_offers (request_id);

-- Index for fetching all offers from a supplier
CREATE INDEX IF NOT EXISTS idx_offers_supplier
    ON supplier_offers (supplier_id);

-- Index for status-based filtering
CREATE INDEX IF NOT EXISTS idx_offers_status
    ON supplier_offers (status);
