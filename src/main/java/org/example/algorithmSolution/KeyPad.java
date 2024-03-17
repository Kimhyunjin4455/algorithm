package org.example.algorithmSolution;

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
        Position nowLeft;
        Position nowRight;
        Position numPos;
        public String solution(int[] numbers, String hand) {
            // 키패드 생성
            String[][] keyPad = new String[][]{{"1","2","3"}, {"4","5","6"}, {"7","8","9"}, {"*","0","#"}};

            // 손가락 위치 생성
            nowLeft = new Position(3,0);
            nowRight = new Position(3,2);

            String answer = "";
            for (int num: numbers){   // 주어진 숫자에 대해
                numPos = new Position((num-1)/3, (num-1)%3);   // 숫자의 위치 체크
                if(num == 0){
                    numPos = new Position(3,1); // 0은 순서와 다르기에 따로 처리
                }
                String finger = numPos.getFinger(hand);
                if(finger=="R") nowRight = numPos;
                if (finger=="L") nowLeft = numPos;
                answer += finger;

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

            public String getFinger(String hand){
                String finger = hand.equals("right") ? "R" : "L";
                if (this.col == 0) finger = "L";    // this는 numPos기준으로 실행
                else if(this.col == 2) finger = "R";
                else{
                    int leftDistance = nowLeft.getDistance(this);
                    int rightDistance = nowRight.getDistance(this);

                    if (leftDistance < rightDistance) finger = "L";
                    else if (leftDistance > rightDistance) finger = "R";

                }
                return finger;
            }
            public int getDistance(Position p){
                return (Math.abs(this.row - p.row) + Math.abs(this.col - p.col));
            }

        }
    }


}
