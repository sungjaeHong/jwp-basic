#### 1. Tomcat 서버를 시작할 때 웹 애플리케이션이 초기화하는 과정을 설명하라.
1. src/main/java/next/WebServerLauncher.java 에서 톰캣의 설정을 한 후 톰캣 실행
2. 톰캣이 실행되며 next/support/context의 ContextLoaderListener에 있는 contextInitialized가 실행된다.
3. src/main/java/core/mvc/DispatcherServlet에 선언된 어노테이션을 통해 servlet lifeCycle에 따라 동작한다.  
4. init()를 통해 각 URL마다 Controller가 매핑되며, 추후에 요청이 들어 올 시 service에서각 Controller를 실행한다.
 

#### 2. Tomcat 서버를 시작한 후 http://localhost:8080으로 접근시 호출 순서 및 흐름을 설명하라.
DispatcherServler service -> 매핑된 Controller -> 각 Controller의 역할수행 후 View 로 redirect 혹은 forward 


#### 7. next.web.qna package의 ShowController는 멀티 쓰레드 상황에서 문제가 발생하는 이유에 대해 설명하라.
* 


개인시간이 부족해 지난 주 수업에 했던 내용만 커밋합니다.
추후 작업 완료 후 다시 진행하겠습니다.