package pofIMDB.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class IMDBTest extends IMDBBase{

	@Test
	@FileParameters("./data/dtIMDB.csv")
	public void test(String browser, String urlToOpen, String movieName, String moreMatchesLink,
			String sequelName, String movieYear, String fullCastLink,
			String roleActor_1, String roleName_1,
			String roleActor_2, String roleName_2,
			String roleActor_3, String roleName_3) {
		
		setUp(browser, urlToOpen);
		
		imdbFindPage = imdbHomePage.searchMovie(movieName);
		imdbFindPage.moreMatches();
		imdbTitlePage = imdbFindPage.locateAndOpen();
		imdbTitlePage.validateTitle();
		imdbCastPage = imdbTitlePage.openCast();
		imdbCastPage.validateTitle();
		imdbCastPage.validateActor_Role();
	}
}