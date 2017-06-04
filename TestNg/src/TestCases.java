import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;


public class TestCases {

	
	
	/*@Test
	 * @Beforetest
	 * @Aftertest
	 * @Beforesuite
	 * @Aftersuite
	 @Beforemethod
	 @Aftermethod
	 @dataprovider
	 @parametrized
	 * 
	 */
	//Annotations
	@Test
	public void testLogin()
	{
		
		//throw new SkipException("Skipping this test case");
		System.out.println("Login to the application");
	}
	
	
	@Test
	public void testadduser()
	{
		
		//throw new SkipException("Skipping this test case");
		System.out.println("adding the user");
	}
	
	@Test
	public void testremoveuser()
	{
		
		//throw new SkipException("Skipping this test case");
		//System.out.println("adding the user");
		Assert.assertEquals(10, 11);
	}
	
	@Test
	public void testLogout()
	{
		
		//throw new SkipException("Skipping this test case");
		System.out.println("Logging out");
	}
}
