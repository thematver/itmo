/*
тригер №1 - если создается заказ, то создать чек
*/
create or replace function update_rating()
returns trigger as $$
declare
    spec_id int = (select s.id from specialist s
        inner join "order" o on s.id = o.specialist_id
                            where o.id = new.order_id);
    sum_rar int = (select sum(r.rating) from review r inner join "order" o2 on o2.id = r.order_id where o2.specialist_id = spec_id);
    count_rar int = (select count(*) from review r inner join "order" o3 on o3.id = r.order_id where o3.specialist_id = spec_id);
    new_rat int = sum_rar / count_rar;
begin
    update specialist set rating=new_rat where id = spec_id;
    return new;
end
$$ language 'plpgsql';

create trigger update_rating_tr after insert on "review"
    for each row execute procedure update_rating();





create or replace function update_master()
    returns trigger as $$
declare

begin
    if (new.status = 'blocked') then
        update "order" set status = 'in_search' where specialist_id = old.id;
        update "order" set specialist_id = null where specialist_id = old.id;
    end if;
    return new;
end
$$ language 'plpgsql';

create trigger update_master_tr after update on specialist
    for each row execute procedure update_master();


create index if not exists specialist_index_id on specialist using hash(id);
create index if not exists order_index_id on "order" using hash(id);
create index if not exists client_index_id on client using hash(id);



-- function for create payout
create or replace function create_payout(new_auth_id int, new_amount int, new_comment text)
returns void as $$
begin
    insert into payout (auth_id, amount, date, comment) values (new_auth_id, new_amount, (select now()), new_comment);
end
$$ language 'plpgsql';

select create_payout(1, 999, 'privet')
