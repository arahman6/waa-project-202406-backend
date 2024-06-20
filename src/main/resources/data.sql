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
(true, 8, 'seller4', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'seller4@example.com', 'Seller', 'Four'),
(true, 9, 'buyer4', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'buyer4@example.com', 'Buyer', 'Four'),
(true,10, 'buyer5', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'buyer5@example.com', 'Buyer', 'Five');


INSERT INTO role (id, role) VALUES (1, 'ADMIN');
INSERT INTO role (id, role) VALUES (2, 'BUYER');
INSERT INTO role (id, role) VALUES (3, 'SELLER');


INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES (2, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES (3, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES (4, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES (5, 3);
INSERT INTO users_roles (user_id, roles_id) VALUES (6, 3);
INSERT INTO users_roles (user_id, roles_id) VALUES (7, 3);
INSERT INTO users_roles (user_id, roles_id) VALUES (8, 3);
INSERT INTO users_roles (user_id, roles_id) VALUES (9, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES (10, 2);


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

INSERT INTO product (id, purchased, user_id, name, description, price, image_url, stock_quantity, sub_category_id)
VALUES
(1, false, 5, 'iPhone 12', 'Latest Apple iPhone', 799.99, 'iphone12.jpg', 50, 1),
(2, false, 5, 'Samsung Galaxy S21', 'Latest Samsung phone', 699.99, 'galaxys21.jpg', 45, 1),
(3, false, 5, 'Dell XPS 13', 'High performance laptop', 999.99, 'dellxps13.jpg', 30, 2),
(4, false, 6, 'MacBook Pro', 'Apple laptop', 1299.99, 'macbookpro.jpg', 25, 2),
(5, false, 6, 'Whirlpool Refrigerator', 'Energy efficient refrigerator', 499.99, 'whirlpool.jpg', 20, 3),
(6, false, 6, 'LG Washing Machine', 'Top load washing machine', 399.99, 'lg.jpg', 15, 4),
(7, false, 6, 'The Great Gatsby', 'Classic novel by F. Scott Fitzgerald', 10.99, 'gatsby.jpg', 100, 5),
(8, false, 7, 'Sapiens', 'A Brief History of Humankind by Yuval Noah Harari', 15.99, 'sapiens.jpg', 80, 6),
(9, false, 7, 'Levis Jeans', 'Comfortable jeans', 39.99, 'levis.jpg', 60, 7),
(10, false, 8, 'Nike Running Shoes', 'Lightweight running shoes', 59.99, 'nike.jpg', 40, 8);


-- -- Inserting sample Orders
INSERT INTO orders (id, user_id, order_date, delivery_date, status)
VALUES
    (1, 2, '2024-06-15T10:00:00', '2024-06-15T10:00:00', 'PROCESSING'),
    (2, 3, '2024-06-14T11:00:00', '2024-06-14T11:00:00', 'PROCESSING'),
    (3, 4, '2024-06-13T12:00:00', '2024-06-13T12:00:00', 'PROCESSING'),
    (4, 5, '2024-06-12T13:00:00', '2024-06-12T13:00:00', 'PROCESSING'),
    (5, 6, '2024-06-11T14:00:00', '2024-06-11T14:00:00', 'PROCESSING'),
    (6, 7, '2024-06-10T15:00:00', '2024-06-10T15:00:00', 'PROCESSING'),
    (7, 8, '2024-06-09T16:00:00', '2024-06-09T16:00:00', 'PROCESSING'),
    (8, 9, '2024-06-08T17:00:00', '2024-06-08T17:00:00', 'PROCESSING'),
    (9, 10, '2024-06-07T18:00:00', '2024-06-07T18:00:00', 'PROCESSING'),
    (10, 2, '2024-06-06T19:00:00', '2024-06-06T19:00:00', 'PROCESSING');


INSERT INTO public.cart (id, user_id)
VALUES
    (1, 2),
    (2, 3),
    (3, 4),
    (4, 5);


-- -- Inserting sample Items
INSERT INTO item (id, cart_id, product_id, order_id, quantity)
VALUES
    (1, null, 1, 1, 1),
    (2, null, 2, 2, 2),
    (3, null, 3, 3, 1),
    (4, null, 4, 4, 1),
    (5, null, 5, 5, 1),
    (6, null, 6, 6, 1),
    (7, null, 7, 7, 3),
    (8, null, 8, 8, 2),
    (9, null, 9, 9, 1),
    (10, null, 10, 10, 2),
    (11, 1, 1, null, 2),
    (12, 2, 2, null, 2),
    (13, 3, 3, null, 2),
    (14, 4, 4, null, 2);
--
-- -- Inserting sample Payments
INSERT INTO payment (id, order_id, payment_method, payment_date, amount) VALUES
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
INSERT INTO review (id, user_id, product_id, rating, comment, review_date) VALUES
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
