package cv64.jsp.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <code>IOProcessing</code> class
 *
 * <p>This class contains several reusable methods for I/O operations.
 */

public class IOProcessing {

	/**
	* Method closeInputFile, closes the input file.
	*
	* @param bufferedReader accepts the name of the input file to close.
	* @exception IOException if there are problems closing the input file.
	*/
	public void closeInputFile(BufferedReader bufferedReader) throws IOException {

		if (debug_)
			System.err.println(
			    "IOProcessing.closeInputFile()");

		try {
			if (bufferedReader != null) {
				bufferedReader.close();
				bufferedReader = null;
			}
		} catch (IOException ex) {
			System.err.println("IOProcessing.closeInputFile Exception");
			System.err.println("Error closing input file: " +
			    bufferedReader.toString());
			throw ex;
		}
	}

	/**
	* Method closeOutputFile, closes the output file.
	*
	* @param printWriter accepts the name of the output file to close.
	* @exception Exception if there are problems closing the output file.
	*/
	public void closeOutputFile(PrintWriter printWriter) throws Exception {

		if (debug_)
			System.err.println(
			    "IOProcessing.closeOutputFile()");

		try {
			if (printWriter != null) {
				printWriter.close();
				printWriter = null;
			}
		} catch (Exception ex) {
			System.err.println("IOProcessing.closeOutputFile Exception");
			System.err.println("Error closing output file: " +
			    printWriter.toString());
			throw ex;
		}
	}

	/**
	* Method openInputFile, opens the input file from system
	* property inFile.
	*
	* @param inputFile accepts a name of an input file.
	* @return returns an input file.
	* @exception FileNotFoundException if the input file cannot be found.
	*/
	public BufferedReader openInputFile(String inputFile)
		throws FileNotFoundException {

		if (debug_)
			System.err.println(
			    "IOProcessing.openInputFile()");

		BufferedReader bufferedReader;

		try {
			bufferedReader = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException ex) {
			System.err.println("IOProcessing.openInputFile Exception");
			System.err.println("File Not Found Exception: " + inputFile);
			throw ex;
		}

		return bufferedReader;
	}

	/**
	* Method openOutputFile, receives an output file name and opens
	* the a new file.
	*
	* @param outputFile accepts a name of an output file.
	* @return returns an output file.
	* @exception IOException if there are problems creating the output file.
	*/
	public PrintWriter openOutputFile(String outputFile) throws java.io.IOException {

		if (debug_)
			System.err.println(
			    "IOProcessing.closeOutputFile()");

		PrintWriter printWriter;

		try {
			printWriter = new PrintWriter(new BufferedWriter(
			new FileWriter(outputFile)));
		} catch (IOException ex) {
			System.err.println("IOProcessing.openOutputFile Exception");
			System.err.println("Output File Exception: " + outputFile);
			throw ex;
		}

		return printWriter;
	}

	/** Sets the debug flag */
	private static final boolean debug_ = false;
}
