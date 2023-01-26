# 230127spring_lec03-user-service
패키지 구조 및 람다식

파일구조 및 결과창
![230127파일구조및 결과창](https://user-images.githubusercontent.com/114065051/214883560-6b45994a-8853-4206-926c-3c4d7844b129.PNG)

정리 및 다음주숙제
[230126 spring.txt](https://github.com/hhhhea/230127spring_lec03-user-service/files/10510985/230126.spring.txt)

인스턴스 - 객체를 애플리케이션에서 실제로 사용될때
bena - 개발자가 관리하는 객체가 아닌 스프링에게 제어권을 넘긴 객체를 bean이라고 함


spring bean이란
1.spring에서 POJO(plain, old java object)를 Beans라고 부른다.
2.Bean은 애플리케이션의 핵심을 이루는 객체이며, Spring IoC(inversion of Control)컨테이너의 의해 인스턴스화, 관리, 생성된다.
3.Bean는 우리가 컨테이너에 공급하는 설정메타데이터(XML파일)에 의해 생성된다.
-컨테이너는 이 메타 데이터를 통해 Bean의 생성, Bean Life Cycle, Bean Dependency(종속성)등을 알 수 있다.
4.애플리케이션의 객체가 지정되면, 해당 객체는 getBean() 메서드를 통해 가져올 수 있다.

Spring Bean 정의
일반적으로 XML 파일에 정의한다.
주요 속성
class(필수): 정규화된 자바 클래스 이름
id: bean의 고유 식별자
scope: 객체의 범위 (sigleton, prototype)
constructor-arg: 생성 시 생성자에 전달할 인수
property: 생성 시 bean setter에 전달할 인수
init method와 destroy method

Spring Bean Scope
1.스프링은 기본적으로 모든 Bean을 singleton으로 생성하여 관리
-애플리케이션 구동시 JVM안에서 스프링이 bean마다 하나의 객체를 생성하는 것
-스프링을 통해서 bean을 제공받으면 언제나 주입받은 bean은 동일한 객체라는 가정하에 개발

***singleton prototype차이
singleton - 하나의 bean 정의에 대해서 spring Ioc Container내에 단 하나의 객체만 존재
prototype - 하나의 bean 정의에 대해서 다수의 객체가 존재할 수 있다.

singleton (1대1)
1.싱글톤 bean은 컨테이너에서 한번 생성된다.
-컨테이너가 사라질때 bean도 제거
2.생성된 하나의 인스턴스는 single beans cache에 저장되고, 해당 bean에 대한 요청과 창조가 있으면 캐시된 객체를 반환
-즉 하나만 생성되기 때문에 동일한 것을 참조
3.기본적으로 모든 bean은 scope이 명시적으로 지정되지 않으면 singleton

prototype (1대 다수)
1.prototype bean은 모든 요청에서 새로운 객체를 생성하는 것을 의미
-즉, prototype bean은 의존성 관계의 bean에 주입될때 새로운 객체가 생성되어 주입
-정상적인 방식으로 gc에 의해 bean이 제거
