INSERT INTO library.role (id, name) VALUES (DEFAULT, 'user');
INSERT INTO library.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO library.book (id, title, author, release_time, genre, lending_period_days, location, quantity) VALUES (DEFAULT, 'Clean Code', 'Robert C. Martin', '2008-08-01', 'Education', 7, '1 floor', 5);
INSERT INTO library.book (id, title, author, release_time, genre, lending_period_days, location, quantity) VALUES (DEFAULT, 'Aabits', 'Eno Raud', '2022-12-22', 'Education', 14, '1 floor', 23);
INSERT INTO library.book (id, title, author, release_time, genre, lending_period_days, location, quantity) VALUES (DEFAULT, 'T6de ja 6igus', 'A.H.Tammsaare', '1856-07-09', 'Fiction', 7, '2 floor', 14);

INSERT INTO library."user" (id, user_name, password) VALUES (DEFAULT, 'henri123', 'hencs123');
INSERT INTO library."user" (id, user_name, password) VALUES (DEFAULT, 'aleksei123', 'alex123');
INSERT INTO library.user_role (id, role_id, user_id) VALUES (DEFAULT, 1, 1);
INSERT INTO library.user_role (id, role_id, user_id) VALUES (DEFAULT, 1, 2);

INSERT INTO library.contact (id, first_name, last_name, email, address, mobile_number, user_id) VALUES (DEFAULT, 'Henri', 'Eessalu', 'henri.eessalu@gmail.com', 'Lai 15, Parnu', '56640162', 1);
INSERT INTO library.contact (id, first_name, last_name, email, address, mobile_number, user_id) VALUES (DEFAULT, 'Aleksei', 'Romanov', 'aleksei.romanov@mail.com', 'Tihase 17, Tallinn', '54393842', 2)