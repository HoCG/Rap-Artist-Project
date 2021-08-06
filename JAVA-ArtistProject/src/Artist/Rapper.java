package Artist;

import java.util.Scanner;

public class Rapper {
	int id;
	String rapper;
	int like;
	String album;
	int abmlike;
	String hitsong;
	int hitlike;

	void read(Scanner scan) {
		id = scan.nextInt();
		rapper = scan.next();
		like = scan.nextInt();
		album = scan.next();
		abmlike = scan.nextInt();
		hitsong = scan.next();
		hitlike = scan.nextInt();
	}

	//줄맞춤
	void print() {
		System.out.printf("[%3d] %s\t ", id, rapper);
		if (rapper.length() < 8)
			System.out.printf("\t");
		System.out.printf("%d개\t %s\t", like, album);
		if (album.length() < 15)
			System.out.printf("\t");
		if (album.length() < 7)
			System.out.printf("\t");
		System.out.printf("%d개\t %s\t", abmlike, hitsong);
		if (hitsong.length() < 15)
			System.out.printf("\t");
		if (hitsong.length() < 7)
			System.out.printf("\t");
		System.out.printf("%d개\n", hitlike);
	}

	boolean matches(String kwd) {
		if (kwd.equals(id + ""))
			return true;
		if (rapper.contains(kwd))
			return true;
		if (album.contains(kwd))
			return true;
		if (hitsong.contains(kwd))
			return true;
		if (kwd.matches("[0-9]+")) {
			int year = Integer.parseInt(kwd);
			if (year <= like)
				return true;
		}
		if (kwd.matches("[0-9]+")) {
			int year = Integer.parseInt(kwd);
			if (year <= abmlike)
				return true;
		}
		if (kwd.matches("[0-9]+")) {
			int year = Integer.parseInt(kwd);
			if (year <= hitlike)
				return true;
		}
		return false;
	}
}
