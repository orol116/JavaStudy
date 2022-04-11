package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadXML {
    public static void main(String[] args) {

        // 외부 XML 파일 읽어오기(Properties 사용)

        Properties prop = new Properties();
        // Key, Value가 String으로 제한된 Map

        try {
            prop.loadFromXML(new FileInputStream("driver.xml"));

            // Property : 속성(데이터)
            // prop.getProperty("driver") : XML에서 얻어온 값 중
            //                              Key가 "driver"인 엔트리의 value를 얻어옴
            System.out.println("driver : " + prop.getProperty("driver"));

            // 외부 파일 미사용
            String str = "oracle.jdbc.driver.OracleDriver";
            System.out.println(str);

            // Java는 코드가 한글자라도 변환되면
            // 다시 처음부터 전체 내용을 컴파일(이진 코드 번역)한다 --> 비효율적

            // 그런데, Java에 외부 파일을 읽어오는 변하지 않는 코드를 작성하면
            // 컴파일을 다시 하지 않음 --> 효율적

            // 컴파일을 다시 하지 않아도 외부파일 내용이 변하면 자동으로 반영됨

            // DB 연결정보, SQL 내용은 빈번히 변화될 예정
            // 1) Java 코드에 직접 작성 -> 다시 컴파일 -> 실행
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(JDBCTemplate.getConnection());
    }
}
