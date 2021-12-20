USE [quanly_dienthoai]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[idChiTietHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[idSanPham] [int] NOT NULL,
	[idChiTietSanPham] [int] NOT NULL,
	[idHoaDon] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[Gia] [float] NOT NULL,
	[TongTien] [float] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[idChiTietHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuNhap]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuNhap](
	[idChiTietPhieuNhap] [int] IDENTITY(1,1) NOT NULL,
	[idPhieuNhap] [int] NOT NULL,
	[idSanPham] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[GiaTien] [float] NOT NULL,
	[TongTien] [float] NOT NULL,
 CONSTRAINT [PK_ChiTietPhieuNhap_1] PRIMARY KEY CLUSTERED 
(
	[idChiTietPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSanPham](
	[idChiTietSanPham] [int] IDENTITY(1,1) NOT NULL,
	[DungLuong] [nvarchar](50) NULL,
	[idSanPham] [int] NOT NULL,
	[MauSac] [nvarchar](15) NOT NULL,
	[HangSanXuat] [nvarchar](55) NOT NULL,
	[SoLuong] [int] NOT NULL,
 CONSTRAINT [PK_ChiTietSanPham_1] PRIMARY KEY CLUSTERED 
(
	[idChiTietSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DANHMUC]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DANHMUC](
	[maDanhMuc] [int] IDENTITY(1,1) NOT NULL,
	[tenDanhMuc] [nvarchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maDanhMuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[idHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[idKhachHang] [int] NULL,
	[idNhanVien] [int] NOT NULL,
	[idKhuyenMai] [int] NULL,
	[SoLuong] [int] NOT NULL,
	[TongTien] [float] NOT NULL,
	[NgayLap] [datetime] NOT NULL,
	[HinhThucThanhToan] [nvarchar](55) NOT NULL,
	[GhiChu] [nvarchar](150) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[idHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[idKhachHang] [int] IDENTITY(1,1) NOT NULL,
	[TenKhachHang] [nvarchar](55) NOT NULL,
	[SoDienThoai] [varchar](15) NOT NULL,
	[DiaChi] [nvarchar](150) NOT NULL,
	[CMND] [varchar](9) NOT NULL,
	[GhiChu] [nvarchar](150) NOT NULL,
	[GioiTInh] [nvarchar](4) NOT NULL,
	[Email] [nvarchar](55) NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[idKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHOHANG]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHOHANG](
	[maSanPham] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[giaNhap] [float] NOT NULL,
	[giaBan] [float] NOT NULL,
	[maPhieuNhap] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[idKhuyenMai] [int] IDENTITY(1,1) NOT NULL,
	[TenKhuyenMai] [nvarchar](55) NOT NULL,
	[PhanTramKhuyenMai] [int] NOT NULL,
	[GhiChu] [nvarchar](150) NULL,
 CONSTRAINT [PK_KhuyenMai] PRIMARY KEY CLUSTERED 
(
	[idKhuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[idLoaiSanPham] [int] IDENTITY(1,1) NOT NULL,
	[TenLoaiSanPham] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_idLoaiSanPham] PRIMARY KEY CLUSTERED 
(
	[idLoaiSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[idNhaCungCap] [int] IDENTITY(1,1) NOT NULL,
	[TenNhaCungCap] [nvarchar](155) NOT NULL,
	[SoDienThoai] [varchar](15) NOT NULL,
	[Email] [nvarchar](55) NOT NULL,
	[TongMua] [float] NOT NULL,
	[DiaChi] [nvarchar](150) NOT NULL,
	[GhiChu] [nvarchar](150) NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[idNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[idNhanVien] [int] IDENTITY(1,1) NOT NULL,
	[TenNhanVien] [nvarchar](55) NOT NULL,
	[GioiTinh] [nvarchar](4) NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[CMND] [varchar](9) NOT NULL,
	[SoDienThoai] [varchar](15) NOT NULL,
	[Email] [nvarchar](55) NULL,
	[NgayVaoLam] [date] NOT NULL,
	[Lv] [int] NOT NULL,
	[TenDangNhap] [varchar](50) NOT NULL,
	[MatKhau] [varchar](50) NOT NULL,
	[TrangThai] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[idNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuBaoHanh]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuBaoHanh](
	[idPhieuBaoHanh] [int] IDENTITY(1,1) NOT NULL,
	[idHoaDon] [int] NOT NULL,
	[idKhachHang] [int] NOT NULL,
	[idNhanVien] [int] NOT NULL,
	[NgayLap] [datetime] NOT NULL,
	[LyDo] [nvarchar](150) NOT NULL,
	[ThoiGianBaoTri] [nvarchar](50) NOT NULL,
	[TrangThai] [nvarchar](50) NOT NULL,
	[ChiPhiBaoHanh] [float] NOT NULL,
	[GhiChu] [nvarchar](150) NULL,
 CONSTRAINT [PK_PhieuBaoHang] PRIMARY KEY CLUSTERED 
(
	[idPhieuBaoHanh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[idPhieuNhap] [int] IDENTITY(1,1) NOT NULL,
	[idNhaCungCap] [int] NOT NULL,
	[NgayNhap] [datetime] NOT NULL,
	[TongTien] [float] NOT NULL,
	[TrangThai] [nvarchar](50) NOT NULL,
	[SoLuong] [int] NOT NULL,
 CONSTRAINT [PK_PhieuNhap] PRIMARY KEY CLUSTERED 
(
	[idPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[idSanPham] [int] IDENTITY(1,1) NOT NULL,
	[idLoaiSanPham] [int] NOT NULL,
	[TenSanPham] [nvarchar](150) NOT NULL,
	[GiaNhap] [float] NOT NULL,
	[GiaBan] [float] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[DVT] [nvarchar](15) NOT NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[idSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SUKIEN]    Script Date: 12/17/2021 1:26:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SUKIEN](
	[maKhuyenMai] [int] IDENTITY(1,1) NOT NULL,
	[giaTriKhuyenMai] [int] NOT NULL,
	[ngayBatDau] [varchar](20) NOT NULL,
	[ngayKetThuc] [varchar](20) NOT NULL,
	[noiDungKhuyenMai] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maKhuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] ON 
GO
INSERT [dbo].[ChiTietHoaDon] ([idChiTietHoaDon], [idSanPham], [idChiTietSanPham], [idHoaDon], [SoLuong], [Gia], [TongTien]) VALUES (142, 2043, 1056, 1189, 3, 5500000, 14791800)
GO
INSERT [dbo].[ChiTietHoaDon] ([idChiTietHoaDon], [idSanPham], [idChiTietSanPham], [idHoaDon], [SoLuong], [Gia], [TongTien]) VALUES (143, 2044, 1057, 1189, 4, 30000, 14791800)
GO
INSERT [dbo].[ChiTietHoaDon] ([idChiTietHoaDon], [idSanPham], [idChiTietSanPham], [idHoaDon], [SoLuong], [Gia], [TongTien]) VALUES (144, 2033, 1043, 1190, 1, 17500000, 17500000)
GO
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[ChiTietPhieuNhap] ON 
GO
INSERT [dbo].[ChiTietPhieuNhap] ([idChiTietPhieuNhap], [idPhieuNhap], [idSanPham], [SoLuong], [GiaTien], [TongTien]) VALUES (1014, 14, 2025, 2, 4500000, 9000000)
GO
INSERT [dbo].[ChiTietPhieuNhap] ([idChiTietPhieuNhap], [idPhieuNhap], [idSanPham], [SoLuong], [GiaTien], [TongTien]) VALUES (1015, 14, 2026, 2, 3000000, 6000000)
GO
SET IDENTITY_INSERT [dbo].[ChiTietPhieuNhap] OFF
GO
SET IDENTITY_INSERT [dbo].[ChiTietSanPham] ON 
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1019, N'8GB', 2024, N'Đỏ', N'SamSung', 9)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1020, N'8GB', 2024, N'Đen', N'SamSung', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1021, N'8GB', 2024, N'Hồng', N'SamSung', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1022, N'16GB', 2024, N'Hồng', N'SamSung', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1023, N'16GB', 2024, N'Đen', N'SamSung', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1024, N'16GB', 2024, N'Đỏ', N'SamSung', 9)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1025, N'8GB', 2025, N'Đen', N'SamSung', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1026, N'16GB', 2025, N'Đỏ', N'SamSung', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1027, N'16GB', 2025, N'Đen', N'SamSung', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1028, N'8GB', 2026, N'Đỏ', N'SamSung', 3)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1029, N'8GB', 2026, N'Đen', N'SamSung', 3)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1030, N'8GB', 2027, N'Đen', N'SamSung', 3)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1031, N'8GB', 2027, N'Đỏ', N'SamSung', 4)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1032, N'8GB', 2028, N'Đỏ', N'Apple', 7)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1033, N'8GB', 2028, N'Đen', N'Apple', 4)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1034, N'8GB', 2029, N'Đen', N'Apple', 4)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1035, N'16GB', 2029, N'Đen', N'Apple', 4)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1036, N'16GB', 2030, N'Đen', N'Apple', 4)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1037, N'8GB', 2030, N'Đen', N'Apple', 4)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1038, N'16GB', 2031, N'Đen', N'Apple', 4)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1039, N'32GB', 2031, N'Đen', N'Apple', 4)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1040, N'32GB', 2032, N'Đen', N'Apple', 4)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1041, N'64GB ', 2032, N'Đỏ', N'Apple', 5)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1042, N'64GB ', 2033, N'Đỏ', N'SamSung', 9)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1043, N'64GB ', 2033, N'Đen', N'SamSung', 8)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1044, N'8GB', 2034, N'Đen', N'Xiaomi', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1045, N'8GB', 2035, N'Gold', N'Oppo', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1046, N'8GB', 2036, N'Gold', N'Oppo', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1047, N'8GB', 2036, N'Đen', N'Oppo', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1048, N'8GB', 2036, N'Trắng', N'Oppo', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1049, N'8GB', 2037, N'Trắng', N'Oppo', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1050, N'8GB', 2037, N'Đen', N'Oppo', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1051, N'8GB', 2040, N'Đen', N'Oppo', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1052, N'8GB', 2040, N'Đỏ', N'Oppo', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1053, N'8GB', 2041, N'Đỏ', N'SamSung', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1054, N'8GB', 2042, N'Đỏ', N'Apple', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1055, N'8GB', 2042, N'Đen', N'Apple', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1056, N'', 2043, N'Đen', N'Apple', 7)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1057, N'', 2044, N'Đen', N'Không', 6)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1058, N'', 2044, N'Trắng', N'Không', 10)
GO
INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat], [SoLuong]) VALUES (1059, N'', 2046, N'Trắng', N'Apple', 9)
GO
SET IDENTITY_INSERT [dbo].[ChiTietSanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1162, 1, 1, 1013, 3, 1000000, CAST(N'2021-01-01T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1163, 2, 2, 1013, 4, 2500000, CAST(N'2021-02-01T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1164, 2, 2, 1013, 4, 2000000, CAST(N'2021-03-01T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1165, 3, 2, 1013, 4, 2100000, CAST(N'2021-04-01T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1166, 4, 2, 1013, 4, 2200000, CAST(N'2021-05-01T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1167, 5, 2, 1013, 4, 2300000, CAST(N'2021-06-01T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1168, 6, 2, 1013, 5, 2500000, CAST(N'2021-07-01T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1169, 7, 2, 1013, 5, 2500000, CAST(N'2021-08-01T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1172, 9, 2, 1013, 5, 2500000, CAST(N'2021-09-01T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1173, 10, 2, 1013, 5, 3000000, CAST(N'2021-09-01T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1174, 1, 1, 1013, 5, 3000000, CAST(N'2021-10-01T00:00:00.000' AS DateTime), N'TIền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1175, 1, 1, 1013, 5, 3000000, CAST(N'2021-10-01T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1177, 1, 1, 1013, 5, 3500000, CAST(N'2021-11-01T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1178, 2, 2, 1013, 6, 1000000, CAST(N'2021-12-01T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1179, 2, 2, 1013, 6, 1500000, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1180, 2, 2, 1013, 6, 2000000, CAST(N'2021-12-03T00:00:00.000' AS DateTime), N'TIền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1181, 3, 2, 1013, 7, 1600000, CAST(N'2021-12-04T00:00:00.000' AS DateTime), N'TIền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1182, 4, 1, 1013, 1, 1700000, CAST(N'2021-12-05T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1183, 5, 1, 1013, 2, 1100000, CAST(N'2021-12-05T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1184, 6, 2, 1013, 2, 1500000, CAST(N'2021-12-06T00:00:00.000' AS DateTime), N'TIền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1185, 7, 2, 1013, 2, 1700000, CAST(N'2021-12-06T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1187, 9, 2, 1013, 2, 1800000, CAST(N'2021-12-07T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1188, 10, 2, 1013, 1, 2000000, CAST(N'2021-12-08T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1189, 1, 1, 1015, 7, 14791800, CAST(N'2021-12-17T12:04:19.627' AS DateTime), N'Tiền Mặt', N'Đã xong')
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1190, 5, 1, 1013, 1, 17500000, CAST(N'2021-12-17T12:12:24.007' AS DateTime), N'Tiền Mặt', N'')
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1191, 1, 1, 1015, 2, 13000000, CAST(N'2021-01-02T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1192, 10, 1, 1015, 3, 30000000, CAST(N'2021-01-03T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1193, 9, 1, 1015, 3, 40000000, CAST(N'2021-02-04T00:00:00.000' AS DateTime), N'TIền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1194, 7, 1, 1015, 3, 40000000, CAST(N'2021-03-05T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1195, 6, 1, 1016, 2, 10000000, CAST(N'2021-04-06T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1196, 5, 1, 1015, 2, 20000000, CAST(N'2021-05-05T00:00:00.000' AS DateTime), N'TIền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1197, 4, 1, 1015, 2, 20000000, CAST(N'2021-12-01T00:00:00.000' AS DateTime), N'TIền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1198, 3, 1, 1015, 1, 10000000, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [SoLuong], [TongTien], [NgayLap], [HinhThucThanhToan], [GhiChu]) VALUES (1199, 2, 1, 1015, 2, 5000000, CAST(N'2021-12-05T00:00:00.000' AS DateTime), N'Tiền Mặt', NULL)
GO
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 
GO
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (1, N'', N'', N'', N'', N'Khách vãn lai', N'', N'')
GO
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (2, N'Phan Thanh Thắng', N'0374984567', N'Đắk Lắk', N'24175487', N'Khách VIP', N'Nam', N'gnaht.asdzxc@gmail.com')
GO
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (3, N'Lý Xuân Quý', N'0374567892', N'Đắk Lắk', N'241245423', N'', N'Nam', N'Quy@gmail.com')
GO
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (4, N'Nguyễn Thị Liên', N'0987458569', N'123 Hùng Vương, Quảng Phú', N'241585696', N'', N'Nam', N'Lien1234@gmail.com')
GO
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (5, N'Nguyễn Xuân Phát', N'0147585869', N'Buôn Ma Thuột', N'241253458', N'', N'Nam', N'Phatabc@gmail.com')
GO
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (6, N'Nguyễn Thị Liên', N'0374561232', N'Đắk Nông', N'241254123', N'', N'Nam', N'lien@gmail.com')
GO
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (7, N'Nguyễn Văn Quế', N'0456785485', N'145 Hùng Vương, BMT', N'241456458', N'', N'Nam', N'quy123@gmail.com')
GO
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (9, N'Nguyễn Văn Quỳ', N'0456785444', N'148 Cao bá Quát, BMT', N'241454562', N'', N'Nam', N'quy1asd@gmail.com')
GO
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (10, N'Trần Thị Tuyết', N'0956485756', N'Thôn 1, Eakpam', N'241456785', N'', N'Nam', N'tuyet@gmail.com')
GO
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (11, N'Phan Thanh Hưng', N'0978456125', N'Đắk Lắk', N'241564785', N'', N'nam', N'test@gmail.com')
GO
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
INSERT [dbo].[KHOHANG] ([maSanPham], [soLuong], [giaNhap], [giaBan], [maPhieuNhap]) VALUES (1, 10, 1000, 10000, 3)
GO
INSERT [dbo].[KHOHANG] ([maSanPham], [soLuong], [giaNhap], [giaBan], [maPhieuNhap]) VALUES (2, 30, 1000, 10000, 3)
GO
INSERT [dbo].[KHOHANG] ([maSanPham], [soLuong], [giaNhap], [giaBan], [maPhieuNhap]) VALUES (1, 10, 1000, 10000, 3)
GO
INSERT [dbo].[KHOHANG] ([maSanPham], [soLuong], [giaNhap], [giaBan], [maPhieuNhap]) VALUES (2, 30, 1000, 10000, 3)
GO
SET IDENTITY_INSERT [dbo].[KhuyenMai] ON 
GO
INSERT [dbo].[KhuyenMai] ([idKhuyenMai], [TenKhuyenMai], [PhanTramKhuyenMai], [GhiChu]) VALUES (1013, N'None', 0, N'None')
GO
INSERT [dbo].[KhuyenMai] ([idKhuyenMai], [TenKhuyenMai], [PhanTramKhuyenMai], [GhiChu]) VALUES (1015, N'20/11', 11, N'Ngày nhà giáo Việt Nam')
GO
INSERT [dbo].[KhuyenMai] ([idKhuyenMai], [TenKhuyenMai], [PhanTramKhuyenMai], [GhiChu]) VALUES (1016, N'Black friday', 20, N'Black friday')
GO
INSERT [dbo].[KhuyenMai] ([idKhuyenMai], [TenKhuyenMai], [PhanTramKhuyenMai], [GhiChu]) VALUES (1017, N'Tết', 10, N'Năm mới')
GO
SET IDENTITY_INSERT [dbo].[KhuyenMai] OFF
GO
SET IDENTITY_INSERT [dbo].[LoaiSanPham] ON 
GO
INSERT [dbo].[LoaiSanPham] ([idLoaiSanPham], [TenLoaiSanPham]) VALUES (9, N'Điện Thoại')
GO
INSERT [dbo].[LoaiSanPham] ([idLoaiSanPham], [TenLoaiSanPham]) VALUES (10, N'Ốp Lưng')
GO
INSERT [dbo].[LoaiSanPham] ([idLoaiSanPham], [TenLoaiSanPham]) VALUES (11, N'Tai nghe')
GO
INSERT [dbo].[LoaiSanPham] ([idLoaiSanPham], [TenLoaiSanPham]) VALUES (12, N'Cục điện thoại')
GO
INSERT [dbo].[LoaiSanPham] ([idLoaiSanPham], [TenLoaiSanPham]) VALUES (13, N'Sạc dự phòng')
GO
INSERT [dbo].[LoaiSanPham] ([idLoaiSanPham], [TenLoaiSanPham]) VALUES (14, N'Miếng dán màn hình')
GO
INSERT [dbo].[LoaiSanPham] ([idLoaiSanPham], [TenLoaiSanPham]) VALUES (15, N'Sim điện thoại')
GO
INSERT [dbo].[LoaiSanPham] ([idLoaiSanPham], [TenLoaiSanPham]) VALUES (16, N'Dây sạc điện thoại')
GO
INSERT [dbo].[LoaiSanPham] ([idLoaiSanPham], [TenLoaiSanPham]) VALUES (17, N'Adapters')
GO
SET IDENTITY_INSERT [dbo].[LoaiSanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[NhaCungCap] ON 
GO
INSERT [dbo].[NhaCungCap] ([idNhaCungCap], [TenNhaCungCap], [SoDienThoai], [Email], [TongMua], [DiaChi], [GhiChu]) VALUES (6, N'Công Ty An Phát', N'0987456565', N'abc@gmail.com', 9900000, N'Đắk Lắk', N'Đã Đặt')
GO
SET IDENTITY_INSERT [dbo].[NhaCungCap] OFF
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON 
GO
INSERT [dbo].[NhanVien] ([idNhanVien], [TenNhanVien], [GioiTinh], [DiaChi], [CMND], [SoDienThoai], [Email], [NgayVaoLam], [Lv], [TenDangNhap], [MatKhau], [TrangThai]) VALUES (1, N'Phan Thanh Thắng', N'Nam', N'CưMgar Đắk Lắk', N'241721454', N'0374984567', N'gnaht.asdzxc@gmaiol.com', CAST(N'2018-07-30' AS Date), 1, N'admin', N'admin', N'Đang làm')
GO
INSERT [dbo].[NhanVien] ([idNhanVien], [TenNhanVien], [GioiTinh], [DiaChi], [CMND], [SoDienThoai], [Email], [NgayVaoLam], [Lv], [TenDangNhap], [MatKhau], [TrangThai]) VALUES (2, N'Lý Xuân Quý', N'Nam', N'Đắk Lắk', N'241754123', N'0374568545', N'quyxuan@gmail.com', CAST(N'2021-12-01' AS Date), 2, N'quy123', N'quy123', N'Đang làm')
GO
INSERT [dbo].[NhanVien] ([idNhanVien], [TenNhanVien], [GioiTinh], [DiaChi], [CMND], [SoDienThoai], [Email], [NgayVaoLam], [Lv], [TenDangNhap], [MatKhau], [TrangThai]) VALUES (3, N'Nguyễn Thị Hoa', N'Nam', N'Đắk Lắk', N'241721452', N'0978456232', N'hoa@gmail.com', CAST(N'2019-12-11' AS Date), 0, N'Hoa123123', N'123123', N'Nghỉ')
GO
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[PhieuBaoHanh] ON 
GO
INSERT [dbo].[PhieuBaoHanh] ([idPhieuBaoHanh], [idHoaDon], [idKhachHang], [idNhanVien], [NgayLap], [LyDo], [ThoiGianBaoTri], [TrangThai], [ChiPhiBaoHanh], [GhiChu]) VALUES (1027, 1198, 2, 1, CAST(N'2021-12-17T13:05:33.290' AS DateTime), N'Hỏng Màn Hình', N'7 Ngày', N'Vừa Nhận', 1000000, N'Thay màn')
GO
SET IDENTITY_INSERT [dbo].[PhieuBaoHanh] OFF
GO
SET IDENTITY_INSERT [dbo].[PhieuNhap] ON 
GO
INSERT [dbo].[PhieuNhap] ([idPhieuNhap], [idNhaCungCap], [NgayNhap], [TongTien], [TrangThai], [SoLuong]) VALUES (14, 6, CAST(N'2021-12-17T13:16:22.147' AS DateTime), 9000000, N'Đã giao', 5)
GO
SET IDENTITY_INSERT [dbo].[PhieuNhap] OFF
GO
SET IDENTITY_INSERT [dbo].[SanPham] ON 
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2024, 9, N'SamSung Galaxy S10', 5000000, 6000000, 42, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2025, 9, N'SamSung A20', 4000000, 5000000, 18, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2026, 9, N'SamSung J7', 7500000, 8000000, 6, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2027, 9, N'SamSung J8', 8000000, 8500000, 7, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2028, 9, N'Iphone 7', 7000000, 8000000, 11, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2029, 9, N'Iphone 8', 8000000, 9000000, 8, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2030, 9, N'Iphone X', 9000000, 9900000, 8, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2031, 9, N'Iphone 11', 8000000, 8900000, 8, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2032, 9, N'Iphone 13 Pro Max', 3400000, 3500000, 9, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2033, 9, N'SamSung Galaxy S21 5G', 7500000, 8520000, 17, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2034, 9, N'Xiaomi 11T ', 10000000, 12000000, 6, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2035, 9, N'Oppo Reno6 5G', 9000000, 10000000, 6, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2036, 9, N'Oppo A54', 9000000, 9900000, 18, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2037, 9, N'Oppo A95', 6000000, 7000000, 12, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2039, 9, N'Oppo A74', 6000000, 7000000, 0, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2040, 9, N'Oppo A55', 4000000, 5000000, 12, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2041, 9, N'SamSung Galaxy A22', 5000000, 5500000, 6, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2042, 9, N'Iphone X', 9000000, 9900000, 12, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2043, 11, N'Tai nghe Bluetooth AirPod Pro', 5000000, 5500000, 7, N'Cái')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2044, 11, N'Tai Nghe Thường', 20000, 30000, 16, N'Dây')
GO
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (2046, 16, N'Dây Sạc Iphone', 100000, 200000, 9, N'Cái')
GO
SET IDENTITY_INSERT [dbo].[SanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[SUKIEN] ON 
GO
INSERT [dbo].[SUKIEN] ([maKhuyenMai], [giaTriKhuyenMai], [ngayBatDau], [ngayKetThuc], [noiDungKhuyenMai]) VALUES (1, 10, N'1-1-1990', N'1-1-1990', N'dfbsfgd')
GO
INSERT [dbo].[SUKIEN] ([maKhuyenMai], [giaTriKhuyenMai], [ngayBatDau], [ngayKetThuc], [noiDungKhuyenMai]) VALUES (2, 50, N'12-11-2021', N'12-11-2021', N'20 thang 11')
GO
SET IDENTITY_INSERT [dbo].[SUKIEN] OFF
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_ChiTietSanPham1] FOREIGN KEY([idChiTietSanPham])
REFERENCES [dbo].[ChiTietSanPham] ([idChiTietSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_ChiTietSanPham1]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon1] FOREIGN KEY([idHoaDon])
REFERENCES [dbo].[HoaDon] ([idHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon1]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SanPham] FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([idSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuNhap_PhieuNhap] FOREIGN KEY([idPhieuNhap])
REFERENCES [dbo].[PhieuNhap] ([idPhieuNhap])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] CHECK CONSTRAINT [FK_ChiTietPhieuNhap_PhieuNhap]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuNhap_SanPham] FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([idSanPham])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] CHECK CONSTRAINT [FK_ChiTietPhieuNhap_SanPham]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_SanPham1] FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([idSanPham])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_SanPham1]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([idKhachHang])
REFERENCES [dbo].[KhachHang] ([idKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhuyenMai] FOREIGN KEY([idKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([idKhuyenMai])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhuyenMai]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NhanVien] ([idNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[PhieuBaoHanh]  WITH CHECK ADD  CONSTRAINT [FK_PhieuBaoHang_NhanVien] FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NhanVien] ([idNhanVien])
GO
ALTER TABLE [dbo].[PhieuBaoHanh] CHECK CONSTRAINT [FK_PhieuBaoHang_NhanVien]
GO
ALTER TABLE [dbo].[PhieuBaoHanh]  WITH CHECK ADD  CONSTRAINT [FK_PhieuBaoHanh_KhachHang] FOREIGN KEY([idKhachHang])
REFERENCES [dbo].[KhachHang] ([idKhachHang])
GO
ALTER TABLE [dbo].[PhieuBaoHanh] CHECK CONSTRAINT [FK_PhieuBaoHanh_KhachHang]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhaCungCap] FOREIGN KEY([idNhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([idNhaCungCap])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhaCungCap]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_idLoaiSanPham] FOREIGN KEY([idLoaiSanPham])
REFERENCES [dbo].[LoaiSanPham] ([idLoaiSanPham])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_idLoaiSanPham]
GO
