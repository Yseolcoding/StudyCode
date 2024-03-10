## SimpleStartup 클래스
### 준비코드
<br>ㅈㅎㄹ

셀의 위치를 저장하기 위한 locationCells라는 int 배열을 **선언**합니다.  
맞힌 셀의 개수를 저장하기 위한 numOfHits라는 int를 **선언**하고 값은 0으로 **설정**합니다.
---
사용자가 추측한 위치를 int(1, 3 등)로 받아들이고 그 값을 확인하고 "hit", "miss", "kill" 중 하나를 나타내는 결과를 리턴하는 checkYourself()라는 메서드를 **선언**합니다.  
int 배열(셀 위치 세 개를 나타내는 int(2, 3, 4 등) 세 개가 들어감)을 받아들이는 setLocationCells()라는 세터 메서드를 선언합니다.
---
**메서드** : 
String checkYourself(int userGuess)  
사용자가 추측한 위치를 int 매개변수 형태로 받아옵니다.
