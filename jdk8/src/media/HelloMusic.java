package media;

import org.jfugue.player.Player;

public class HelloMusic {
	public static void main(String[] args) {
		Player player = new Player();
		player.play("C D E F G A B");
	}
}
