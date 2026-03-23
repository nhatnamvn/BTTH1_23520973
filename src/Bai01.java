import java.util.Random;
import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nhap ban kinh: ");
            double r = sc.nextDouble();
            double zero = r - r;              
            double one = r / r;                    
            double ten = one + one + one + one + one + one + one + one + one + one;
            double N = ten * ten * ten * ten * ten * ten; 
            double duongKinh = r + r;         
            double rBinhPhuong = r * r;       
            double n = zero;
            Random random = new Random();
            for (double i = zero; i < N; i += one) {
                double x = (random.nextDouble() * duongKinh) - r;
                double y = (random.nextDouble() * duongKinh) - r;
                if ((x * x) + (y * y) <= rBinhPhuong) {
                    n += one; 
                }
            }
            double dienTichHinhVuong = duongKinh * duongKinh;
            double dienTichHinhTron = (n / N) * dienTichHinhVuong;
            System.out.println("Dien tich hinh tron xap xi: " + dienTichHinhTron);
        }
    }
}