package project2.ver05;

import java.util.*;

public class Puzzle3by3 {

	Scanner scan = new Scanner(System.in);
	final int SIZE = 3;
	int x=2, y=2, count=0, choice, shuffle=5;
	String tmp=null;

	//game : 게임진행을 위한 배열, correct : 정답체크를 위한 배열
	String[][] game = {{" 1 ", " 2 ", " 3 "}
	, {" 4 ", " 5 ", " 6 "}, {" 7 ", " 8 ", " X "}};
	String[][] correct = {{" 1 ", " 2 ", " 3 "}
	, {" 4 ", " 5 ", " 6 "}, {" 7 ", " 8 ", " X "}};

	public void showPuzzle() {
		System.out.println("===========");
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				System.out.printf("%s ", game[i][j]);
			}
			System.out.println();
		}
		System.out.println("===========");
		System.out.println();
	}

	public void shuffle() {
		
		
		while(count < shuffle) {
			try {
				int ranNum = (int)(Math.random()*4+1);
				if(ranNum==1) { 
					tmp = game[x][y];
					game[x][y] = game [x][y-1];
					game[x][y-1] = tmp;
					y--;
					count++;
				}else if(ranNum==2) { 
					tmp = game[x][y];
					game[x][y] = game[x+1][y];
					game[x+1][y] = tmp;
					x++;
					count++;
				}else if(ranNum==3) { 
					tmp = game[x][y];
					game[x][y] = game [x][y+1];
					game[x][y+1] = tmp;
					y++;
					count++;
				}else if(ranNum==4) { 
					tmp = game[x][y];
					game[x][y] = game [x-1][y];
					game[x-1][y] = tmp;
					x--;
					count++;
				}	
			}catch (ArrayIndexOutOfBoundsException e) {
				count++;
			}
		}
	}

	public void reStart() {
		if(Objects.deepEquals(game, correct)==true) {
			System.out.println("==^^정답입니다^^==");
			System.out.println();
			System.out.println("===========");
			for(int i=0;i<SIZE;i++) {
				for(int j=0;j<SIZE;j++) {
					System.out.printf("%s ", correct[i][j]);
				}
				System.out.println();
			}
			System.out.println("===========");
			System.out.println();
			System.out.println("재시작하시겠습니까?");
			System.out.println("재시작하려면 y, 종료하려면 아무키나 입력하세요.");
			System.out.print("입력값 >  ");
			String reStart = scan.nextLine();
			switch (reStart) {
			case "y":
				System.out.println("게임을 재시작합니다.");
				System.out.println();
				execute();
				break;
			default:
				Account ac = new Account();
				ac.printMenu();
				System.out.println();
				break;
			}
		}
	}

	public void welcome() {
		
		
	}

	public void playGame() {
		while(true) {
			try {
				//선택하는 과정
				System.out.println("[ 이동  ] 1:LEft 3:Right"
						+ " 5:Up 2:Down");
				System.out.println("[ 종료  ] 0:Exit");
				System.out.print("이동방향 >  ");
				choice = scan.nextInt();
				scan.nextLine();

				System.out.println();				
				switch (choice) {
				//오른쪽으로 이동
				case 3:
					tmp = game[x][y];
					game[x][y] = game [x][y-1];
					game[x][y-1] = tmp;
					y--;
					break;
					//왼쪽으로 이동
				case 1:
					tmp = game[x][y];
					game[x][y] = game [x][y+1];
					game[x][y+1] = tmp;
					y++;
					break;
					//위쪽으로 이동
				case 2:
					tmp = game[x][y];
					game[x][y] = game [x-1][y];
					game[x-1][y] = tmp;
					x--;
					break;
					//아래쪽으로 이동
				case 5:
					tmp = game[x][y];
					game[x][y] = game[x+1][y];
					game[x+1][y] = tmp;
					x++;
					break;
				case 0:
					return;
				}

				//선택 후 출력되는 퍼즐
				showPuzzle();

				reStart();
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("xxxxxxxxxxxxxxxxxxx");
				System.out.println("xxxxxxx이동불가xxxxxxx");
				System.out.println("xxxxxxxxxxxxxxxxxxx");
			}
		}
	}

	public void execute(){
		System.out.println();
		System.out.println("***퍼즐게임에 오신것을 환영합니다.***");
		
		shuffle();

		showPuzzle();


		playGame();
	}
}
