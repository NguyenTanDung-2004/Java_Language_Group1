import java.util.Scanner;
public class bai7 {

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
class PhanSo {

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
