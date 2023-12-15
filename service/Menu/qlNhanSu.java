package service.Menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import core.HeThong;
import model.actionHopDong;
import model.actionNhanVien;
import model.actionPhongBan;
import model.HopDong;
import model.NhanVien;
import model.PhongBan;
import model.rwNhanSu;

public class qlNhanSu {
    public static void menuHopDong() {
        System.out.println("--------------danh sach chuc nang---------------");
        System.out.println("1.tim kiem hop dong");
        System.out.println("2.them hop dong");
        System.out.println("3.sua hop dong");
        System.out.println("4.xoa hop dong");
        System.out.println("5.danh sach hop dong");
        System.out.println("6.tro lai chuc nang quan ly nhan luc");
        System.out.println("9.dang xuat");
    }

    public static void menuPhongBan() {
        System.out.println("----------------danh sach chuc nang-----------------");
        System.out.println("1.tim kiem phong ban");
        System.out.println("2.them phong ban");
        System.out.println("3.sua phong ban");
        System.out.println("4.xoa phong ban");
        System.out.println("5.danh sach phong ban");
        System.out.println("6.tro lai chuc nang quan ly nhan luc");
        System.out.println("9.dang xuat");
    }

    public static void menuNhanVien() {
        System.out.println("------------danh sach chuc nang--------------");
        System.out.println("1.tim kiem Nhan vien");
        System.out.println("2.them Nhan vien");
        System.out.println("3.sua Nhan vien");
        System.out.println("4.xoa thong tin Nhan vien");
        System.out.println("5.danh sach Nhan vien");
        System.out.println("6.tro lai chuc nang quan ly nhan luc");
        System.out.println("9.dang xuat");
    }

    // public static void menuChucvu() {
    // System.out.println("--------------danh sach chuc nang-------------");
    // System.out.println("1.tim kien thong tin chuc vu");
    // System.out.println("2.them chuc vu");
    // System.out.println("3.sua chuc vu");
    // System.out.println("4.xoa chuc vu");
    // System.out.println("5.danh sach chuc vu");
    // System.out.println("6.tro lai chuc nang quan ly nhan luc");
    // System.out.println("9.dang xuat");
    // }

