# Spring_GGABIMail

(기본)
- apache james 메일 사용
- postgresql 사용

<br><br>
1. james 구동 및 방법

  sudo apt install openjdk-11-jdk-headless (headless는 gui 없는 서버용 프로그램)

  sudo apt install libc6-i386 libc6-dev-i386

  sudo cd $HOME/bin

  sudo ./james start
  
<br><br>
2. spring(백엔드) 구동 및 방법

  nobup.out 파일 삭제 후 다음 명령어 실행

  nohup java -jar backend.jar &

  tail -f nohup.out 
