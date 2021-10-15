# 스프링 MSA 예제
기본적으로 스프링 마이크로 서비스 코딩 공작소 라는 책 내용을 기준으로 구현하였습니다.
다만 책 내용이 구 버전 기준으로 작성된 부분이 많아 Boot 2.5.5 에 맞춰 새로이 예제를 작성하게 되었습니다.

## 환경 구성
- Java 17
- Gradle 7.2
- Docker 20.10.8
- Spring Boot 2.5.5
- Spring Cloud 2020.0.4

## 도커
1. docker-compose.yaml 에서 `KEYCLOAK_URI`를 자신의 환경에 맞게 수정합니다.
2. `docker-compose up --build`
3. 다음 주소로 접속 합니다 `http://localhost:8000/user-service/v1/users/`
4. test / test 계정으로 로그인하여 테스트 합니다.
