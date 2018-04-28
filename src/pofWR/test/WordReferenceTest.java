package pofWR.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class WordReferenceTest extends WordReferenceBase{

	@Test
	@FileParameters("./data/dtWordReference.csv")
	public void testNumber1(String browser, String urlToOpen,
			String searchTerm1, String numberOfElementToSearch1,
			String searchTerm2, String numberOfElementToSearch2){
		
		setUp(browser,urlToOpen);
		
		wrDefinitionPage = wrHomePage.search(searchTerm1);
		wrDefinitionPage.wrReverse();		
		wrDefinitionPage.searchList(Integer.parseInt(numberOfElementToSearch1));
		wrDefinitionPage.search(searchTerm2);
		wrDefinitionPage.wrReverse();
		wrDefinitionPage.searchList(Integer.parseInt(numberOfElementToSearch2));
	}

}