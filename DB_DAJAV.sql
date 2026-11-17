CREATE DATABASE DuAnJava1;
USE DuAnJava1;

-- 1. NHAN_VIEN (bang cha cua TAI_KHOAN va HOA_DON)
CREATE TABLE NHAN_VIEN (
    MaNV INT NOT NULL PRIMARY KEY,
    HoTen NVARCHAR(100) NOT NULL,
    GioiTinh BIT NOT NULL,                 -- 1: Nam, 0: Nu (quy uoc minh hoa)
    NgaySinh DATE NOT NULL,
    SoDienThoai VARCHAR(15) NOT NULL,
    DiaChi NVARCHAR(255) NOT NULL,
    TrangThai BIT NOT NULL DEFAULT 1
);

-- 2. TAI_KHOAN: moi nhan vien toi da mot tai khoan
CREATE TABLE TAI_KHOAN (
    MaTK INT NOT NULL PRIMARY KEY,
    TenDangNhap VARCHAR(50) NOT NULL UNIQUE,
    MatKhau VARCHAR(500) NOT NULL,
    VaiTro VARCHAR(20) NOT NULL,
    TrangThai BIT NOT NULL DEFAULT 1,
    MaNV INT NOT NULL UNIQUE,
    CONSTRAINT FK_TK_NV FOREIGN KEY (MaNV) REFERENCES NHAN_VIEN(MaNV),
    CONSTRAINT CK_TK_VaiTro CHECK (VaiTro IN ('NHAN_VIEN', 'QUAN_LY'))
);

-- 3. DANH_MUC
CREATE TABLE DANH_MUC (
    MaDM INT NOT NULL PRIMARY KEY,
    TenDM NVARCHAR(100) NOT NULL,
    MoTa NVARCHAR(255) NOT NULL,
    NgayTao DATE NOT NULL,
    TrangThai BIT NOT NULL DEFAULT 1
);

-- 4. SAN_PHAM: mot danh muc co nhieu san pham
CREATE TABLE SAN_PHAM (
    MaSP INT NOT NULL PRIMARY KEY,
    TenSP NVARCHAR(200) NOT NULL,
    MaDM INT NOT NULL,
    ThuongHieu NVARCHAR(100) NOT NULL,
    GiaBan DECIMAL(18,2) NOT NULL,
    HinhAnh VARCHAR(255) NOT NULL,
    TrangThai BIT NOT NULL DEFAULT 1,
    CONSTRAINT FK_SP_DM FOREIGN KEY (MaDM) REFERENCES DANH_MUC(MaDM),
    CONSTRAINT CK_SP_GiaBan CHECK (GiaBan >= 0)
);

-- 5. KICH_CO: luu so luong ton theo tung size cua tung mau giay
CREATE TABLE KICH_CO (
    MaKichCo INT NOT NULL PRIMARY KEY,
    MaSP INT NOT NULL,
    KichCo INT NOT NULL,
    SoLuongTon INT NOT NULL,
    NgayCapNhat DATE NOT NULL,
    TrangThai BIT NOT NULL DEFAULT 1,
    CONSTRAINT FK_KC_SP FOREIGN KEY (MaSP) REFERENCES SAN_PHAM(MaSP),
    CONSTRAINT UQ_KC_SP_Size UNIQUE (MaSP, KichCo),
    CONSTRAINT CK_KC_SoLuongTon CHECK (SoLuongTon >= 0),
    CONSTRAINT CK_KC_KichCo CHECK (KichCo > 0)
);

-- 6. HOA_DON: mot nhan vien lap duoc nhieu hoa don
CREATE TABLE HOA_DON (
    MaHD INT NOT NULL PRIMARY KEY,
    MaNV INT NOT NULL,
    NgayLap DATE NOT NULL,
    TongTien DECIMAL(18,2) NOT NULL,
    TienKhachDua DECIMAL(18,2) NOT NULL,
    TienThua DECIMAL(18,2) NOT NULL,
    TrangThai BIT NOT NULL DEFAULT 1,
    CONSTRAINT FK_HD_NV FOREIGN KEY (MaNV) REFERENCES NHAN_VIEN(MaNV),
    CONSTRAINT CK_HD_TongTien CHECK (TongTien >= 0),
    CONSTRAINT CK_HD_TienKhachDua CHECK (TienKhachDua >= 0),
    CONSTRAINT CK_HD_TienThua CHECK (TienThua >= 0)
);

-- 7. CHI_TIET_HOA_DON: bang trung gian giua HOA_DON va KICH_CO
CREATE TABLE CHI_TIET_HOA_DON (
    MaCTHD INT NOT NULL PRIMARY KEY,
    MaHD INT NOT NULL,
    MaKichCo INT NOT NULL,
    SoLuong INT NOT NULL,
    DonGia DECIMAL(18,2) NOT NULL,
    ThanhTien DECIMAL(18,2) NOT NULL,
    CONSTRAINT FK_CTHD_HD FOREIGN KEY (MaHD) REFERENCES HOA_DON(MaHD),
    CONSTRAINT FK_CTHD_KC FOREIGN KEY (MaKichCo) REFERENCES KICH_CO(MaKichCo),
    CONSTRAINT UQ_CTHD_HD_KC UNIQUE (MaHD, MaKichCo),
    CONSTRAINT CK_CTHD_SoLuong CHECK (SoLuong > 0),
    CONSTRAINT CK_CTHD_DonGia CHECK (DonGia >= 0),
    CONSTRAINT CK_CTHD_ThanhTien CHECK (ThanhTien >= 0)
);
GO
-- DU LIEU MAU: thong tin nhan vien la gia lap
INSERT INTO NHAN_VIEN (MaNV,HoTen,GioiTinh,NgaySinh,SoDienThoai,DiaChi,TrangThai) VALUES
(1,N'Nguyễn Minh Anh',1,'2000-04-12','0901234567',N'TP. Hồ Chí Minh',1),
(2,N'Trần Thảo Vy',0,'2002-07-08','0912345678',N'TP. Hồ Chí Minh',1),
(3,N'Lê Quốc Bảo',1,'2001-11-20','0987654321',N'Bình Dương',1);

