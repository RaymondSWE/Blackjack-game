import java.awt.Image;

public class Card {

    private final String suit;
    private final String rank;
    private final int cardValue;
    private final String imagePath ;
    private Image image;

    public Card(String rank, String suit, int value) {
        this.suit = suit;
        this.rank = rank;
        this.cardValue = value;
        imagePath = "Images\\Cardimages\\" + rank + "\\" + suit + ".png";
        image = null;
    }

    public void setImage(Image image){
        this.image = image;
    }

    public Image getImage(){
        return image;
    }

    public int getValue() {
        return cardValue;
    }

    public String getFullImagePath() {
        return imagePath;
    }

}
