package ch.brandon.hackerrank.math;

import java.math.BigInteger;

public class SummingNSeries {

    static int summingSeries(long n) {
        /*
         * Math:
         * T_n = n^2 - (n - 1)^2 =2n - 1
         * sum(T_n) = (n * (2n + 1 - 1)) / 2 = n^2
         * S_n = n^2
         */

        BigInteger bd = BigInteger.valueOf(n);
        BigInteger product = bd.multiply(bd);
        BigInteger modulo = BigInteger.valueOf(10).pow(9).add(BigInteger.valueOf(7));
        BigInteger result = product.remainder(modulo);
        return result.intValue();
    }

}