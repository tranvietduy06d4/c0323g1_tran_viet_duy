create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table customer(
cID int primary key,
cName varchar(255) not null,
cAge int not null check(cAge > 1 and cAge < 110)
);
create table product(
pID varchar(255) primary key,
pName varchar(255) not null,
pPrice double not null check(pPrice > 0)
);

create table `order`(
oID varchar(255) primary key,
cID int not null,
foreign key(cID) references customer(cID),
oDate date not null,
oTotalPrice double not null check(oTotalPrice > 0)
);

create table order_detail(
odQuantity int not null check(odQuantity >= 1),
oID varchar(255) not null,
foreign key(oID) references `order`(oID),
pID varchar(255) not null,
foreign key(pID) references product(pID),
primary key(oID,pID)
);