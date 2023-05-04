create database QLNHANVIEN_NEW
go
use QLNHANVIEN_NEW
go
CREATE TABLE PhongBan(
   maPhong  VARCHAR (10) primary key,
   tenPhong NVARCHAR (30) NOT NULL,     
);
CREATE TABLE NhanVien(
   maNV int primary key,
   ho NVARCHAR (50)  NULL,
   ten NVARCHAR (50)  NULL,
   tuoi int NULL,
   phai bit  NULL,
   maPhong  VARCHAR (10) NULL,  
   tienLuong float,
   Constraint F_LP_HN Foreign key(maPhong) references PhongBan(maPhong),
);
INSERT PhongBan([maPhong], [tenPhong]) VALUES ('PHONG_TC', N'Phòng tổ chức')
INSERT PhongBan([maPhong], [tenPhong]) VALUES ('PHONG_KT', N'Phòng kỹ thuật')
INSERT PhongBan([maPhong], [tenPhong]) VALUES ('PHONG_NS', N'Phòng nhân sự')

INSERT NhanVien([maNV], [ho],[ten],[tuoi],[phai],[maPhong],[tienLuong]) VALUES (1, N'Ly',N'Thong',23,1,N'PHONG_TC',20000000)
INSERT NhanVien([maNV], [ho],[ten],[tuoi],[phai],[maPhong],[tienLuong]) VALUES (4, N'Thach',N'Sanh',23,1,N'PHONG_KT',26000000)
INSERT NhanVien([maNV], [ho],[ten],[tuoi],[phai],[maPhong],[tienLuong]) VALUES (9, N'Anh',N'Minh',23,1,N'PHONG_TC',36000000)
