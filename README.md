# MSA 기반 시스템

## [Spring Cloud Config Server](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/)
> Q. 스프링 설정이 바뀌었을 때 빌드, 배포없이 갱신하려면 어떻게 해야할까? 스프링의 설정 파일들을 어떻게 외부로 분리시킬까?
> 
> A. Spring Cloud Config Server를 이용하여 어플리케이션과 설정파일의 커플링을 분리하자.

![config-server](https://slack.inveniacorp.com/files/tym7jny9y3bxigzy6jepugaf4r/public?h=fOQcckdT9EKEB0x2azVrD1dbJtc45bUw-I3zJEqIUuQ)

하지만 Config Server는 어플리케이션이 요청해야 응답하는 수동적인 서버이다.

즉, 설정파일이 변경 되면 각 어플리케이션이 Config Server에 새로운 설정을 요청하도록 수동으로 작업해야 한다.

## [Spring Cloud Bus](https://docs.spring.io/spring-cloud-bus/docs/current/reference/html/)
> Q. Spring Cloud Config가 변경될 때마다 모든 클라이언트 호출해야만 할까? 
> 
> A. Spring Cloud Bus를 이용하여 모든 클라이언트를 연결하자.

![cloud-bus](https://slack.inveniacorp.com/files/s6rtit7hh7gppjccgc35qt43sh/public?h=ZjT6IvHEZsggIH_YWpRMfAM0WHjskAF8YSVWUg4dVUo)

설정파일이 변경되면 Github가 이를 감지하고 RabbitMQ로 설정파일이 업데이트 되었다는 웹훅 메세지를 보낸다.

그러면 메세지큐를 구독하고 있던 어플리케이션은 설정이 갱신되었다는 메세지를 수신하고, Config Server에 갱신 요청을 보낸다.


// todo

## API Gateway

## Eureka Server
