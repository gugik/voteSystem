INSERT INTO PUBLIC.USERS(EMAIL, PASSWORD) VALUES
  ('user@yandex.ru', '12345'),
  ('admin@gmail.com', '12345');

INSERT INTO PUBLIC.USER_ROLES(USER_ID, ROLE) VALUES
  (100000, 'ROLE_USER'),
  (100001, 'ROLE_ADMIN'),
  (100001, 'ROLE_USER');

INSERT INTO restaurants (name) VALUES
  ('restaurant1'),
  ('restaurant2'),
  ('restaurant3');

INSERT INTO menu (date, restaurant_id) VALUES
  ('2017-06-10', 100003),
  ('2017-06-10', 100004),
  ('2017-06-10', 100002),
  ('2017-06-09', 100003),
  ('2017-06-09', 100004);

/*INSERT INTO dishes (name, price, menu_id) VALUES
  ('Soup', 30, 100005),
  ('Potato', 60, 100005),
  ('Meat', 90, 100005),
  ('Soup', 50, 100006),
  ('Potato', 70, 100006),
  ('Meat', 120, 100006),
  ('Potato', 60, 100007),
  ('Meat', 130, 100007),
  ('Soup', 30, 100008),
  ('Fish', 98, 100008),
  ('Soup', 30, 100009),
  ('Vegetables', 60, 100009),
  ('Fish', 150, 100009);*/

INSERT INTO dishes (name, price) VALUES
  ('Soup', 30),
  ('Potato', 60),
  ('Meat', 90),
  ('Soup', 50),
  ('Potato', 70),
  ('Meat', 120),
  ('Potato', 60),
  ('Meat', 130),
  ('Soup', 30),
  ('Fish', 98),
  ('Soup', 30),
  ('Vegetables', 60),
  ('Fish', 150);

insert into menu_dishes(menu_id,dishes_id) values
  (100005,100010),
  (100005,100011),
  (100005,100012),
  (100006,100013),
  (100006,100014),
  (100006,100015),
  (100007,100016),
  (100007,100017),
  (100007,100018),
  (100008,100019),
  (100008,100020),
  (100009,100021),
  (100009,100022)
;
INSERT INTO votes (date_time, user_id, restaurant_id) VALUES
  ('2017-06-10', 100001, 100002),
  ('2017-06-10', 100000, 100002),
  ('2017-06-09', 100000, 100004),
  ('2017-06-09', 100001, 100004);
