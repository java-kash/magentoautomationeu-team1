package runner.cucumberframwork.storemodulesteps;

import com.unitedcoder.magentoautomationtest.backend.storemodule.*;
import com.unitedcoder.magentoautomationtest.utility.ExcelReader;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StoreModuleSteps extends TestBase {

    //****************************   Habiba   *********************************
    StoreModuleLogin storeModuleLogin;

    final static String configFile = "config-qa.properties";
    final static String url = TestBase.readFromConfigProperties(configFile, "backend_url");

//******************************************************************************

    CreateNewOrderPage createNewOrderPage;
    EditOrderPage editOrderPage;
    CancelOrderPage cancelOrderPage;
    CategoriesAndNewRootCategoryFormPage formPage;
    FunctionPage functionPage;
    String title;

    @Before("@MagentoStoreModuleFeature")
    public void setUp() {
        browserSetUp(url);
        storeModuleLogin = new StoreModuleLogin(driver);
        storeModuleLogin.login();

    }

//    @Given("store manager is on the dashboard page")
//    public void storeManagerAlreadyLoggedIn() {
//
//
//    }


//*************   Nijat   ***************************

    //Create New Order Steps
    @When("a customer selected")
    public void aCustomerSelected() {
        createNewOrderPage.selectCustomer();
        createNewOrderPage.createOrder();
    }

    @Then("create a new order")
    public void createANewOrder() {
        createNewOrderPage.fillTheForm();
    }

    @And("verify create a new order")
    public void verifyCreateANewOrder() {
        Assert.assertTrue(createNewOrderPage.verify());
        System.out.println("create order");
    }

    @After("@MagentoStoreModuleFeature")
    public void tearDown() {
        driver.quit();
    }

    //Edit order steps
    @When("a customer select for edit")
    public void aCustomerSelectForEdit() {
        editOrderPage.findOrder();
    }

    @Then("edit a new order")
    public void editANewOrder() {
        editOrderPage.editOrder();
    }

    @And("verify  edit order")
    public void verifyEditOrder() {
        Assert.assertTrue(editOrderPage.verify());
        System.out.println("edit order");
    }


    //cancel order steps
    @When("select a customer")
    public void selectACustomer() {
        cancelOrderPage.findOrder();
    }

    @Then("cancel order")
    public void cancelOrder() {
        cancelOrderPage.cancelOrder();
    }

    @And("verify  cancel order")
    public void verifyCancelOrder() {
        cancelOrderPage.verify();
        System.out.println("cancel order");
    }
    //create store steps
    // *************************Esma*****************************

    ManageStoresPage manageStoresPage;
    ManageCurrencyRatesPage manageCurrencyRatesPage;
    private String storeName;
    private String websiteCode;

    @Given("store manager is on the dashboard page")
    public void storeManagerIsOnTheDashboardPage() {
        storeModuleLogin = new StoreModuleLogin(driver);
        manageStoresPage = new ManageStoresPage(driver);
        createNewOrderPage = new CreateNewOrderPage(driver);
        editOrderPage = new EditOrderPage(driver);
        cancelOrderPage = new CancelOrderPage(driver);
        formPage = new CategoriesAndNewRootCategoryFormPage(driver);
        functionPage = new FunctionPage(driver);
        manageCurrencyRatesPage = new ManageCurrencyRatesPage(driver);


    }

    @When("the user fills out a new store form {string}")
    public void theUserFillsOutANewStoreForm(String arg0) {
        manageStoresPage = new ManageStoresPage(driver);
        manageCurrencyRatesPage.clickManageStore();
        storeName = arg0;
        manageStoresPage.CreateStore(storeName);
    }

    @Then("a new store should be created")
    public void aNewStoreShouldBeCreated() {
        Assert.assertTrue(manageStoresPage.verifyCreateStore());
    }


    @When("the user edit the store")
    public void theUserEditTheStore() {
        manageStoresPage = new ManageStoresPage(driver);
        manageCurrencyRatesPage.clickManageStore();
        manageStoresPage.editStore();
    }

    @Then("store edit successfully")
    public void storeEditSuccessfully() {
        Assert.assertTrue(manageStoresPage.verifyEditStore());
    }

    //      createWebsite
    // *************************Zohra*****************************
    CreateWebsitePage createWebsitePage;
    EditWebsitePage editWebsitePage;


    @When("store manager should be able to create website")
    public void store_manager_should_be_able_to_create_website() {
        createWebsitePage = new CreateWebsitePage(driver);
        manageCurrencyRatesPage.clickManageStore();
        createWebsitePage.createWebsite();

    }

    @Then("a new website should be created")
    public void store_manager_should_be_able_to_see_the_website_has_been_saved_message() {
        Assert.assertTrue(createWebsitePage.verifyCreateWebsite());
    }

    //*****************************Kadirdan******************************

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = functionPage.getPageTitle();
        System.out.println("Page title is: " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @Then("user gets page tab section")
    public void userGetsTabSection(DataTable sectionsTable) {
        List<String> pageSections = sectionsTable.asList();
        System.out.println("Expected page tabs sections: " + pageSections);
        List<String> actualTabSectionList = functionPage.getElementsText(manageCurrencyRatesPage.tabSections);
        System.out.println("Actual page tabs sections: " + actualTabSectionList);
        Assert.assertTrue(pageSections.containsAll(actualTabSectionList));
    }

    @And("home page tab section count should be {int}")
    public void tabSectionCountShouldBe(int expectedSectionCount) {
        Assert.assertEquals(functionPage.getSectionCount(manageCurrencyRatesPage.tabSections), expectedSectionCount);
    }

    @When("user hovers to click the {string}")
    public void userHoversOverThe(String text) {
        functionPage.hoverToClick(text);
    }

    @Then("user gets Catalog tab section")
    public void userGetsCatalogTabSection(DataTable sectionsTable) {
        List<String> pageSections = sectionsTable.asList();
        System.out.println("Expected Catalog tabs sections: " + pageSections);
        List<String> actualTabSectionList = functionPage.getElementsText(manageCurrencyRatesPage.catalogTabSections);
        System.out.println("Actual Catalog tabs sections: " + actualTabSectionList);
        Assert.assertTrue(pageSections.containsAll(actualTabSectionList));
    }

    @And("Catalog tab's section count should be {int}")
    public void catalogTabSSectionCountShouldBe(int expectedSectionCount) {
        Assert.assertEquals(functionPage.getSectionCount(manageCurrencyRatesPage.catalogTabSections), expectedSectionCount);
    }

    @Then("user navigates to {string}")
    public void userNavigatesToPageAndShouldSeePageName(String expectedPageName) {
        System.out.println("Expected page name: " + expectedPageName);
        System.out.println("Actual page name: " + functionPage.getPageName(expectedPageName));
        Assert.assertEquals(expectedPageName, functionPage.getPageName(expectedPageName));
    }

    @And("user gets Category Information tabs")
    public void userGetsCategoryInformationTabs(DataTable sectionsTable) {
        functionPage.sleep(3);
        List<String> infoTabSections = sectionsTable.asList();
        System.out.println("Expected Category Information tabs sections: " + infoTabSections);
        List<String> actualInfoTabSectionList = functionPage.getElementsText(formPage.categoryInformationTabs);
        System.out.println("Actual Category Information tabs sections: " + actualInfoTabSectionList);
        Assert.assertTrue(infoTabSections.containsAll(actualInfoTabSectionList));
    }

    @And("Category Information tabs count should be {int}")
    public void categoryInformationTabsCountShouldBe(int expectedSectionCount) {
        Assert.assertEquals(functionPage.getSectionCount(formPage.categoryInformationTabs), expectedSectionCount);
    }

    @And("user sees General Information form")
    public void userSeesForm() {
        Assert.assertTrue(formPage.verifyGeneralInformationForm());
    }

    @When("user fills the form given sheet name {string} and row number {int}")
    public void userFillsTheFormGivenSheetNameAndRowNumberRowNumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData("Xml_Data/DataForMagento.xlsx", sheetName);
        String name = testData.get(rowNumber).get("Name");
        String Yes_No = testData.get(rowNumber).get("IsActive");
        String description = testData.get(rowNumber).get("Description");
        String pageTitle = testData.get(rowNumber).get("Page Title");
        String metaKeywords = testData.get(rowNumber).get("Meta Keywords");
        String metaDescription = testData.get(rowNumber).get("Meta Description");
        formPage.fillGeneralInformationForm(name + System.currentTimeMillis(), Yes_No, description, pageTitle, metaKeywords, metaDescription);
    }

    @When("user clicks on Save Category button")
    public void userClicksOnButton() {
        functionPage.sleep(3);
        formPage.clickSaveButton();
    }

    @Then("it shows a successful message {string}")
    public void itShowsASuccessfulMessage(String expectedSuccessMessage) {
        functionPage.sleep(4);
        String message = formPage.getSuccessMessage();
        System.out.println("This is success message: " + message);
        Assert.assertEquals(formPage.getSuccessMessage(), expectedSuccessMessage);
    }

    @And("user sees New Category folder in the left Categories Side Column")
    public void userSeesNewCategoryFolderInTheLeftCategoriesSideColumn() {
        Assert.assertTrue(formPage.verifyCreatedCategory());
    }

    @When("user clicks on new Category which created before for editing")
    public void userClicksOnNewCategoryWhichCreatedBeforeForEditing() {
        functionPage.sleep(3);
        formPage.clickOnCategoryFolder();
    }

    @And("user changes any field on the form")
    public void userChangesAnyFieldOnTheForm() {
        functionPage.sleep(3);
        formPage.selectNoInIncludeInNavigationMenu();
    }

    @And("user clicks on Delete Category button")
    public void userClicksOnDeleteCategoryButton() {
        functionPage.sleep(3);
        formPage.clickOnDeleteButton();
    }

    @And("user clicks on the OK button from an alert pop up")
    public void userClicksOnTheOKButtonFromAnAlertPopUp() {
        functionPage.sleep(3);
        functionPage.waitForAlertPresent();
        functionPage.alertAccept();
    }

    @When("the user edit the website")
    public void the_user_edit_the_website() {
        storeModuleLogin=new StoreModuleLogin(driver);
        manageCurrencyRatesPage=new ManageCurrencyRatesPage(driver);
//       manageStoresPage=new ManageStoresPage(driver);
        editWebsitePage=new EditWebsitePage(driver);
        manageCurrencyRatesPage.clickManageStore();
        editWebsitePage.editWebsite();
    }
    @Then("website edit successfully")
    public void website_edit_successfully() {
        Assert.assertTrue(editWebsitePage.verifyEditWebsite());
    }


}