    public static void ChucNang() {
        int option = 0;
        Scanner inputs = new Scanner(System.in);

        do {
            try {
                System.out.println("----danh sach chuc nang-----");
                System.out.println("1.chuc nang quan ly hop dong");
                System.out.println("2.chuc nang quan ly nhan vien");
                System.out.println("3.chuc nang quan ly phong ban");
                // System.out.println("4.chuc nang quan ly chuc vu");
                System.out.println("9.dang xuat");
                System.out.print("nhap lua chon");
                option = inputs.nextInt();
            } catch (InputMismatchException ei) {
                System.out.println("loi lu chon vui long nhan lai");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (option == 9) {
                System.out.println("----------------------------------");
                System.out.println("da dang xuat !");
                System.out.println("---------------------------------");
                HeThong.state = 9;
                return;
            }
            if (option < 0 && option > 5) {
                System.out.println("loi  lua chon vui long nhap lai");
            }
        } while (option < 0 && option > 5);
        rwNhanSu a = new rwNhanSu();
        switch (option) {
            case 1: {
                int select = 0;
                menuHopDong();
                HopDong[] hopdong = a.ReadHopDong();
                actionHopDong hd = new actionHopDong(hopdong, hopdong.length);
                System.out.print("nhan  lua chon:");
                select = inputs.nextInt();
                if (select == 6) {
                    ChucNang();
                    return;
                }
                if (select == 9) {
                    System.out.println("----------------------------------");
                    System.out.println("da dang xuat !");
                    System.out.println("---------------------------------");
                    HeThong.state = 9;
                    return;
                }
                switch (select) {
                    case 1: {

                        System.out.println("----------------------------------");
                        System.out.println("chuc nang: tim kiem hop  dong");
                        hd.TimKiemThongTin();
                    }
                        break;
                    case 2: {

                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  them hop dong");
                        hd.ThemThongTin();
                        a.WriteHopDong(hd.getDanhSachHopDong(), hd.getKt());
                    }
                        break;
                    case 3: {

                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  sua hop dong");
                        hd.ChinhSuaThongTin();
                        a.WriteHopDong(hd.getDanhSachHopDong(), hd.getKt());
                    }
                        break;
                    case 4: {

                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  xoa hop dong");
                        hd.XoaThongTin();
                        a.WriteHopDong(hd.getDanhSachHopDong(), hd.getKt());
                    }
                        break;
                    case 5: {

                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:   danh sach hop dong");
                        hd.InDanhSach();
                        a.WriteHopDong(hd.getDanhSachHopDong(), hd.getKt());
                    }
                        break;
                    default:
                        break;
                }
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 6 de tro lai chuc nang quan ly nhan su");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 6) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }

                } while (select != 0 && select != 6);
                if (select == 6) {
                    ChucNang();
                    return;
                }
                if (select == 0) {
                    HeThong.state = 9;
                    return;
                }
            }
            case 2: {
                NhanVien[] nhanvien = a.ReadNhanVien();
                actionNhanVien nv = new actionNhanVien(nhanvien, nhanvien.length);
                int select = 0;
                menuNhanVien();
                System.out.print("nhan  lua chon:");
                select = inputs.nextInt();
                if (select == 6) {
                    ChucNang();
                    return;
                }
                if (select == 9) {
                    System.out.println("----------------------------------");
                    System.out.println("da dang xuat !");
                    System.out.println("---------------------------------");
                    HeThong.state = 9;
                    return;
                }
                switch (select) {
                    case 1: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang: tim kiem nhan vien");
                        nv.TimKiemThongTin();
                        a.WriteNhanVien(nv.getDanhSachNhanVien(), nv.getKt());
                    }
                        break;
                    case 2: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  them nhan vien");
                        nv.ThemThongTin();
                        a.WriteNhanVien(nv.getDanhSachNhanVien(), nv.getKt());
                    }
                        break;
                    case 3: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  sua nhan vien");
                        nv.ChinhSuaThongTin();
                        a.WriteNhanVien(nv.getDanhSachNhanVien(), nv.getKt());
                    }
                        break;
                    case 4: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  xoa nhan vien");
                        nv.XoaThongTin();
                        a.WriteNhanVien(nv.getDanhSachNhanVien(), nv.getKt());
                    }
                        break;
                    case 5: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:   danh sach nhan vien");
                        // List<NhanVien> list = HeThong.getList(1);
                        // for (NhanVien person : list) {
                        // System.out.println(person);
                        // }
                        nv.InDanhSach();
                    }
                        break;
                    default:
                        break;
                }
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 6 de tro lai chuc nang quan ly nhan su");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 6) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }

                } while (select != 0 && select != 6);
                if (select == 6) {
                    ChucNang();
                    return;
                }
                if (select == 0) {
                    HeThong.state = 9;
                    return;
                }
            }
            case 3: {
                int select = 0;
                menuPhongBan();
                PhongBan[] phongban = a.ReadPhongBan();
                actionPhongBan pb = new actionPhongBan(phongban, phongban.length);
                System.out.print("nhan  lua chon:");
                select = inputs.nextInt();
                if (select == 6) {
                    ChucNang();
                    return;
                }
                if (select == 9) {
                    System.out.println("----------------------------------");
                    System.out.println("da dang xuat !");
                    System.out.println("---------------------------------");
                    HeThong.state = 9;
                    return;
                }
                switch (select) {

                    case 1: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang: tim kiem phong ban");
                        pb.TimKiemThongTin();
                        a.WritePhongBan(pb.getDanhSachPhongBan(), pb.getKt());
                    }
                        break;
                    case 2: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  them phong ban");
                        pb.ThemThongTin();
                        a.WritePhongBan(pb.getDanhSachPhongBan(), pb.getKt());
                    }
                        break;
                    case 3: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  sua phong ban");
                        pb.ChinhSuaThongTin();
                        a.WritePhongBan(pb.getDanhSachPhongBan(), pb.getKt());
                    }
                        break;
                    case 4: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  xoa phong ban");
                        pb.XoaThongTin();
                        a.WritePhongBan(pb.getDanhSachPhongBan(), pb.getKt());
                    }
                        break;
                    case 5: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:   danh sach phong ban");
                        pb.InDanhSach();
                        a.WritePhongBan(pb.getDanhSachPhongBan(), pb.getKt());
                    }
                        break;
                    default:
                        break;
                }
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 6 de tro lai chuc nang quan ly nhan su");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 6) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }

                } while (select != 0 && select != 6);
                if (select == 6) {
                    ChucNang();
                    return;
                }
                if (select == 0) {
                    HeThong.state = 9;
                    return;
                }
            }
            default:
                break;
        }
    }
}
