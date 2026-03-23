import java.util.Random;

public class Bai02 {
    public static void main(String[] args) {
        double r = 1.0;
        double zero = r - r;                               
        double ten = r+r+r+r+r+r+r+r+r+r;
        double N = ten * ten * ten * ten * ten * ten; 
        double duongKinh = r + r;         
        double rBinhPhuong = r * r;       
        double n = zero;
        Random random = new Random();
        for (double i = zero; i < N; i++) {
            double x = (random.nextDouble() * duongKinh) - r;
            double y = (random.nextDouble() * duongKinh) - r;
            if ((x * x) + (y * y) <= rBinhPhuong) {
                n++; 
            }
        }
        double dienTichHinhVuong = duongKinh * duongKinh;
        double piXapXi = dienTichHinhVuong * (n / N);
        System.out.println("Gia tri xap xi cua Pi la: " + piXapXi);
    }
}