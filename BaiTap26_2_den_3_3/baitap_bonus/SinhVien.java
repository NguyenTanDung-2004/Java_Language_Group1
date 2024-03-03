package oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SinhVien {
	private String MSSV;
	private String HoTen;
	public ArrayList<Lop> getLophoc() {
		return lophoc;
	}
	public void setLophoc(ArrayList<Lop> lophoc) {
		this.lophoc = lophoc;
	}
	private int So_TC;
	private int So_Lop;
	ArrayList<Lop> lophoc;
	public String getMSSV() {
		return MSSV;
	}
	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public int getSo_TC() {
		return So_TC;
	}
	public void setSo_TC(int so_TC) {
		So_TC = so_TC;
	}
	public int getSo_Lop() {
		return So_Lop;
	}
	public void setSo_Lop(int so_Lop) {
		So_Lop = so_Lop;
	}
	public SinhVien() {
		MSSV = "";
		HoTen = "";
		So_Lop = 0;
		So_TC = 0;
		lophoc = new ArrayList<>();
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("MSSV: ");
		this.MSSV = sc.next();
		System.out.print("Ho Ten: ");
		this.HoTen = sc.next();
	}
	public void xuat() {
		System.out.println("MSSV: " + MSSV);
		System.out.println("HOTEN: " + this.HoTen);
	}
	public void remove_lop() {
		this.lophoc.clear();
	}
	public void tang_solop() {
		this.So_Lop++;
	}
	public void tang_tinchi(int x) {
		this.So_TC = this.So_TC + x;
	}
	public static void sapXepTheoThuVaTiet(ArrayList<Lop> lophoc) {
        Collections.sort(lophoc, new Comparator<Lop>() {
            @Override
            public int compare(Lop lop1, Lop lop2) {
                // So sánh theo trường "thu" trước
                int compareThu = Integer.compare(Integer.parseInt(lop1.getThu()), Integer.parseInt(lop2.getThu()));
                if (compareThu != 0) {
                    return compareThu;
                }
                // Nếu "thu" bằng nhau, so sánh theo trường "tiet_BD"
                return Integer.compare(lop1.getTiet_BD(), lop2.getTiet_BD());
            }
        });
    }
	public void thkb(SinhVien sv) {
		sapXepTheoThuVaTiet(sv.getLophoc());
		for (int i = 0; i < sv.getLophoc().size(); i++) {
			sv.getLophoc().get(i).xuat();
		}
	}
}
