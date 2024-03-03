package oop;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Main obj = new Main();
		obj.luu_y();
		int n = 0; // số lượng học sinh.
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số lượng học sinh: ");
		n = sc.nextInt();
		SinhVien sv_array[] = new SinhVien[n]; // mảng sinh viên.
		obj.nhap_n_sinhvien(sv_array, n);
		System.out.print("Nhập số lượng lớp học: ");
		int m = 0; // số lượng lớp học.
		m = sc.nextInt();
		Lop lop_array[] = new Lop[m];
		monhoc mb = new monhoc(); // khởi tạo hashmap trong môn học.
		obj.nhap_m_lop(lop_array, m);
		System.out.println("\n \n \n");
		System.out.println("Bắt đầu đăng kí học phần: ");
		obj.dang_ki_hp_cho_tat_ca_sinh_vien(sv_array, lop_array);
		System.out.println("Môn học có sinh viên đăng kí nhiều nhất: " + monhoc.monhoc_sv_dk_nhieunhat());
		System.out.println("Số lượng sinh viên đăng kí môn học trên: " + monhoc.so_sinhvien_cua_monhoc_dk_nhieunhat());
		obj.lich_hoc_cua_sinhvien(sv_array);
	}
	public void lich_hoc_cua_sinhvien(SinhVien sv_array[]) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Nhập mã số sinh viên và nhận được lịch học:");
			String MSSV = sc.next();
			if (lay_SinhVien_theoMSSV(sv_array, MSSV) == null) {
				System.out.println("không có sinh viên có MSSV này.");
			}
			else {
				SinhVien sv = lay_SinhVien_theoMSSV(sv_array, MSSV);
				sv.thkb(sv);
			}
			System.out.println("Bạn có muốn dừng chương trình? Y/N");
			String answer = sc.next();
			if(answer.equals("Y")) {
				return;
			}
		}
	}
	public void luu_y() {
		System.out.println("**** Chương Trình ****");
		System.out.println("- Một số lưu ý của chương trình: ");
		System.out.println("  + Mã lớp và mã học sinh là duy nhất.");
		System.out.println("\n \n \n");
	}
	public void nhap_n_sinhvien(SinhVien sv_array[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Sinh vien " + i + ":");
			sv_array[i] = new SinhVien();
			sv_array[i].nhap();
		}
	}
	public void xuat_n_sinhvien(SinhVien sv_array[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Sinh vien " + i + ":");
			sv_array[i].xuat();
		}
	}
	public void nhap_m_lop(Lop lop_array[], int m) {
		for (int i = 0; i < m; i++) {
			System.out.println("Lớp Học " + i + ":");
			lop_array[i] = new Lop();
			lop_array[i].nhap();
			lop_array[i].them_monhoc();
		}
	}
	public SinhVien lay_SinhVien_theoMSSV(SinhVien sv_array[], String MSSV) { // hàm này lấy ra sinh viên theo MSSV.
		for (int i = 0; i < sv_array.length; i++) {
			if (sv_array[i].getMSSV().equals(MSSV)) {
				return sv_array[i];
			}
		}
		return null;
	}
	public Lop lay_Lop_theoMaLop(Lop lop_list[], String MaLop) {
		for (int i = 0; i < lop_list.length; i++) {
			if (lop_list[i].getMaLop().equals(MaLop)) {
				return lop_list[i];
			}
		}
		return null;
	}
	public void dk_1_lop_hoc(SinhVien sv, Lop l) {
		if (l.kiem_tra_lophoc_trung_lich(l, sv.getLophoc())) {
			System.out.println("Bạn đang đăng kí môn học trùng lịch.");
			System.out.println("Bạn có muốn đăng kí lại từ đầu không? Y/N");
			Scanner sc = new Scanner(System.in);
			String answer = sc.next();
			if (answer.equals("Y")) {
				sv.remove_lop();
			}
		}
		else {
			if (sv.getSo_TC() + l.getSo_TC() > 24) {
				System.out.println("Số tín chỉ đã vượt quá 24 TC");
				return;
			}
			sv.tang_solop();
			System.out.println("Đăng kí thành công");
			sv.getLophoc().add(l);
			sv.tang_tinchi(l.getSo_TC());
			monhoc.tang_sl_dk(l.getTen_MH());
		}
	}
	public void dang_ki_hp_cho_1_sinhvien(SinhVien sv, Lop lop_list[]) { // hàm này giải quyết vấn đề đăng kí học phần cho một sinh viên.
		while (true) {
			if (sv.getSo_TC() == 24) {
				System.out.println("Số lượng tín chỉ đã đạt 24.");
				return;
			}
			// nhập mã môn học.
			System.out.print("Nhập mã lớp học đăng ký: ");
			Scanner sc = new Scanner(System.in);
			String MaLH = sc.next();
			// lấy ra lớp.
			Lop l = lay_Lop_theoMaLop(lop_list, MaLH);
			if (l == null) {
				System.out.println("Lớp không tồn tại");
				continue;
			}
			dk_1_lop_hoc(sv, l);
			if (14 - sv.getSo_TC() >= 0) {
				System.out.println("Còn thiếu " + (14 - sv.getSo_TC()));
			}
			else {
				System.out.println("số tín chỉ hiện tại là " + sv.getSo_TC() + "/24");
				System.out.println("Bạn có muốn đăng kí tiếp không? Y/N"); 
				String answer = sc.next();
				if (answer.equals("Y")) {
					continue;
				}
				else {
					return;
				}
			}
		}
	}
	public void dang_ki_hp_cho_tat_ca_sinh_vien(SinhVien sv_array[], Lop l_array[]) {
		for (int i = 0; i < sv_array.length; i++) {
			System.out.println("Sinh Vien " + i + " đăng kí môn học.");
			dang_ki_hp_cho_1_sinhvien(sv_array[i], l_array);
		}
	}
	public SinhVien lay_sinhvien_tc_caonhat(SinhVien sv_array[]) {
		SinhVien sv = sv_array[0];
		for (int i = 0; i < sv_array.length; i++) {
			if (sv.getSo_TC() < sv_array[i].getSo_TC()) {
				sv = sv_array[i];
			}
		}
		return sv;
	}
	public SinhVien lay_sinhvien_dk_nhieu_lop_nhat(SinhVien sv_array[]) {
		SinhVien sv = sv_array[0];
		for (int i = 0; i < sv_array.length; i++) {
			if (sv.getSo_Lop() < sv_array[i].getSo_Lop()) {
				sv = sv_array[i];
			}
		}
		return sv;
	}
}
