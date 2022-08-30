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
    - [X] 기존 영화를 불러오고 검색하는 책임을 MovieFinder 객체에 의존하도록 변경한다.

#### Section2.
1. 상속을 통한 기능 확장(템플릿 메서드 패턴)
- 영화를 불러오는 방식에 CSV 파일을 지원하도록 추가하는 방법은 여러가지가 있다.
- 그 중 가장 간단한 건 메서드 추가
    - 문제는 처리해야 할 요구사항이 늘어날 때마다 아주 귀찮게 코드 작업을 반복해야 한다.
    - 단순히 귀찮음의 문제가 아니라 변경에 대한 두려움이 늘고 유지보수를 어렵게 만들 수 있다.
- 원인?
    - 관심사가 섞여있는 경우 이런 문제가 발생한다(단일책임원칙 위반)
- 이를 해결하기 위한 방법 중 하나로 `상속`을 제안한다.
    - MovieFindder 오브젝트를 추상클래스로 바꾸고 loadMovies 메서드도 추상메서드로 만들어주자
    - 이 추상클래스를 상속해서 상황에 맞는 loadMovies 메서드를 구현하면 상속을 통해 기능을 확장할 수 있다.
- 위와 같은 해결책은 `템플릿 메서드 패턴`으로 볼 수 있다.
- 이걸 적용하는 시기는 어떻게 파악하나?
    - `관심사`에 주의를 기울이자
    - 코드가 변화하는 성격(변화시기, 변화원인)이 다른 부분이 없는지 관찰하고, 서로 다른 부분을 계층화 시키자

2. 합성을 통한 기능 확장
- `상속`은 많이 쓰이는 기능 확장 방식이지만 사실 권장하지 않는다.
- 대부분의 경우 인터페이스를 통한 `합성`이 더 유연하고 잘 만들어진 설계 방안이다.
- 그냥 `합성`만 쓰고 진짜 필요할 때만 `상속`을 사용하자.

#### Section3.
- 여러 XML 언마샬링 라이브러리가 있는데 이 중 `JAXB`를 이용한 XmlMovieReader를 구현하는 실습을 진행한다.
- 모두가 아는 단위테스트 할 때 떠오르는 그것 `JUnit`을 적용한다.

#### Section4.
- 어떤 객체를 사용할지 결정하는 행위도 `책임`이다.
- 이러한 책임이 객체 내에 있으면 객체의 역할이 계속 늘어나게 된다.
- 문제점을 방지하기 위해 생성자를 통해 `객체간 느슨한 연결` 방식을 도입할 수 있다.

#### Section6.
- Spring Bean
  - 스프링 컨텍스트에서 관리하는 객체
- Bean Scope
  - Singleton: 기본값. 스프링 컨텍스트가 시작될 때 생성되고 종료될 때 소멸한다. 스프링 컨텍스트 내 단 1개만 존재한다.
  - Prototype: 빈이 요청될 때마다 새로운 빈을 만든다. 컨텍스트 내에 여러개가 존재할 수 있다.
  - Web 전용 Scope
    - Request, Session 등

#### Section7.
- 자동 와이어링 동작 우선순위
  - 먼저 타입으로 탐색한다.
  - 타입이 중복된 경우 이름으로 탐색한다.
  
#### Section8.
- 스프링 컨텍스트 테스트를 원활하게 하려면 필드 DI는 가능한 절대적으로 피하자

#### Section11.
- 스프링은 환경에 따라 빈 구성정보를 달리줄 수 있는 `Profile` 기능을 제공한다.

#### Section12.
- Spring Lifecycle Callbacks
  - 스프링 빈의 생명주기 사이에 실행할 수 있는 콜백 인터페이스들이 존재함
  - 대표적으로 initializing(생성시), disposal(소멸시)가 존재함
  
#### Section14.
- 다양한 Resource를 받을 수 있도록 스프링에서는 추상화된 기술을 제공한다.
- ResourceLoader, ResourceLoaderAware를 응용할 수 있다.
- ResourceLoader는 Application Context에 기본적으로 내장되어 있다.
  - 이 때문에 스프링을 사용하면 굳이 Resource를 부르기 위해 이상한 짓 안하고 스프링 컨테이너를 이용하면 된다.

#### Section15.
- 원격지에서 리소스를 받아오면 속도가 더럽게 느려진다
- 고려해볼 방법은 여러가지가 있다.
    - DB에 영속화 시켜도 되고
    - 캐싱해도 된다.
- 실습에서는 객체 캐싱을 이용해보자
  - 카페인을 사용해볼 예정
  - 카페인은 메모리 기반 캐시
  - 잘못 쓰면 OOM 난다
- 스프링은 이 캐시까지 추상화해줄 수 있다.
  - 캐시, 캐시 매니저 인터페이스로 구성된다.