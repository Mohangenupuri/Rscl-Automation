
package com.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.Scanner;

public class SeedDiversionOut {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create();
             Scanner scanner = new Scanner(System.in)) {

            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setArgs(java.util.Arrays.asList("--start-maximized"))
            );

            BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                    .setViewportSize(null)
            );

            Page page = context.newPage();

            try {

                page.navigate("https://cmserpdev.rscl.in/login-page");

                System.out.println("Page title: " + page.title());

                // Login
                Locator username = page.locator("//input[@name='USERNAME']");
                Locator password = page.locator("//input[@name='PASSWORD']");
                Locator loginButton = page.locator("//button[@type='submit']");

                username.fill("ccsvng");
                System.out.println("Username entered successfully");

                password.fill("T");
                System.out.println("Password entered successfully");

                loginButton.click();
                System.out.println("Login button clicked");

                page.locator("//*[@id='auth-form']/div[2]/button").click();
                System.out.println("Authenticate button clicked successfully");

                // Navigation
                page.locator("//a[normalize-space()='Cane FI']").first().click();

                page.locator("//a[normalize-space()='Seed']").click();

                page.locator("//a[normalize-space()='Seed Diversion Out']").click();

                System.out.println("Seed Diversion Out opened successfully");

                // Supplier Plot No
                page.locator("//div[@id='supplierPlotNo_property']//div[@class='space-lookup']//div[2]//*[name()='svg']").click();

                System.out.println("Supplier Plot lookup clicked");

                page.locator("//button[normalize-space()='Find']").click();

                System.out.println("Supplier Plot Find clicked");

                page.locator("//tbody/tr[1]/td[1]").click();

                System.out.println("Supplier Plot selected successfully");

                // Diversion To - Select SSEM
                Locator diversionDropdown = page.locator("//select[@id='diversionTo']");

                diversionDropdown.selectOption(
                new SelectOption().setLabel("SSEM")
                );

                System.out.println("Diversion To selected: SSEM");

                // Vehicle Number
                page.locator("//div[@id='vehicleNumber_property']//div[contains(@class,'space-lookup')]//div[2]//*[name()='svg']").click();

                System.out.println("Vehicle Number lookup clicked");

                page.locator("//button[normalize-space()='Find']").click();

                System.out.println("Vehicle Number Find clicked");

                page.locator("//tbody/tr[1]/td[1]").click();

                System.out.println("Vehicle Number selected successfully");

                // Date
                page.locator("//button[@aria-label='Choose date']").click();

                System.out.println("Calendar opened");

                page.locator("//button[normalize-space()='6']").click();

                System.out.println("Date 6 selected successfully");

                // Product ID / Seed Code
                page.locator("//div[@id='productId_property']//div[contains(@class,'space-lookup')]//div[2]//*[name()='svg']").click();

                System.out.println("Seed Code lookup clicked");

                page.locator("//span[normalize-space()='SEED_CODE-RBS']").click();

                System.out.println("SEED_CODE-RBS selected successfully");

                //Quantity M/T

                page.locator("//input[@id='quantity']").fill("10");

                System.out.println("Quantity entered: 10");

                // Harvester
                page.locator("//select[@id='harvester']")
                    .selectOption(new SelectOption().setLabel("Self"));

                System.out.println("Harvester selected: Self");

                // Transport
                page.locator("//select[@id='transport']")
                    .selectOption(new SelectOption().setLabel("Self"));

                System.out.println("Transport selected: Self");

                System.out.println("Automation completed successfully");

                // Submit 

                page.locator("//button[@type='submit']").click();

                 System.out.println("Submit button clicked successfully");

            } catch (Exception e) {

                System.out.println("\n========== AUTOMATION ERROR ==========");

                System.out.println("Error message: " + e.getMessage());

                e.printStackTrace();

                System.out.println("\nBrowser will remain open for debugging.");

            } finally {

                System.out.println("\nPress Enter to close the browser...");

                scanner.nextLine();

                browser.close();
            }
        }
    }
}
