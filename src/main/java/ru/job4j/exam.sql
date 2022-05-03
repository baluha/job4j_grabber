insert into company(id, name) values(1, 'samsung');
insert into company(id, name) values(2, 'apple');
insert into company(id, name) values(3, 'huawei');
insert into company(id, name) values(4, 'lenovo');
insert into company(id, name) values(5, 'motorola');

insert into person(id, name, company_id) values(1, 'petrov', 1);
insert into person(id, name, company_id) values(2, 'sidorov', 1);
insert into person(id, name, company_id) values(3, 'ivanov', 2);
insert into person(id, name, company_id) values(4, 'antonov', 2);
insert into person(id, name, company_id) values(5, 'gvedonov', 3);
insert into person(id, name, company_id) values(6, 'gvozdev', 3);
insert into person(id, name, company_id) values(7, 'vasivkov', 4);
insert into person(id, name, company_id) values(8, 'razlomov', 4);
insert into person(id, name, company_id) values(9, 'pupkin', 4);
insert into person(id, name, company_id) values(10, 'zubov', 2);
insert into person(id, name, company_id) values(11, 'vizov', 5);
insert into person(id, name, company_id) values(12, 'obrubov', 5);

select p.name as person_name, c.name as company_name
from person as p
join company as c
on p.company_id = c.id
where c.id !=5;

select p.name as Человек, c.name as Компания
from person as p
join company as c
on p.company_id = c.id;

select c.name, count(p)
from company c
join person p
on p.company_id = c.id
group by c.name
having count(p) =
(select max(count) from
(select c.name, count(p) from company c
join person p
on p.company_id = c.id
group by c.name
) as foo)