insert into auth(username, password, email) values ('+7999999999', 'superstrongpassword', 'test@test.ru');
insert into auth(username, password, email) values ('+7999999998', 'superstrongpassword', 'testa@test.ru');
insert into auth(username, password, email) values ('+7999999997', 'superstrongpassword', 'testb@test.ru');
insert into auth(username, password, email) values ('+7999999996', 'superstrongpassword', 'testc@test.ru');
insert into auth(username, password, email) values ('+7999999995', 'superstrongpassword', 'testd@test.ru');
insert into auth(username, password, email) values ('+7999999994', 'superstrongpassword', 'teste@test.ru');
insert into auth(username, password, email) values ('+7999999993', 'superstrongpassword', 'testf@test.ru');
insert into auth(username, password, email) values ('+7999999992', 'superstrongpassword', 'testg@test.ru');
insert into auth(username, password, email) values ('+7999999991', 'superstrongpassword', 'testh@test.ru');
insert into auth(username, password, email) values ('+7999999990', 'superstrongpassword', 'testj@test.ru');

insert into specialist(auth_id, name, surname, patronymic, status, rating, phone) values ('1', 'Oleg', 'Krivoruchkin', 'Illarionovich', 'working', 5, '+79969219000');

insert into specialist(auth_id, name, surname, patronymic, status, rating, phone) values ('2', 'Andrey', 'Krivoruchkin', 'Illarionovich', 'working', 5, '+79969219001');

insert into specialist(auth_id, name, surname, patronymic, status, rating, phone) values ('3', 'Maxim', 'Krivoruchkin', 'Illarionovich', 'working', 5, '+79969219002');

insert into specialist(auth_id, name, surname, patronymic, status, rating, phone) values ('4', 'Matvey', 'Krivoruchkin', 'Illarionovich', 'blocked', 1, '+79969219002');

insert into client(auth_id, name, status, phone) values ('5', 'Igor', 'default', '+6932592315351');
insert into client(auth_id, name, status, phone) values ('6', 'Varya', 'default', '+693255351');
insert into client(auth_id, name, status, phone) values ('7', 'Sasha', 'default', '+69325315351');
insert into client(auth_id, name, status, phone) values ('8', 'Senya', 'default', '+1125315351');

insert into category(name, slug) values ('Сантехника', 'santekhnika');
insert into category(name, slug) values ('Кухня', 'kukhnya');
insert into category(name, slug) values ('Мебель', 'mebel');

insert into service(category_id, title, price, slug) values (1, 'Починить унитаз', 1600, 'pochinit-unitaz');
insert into service(category_id, title, price, slug) values (1, 'Устранить засор', 1500, 'ustranit-zasor');
insert into service(category_id, title, price, slug) values (1, 'Развести трубы', 12500, 'razvesti-trubi');
insert into service(category_id, title, price, slug) values (2, 'Собрать кухонный стол', 1250, 'sobrat-shkaf');
insert into service(category_id, title, price, slug) values (3, 'Починить шкаф', 5550, 'pochinit-shkaf');

select * from add_order('1', '1', 'проезд Аэропорта, 8', '2022-12-12');
select * from add_order('1', '7', 'проезд Аэропорта, 8', '2022-12-14');
select * from add_order('3', '8', 'Кронверкский, 49', '2022-12-31');
-- maybe bug in client_id

insert into documents(order_id, url) values ('1', 'example.com/example.txt');
insert into documents(order_id, url) values ('2', 'example.com/test.txt');

insert into specialization(specialist_id, service_id) values ('1', '1');
insert into specialization(specialist_id, service_id) values ('2', '2');
insert into specialization(specialist_id, service_id) values ('3', '2');
insert into specialization(specialist_id, service_id) values ('4', '3');

update "order" set specialist_id='1' where service_id='1';

insert into payout(auth_id, amount, date) values ('1', 1000, current_date);
insert into report(order_id, creation_time, text) values ('1', current_date, 'Вроде все сделал');


