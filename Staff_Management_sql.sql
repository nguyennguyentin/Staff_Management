	drop database staff_management;
    create database staff_management;
	use staff_management;

	create table part(
	id_part int primary key auto_increment,
	name_part varchar(100)
	);

	create table title(
	id_title int primary key auto_increment,
	name_title varchar(100)
	);
	
	create table staff(
	id_staff int primary key auto_increment,
	name_staff varchar(100),
	birthday date,
	cmnd varchar(9) unique,
	id_part int,
	id_title int,
	foreign key (id_title) references title(id_title),
	foreign key (id_part) references part(id_part)
	);

	INSERT INTO part (name_part) VALUES
	('- CHUA CO -'),
	('IT Department'),
	('HR Department'),
	('Finance Department');
	INSERT INTO title (name_title) VALUES
	('- CHUA CO -'),
    ('Manager'),
	('Developer'),
	('Analyst');
    INSERT INTO staff (name_staff, birthday, cmnd, id_part, id_title) VALUES
('Alice Nguyen', '1990-01-15', '123456789', 1, 1),
('Bob Tran', '1985-03-22', '234567890', 2, 2),
('Charlie Le', '1992-07-30', '345678901', 3, 3),
('Diana Pham', '1995-11-04', '456789012', 1, 2),
('Ethan Vo', '1988-06-18', '567890123', 2, 1),
('Fiona Ho', '1993-09-25', '678901234', 3, 3),
('George Lam', '1987-05-12', '789012345', 1, 1),
('Hana Ly', '1996-12-20', '890123456', 2, 3),
('Ivan Bui', '1991-04-09', '901234567', 3, 2),
('Jenny Phan', '1994-08-15', '012345678', 1, 1);

	