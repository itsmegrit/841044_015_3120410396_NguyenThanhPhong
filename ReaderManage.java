import java.util.Scanner;
import java.util.ArrayList;

public class ReaderManage implements Manage {

	Scanner input = new Scanner(System.in);
	private ArrayList<Reader> readerArrList;
	public ReaderManage() {
		this.readerArrList = null;
	}

	public ReaderManage(ArrayList<Reader> readerArrList) {
		this.readerArrList = readerArrList;
	}

	@Override
	public void add() {
		try {
			System.out.println("Nhap so doc gia can them (int)");
			int quantity = input.nextInt();
			for (int i = 0; i < quantity; i++) {
				System.out.println("----------------------------------------------------------\nnhap thong tin doc gia thu " + (i + 1));
				Reader reader = new Reader();
				readerInput(reader);
				readerArrList.add(reader);
				System.out.println("thong tin doi tuong vua thao tac\n " + reader.toString());
			}
		} catch (Exception e) {
			System.out.println("Error: Wrong type!!!");
		}
	}

// reader input function
	private void readerInput(Reader reader) {

		Scanner scan = new Scanner(System.in);

		System.out.println("nhap ten (String):");
		String name = scan.nextLine();
		System.out.println("nhap ho chieu (String):");
		String passport = scan.nextLine();
		try {
			System.out.println("nhap tuoi (int):");
			int age = scan.nextInt();
			System.out.println("nhap loai (int) (0 la sinh vien; khac 0 la giang vien):");
			int readerType = scan.nextInt();
			reader.setReaderType(readerType);
			reader.setAge(age);
		} catch (Exception e) {
			System.out.println("Error: Wrong type!!!");
		}

		reader.setName(name);
		reader.setPassport(passport);
	}

	@Override
	public void update() {

		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Nhap ma doc gia can sua (int)");
			int findByID = scan.nextInt();
			for (Reader reader : readerArrList) {
				if (reader.getReaderID() == findByID) {
					readerInput(reader);
					System.out.println("thong tin doi tuong vua thao tac\n " + reader.toString());
					return;
				}
			}
			System.out.println("khong tim thay doc gia co ma la " + findByID);
		} catch (Exception e) {
			System.out.println("Error: Wrong type!!!");
		}
	}

	@Override
	public void remove() {
		Scanner scan = new Scanner(System.in);

		try {
			System.out.println("Nhap ma doc gia can xoa (int):");
			int findByID = scan.nextInt();
			for (Reader reader : readerArrList) {
				if (reader.getReaderID() == findByID) {
					readerArrList.remove(reader);
					System.out.println("da xoa doc gia co id la " + findByID);
					return;
				}
			}
			System.out.println("khong tim thay doc gia co ma la " + findByID);
		} catch (Exception e) {
			System.out.println("Error: Wrong type!!!");
		}
	}

	@Override
	public void search() {
		Scanner scan = new Scanner(System.in);

		System.out.println("nhap 1 de tim theo ten doc gia; khac 1 de tim theo ma doc gia (int):");
		String findBy = scan.nextLine();

		if (findBy.equals("1")) {
			try {
				System.out.println("nhap ten doc gia can tim (String (tim gan dung)):");
				String findByname = scan.nextLine();
				for (Reader reader : readerArrList) {
					if (reader.getName().contains(findByname)) {
						System.out.println("\nmaDocGia;ten;tuoi;hoChieu;chucVu:");
						System.out.println("tim thay: " + reader.toString());
					}
				}
			} catch (Exception e) {
				System.out.println("Error: Wrong type!!!");
			}
		} else {
			try {
				System.out.println("nhap ma doc gia can tim (int):");
				int findByID = scan.nextInt();
				System.out.println("\nmaDocGia;ten;tuoi;hoChieu;chucVu:");
				for (Reader reader : readerArrList) {
					if (reader.getReaderID() == findByID) {
						System.out.println("tim thay doc gia co thong tin la: " + reader.toString());
					}
				}
			} catch (Exception e) {
				System.out.println("Error: Wrong type!!!");
			}
		}
	}

	@Override
	public void show() {
		System.out.println("\nHien thi toan bo thong tin cua tat ca doc gia:");
		System.out.println("\nmaDocGia;ten;tuoi;hoChieu;chucVu:");
		for (Reader reader : readerArrList) {
			System.out.println(reader.toString());
		}
		System.out.println("\n");
	}

	@Override
	public void menu() {
		int operation = 6;
		do {
			System.out.println("---------------- Reader Management ---------------------------");
			System.out.println("\t1: Them doc gia");
			System.out.println("\t2: Cap nhat thong tin doc gia");
			System.out.println("\t3: Xoa doc gia");
			System.out.println("\t4: Tim kiem doc gia");
			System.out.println("\t5: Hien thi tat ca doc gia");
			System.out.println("\t6: Tro lai va luu thay doi");
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