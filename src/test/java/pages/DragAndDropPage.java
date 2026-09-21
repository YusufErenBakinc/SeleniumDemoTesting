package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage extends BasePage {

    private By columnA = By.id("column-a");
    private By columnB = By.id("column-b");
    private By headerA = By.cssSelector("#column-a header");
    private By headerB = By.cssSelector("#column-b header");

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://practice.expandtesting.com/drag-and-drop");
    }

    public void dragAtoB() {
        WebElement source = find(columnA);
        WebElement target = find(columnB);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    public String getColumnAText() {
        return getText(headerA);
    }

    public String getColumnBText() {
        return getText(headerB);
    }
}