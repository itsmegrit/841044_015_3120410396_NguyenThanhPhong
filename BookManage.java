import java.util.Scanner;
import java.util.ArrayList;

public class BookManage implements Manage {

	Scanner input = new Scanner(System.in);
	private ArrayList<Book> bookArrList;
	private ArrayList<Author> authorArrList;
	public BookManage() {
		this.bookArrList = null;
		this.authorArrList = null;
	}

	public BookManage(ArrayList<Book> bookArrList, ArrayList<Author> authorArrList) {
		this.authorArrList = authorArrList;
		this.bookArrList = bookArrList;
	}

	@Override
	public void add() {
		try {
			System.out.println("Nhap so sach can them (int)");
			int quantity = input.nextInt();

			for (int i = 0; i < quantity; i++) {
				System.out.println("----------------------------------------------------------\nnhap thong tin sach thu " + (i + 1));
				Book book = new Book();
				bookInput(book);
				bookArrList.add(book);
			}
		} catch (Exception e) {
			System.out.println("Error: Wrong type");
		}
	}

// book input function
	private void bookInput(Book book) {

		Scanner scan = new Scanner(System.in);

		System.out.println("nhap ten sach (String):");
		String name = scan.nextLine();
		System.out.println("nhap the loai (String):");
		String type = scan.nextLine();
		int num;
		try {
			do {
				System.out.println("nhap so trang (int):");
				num = scan.nextInt();
			} while (num < 0);
			int year;
			do {
				System.out.println("nhap nam xuat ban (int):");
				year = scan.nextInt();
			} while (year < 0);
			book.setNumberOfPages(num);
			book.setPublishYear(year);
		} catch (Exception e) {
			System.out.println("Error: Wrong type");
		}

		book.setBookName(name);
		book.setType(type);

		Scanner scanner = new Scanner(System.in);
		System.out.println("mo menu hien thi (0) hay nhap truc tiep ma tac gia(!=0)?:");
		String choice = scanner.nextLine();
		if (choice.equals("0")) {
			System.out.println("\nHien thi toan bo thong tin cua tat ca tac gia:");
			System.out.println("\nmaTG; tenTG; butDanh; tuoi");
			for (Author author : authorArrList) {
				System.out.println(author.toString());
			}
			System.out.println("\n");
			try {
				int authorID = 0;
				System.out.println("nhap ma sach tac gia can them (int):");
				authorID = scan.nextInt();
				for (Author author : authorArrList) {
					if (author.getAuthorID() == authorID) {
						book.setAuthor(author);
						return;
					}
				}
				System.out.println("khong tim thay tac co ma la " + authorID);
				return;
			} catch (Exception e) {
				System.out.println("Error: Wrong type");
			}
		} else {
			try {
				int authorID = 0;
				System.out.println("nhap ma tac gia (int):");
				authorID = scan.nextInt();
				for (Author author : authorArrList) {
					if (author.getAuthorID() == authorID) {
						book.setAuthor(author);
						return;
					}
				}
				System.out.println("khong tim thay tac co ma la " + authorID);
				return;
			} catch (Exception e) {
				System.out.println("Error: Wrong type");
			}
		}
	}

	@Override
	public void update() {

		Scanner scan = new Scanner(System.in);

		try {
			System.out.println("Nhap ma sach can sua (int)");
			int findByID = scan.nextInt();
			for (Book book : bookArrList) {
				if (book.getBookID() == findByID) {
					bookInput(book);
					System.out.println("done!");
					return;
				}
			}
			System.out.println("khong tim thay sach co ma la " + findByID);
		} catch (Exception e) {
			System.out.println("Error: Wrong type");
		}
	}

	@Override
	public void remove() {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Nhap ma sach can xoa (int):");
			int findByID = scan.nextInt();
			for (Book book : bookArrList) {
				if (book.getBookID() == findByID) {
					bookArrList.remove(book);
					return;
				}
			}
			System.out.println("khong tim thay sach co ma la " + findByID);
		} catch (Exception e) {
			System.out.println("Error: Wrong type");
		}
	}

	@Override
	public void search() {
		Scanner scan = new Scanner(System.in);

		System.out.println("nhap 1 de tim theo ten sach; khac 1 de tim theo ma sach (int):");
		String findBy = scan.nextLine();

		if (findBy.equals("1")) {
			System.out.println("nhap ten sach can tim (String (tim gan dung)):");
			String findByname = scan.nextLine();
			System.out.println("\nmaSach; tenSach; tacGia; soTrang; namXB; theLoai");
			for (Book book : bookArrList) {
				if (book.getBookName().contains(findByname)) {
					System.out.println("tim thay " + book.toString());
				}
			}
		} else {
			try {
				System.out.println("nhap ma sach can tim (int):");
				int findByID = scan.nextInt();
				System.out.println("\nmaSach; tenSach; tacGia; soTrang; namXB; theLoai");
				for (Book book : bookArrList) {
					if (book.getBookID() == findByID) {
						System.out.println("tim thay sach co thong tin la" + book.toString());
						return;
					}
				}
				System.out.println("khong tim thay sach co ma la " + findByID);
			} catch (Exception e) {
				System.out.println("Error: Wrong type");
			}
		}
	}

	@Override
	public void show() {
		System.out.println("\nHien thi toan bo thong tin cua tat ca sach:");
		System.out.println("\nmaSach; tenSach; tacGia; soTrang; namXB; theLoai");
		for (Book book : bookArrList) {
			System.out.println(book.toString());
		}
		System.out.println("\n");
	}

	@Override
	public void menu() {
		int operation = 6;
		do {
			System.out.println("---------------- Book Management ---------------------------");
			System.out.println("\t1: Them sach");
			System.out.println("\t2: Cap nhat thong tin sach");
			System.out.println("\t3: Xoa sach");
			System.out.println("\t4: Tim kiem sach");
			System.out.println("\t5: Hien thi tat ca sach");
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