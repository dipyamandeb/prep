package study.browserStackLogRead;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution implements Runnable {
	private boolean debug = false;

	private int brsRunEveryNSeconds = 2000;
	private long lastKnownPosition = 0;
	private boolean shouldIRun = true;
	private File brsFile = null;
	private static int brsCounter = 0;

	public Solution(String myFile, int myInterval) {
		brsFile = new File(myFile);
		this.brsRunEveryNSeconds = myInterval;
	}

	private void printLine(String message) {
		System.out.println(message);
	}

	public void stopRunning() {
		shouldIRun = false;
	}

	public void run() {
		try {
			while (shouldIRun) {
				Thread.sleep(brsRunEveryNSeconds);
				long fileLength = brsFile.length();
				if (fileLength > lastKnownPosition) {

					// Reading and writing file
					RandomAccessFile readWriteFileAccess = new RandomAccessFile(brsFile, "r");
					readWriteFileAccess.seek(lastKnownPosition);
					String brsLine = null;
					while ((brsLine = readWriteFileAccess.readLine()) != null) {
//						System.out.println(readWriteFileAccess.length());
						this.printLine(brsLine);
						brsCounter++;
					}
					lastKnownPosition = readWriteFileAccess.getFilePointer();
					readWriteFileAccess.close();
				} else {
					if (debug)
						this.printLine("Couldn't found new line after line # " + brsCounter);
				}
			}
		} catch (Exception e) {
			stopRunning();
		}
		if (debug)
			this.printLine("Exit the program...");
	}

	public static void main(String argv[]) {

		ExecutorService brsExecutor = Executors.newFixedThreadPool(4);
		String filePath = "/Users/dipyaman.deb/Practise/prep/prep/src/main/java/com/intrw/browserStackLogRead/brs.log";
		Solution brs_tailF = new Solution(filePath, 2000);

		// Start running log file tailer on crunchify.log file
		brsExecutor.execute(brs_tailF);

		// Start pumping data to file crunchify.log file
		appendData(filePath, true, 5000);

	}

	private static void appendData(String filePath, boolean shouldIRun, int brsRunEveryNSeconds) {
		FileWriter fileWritter;

		try {
			int i = 0;
			while (shouldIRun) {
				Thread.sleep(brsRunEveryNSeconds);
				fileWritter = new FileWriter(filePath, true);
				BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
				i++;
				String data = "\n brs.log file content: " + i;
				bufferWritter.write(data);
				bufferWritter.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
