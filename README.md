# HibernateContactManager--SpringMVC-
This is a sample project for Hibernate Configuration with Spring MVC

------------------------------------------------------------------------------------------
Oracle DB setup:

create table contacts (
  bid number(10) not null,
  firstname varchar2(20),
  lastname varchar2(20),
  email varchar2(50),
  telephone number(10),
  created date default sysdate,
  constraint contacts_pk primary key(bid)
);

create sequence contacts_seq;

insert into contacts (bid, firstname, lastname, email, telephone, created) 
values (contacts_seq.nextval,'Joe','Bonito','handsome@email.com',123-456-7890,sysdate);

commit;