-- CHI MINH HOA: MatKhau duoi day KHONG phai mat khau da bam.
-- Khi lap trinh dang nhap that, thay bang BCrypt/Argon2 va kiem tra bang thu vien tuong ung.
INSERT INTO TAI_KHOAN (MaTK,TenDangNhap,MatKhau,VaiTro,TrangThai,MaNV) VALUES
(1,'quanly01','DEMO_ONLY_CHANGE_ME','QUAN_LY',1,1),
(2,'nhanvien01','DEMO_ONLY_CHANGE_ME','NHAN_VIEN',1,2),
(3,'nhanvien02','DEMO_ONLY_CHANGE_ME','NHAN_VIEN',1,3);

INSERT INTO DANH_MUC (MaDM,TenDM,MoTa,NgayTao,TrangThai) VALUES
(1,N'Giày bóng đá',N'Giày đá bóng sân cỏ tự nhiên và sân cỏ nhân tạo','2026-11-01',1),
(2,N'Giày chạy bộ',N'Giày chạy bộ và tập luyện','2026-11-01',1),
(3,N'Giày bóng rổ',N'Giày dành cho tập luyện và thi đấu bóng rổ','2026-11-01',1);

INSERT INTO SAN_PHAM (MaSP,TenSP,MaDM,ThuongHieu,GiaBan,HinhAnh,TrangThai) VALUES
(1,N'Nike Mercurial Vapor',1,N'Nike',1800000,'mercurial.jpg',1),
(2,N'Adidas Predator Club',1,N'Adidas',1500000,'predator.jpg',1),
(3,N'Nike Pegasus',2,N'Nike',2200000,'pegasus.jpg',1),
(4,N'Adidas Duramo',2,N'Adidas',1200000,'duramo.jpg',1),
(5,N'Nike Precision',3,N'Nike',1900000,'precision.jpg',1),
(6,N'Under Armour Lockdown',3,N'Under Armour',1600000,'lockdown.jpg',1);

-- SoLuongTon la so ton SAU cac giao dich hoa don minh hoa ben duoi
INSERT INTO KICH_CO (MaKichCo,MaSP,KichCo,SoLuongTon,NgayCapNhat,TrangThai) VALUES
(1,1,40,9,'2026-11-11',1),
(2,1,41,6,'2026-11-11',1),
(3,2,40,8,'2026-11-11',1),
(4,2,42,5,'2026-11-11',1),
(5,3,39,10,'2026-11-11',1),
(6,3,40,6,'2026-11-11',1),
(7,4,41,12,'2026-11-11',1),
(8,4,42,5,'2026-11-11',1),
(9,5,42,8,'2026-11-11',1),
(10,5,43,5,'2026-11-11',1),
(11,6,41,9,'2026-11-11',1),
(12,6,42,6,'2026-11-11',1);

-- Hoa don chi thanh toan TIEN MAT
INSERT INTO HOA_DON (MaHD,MaNV,NgayLap,TongTien,TienKhachDua,TienThua,TrangThai) VALUES
(1,2,'2026-11-11',4000000,4000000,0,1),
(2,3,'2026-11-11',1500000,2000000,500000,1),
(3,2,'2026-11-11',4300000,4500000,200000,1),
(4,3,'2026-11-11',3100000,3500000,400000,1);

INSERT INTO CHI_TIET_HOA_DON (MaCTHD,MaHD,MaKichCo,SoLuong,DonGia,ThanhTien) VALUES
(1,1,1,1,1800000,1800000),
(2,1,6,1,2200000,2200000),
(3,2,3,1,1500000,1500000),
(4,3,9,1,1900000,1900000),
(5,3,7,2,1200000,2400000),
(6,4,4,1,1500000,1500000),
(7,4,11,1,1600000,1600000);
GO

-- KIEM TRA DU LIEU
SELECT * FROM NHAN_VIEN;
SELECT * FROM TAI_KHOAN;
SELECT * FROM DANH_MUC;
SELECT * FROM SAN_PHAM;
SELECT * FROM KICH_CO;
SELECT * FROM HOA_DON;
SELECT * FROM CHI_TIET_HOA_DON;

-- Tong so luong ton theo mau giay
SELECT sp.MaSP, sp.TenSP, SUM(kc.SoLuongTon) AS TongSoLuongTon
FROM SAN_PHAM sp
JOIN KICH_CO kc ON kc.MaSP = sp.MaSP
GROUP BY sp.MaSP, sp.TenSP;

-- Kiem tra tong chi tiet co khop tong hoa don
SELECT hd.MaHD, hd.TongTien, SUM(ct.ThanhTien) AS TongChiTiet
FROM HOA_DON hd
JOIN CHI_TIET_HOA_DON ct ON ct.MaHD = hd.MaHD
GROUP BY hd.MaHD, hd.TongTien;
