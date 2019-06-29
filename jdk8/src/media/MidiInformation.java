package media;

import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;

import java.util.Scanner;

public class MidiInformation {

	// no argument Constructor
	public MidiInformation() {

		Pattern pattern = null;

		try {
			// scanner - gets input from the keyboard (System.in)
			Scanner scanner = new Scanner(System.in);
			System.out.print("Please tell me the name of your MiDi files, e.g:  c:\\\\test.mid ");
			String songName = scanner.nextLine();
			System.out.println(songName);

			// retrieves the pattern from the midi file
			pattern = MidiFileManager.loadPatternFromMidi(new File(songName));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}

		// prints out the pattern of the midi file
		System.out.println(pattern);
	}

	public static void main(String[] args) {
		new MidiInformation();
	}
}
