create database quan_ly_vat_tu;
use quan_ly_vat_tu;
create table vat_tu(
MaVatTu varchar(255) primary key,
TenVatTu varchar(255)
);

create table phieu_xuat (
SoPX varchar(255) primary key,
NgayXuat date

);

create table chi_tiet_phieu_xuat (
DGXuat float,
SLXuat int,
SoPX varchar(255),
MaVatTu varchar(255),
foreign key(SoPX) references phieu_xuat(SoPX),
foreign key(MaVatTu) references vat_tu(MaVatTu),
primary key(SoPX,MaVatTu)

);
create table SDT (
SoDT varchar(255) primary key
);

create table Phieu_nhap(
SoPN varchar(255) primary key,
NgayNhap date
);
create table chi_tiet_phieu_nhap(
DGNhap double,
SLNhap int,
MaVatTu varchar(255),
SoPN varchar(255),
foreign key(SoPN) references Phieu_nhap(SoPN),
foreign key(MaVatTu) references vat_tu(MaVatTu),
primary key(SoPN,MaVatTu)
);
create table DonDH(
SoDH varchar(255) primary key,
NgayDH date
);

create table NHACC (
MaNCC varchar(255) primary key,
TenNCC varchar(255),
DiaChi varchar(255),
`SDT` varchar(255),
foreign key(`SDT`) references SDT(SoDT),
SoDH varchar(255),
foreign key(SoDH) references DonDH(SoDH)
);

create table chi_tiet_DonDH(
MaVatTu varchar(255),
SoDH varchar(255),
foreign key(MaVatTu) references vat_tu(MaVatTu),
foreign key(SoDH) references DonDH(SoDH),
primary key(MaVatTu,SoDH)
);


