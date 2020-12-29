/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlcuahang;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author thuancutee
 */
public class HoaDon {

    ArrayList<HoaDon> arr = new ArrayList<>();
    ArrayList<Integer> maBang = new ArrayList<>();
    ArrayList<Integer> maDia = new ArrayList<>();
    ArrayList<Integer> maSach = new ArrayList<>();
    ArrayList<Integer> soLuongBang = new ArrayList<>();
    ArrayList<Integer> soLuongDia = new ArrayList<>();
    ArrayList<Integer> soLuongSach = new ArrayList<>();

    private int maKhachHang;
    private Date ngayBan;
    private float tongTien;

    public HoaDon() {

    }

    public HoaDon(int maKhachHang, Date ngayBan, float tongTien) {
        this.maKhachHang = maKhachHang;
        this.ngayBan = ngayBan;
        this.tongTien = tongTien;
    }

    public ArrayList<HoaDon> getArr() {
        return arr;
    }

    public ArrayList<Integer> getMaBang() {
        return maBang;
    }

    public ArrayList<Integer> getMaDia() {
        return maDia;
    }

    public ArrayList<Integer> getMaSach() {
        return maSach;
    }

    public ArrayList<Integer> getSoLuongBang() {
        return soLuongBang;
    }

    public ArrayList<Integer> getSoLuongDia() {
        return soLuongDia;
    }

