select*from customers;
alter table customers add GENDER varchar(3) after NAME;
select*from customers;
alter table customers modify GENDER boolean;
select*from customers;
alter table customers modify GENDER varchar(3);
select*from customers;
select*from customers order by NAME;
ALTER table customers rename TO QLCUSTUMERS;
select NAME,SALARY FROM QLCUSTUMERS;
select distinct SALARY FROM QLCUSTUMERS;