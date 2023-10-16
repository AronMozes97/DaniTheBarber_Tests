package org.example;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Shortcuts {

    public void login(@NotNull WebDriver driver) {

        WebElement userNameInput = driver.findElement(
                By.xpath("/html/body/div/div/div[1]/form/input[2]")
        );
        userNameInput.sendKeys("aron.mozes97@gmail.com");

        WebElement passwordInput = driver.findElement(
                By.xpath("/html/body/div/div/div[1]/form/input[3]")
        );
        passwordInput.sendKeys("adminadmin");

        WebElement loginButton = driver.findElement(
                By.xpath("/html/body/div/div/div[1]/form/button")
        );
        loginButton.click();
    }

    public void cutType(@NotNull WebDriver driver, boolean _long) {

        WebElement cutTypeButton = driver.findElement(
                By.xpath("/html/body/div/div/form/div/button[" + (_long ? 2 : 1) + "]")
        );
        cutTypeButton.click();
    }

    public String openDay(@NotNull WebDriver driver, int buttonX, int buttonY) {

        String day = "/html/body/div/div/div[" + buttonY + "]/div[" + buttonX + "]";
        WebElement dayButton = driver.findElement(
                By.xpath(day)
        );
        dayButton.click();

        return day;
    }

    public String selectTAndSubmitTime(@NotNull WebDriver driver, int timeX, int timeY, String day) {

        String time = day + "/div/div/div/div[2]/div/div[" + timeY + "]/div[" + timeX + "]/div";

        WebElement timeButton = null;
        do {
            timeButton = driver.findElement(
                    By.xpath(time)
            );
        } while (!driver.findElement(By.xpath(time)).isDisplayed());

        timeButton.click();

        WebElement submitButton = driver.findElement(
                By.xpath(day + "/div/div/div/div[3]/form/button")
        );
        submitButton.click();

        return time;
    }

    public void deleteBooking(@NotNull WebDriver driver, int id){
        String xPatch = "/html/body/div/div/table/tbody/tr["+ id +"]/td[5]/button";

        driver.findElement(By.xpath(xPatch)).click();
    }

    public void closeModal(@NotNull WebDriver driver, String day){
        String xPath = day + "/div/div/div/div[1]/button";

        driver.findElement(By.xpath(xPath)).click();
    }
}
