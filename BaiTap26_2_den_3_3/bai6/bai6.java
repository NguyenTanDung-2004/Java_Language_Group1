import java.util.Scanner;

public class bai6 {
    // Hàm trả về tên của tháng dựa trên chỉ số [1 ... 12]
    public static String getMonthName(int m) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        return monthNames[m - 1];
    }
    
    // Hàm kiểm tra năm nhuận
    public static boolean isLeapYear(int y) {
        return (y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0)); 
    }

    // Hàm lấy tổng số ngày trong tháng 
    public static int getNumberOfDaysInMonth(int y, int m) {
        if (isLeapYear(y) && m == 2) 
            return 29;
        else if (m == 2) return 28;
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
            return 31;
        return 30;
    }

    // Hàm lấy ra thứ đầu tiên của tháng
    public static int getFirstDayOfMonth(int y, int m) {

        //Sử dụng công thức Zeller's congruence
        if (m < 3) {
            m = 12 + m;
            y--;
        }
        int k = y % 100;
        int j = y / 100;

        int h = (1 + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;

        // Đổi lại định dạng (0: Monday, 1: Tuesday, ... 6: Sunday)
        return (h + 5) % 7;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Nhập năm cần in lịch
        int y = 0;
        while (y < 1) {
            System.out.print("* Enter the year ( > 0): ");
            y = input.nextInt();
        }

        for (int m = 1; m <= 12; m++) {
            System.out.println("\t" + getMonthName(m) + ":");
            System.out.println("Mon\tTue\tWed\tThu\tFri\tSat\tSun");

            int numberOfDaysInMonth = getNumberOfDaysInMonth(y, m); // Lấy tổng số ngày trong tháng
            int firstDayOfMonth = getFirstDayOfMonth(y, m);    // Lấy thứ đầu tiên của tháng

            
            int dayOfWeek = firstDayOfMonth;    //Tuần đầu tiên bắt đầu từ thứ đầu tiên

            // In khoảng trắng của ngày 1 
            for (int i = 0; i < firstDayOfMonth; i++) {
                System.out.print("\t");
            }

            for (int day = 1; day <= numberOfDaysInMonth; day++) {
                System.out.printf("%2d\t", day); // In ngày

                if (dayOfWeek == 6) { // Nếu đã in đủ 7 ngày trong tuần, xuống dòng + reset lại số ngày trong tuần đã in.
                    System.out.println();
                    dayOfWeek = 0; 
                } else {
                    dayOfWeek++; // Tăng biến đếm ngày trong tuần
                }
            }

            System.out.println();
        }

        input.close();
    }
}
