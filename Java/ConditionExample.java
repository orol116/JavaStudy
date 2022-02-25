package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionExample {

    Scanner sc = new Scanner(System.in);

    public void ex1() {
        // if문
        // - 조건식 결과가 true면
        //   실행

        /* if (조건식) {
         *      조건식이 true일 때 수행할 코드
         * }
         */

        System.out.print("정수 입력 : ");
        int input = sc.nextInt();

        // 입력된 정수가 양수인지 아닌지 판별
        if (input > 0)
            System.out.println("양수 입니다.");

        if (input <= 0)
            System.out.println("양수가 아니다.");
    }

    public void ex2() {
        // if - else 문
        // - 조건식 결과가 true이면 if문,
        //   false이면 else 구문이 수행됨.

        /* if (조건식) {
         *      조건식이 true일 때 수행할 코드
         * } else {
         *      조건식이 false일 때 수행할 코드
         * }
         */

        // 홀짝 검사
        System.out.print("정수 입력 : ");
        int input = sc.nextInt();

        if (input % 2 != 0) {
            System.out.println("홀수 입니다.");
        } else {    // 짝수 또는 0 입력 시 수행

            // ** 중첩 if문 **
            if (input == 0)
                System.out.println("0 입니다.");
            else
                System.out.println("짝수 입니다.");
        }
    }

    public void ex3() {
        // if - else if - else

        // 양수, 음수, 0 판별
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int input = sc.nextInt();

        if (input > 0) {    // input이 양수일 경우
            System.out.println("양수 입니다.");
        } else if (input < 0) { // 바로 위의 if문이 만족되지 않은 경우에 수행
            System.out.println("음수 입니다.");
        } else // 모든 if, else if가 만족되지 않은 경우에 수행
            System.out.println("0 입니다.");
    }

    public void ex4() {
        // 달(month)을 입력 받아 해당 달에 맞는 계절 출력

        System.out.print("달(month) 입력 : ");
        int month = sc.nextInt();

        String season;  // 아래 조건문 수행 결과를 저장할 변수 선언

        // 봄 : 3, 4, 5
        if (month == 3 && month == 4 && month == 5) {
            season = "봄";
        } else if (month >= 6 && month <= 8) {  // 여름 : 6, 7, 8
            season = "여름";
        } else if (month >= 9 && month <= 11) { // 가을 : 9, 10, 11
            season = "가을";
        } else if (month == 12 || month == 1 || month == 2) { // 겨울 : 12, 1, 2
            season = "겨울";
        } else { // if, else if가 모두 false인 경우
            season = "해당하는 계절이 없습니다.";
        }

        System.out.println(season);
    }

    public void ex5() {
        // 나이를 입력 받아
        // 13세 이하면 "어린이 입니다."
        // 13세 초과 19세 이하면 "청소년 입니다."
        // 19세 초과 시 "성인 입니다." 출력

        System.out.print("나이 입력 : ");
        int age = sc.nextInt();

        if (age <= 13)                 System.out.println("어린이 입니다.");
        else if (age > 13 && age < 19) System.out.println("청소년 입니다.");
        else if (age > 19)             System.out.println("성인 입니다.");
    }

    public void ex6() {
        // 점수(100점 만점)를 입력 받아
        // 90점 이상 : A
        // 80점 이상 90점 미만 : B
        // 70점 이상 80점 미만 : C
        // 60점 이상 70점 미만 : D
        // 60점 미만 : F

        // 0점 미만, 100초과 : "잘못 입력하셨습니다."

        System.out.print("점수 입력 : ");
        int score = sc.nextInt();

        if (score < 0 || score > 100)       System.out.println("잘못 입력하셨습니다.");
        else if (score >= 90)               System.out.println('A');
        else if (score >= 80 && 90 > score) System.out.println('B');
        else if (score >= 70 && 80 > score) System.out.println('C');
        else if (score >= 60 && 70 > score) System.out.println('D');
        else if (score < 60)                System.out.println('F');
    }

    public void ex7() {
        // 놀이기구 탑승 제한 검사
        // 나이가 12세 이상, 키 140.0cm 이상 일 경우에만 "탑승 가능"
        // 나이가 12미만인 경우 : "적정 연령이 아닙니다."
        // 키가 140.0cm 미만 : "적정 키가 아닙니다."
        // 나이를 0세 미만, 100세 초과 시 : "잘못 입력하셨습니다."
        // 중첩 if문 사용

        System.out.print("나이 입력 : ");
        int age = sc.nextInt();
        System.out.print("키 입력 : ");
        double height = sc.nextDouble();

        if (age < 0 || age > 100)
            System.out.println("잘못 입력하셨습니다.");
        else {
            if (age < 12)
                System.out.println("적정 연령이 아닙니다.");
            else {
                if (height < 140.0)
                    System.out.println("적정 키가 아닙니다.");
                else
                    System.out.println("탑승 가능");
            }
        }
    }

    public void ex8() {
        // 놀이기구 탑승 제한 검사 프로그램
        // 조건 - 나이 : 12세 이상
        //     -  키 : 140.0cm 이상

        // 나이를 0~100세 사이로 입력하지 않은 경우 : "나이를 잘못 입력 하셨습니다."
        // 키를 0~250.0cm 사이로 입력하지 않은 경우 : "키를 잘못 입력 하셨습니다."
        // -> 입력이 되자 마자 검사를 진행하여 잘못된 경우 프로그램 종료

        // 나이 O , 키 X : "나이는 적절하나, 키가 적절치 않음";
        // 나이 X , 키 O : "키는 적절하나, 나이는 적절치 않음";
        // 나이 X , 키 X : "나이와 키 모두 적절치 않음";
        // 나이 O , 키 O : "탑승 가능"

        System.out.print("나이 입력 : ");
        int age = sc.nextInt();

        if (age < 0 || age > 100) {
            System.out.println("나이를 잘못 입력하셨습니다.");
        } else {
            System.out.print("키 입력 : ");
            double height = sc.nextDouble();

            if (height < 0 || height > 250)
                System.out.println("키를 잘못 입력하셨습니다.");
            else if (age >= 12 && height < 140) System.out.println("나이는 적절하나, 키가 적절치 않음");
            else if (age < 12 && height >= 140) System.out.println("키는 적절하나, 나이가 적절치 않음");
            else if (age < 12 && height < 140) System.out.println("나이와 키 모두 적절치 않음");
            else System.out.println("탑승 가능");
        }
    }
}
