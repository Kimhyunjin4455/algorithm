package org.example.algorithmSolution.bruteForce;

public class KeyPad {
    // 맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작
    // 상하좌우 4가지 방향으로만 이동 (이동 한 칸은 거리로 1에 해당)
    // 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지
    // 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지
    // 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용
    // 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        Solution solution = new Solution();

        System.out.println(solution.solution(numbers, hand));

    }



    static class Solution {
        Position left;
        Position right;
        Position keyNum;
        public String solution(int[] numbers, String hand) {

            // 키패드 생성
            String[][] keyPad = new String[][]{{"1","2","3"}, {"4","5","6"}, {"7","8","9"}, {"*","0","#"}};
            // 초기 손가락 위치
            left = new Position(3,0);
            right = new Position(3,2);

            String answer = "";

            for(int num: numbers){
                // 숫자에 대한 위치 구하기 + 거리 구하기 + 이동된 손가락 구하기
                keyNum = new Position((num-1)/3, (num-1)%3);
                if(num == 0) keyNum = new Position(3,1);

                String finger = keyNum.getFinger(hand);

                // answer에 손가락 추가
                answer += finger;

                // 손가락 위치 조정
                if(finger == "R") right = keyNum;
                else if(finger == "L") left = keyNum;

            }

            return answer;

        }
        class Position{
            int row;
            int col;

            Position(int row, int col){
                this.row = row;
                this.col = col;
            }

            String getFinger(String hand){
                String finger = hand.equals("right")?"R":"L";       // main 클래스의 입력기준은 오른손잡이
                if(this.col == 0) finger = "L";
                else if (this.col == 2) finger = "R";
                else {
//                    int leftDistance = left.getDistance(this);  // left 기준으로 실행하기에 파라미터값 this로
//                    int rightDistance = right.getDistance(this);
                    int leftDistance = this.getDistance(left);
                    int rightDistance = this.getDistance(right);

                    if(leftDistance < rightDistance) finger = "L";
                    else if (rightDistance < leftDistance) finger = "R";
                }

                return finger;
            }

            int getDistance(Position p){
                int distance = (Math.abs(this.row - p.row) + Math.abs(this.col - p.col));
                return distance;
            }
        }



    }


}
