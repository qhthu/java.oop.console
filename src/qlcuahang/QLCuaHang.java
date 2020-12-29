/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlcuahang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author thuancutee
 */
public class QLCuaHang {

    public static ArrayList<Bang> arrB = new ArrayList<>();
    public static ArrayList<Sach> arrS = new ArrayList<>();
    public static ArrayList<Dia> arrD = new ArrayList<>();
    public static ArrayList<HoaDon> arrHD = new ArrayList<>();
    public static ArrayList<KhachHang> arrKH = new ArrayList<>();

    public static ArrayList<Sach> XLSach() {
        Sach sach = new Sach("", 0, 0, "", "", 0);
        arrS = sach.NhapSach();
        sach.XuatSach();

        try {
            File file = new File("d:/sach.txt");
            OutputStream os = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            Iterator it = arrS.iterator();
            while (it.hasNext()) {
                Sach b = (Sach) it.next();
                String congchuoi = b.getMaSo() + "/" + b.getTuaDe() + "/" + b.getGiaBan() + "/" + b.getNhaXuatBan() + "/" + b.getTenTacGia() + "/" + b.getSoTrang() + "\n";
                osw.write(congchuoi);
                osw.flush();
            }
            os.close();
            osw.close();
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            System.out.println("Không thành công");
        }
        return arrS;
    }

    public static ArrayList<Dia> XLDia() {

        Dia dia = new Dia(0, 0, "", "", 0);
        arrD = dia.NhapDia();
        dia.XuatDia();
        try {
            File file = new File("d:/dia.txt");
            OutputStream os = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            Iterator it = arrD.iterator();
            while (it.hasNext()) {
                Dia b = (Dia) it.next();
                String congchuoi = b.getMaSo() + "/" + b.getTuaDe() + "/" + b.getGiaBan() + "/" + b.getNhaXuatBan() + "/" + b.getThoiGian() + "\n";

                osw.write(congchuoi);
                osw.flush();
            }
            os.close();
            osw.close();

            System.out.println("Thêm thành công");
        } catch (Exception e) {
            System.out.println("Không thành công");
        }
        return arrD;
    }

    public static ArrayList XLBang() {

        Bang bang = new Bang(0, 0, "", "", 0);
        arrB = bang.NhapBang();
        bang.XuatBang();
        try {

            File file = new File("d:/bang.txt");
            OutputStream os = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(os);

            Iterator it = arrB.iterator();
            while (it.hasNext()) {
                Bang b = (Bang) it.next();
                String congchuoi = b.getMaSo() + "/" + b.getTuaDe() + "/" + b.getGiaBan() + "/" + b.getNhaXuatBan() + "/" + b.getThoiGian() + "\n";
                osw.write(congchuoi);
                osw.flush();
            }
            os.close();
            osw.close();

            System.out.println("Thêm thành công");
        } catch (Exception e) {
            System.out.println("Không thành công");
        }
        return arrB;
    }

    public static void TachBang(ArrayList<Bang> arrB, String line) {
        String[] string;
        string = line.split("/");
        Bang b = new Bang(0, 0, line, line, 0);
        b.setMaSo(Integer.parseInt(string[0].trim()));
        b.setTuaDe(string[1]);
        b.setGiaBan(Float.parseFloat(string[2]));
        b.setNhaXuatBan(string[3]);
        b.setThoiGian(Integer.parseInt(string[4]));
        arrB.add(b);
    }

    public static void TachDia(ArrayList<Dia> arrD, String line) {
        String[] string;
        string = line.split("/");
        Dia b = new Dia(0, 0, line, line, 0);
        b.setMaSo(Integer.parseInt(string[0]));
        b.setTuaDe(string[1]);
        b.setGiaBan(Float.parseFloat(string[2]));
        b.setNhaXuatBan(string[3]);
        b.setThoiGian(Integer.parseInt(string[4]));
        arrD.add(b);
    }

    public static void TachSach(ArrayList<Sach> arrS, String line) {
        String[] string;
        string = line.split("/");
        Sach b = new Sach(line, 0, 0, line, line, 0);
        b.setMaSo(Integer.parseInt(string[0]));
        b.setTuaDe(string[1]);
        b.setGiaBan(Float.parseFloat(string[2]));
        b.setNhaXuatBan(string[3]);
        b.setTenTacGia(string[4]);
        b.setSoTrang(Integer.parseInt(string[5]));
        arrS.add(b);
    }

    public static void TachKhachHang(ArrayList<KhachHang> arrS, String line) {
        String[] string;
        string = line.split("/");
        KhachHang b = new KhachHang(0, "", "");
        b.setMaSo(Integer.parseInt(string[0]));
        b.setHoTen(string[1]);
        b.setSoDienThoai(string[2]);
        arrS.add(b);
    }

