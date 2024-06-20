

SELECT 1;




INSERT INTO users ("enable", id, email, first_name, last_name, "password", phone, username)
VALUES
    (true, 10, 'admin@example.com', '', '', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', '', 'admin'),
    (true, 20, 'buyer@example.com', '', '', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', '', 'buyer'),
    (true, 30, 'seller@example.com', '', '', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', '', 'seller');--123

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'BUYER');
INSERT INTO role (id, role)
VALUES (3, 'SELLER');
--
-- --
-- --
-- INSERT INTO users_roles (user_id, roles_id)
-- VALUES (1, 1);
-- INSERT INTO users_roles (user_id, roles_id)
-- VALUES (2, 2);
-- INSERT INTO users_roles (user_id, roles_id)
-- VALUES (3, 3);
--


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


INSERT INTO address (id, street, city, state, postal_code, country) VALUES
                                                                        (1, '123 Main St', 'Anytown', 'Anystate', '12345', 'USA'),
                                                                        (2, '456 Oak St', 'Othertown', 'Otherstate', '67890', 'USA'),
                                                                        (3, '789 Pine St', 'Somewhere', 'Somestate', '11111', 'USA');


INSERT INTO product (id, name, description, price, image_url, stock_quantity, purchased) VALUES
                                                                                    (1, 'iPhone 12', 'Latest Apple iPhone', 799.99, 'iphone12.jpg', 50, false),
                                                                                    (2, 'Samsung Galaxy S21', 'Latest Samsung phone', 699.99, 'galaxys21.jpg', 45, false),
                                                                                    (3, 'Dell XPS 13', 'High performance laptop', 999.99, 'dellxps13.jpg', 30, false);


INSERT INTO review (id, user_id, product_id, rating, "comment", review_date) VALUES
                                                                                 (1, 2, 1, 'FIVE', 'Great product!', '2024-06-15T10:00:00'),
                                                                                 (2, 3, 2, 'FOUR', 'Very good phone', '2024-06-14T11:00:00'),
                                                                                 (3, 1, 3, 'THREE', 'Average laptop', '2024-06-13T12:00:00');


INSERT INTO orders (id, user_id, order_date, status, price) VALUES
                                                         (1, 20, '2024-06-15T10:00:00', 'PROCESSING',0),
                                                         (2, 30, '2024-06-14T11:00:00', 'SHIPPED',100),
                                                         (3, 10, '2024-06-13T12:00:00', 'DELIVERED',300);



INSERT INTO item (id, product_id, quantity) VALUES
                                                (1, 1, 1),
                                                (2, 2, 2),
                                                (3, 3, 1);


INSERT INTO cart (id, user_id) VALUES
                                   (1, 1),
                                   (2, 2),
                                   (3, 3);






