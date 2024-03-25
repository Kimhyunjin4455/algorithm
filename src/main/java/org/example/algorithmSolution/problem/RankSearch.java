package org.example.algorithmSolution.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class RankSearch {

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};

        int[] sol = solution(info, query);
        for(int i=0; i< sol.length; i++){
            if(i==0){
                System.out.print("["+sol[i]+",");
            }else if(i== sol.length-1){
                System.out.print(sol[i]+"]");
            }else System.out.print(sol[i]+",");
        }

    }



    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        // info 기반 hashMap 생성
        HashMap<String, ArrayList<Integer>> hashMap =  new HashMap<>();

        for(String i: info){
            String[] data = i.split(" ");
            String[] languages = {data[0], "-"};
            String[] jobs = {data[1], "-"};
            String[] exps = {data[2], "-"};
            String[] foods = {data[3], "-"};
            int value = Integer.parseInt(data[4]);

            for(String lang: languages){
                for (String job: jobs){
                    for (String exp: exps){
                        for (String food: foods){
                            String[] keyData = {lang, job, exp, food};
                            String key = String.join(" ", keyData);
                            ArrayList<Integer> arr = hashMap.getOrDefault(key, new ArrayList<Integer>());
                            // 있으면 key에 상응하는 ArrayList, 없으면 빈 리스트 생성
                            arr.add(value);
                            hashMap.put(key, arr);
                        }
                    }
                }
            }
        }

        for (ArrayList<Integer> arr: hashMap.values()) arr.sort(null);

        int idx=0;
        for(String q: query){
            String[] data = q.split(" and ");
            int target = Integer.parseInt(data[3].split(" ")[1]); // ex: "chicken 150"에서 150만 분리
            data[3] = data[3].split(" ")[0]; // 음식만 분리
            String key = String.join(" ", data);

            if(hashMap.containsKey(key)){
                ArrayList<Integer> list = hashMap.get(key);
                int start = 0;
                int end = list.size()-1;
                while(start<=end){
                    int mid = (start+end)/2;
                    if(list.get(mid) >= target){
                        end = mid-1;
                    }else start = mid+1;
                }
                answer[idx] = list.size()-start;
            }
            idx++;
        }
        return answer;
    }

    
}
