package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/* CTRL + T *//*
((JavascriptExecutor) driver).executeScript("window.open(arguments[0]);", url);*/

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aronm\\Desktop\\Files\\UKF MGR 2\\Testing\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String day, time;

        String url = "http://127.0.0.1:8000/index/login";
        driver.get(url);

        try {
            Shortcuts shortcuts = new Shortcuts();
            ElementGetter elementGetter = new ElementGetter();

            shortcuts.login(driver);

            WebElement resetButton = driver.findElement(By.xpath("/html/body/nav/div/a"));
            resetButton.click();

            shortcuts.cutType(driver, false);

            day = shortcuts.openDay(driver, 2, 1);

            time = shortcuts.selectTAndSubmitTime(driver, 3, 1, day);

            driver.navigate().refresh();

            shortcuts.openDay(driver, 2, 1);

            WebElement timeButton = elementGetter.getTimeWebElement(driver, time);
            System.out.println(timeButton.isEnabled());

            Thread.sleep(500);

            shortcuts.closeModal(driver, day);

            elementGetter.getNavbarElements(driver, 1).click();

            shortcuts.deleteBooking(driver, 1);

            elementGetter.getNavbarElements(driver, 2).click();
            Thread.sleep(1_000);
            elementGetter.getNavbarElements(driver, 4).click();
            Thread.sleep(1_000);
            elementGetter.getNavbarElements(driver, 5).click();
            Thread.sleep(1_000);
            elementGetter.getNavbarElements(driver, 6).click();
            Thread.sleep(1_000);
            elementGetter.getNavbarElements(driver, 7).click();
            Thread.sleep(1_000);
            elementGetter.getNavbarElements(driver, 3).click();


            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.quit();

    }
}


