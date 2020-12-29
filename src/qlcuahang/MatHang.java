/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlcuahang;

import java.util.Scanner;

/**
 *
 * @author thuancutee
 */
public class MatHang {

    private int maSo;
    private String tuaDe;
    private String nhaXuatBan;
    private float giaBan;

    public MatHang(int maSo, String tuaDe, String nhaXuatBan, float giaBan) {
        this.maSo = maSo;
        this.tuaDe = tuaDe;
        this.nhaXuatBan = nhaXuatBan;
        this.giaBan = giaBan;
    }

    public int getMaSo() {
        return maSo;
    }

    public String getTuaDe() {
        return tuaDe;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }

    public void setTuaDe(String tuaDe) {
        this.tuaDe = tuaDe;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã số: ");
        maSo = KiemTra.KtraSo();
        System.out.print("Nhập giá bán: ");
        giaBan = KiemTra.KtraSo();
        System.out.print("Nhập tựa đề: ");
        tuaDe = sc.nextLine();
        System.out.print("Nhập nhà sản xuất: ");
        nhaXuatBan = sc.nextLine();
    }

    public void Xuat() {
        System.out.print(maSo + "\t\t" + tuaDe + "\t\t" + nhaXuatBan + "\t\t" + giaBan);
    }

}
