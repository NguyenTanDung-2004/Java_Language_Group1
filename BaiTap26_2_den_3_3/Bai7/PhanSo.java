package MangPhanSo;

import java.util.Scanner;

public class PhanSo {

	private int tu;
	private int mau;
	
	PhanSo()
	{
		tu=0;
		mau=1;
	}
	
	PhanSo(int tu, int mau)
	{
		this.tu=tu;
		this.mau=mau;
	}
	public double getGiaTri()
	{
		return (double) this.tu/this.mau;
	}
	public void Nhap()
	{
		Scanner scanner = new Scanner(System.in);
		String ps = scanner.next();
		String split[] = ps.split("/");
		
		if(split.length == 2)
		{
			this.tu = Integer.parseInt(split[0]);
			this.mau = Integer.parseInt(split[1]);
		}
	}
	public String toString()
	{
		return String.valueOf(this.tu) + "/" + String.valueOf(this.mau);
	}
}
