public class Card {

	private String mSuit;
	private String mRank;
	private int mValue;
	private String mImagePath = "../Cardimages/";

	public Card(String rank, String suit, int value) {
		this.mSuit = suit;
		this.mRank = rank;
		this.mValue = value;
		setFullImagePath();
	}

	// this function returns a string and expects no input.
	public String getSuit() {
		return mSuit;
	}

	// this function returns a string and expects no input
	public String getRank() {
		return mRank;
	}

	// this function returns an int and expects no input
	public int getValue() {
		return mValue;
	}
	
	public String getFullImagePath() {
		return mImagePath;
		
	}

	// this function sets the complete path to the image of the card based on suit.
	// it takes no input.
	private void setFullImagePath()
     {
		mImagePath+=mSuit+"/"+mRank+".png";
     }

}
