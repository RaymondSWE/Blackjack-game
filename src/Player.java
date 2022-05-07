public class Player implements PlayerInterface {
	// Player has a name, score and his balance
	private final String mName;
	private int mScore;
	private int mBalance;

	// Initialize a player with his name and balance
	public Player(String Name, int Balance) {
		this.mName = Name;
		this.mBalance = Balance;
	}

	// Getters and setters
	@Override
	public String getName() {
		return mName;
	}

	@Override
	public int getScore() {
		return mScore;
	}

	@Override
	public void setScore(int score) {
		this.mScore = score;
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