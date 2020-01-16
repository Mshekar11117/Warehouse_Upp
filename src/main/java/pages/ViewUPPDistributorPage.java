package pages;

import org.testng.Assert;
import POM.HomepagePOM;
import POM.ViewUppDistributorPOM;
import POM.uppDistributorTablePOM;
import base.SuperTestNG;

public class ViewUPPDistributorPage extends SuperTestNG {
	
	public void AccessUppViewPage() {
		HomepagePOM h = new HomepagePOM(driver);
		uppDistributorTablePOM u = new uppDistributorTablePOM(driver);
		ViewUppDistributorPOM v = new ViewUppDistributorPOM(driver);
		
		h.UppDistributor().click();
		u.firstviewbutton().click();
		String heading = v.uppdistributorTitle().getText();
		Assert.assertEquals(prop.getProperty("viewpagetitle"), heading);
	}
	
	public void verifyViewtitles() {
		ViewUppDistributorPOM v = new ViewUppDistributorPOM(driver);
		
		String Distributorname = v.titleUppDistName().getText();
		Assert.assertEquals(prop.getProperty("createuppDistributorName"), Distributorname);
		
		String uppno = v.titleUppDistNo().getText();
		Assert.assertEquals(prop.getProperty("createUPPNo"), uppno);
		
		String Adate = v.titleUppDistADate().getText();
		Assert.assertEquals(prop.getProperty("createADate"), Adate);
		
		String uppname = v.titleUppDistUppName().getText();
		Assert.assertEquals(prop.getProperty("createuppname"), uppname);
		
		String distid = v.titleUppDistID().getText();
		Assert.assertEquals(prop.getProperty("createdistid"), distid);
		
		String place = v.titleDistPlace().getText();
		Assert.assertEquals(prop.getProperty("createplace"), place);
		
		String state = v.titleDistState().getText();
		Assert.assertEquals(prop.getProperty("createState"), state);
		
		String Status = v.titleDistStatus().getText();
		Assert.assertEquals(prop.getProperty("createStatus"), Status);
		
		String phone = v.titleDistPhone().getText();
		Assert.assertEquals(prop.getProperty("createContactNo"), phone);
		
		String email = v.titleDistEmail().getText();
		Assert.assertEquals(prop.getProperty("createEmailid"), email);
		
		String Createdby = v.titleCreatedBy().getText();
		Assert.assertEquals(prop.getProperty("createdBY"), Createdby);
		
		String Modifiedby = v.titleModifiedBy().getText();
		Assert.assertEquals(prop.getProperty("modifiedBY"), Modifiedby);

	}
	
