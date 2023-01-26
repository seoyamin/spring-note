# :herb:Spring Boot Basic
## 1. 스프링이란 ?
#### 1-1.  Framework
 틀을 제공해주고, 이에 맞춰서 개발하도록 제한하는 환경 <br>

#### 1-2.  Open Source
소스코드가 공개되어 있으며, 그 내부를 수정할 수 있다. <br>

#### 1-3.  IoC Container 를 지원한다.
※  IoC Container (Inversion of Controll) : 제어의 역전         " 주도권이 스프링에게 있다. " <br>

IoC란 객체와 관련된 모든 제어권이 개발자에서 스프링으로 바뀐 것을 의미한다.
기존에는 개발자가 직접 객체를 생성하고, 메소드나 객체의 호출을 결정하였다. 그러나, 스프링에서는 개발자의 어플리케이션 코드가 아닌, 스프링 컨테이너에서 객체를 제어하는 역할을 담당한다.

이렇게 객체의 생성, 제어, 생명주기 관리 (= IoC)를 담당하는 컨테이너를 IoC Container라고 한다. <br>


#### 1-4.  DI 를 지원한다. 
※  DI (Dependency Injection) : 의존관계 주입  <br>

객체를 직접 생성하는 것이 아닌, 외부에서 생성한 후에 주입시켜주어 객체들 간의 관계를 결정하는 것
따라서 모든 클래스에서 공통적으로 이 외부 객체를 가져다 쓸 수 있게 된다. <br>

#### 1-5.  많은 Filter를 가진다.
권한을 가지고 있는지 여부를 검열하는 문지기가 바로 필터이다. 

필터는 스프링 자체가 가지고 있는 종류도 많으며, 직접 만들어서 사용해도 된다.

이때, 톰캣 등의 웹 컨테이너가 가지고 있는 문지기를 'Filter', 스프링 컨테이너가 가지고 있는 문지기를 'Interceptor'라고 한다. <br>

#### 1-6.  많은 Annotation을 가진다.
※  Annotation (주석 + 힌트)  <br>

어노테이션은 컴파일러가 무시하지 않는 주석으로, 컴파일 체킹에 사용되는 힌트를 제공하는 역학을 한다.
스프링에서는 어노테이션을 통해 객체를 생성, 주입한다.  <br>

#### 1-7.  MessageConverter를 가진다. (기본값 Json)
서로 다른 언어 간의 통신을 위해 중간 언어(json)가 있고, 이 중간 언어 형태로 바꾸거나 번역하는 역할을 MessageConverter가 한다.  <br>

#### 1-8.  BufferedReader, BufferedWriter 쉽게 사용할 수 있다.
Byte Stream 통신을 통해 1 byte ( = 8 bit ) 단위로 전송이 되면, Java 프로그램에서는 InputStream으로 데이터를 byte 그대로 받는다. 이때, 받은 byte 형식 데이터를 우리에게 친숙한 char (문자) 형태로 변환해주는InputStreamReader가 존재한다. 그러나 InputStreamReader는 배열을 통해 여러개의 문자를 받을 수는 있지만, 배열의 크기를 정해놔야 해서 제한사항이 많다.
 

이를 해결할 수 있는 Reader가 BufferedReader이다. 즉, BufferedReader는 가변길이의 문자를 받을 수 있다.
마찬가지로 BufferedWriter는 가변길이의 문자를 전송할 수 있다.
이러한 BufferedReader, BufferedWriter는 어노테이션을 통해 편리하게 이용할 수 있다. <br>