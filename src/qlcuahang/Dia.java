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
public class Dia extends MatHang {

    ArrayList<Dia> arr = new ArrayList<>();
    private long thoiGian;

    public Dia(long thoiGian, int maSo, String tuaDe, String nhaXuatBan, float giaBan) {
        super(maSo, tuaDe, nhaXuatBan, giaBan);
        this.thoiGian = thoiGian;
    }

    public long getThoiGian() {
        return thoiGian;
    }

    public ArrayList<Dia> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Dia> arr) {
        this.arr = arr;
    }

    public void setThoiGian(long thoiGian) {
        this.thoiGian = thoiGian;
    }

    public ArrayList<Dia> NhapDia() {
        Scanner sc = new Scanner(System.in);
        char check = 'n';
        System.out.println(".......Nhập đĩa......");
        do {
            Dia dia = new Dia(0, 0, "", "", 0);

            dia.Nhap();
            System.out.print("Nhập thời gian: ");
            dia.setThoiGian(KiemTra.KtraSo());
            arr.add(dia);
            System.out.print("Bạn có muốn nhập tiếp hay không(Y/n): ");
            check = Character.toLowerCase((sc.nextLine().charAt(0)));
        } while (check == 'y');
        return arr;
    }

    public void XuatDia() {
        Iterator it = arr.iterator();
        while (it.hasNext()) {
            Dia dia = (Dia) it.next();
            dia.Xuat();
            System.out.println("\t\t" + dia.getThoiGian());
        }

    }

}
