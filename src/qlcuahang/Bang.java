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
public class Bang extends MatHang {

    ArrayList<Bang> arr = new ArrayList<>();
    private long thoiGian;

    public Bang(long thoiGian, int maSo, String tuaDe, String nhaXuatBan, float giaBan) {
        super(maSo, tuaDe, nhaXuatBan, giaBan);
        this.thoiGian = thoiGian;
    }

    public ArrayList<Bang> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Bang> arr) {
        this.arr = arr;
    }

    public long getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(long thoiGian) {
        this.thoiGian = thoiGian;
    }

    public ArrayList<Bang> NhapBang() {
        Scanner sc = new Scanner(System.in);
        char check = 'n';

        System.out.println(".......Nhập băng......");
        do {
            Bang bang = new Bang(0, 0, "", "", 0);
            bang.Nhap();
            System.out.print("Nhập thời gian: ");
            bang.setThoiGian(KiemTra.KtraSo());
            arr.add(bang);
            System.out.print("Bạn có muốn nhập tiếp không(Y/n): ");
            check = Character.toLowerCase((sc.nextLine().charAt(0)));
        } while (check == 'y');
        return arr;
    }

    public void XuatBang() {
        Iterator it = arr.iterator();
        while (it.hasNext()) {
            Bang bang = (Bang) it.next();
            bang.Xuat();
            System.out.println("\t\t" + bang.getThoiGian());
        }
    }
}