    public ArrayList<Integer> getSoLuongSach() {
        return soLuongSach;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setArr(ArrayList<HoaDon> arr) {
        this.arr = arr;
    }

    public void setMaBang(ArrayList<Integer> maBang) {
        this.maBang = maBang;
    }

    public void setMaDia(ArrayList<Integer> maDia) {
        this.maDia = maDia;
    }

    public void setMaSach(ArrayList<Integer> maSach) {
        this.maSach = maSach;
    }

    public void setSoLuongBang(ArrayList<Integer> soLuongBang) {
        this.soLuongBang = soLuongBang;
    }

    public void setSoLuongDia(ArrayList<Integer> soLuongDia) {
        this.soLuongDia = soLuongDia;
    }

    public void setSoLuongSach(ArrayList<Integer> soLuongSach) {
        this.soLuongSach = soLuongSach;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public float TinhTongTienBang(ArrayList<Bang> arrBang, ArrayList<Integer> maBang, ArrayList<Integer> soLuongBang) {
        Iterator it1 = arrBang.iterator();
        Iterator it2 = maBang.iterator();
        Iterator it3 = soLuongBang.iterator();
        float tongtien = 0;
        while (it2.hasNext()) {
            int maso = (int) it2.next();
            int soluong = (int) it3.next();
            while (it1.hasNext()) {
                Bang b = (Bang) it1.next();
                if (maso == b.getMaSo()) {
                    tongtien += b.getGiaBan() * soluong;
                }
            }
        }
        return tongtien;
    }

    public float TinhTongTienDia(ArrayList<Dia> arrDia, ArrayList<Integer> maDia, ArrayList<Integer> soLuongDia) {
        float tongtien = 0;
        Iterator it4 = arrDia.iterator();
        Iterator it5 = maDia.iterator();
        Iterator it6 = soLuongDia.iterator();
        while (it5.hasNext()) {
            int maso = (int) it5.next();
            int soluong = (int) it6.next();
            while (it4.hasNext()) {
                Dia b = (Dia) it4.next();
                if (maso == b.getMaSo()) {
                    tongtien += b.getGiaBan() * soluong;
                }
            }
        }
        return tongtien;
    }

    public float TinhTongTienSach(ArrayList<Sach> arrSach, ArrayList<Integer> maSach, ArrayList<Integer> soLuongSach) {
        float tongtien = 0;
        Iterator it7 = arrSach.iterator();
        Iterator it8 = maSach.iterator();
        Iterator it9 = soLuongSach.iterator();
        while (it8.hasNext()) {
            int maso = (int) it8.next();
            int soluong = (int) it9.next();
            while (it7.hasNext()) {
                Sach b = (Sach) it7.next();
                if (maso == b.getMaSo()) {
                    tongtien += b.getGiaBan() * soluong;
                }
            }
        }
        return tongtien;
    }

    public ArrayList<HoaDon> NhapHoaDon(ArrayList<Bang> arrBang, ArrayList<Dia> arrDia, ArrayList<Sach> arrSach) {
        Scanner sc = new Scanner(System.in);
        char check, checkBang, checkDia, checkSach;
        int count = 0;
        do {
            HoaDon hd = new HoaDon();
            System.out.print("Nhập mã khách hàng: ");
            hd.setMaKhachHang(KiemTra.KtraSo());

            System.out.print("Nhập ngày bán: ");
            hd.setNgayBan(new Date());
            System.out.println("Nhập danh sách các mặt hàng ");

            do {
                System.out.println("Nhập mã băng thứ " + (count + 1) + ": ");
                maBang.add(KiemTra.KtraSo());
                System.out.println("Nhập số lượng của mã băng thứ " + (count + 1) + ": ");
                soLuongBang.add(KiemTra.KtraSo());
                count++;
                System.out.print("Bạn có muốn mua thêm băng hay không(Y/n): ");
                check = Character.toLowerCase((sc.nextLine().charAt(0)));
            } while (check == 'y');
            count = 0;
            do {
                System.out.println("Nhập mã đĩa thứ " + (count + 1) + ": ");
                maDia.add(KiemTra.KtraSo());
                System.out.println("Nhập số lượng của mã đĩa thứ " + (count + 1) + ": ");
                soLuongDia.add(KiemTra.KtraSo());
                count++;
                System.out.print("Bạn có muốn mua thêm đĩa hay không(Y/n): ");
                check = Character.toLowerCase((sc.nextLine().charAt(0)));
            } while (check == 'y');

            count = 0;
            do {
                System.out.println("Nhập mã sách thứ " + (count + 1) + ": ");
                maSach.add(KiemTra.KtraSo());
                System.out.println("Nhập số lượng của mã sách thứ " + (count + 1) + ": ");
                soLuongSach.add(KiemTra.KtraSo());
                count++;
                System.out.print("Bạn có muốn mua thêm sách hay không(Y/n): ");
                check = Character.toLowerCase((sc.nextLine().charAt(0)));
            } while (check == 'y');

            hd.setMaBang(maBang);
            hd.setMaDia(maDia);
            hd.setMaSach(maSach);
            hd.setSoLuongBang(soLuongBang);
            hd.setSoLuongDia(soLuongDia);
            hd.setSoLuongSach(soLuongSach);
            hd.setTongTien(TinhTongTienBang(arrBang, hd.getMaBang(), hd.getSoLuongBang()) + TinhTongTienDia(arrDia, hd.getMaDia(), hd.getSoLuongDia()) + TinhTongTienSach(arrSach, hd.getMaSach(), hd.getSoLuongSach()));
            arr.add(hd);
            maBang = new ArrayList<>();
            maDia = new ArrayList<>();
            maSach = new ArrayList<>();
            soLuongBang = new ArrayList<>();
            soLuongDia = new ArrayList<>();
            soLuongSach = new ArrayList<>();
            System.out.print("Bạn có muốn nhập hóa đơn mới hay không(Y/n): ");
            check = Character.toLowerCase((sc.nextLine().charAt(0)));
        } while (check == 'y');
        return arr;
    }

    public void XuatHoaDon() {
        Iterator it = arr.iterator();
        int dem = 1;
        while (it.hasNext()) {
            System.out.println(".....................................");
            System.out.println("\n\tHóa đơn thứ " + dem + "\n");
            HoaDon hd = (HoaDon) it.next();
            System.out.println("Ngày bán: " + hd.getNgayBan());
            System.out.println("Mã khách hàng: " + hd.getMaKhachHang());
            System.out.println("\tDanh sách mặt hàng");
            System.out.println("Băng");
            System.out.printf("%-10s%-10s", "Mã băng", "Số lượng");
            System.out.println("");
            for (int i = 0; i < hd.getMaBang().size(); i++) {
                System.out.printf("%-10s%-10s", hd.getMaBang().get(i), hd.getSoLuongBang().get(i));
                System.out.println("");
            }

            System.out.println("Đĩa");
            System.out.printf("%-10s%-10s", "Mã đĩa", "Số lượng");
            System.out.println("");
            for (int i = 0; i < hd.getMaDia().size(); i++) {
                System.out.printf("%-10s%-10s", hd.getMaDia().get(i), hd.getSoLuongDia().get(i));
                System.out.println("");
            }
            System.out.println("Sách");
            System.out.printf("%-10s%-10s", "Mã sách", "Số lượng");
            System.out.println("");
            for (int i = 0; i < hd.getMaSach().size(); i++) {
                System.out.printf("%-10s%-10s", hd.getMaSach().get(i), hd.getSoLuongSach().get(i));
                System.out.println("");
            }
            System.out.println("Tổng tiền: " + hd.getTongTien());
            dem++;
        }
    }

}
