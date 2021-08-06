package Artist;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	static Main main;
	String name;
	ArrayList<Rapper> select = new ArrayList<>();

	void count(int count[]) {
		for (Rapper s : select)
			count[main.rapList.indexOf(s)]++;
	}

	void read(Scanner scan) {
		name = scan.next();
		int c = scan.nextInt();
		while (c != 0) {
			select.add(main.findRapper(c-1));
			c = scan.nextInt();
		}
	}

	void print() {
		System.out.printf("[%s]", name);
		for (Rapper r : select) {
			System.out.printf(" %s ", r.rapper);
		}
		System.out.println();
	}

	boolean matches(String kwd) {
		if (name.equals(kwd))
			return true;
		return false;
	}

}
