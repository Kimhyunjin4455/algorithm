    package org.example.binarySearch;

    import java.io.*;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class BinarySearch2512 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] budgets = new int[N];
            int budgetSum = 0;
            int maxBudget = 0;
            for (int i=0; i<N; i++){
                budgets[i] = Integer.parseInt(st.nextToken());
                budgetSum += budgets[i];
                maxBudget = Math.max(maxBudget, budgets[i]);

            }

            Arrays.sort(budgets);

            int M = Integer.parseInt(br.readLine());
            int start = 0;
            int end = maxBudget;
            int result = 0;

            if (budgetSum <= M) bw.write(String.valueOf(maxBudget));
            else {
                while (start <= end) {
                    int resultSum = 0;
                    int mid = (start + end) / 2;
                    for (int budget : budgets) {
                        if (mid < budget) resultSum += mid;
                        else resultSum += budget;
                    }
                    if (resultSum <= M) {
                        result = mid;
                        start = mid + 1;
                    } else if (resultSum > M) {
                        end = mid - 1;
                    }
                }
                bw.write(String.valueOf(start-1));
            }

            bw.flush();
            bw.close();
            br.close();

        }
    }
