package juyeop.dp;

import java.util.Scanner;

/** 2023-08-01
 * 큰 문제를 작은 문제로 나누어 해결할 수 있나? -> O, 작은 문제가 중복돼 메모이제이션으로 해결할 수 있나? -> O
 * 이유는? -> 10의 경우에 2로 나누어 떨어지고 이때 / 2 를 하면 5가 되는데 5에 해당하는 결과를 미리 메모이제이션 한다면 재계산을 할 필요가 없음.
 * 2, 1
 * 3, 1
 * 4, 2, 1
 * 5, 4, 2, 1
 * 6, 2, 1
 * 7, 6, 2, 1
 * 8, 4, 2, 1
 * 9, 3, 1
 * 10, 9, 3, 1
 * 11, 10, 9, 3, 1
 *
 * 0, 1, 1, 2, 3, 2, 3, 3, 2, 3
 * */
public class Boj1463 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n + 1];

        dp[1] = 0;

        /**
         *         for (int i = 4; i <= n; i++) {
         *             if (i % 3 == 0) {
         *                 dp[i] = dp[i / 3] + 1;
         *             } else if (i % 2 == 0) {
         *                 dp[i] = dp[i / 2] + 1;
         *             } else dp[i] = dp[i - 1] + 1;
         *         }
         * 9 까지는 결과가 잘 나오는데 10 에서 10 -> 9 -> 3 -> 1 이 아니라 10 -> 5 -> 4 -> 2 -> 1 의 로직을 타게 되어 적절한 로직이 아님.
         * */

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[n]);
    }
}