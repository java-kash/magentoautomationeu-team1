package runner.testngframwork;

import com.unitedcoder.magentoautomationtest.backend.catalogmodule.CatalogManagerLogInPage;
import com.unitedcoder.magentoautomationtest.backend.catalogmodule.FilterProductsByCategoryPage;
import com.unitedcoder.magentoautomationtest.backend.catalogmodule.ManageCategoryPage;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CatalogModuleRunner extends TestBase {
    FunctionPage functionPage;
    static CatalogManagerLogInPage catalogManagerLogInPage;
    String configFile = "config-qa.properties";
    ManageCategoryPage manageCategoryPage;
    FilterProductsByCategoryPage filterProductsByCategoryPage;

    @BeforeSuite
    public void setUp(){
        browserSetUp(readFromConfigProperties(configFile,"backend_url"));
        Log4j.startTestCase("Magento_Customer_Module_Automation_Test_Start");
        catalogManagerLogInPage = new CatalogManagerLogInPage(driver);
        functionPage=new FunctionPage(driver);
        manageCategoryPage =new ManageCategoryPage(driver);
        filterProductsByCategoryPage=new FilterProductsByCategoryPage(driver);

    }
    @BeforeClass
    public void loginCustomerModule(){
        Assert.assertTrue(catalogManagerLogInPage.verifyLoginPageOpened());
        catalogManagerLogInPage.login();
    }

    @Test
    public void addRootCategories() throws InterruptedException {
        manageCategoryPage.manageCategoriesLink();
        Assert.assertTrue(manageCategoryPage.verifySuccessMessage());

    }

    @Test
    public void filterProductsByCategory(){
        filterProductsByCategoryPage.openCategoryList();
        filterProductsByCategoryPage.viewLimit();
        filterProductsByCategoryPage.filterByCategoryName();
        Assert.assertTrue(filterProductsByCategoryPage.verify());
    }



    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }

}




