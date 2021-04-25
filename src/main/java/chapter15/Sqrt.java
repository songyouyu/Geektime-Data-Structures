package chapter15;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 使用二分法求一个数的平方根, 精确到小数点后 6 位
 *
 * @author songyouyu
 * @date 2021/4/23 23:35
 */
public class Sqrt {

    private static final double PRECISION = 0.000001;

    public double sqrt(double x) {
        double l = 0;
        double r = x;

        if (x < 1 && x > 0) {
            l = x;
            r = 1;
        }

        double mid = l + (r - l) / 2;
        while (l <= r) {
            if (mid * mid < x) {
                l = mid + PRECISION;
            } else if (mid * mid > x) {
                r = mid - PRECISION;
            } else {
                return new BigDecimal(mid).setScale(6, RoundingMode.HALF_UP).doubleValue();
            }
            mid = l + (r - l) / 2;
        }

        return new BigDecimal(mid).setScale(6, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().sqrt(0.5));
        System.out.println(new Sqrt().sqrt(5));
    }

}
