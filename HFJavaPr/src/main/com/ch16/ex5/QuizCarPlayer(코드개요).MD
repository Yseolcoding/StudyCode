public class QuizCardPlayer {  

　　　public void **go()** {  
　　　　　// GUI를 만들고 화면에 표시합니다.  
　　　}  

　　　private void **nextCard()** {  
　　　　　// 이게 질문이라면 정답을 보여 주고, 질문이 아니라면  
　　　　　// 다음 질문을 보여 주면서 지금 보여 주는 게 질문인지  
　　　　　// 답인지를 나타내는 플래그를 설정합니다.  
　　　}  

　　　private void **open()** {  
　　　　　// 파일 대화상자를 열고 사용자가 열고  
　　　　　// 싶은 카드 세트를 찾을 때까지 대기합니다.  
　　　}  

　　　private void **loadFile(File file)** {  
　　　　　// OpenMenuListener 이벤트 핸들러로부터 호출되는 텍스트 파일로부터  
　　　　　// 읽어들임으로써 카드의 ArrayList를 구축하고, 파일을 한 번에  
　　　　　// 한 줄씩 읽어들이고 makeCard() 메서드에 새로 들어오는  
　　　　　// 줄 하나마다 새 카드를 하나씩 만들도록 합니다(파일의  
　　　　　// 한  줄에 질문과 답이 '/'로 구분되어 모두 들어가 있습니다.)  
　　　}  

　　　private void **makeCard(String lineToParse)** {  
　　　　　// loadFile 메서드에서 호출하는 메서드로, 텍스트 파일을 한 줄  
　　　　　// 읽어와서 문제와 답으로 파싱하여 새로운 QuizCard를 생성하고,  
　　　　　// 그 카드를 CardList라는 ArrayList에 추가합니다.  
　　　}  
}