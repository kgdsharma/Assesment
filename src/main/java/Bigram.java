import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Bigram {

	private static final String FILE_PATH = "src/main/java/BigramInputFile.txt";
	private static final int nGram = 2;

	public static void main(String[] args) {

		Bigram bigram = new Bigram();
		bigram.displayBigram(bigram.readFileInput(), nGram);

	}

	public List<String> getProcessedList(String input, int ngramCount) {

		String[] someString = input.split(" ");

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < someString.length - 1; i++) {
			String temp = "";
			for (int j = i; j < i + ngramCount; j++) {
				if (j <= someString.length - 1)
					temp = temp + " " + someString[j];
			}
			list.add(temp.trim());			
		}
		return list;

	}

	public static class Result {
		String ngramString;
		int ngramCount;

		public Result(String ngramString, int ngramCount) {
			this.ngramCount = ngramCount;
			this.ngramString = ngramString;
		}

		public boolean equals(Object obj) {
			if (null == obj) {
				return false;
			}
			
			if(!(obj instanceof Result)){
				return false;
			}			

			Result rslt = (Result) obj;

			if (this.ngramString != null) {
				if(this.ngramString.equalsIgnoreCase(rslt.ngramString)){
				return true;
			}}
			
			return false;

		}

		public int hashCode() {
			int hash = 7;
			hash = 49 * hash;			
			return hash;
		}
	}

	public List<Result> getResultList(String s, int nGram) {

		List<String> processedList = getProcessedList(s, nGram);
		List<Result> resultList = new ArrayList<Result>();

		for (int i = 0; i < processedList.size(); i++) {
			int count = 0;
			for (int j = 0; j < processedList.size(); j++) {
				if (processedList.get(i).equalsIgnoreCase(processedList.get(j)))
					count++;				
			}
			Result rslt = new Result(processedList.get(i), count);
			if(!resultList.contains(rslt))
			resultList.add(rslt);
		}

		return resultList;				

	}

	public void displayBigram(String input, int nGramCount) {

		List<Result> rsltlst = getResultList(input, nGramCount);		

		rsltlst.forEach(result -> {
			System.out.println(result.ngramString + "  " + result.ngramCount);
		});

	}

	private String readFileInput() {

		String inputData = null;

		try {
			inputData = new String(Files.readAllBytes(Paths.get(FILE_PATH)));

		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			System.out.println("File is not available , Correct the Path");
			
		}

		return inputData;

	}

}