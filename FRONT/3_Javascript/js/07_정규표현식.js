// 정규 표현식 객체 생성 + 확인하기
document.getElementById("check1").addEventListener("click", function() {

    // 정규 표현식 객체 생성
    const regExp1 = new RegExp("script");
                    // "script" 와 일치하는 문자열이 있는지 검사하는 정규 표현식

    const regExp2 = /java/;
                    // "script" 와 일치하는 문자열이 있는지 검사하는 정규 표현식

    // 확인하기
    const str1 = "저희는 지금 javascript를 공부하고 있습니다.";
    const str2 = "servlet/jsp(java server page)도 조만간 다시 합니다.";
    const str3 = "java, java, java";

    console.log("regExp1.test(str1) : " + regExp1.test(str1));
    console.log(regExp1.exec(str1));

    console.log("regExp2.test(str2) : " + regExp2.test(str2));
    console.log(regExp2.exec(str2));

    // 일치하는게 없는 경우
    console.log("regExp1.test(str2) : " + regExp1.test(str2));
    console.log(regExp1.exec(str2));
});

// 메타문자 확인하기
document.getElementById("btn1").addEventListener("click", function() {

    const div1 = document.getElementById("div1");

    div1.innerHTML = ""; // 내용 모두 삭제

    // a (일반문자열) : 문자열 내에 a라는 문자열이 존재하는지 검색
    const regExp1 = /a/;

    div1.innerHTML += "/a/ , apple : " + regExp1.test("apple") + "<hr>";
    div1.innerHTML += "/a/ , price : " + regExp1.test("price") + "<hr>";

    // [abcd] : 문자열 내에 a, b, c, d 중 하나라도 일치하는 문자가 있는지 검색
    const regExp2 = /[abcd]/;

    div1.innerHTML += "/[abcd]/ , apple : " + regExp2.test("apple") + "<hr>";
    div1.innerHTML += "/[abcd]/ , ssbss : " + regExp2.test("ssbss") + "<hr>";
    div1.innerHTML += "/[abcd]/ , qwerty : " + regExp2.test("qwerty") + "<hr>";

    // ^(캐럿) : 문자열의 시작을 의미
    const regExp3 = /^group/; // 문자열의 시작이 "group"인지 확인

    div1.innerHTML += "/^group/ , group100 : " + regExp3.test("group100") + "<hr>";
    div1.innerHTML += "/^group/ , 100group : " + regExp3.test("100group") + "<hr>";

    // $(달러) : 문자열의 끝을 의미
    const regExp4 = /group$/; // 문자열의 시작이 "group"인지 확인

    div1.innerHTML += "/group$/ , group100 : " + regExp4.test("group100") + "<hr>";
    div1.innerHTML += "/group$/ , 100group : " + regExp4.test("100group") + "<hr>";

});

// 이름 유효성 검사
document.getElementById("inputName").addEventListener("keyup", function() {
    
    // 결과 출력용 span
    const span = document.getElementById("inputNameResult");

    // 한글 2 ~ 5 글자 정규 표현식 (정규식)
    // [가-힣] : 한글 (단일 자음, 모음 제외)
    const regExp = /^[가-힣]{2,5}$/;

    // 빈칸인지 검사
    if (this.value.length == 0) {
        span.innerText = "";
        return; // 함수를 종료하고 호출한 곳으로 돌아간다.
    }

    // 유효성 검사
    if (regExp.test(this.value)) {
        // #inputName에 작성된 값이 유효한 경우
        span.innerText = "유효한 이름 형식입니다.";
        span.style.color = "green";
        span.style.fontWeight = "bold";
    } else {
        span.innerText = "이름 형식이 올바르지 않습니다.";
        span.style.color = "red";
        span.style.fontWeight = "bold";
    }
});

// 주민등록번호 유효성 검사
document.getElementById("inputPno").addEventListener("keyup", function() {

    // 결과 출력 span 태그
    const span = document.getElementById("inputPnoResult");

    if (this.value.length == 0) {

        span.innerText = "주민등록번호를 작성해주세요.";

        span.classList.remove("confirm");
        span.classList.remove("error");

        return;
    }

    // 주민등록번호 정규식 객체 생성
    // 생년월일(6)-고유번호(7) : 총 14글자
    const regExp = /^\d{6}\-\d{7}$/;

    // 요소.classList : 요소가 가지고 있는 클래스를 배열로 반환
    // 요소.classList.remove("클래스명") : 요소의 특정 클래스 제거
    // 요소.classList.add("클래스명") : 요소의 특정 클래스 추가
    // 요소.classList.toggle("클래스명") : 클래스가 있으면 제거, 없으면 추가

    // 유효성 검사
    if (regExp.test(this.value)) {
        span.innerText = "유효한 주민등록번호 형식입니다.";

        span.classList.remove("error"); // error 클래스 제거
        span.classList.add("confirm");  // confirm 클래스 추가
    } else {
        span.innerText = "주민번호 형식이 올바르지 않습니다.";

        span.classList.remove("confirm"); 
        span.classList.add("error");  
    }

});
