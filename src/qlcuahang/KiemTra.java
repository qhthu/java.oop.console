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
public class KiemTra {

    public static int KtraSo() {
        Scanner s = new Scanner(System.in);
        int a;
        while (true) {
            try {
                a = s.nextInt();
                return a;
            } catch (Exception e) {
                System.out.println("Vui long nhap lai!");
                s.nextLine();
            }
        }
    }

}
