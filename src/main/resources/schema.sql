create table student (
    id int8 primary key,
    first_name varchar,
    national_id int8
);

insert into student values (1, 'Mehdi', '23524');
insert into student values (2, 'Hasan', '5898348');

create table invoice (
    id int8 primary key,
    customer_name varchar,
    status varchar,
    is_warning boolean,
    warning_reason varchar,
    version int8
);

insert into invoice values (1, 'Mehdi', 'PAID', FALSE, NULL, 0);