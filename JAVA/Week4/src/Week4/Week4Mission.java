package Week4;

import java.util.Scanner;

public class Week4Mission {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//12171571 강민상
		String input = "";
		do
		{
			System.out.println("<Q>");
			input = in.nextLine();
			answer(input);
			
		} while(!(input.equals("exit")));

	}
	
	public static void answer(String input)
	{
		String Print = new String();
		switch (input)
		{
		case "안녕?":
			Print = "안녕";
			break;
			
		case "이름이뭐니?":
			Print = "민상이라구해";
			break;
			
		case "오늘날씨는어때?":
			Print = "창밖을 직접봐봐.";
			break;
			
		case "자바기반응용프로그래밍 수업 어떠니?":
			Print = "무지 재미있어!";
			break;
			
		case "지금기분은어떠니?":
			Print = "졸려";
			break;
			
		case "심심해":
			Print = "빨리어플이나만들어!";
			break;
			
		case "배고파":
			Print = "치킨이 진리지~";
			break;
			
		case "언제학교를 갈수있을까?":
			Print = "한학기동안 못갈수도 있어...";
			break;
			
		case "비트박스해줘":
			Print = "북치기박치기북치기박치기북북치기치기박박치기치기";
			break;
			
		case "시리야":
			Print = "전 아이폰이 아닙니다";
			break;
			
		case "하이빅스비":
			Print = "전 갤럭시가 아닙니다";
			break;
			
		case "exit":
			return;
			
		default:
			Print = "난 그건 잘 모르겠어.";
			break;
		}
		System.out.println("<A>\n" + Print);
	}

}
