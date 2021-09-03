# 스프링 MSA 예제

## 환경 구성
- Java 16
- Gradle 7.1
- Docker 20.10.8
- Spring Boot 2.5.4
- Spring Cloud 2020.0.3

## 모듈 설명
- licensing-service : Demo Application
- config-server : Application Server 의 구성설정을 담당하는 서버
    - profile : native 

## 도커 이미지 생성 (Spring Boot 2.3 이상)
- gradle plugin -> task -> build -> bootBuildImage

이미지가 정상적으로 생성 되었다면 도커 데스크톱에서 확인 가능합니다. 

## 도커 컨테이너 생성 및 실행
```> docker run --rm -p [port]:[port] [image name]:[tag]```
