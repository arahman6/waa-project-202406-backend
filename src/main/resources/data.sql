

SELECT 1;

-- -- Inserting sample Users
INSERT INTO users (enable, id, username, password, email, first_name, last_name)
VALUES
    (true, 1, 'admin', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'admin@example.com', 'Admin', 'User'),
    (true, 2, 'buyer1', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'buyer1@example.com', 'Buyer', 'One'),
    (true, 3, 'buyer2', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'buyer2@example.com', 'Buyer', 'Two'),
    (true, 4, 'buyer3', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'buyer3@example.com', 'Buyer', 'Three'),
    (true, 5, 'seller1', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'seller1@example.com', 'Seller', 'One'),
    (true, 6, 'seller2', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'seller2@example.com', 'Seller', 'Two'),
    (true, 7, 'seller3', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'seller3@example.com', 'Seller', 'Three'),
    (false, 8, 'seller4', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'seller4@example.com', 'Seller', 'Four'),
    (true, 9, 'buyer4', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'buyer4@example.com', 'Buyer', 'Four'),
    (true,10, 'buyer5', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'buyer5@example.com', 'Buyer', 'Five');


INSERT INTO role (id, user_id, role) VALUES (1, 1, 'ADMIN');
INSERT INTO role (id, user_id, role) VALUES (2, 2, 'BUYER');
INSERT INTO role (id, user_id, role) VALUES (3, 3, 'BUYER');
INSERT INTO role (id, user_id, role) VALUES (4, 4, 'BUYER');
INSERT INTO role (id, user_id, role) VALUES (5, 5, 'SELLER');
INSERT INTO role (id, user_id, role) VALUES (6, 6, 'SELLER');
INSERT INTO role (id, user_id, role) VALUES (7, 7, 'SELLER');
INSERT INTO role (id, user_id, role) VALUES (8, 8, 'SELLER');
INSERT INTO role (id, user_id, role) VALUES (9, 9, 'BUYER');
INSERT INTO role (id, user_id, role) VALUES (10, 10, 'BUYER');

-- Inserting sample Addresses
INSERT INTO address (id, street, city, state, postal_code, country, user_id)
VALUES
    (1, '123 Main St', 'Anytown', 'Anystate', '12345', 'USA', 1),
    (2, '456 Oak St', 'Othertown', 'Otherstate', '67890', 'USA', 2),
    (3, '789 Pine St', 'Somewhere', 'Somestate', '11111', 'USA', 3),
    (4, '101 Maple St', 'Elsewhere', 'Elsestate', '22222', 'USA', 4),
    (5, '202 Birch St', 'Nowhere', 'Nowherestate', '33333', 'USA', 5),
    (6, '303 Cedar St', 'Anywhere', 'Anystate', '44444', 'USA', 6),
    (7, '404 Elm St', 'Thisplace', 'Thistate', '55555', 'USA', 7),
    (8, '505 Spruce St', 'Thatplace', 'Thatstate', '66666', 'USA', 8),
    (9, '606 Fir St', 'Whoknows', 'Whostate', '77777', 'USA', 9),
    (10, '707 Ash St', 'Whoknows', 'Whostate', '88888', 'USA', 10);

-- Inserting sample Categories
INSERT INTO category (id, name)
VALUES
    (1, 'Electronics'),
    (2, 'Home Appliances'),
    (3, 'Books'),
    (4, 'Clothing'),
    (5, 'Toys'),
    (6, 'Sports'),
    (7, 'Health'),
    (8, 'Beauty'),
    (9, 'Automotive'),
    (10, 'Garden');

-- Inserting sample SubCategories
INSERT INTO sub_category (id, name, category_id)
VALUES
    (1, 'Mobile Phones', 1),
    (2, 'Laptops', 1),
    (3, 'Refrigerators', 2),
    (4, 'Washing Machines', 2),
    (5, 'Fiction', 3),
    (6, 'Non-Fiction', 3),
    (7, 'Men', 4),
    (8, 'Women', 4),
    (9, 'Action Figures', 5),
    (10, 'Dolls', 5);
