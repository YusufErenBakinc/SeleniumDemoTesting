package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocatorsPage extends BasePage {

    private By addItemBtn = By.xpath("//button[@aria-label='Add Item']");
    private By taskReviewItem = By.xpath("//li[normalize-space()='Task 1: Review']");

    // Tablo içindeki spesifik hücreyi yakalama (XPath: Monitor satırının yanındaki Stock hücresi)
    private By monitorStock = By.xpath("//td[normalize-space()='0']");

    public LocatorsPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get("https://practice.expandtesting.com/locators");
    }

    public boolean isAddItemButtonDisplayed() {
        return find(addItemBtn).isDisplayed();
    }

    public String getTaskReviewText() {
        return getText(taskReviewItem);
    }

    public String getMonitorStockValue() {
        return getText(monitorStock);
    }
}