package MangPhanSo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		
		System.out.print("Nhap so luong phan so trong mang: ");
		int n = scanner.nextInt();
		
		PhanSo[] ps = new PhanSo[n];
		
		for(int i =0 ;i< ps.length; i++)
		{
			System.out.print("Nhap phan so (a/b) thu " + (i+1) + ": ");
			
			ps[i] = new PhanSo();
			
			ps[i].Nhap();
		}
		
		System.out.println("Mang phan so cua ban la: ");
		for(int j = 0 ;j<n; j++)
		{
			System.out.print(ps[j].toString() + "\t");
		}
		
		PhanSo min = ps[0];
		for(int i = 1; i <n; i++)
		{
			if(ps[i].getGiaTri() < min.getGiaTri()) 
				min = ps[i];
		}
		System.out.println("\nPhan so nho nhat trong mang: " + min.toString());
		
		PhanSo max = ps[0];
		for(int i = 1; i <n; i++)
		{
			if(ps[i].getGiaTri() > max.getGiaTri()) 
				max = ps[i];
		}
		System.out.print("Phan so lon nhat trong mang: " + max.toString());
		
	}

}
