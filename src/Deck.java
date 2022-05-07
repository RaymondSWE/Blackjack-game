import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Deck {
	/*
	 * A deck has a list of cards and an image for back cover of the card
	 */
	private final ArrayList<Card> mCards;
	private Image backCover;

	// a enumeration to initialize cards
	public enum cards {
		Spades, Diamonds, Clubs, Hearts;

		HashMap<String, Integer> ranks;
		// Each card has rank has a name(key) and value(score)

		cards() {
			ranks = new HashMap<>();
			ranks.put("2", 2); // example 2 as rank and 2 as value
			ranks.put("3", 3);
			ranks.put("4", 4);
			ranks.put("5", 5);
			ranks.put("6", 6);
			ranks.put("7", 7);
			ranks.put("8", 8);
			ranks.put("9", 9);
			ranks.put("10", 10);
			ranks.put("JACK", 10);
			ranks.put("QUEEN", 10);
			ranks.put("KING", 10);
			ranks.put("ACE", 11);
		}
	}
	/*
	 * A deck is initialized with new list of cards cards.values() returns the
	 * instances as list the instances are Spades, Diamonds, etc for each card we
	 * get its rank and value, and for each of these value we create a new card with
	 * suit, rank and value. The card images will also load up
	 */

	public Deck() {
		mCards = new ArrayList<>();
		for (cards card : cards.values())
			for (String rank : card.ranks.keySet())
				mCards.add(new Card(card.toString(), rank, card.ranks.get(rank)));
		loadImages();
	}

	/*
	 * For each card, we get its image path, load the image with size of 50px wide
	 * and 73px height Same for the back cover of the card
	 */

	public void loadImages() {
		try {
			for (Card card : mCards)
				card.setImage(ImageIO.read(new File(card.getFullImagePath())).getScaledInstance(50, 73,
						BufferedImage.SCALE_SMOOTH));
			backCover = ImageIO.read(new File("Images\\Cardimages\\BACK COVER.png")).getScaledInstance(50, 73,
					BufferedImage.SCALE_SMOOTH);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Self explanatory, shuffling deck
	public void shuffleDeck() {
		Collections.shuffle(mCards);
	}

	// Getting card at a specific index
	public Card getPlayerCards(int index) {
		return mCards.get(index = index % mCards.size());
	}

	// Gets the back cover of the card
	public Image getBackCover() {
		return backCover;
	}
}