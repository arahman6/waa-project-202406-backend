SELECT 1;



INSERT INTO users ("enable", id, email, first_name, last_name, "password", phone, username)
VALUES
    (true, 1, 'admin@example.com', '', '', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', '', 'admin'),
    (true, 2, 'buyer@example.com', '', '', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', '', 'buyer'),
    (true, 3, 'seller@example.com', '', '', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', '', 'seller');--123

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'BUYER');
INSERT INTO role (id, role)
VALUES (3, 'SELLER');
--
--
--
INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 2);
INSERT INTO users_roles (user_id, roles_id)
VALUES (3, 3);


-- -- Inserting sample Users
-- INSERT INTO users (id, username, password, email, first_name, last_name, role) VALUES
-- (1, 'admin', '$2a$10$Dow1oEppW1MSKgV/q2xdLuS4n//U1z/O13h6.dX23OQv.zTO2F1pW', 'admin@example.com', 'Admin', 'User', 'ADMIN'),
-- (2, 'buyer1', '$2a$10$Dow1oEppW1MSKgV/q2xdLuS4n//U1z/O13h6.dX23OQv.zTO2F1pW', 'buyer1@example.com', 'Buyer', 'One', 'BUYER'),
-- (3, 'buyer2', '$2a$10$Dow1oEppW1MSKgV/q2xdLuS4n//U1z/O13h6.dX23OQv.zTO2F1pW', 'buyer2@example.com', 'Buyer', 'Two', 'BUYER'),
-- (4, 'buyer3', '$2a$10$Dow1oEppW1MSKgV/q2xdLuS4n//U1z/O13h6.dX23OQv.zTO2F1pW', 'buyer3@example.com', 'Buyer', 'Three', 'BUYER'),
-- (5, 'seller1', '$2a$10$Dow1oEppW1MSKgV/q2xdLuS4n//U1z/O13h6.dX23OQv.zTO2F1pW', 'seller1@example.com', 'Seller', 'One', 'SELLER'),
-- (6, 'seller2', '$2a$10$Dow1oEppW1MSKgV/q2xdLuS4n//U1z/O13h6.dX23OQv.zTO2F1pW', 'seller2@example.com', 'Seller', 'Two', 'SELLER'),
-- (7, 'seller3', '$2a$10$Dow1oEppW1MSKgV/q2xdLuS4n//U1z/O13h6.dX23OQv.zTO2F1pW', 'seller3@example.com', 'Seller', 'Three', 'SELLER'),
-- (8, 'seller4', '$2a$10$Dow1oEppW1MSKgV/q2xdLuS4n//U1z/O13h6.dX23OQv.zTO2F1pW', 'seller4@example.com', 'Seller', 'Four', 'SELLER'),
-- (9, 'buyer4', '$2a$10$Dow1oEppW1MSKgV/q2xdLuS4n//U1z/O13h6.dX23OQv.zTO2F1pW', 'buyer4@example.com', 'Buyer', 'Four', 'BUYER'),
-- (10, 'buyer5', '$2a$10$Dow1oEppW1MSKgV/q2xdLuS4n//U1z/O13h6.dX23OQv.zTO2F1pW', 'buyer5@example.com', 'Buyer', 'Five', 'BUYER');
--
-- -- Inserting sample Addresses
-- INSERT INTO address (id, street, city, state, postal_code, country, user_id) VALUES
--                                                                                  (1, '123 Main St', 'Anytown', 'Anystate', '12345', 'USA', 1),
--                                                                                  (2, '456 Oak St', 'Othertown', 'Otherstate', '67890', 'USA', 2),
--                                                                                  (3, '789 Pine St', 'Somewhere', 'Somestate', '11111', 'USA', 3),
--                                                                                  (4, '101 Maple St', 'Elsewhere', 'Elsestate', '22222', 'USA', 4),
--                                                                                  (5, '202 Birch St', 'Nowhere', 'Nowherestate', '33333', 'USA', 5),
--                                                                                  (6, '303 Cedar St', 'Anywhere', 'Anystate', '44444', 'USA', 6),
--                                                                                  (7, '404 Elm St', 'Thisplace', 'Thistate', '55555', 'USA', 7),
--                                                                                  (8, '505 Spruce St', 'Thatplace', 'Thatstate', '66666', 'USA', 8),
--                                                                                  (9, '606 Fir St', 'Whoknows', 'Whostate', '77777', 'USA', 9),
--                                                                                  (10, '707 Ash St', 'Whoknows', 'Whostate', '88888', 'USA', 10);
--
-- -- Inserting sample Categories
-- INSERT INTO category (id, name) VALUES
--                                     (1, 'Electronics'),
--                                     (2, 'Home Appliances'),
--                                     (3, 'Books'),
--                                     (4, 'Clothing'),
--                                     (5, 'Toys'),
--                                     (6, 'Sports'),
--                                     (7, 'Health'),
--                                     (8, 'Beauty'),
--                                     (9, 'Automotive'),
--                                     (10, 'Garden');
--
-- -- Inserting sample SubCategories
-- INSERT INTO sub_category (id, name, category_id) VALUES
--                                                      (1, 'Mobile Phones', 1),
--                                                      (2, 'Laptops', 1),
--                                                      (3, 'Refrigerators', 2),
--                                                      (4, 'Washing Machines', 2),
--                                                      (5, 'Fiction', 3),
--                                                      (6, 'Non-Fiction', 3),
--                                                      (7, 'Men', 4),
--                                                      (8, 'Women', 4),
--                                                      (9, 'Action Figures', 5),
--                                                      (10, 'Dolls', 5);
--
-- -- Inserting sample Products
-- INSERT INTO product (id, name, description, price, image_url, stock_quantity, sub_category_id) VALUES
--                                                                                                    (1, 'iPhone 12', 'Latest Apple iPhone', 799.99, 'iphone12.jpg', 50, 1),
--                                                                                                    (2, 'Samsung Galaxy S21', 'Latest Samsung phone', 699.99, 'galaxys21.jpg', 45, 1),
--                                                                                                    (3, 'Dell XPS 13', 'High performance laptop', 999.99, 'dellxps13.jpg', 30, 2),
--                                                                                                    (4, 'MacBook Pro', 'Apple laptop', 1299.99, 'macbookpro.jpg', 25, 2),
--                                                                                                    (5, 'Whirlpool Refrigerator', 'Energy efficient refrigerator', 499.99, 'whirlpool.jpg', 20, 3),
--                                                                                                    (6, 'LG Washing Machine', 'Top load washing machine', 399.99, 'lg.jpg', 15, 4),
--                                                                                                    (7, 'The Great Gatsby', 'Classic novel by F. Scott Fitzgerald', 10.99, 'gatsby.jpg', 100, 5),
--                                                                                                    (8, 'Sapiens', 'A Brief History of Humankind by Yuval Noah Harari', 15.99, 'sapiens.jpg', 80, 6),
--                                                                                                    (9, 'Levi\'s Jeans', 'Comfortable jeans', 39.99, 'levis.jpg', 60, 7),
-- (10, 'Nike Running Shoes', 'Lightweight running shoes', 59.99, 'nike.jpg', 40, 8);
--
-- -- Inserting sample Orders
-- INSERT INTO orders (id, user_id, order_date, status) VALUES
-- (1, 2, '2024-06-15T10:00:00', 'PROCESSING'),
-- (2, 3, '2024-06-14T11:00:00', 'SHIPPED'),
-- (3, 4, '2024-06-13T12:00:00', 'DELIVERED'),
-- (4, 5, '2024-06-12T13:00:00', 'PROCESSING'),
-- (5, 6, '2024-06-11T14:00:00', 'SHIPPED'),
-- (6, 7, '2024-06-10T15:00:00', 'DELIVERED'),
-- (7, 8, '2024-06-09T16:00:00', 'PROCESSING'),
-- (8, 9, '2024-06-08T17:00:00', 'SHIPPED'),
-- (9, 10, '2024-06-07T18:00:00', 'DELIVERED'),
-- (10, 1, '2024-06-06T19:00:00', 'PROCESSING');
--
-- -- Inserting sample Items
-- INSERT INTO item (id, cart_id, product_id, quantity) VALUES
-- (1, 1, 1, 1),
-- (2, 2, 2, 2),
-- (3, 3, 3, 1),
-- (4, 4, 4, 1),
-- (5, 5, 5, 1),
-- (6, 6, 6, 1),
-- (7, 7, 7, 3),
-- (8, 8, 8, 2),
-- (9, 9, 9, 1),
-- (10, 10, 10, 2);
--
-- -- Inserting sample Payments
-- INSERT INTO payment (id, order_id, payment_method, payment_date, amount) VALUES
-- (1, 1, 'CREDIT_CARD', '2024-06-15T10:30:00', 799.99),
-- (2, 2, 'PAYPAL', '2024-06-14T11:30:00', 1399.98),
-- (3, 3, 'CREDIT_CARD', '2024-06-13T12:30:00', 999.99),
-- (4, 4, 'PAYPAL', '2024-06-12T13:30:00', 1299.99),
-- (5, 5, 'CREDIT_CARD', '2024-06-11T14:30:00', 499.99),
-- (6, 6, 'PAYPAL', '2024-06-10T15:30:00', 399.99),
-- (7, 7, 'CREDIT_CARD', '2024-06-09T16:30:00', 10.99),
-- (8, 8, 'PAYPAL', '2024-06-08T17:30:00', 15.99),
-- (9, 9, 'CREDIT_CARD', '2024-06-07T18:30:00', 39.99),
-- (10, 10, 'PAYPAL', '2024-06-06T19:30:00', 59.99);
--
-- -- Inserting sample Reviews
-- INSERT INTO review (id, user_id, product_id, rating, comment, review_date) VALUES
-- (1, 2, 1, 'FIVE', 'Great product!', '2024-06-15T10:00:00'),
-- (2, 3, 2, 'FOUR', 'Very good phone', '2024-06-14T11:00:00'),
-- (3, 4, 3, 'THREE', 'Average laptop', '2024-06-13T12:00:00'),
-- (4, 5, 4, 'FIVE', 'Excellent laptop', '2024-06-12T13:00:00'),
-- (5, 6, 5, 'FOUR', 'Good refrigerator', '2024-06-11T14:00:00'),
-- (6, 7, 6, 'THREE', 'It\'s okay', '2024-06-10T15:00:00'),
--                                                                                                    (7, 8, 7, 'FIVE', 'Loved it!', '2024-06-09T16:00:00'),
--                                                                                                    (8, 9, 8, 'FOUR', 'Very interesting book', '2024-06-08T17:00:00'),
--                                                                                                    (9, 10, 9, 'FOUR', 'Comfortable jeans', '2024-06-07T18:00:00'),
--                                                                                                    (10, 1, 10, 'FIVE', 'Great shoes!', '2024-06-06T19:00:00');
