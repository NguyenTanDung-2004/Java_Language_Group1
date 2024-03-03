package oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Lop {
	private String MaLop;
	private String Ten_MH;
	private int So_TC;
	private int Tiet_BD;
	private int Tiet_KT;
	private String Thu;
	private String Thgian_BD;
	private String Thgian_KT;
	public int getTiet_BD() {
		return Tiet_BD;
	}
	public void setTiet_BD(int tiet_BD) {
		Tiet_BD = tiet_BD;
	}
	public int getTiet_KT() {
		return Tiet_KT;
	}
	public void setTiet_KT(int tiet_KT) {
		Tiet_KT = tiet_KT;
	}
	public String getMaLop() {
		return MaLop;
	}
	public void setMaLop(String maLop) {
		MaLop = maLop;
	}
	public String getTen_MH() {
		return Ten_MH;
	}
	public void setTen_MH(String ten_MH) {
		Ten_MH = ten_MH;
	}
	public int getSo_TC() {
		return So_TC;
	}
	public void setSo_TC(int so_TC) {
		So_TC = so_TC;
	}
	public String getThu() {
		return Thu;
	}
	public void setThu(String thu) {
		Thu = thu;
	}
	public String getThgian_BD() {
		return Thgian_BD;
	}
	public void setThgian_BD(String thgian_BD) {
		Thgian_BD = thgian_BD;
	}
	public String getThgian_KT() {
		return Thgian_KT;
	}
	public void setThgian_KT(String thgain_KT) {
		Thgian_KT = thgain_KT;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("MA LOP: ");
		this.MaLop = sc.next();
		System.out.print("Ten Mon Hoc: ");
		this.Ten_MH = sc.next();
		System.out.print("So tin chi: ");
		this.So_TC = sc.nextInt();
		System.out.print("Tiet BD: ");
		this.Tiet_BD = sc.nextInt();
		System.out.print("Tiet KT: ");
		this.Tiet_KT = sc.nextInt();
		System.out.print("Thu: ");
		this.Thu = sc.next();
		System.out.print("Ngay BD(dd/mm/yy/): ");
		this.Thgian_BD = sc.next();
		System.out.print("Ngay KT(dd/mm/yy/): ");
		this.Thgian_KT = sc.next();
	}
	public void xuat() {
	    System.out.println("MA LOP: " + this.MaLop);
	    System.out.println("Ten Mon Hoc: " + this.Ten_MH);
	    System.out.println("So tin chi: " + this.So_TC);
	    System.out.println("Tiet BD: " + this.Tiet_BD);
	    System.out.println("Tiet KT: " + this.Tiet_KT);
	    System.out.println("Thu: " + this.Thu);
	    System.out.println("Ngay BD(dd/mm/yy/): " + this.Thgian_BD);
	    System.out.println("Ngay KT(dd/mm/yy/): " + this.Thgian_KT);
	}
	public boolean kiem_tra_lich_trung(Lop l1, Lop l2) { // hàm này có tác dụng kiểm tra xem hai môn học có trùng lịch học hay không. False la khong trùng
		if (l1.Thu.equals(l2.Thu)) {
			if (kiem_tra_tiet_kt(l1, l2)) {
				if (l1.Tiet_BD <= l2.Tiet_KT) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				if (l2.Tiet_BD <= l1.Tiet_KT) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	public boolean kiem_tra_tiet_kt(Lop l1, Lop l2) { // hàm này kiểm tra xem tiết kết thúc nào lớn hơn. ( true la l1 >= l2 ). Trường hợp hai lớp cùng một hôm.
		if (l1.Tiet_KT >= l2.Tiet_KT) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean kiem_tra_lophoc_trung_lich(Lop l, ArrayList<Lop> list) { // hàm này kiểm tra một lop hoc có trùng lịch với các môn trong thời khóa biểu hay không. True là trùng.
		for (int i = 0; i < list.size(); i++) {
			if (kiem_tra_lich_trung(l, list.get(i))) {
				return true;
			}
		}
		return false;
	}
	public void them_monhoc() { // hàm này có tác dụng thêm môn học vào trong HashMap.
		monhoc.monhoc_soluong.put(this.Ten_MH, 0);
	}
	
}
