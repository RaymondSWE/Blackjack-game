public class Player implements PlayerInterface {
	private String mName;
	private int mScore;
	private int mBalance;

	public Player(String Name, int Balance) {
		this.mName = Name;
		this.mBalance = Balance;
	}

	@Override
	public String getName() {

		return mName;
	}

	@Override
	public void setName(String name) {
		this.mName = name;
	}

	@Override
	public int getScore() {
		return mScore;
	}

	@Override
	public void setScore(int score) {
		this.mScore += score;
	}

	@Override
	public int getBalance() {
		return mBalance;
	}

	@Override
	public void setBalance(int balance) {
		this.mBalance = balance;
	}

}