--
-- -- Inserting sample Products
INSERT INTO product (id, purchased, user_id, brand, name, description, price, image_url, stock_quantity, sub_category_id)
VALUES
    (1, false, 5, 'APPLE', 'iPhone 12', 'Latest Apple iPhone', 799.99, 'iphone12.jpg', 50, 1),
    (2, false, 5, 'SAMSUNG', 'Samsung Galaxy S21', 'Latest Samsung phone', 699.99, 'galaxys21.jpg', 45, 1),
    (3, false, 5, 'DELL', 'Dell XPS 13', 'High performance laptop', 999.99, 'dellxps13.jpg', 30, 2),
    (4, false, 6, 'APPLE', 'MacBook Pro', 'Apple laptop', 1299.99, 'macbookpro.jpg', 25, 2),
    (5, false, 6, 'LG', 'Whirlpool Refrigerator', 'Energy efficient refrigerator', 499.99, 'whirlpool.jpg', 20, 3),
    (6, false, 6, 'LG', 'LG Washing Machine', 'Top load washing machine', 399.99, 'lg.jpg', 15, 4),
    (7, false, 6, 'LG', 'The Great Gatsby', 'Classic novel by F. Scott Fitzgerald', 10.99, 'gatsby.jpg', 100, 5),
    (8, false, 7, 'LG', 'Sapiens', 'A Brief History of Humankind by Yuval Noah Harari', 15.99, 'sapiens.jpg', 80, 6),
    (9, false, 7, 'LG', 'Levis Jeans', 'Comfortable jeans', 39.99, 'levis.jpg', 60, 7),
    (10, false, 8, 'LG', 'Nike Running Shoes', 'Lightweight running shoes', 59.99, 'nike.jpg', 40, 8);

-- Inserting sample data into the product table with constraints
-- INSERT INTO public.product (price, purchased, stock_quantity, id, sub_category_id, user_id, brand, color, description, image_url, material, "name", "size")
-- VALUES
--     (799.99, false, 50, 1000, 1, 5, 'APPLE', 'BLACK', 'Latest Apple iPhone', 'iphone12.jpg', 'PLASTIC', 'iPhone 12', NULL),
--     (699.99, false, 45, 1001, 1, 5, 'SAMSUNG', 'WHITE', 'Latest Samsung phone', 'galaxys21.jpg', 'PLASTIC', 'Samsung Galaxy S21', NULL),
--     (999.99, false, 30, 1002, 2, 5, 'DELL', 'BLACK', 'High performance laptop', 'dellxps13.jpg', 'PLASTIC', 'Dell XPS 13', NULL),
--     (1299.99, false, 25, 1003, 2, 6, 'APPLE', 'WHITE', 'Apple laptop', 'macbookpro.jpg', 'PLASTIC', 'MacBook Pro', NULL),
--     (499.99, false, 20, 1004, 3, 6, 'LG', 'WHITE', 'Energy efficient refrigerator', 'whirlpool.jpg', 'PLASTIC', 'Whirlpool Refrigerator', NULL),
--     (399.99, false, 15, 1005, 4, 6, 'LG', 'WHITE', 'Top load washing machine', 'lg.jpg', 'PLASTIC', 'LG Washing Machine', NULL),
--     (10.99, false, 100, 1006, 5, 6, 'PENGUIN', 'BLUE', 'Classic novel by F. Scott Fitzgerald', 'gatsby.jpg', 'PAPER', 'The Great Gatsby', NULL),
--     (15.99, false, 80, 1007, 6, 7, 'HARPER', 'WHITE', 'A Brief History of Humankind by Yuval Noah Harari', 'sapiens.jpg', 'PAPER', 'Sapiens', NULL),
--     (39.99, false, 60, 1008, 7, 7, 'LEVIS', 'BLUE', 'Comfortable jeans', 'levis.jpg', 'DENIM', 'Levis Jeans', 'M'),
--     (59.99, false, 40, 1009, 8, 8, 'NIKE', 'BLACK', 'Lightweight running shoes', 'nike.jpg', 'PLASTIC', 'Nike Running Shoes', '10');



-- Inserting sample Orders
INSERT INTO orders (id, user_id, order_date, delivery_date, status, price)
VALUES
    (1, 2, '2024-06-15T10:00:00', '2024-06-15T10:00:00', 'PROCESSING',0.0),
    (2, 3, '2024-06-14T11:00:00', '2024-06-14T11:00:00', 'PROCESSING',0.0),
    (3, 4, '2024-06-13T12:00:00', '2024-06-13T12:00:00', 'PROCESSING',0.0),
    (4, 5, '2024-06-12T13:00:00', '2024-06-12T13:00:00', 'PROCESSING',0.0),
    (5, 6, '2024-06-11T14:00:00', '2024-06-11T14:00:00', 'PROCESSING',0.0),
    (6, 7, '2024-06-10T15:00:00', '2024-06-10T15:00:00', 'PROCESSING',0.0),
    (7, 8, '2024-06-09T16:00:00', '2024-06-09T16:00:00', 'PROCESSING',0.0),
    (8, 9, '2024-06-08T17:00:00', '2024-06-08T17:00:00', 'PROCESSING',0.0),
    (9, 10, '2024-06-07T18:00:00', '2024-06-07T18:00:00', 'PROCESSING',0.0),
    (10, 2, '2024-06-06T19:00:00', '2024-06-06T19:00:00', 'PROCESSING',0.0);



