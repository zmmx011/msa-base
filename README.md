# 스프링 MSA 예제
기본적으로 스프링 마이크로 서비스 코딩 공작소 라는 책 내용을 기준으로 구현하였습니다.
다만 책 내용이 구 버전 기준으로 작성된 부분이 많아 Boot 2.5.5 에 맞춰 새로이 예제를 작성하게 되었습니다.
## 환경 구성
- Java 17
- Gradle 7.2
- Docker 20.10.8
- Spring Boot 2.5.5
- Spring Cloud 2020.0.4

## 모듈 설명
- licensing-service : Demo Application
- config-server : Application Server 의 구성설정을 담당하는 서버
    - profile : native 

## Gradle 빌드 및 Docker 이미지 생성 (Spring Boot 2.3 이상)
Spring Boot Gradle Plugin 을 IDEA에서 사용하는 것이 가장 편합니다.

명령줄 실행 방법

- 빌드 : `> ./gradlew build`

- 도커 이미지 생성 : `> ./gradlew bootBuildImage`

도커 이미지 이름 변경 시 다음 옵션 추가 `--imageName=[이미지 이름]` 

도커 이미지가 정상적으로 생성 되었다면 도커 데스크톱에서 확인 가능합니다. 

## 도커 실행
- **config-server** : `docker run --env ENCRYPT_KEY="damu" --rm -p 8888:8888 config-server:0.0.1-SNAPSHOT`
- **licensing-service** : `docker run -e spring.profiles.active=dev --env ENCRYPT_KEY="damu" --rm -p 8001:8001 licensing-service:0.0.1-SNAPSHOT`
- **organization-service** : `docker run -e spring.profiles.active=dev --env ENCRYPT_KEY="damu" --rm -p 8002:8002 organization-service:0.0.1-SNAPSHOT` 

자주 사용되는 옵션
- -d : 백그라운드 실행
- -e : 실행시 환경변수 지정
- -p : 포트 지정
- --name : 컨테이너 명
- --rm : 일회성 실행(종료시 컨테이너 및 관련된 리소스 삭제)

[전체 옵션](https://docs.docker.com/engine/reference/run/)
