package runner.testngframwork;

import com.unitedcoder.magentoautomationtest.backend.catalogmodule.*;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import com.unitedcoder.magentoautomationtest.utility.TestNGResultListener;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNGResultListener.class)
public class CatalogModuleRunner extends TestBase {
    FunctionPage functionPage;
    static CatalogManagerLogInPage catalogManagerLogInPage;
    String configFile = "config-qa.properties";
    ManageCategoryPage manageCategoryPage;
    FilterProductsByCategoryPage filterProductsByCategoryPage;
    CatalogDashboardPage catalogDashboardPage;
    ManagerAttributesPage managerAttributesPage;
    NewProductAttributePage newProductAttributePage;
    ViewDefaultCategoryPage viewDefaultCategoryPage;

    @BeforeSuite
    public void setUp(){
        browserSetUp(readFromConfigProperties(configFile,"backend_url"));
        Log4j.startTestCase("Magento_Customer_Module_Automation_Test_Start");
        catalogManagerLogInPage = new CatalogManagerLogInPage(driver);
        functionPage=new FunctionPage(driver);
        manageCategoryPage =new ManageCategoryPage(driver);
        filterProductsByCategoryPage=new FilterProductsByCategoryPage(driver);
        catalogDashboardPage = new CatalogDashboardPage(driver);
        managerAttributesPage = new ManagerAttributesPage(driver);
        newProductAttributePage = new NewProductAttributePage(driver);
        viewDefaultCategoryPage=new ViewDefaultCategoryPage(driver);


    }
    @BeforeClass
    public void loginCustomerModule(){
        Assert.assertTrue(catalogManagerLogInPage.verifyLoginPageOpened());
        catalogManagerLogInPage.login();
    }

    @Test
    public void addRootCategory() {
        manageCategoryPage.addRootCategory();
        Assert.assertTrue(manageCategoryPage.verifySuccessMessage());

    }

    @Test
    public void filterProductsByCategory(){
        filterProductsByCategoryPage.openCategoryList();
        filterProductsByCategoryPage.viewLimit();
        filterProductsByCategoryPage.filterByCategoryName();
        Assert.assertTrue(filterProductsByCategoryPage.verify());
    }


    @Test()
    public void editRootCategory(){
        manageCategoryPage.editRootCategory();
        Assert.assertTrue(manageCategoryPage.verifyEditSuccessMessage());
    }

    @Test(description = "add subcategory")
    public void addSubcategoryTest() throws InterruptedException {
        catalogDashboardPage.clickOnManageCategories();
        Assert.assertTrue( manageCategoryPage.addSubcategory());
    }

    @Test(description = "edit subcategory",dependsOnMethods = "addSubcategoryTest")
    public void editSubCategoryTest(){
        catalogDashboardPage.clickOnManageCategories();
        Assert.assertTrue(manageCategoryPage.editSubCategory());
    }
    @Test(description = "delete subcategory test",dependsOnMethods = "editSubCategoryTest")
    public void deleteSubcategoryTest(){
        Assert.assertTrue(manageCategoryPage.deleteSubcategory());
    }

    //Kadirdan
    @Test
    public void addNewAttribute(){
        catalogDashboardPage.navigateToManageAttributesPage();
        managerAttributesPage.clickOnAddNewAttributeButton();
        newProductAttributePage.enterOrSelectValidValues();
        Assert.assertTrue(newProductAttributePage.verifyNewAttributeSuccessMessages());
        Assert.assertTrue(newProductAttributePage.verifyNewAttributeInTheTableList());
    }
    @Test
    public void viewDefaultCategory(){
        viewDefaultCategoryPage.viewDefaultCategory();
        Assert.assertTrue(viewDefaultCategoryPage.verifyManagerCanViewAllDefaultCategories());
    }


    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }

}




