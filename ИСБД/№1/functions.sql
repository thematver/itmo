-- Create order

create or replace function add_order(service_id int, client_id int, address text, deadline date) 
returns void 
as 
$$  
begin
insert into "order"(service_id, client_id, creation_time, status, address, deadline) values (service_id, client_id, current_date, 'in_search', address, deadline);
end;
$$ language 'plpgsql';

-- Check auth

create or replace function check_auth(username text, pass text) 
returns boolean
as 
$$  
begin
select * from auth where login=username and password=pass;
if not found then
	return false;
else
	return true;
end if;
end;
$$ language 'plpgsql';

-- Get conflicts

create or replace function get_conflicts()
returns table(order_id int, specialist_id int, client_id int)
as 
$$  

declare 
	temp_order record;
	temp_client client;
	temp_specialist specialist;
	
begin

for temp_order in (
select * from "order" where status = "Conflict"
)
loop 
	temp_client:=temp.client_id;
	temp_specialist:=temp.specialist_id;
	return next;
end loop;
end;

$$ language 'plpgsql';

