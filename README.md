# Learn Essence of Spring Template

본 프로젝트는 Learn Essence of Spring 워크숍(강좌)에서 사용할 템플릿 프로젝트입니다. 

---

## MovieBuddy

![MovieBuddyApplication](./moviebuddy.png)

여기 순수 자바로 작성된 콘솔 애플리케이션이 있습니다. 보시는 것처럼 그래픽 유저 인터페이스가 없습니다. 검은 바탕에 흰 글자로 구성된 콘솔 창에서 명령 프롬프트를 통해 명령어를 입력하면, 그에 해당하는 동작을 수행하고 결과를 텍스트로 출력합니다.

이 애플리케이션은 잘 동작하고 있지만, 코드에서 나쁜 악취가 많이 나고 있습니다. 이 와중에 몇 가지 기능을 더 추가해야 합니다. 워크숍(강좌) 과정에서 이 콘솔 애플리케이션에 스프링 프레임워크를 도입하고, 리팩토링을 통해 점진적으로 코드를 개선해볼 것입니다.

### 빌드 및 실행 방법
저장소를 복제하거나 압축 파일로 내려받은 받은 후 다음 명령어를 통해 애플리케이션을 빌드하고, 실행할 수 있습니다.
```
$❯ ./gradlew clean build
$❯ unzip build/distributions/moviebuddy.zip -d build/
$❯ build/moviebuddy/bin/moviebuddy
```

### 사용법
```
// 감독으로 영화 검색하기
❯ directedBy Michael Bay

// 개봉연도로 영화 검색하기
❯ releasedYearBy 2015

// 애플리케이션 종료하기
❯ quit
```

### 개발환경
- Java SE 11
- Gradle 6.6

---

워크숍(강좌)에 대한 자세한 소개는 [여기](https://springrunner.dev/training/learn-essence-of-spring-workshop/)에서 볼 수 있습니다.

---

### 강의노트
#### Section1.
1. 관심사 분리
- 한개의 거대한 오브젝트(God Object)로 구성된 애플리케이션은 변경이 매우 어렵다.
- 이를 방지하기 위해 관심사가 비슷한 것끼리 한곳으로 모으고 다른 것은 나눔으로써 변화 수용을 쉽게 만들 수 있다.
- 관심사 분리의 한 방안으로 `계층화`를 도입할 수 있다.
- 일반적으로 `표현 영역`, `도메인 영역`, `데이터(인프라) 영역`으로 나눈다.
    - 도메인: 해당 프로그램으로 해결하려는 `문제 영역`
- 실습 실행안
    - [X] 도메인 패키지로 Movie 클래스를 이동시킨다.
    - [X] MovieFinder 클래스를 추가한다.
        - [X] 영화를 불러오고 검색하는 메서드들을 이동 시킨다.
    - [X] MovieBuddyApplication에 MovieFinder에 대한 의존성을 추가한다.
    - [ ] 기존 영화를 불러오고 검색하는 책임을 MovieFinder 객체에 의존하도록 변경한다.
