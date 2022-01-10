import java.util.Scanner;
import java.util.ArrayList;

public class AuthorManage implements Manage {

	Scanner input = new Scanner(System.in);
	private ArrayList<Author> authorArrList;
	public AuthorManage() {
		this.authorArrList = null;
	}

	public AuthorManage(ArrayList<Author> authorArrList) {
		this.authorArrList = authorArrList;
	}

	@Override
	public void add() {
		try {
			System.out.println("Nhap so tac gia can them (int)");
			int quantity = input.nextInt();

			for (int i = 0; i < quantity; i++) {
				System.out.println("----------------------------------------------------------\nnhap thong tin tac gia thu " + (i + 1));
				Author author = new Author();
				authorInput(author);
				authorArrList.add(author);
			}
		} catch (Exception e) {
			System.out.println("Error: Wrong type!!!");
		}
	}

// author input function
	private void authorInput(Author author) {

		Scanner scan = new Scanner(System.in);

		System.out.println("nhap ten (String):");
		String name = scan.nextLine();
		System.out.println("nhap but danh (String):");
		String nickname = scan.nextLine();
		try {
			System.out.println("nhap tuoi (int):");
			int age = scan.nextInt();
			author.setAge(age);

		} catch (Exception e) {
			System.out.println("Error: Wrong type!!!");
		}
		author.setName(name);
		author.setAuthorNickname(nickname);
	}

	@Override
	public void update() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Nhap ma tac gia can sua (int)");
		int findByID = scan.nextInt();
		for (Author author : authorArrList) {
			if (author.getAuthorID() == findByID) {
				authorInput(author);
				System.out.println("done!");
				return;
			}
		}
		System.out.println("khong tim thay tac gia co ma la " + findByID);

	}

	@Override
	public void remove() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Nhap ma tac gia can xoa (int):");
		int findByID = scan.nextInt();
		for (Author author : authorArrList) {
			if (author.getAuthorID() == findByID) {
				authorArrList.remove(author);
				return;
			}
		}
		System.out.println("khong tim thay tac gia co ma la " + findByID);
	}

	@Override
	public void search() {
		Scanner scan = new Scanner(System.in);

		System.out.println("nhap 1 de tim theo but danh tac gia; khac 1 de tim theo ma tac gia (int):");
		String findBy = scan.nextLine();

		if (findBy.equals("1")) {
			System.out.println("nhap but danh tac gia can tim (String (tim gan dung)):");
			String findByNname = scan.nextLine();
			for (Author author : authorArrList) {
				if (author.getAuthorNickname().contains(findByNname)) {
					System.out.println("tim thay " + author.toString());
				}
			}
		} else {
			try {
				System.out.println("nhap ma tac gia can tim (int):");
				int findByID = scan.nextInt();
				for (Author author : authorArrList) {
					if (author.getAuthorID() == findByID) {
						System.out.println("tim thay tac gia co thong tin la" + author.toString());
						return;
					}
				}
				System.out.println("khong tim thay tac gia co ma la " + findByID);
			} catch (Exception e) {
				System.out.println("Error: Wrong type!!!");
			}
		}
	}

	@Override
	public void show() {
		System.out.println("\nHien thi toan bo thong tin cua tat ca tac gia:");
		for (Author author : authorArrList) {
			System.out.println(author.toString());
		}
		System.out.println("\n");
	}

	@Override
	public void menu() {
		int operation = 6;
		do {
			System.out.println("---------------- author Management ---------------------------");
			System.out.println("\t1: Them tac gia");
			System.out.println("\t2: Cap nhat thong tin tac gia");
			System.out.println("\t3: Xoa tac gia");
			System.out.println("\t4: Tim kiem tac gia");
			System.out.println("\t5: Hien thi tat ca tac gia");
			System.out.println("\t6: Tro lai");
			System.out.println("--------------------------------------------------------------");
			System.out.print("Which case do you choose?: ");
			operation = input.nextInt();
			switch (operation) {
			case 1:
				add();
				break;
			case 2:
				update();
				break;
			case 3:
				remove();
				break;
			case 4:
				search();
				break;
			case 5:
				show();
				break;
			case 6:
				System.out.println("\nDa tro lai menu quan li thu vien\n");
				break;
			default:
				System.out.println("Error!!!");
				break;
			}
		} while (operation != 6);
	}
}