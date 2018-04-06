package pofWR.test;

import org.junit.Test;

public class WordReferenceTest extends WordReferenceBase{

	@Test
	public void test() {
		
		setUp("http://www.wordreference.com/","chrome");
		
		wrHomePage.search();
		wrDefinitionPage.wrReverse();		
		wrDefinitionPage.searchList();
		wrDefinitionPage.searchList();
		wrDefinitionPage.wrReverse();
		wrDefinitionPage.searchList();
	}

}