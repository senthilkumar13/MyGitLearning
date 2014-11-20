package DevOlympus;

import org.testng.annotations.Test;

import com.o2.olympus.dev.BaseUtility.BaseClass;
import com.o2.olympus.dev.ObjHelper.ButtonHelper;
import com.o2.olympus.dev.ObjHelper.LinkHelper;
import com.o2.olympus.dev.ObjHelper.TextBoxHelper;

public class PsearchLogin extends BaseClass
{
	@Test
	public static void ProfileSearch() throws InterruptedException
	{
		Thread.sleep(2000);
		String Aprofile="Olympus JJProvisioning";
		TextBoxHelper.type("HeaderSearch", Aprofile);
		LinkHelper.Click("HeaderSearchBtn");
		LinkHelper.Click("AgentProfile");
		LinkHelper.Click("MPbtn");
		LinkHelper.Click("UserDetail");
		ButtonHelper.button("APloginbtn");
		
	}
	
}
