begin transaction;

drop table if exists cat_donations, dog_donations cascade;

create table cat_donations (
	id serial,
	item_name varchar(200),
    quantity int,
	constraint pk_cat_item primary key (id)
);

create table dog_donations (
	id serial,
	item_name varchar(200),
    quantity int,
	constraint pk_dog_item primary key (id)
);


INSERT INTO cat_donations (item_name, quantity)
VALUES ('dry_food', 0),
        ('wet_1halfoz',0),
        ('wet_3oz', 0),
        ('wet_5halfoz', 0),
        ('wet_12oz', 0),
        ('litter_5lb', 0),
        ('litter_10lb', 0),
        ('litter_15lb', 0),
        ('litter_20lb', 0),
        ('litter_35lb', 0);

INSERT INTO dog_donations (item_name, quantity)
VALUES	('dry_food', 0),
        ('wet_3oz', 0),
        ('wet_5oz', 0),
        ('wet_12oz', 0),
        ('wet_32oz', 0);

commit;