import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class RTVoucherManage implements Manage {

	Scanner input = new Scanner(System.in);

	private ArrayList<Book> bookArrList;
	private ArrayList<Reader> readerArrList;
	private ArrayList<RentalVoucher> RTVArrList;

	public RTVoucherManage() {
		this.readerArrList = null;
		this.bookArrList = null;
		this.RTVArrList = null;
	}

	public RTVoucherManage(ArrayList<Book> bookArrList, ArrayList<Reader> readerArrList, ArrayList<RentalVoucher> RTVArrList) {
		this.readerArrList = readerArrList;
		this.bookArrList = bookArrList;
		this.RTVArrList = RTVArrList;
	}

	@Override
	public void add() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhap so phieu muon can them (int)");
		int quantity = input.nextInt();

		for (int i = 0; i < quantity; i++) {
			System.out.println("----------------------------------------------------------\nnhap thong tin phieu muon thu " + (i + 1));
			RentalVoucher voucher = new RentalVoucher();
			RTVInput(voucher);
			RTVArrList.add(voucher);
		}

	}

	Reader findReader(int readerID, ArrayList<Reader> readerArrList) {
		for (Reader reader : readerArrList) {
			if (readerID == reader.getReaderID()) {
				return reader;
			}
		}
		return null;
	}

	Book findBook(int id, ArrayList<Book> bookArrList) {
		for (Book book : bookArrList) {
			if (id == book.getBookID()) {
				return book;
			}
		}
		return null;
	}

	// book input function
	private void RTVInput(RentalVoucher voucher) {

		Scanner scan = new Scanner(System.in);

		String findBy = input.nextLine();

		System.out.println("nhap ma doc gia (int): ");
		int id = scan.nextInt();
		Reader rdr = findReader(id, readerArrList);
		if (rdr != null) {
			voucher.setReader(rdr);
		} else {
			do {
				System.out.println("khong tim thay doc gia co ma la" + id + "vui long nhap lai (int): ");
				id = scan.nextInt();
				rdr = findReader(id, readerArrList);
			} while (rdr == null);
			voucher.setReader(rdr);
		}

		System.out.println("nhap ma sach (int): ");
		int bID = scan.nextInt();
		Book bk = findBook(bID, bookArrList);
		if (bk != null) {
			voucher.setBook(bk);
		} else {
			do {
				System.out.println("khong tim thay sach co ma la" + id + "vui long nhap lai (int): ");
				bID = scan.nextInt();
				bk = findBook(bID, bookArrList);
			} while (bk == null);
			voucher.setBook(bk);
		}

		voucher.setBorrowedDate(new Date());

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("nhap ngay tra (dd/MM/yyyy)");
			String sDate = sc.nextLine();
			Date rDate = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
			voucher.setReturnDate(rDate);
		} catch (Exception e) {
		}
	}

	@Override
	public void update() {

		Scanner scan = new Scanner(System.in);

		System.out.println("update (0) hay tra sach/phieu (!=0)?");
		String options = scan.nextLine();
		if (options.equals("0")) {
			System.out.println("Nhap ma phieu can sua (int)");
			int findByID = scan.nextInt();
			for (RentalVoucher voucher : RTVArrList) {
				if (voucher.getRTVoucherID() == findByID) {
					RTVInput(voucher);
					System.out.println("done!");
					return;
				}
			}
			System.out.println("khong tim thay phieu co ma la " + findByID);
		} else {
			System.out.println("Nhap ma phieu can sua (int)");
			int findByID = scan.nextInt();
			for (RentalVoucher voucher : RTVArrList) {
				if (voucher.getRTVoucherID() == findByID) {
					voucher.setPayDay(new Date());
					System.out.println("tra sach thanh cong");
					return;
				}
			}
			System.out.println("khong tim thay phieu co ma la " + findByID);
			return;
		}
	}

	@Override
	public void remove() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Nhap ma phieu can xoa (int): ");
		int findByID = scan.nextInt();
		for (RentalVoucher voucher : RTVArrList) {
			if (voucher.getRTVoucherID() == findByID) {
				RTVInput(voucher);
				System.out.println("done!");
				return;
			}
		}
		System.out.println("khong tim thay phieu co ma la " + findByID);
	}

	@Override
	public void search() {
		Scanner scan = new Scanner(System.in);

		System.out.println("nhap 1 de tim theo ma phieu muon; khac 1 de tim theo ma nguoi muon: ");
		String findBy = scan.nextLine();

		if (findBy.equals("1")) {
			System.out.println("nhap ma phieu can tim tim (int): ");
			int findByRTVID = scan.nextInt();
			for (RentalVoucher voucher : RTVArrList) {
				if (voucher.getRTVoucherID() == findByRTVID) {
					System.out.println("\nmaPhieu; maSach; maDocGia; ngayMuon; ngayHenTra; ngayTra");
					System.out.println("tim thay " + voucher.toString());
				}
			}
		} else {
			System.out.println("nhap ma doc gia can tim (int): ");
			int findByID = scan.nextInt();
			for (RentalVoucher voucher : RTVArrList) {
				if (voucher.getReader().getReaderID() == findByID) {
					System.out.println("\nmaPhieu; maSach; maDocGia; ngayMuon; ngayHenTra; ngayTra");
					System.out.println("tim thay phieu co thong tin la" + voucher.toString());
					return;
				}
			}
			System.out.println("khong tim thay phieu co ma doc gia la " + findByID);
		}
	}

	@Override
	public void show() {
		System.out.println("\nHien thi toan bo thong tin cua tat ca phieu muon: ");
		System.out.println("\nmaPhieu; maSach; maDocGia; ngayMuon; ngayHenTra; ngayTra");
		for (RentalVoucher voucher : RTVArrList) {
			System.out.println(voucher.toString());
		}
		System.out.println("\n");
	}

	@Override
	public void menu() {
		int operation = 6;
		do {
			System.out.println("---------------- RentalVoucher Management -------------------------- -");
			System.out.println("\t1: Them phieu muon");
			System.out.println("\t2: Cap nhat thong tin phieu muon");
			System.out.println("\t3: Xoa phieu muon");
			System.out.println("\t4: Tim kiem phieu muon");
			System.out.println("\t5: Hien thi tat ca phieu muon");
			System.out.println("\t6: Tro lai");
			System.out.println("--------------------------------------------------------------");
			System.out.print("Which case do you choose? : ");
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