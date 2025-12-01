-- ===========================================
-- V2: Initial Demo Data for Car Buying App
-- ===========================================

-- =============
-- Customer Requests
-- =============

INSERT INTO customer_requests (
    customer_id,
    status,
    description,
    checked_by_company,
    created_at,
    updated_at
) VALUES
(101, 'ACTIVE', 'Looking for 2018 Toyota Corolla, white, good condition', 'AUTO_CHECK_CO', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(102, 'ACTIVE', 'Need a 2020 BMW 320i imported from Germany', 'VEHI_VERIFY_INC', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(103, 'CLOSED', 'Searching for Honda Civic 2017 local', 'AUTO_CHECK_CO', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


-- Fetch inserted IDs (for H2 compatibility)
-- H2 auto-generates IDs incrementally starting from 1

-- Assume request IDs become: 1, 2, 3


-- =============
-- Supplier Offers
-- =============

INSERT INTO supplier_offers (
    supplier_id,
    request_id,
    status,
    car_details,
    price,
    inspection_score,
    created_at,
    updated_at
) VALUES
(201, 1, 'PENDING', 'Car is well maintained, 80k km, minor scratches', 350000, 82, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(202, 1, 'PENDING', 'Good condition, no accidents, 75k km', 360000, 87, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),

(203, 2, 'PENDING', 'Imported BMW, 45k km, excellent condition', 950000, 91, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),

(204, 3, 'REJECTED', 'Local Honda Civic 2017, 100k km', 280000, 70, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
