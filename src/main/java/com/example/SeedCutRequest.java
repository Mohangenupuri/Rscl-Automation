package com.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.Scanner;

public class SeedCutRequest {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create();
             Scanner scanner = new Scanner(System.in)) {

            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
            );

            Page page = browser.newPage();

            page.navigate("https://cmserpdev.rscl.in/login-page");

            System.out.println("Page title: " + page.title());

            Locator username = page.locator("//input[@name='USERNAME']");
            Locator password = page.locator("//input[@name='PASSWORD']");
            Locator loginButton = page.locator("//button[@type='submit']");

            System.out.println("Username count: " + username.count());
            System.out.println("Password count: " + password.count());
            System.out.println("Login button count: " + loginButton.count());

            username.fill("ccssem");
            System.out.println("Username entered successfully");

            password.fill("Test@123");
            System.out.println("Password entered successfully");

            loginButton.click();
            System.out.println("Login button clicked");

            page.locator("//*[@id='auth-form']/div[2]/button").click(); 
            System.out.println("Authenticate button clicked successfully");

            page.locator("//a[normalize-space()='Cane FI']").first().click();

            page.locator("//a[normalize-space()='Seed']").click();

            page.locator("//a[normalize-space()='Seed Cut Request']").click();
            System.out.println("Seed Cut Request clicked successfully");

            page.locator("//button[@aria-label='Choose date']//*[name()='svg']").click();
            System.out.println("Calendar icon clicked successfully");

            page.locator("//button[normalize-space()='4']").click();
            System.out.println("Date Selected successfully");

            page.locator("//div[@id='plotNo_property']//div[contains(@class,'space-lookup')]//div[2]//*[name()='svg']").click(); 
            System.out.println("Plot No lookup icon clicked");

            page.locator("//button[normalize-space()='Find']").click();
            System.out.println("Find button clicked successfully");

            page.locator("//tbody/tr[1]/td[1]").click();
            System.out.println("First row, first column clicked");

            page.locator("//input[@id='revisedEstimatedQuantity']").fill("30");
            System.out.println("Revised Estimated Quantity Filled");

            page.locator("//div[@id='seedType_property']//div[contains(@class,'space-lookup')]//div[2]//*[name()='svg']").click();
            System.out.println("Seed Type lookup icon clicked");

            page.locator("//button[normalize-space()='Find']").click();
            System.out.println("Seed Type Find button clicked");

            page.locator("//td[contains(@data-name,'SEED_CODE-SBS')]").click();
            System.out.println("Seed Code selected successfully");

            page.locator("//select[@id='fitOrUnfit']")
            .selectOption(new SelectOption().setLabel("Yes"));

            System.out.println("Fit or Unfit selected: Yes");

            page.locator("//input[@id='purity']").fill("80");
            System.out.println("Purity entered: 80");

            page.locator("//select[@id='caneGirth']").selectOption(
            new SelectOption().setLabel("Thick"));

            page.locator("//input[@id='thinCane']").fill("70");
            System.out.println("Thin Cane entered: 70");

            page.locator("//select[@id='pestOrDisease']")
            .selectOption(new SelectOption().setLabel("No"));
            
            System.out.println("Pest or Disease selected: No");

            page.locator("//button[@type='submit']").click();
            System.out.println("Submit button clicked successfully");

            System.out.println("Press Enter to close browser.");

            scanner.nextLine();

            browser.close();
        }
    }
} 