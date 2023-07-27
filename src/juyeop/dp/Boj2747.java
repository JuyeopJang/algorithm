package juyeop.dp;

import java.util.Scanner;

/** 2023-07-28
 * 피보나치 수열 문제로 전형적인 dp 문제다.
 * dp 특징은 크게 네 가지다.
 * 1. 큰 문제를 작은 문제로 나눌 수 있다. -> 점화식을 세운다.
 * 2. 작은 문제들이 반복되며 이 작은 문제들의 값은 항상 같다. -> 점화식을 이루는 부분 점화식이 중복되며 그 값은 같다.
 * 3. 모든 작은 문제들을 한 번만 계산해 dp 테이블에 저장해 추후 재사용할 때 참조한다. -> 배열, 2차원 배열, 3차원 배열에 저장한다.
 * 4. dp는 top-down, bottom-up 방식으로 구현할 수 있다.
 * */
public class Boj2747 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}