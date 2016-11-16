package makeVoca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.junit.Test;

public class test {

	@Test
	public void test() throws IOException {

		String sentence = "insert";

		FetchMeanings meanings = new FetchMeanings();
		
		String mean = meanings.fetchMeanings(sentence).toString();
		System.out.println(mean);
		
		StringTokenizer st = new StringTokenizer(sentence);



	}
}