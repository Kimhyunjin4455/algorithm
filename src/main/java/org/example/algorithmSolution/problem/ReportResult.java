package org.example.algorithmSolution;

import java.util.*;

public class ReportResult {
    // 각 유저는 한 번에 한 명의 유저를 신고
    // 신고 횟수에 제한은 없음
    // 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리
    // k번 이상 신고된 유저는 게시판 이용이 정지
    // 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
    // 유저가 신고한 모든 내용을 취합 -> 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송
    public static void main(String[] args) {
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

//        String[] id_list = new String[]{"con", "ryan"};
//        String[] report = new String[]{"ryan con", "ryan con", "ryan con", "ryan con"};
//        int k=3;
        int[] result = solution(id_list, report, k);
        for (int r: result) {
            System.out.print(r+" ");
        }
        System.out.println();

    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
//        int[] result = new int[k];
//        // 유저 id마다 신고한 사람이 다름
//        // 신고당한 사람 cnt++ (cnt==k -> 신고한 사람 cnt++) if 같은 사람 신고시에는 생략
//
//        LinkedHashMap<String, Integer> resultMap = new LinkedHashMap<>();   // 최종 정보(몇번 메일 통보받는지)
//        LinkedHashMap<String, Integer> reportedMap = new LinkedHashMap<>(); // 누가 몇번 신고 당했는지
//        LinkedHashMap<String, String> nowRepotedInfoMap = new LinkedHashMap<>();    // 중복 신고 안되도록 체크할 Map
//
//        // 신고 리스트에 대해
//        for (String s : report){
//            StringTokenizer st = new StringTokenizer(s, " ");
//            String reportingUser = st.nextToken();                          // 신고한 유저
//            String reportedUser = st.nextToken();                           // 신고당한 유저
//
//
//
//            if(nowRepotedInfoMap.get(reportingUser) != reportedUser){
//                // 중복 신고가 아니라면 신고를 하고
//                nowRepotedInfoMap.put(reportingUser, reportedUser);
//                reportedMap.put(reportedUser, reportedMap.getOrDefault(reportedUser,0)+1);
//                System.out.println(reportedUser);   // 신고 당한 사람 출력
//                // 그 후 신고 횟수가 정지기준 이상이라면 최종 정보 +1
//                if(reportedMap.get(reportedUser) >= k){
//                    resultMap.put(reportingUser, resultMap.getOrDefault(reportingUser,0)+1);
//                    System.out.println(reportedMap.get(reportedUser));
//                }
//            }
//
//
//        }
//        for (Map.Entry<String, Integer> entryMap: resultMap.entrySet()){
//            System.out.println(entryMap.getKey() +" / "+ entryMap.getValue());
//        }

        /** 중복제거 */
        HashSet<String> reportSet = new HashSet<>();
        for(String s: report)reportSet.add(s);

        /** 신고 통지 위한 Map*/
        HashMap<String, ArrayList<String>> notifyUserMap = new HashMap<>();
        for (String s: reportSet){
            int blankIdx = s.indexOf(" ");  //
            String reportingUser =s.substring(0,blankIdx);
            String reportedUser =s.substring(blankIdx+1);

            ArrayList<String> reportingUserList = notifyUserMap.getOrDefault(reportedUser, null);
            // 신고당한 유저가 있다면 그 값을 가져옴, 디폴트 값을 가져오는 것은 신고당한 적인 없다는 뜻
            if (reportingUserList == null) reportingUserList = new ArrayList<>();

            reportingUserList.add(reportingUser);
            notifyUserMap.put(reportedUser, reportingUserList); // key는 신고당한 사람,  value는 통지해야 될 사람

        }

        /** 통지 받을 메일의 수를 위한 Map */
        HashMap<String, Integer> reportingUserMailCntMap = new HashMap<>();
        for(ArrayList<String> notifyUserList: notifyUserMap.values()){
            if(notifyUserList.size() >= k){
                for(String notifyUser: notifyUserList){
                    reportingUserMailCntMap.put(notifyUser, reportingUserMailCntMap.getOrDefault(notifyUser, 0)+1);
                }
            }
        }

        for (int i=0; i<id_list.length; i++) {
            answer[i] = reportingUserMailCntMap.getOrDefault(id_list[i], 0);

        }


        return answer;
    }
}
