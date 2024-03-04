import java.util.Scanner;

class MangSoNguyen {
    private int[] a;
    private int n;

    MangSoNguyen() {
        n = 0;
    }
    MangSoNguyen(int n) {
        this.n = n;
        a = new int[n];
    }
    public int getSLPT() {return n;}
    public void nhap(Scanner input) {
        
        for (int i = 0; i < a.length; i++) {
            System.out.print(" - Nhap phan tu thu " + (i+1) + ": ");
            a[i] = input.nextInt();
        }
    } 
    public void xuat() {
        System.out.print(" - Mang gom cac phan tu:\t");
        for (int x : a)
            System.out.print(x + " ");

        System.out.println();
    }
    public void xuatNguoc() {
        System.out.print(" - Mang gom cac phan tu (xuat nguoc):\t");
        for (int i = n - 1; i > -1; i--)
            System.out.print(a[i] + " ");

        System.out.println();
    }
    public int demPTChan() {
        int count = 0;
        for (int x : a)
            if (x % 2 == 0) count++;
        return count;
    }
    public int demPTLe() {
        return n - demPTChan();
    }
    public double giatriTB() {
        int sum = 0;
        for (int x : a) 
            sum += x;
        return (double)sum / n;
    }
    public int max() {
        int M = a[0];
        for (int x : a)
            if (x > M) M = x;
        return M;
    }
    public int min() {
        int m = a[0];
        for (int x : a)
            if (x < m) m = x;
        return m;
    }
    public void sepTang() {
        for (int i = 0; i < n-1; i++)
            for (int j = i+1; j < n; j++)
                if (a[j] < a[i]) {
                    int temp = a[i];
                    a[i] =  a[j];
                    a[j] = temp;
                }

        xuat();
    }
}
public class bai8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int chon = -1, n = 0;
        MangSoNguyen m = new MangSoNguyen();
        while (true) {
            System.out.println("\t=========== THAO TAC TREN MANG SO NGUYEN ===========");
            System.out.println("\t\t 0. EXIT");
            System.out.println("\t\t 1. Nhap mang moi");
            System.out.println("\t\t 2. Xuat mang");
            System.out.println("\t\t 3. Xuat theo chieu nguoc lai");
            System.out.println("\t\t 4. Dem so phan tu chan trong mang");
            System.out.println("\t\t 5. Dem so phan tu le trong mang");
            System.out.println("\t\t 6. Tinh gia tri trung binh cua mang");
            System.out.println("\t\t 7. Tim so lon nhat");
            System.out.println("\t\t 8. Tim so nho nhat");
            System.out.println("\t\t 9. Sap xep mang tang dan va xuat mang");

            System.out.print("~~~ Vui long chon thao tac can thuc hien: ");
            chon = input.nextInt();

            switch (chon) {
                case 0:
                    return;
                case 1:
                    if (n > 0) {
                        n = 0;
                        m = null;
                    }
                    while (n < 1) {
                        System.out.print("* Nhap so luong phan tu cua mang (n > 0): ");
                        n = input.nextInt();
                    }
                    m = new MangSoNguyen(n);
                    input.nextLine();
                    m.nhap(input);
                    break;
                case 2:
                    if (n == 0) {
                        System.out.println("Chua nhap mang.");
                        break;
                    }
                    m.xuat();
                    break;
                case 3:
                    if (n == 0) {
                        System.out.println("Chua nhap mang.");
                        break;
                    }
                    m.xuatNguoc();
                    break;
                case 4:
                    if (n == 0) {
                        System.out.println("Chua nhap mang.");
                        break;
                    }
                    System.out.println("So phan tu chan trong mang: " + m.demPTChan());
                    break;
                case 5:
                    if (n == 0) {
                        System.out.println("Chua nhap mang.");
                        break;
                    }
                    System.out.println("Sophan tu le trong mang: " + m.demPTLe());
                    break;
                case 6:
                    if (n == 0) {
                        System.out.println("Chua nhap mang.");
                        break;
                    }
                    System.out.println("Gia tri trung binh cua mang: " + m.giatriTB());
                    break;
                case 7:
                    if (n == 0) {
                        System.out.println("Chua nhap mang.");
                        break;
                    }
                    System.out.println("So lon nhat cua mang: " + m.max());
                    break;
                case 8:
                    if (n == 0) {
                        System.out.println("Chua nhap mang.");
                        break;
                    }
                    System.out.println("So nho nhat cua mang: " + m.min());
                    break;
                case 9:
                    if (n == 0) {
                        System.out.println("Chua nhap mang.");
                        break;
                    }
                    m.sepTang();
                    break;
                default:
                    System.out.println("!! Khong co thao tac nay.");
                    break;
            }
        }
    }
}
