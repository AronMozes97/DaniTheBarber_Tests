package org.example;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementGetter {

    public WebElement getTimeWebElement(@NotNull WebDriver driver, String time){

        WebElement timeButton = null;
        do {
            timeButton = driver.findElement(
                    By.xpath(time)
            );
        } while (!driver.findElement(By.xpath(time)).isDisplayed());

        return timeButton;
    }

    public WebElement getNavbarElements(@NotNull WebDriver driver, int id){
        String xPath = "/html/body/nav/div/div/ul/li[" + id + "]/a";
        return driver.findElement(By.xpath(xPath));
    }

    public WebElement getBody(@NotNull WebDriver driver){
        return driver.findElement(By.xpath("/html/body"));
    }

}