	public void VerifyTheValues() {
		ViewUppDistributorPOM v = new ViewUppDistributorPOM(driver);
		uppDistributorTablePOM u = new uppDistributorTablePOM(driver);
		HomepagePOM H = new HomepagePOM(driver);
		
		String distname = v.uppDistributornamefield().getAttribute("placeholder");
		String Uppno = v.uppdistributornumberfield().getAttribute("placeholder");
		String ADate = v.uppdistributorAdatefield().getAttribute("placeholder");
		String UppName = v.uppDistUppNamefield().getAttribute("placeholder");
		String DistId = v.uppdistributoridfield().getAttribute("placeholder");
		String place = v.uppdistributorplacefield().getAttribute("placeholder");
		String State = v.uppdistributorstatefield().getAttribute("placeholder");
		String Status = v.uppDistStatusfield().getAttribute("placeholder");
		String Contactno = v.uppdistributorPhonefield().getAttribute("placeholder");
		String email = v.uppdistributorEmailfield().getAttribute("placeholder");
		String Createdby = v.uppDistCreatedByfield().getAttribute("placeholder");
		String modifiedby = v.uppDistModifiedByfield().getAttribute("placeholder");
		
		v.backButton().click();
		
		String tabledistname = u.tableDistNamefirstrow().getText();
		String tableuppno = u.tableUPPNofirstrow().getText();
		String tableAdate = u.tableADatefirstrow().getText();
		String tableuppname = u.tableUPPNamefirstrow().getText();
		String tableDistId = u.tableDistIDfirstrow().getText();
		String tableplace = u.tableplacefirstrow().getText();
		String tablestate = u.tableStatefirstrow().getText();
		String tablestatus = u.tableStatusfirstrow().getText();
		String tablecontact = u.tableContactNofirstrow().getText();
		String user = H.userprofilename().getText();
		String profile = H.profilename().getText();

		Assert.assertEquals(distname, tabledistname);
		Assert.assertEquals(Uppno, tableuppno);
		Assert.assertEquals(ADate, tableAdate);
		Assert.assertEquals(UppName, tableuppname);
		Assert.assertEquals(DistId, tableDistId);
		Assert.assertEquals(place, tableplace);
		Assert.assertEquals(State, tablestate);
		Assert.assertEquals(Status, tablestatus);
		Assert.assertEquals(Contactno, tablecontact);
		Assert.assertEquals(Createdby, user);
		Assert.assertEquals(user, profile);
		Assert.assertTrue(modifiedby.isEmpty(), "Created flow we find Modified value which is incorrect");
		Assert.assertFalse(email.isEmpty(), "Email field value is missing");
	}
	
	
	public void VerifyTheValuesAfterUpdate() {
		ViewUppDistributorPOM v = new ViewUppDistributorPOM(driver);
		uppDistributorTablePOM u = new uppDistributorTablePOM(driver);
		HomepagePOM H = new HomepagePOM(driver);
		
		String distname = v.uppDistributornamefield().getAttribute("placeholder");
		String Uppno = v.uppdistributornumberfield().getAttribute("placeholder");
		String ADate = v.uppdistributorAdatefield().getAttribute("placeholder");
		String UppName = v.uppDistUppNamefield().getAttribute("placeholder");
		String DistId = v.uppdistributoridfield().getAttribute("placeholder");
		String place = v.uppdistributorplacefield().getAttribute("placeholder");
		String State = v.uppdistributorstatefield().getAttribute("placeholder");
		String Status = v.uppDistStatusfield().getAttribute("placeholder");
		String Contactno = v.uppdistributorPhonefield().getAttribute("placeholder");
		String email = v.uppdistributorEmailfield().getAttribute("placeholder");
		String Createdby = v.uppDistCreatedByfield().getAttribute("placeholder");
		String modifiedby = v.uppDistModifiedByfield().getAttribute("placeholder");
		
		v.backButton().click();
		
		String tabledistname = u.tableDistNamefirstrow().getText();
		String tableuppno = u.tableUPPNofirstrow().getText();
		String tableAdate = u.tableADatefirstrow().getText();
		String tableuppname = u.tableUPPNamefirstrow().getText();
		String tableDistId = u.tableDistIDfirstrow().getText();
		String tableplace = u.tableplacefirstrow().getText();
		String tablestate = u.tableStatefirstrow().getText();
		String tablestatus = u.tableStatusfirstrow().getText();
		String tablecontact = u.tableContactNofirstrow().getText();
		String user = H.userprofilename().getText();
		String profile = H.profilename().getText();

		Assert.assertEquals(distname, tabledistname);
		Assert.assertEquals(Uppno, tableuppno);
		Assert.assertEquals(ADate, tableAdate);
		Assert.assertEquals(UppName, tableuppname);
		Assert.assertEquals(DistId, tableDistId);
		Assert.assertEquals(place, tableplace);
		Assert.assertEquals(State, tablestate);
		Assert.assertEquals(Status, tablestatus);
		Assert.assertEquals(Contactno, tablecontact);
		Assert.assertEquals(Createdby, user);
		Assert.assertEquals(user, profile);
		Assert.assertFalse(modifiedby.isEmpty(), "Updated user name is not stored in Modified field in update flow");
		Assert.assertFalse(email.isEmpty(), "Email field value is missing in updated flow");
		
		
	}

}