    public static void DocFile() throws Exception {
        File fileB = new File("d:/bang.txt");
        InputStream isBang = new FileInputStream(fileB);
        InputStreamReader isrBang = new InputStreamReader(isBang);
        BufferedReader readerBang = new BufferedReader(isrBang);
        String lineBang;
        while ((lineBang = readerBang.readLine()) != null) {
            TachBang(arrB, lineBang);
        }

        File fileD = new File("d:/dia.txt");
        InputStream isDia = new FileInputStream(fileD);
        InputStreamReader isrDia = new InputStreamReader(isDia);
        BufferedReader readerDia = new BufferedReader(isrDia);
        String lineDia = "";
        while ((lineDia = readerDia.readLine()) != null) {
            TachDia(arrD, lineDia);
        }

        File fileS = new File("d:/sach.txt");
        InputStream isSach = new FileInputStream(fileS);
        InputStreamReader isrSach = new InputStreamReader(isSach);
        BufferedReader readerSach = new BufferedReader(isrSach);
        String lineSach = "";
        while ((lineSach = readerSach.readLine()) != null) {
            TachSach(arrS, lineSach);
        }
        File fileKH = new File("d:/khachhang.txt");
        InputStream isKH = new FileInputStream(fileKH);
        InputStreamReader isrKH = new InputStreamReader(isKH);
        BufferedReader readerKH = new BufferedReader(isrKH);
        String lineKH = "";
        while ((lineKH = readerKH.readLine()) != null) {
            TachKhachHang(arrKH, lineKH);
        }
    }

    public static void TongGiaBanTungLoaiHang() {
        Iterator it = arrHD.iterator();
        float tongtienBang = 0, tongtienDia = 0, tongtienSach = 0;
        ArrayList<Integer> mabang;
        ArrayList<Integer> slbang;
        while (it.hasNext()) {
            HoaDon hd = (HoaDon) it.next();
            mabang = hd.getMaBang();
            slbang = hd.getSoLuongBang();
            tongtienBang += hd.TinhTongTienBang(arrB, mabang, slbang);
        }

        it = arrHD.iterator();
        while (it.hasNext()) {
            HoaDon hd = (HoaDon) it.next();
            mabang = hd.getMaDia();
            slbang = hd.getSoLuongDia();
            tongtienDia += hd.TinhTongTienDia(arrD, mabang, slbang);
        }

        it = arrHD.iterator();
        while (it.hasNext()) {
            HoaDon hd = (HoaDon) it.next();
            mabang = hd.getMaSach();
            slbang = hd.getSoLuongSach();
            tongtienSach += hd.TinhTongTienSach(arrS, mabang, slbang);
        }
        System.out.println("Tổng tiền của băng là: " + tongtienBang);
        System.out.println("Tổng tiền của đĩa là: " + tongtienDia);
        System.out.println("Tổng tiền của sách là: " + tongtienSach);

    }

    public static void KhachHangMuaNhieuNhat() {
        Iterator it = arrHD.iterator();
        float max = 0;
        int maKH = 0;
        while (it.hasNext()) {
            HoaDon hd = (HoaDon) it.next();
            if (hd.getTongTien() > max) {
                max = hd.getTongTien();
                maKH = hd.getMaKhachHang();
            }
        }
        Iterator KH = arrKH.iterator();
        while (KH.hasNext()) {
            KhachHang kh = (KhachHang) KH.next();
            if (kh.getMaSo() == maKH) {
                System.out.println("Mã số: " + kh.getMaSo());
                System.out.println("Họ và tên: " + kh.getHoTen());
                System.out.println("Số điện thoại: " + kh.getSoDienThoai());
                System.out.println("Tổng tiền đã mua: " + max);
            }
        }
    }

    public static void SapXepHoaDon() {
        Iterator it = arrHD.iterator();
        while (it.hasNext()) {
            HoaDon hdI = (HoaDon) it.next();
            while (it.hasNext()) {
                HoaDon hdJ = (HoaDon) it.next();
                if (hdI.getNgayBan().compareTo(hdJ.getNgayBan()) == 0) {
                    HoaDon tam = hdI;
                    hdI = hdJ;
                    hdJ = tam;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        DocFile();

        HoaDon hd = new HoaDon();
        boolean check = true;
        while (check) {
            System.out.println("1. Nhập, xuất danh sách các hóa đơn.");
            System.out.println("2. Sắp xếp danh sách các hóa đơn theo thứ tự tăng dần của ngày tháng năm.");
            System.out.println("3. Cho biết khách hàng có mua nhiều mặt hàng nhất.");
            System.out.println("4. Tính tổng trị giá bán của từng loại.");
            System.out.println("5. Lưu file");
            System.out.println("6. Thoát");
            System.out.print("Vui lòng nhập lựa chọn: ");
            int chon = KiemTra.KtraSo();
            switch (chon) {
                case 1: {
                    arrHD = hd.NhapHoaDon(arrB, arrD, arrS);
                    hd.XuatHoaDon();
                    break;
                }
                case 2: {
                    System.out.println("........................................");
                    System.out.println("Danh sách hóa đơn sau khi sắp xếp là: ");
                    SapXepHoaDon();
                    hd.XuatHoaDon();
                    break;
                }
                case 3: {
                    System.out.println("........................................");
                    KhachHangMuaNhieuNhat();
                    break;
                }
                case 4: {
                    System.out.println("..........................................");
                    TongGiaBanTungLoaiHang();
                    break;
                }
                case 5: {
                    XLBang();
                    XLDia();
                    XLSach();
                    break;
                }
                case 6: {
                    check = false;
                    break;
                }
            }
        }

    }

}
