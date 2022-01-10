import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Libary {

	private static ArrayList<Reader> readerArrList = new ArrayList<Reader>();
	private static ReaderManage readerMng = new ReaderManage(readerArrList);

	private static ArrayList<Author> authorArrList = new ArrayList<Author>();
	private static AuthorManage authorMng = new AuthorManage(authorArrList);

	private static ArrayList<Book> bookArrList = new ArrayList<Book>();
	private static BookManage bookMng = new BookManage(bookArrList, authorArrList);

	private static ArrayList<RentalVoucher> rentalVoucherArrList = new ArrayList<RentalVoucher>();
	private static RTVoucherManage RTVoucherMng = new RTVoucherManage(bookArrList, readerArrList, rentalVoucherArrList);

	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);

		fileIn(readerArrList, authorArrList, bookArrList, rentalVoucherArrList);

		String operation;
		do {
			System.out.println("---------------- Libary Management ---------------------------");
			System.out.println("\t1: Thao tac voi doc gia");
			System.out.println("\t2: Thao tac voi tac gia");
			System.out.println("\t3: Thao tac voi sach");
			System.out.println("\t4: Thao tac voi phieu muon");
			System.out.println("\t5: Thoat va luu tat ca thay doi");
			System.out.println("--------------------------------------------------------------");
			System.out.print("Which case do you choose?: ");
			operation = input.nextLine();
			switch (operation) {
			case "1":
				readerMng.menu();
				break;
			case "2":
				authorMng.menu();
				break;
			case "3":
				bookMng.menu();
				break;
			case "4":
				RTVoucherMng.menu();
				break;
			case "5":
				fileOut(readerArrList, authorArrList, bookArrList, rentalVoucherArrList);
				System.out.println("bye");
				break;
			default:
				System.out.println("Error!!!");
				break;
			}
		} while (!operation.equals("5"));
	}

	public static void fileOut(ArrayList<Reader> readerArrList, ArrayList<Author> authorArrList, ArrayList<Book> bookArrList, ArrayList<RentalVoucher> rentalVoucherArrList) throws Exception {
		// readerIO
		try {
			FileWriter fw = new FileWriter("readerData.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (Reader reader : readerArrList) {
				bw.write(reader.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
		}

		// author
		try {
			FileWriter fw = new FileWriter("authorData.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (Author author : authorArrList) {
				bw.write(author.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
		}

		// book
		try {
			FileWriter fw = new FileWriter("bookData.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (Book book : bookArrList) {
				bw.write(book.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
		}

		// RTV
		try {
			FileWriter fw = new FileWriter("RTVData.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (RentalVoucher rtv : rentalVoucherArrList) {
				bw.write(rtv.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
		}
	}

	public static void fileIn(ArrayList<Reader> readerArrList, ArrayList<Author> authorArrList, ArrayList<Book> bookArrList, ArrayList<RentalVoucher> rentalVoucherArrList) throws Exception {
		// readerIO
		try {
			FileReader fr = new FileReader("readerData.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String txt[] = line.split(";");
				String name = txt[1];
				int age = Integer.parseInt(txt[2]);
				String passport = txt[3];
				String pos = txt[4];
				int posInt = 0;
				if (pos.equals("sinh vien")) {
					posInt = 0;
				} else {
					posInt = 1;
				}
				readerArrList.add(new Reader(name, age, passport, posInt));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
		}

		// author
		try {
			FileReader fr = new FileReader("authorData.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String txt[] = line.split(";");
				String name = txt[1];
				int age = Integer.parseInt(txt[2]);
				String nickname = txt[3];
				int posInt = 0;
				authorArrList.add(new Author(name, nickname, age));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
		}

		// book
		try {
			FileReader fr = new FileReader("bookData.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String txt[] = line.split(";");
				String name = txt[1];
				int authorID = Integer.parseInt(txt[2]);
				int num = Integer.parseInt(txt[3]);
				int year = Integer.parseInt(txt[4]);
				String type = txt[5];
				for (Author author : authorArrList) {
					if (author.getAuthorID() == authorID) {
						bookArrList.add(new Book(name, type, author, num, year));
					}
				}
			}
			br.close();
			fr.close();
		} catch (Exception e) {
		}

		// RTVIO
		try {
			FileReader fr = new FileReader("RTVData.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String txt[] = line.split(";");
				int bookID = Integer.parseInt(txt[1]);
				int readerID = Integer.parseInt(txt[2]);
				String borrowed = txt[3];
				String returned = txt[4];
				String sPayDay = txt[5];

				RentalVoucher newVch = new RentalVoucher();

				for (Book book : bookArrList) {
					if (book.getBookID() == bookID) {
						newVch.setBook(book);
					}
				}
				for (Reader reader : readerArrList) {
					if (reader.getReaderID() == readerID) {
						newVch.setReader(reader);
					}
				}

				SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");

				Date borrowedDate = new Date();
				borrowedDate  = sdf.parse(borrowed);
				newVch.setBorrowedDate(borrowedDate);

				Date returnDate = new Date();
				returnDate  = sdf.parse(returned);
				newVch.setReturnDate(returnDate);

				if (!sPayDay.equals("null")) {
					Date payDay = new Date();
					payDay  = sdf.parse(sPayDay);
					newVch.setPayDay(payDay);
				}

				rentalVoucherArrList.add(newVch);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
		}
	}
}