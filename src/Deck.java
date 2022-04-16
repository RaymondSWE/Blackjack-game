import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Deck {
	private final ArrayList<Card> mCards;
	private Image backCover;

	public enum cards {
		Spades, Diamonds, Clubs, Hearts;

		HashMap<String, Integer> ranks;

		cards() {
			ranks = new HashMap<>();
			ranks.put("2", 2);
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

	public Deck() {
		mCards = new ArrayList<>();
		for (cards card : cards.values())
			for (String rank : card.ranks.keySet())
				mCards.add(new Card(card.toString(), rank, card.ranks.get(rank)));
		loadImages();
	}

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

	public void shuffleDeck() {
		Collections.shuffle(mCards);
	}

	public Card getPlayerCards(int index) {
		return mCards.get(index = index % mCards.size());
	}

	public Image getBackCover() {
		return backCover;
	}
}