package fundamentals.ascii;

public class Ascii {

    private int decimal = 0;
    private String hex = "";
    private String binary = "";
    private String character = "";
    private String description = "";

    public Ascii(int decimal, String hex, String binary, String character, String description) {
        this.decimal = decimal;
        this.hex = hex;
        this.binary = binary;
        this.character = character;
        this.description = description;
    }

    public Ascii() {
        this(0, "", "", "", "");
    }

    public int getDecimal() {
        return decimal;
    }

    public String getHex() {
        return hex;
    }

    public String getBinary() {
        return binary;
    }

    public String getCharacter() {
        return character;
    }

    public String getDescription() {
        return description;
    }
}
