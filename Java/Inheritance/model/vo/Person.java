package edu.kh.inheritance.model.vo;

public class Person {
    // class명에 상속 구문이 없다면
    // 컴파일러가 자동으로 extends Object 구문을 추가한다.


    // 필드
    private String name;
    private int age;
    private String nationality; // 국적

    // 생성자
    public Person() {
    } // 기본 생성자

    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    // 메서드
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    // 상속의 특징 : 코드 추가 및 수정에 용이함
    // (새로운 메서드를 Person에 추가하였을 때 Student, Employee가 사용 가능한지 확인)
    public void breath() {
        System.out.println("사람은 코나 입으로 숨을 쉰다.");
    }

    public void move() {
        System.out.println("사람은 움직일 수 있다.");
    }
    // - 상속 받은 자식들에 대한 공통적인 규약을 정의할 수 있다.
    // --> 상속 받은 자식들은 모두 부모와 같은 필드, 메서드를 가지고 있으므로
    //     클래스들이 일부 공통된 형태를 띈다.

    // Object.toString() 메서드 오버라이딩

    // - toString() 메서드는 객체가 가지고 있는 모든 값(필드)을
    //   하나의 문자열로 반환하는 용도의 메서드
    @Override
    public String toString() {
        return name + " / " + age + " / " + nationality;
             // 김철수 / 17 / 대한민국
    }
}
