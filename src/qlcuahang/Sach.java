/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlcuahang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author thuancutee
 */
public class Sach extends MatHang {

    ArrayList<Sach> arr = new ArrayList<>();
    private String tenTacGia;
    private int soTrang;

    public Sach(String tenTacGia, int soTrang, int maSo, String tuaDe, String nhaXuatBan, float giaBan) {
        super(maSo, tuaDe, nhaXuatBan, giaBan);
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }

    public ArrayList<Sach> getArr() {
        return arr;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setArr(ArrayList<Sach> arr) {
        this.arr = arr;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public ArrayList<Sach> NhapSach() {
        Scanner sc = new Scanner(System.in);
        char check = 'n';
        System.out.println(".......Nhập sách......");
        do {
            Sach sach = new Sach("", 0, 0, "", "", 0);

            sach.Nhap();
            System.out.print("Nhập số trang: ");
            sach.setSoTrang(KiemTra.KtraSo());
            System.out.print("Nhập tên tác giả: ");
            sach.setTenTacGia(sc.nextLine());
            arr.add(sach);
            System.out.print("Bạn có muốn nhập tiếp hay không(Y/n): ");
            check = Character.toLowerCase((sc.nextLine().charAt(0)));
        } while (check == 'y');
        return arr;

    }

    public void XuatSach() {
        Iterator it = arr.iterator();
        while (it.hasNext()) {
            Sach sach = (Sach) it.next();
            sach.Xuat();
            System.out.println("\t\t" + sach.getSoTrang() + "\t\t" + sach.getTenTacGia());
        }

    }
}
