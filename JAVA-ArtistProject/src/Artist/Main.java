package Artist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	ArrayList<Rapper> rapList = new ArrayList<>();
	ArrayList<User> userList = new ArrayList<>();
	Scanner keyin = new Scanner(System.in); // ������ �ʵ�� Ű���� ���ɳ�
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
			System.out.println("-------------------<�޴�3>------------------");
			System.out.println("[�޴�1,�޴�2 �������� ����]");
			System.out.println(" [1]:�Ѱ���Ƽ��Ʈ ����(ž10).\n [2]:���ƿ� ��Ƽ��Ʈ ����(ž10)\n "
					+ "[3]:�ٹ� ��Ƽ��Ʈ ����(ž10)\n [4]:��Ʈ�� ��Ƽ��Ʈ ����(ž10)\n [5]:��� ������ 20�� �ȿ���� ��Ƽ��Ʈ\n [6]:��Ƽ��Ʈ �����˻�\n [0]:����\n");
			System.out.printf("�Է�: ");
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
				.println("\n----------------------------------���� 20���ȿ� ����ִ� ��Ƽ��Ʈ----------------------------------\n");
		System.out
				.printf("        [�̸�]\t\t    [��Ż����]\t      [���ƿ� ����]\t      [�ٹ� ����]\t       [��Ʈ�� ����]      [������ǥ ����]\n");

		for (int j = 0; j < 60; j++) {
			if ((likecount[j] <= 20) && (hitlikecount[j] <= 20) && (abmlikecount[j] <= 20) && (finalcount[j] <= 20)
					&& (rankcount[j]) <= 20) {
				System.out.printf("\t%s\t\t", rapList.get(j).rapper);
				if (rapList.get(j).rapper.length() < 7)
					System.out.printf("\t");
				System.out.printf("%d��\t\t %d��\t\t %d��\t\t %d��\t\t %d��\n", likecount[j], abmlikecount[j],
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
		System.out.println("\n--------------------��Ʈ�� ���ƿ� ����--------------------\n");
		System.out
				.printf("     [��Ʈ�� ����]\t\t[�̸�]                [��Ż����]\t      [���ƿ� ����]\t      [�ٹ� ����]       [������ǥ ����]\n");
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 60; j++) {
				if (i == hitlikecount[j]) {
					System.out.printf("\t[%d]�� \t\t%s\t\t", hitlikecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 7)
						System.out.printf("\t");
					System.out.printf("%d��\t\t %d��\t\t %d��\t\t %d��\n", finalcount[j], likecount[j], abmlikecount[j],
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
		System.out.println("\n--------------------�ٹ� ���ƿ� ����--------------------\n");
		System.out
				.printf("     [�ٹ� ����]\t\t[�̸�]                [��Ż����]\t      [���ƿ� ����]\t      [��Ʈ�� ����]       [������ǥ ����]\n");
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 60; j++) {
				if (i == abmlikecount[j]) {
					System.out.printf("\t[%d]�� \t\t%s\t\t", abmlikecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 7)
						System.out.printf("\t");
					System.out.printf("%d��\t\t %d��\t\t %d��\t\t %d��\n", finalcount[j], likecount[j], hitlikecount[j],
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
		System.out.println("\n--------------------���ƿ� ����--------------------\n");
		System.out
				.printf("     [���ƿ� ����]\t\t[�̸�]                [��Ż����]\t      [�ٹ� ����]\t      [��Ʈ�� ����]       [������ǥ ����]\n");
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 60; j++) {
				if (i == likecount[j]) {
					System.out.printf("\t[%d]�� \t\t%s\t\t", likecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 7)
						System.out.printf("\t");
					System.out.printf("%d��\t\t %d��\t\t %d��\t\t %d��\n", finalcount[j], abmlikecount[j], hitlikecount[j],
							rankcount[j]);
				}
			}
	}

	void menu() {
		likeRapper();
		System.out.println();

		while (true) {
			System.out.println("-------------------<�޴�1>------------------");
			System.out.println("[���ƿ�,�ٹ� ���ƿ�,��Ʈ�� ���ƿ� ��� �޴�]");
			System.out.println(" [1]:��Ƽ��Ʈ ���� ����.\n [2]:��Ƽ��Ʈ �˻�.\n [3]:��Ƽ��Ʈ ������.\n [4]:ž10\n [0]:��������\n");
			System.out.printf("�Է�: ");
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
			System.out.println("-------------------<�޴�2>------------------");
			System.out.println("[�޴�1�� ������ǥ �����͸� ��������� �޴�]");
			System.out.println(" [1]:�������� ����.\n [2]:���� ��ǥ ���(���� �Ѱ� ž10).\n [3]:��Ƽ��Ʈ ��ǥ��  �˻�.\n [0]:��������\n");
			System.out.printf("�Է�: ");
			int n = keyin.nextInt();
			switch (n) {
			case 1:
				printAllUsers();
				break;
			case 2:
				System.out.println("-----------------<ž10>-----------------");
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
		System.out.println("<���ƿ� ����>                       <�ٹ� ����>                        <��Ʈ�� ����>");
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 60; j++) {
				if (i == likecount[j]) {
					System.out.printf("���ƿ�[%d]��: %s\t\t", likecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 5)
						System.out.printf("\t");
				}
			}
			for (int j = 0; j < 60; j++) {
				if (i == abmlikecount[j]) {
					System.out.printf("�ٹ�[%d]��: %s\t\t", abmlikecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() <= 5)
						System.out.printf("\t");
				}
			}
			for (int j = 0; j < 60; j++) {
				if (i == hitlikecount[j])
					System.out.printf("��Ʈ��[%d]��: %s\n", hitlikecount[j], rapList.get(j).rapper);
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
		System.out.println("\n--------------------��������--------------------\n");
		System.out
				.printf("     [��Ż����]\t\t  [�̸�]             [���ƿ� ����]\t      [�ٹ� ����]\t      [��Ʈ�� ����]       [������ǥ ����]\n");
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 60; j++) {
				if (i == finalcount[j]) {
					System.out.printf("\t[%d]�� \t\t%s\t\t", finalcount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 7)
						System.out.printf("\t");
					System.out.printf("%d��\t\t %d��\t\t %d��\t\t %d��\n", likecount[j], abmlikecount[j], hitlikecount[j],
							rankcount[j]);
				}
			}
	}

	void compareRapper() {
		System.out.printf("\n---------------------------[��Ƽ��Ʈ ��]---------------------------\n");
		System.out.printf("\n���ϴ� ��Ƽ��Ʈ �̸� �Է�: ");
		String kwd = keyin.next();
		System.out.printf("\n�� �ϰ���� ��Ƽ��Ʈ �̸� �Է�: ");
		String ckwd = keyin.next();
		int x = 0, y = 0;
		for (int i = 0; i < 60; i++) {
			if (kwd.equals(rapList.get(i).rapper)) {
				System.out.printf(
						"[ %d]\t %s\t ���ƿ����: %d��\t ���ƿ�: %d��\t �ٹ�����: %d��\t �ٹ����ƿ�: %d��\t ��Ʈ�����: %d��\t ��Ʈ�� ���ƿ�: %d��\t\n",
						rapList.get(i).id, rapList.get(i).rapper, likecount[i], rapList.get(i).like, abmlikecount[i],
						rapList.get(i).abmlike, hitlikecount[i], rapList.get(i).hitlike);
				x = i;
			}

		}
		for (int i = 0; i < 60; i++) {
			if (ckwd.equals(rapList.get(i).rapper)) {
				System.out.printf(
						"[ %d]\t %s\t ���ƿ����: %d��\t ���ƿ�: %d��\t �ٹ�����: %d��\t �ٹ����ƿ�: %d��\t ��Ʈ�����: %d��\t ��Ʈ�� ���ƿ�: %d��\t\n",
						rapList.get(i).id, rapList.get(i).rapper, likecount[i], rapList.get(i).like, abmlikecount[i],
						rapList.get(i).abmlike, hitlikecount[i], rapList.get(i).hitlike);
				y = i;
			}
		}
		System.out.printf(
				"\n%s��(��) %s����\t ���ƿ� ����: %d\t ���ƿ�: %d\t �ٹ�����: %d\t �ٹ����ƿ�: %d\t ��Ʈ�����: %d\t ��Ʈ�����ƿ�: %d\t ��ŭ �ռ��ֽ��ϴ�.\n",
				rapList.get(x).rapper, rapList.get(y).rapper, likecount[y] - likecount[x],
				rapList.get(x).like - rapList.get(y).like, abmlikecount[y] - abmlikecount[x],
				rapList.get(x).abmlike - rapList.get(y).abmlike, hitlikecount[y] - hitlikecount[x],
				rapList.get(x).hitlike - rapList.get(y).hitlike);

	}

	void search_LikeRapper() {
		System.out.printf("\n[��Ƽ��Ʈ �˻�]Ű���� �Է�(�̸�,����,����� end): ");
		String kwd = keyin.next();
		while (true) {
			if (kwd.equals("end"))
				break;
			for (int i = 0; i < 60; i++) {
				if (kwd.equals(rapList.get(i).rapper)) {
					System.out.printf(
							"[ %d]\t %s\t ���ƿ����: %d��\t ���ƿ�: %d��\t �ٹ�����: %d��\t �ٹ����ƿ�: %d��\t ��Ʈ�����: %d��\t ��Ʈ�� ���ƿ�: %d��\t\n",
							rapList.get(i).id, rapList.get(i).rapper, likecount[i], rapList.get(i).like,
							abmlikecount[i], rapList.get(i).abmlike, hitlikecount[i], rapList.get(i).hitlike);
				}
			}
			if (kwd.matches("[0-9]+")) {
				int year = Integer.parseInt(kwd);
				for (int i = 0; i < 60; i++) {
					if (rapList.get(i).id == year)
						System.out.printf(
								"[ %d]\t %s\t ���ƿ����: %d��\t ���ƿ�: %d��\t �ٹ�����: %d��\t �ٹ����ƿ�: %d��\t ��Ʈ�����: %d��\t ��Ʈ�� ���ƿ�: %d��\t\n",
								rapList.get(i).id, rapList.get(i).rapper, likecount[i], rapList.get(i).like,
								abmlikecount[i], rapList.get(i).abmlike, hitlikecount[i], rapList.get(i).hitlike);
				}
			}

			System.out.printf("\n[��Ƽ��Ʈ �˻�]Ű���� �Է�(�̸�,����,����� end): ");
			kwd = keyin.next();
		}
		System.out.println("����� �����մϴ�");
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
		System.out.println("------------------------------------" + "���------------------------------------\n");
		System.out.printf("\t       [�̸�]\t      [���ƿ� ����]\t\t[���ƿ� ����]\t [�ٹ�����] \t [�ٹ����ƿ�] \t[��Ʈ�����]\t[��Ʈ�� ���ƿ�]\n");
		for (int i = 0; i < 60; i++) {
			System.out.printf("[ %d]\t\t%s\t", rapList.get(i).id, rapList.get(i).rapper);
			if (rapList.get(i).rapper.length() < 7)
				System.out.printf("\t");
			System.out.printf(" %d��\t\t %d��\t\t  %d��\t\t  %d��\t\t  %d��\t\t %d��\t\t\n", likecount[i],
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
		System.out.println("<������ǥ����>           <���� ��ǥ��>            <���ƿ� ����>                       <�ٹ� ����>                        <��Ʈ�� ����>");
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
					System.out.printf("��ǥ[%d]�� %s",rankcount[j],rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 7)
						System.out.printf("\t");
					System.out.printf("\t%dȸ\t\t", count[j]);
					break;
				}
			}
			for (int j = 0; j < 60; j++) {
				if (i == likecount[j]) {
					System.out.printf("���ƿ�[%d]��: %s\t\t", likecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 5)
						System.out.printf("\t");
				}
			}
			for (int j = 0; j < 60; j++) {
				if (i == abmlikecount[j]) {
					System.out.printf("�ٹ�[%d]��: %s\t\t", abmlikecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() <= 5)
						System.out.printf("\t");
				}
			}
			for (int j = 0; j < 60; j++) {
				if (i == hitlikecount[j]) {
					System.out.printf("��Ʈ��[%d]��: %s\t\t", hitlikecount[j], rapList.get(j).rapper);
					if (rapList.get(j).rapper.length() < 5)
						System.out.printf("\t");
				}
			}
			System.out.printf("\n");
		}
	 System.out.printf("������� ���� ���� ������ ��Ƽ��Ʈ�� %s�Դϴ�.\n\n\n",rapList.get(maxindex).rapper);

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
		System.out.printf("Ű���� �Է�(�̸�,����,����� end): ");
		String kwd = keyin.next();
		while (true) {
			if (kwd.equals("end"))
				break;
			for (int i = 0; i < 60; i++) {
				if (kwd.matches(rapList.get(i).rapper)) {
					System.out.printf("%s��(��) ���� %s���̰� ���ƿ� ����: %d �ٹ�����: %d ��Ʈ�� ����: %d ���� ��ǥ����: %d �Դϴ�.\n",
							rapList.get(i).rapper, finalcount[i], likecount[i], abmlikecount[i], hitlikecount[i],
							rankcount[i]);
				}
			}
			if (kwd.matches("[0-9]+")) {
				int year = Integer.parseInt(kwd);
				for (int i = 0; i < 60; i++) {
					if (rankcount[i] == year)
						System.out.printf("��Ż %s���� %s�̰� ���ƿ� ����: %d �ٹ�����: %d ��Ʈ�� ����: %d ���� ��ǥ����: %d �Դϴ�.\n", kwd,
								rapList.get(i).rapper, likecount[i], abmlikecount[i], hitlikecount[i], rankcount[i]);
				}

			}
			System.out.printf("Ű���� �Է�(�̸�,����,����� end): ");
			kwd = keyin.next();
		}
		System.out.println("����� �����մϴ�");
	}

	void search_tenRapper() {
		int count[] = new int[200];
		for (User u : userList)
			u.count(count);
		System.out.printf("Ű���� �Է�(�̸�,����,����� end): ");
		String kwd = keyin.next();
		while (true) {
			if (kwd.equals("end"))
				break;
			for (int i = 0; i < 60; i++) {
				if (kwd.matches(rapList.get(i).rapper)) {
					System.out.printf("%s��(��) %s���̰� %d�� ���� �Ǿ����ϴ�.\n", rapList.get(i).rapper, rankcount[i], count[i]);
				}
			}
			if (kwd.matches("[0-9]+")) {
				int year = Integer.parseInt(kwd);
				for (int i = 0; i < 60; i++) {
					if (rankcount[i] == year)
						System.out.printf("%s���� %s�̰� %d�� ���õǾ����ϴ�.\n", kwd, rapList.get(i).rapper, count[i]);
				}

			}
			System.out.printf("Ű���� �Է�(�̸�,����,����� end): ");
			kwd = keyin.next();
		}
		System.out.println("����� �����մϴ�");
	}

	void searchUser() {
		System.out.printf("Ű���� �Է�: ");
		String kwd = keyin.next();
		while (kwd != "end") {
			for (User s : userList)
				if (s.matches(kwd))
					s.print();
			kwd = keyin.next();
		}
	}

	void readAllUsers() {
		Scanner filein = openFile("list.txt"); // �������� �ٷιٷ� �����ִ°� �߿��ϴ�!!
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
		Scanner filein = openFile("rappers.txt"); // �������� �ٷιٷ� �����ִ°� �߿��ϴ�!!
		while (filein.hasNext()) {
			Rapper s = new Rapper();
			s.read(filein);
			rapList.add(s);
		}
		filein.close();
	}

	void printAllRapper() {
		System.out.printf("   [��Ƽ��Ʈ �̸�]         [���ƿ� ��]      [��ǥ����]         [���� ���ƿ��]    [��Ʈ��]            [��Ʈ�� ���ƿ�]\n");
		for (Rapper r : rapList)
			r.print();
	}

	void search() {
		System.out.printf("Ű���� �Է�(����� end): ");
		String kwd = keyin.next();
		while (true) {
			if (kwd.equals("end"))
				break;
			for (Rapper r : rapList)
				if (r.matches(kwd)) {
					System.out.printf(
							"   [��Ƽ��Ʈ �̸�]         [���ƿ� ��]      [��ǥ����]         [���� ���ƿ��]    [��Ʈ��]            [��Ʈ�� ���ƿ�]\n");
					r.print();
				}
			System.out.printf("\nŰ���� �Է�(����� end): ");
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
