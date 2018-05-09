package pofIMDB.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class IMDBTest extends IMDBBase{

	@Test
	@FileParameters("./data/dtIMDB.csv")
	public void test(String browser, String urlToOpen, String movieName, 
			String sequelName, String movieYear,
			String actor_and_Roles) {
		
		setUp(browser, urlToOpen);
		
		imdbFindPage = imdbHomePage.searchMovie(movieName);
		imdbFindPage.moreMatches();
		imdbTitlePage = imdbFindPage.locateAndOpen(sequelName, movieYear);
		imdbTitlePage.validateTitle(sequelName, movieYear);
		imdbCastPage = imdbTitlePage.openCast();
		imdbCastPage.validateTitle(sequelName, movieYear);
		imdbCastPage.validateActor_Role(actor_and_Roles);
	}
}