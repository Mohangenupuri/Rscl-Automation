package com.example;

import java.util.Scanner;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class SeedIssue {
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

            username.fill("acmo1");
            System.out.println("Username entered successfully");

            password.fill("Test@123");
            System.out.println("Password entered successfully");

            loginButton.click();
            System.out.println("Login button clicked");

            page.locator("//*[@id='auth-form']/div[2]/button").click(); 
            System.out.println("Authenticate button clicked successfully");

            page.locator("//a[normalize-space()='Cane FI']").first().click();

            page.locator("//a[normalize-space()='Seed']").click();

            page.locator("//a[normalize-space()='Seed Issue']").click();
            System.out.println("Seed Issue clicked successfully");

            page.locator("//div[@id='supplierPlotNo_property']//div[@class='space-lookup']//div[2]//*[name()='svg']").click();
            System.out.println("Supplier Plot No lookup icon clicked");

            page.locator("//button[normalize-space()='Find']").click();
            System.out.println("Supplier Plot Find button clicked");

            page.locator("//tbody/tr[1]/td[1]").click();
            System.out.println("Supplier Plot selected successfully");

            page.locator("//select[@id='harvester']")
            .selectOption(new SelectOption().setLabel("Self"));
            System.out.println("Harvester selected: Self");

            //Receiver Details

            page.locator("//button[@aria-label='Choose date']//*[name()='svg']").click();
            System.out.println("Calendar icon clicked successfully");

            page.locator("//button[normalize-space()='5']").click();
            System.out.println("Date 5 selected successfully");

            page.locator("//div[@id='receiverPlotNo_receiverInformation1_property']//div[contains(@class,'space-lookup')]//div[2]//*[name()='svg']").click();
            System.out.println("Receiver Plot No lookup icon clicked");

            page.locator("//button[normalize-space()='Find']").click();
            System.out.println("Receiver Plot Find button clicked successfully");

            page.locator("//tbody/tr[1]/td[1]").click();
            System.out.println("Receiver Plot selected successfully");

            page.locator("//div[@id='productId_receiverInformation1_property']//div[contains(@class,'space-lookup')]//div[2]//*[name()='svg']").click();
            System.out.println("Product ID lookup icon clicked successfully");

            page.locator("//span[normalize-space()='SEED_CODE-CBS']").click();
            System.out.println("SEED_CODE-CBS selected successfully");

            page.locator("//select[@id='seedIssueType_receiverInformation1']")
            .selectOption(new SelectOption().setLabel("Own Arrangement"));
            System.out.println("Seed Issue Type selected: Own Arrangement");

            page.locator("//input[@id='quantity_receiverInformation1']").fill("25");
            System.out.println("Quantity entered: 25");

            page.locator("//select[@id='transport_receiverInformation1']")
            .selectOption(new SelectOption().setLabel("Self"));
            System.out.println("Transport selected: Self");

            page.locator("//select[@id='considerOtherAmount_receiverInformation1']")
            .selectOption(new SelectOption().setLabel("No"));
            System.out.println("Consider Other Amount selected: No");

            page.locator("//select[@id='considerOtherAmountRyot_receiverInformation1']")
            .selectOption(new SelectOption().setLabel("No"));
            System.out.println("Consider Other Amount Ryot selected: No");

            page.locator("//button[@type='submit']").click();
            System.out.println("Seed Issue submitted successfully");

            scanner.nextLine();

            browser.close();

            

        }
    } 
}
