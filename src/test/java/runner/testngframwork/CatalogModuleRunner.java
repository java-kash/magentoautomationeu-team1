package runner.testngframwork;

import com.unitedcoder.magentoautomationtest.backend.catalogmodule.*;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import com.unitedcoder.magentoautomationtest.utility.TestNGResultListener;
import org.testng.Assert;
import org.testng.ITestContext;
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
    CatalogProductPage catalogProductPage;
    String subcatName=readFromConfigProperties(configFile,"subcategory_name");


    @BeforeSuite
    public void setUp(ITestContext context){
        browserSetUp(readFromConfigProperties(configFile,"backend_url"));
        Log4j.startTestCase("Magento_Customer_Module_Automation_Test_Start");
        context.setAttribute("driver",driver);
        catalogManagerLogInPage = new CatalogManagerLogInPage(driver);
        functionPage=new FunctionPage(driver);
        manageCategoryPage =new ManageCategoryPage(driver);
        filterProductsByCategoryPage=new FilterProductsByCategoryPage(driver);
        catalogDashboardPage = new CatalogDashboardPage(driver);
        managerAttributesPage = new ManagerAttributesPage(driver);
        newProductAttributePage = new NewProductAttributePage(driver);
        viewDefaultCategoryPage=new ViewDefaultCategoryPage(driver);
        catalogProductPage=new CatalogProductPage(driver);



    }
    @BeforeClass
    public void loginCustomerModule(){
        Assert.assertTrue(catalogManagerLogInPage.verifyLoginPageOpened());
        catalogManagerLogInPage.login();
    }
    @BeforeMethod
    public void backToDashboard(){
        catalogDashboardPage.backToDashboardPage();
        catalogDashboardPage.dashboardVerify();
    }

    @Test (description = "add Root Category",priority = 1)
    public void addRootCategory() {
        manageCategoryPage.addRootCategory();
        Assert.assertTrue(manageCategoryPage.verifySuccessMessage());

    }



    @Test (description = "edit Root Category",dependsOnMethods = "addRootCategory")
    public void editRootCategory(){
        manageCategoryPage.editRootCategory();
        Assert.assertTrue(manageCategoryPage.verifyEditSuccessMessage());
    }

    @Test (description = "delete Root Category")
    public void deleteRootCategory(){
        manageCategoryPage.deleteRootCategory();
        Assert.assertTrue(manageCategoryPage.verifyDeleteSuccessMsg());
    }

    @Test(description = "add subcategory")
    public void addSubcategoryTest() throws InterruptedException {
        catalogDashboardPage.clickOnManageCategories();
        Assert.assertTrue( manageCategoryPage.addSubcategory());
    }

    @Test(description = "edit subcategory")
    public void editSubCategoryTest(){
        catalogDashboardPage.clickOnManageCategories();
        Assert.assertTrue(manageCategoryPage.editSubCategory(subcatName));
    }
    @Test(description = "delete subcategory test")
    public void deleteSubcategoryTest(){
        catalogDashboardPage.clickOnManageCategories();
        Assert.assertTrue(manageCategoryPage.deleteSubcategory(subcatName));//please check you are code
    }

    @Test
    public void filterProductsByCategory(){
        filterProductsByCategoryPage.openCategoryList();
        filterProductsByCategoryPage.viewLimit();
        filterProductsByCategoryPage.filterByCategoryName();
        Assert.assertTrue(filterProductsByCategoryPage.verify());
    }

    //Kadirdan
    @Test
    public void addNewAttribute(){
        catalogDashboardPage.navigateToManageAttributesPage();
        managerAttributesPage.clickOnAddNewAttributeButton();
        newProductAttributePage.enterOrSelectValidValues();
        Assert.assertTrue(newProductAttributePage.verifyNewAttributeSuccessMessages());
    //    Assert.assertTrue(newProductAttributePage.verifyNewAttributeInTheTableList()); you all view then you can use
    }
    // with nijat together see
    @Test
    public void viewDefaultCategory(){
        viewDefaultCategoryPage.viewDefaultCategory();
        Assert.assertTrue(viewDefaultCategoryPage.verifyManagerCanViewAllDefaultCategories());
    }

    @Test
    public void addproductCatalog(){
        catalogProductPage.Addproduct();
        Assert.assertTrue(catalogProductPage.verifyAddproduct());

    }
    @Test(dependsOnMethods = "addproductCatalog")
    public void editproductPage(){
        catalogProductPage.editProduct();
        Assert.assertTrue(catalogProductPage.verifyEdit());
    }
    @Test(dependsOnMethods = "addproductCatalog")
    public void deleteProductPage(){
        catalogProductPage.deleteProduct();
        Assert.assertTrue(catalogProductPage.verifyDeleted());
    }

    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }

}




