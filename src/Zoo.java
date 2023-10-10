import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoo {
	public static void main(String[] args) throws Exception {
		new App();
	}
}

class App {

	private final Scanner sc;
	private final List<String> animals;

	public App() {
		this.sc = new Scanner(System.in);
		this.animals = new ArrayList<>();
		this.run();
		this.sc.close();
	}

	private void run() {
		boolean run = true;
		String input;

		this.println("動物園");

		while (run) {
			this.println("1.家を作る・動物を入れる  2.状況確認  3.動物入れ替え  4.名前検索  5..終了");
			input = this.sc.nextLine();
			switch (input) {
			case "1":
				this.store();
				break;
			case "2":
				this.check();
				break;
			case "3":
				this.replace();
				break;
			case "4":
				this.search();
				break;
			case "5":
				run = false;
				break;
			default:
				this.println("1~5を入力してください");
				break;
			}
		}
		this.println("終了します");
	}

	private void store() {
		this.println("入れたい動物名前を入力");
		this.animals.add(this.sc.nextLine().trim().toLowerCase());
		this.println(this.animals.get(this.animals.size() - 1) + "が入りました");
	}

	private void check() {
		if (this.animals.isEmpty()) {
            this.println("動物がいません");
            return;
        } 
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < this.animals.size(); i++) {
			sb.append(i);
			sb.append("番目には");
			sb.append(this.animals.get(i));
			sb.append("が入っています");
			sb.append(i < this.animals.size() - 1 ? "\n" : "");
		}
		this.println(sb.toString());  
	}

	private void replace() {
		String[] input = new String[2];
		int from = 0, to = 0;
		String temp;

		this.check();
		this.println("入れたい番号を入力");
		input[0] = this.sc.nextLine();
		this.println("入れ替え対象の番号入力");
		input[1] = this.sc.nextLine();
		try {
			from = Integer.parseInt(input[0]);
			to = Integer.parseInt(input[1]);
		} catch (Exception e) {
			this.println("数字を入力してください");
			return;
		}
		if (this.animals.size() < 2) {
			this.println("入れ替える動物数が足りません");
			return;
		}
		if (from > this.animals.size() - 1 || to > this.animals.size() - 1) {
			this.println("0~" + (this.animals.size() - 1) + "まで入力してください");
			return;
		}
		temp = this.animals.get(from);
		this.animals.set(from, this.animals.get(to));
		this.animals.set(to, temp);
		this.println(from + "番目と" + to + "番目入れ替え完了");
	}

	private void search() {
		String input;

		this.println("検索したい名前を入力してください");
		input = this.sc.nextLine();
		if (this.animals.contains(input.trim().toLowerCase())) {
			this.println("その動物は動物園にあります");
		} else {
			this.println("その動物は動物園にありません");
		}
	}

	private void println(String s) {
		System.out.println(s);
	}
}
