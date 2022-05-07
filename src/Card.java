import java.awt.Image;

public class Card {

	/*
	 * A card has a rank, a suit, a value or score and an image
	 */
	private final String suit;
	private final String rank;
	private final int cardValue;
	private final String imagePath;
	private Image image;

	/*
	 * Initialize a card with its rank, suit, value and image path
	 */

	public Card(String rank, String suit, int value) {
		this.suit = suit;
		this.rank = rank;
		this.cardValue = value;
		imagePath = "Images\\Cardimages\\" + rank + "\\" + suit + ".png";
	}

	// Set custom image

	public void setImage(Image image) {
		this.image = image;
	}

	// Get card image
	public Image getImage() {
		return image;
	}

	// Get the score of the card

	public int getValue() {
		return cardValue;
	}
	// Get image path for current card

	public String getFullImagePath() {
		return imagePath;
	}

}
