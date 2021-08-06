package Artist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	ArrayList<Rapper> rapList = new ArrayList<>();
	ArrayList<User> userList = new ArrayList<>();
	Scanner keyin = new Scanner(System.in); // 메인의 필드로 키보드 스케너
	private int[] rankcount = new int[100];
	private int[] likecount = new int[100];
	private int[] abmlikecount = new int[100];
	private int[] hitlikecount = new int[100];
	private int[] finalcount = new int[100];

	void mymain() {
		readAllRapper();
		printAllRapper();
		search();
		menu();
		usermenu();
		finalmenu();
	}

	void finalmenu() {
		while (true) {
			System.out.println("-------------------<메뉴3>------------------");
			System.out.println("[메뉴1,메뉴2 데이터의 종합]");
			System.out.println(" [1]:총괄아티스트 순위(탑10).\n [2]:좋아요 아티스트 순위(탑10)\n "
					+ "[3]:앨범 아티스트 순위(탑10)\n [4]:히트곡 아티스트 순위(탑10)\n [5]:모든 순위가 20위 안에드는 아티스트\n [6]:아티스트 순위검색\n [0]:종료\n");
			System.out.printf("입력: ");
			int n = keyin.nextInt();
			switch (n) {
			case 1:
				totalRapper();
				break;
			case 2:
				totalLikeRapper();
				break;
			case 3:
				totalABMLikeRapper();
				break;
			case 4:
				totalHitLikeRapper();
				break;
			case 5:
				total20Rapper();
				break;
			case 6:
				search_totalRapper();
				break;
			case 0:
				break;
			}
			if (n == 0)
				break;
		}

	}

	void total20Rapper() {
		userRapper();
		int[] totalcount = new int[100];
		for (int i = 0; i < 60; i++) {
			totalcount[i] = 0;
			totalcount[i] = hitlikecount[i] + abmlikecount[i] + likecount[i] + rankcount[i];
		}

		for (int i = 0; i < 60; i++) {
			finalcount[i] = 1;
			for (int j = 0; j < 60; j++) {
				if (totalcount[i] > totalcount[j])
					finalcount[i]++;
			}
		}
		System.out
				.println("\n----------------------------------모든게 20위안에 들어있는 아티스트----------------------------------\n");
		System.out
				.printf("        [이름]\t\t    [토탈순위]\t      [좋아요 순위]\t      [앨범 순위]\t       [히트곡 순위]      [유저투표 순위]\n");

		for (int j = 0; j < 60; j++) {
			if ((likecount[j] <= 20) && (hitlikecount[j] <= 20) && (abmlikecount[j] <= 20) && (finalcount[j] <= 20)
					&& (rankcount[j]) <= 20) {
				System.out.printf("\t%s\t\t", rapList.get(j).rapper);
				if (rapList.get(j).rapper.length() < 7)
					System.out.printf("\t");
				System.out.printf("%d위\t\t %d위\t\t %d위\t\t %d위\t\t %d위\n", likecount[j], abmlikecount[j],
						hitlikecount[j], rankcount[j], finalcount[j]);
			}
		}
	}

	void totalHitLikeRapper() {
		userRapper();
		int[] totalcount = new int[100];
		for (int i = 0; i < 60; i++) {
			totalcount[i] = 0;
			totalcount[i] = hitlikecount[i] + abmlikecount[i] + likecount[i] + rankcount[i];
		}

		for (int i = 0; i < 60; i++) {
			finalcount[i] = 1;
			for (int j = 0; j < 60; j++) {
				if (totalcount[i] > totalcount[j])
					finalcount[i]++;
			}
		}
		System.out.println("\n--------------------히트곡 좋아요 순위--------------------\n");
		System.out
				.printf("     [히트곡 순위]\t\t[이름]                [토탈순위]\t      [좋아요 순위]\t      [앨범 순위]       [유저투표 순위]\n");
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 60; j++) {
				if (i == hitlikecount[j]) {
					System.out.printf("\t[%d]위 \t\t%s\t\t", hitlikecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 7)
						System.out.printf("\t");
					System.out.printf("%d위\t\t %d위\t\t %d위\t\t %d위\n", finalcount[j], likecount[j], abmlikecount[j],
							rankcount[j]);
				}
			}
	}

	void totalABMLikeRapper() {
		userRapper();
		int[] totalcount = new int[100];
		for (int i = 0; i < 60; i++) {
			totalcount[i] = 0;
			totalcount[i] = hitlikecount[i] + abmlikecount[i] + likecount[i] + rankcount[i];
		}

		for (int i = 0; i < 60; i++) {
			finalcount[i] = 1;
			for (int j = 0; j < 60; j++) {
				if (totalcount[i] > totalcount[j])
					finalcount[i]++;
			}
		}
		System.out.println("\n--------------------앨범 좋아요 순위--------------------\n");
		System.out
				.printf("     [앨범 순위]\t\t[이름]                [토탈순위]\t      [좋아요 순위]\t      [히트곡 순위]       [유저투표 순위]\n");
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 60; j++) {
				if (i == abmlikecount[j]) {
					System.out.printf("\t[%d]위 \t\t%s\t\t", abmlikecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 7)
						System.out.printf("\t");
					System.out.printf("%d위\t\t %d위\t\t %d위\t\t %d위\n", finalcount[j], likecount[j], hitlikecount[j],
							rankcount[j]);
				}
			}
	}

	void totalLikeRapper() {
		userRapper();
		int[] totalcount = new int[100];
		for (int i = 0; i < 60; i++) {
			totalcount[i] = 0;
			totalcount[i] = hitlikecount[i] + abmlikecount[i] + likecount[i] + rankcount[i];
		}

		for (int i = 0; i < 60; i++) {
			finalcount[i] = 1;
			for (int j = 0; j < 60; j++) {
				if (totalcount[i] > totalcount[j])
					finalcount[i]++;
			}
		}
		System.out.println("\n--------------------좋아요 순위--------------------\n");
		System.out
				.printf("     [좋아요 순위]\t\t[이름]                [토탈순위]\t      [앨범 순위]\t      [히트곡 순위]       [유저투표 순위]\n");
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 60; j++) {
				if (i == likecount[j]) {
					System.out.printf("\t[%d]위 \t\t%s\t\t", likecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 7)
						System.out.printf("\t");
					System.out.printf("%d위\t\t %d위\t\t %d위\t\t %d위\n", finalcount[j], abmlikecount[j], hitlikecount[j],
							rankcount[j]);
				}
			}
	}

	void menu() {
		likeRapper();
		System.out.println();

		while (true) {
			System.out.println("-------------------<메뉴1>------------------");
			System.out.println("[좋아요,앨범 좋아요,히트곡 좋아요 기반 메뉴]");
			System.out.println(" [1]:아티스트 총합 순위.\n [2]:아티스트 검색.\n [3]:아티스트 순위비교.\n [4]:탑10\n [0]:다음과정\n");
			System.out.printf("입력: ");
			int n = keyin.nextInt();
			switch (n) {
			case 1:
				likeRapperPrint();
				break;
			case 2:
				search_LikeRapper();
				break;
			case 3:
				compareRapper();
				break;
			case 4:
				toptenRapper();
				break;
			case 0:
				break;
			}
			if (n == 0)
				break;
		}

	}

	void usermenu() {
		User.main = this;
		readAllUsers();
		userRapper();
		System.out.println();
		while (true) {
			System.out.println("-------------------<메뉴2>------------------");
			System.out.println("[메뉴1과 유저투표 데이터를 기반으로한 메뉴]");
			System.out.println(" [1]:유저들의 선택.\n [2]:유저 투표 결과(현재 총괄 탑10).\n [3]:아티스트 투표수  검색.\n [0]:다음과정\n");
			System.out.printf("입력: ");
			int n = keyin.nextInt();
			switch (n) {
			case 1:
				printAllUsers();
				break;
			case 2:
				System.out.println("-----------------<탑10>-----------------");
				getFavoriteRapper();
				break;
			case 3:
				search_tenRapper();
				break;
			case 0:
				break;
			}
			if (n == 0)
				break;
		}

	}

	void toptenRapper() {
		System.out.println("<좋아요 순위>                       <앨범 순위>                        <히트곡 순위>");
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 60; j++) {
				if (i == likecount[j]) {
					System.out.printf("좋아요[%d]위: %s\t\t", likecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 5)
						System.out.printf("\t");
				}
			}
			for (int j = 0; j < 60; j++) {
				if (i == abmlikecount[j]) {
					System.out.printf("앨범[%d]위: %s\t\t", abmlikecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() <= 5)
						System.out.printf("\t");
				}
			}
			for (int j = 0; j < 60; j++) {
				if (i == hitlikecount[j])
					System.out.printf("히트곡[%d]위: %s\n", hitlikecount[j], rapList.get(j).rapper);
			}

		}
	}

	void totalRapper() {
		userRapper();
		int[] totalcount = new int[100];
		for (int i = 0; i < 60; i++) {
			totalcount[i] = 0;
			totalcount[i] = hitlikecount[i] + abmlikecount[i] + likecount[i] + rankcount[i];
		}

		for (int i = 0; i < 60; i++) {
			finalcount[i] = 1;
			for (int j = 0; j < 60; j++) {
				if (totalcount[i] > totalcount[j])
					finalcount[i]++;
			}
		}
		System.out.println("\n--------------------최종순위--------------------\n");
		System.out
				.printf("     [토탈순위]\t\t  [이름]             [좋아요 순위]\t      [앨범 순위]\t      [히트곡 순위]       [유저투표 순위]\n");
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 60; j++) {
				if (i == finalcount[j]) {
					System.out.printf("\t[%d]위 \t\t%s\t\t", finalcount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 7)
						System.out.printf("\t");
					System.out.printf("%d위\t\t %d위\t\t %d위\t\t %d위\n", likecount[j], abmlikecount[j], hitlikecount[j],
							rankcount[j]);
				}
			}
	}

	void compareRapper() {
		System.out.printf("\n---------------------------[아티스트 비교]---------------------------\n");
		System.out.printf("\n원하는 아티스트 이름 입력: ");
		String kwd = keyin.next();
		System.out.printf("\n비교 하고싶은 아티스트 이름 입력: ");
		String ckwd = keyin.next();
		int x = 0, y = 0;
		for (int i = 0; i < 60; i++) {
			if (kwd.equals(rapList.get(i).rapper)) {
				System.out.printf(
						"[ %d]\t %s\t 좋아요순위: %d위\t 좋아요: %d개\t 앨범순위: %d위\t 앨범좋아요: %d개\t 히트곡순위: %d위\t 히트곡 좋아요: %d개\t\n",
						rapList.get(i).id, rapList.get(i).rapper, likecount[i], rapList.get(i).like, abmlikecount[i],
						rapList.get(i).abmlike, hitlikecount[i], rapList.get(i).hitlike);
				x = i;
			}

		}
		for (int i = 0; i < 60; i++) {
			if (ckwd.equals(rapList.get(i).rapper)) {
				System.out.printf(
						"[ %d]\t %s\t 좋아요순위: %d위\t 좋아요: %d개\t 앨범순위: %d위\t 앨범좋아요: %d개\t 히트곡순위: %d위\t 히트곡 좋아요: %d개\t\n",
						rapList.get(i).id, rapList.get(i).rapper, likecount[i], rapList.get(i).like, abmlikecount[i],
						rapList.get(i).abmlike, hitlikecount[i], rapList.get(i).hitlike);
				y = i;
			}
		}
		System.out.printf(
				"\n%s은(는) %s보다\t 좋아요 순위: %d\t 좋아요: %d\t 앨범순위: %d\t 앨범좋아요: %d\t 히트곡순위: %d\t 히트곡좋아요: %d\t 만큼 앞서있습니다.\n",
				rapList.get(x).rapper, rapList.get(y).rapper, likecount[y] - likecount[x],
				rapList.get(x).like - rapList.get(y).like, abmlikecount[y] - abmlikecount[x],
				rapList.get(x).abmlike - rapList.get(y).abmlike, hitlikecount[y] - hitlikecount[x],
				rapList.get(x).hitlike - rapList.get(y).hitlike);

	}

	void search_LikeRapper() {
		System.out.printf("\n[아티스트 검색]키워드 입력(이름,순서,종료는 end): ");
		String kwd = keyin.next();
		while (true) {
			if (kwd.equals("end"))
				break;
			for (int i = 0; i < 60; i++) {
				if (kwd.equals(rapList.get(i).rapper)) {
					System.out.printf(
							"[ %d]\t %s\t 좋아요순위: %d위\t 좋아요: %d개\t 앨범순위: %d위\t 앨범좋아요: %d개\t 히트곡순위: %d위\t 히트곡 좋아요: %d개\t\n",
							rapList.get(i).id, rapList.get(i).rapper, likecount[i], rapList.get(i).like,
							abmlikecount[i], rapList.get(i).abmlike, hitlikecount[i], rapList.get(i).hitlike);
				}
			}
			if (kwd.matches("[0-9]+")) {
				int year = Integer.parseInt(kwd);
				for (int i = 0; i < 60; i++) {
					if (rapList.get(i).id == year)
						System.out.printf(
								"[ %d]\t %s\t 좋아요순위: %d위\t 좋아요: %d개\t 앨범순위: %d위\t 앨범좋아요: %d개\t 히트곡순위: %d위\t 히트곡 좋아요: %d개\t\n",
								rapList.get(i).id, rapList.get(i).rapper, likecount[i], rapList.get(i).like,
								abmlikecount[i], rapList.get(i).abmlike, hitlikecount[i], rapList.get(i).hitlike);
				}
			}

			System.out.printf("\n[아티스트 검색]키워드 입력(이름,순서,종료는 end): ");
			kwd = keyin.next();
		}
		System.out.println("기능을 종료합니다");
	}

	void likeRapper() {
		for (int i = 0; i < 60; i++) {
			abmlikecount[i] = 1;
			likecount[i] = 1;
			hitlikecount[i] = 1;
			for (int j = 0; j < 60; j++) {
				if (rapList.get(i).abmlike < rapList.get(j).abmlike) {
					abmlikecount[i]++;
				}
				if (rapList.get(i).hitlike < rapList.get(j).hitlike) {
					hitlikecount[i]++;
				}
				if (rapList.get(i).like < rapList.get(j).like) {
					likecount[i]++;
				}
			}
		}
	}

	void likeRapperPrint() {
		System.out.println("------------------------------------" + "출력------------------------------------\n");
		System.out.printf("\t       [이름]\t      [좋아요 순위]\t\t[좋아요 개수]\t [앨범순위] \t [앨범좋아요] \t[히트곡순위]\t[히트곡 좋아요]\n");
		for (int i = 0; i < 60; i++) {
			System.out.printf("[ %d]\t\t%s\t", rapList.get(i).id, rapList.get(i).rapper);
			if (rapList.get(i).rapper.length() < 7)
				System.out.printf("\t");
			System.out.printf(" %d위\t\t %d개\t\t  %d위\t\t  %d개\t\t  %d위\t\t %d개\t\t\n", likecount[i],
					rapList.get(i).like, abmlikecount[i], rapList.get(i).abmlike, hitlikecount[i],
					rapList.get(i).hitlike);
		}
	}

	void userRapper() {
		int count[] = new int[200];
		for (User u : userList)
			u.count(count);
		for (int i = 0; i < 60; i++) {
			rankcount[i] = 1;
			for (int j = 0; j < 60; j++) {
				if (count[i] < count[j])
					rankcount[i]++;
			}
		}
	}

	void getFavoriteRapper() {
		int count[] = new int[200];
		for (User u : userList)
			u.count(count);
		int maxindex = 0;
		for (int i = 0; i < 100; i++) {
			if (count[i] > count[maxindex])
				maxindex = i;
		}
		for (int i = 0; i < 60; i++) {
			rankcount[i] = 1;
			for (int j = 0; j < 60; j++) {
				if (count[i] < count[j])
					rankcount[i]++;
			}
		}
		System.out.println("<유저투표순위>           <유저 투표수>            <좋아요 순위>                       <앨범 순위>                        <히트곡 순위>");
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 60; j++) {
				if (j >= 1)
					for (int k = 0; k < 60; k++) {
						if (j != k) {
							if (rankcount[j] == rankcount[k])
								rankcount[j]++;
						}
					}

				if (i == rankcount[j]) {
					System.out.printf("투표[%d]위 %s",rankcount[j],rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 7)
						System.out.printf("\t");
					System.out.printf("\t%d회\t\t", count[j]);
					break;
				}
			}
			for (int j = 0; j < 60; j++) {
				if (i == likecount[j]) {
					System.out.printf("좋아요[%d]위: %s\t\t", likecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 5)
						System.out.printf("\t");
				}
			}
			for (int j = 0; j < 60; j++) {
				if (i == abmlikecount[j]) {
					System.out.printf("앨범[%d]위: %s\t\t", abmlikecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() <= 5)
						System.out.printf("\t");
				}
			}
			for (int j = 0; j < 60; j++) {
				if (i == hitlikecount[j]) {
					System.out.printf("히트곡[%d]위: %s\t\t", hitlikecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 5)
						System.out.printf("\t");
				}
			}
			System.out.printf("\n");
		}
	 System.out.printf("사람들이 가장 많이 선택한 아티스트는 %s입니다.\n\n\n",rapList.get(maxindex).rapper);

	}

	void search_totalRapper() {
		userRapper();
		int[] totalcount = new int[100];
		for (int i = 0; i < 60; i++) {
			totalcount[i] = 0;
			totalcount[i] = hitlikecount[i] + abmlikecount[i] + likecount[i] + rankcount[i];
		}

		for (int i = 0; i < 60; i++) {
			finalcount[i] = 1;
			for (int j = 0; j < 60; j++) {
				if (totalcount[i] > totalcount[j])
					finalcount[i]++;
			}
		}
		System.out.printf("키워드 입력(이름,순위,종료는 end): ");
		String kwd = keyin.next();
		while (true) {
			if (kwd.equals("end"))
				break;
			for (int i = 0; i < 60; i++) {
				if (kwd.matches(rapList.get(i).rapper)) {
					System.out.printf("%s은(는) 총합 %s위이고 좋아요 순위: %d 앨범순위: %d 히트곡 순위: %d 유저 투표순위: %d 입니다.\n",
							rapList.get(i).rapper, finalcount[i], likecount[i], abmlikecount[i], hitlikecount[i],
							rankcount[i]);
				}
			}
			if (kwd.matches("[0-9]+")) {
				int year = Integer.parseInt(kwd);
				for (int i = 0; i < 60; i++) {
					if (rankcount[i] == year)
						System.out.printf("토탈 %s위는 %s이고 좋아요 순위: %d 앨범순위: %d 히트곡 순위: %d 유저 투표순위: %d 입니다.\n", kwd,
								rapList.get(i).rapper, likecount[i], abmlikecount[i], hitlikecount[i], rankcount[i]);
				}

			}
			System.out.printf("키워드 입력(이름,순위,종료는 end): ");
			kwd = keyin.next();
		}
		System.out.println("기능을 종료합니다");
	}

	void search_tenRapper() {
		int count[] = new int[200];
		for (User u : userList)
			u.count(count);
		System.out.printf("키워드 입력(이름,순위,종료는 end): ");
		String kwd = keyin.next();
		while (true) {
			if (kwd.equals("end"))
				break;
			for (int i = 0; i < 60; i++) {
				if (kwd.matches(rapList.get(i).rapper)) {
					System.out.printf("%s은(는) %s위이고 %d번 선택 되었습니다.\n", rapList.get(i).rapper, rankcount[i], count[i]);
				}
			}
			if (kwd.matches("[0-9]+")) {
				int year = Integer.parseInt(kwd);
				for (int i = 0; i < 60; i++) {
					if (rankcount[i] == year)
						System.out.printf("%s위는 %s이고 %d번 선택되었습니다.\n", kwd, rapList.get(i).rapper, count[i]);
				}

			}
			System.out.printf("키워드 입력(이름,순위,종료는 end): ");
			kwd = keyin.next();
		}
		System.out.println("기능을 종료합니다");
	}

	void searchUser() {
		System.out.printf("키워드 입력: ");
		String kwd = keyin.next();
		while (kwd != "end") {
			for (User s : userList)
				if (s.matches(kwd))
					s.print();
			kwd = keyin.next();
		}
	}

	void readAllUsers() {
		Scanner filein = openFile("list.txt"); // 빨간줄을 바로바로 고쳐주는게 중요하다!!
		while (filein.hasNext()) {
			User u = new User();
			u.read(filein);
			userList.add(u);
		}
		filein.close();
	}

	Rapper findRapper(int n) {
		return rapList.get(n);
	}

	void printAllUsers() {
		for (User s : userList)
			s.print();
	}

	void readAllRapper() {
		Scanner filein = openFile("rappers.txt"); // 빨간줄을 바로바로 고쳐주는게 중요하다!!
		while (filein.hasNext()) {
			Rapper s = new Rapper();
			s.read(filein);
			rapList.add(s);
		}
		filein.close();
	}

	void printAllRapper() {
		System.out.printf("   [아티스트 이름]         [좋아요 수]      [대표음반]         [음반 좋아요수]    [히트곡]            [히트곡 좋아요]\n");
		for (Rapper r : rapList)
			r.print();
	}

	void search() {
		System.out.printf("키워드 입력(종료는 end): ");
		String kwd = keyin.next();
		while (true) {
			if (kwd.equals("end"))
				break;
			for (Rapper r : rapList)
				if (r.matches(kwd)) {
					System.out.printf(
							"   [아티스트 이름]         [좋아요 수]      [대표음반]         [음반 좋아요수]    [히트곡]            [히트곡 좋아요]\n");
					r.print();
				}
			System.out.printf("\n키워드 입력(종료는 end): ");
			kwd = keyin.next();
		}
	}

	Scanner openFile(String filename) {
		File f = new File(filename);
		Scanner s = null;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return s;
	}

	public static void main(String[] args) {
		Main a = new Main();
		a.mymain();
	}

}
