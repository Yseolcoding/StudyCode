# 실제 StartupBust 클래스를 만들기 위한 준비 코드

### 변수 선언
GameHelper 인스턴스를 만들고 helper라는 인스턴스 변수를 **선언**합니다.  
Startup 목록 세 개를 저장하기 위하 ArrayList를 **선언**하고 인스턴스를 만듭니다.  
이름은 StartupList로 합니다.  
사용자가 추측한 횟수를 저장하기 위한 numOfGuesses라는 int 변수를 **선언**하고 초깃값을 0으로 설정합니다.  
나중에 이 값을 써서 게임이 끝났을 때 점수를 출력합니다.  
---
### 메서드 선언
Startup 객체를 생성하고 초기화해서 이름과 위치까지 모두 지정해 주는 setUpGame() 메서드를 **선언**합니다.  
이 메서드에서는 간단한 게임 방법도 출력합니다.  
모든 Startup 객체가 없어질 때까지 사용자로부터 추측한 위치를 받아들이고  
checkUserGuess() 메서드를 호출하는 startPlaying() 메서드를 **선언**합니다.  
남아 있는 모든 Startup 객체에 대해 반복문을 돌리면서 각 Startup 객체의  
checkYourslef() 메서드를 호출하는 checkUserGuess() 메서드를 **선언**합니다.  
모든 Startup 객체들을 침몰시킬 때까지의 추측 횟수를 바탕으로  
사용자의 점수 메시지를 출력하는 finishGame() 메서드를 **선언**합니다.
---
### 메서드 구현

**메서드:** void setUpGame()  
　// Startup 객체 세 개를 만들고 이름을 붙입니다.  
　Startup 객체 세 개를 **생성**합니다.  
　각 Startup의 이름을 **설정**합니다.  
　모든 Startup을 StartupsList라는 ArrayList에 **추가**합니다.  
　StartupsList에 들어 있는 각 Startup 객체에 대해 다음을 **반복**합니다.  
　　helper 객체의 placeStartup() 메서드를 **호출**해서 무작위로 선택된 Startup의 위치를 구합니다.  
　　(7X7 그리드에 수평 또는 수직 방향으로 배치된 셀 세 개)
　　placeStartup()을 호출한 결과를 바탕으로 각 Startup의 위치를 **설정**합니다.  
　반복 끝  
메서드 끝

**메서드:** void startPlaying()  
　StartUp이 남아 있는 동안 **반복**합니다.  
　　helper의 getUserInput() 메서드를 호출해서 사용자 입력을 **받습니다.**  
　　checkUserGuess() 메서드를 통해 사용자가 추측한 위치를 **평가**합니다.  
　반복 끝  
메서드 끝  

**메서드:** void checkUserGuess(String userGuess)
　// 명중시킨(침몰시킨) Startup 객체가 있는지 확인합니다.  
　numOfGuesses 변수에 저장된 사용자가 추측한 횟수를 **증가**시킵니다.  
　사용자가 추측한 위치가 틀렸을 것이라는 가정하에 result라는 로컬 변수(String)를 "miss"로 설정합니다.  
　startupsList에 들어 있는 각 Startup 객체에 대해 다음을 **반복**합니다.  
　　Startup 객체의 checkYourself() 메서드를 호출해서 사용자가 추측한 위치를 **평가**합니다.  
　　리턴값에 따라 result의 값을 "hit" 또는 "kill"로 **설정**합니다.  
　　**만약** 결과가 "kill"이면 그 Startup을 startupsList에서 **제거**합니다.  
　반복 끝
　result의 값을 **출력**합니다.  
메서드 끝

**메서드:** void finishGame()
　게임이 끝났음을 알리는 메시지를 **출력**합니다.  
　**만약** 추측한 횟수가 적으면  
　　축하 메시지를 **출력**합니다.  
　**그렇지않으면**  
　　결과가 좋지 않다는 메시지를 **출력**합니다.  
　만약 부분 끝  
메서드 끝