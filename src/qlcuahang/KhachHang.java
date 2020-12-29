/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlcuahang;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author thuancutee
 */
public class KhachHang {

    ArrayList<KhachHang> arr = new ArrayList<>();
    private int maSo;
    private String hoTen;
    private String soDienThoai;

    public KhachHang(int maSo, String hoTen, String soDienThoai) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
    }

    public int getMaSo() {
        return maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void NhapKhachHang() throws Exception {
        Scanner sc = new Scanner(System.in);
        char check = 'n';
        File file = new File("d:/khachhang.txt");
        OutputStream os = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        do {
            KhachHang kh = new KhachHang(0, "", "");

            System.out.print("Nhập mã số khách hàng: ");
            kh.setMaSo(sc.nextInt());
            System.out.print("Nhập tên khách hàng: ");
            kh.setHoTen(sc.nextLine());
            System.out.print("Nhập số điện thoại: ");
            kh.setSoDienThoai(sc.nextLine());

            arr.add(kh);
            try {
                String congchuoi = kh.getMaSo() + "/" + kh.getHoTen() + "/" + kh.getSoDienThoai();
                osw.write(congchuoi);
                osw.flush();
                System.out.println("Thành công");
            } catch (Exception e) {
                System.out.println("Thất bại");
            }
            System.out.print("Bạn có muốn nhập tiếp hay không(Y/n): ");
            check = Character.toLowerCase((sc.nextLine().charAt(0)));;
        } while (check == 'y');

    }

    public void XuatKhachHang() {
        Iterator it = arr.iterator();
        while (it.hasNext()) {
            KhachHang kh = (KhachHang) it.next();
            System.out.println(kh.getMaSo() + "\t\t" + kh.getHoTen() + "\t\t" + kh.getSoDienThoai());
        }
    }
}
