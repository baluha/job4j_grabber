insert into company(id, name) values(1, 'samsung');
insert into company(id, name) values(2, 'apple');
insert into company(id, name) values(3, 'huawei');
insert into company(id, name) values(4, 'lenovo');

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

select person.name as name
from person
where company_id !=4;

select p.name as Человек, c.name as Компания
from person as p
join company as c
on p.company_id = c.id;

SELECT company_id, COUNT(*) as how_many
from person
group by company_id
order by how_many desc limit 1;

SELECT c.name, COUNT(p.company_id)
from company as c
join person as p
on p.company_id = c.id
group by c.name
order by count desc
limit 1;