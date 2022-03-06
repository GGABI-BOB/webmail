# Spring_GGABIMail

(기본)
- apache james 메일 사용
- postgresql 사용



1. james 구동 및 방법
sudo apt install openjdk-11-jdk-headless (headless는 gui 없는 서버용 프로그램)
sudo apt install libc6-i386 libc6-dev-i386
sudo cd $HOME/bin
sudo ./james start


2. spring(백엔드) 구동 및 방법
// application.yml 파일
spring:
  jpa:
    show-sql: true
    hibernate:
      dialect: org.hibernate.dialect.PostgreSQL10Dialect
      ddl-auto: update
    generate-ddl: true
    properties:
      hibernate:
        jdbc.lob.non_contextual_creation: true
  datasource:
    url: jdbc:postgresql://localhost:5432/ggabi
    username: postgres
    password: postgres1234!@
  jackson:
    serialization:
      fail-on-empty-beans: false
  servlet:
    multipart:
      max-file-size: 50MB
      max-request-size: 50MB

logging:
  level:
    kr.co.ggabi: DEBUG

jwt:
  header: Authorization
  secret: ggabiggabiggabiggabiggabiggabiggabiggabiggabiggabiggabiggabiggabiggabiggabiggabiggabiggabi
  token-validity-in-milliseconds: 86400000

james:
  dir: /home/ggabi/ggabimail/mailserver/james-server-app-3.6.0/bin/james-cli.sh

admin:
  accessIp: localhost

mailServer:
  host: localhost
  domain: ggabi.co.kr
