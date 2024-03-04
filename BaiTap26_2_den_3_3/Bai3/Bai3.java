import java.util.Scanner;

public class Bai3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng số nguyên: ");
        int n = scanner.nextInt();

        int[] NumArray = new int[n];

        // Nhap cac so nguyen
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập số nguyên thứ " + (i + 1) + ": ");
            NumArray [i] = scanner.nextInt();
        }

        // Sap xep theo thu tu tang dan
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (NumArray [i] > NumArray [j]) {
                    int temp = NumArray [i];
                    NumArray [i] = NumArray [j];
                    NumArray [j] = temp;
                }
            }
        }

        // Xuat ket qua
        for (int number : NumArray ) {
            System.out.print(number + " ");
        }
    }
}