INSERT INTO public.cart (id, user_id)
VALUES
    (1, 2),
    (2, 3),
    (3, 4),
    (4, 5);


-- -- Inserting sample Items
INSERT INTO item (id, cart_id, product_id, order_id, quantity, price)
VALUES
    (1, null, 1, 1, 1, 20),
    (2, null, 2, 2, 2, 20),
    (3, null, 3, 3, 1, 20),
    (4, null, 4, 4, 1, 20),
    (5, null, 5, 5, 1, 40),
    (6, null, 6, 6, 1, 20),
    (7, null, 7, 7, 3, 20),
    (8, null, 8, 8, 2, 20),
    (9, null, 9, 9, 1, 30),
    (10, null, 10, 10, 2, 20),
    (11, 1, 1, null, 2, 20),
    (12, 2, 2, null, 2, 20),
    (13, 3, 3, null, 2, 20),
    (14, 4, 4, null, 2, 20);
--
-- -- Inserting sample Payments
INSERT INTO payment (id, order_id, payment_method, payment_date, amount)
VALUES
    (1, 1, 'CREDIT_CARD', '2024-06-15T10:30:00', 799.99),
    (2, 2, 'PAYPAL', '2024-06-14T11:30:00', 1399.98),
    (3, 3, 'CREDIT_CARD', '2024-06-13T12:30:00', 999.99),
    (4, 4, 'PAYPAL', '2024-06-12T13:30:00', 1299.99),
    (5, 5, 'CREDIT_CARD', '2024-06-11T14:30:00', 499.99),
    (6, 6, 'PAYPAL', '2024-06-10T15:30:00', 399.99),
    (7, 7, 'CREDIT_CARD', '2024-06-09T16:30:00', 10.99),
    (8, 8, 'PAYPAL', '2024-06-08T17:30:00', 15.99),
    (9, 9, 'CREDIT_CARD', '2024-06-07T18:30:00', 39.99),
    (10, 10, 'PAYPAL', '2024-06-06T19:30:00', 59.99);
--
-- -- Inserting sample Reviews
INSERT INTO review (id, user_id, product_id, rating, comment, review_date)
VALUES
           (1, 2, 1, 'FIVE', 'Great product!', '2024-06-15T10:00:00'),
           (2, 3, 2, 'FOUR', 'Very good phone', '2024-06-14T11:00:00'),
           (3, 4, 3, 'THREE', 'Average laptop', '2024-06-13T12:00:00'),
           (4, 5, 4, 'FIVE', 'Excellent laptop', '2024-06-12T13:00:00'),
           (5, 6, 5, 'FOUR', 'Good refrigerator', '2024-06-11T14:00:00'),
           (6, 7, 6, 'THREE', 'Its okay', '2024-06-10T15:00:00'),
           (7, 8, 7, 'FIVE', 'Loved it!', '2024-06-09T16:00:00'),
           (8, 9, 8, 'FOUR', 'Very interesting book', '2024-06-08T17:00:00'),
           (9, 10, 9, 'FOUR', 'Comfortable jeans', '2024-06-07T18:00:00'),
           (10, 1, 10, 'FIVE', 'Great shoes!', '2024-06-06T19:00:00');


-- Ensure sequences start from 1000 for the required tables
ALTER SEQUENCE users_id_seq RESTART WITH 1000;
ALTER SEQUENCE role_id_seq RESTART WITH 1000;
ALTER SEQUENCE address_id_seq RESTART WITH 1000;
ALTER SEQUENCE category_id_seq RESTART WITH 1000;
ALTER SEQUENCE sub_category_id_seq RESTART WITH 1000;
ALTER SEQUENCE product_id_seq RESTART WITH 1000;
ALTER SEQUENCE orders_id_seq RESTART WITH 1000;
ALTER SEQUENCE cart_id_seq RESTART WITH 1000;
ALTER SEQUENCE item_id_seq RESTART WITH 1000;
ALTER SEQUENCE payment_id_seq RESTART WITH 1000;
ALTER SEQUENCE review_id_seq RESTART WITH 1000;

