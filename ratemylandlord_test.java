package AutomationFramework;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.junit.Assert;

/* HOW TO RUN
1. Before running Django server, use the command "python3 manage.py flush" and enter "yes" to clear out pre-entered memory in the SQL database
    ^^^ YOU NEED TO DO THIS EVERYTIME YOU RUN THIS PROGRAM ^^^
2. Change line 24 in this program to wherever you moved this file to from GitHub
3. Run the server with "python3 manage.py runserver"
4. Run this program
*/

public class ratemylandlord_test
{   
    // NEED TO CHANGE THIS TO WHEREVER YOU PULLED THE GITHUB
    final static String directory1 = "C:/Users/maxwe/Dropbox";

    // DO NOT CHANGE THIS
    final static String directory2 = "/selenium-tests/src/AutomationFramework/chromedriver.exe";
    final static String directory = directory1 + directory2;

    public static void homepage_search_by_name() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000");
        driver.manage().window().maximize();
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/a[1]")).click(); // click "SEARCH BY NAME"
        Thread.sleep(2000L);

        Assert.assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:8000/search");
        driver.close();
    }

    public static void homepage_search_by_filter() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000");
        driver.manage().window().maximize();
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/a[2]")).click(); // click "SEARCH BY FILTER"
        Thread.sleep(2000L);

        Assert.assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:8000/filter");
        driver.close();
    }

    public static void create_new_landlord() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000/search");
        driver.manage().window().maximize();
        Thread.sleep(1000L);
        
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/a")).click(); // click on add new landlord
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/input")).sendKeys("Paul");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).sendKeys("Atreides");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/button")).click(); // click submit
        Thread.sleep(1000L);
        
        // should have landlord named "Paul Atreides"
        Assert.assertTrue(driver.getPageSource().contains("Paul Atreides"));
        
        driver.close();
    }

    public static void backout_new_landlord() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();
        
        driver.get("http://127.0.0.1:8000/search");
        driver.manage().window().maximize();
        Thread.sleep(1000L);
        
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/a")).click(); // click on add new landlord
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/input")).sendKeys("Joe");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).sendKeys("Gatto");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/a")).click(); // back
        Thread.sleep(2000L);

        // should be back to original URL
        final String url_cmpr = "http://127.0.0.1:8000/search";
        Assert.assertEquals(driver.getCurrentUrl(), url_cmpr);
        
        driver.close();
    }

    public static void create_duplicate_landlord() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000/search");
        driver.manage().window().maximize();
        Thread.sleep(1000L);
        
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/a")).click(); // click on add new landlord
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/input")).sendKeys("Anakin");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).sendKeys("Skywalker");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/button")).click(); // click submit
        Thread.sleep(1000L);
        /* //sending duplicate
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/input")).sendKeys("Anakin");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).sendKeys("Skywalker");
        Thread.sleep(1000L);
        */
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/input")).sendKeys("Obi-Wan");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).sendKeys("Kenobi");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/button")).click(); // click submit again
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/a")).click(); // click back
        Thread.sleep(2000L);
        
        // there should only be one "Anakin Skywalker"
        /*
        List<WebElement> elements = driver.findElements(By.xpath("//*[text() = ' Anakin Skywalker + ']"));
        Assert.assertTrue(elements.size() == 1);
        */
        driver.close();
    }

    public static void create_empty_landlord() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000/add-landlord");
        driver.manage().window().maximize();
        Thread.sleep(1000L);
        
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/input")).sendKeys("");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).sendKeys("");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/button")).click(); // click submit
        Thread.sleep(2000L);
        
        // check that we get error message
        String error_msg = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div")).getText();
        Assert.assertEquals(error_msg, "Unable to submit new landlord. Please make sure you have filled out all required fields.");
        driver.close();
    }

    public static void create_invalid_landlord() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000/add-landlord");
        driver.manage().window().maximize();
        Thread.sleep(1000L);
        
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/input")).sendKeys("¥¦Ø†¶£*®#©œŒ±");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).sendKeys("§¡—‰…ƒ¼¾[}@{]<>");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/button")).click(); // click submit
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/a")).click(); // click back
        Thread.sleep(2000L);

        // we should get error for invalid landlord name
        driver.close();
    }

    public static void search_valid_landlord() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000/search");
        driver.manage().window().maximize();
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/a")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/input")).sendKeys("Thomas");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).sendKeys("Anderson");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/button")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/input")).sendKeys("Anderson");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).sendKeys("Cooper");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/button")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/a")).click(); // go back
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/input")).sendKeys("anderson");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/div/button")).click();
        Thread.sleep(1000L);
        
        String anderson = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/ul/a[1]/div/h6")).getText();
        Assert.assertEquals(anderson, "Anderson Cooper");
        String neo = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/ul/a[2]/div/h6")).getText();
        Assert.assertEquals(neo, "Thomas Anderson");
        driver.close();
    }

    public static void search_invalid_landlord() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000/search");
        driver.manage().window().maximize();
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/input")).sendKeys("jimothy");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/div/button")).click();
        Thread.sleep(2000L);
        
        String error_msg = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/h5")).getText();
        Assert.assertEquals(error_msg, "No search results found for \"jimothy\"");
        driver.close();
    }

    public static void add_review_form_1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000/add-landlord");
        driver.manage().window().maximize();
        Thread.sleep(1000L);
        
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/input")).sendKeys("Shirley Ann");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).sendKeys("Jackson");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/button")).click(); // click submit
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/a")).click(); // click back
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/input")).sendKeys("shirley ann jackson");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/div/button")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/ul/a/div/h6")).click();
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div[1]/div/div/input")).sendKeys("RPI Student"); // input reviewer name
        Thread.sleep(1000L);
        
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div[1]/span[1]")); // select Safety Rating slider
        //*[@id="app"]/div/div[1]/div/div[3]/div/div[1]/span[1]
        //*[@id="app"]/div/div[1]/div/div[3]/div/div[1]/span[1]/span[1]
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_LEFT); // move to 0
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[2]/span[25]")); // select Responsiveness and Maintenance Rating slider
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_LEFT); // move to 0
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[3]/span[25]")); // select Transparency and Trustworthiness Rating slider
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_LEFT); // move to 0
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[4]/span[25]")); // select Organization Rating slider
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_LEFT); // move to 0
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[5]/span[25]")); // select Student Friendliness Rating slider
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_LEFT); // move to 0
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[2]/button/span[1]")).click(); // hit submit
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/a")); // click Back to Search
        Thread.sleep(2000L);

        driver.close();
    }

    public static void add_review_form_2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000/search");
        driver.manage().window().maximize();
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/input")).sendKeys("paul");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/div/button")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/ul/a/div/h6")).click();
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div[1]/div/div/input")).sendKeys("Lady Jessica"); // input reviewer name
        Thread.sleep(1000L);
        
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[1]/span[25]")); // select Safety Rating slider
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_RIGHT); // move to 10
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[2]/span[25]")); // select Responsiveness and Maintenance Rating slider
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_RIGHT); // move to 10
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[3]/span[25]")); // select Transparency and Trustworthiness Rating slider
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_RIGHT); // move to 10
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[4]/span[25]")); // select Organization Rating slider
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_RIGHT); // move to 10
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[5]/span[25]")); // select Student Friendliness Rating slider
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_RIGHT); // move to 10
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[2]/button/span[1]")).click(); // hit submit
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[4]/a/span[1]")).click(); // click Back to Search
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/input")).sendKeys("Atreides");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/div/button")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/ul/a/div/h6")).click();
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div[1]/div/div/input")).sendKeys("Gurney Halleck"); // input reviewer name
        Thread.sleep(1000L);
        
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[1]/span[25]")); // select Safety Rating slider
        for (int i = 0; i < 3; i++ ) slider.sendKeys(Keys.ARROW_LEFT); // move to 2
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[2]/span[25]")); // select Responsiveness and Maintenance Rating slider
        // stay at to 5
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[3]/span[25]")); // select Transparency and Trustworthiness Rating slider
        for (int i = 0; i < 4; i++ ) slider.sendKeys(Keys.ARROW_RIGHT); // move to 9
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[4]/span[25]")); // select Organization Rating slider
        for (int i = 0; i < 2; i++ ) slider.sendKeys(Keys.ARROW_RIGHT); // move to 7
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[5]/span[25]")); // select Student Friendliness Rating slider
        for (int i = 0; i < 1; i++ ) slider.sendKeys(Keys.ARROW_LEFT); // move to 4
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[2]/button/span[1]")).click(); // hit submit
        Thread.sleep(1000L);

        driver.close();
    }

    public static void search_landlord_reviews_1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000/search");
        driver.manage().window().maximize();
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/input")).sendKeys("shirley ann jackson");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/div/button")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/ul/a/div/h6")).click();
        Thread.sleep(1000L);
        
        String results = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/h5")).getText();
        Assert.assertEquals(results, "1 Review for Shirley Ann Jackson");

        String overall = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/h6")).getText();
        Assert.assertEquals(overall, "RPI Student • 0.0 Overall");

        driver.close();
    }

    public static void search_landlord_reviews_2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000/search");
        driver.manage().window().maximize();
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/input")).sendKeys("paul atreides");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/div/button")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/ul/a/div/h6")).click();
        Thread.sleep(2000L);

        String results = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/h5")).getText();
        Assert.assertEquals(results, "2 Reviews for Paul Atreides");

        String overall1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/h6")).getText();
        Assert.assertEquals(overall1, "Lady Jessica • 10.0 Overall");

        String overall2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div/h6")).getText();
        Assert.assertEquals(overall2, "Gurney Halleck • 5.4 Overall");

        driver.close();
    }

    public static void search_by_filter_1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000/filter");
        driver.manage().window().maximize();
        Thread.sleep(1000L);

        WebElement slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/span")); // select rating scale
        
        // move to 10
        Actions action = new Actions(driver);
        action.click(slider).build().perform();
        for (int i = 0; i < 6; i++) {
            action.sendKeys(Keys.ARROW_RIGHT).build().perform();
            Thread.sleep(200L);
        }

        String error_msg = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/h5")).getText();
        Assert.assertEquals(error_msg, "No search results found for overall ratings > 10");
        driver.close();
    }

    public static void search_by_filter_2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000/add-landlord");
        driver.manage().window().maximize();
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/input")).sendKeys("Peter");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).sendKeys("Griffin");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/button")).click(); // submit
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/input")).sendKeys("Homer");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/input")).sendKeys("Simpson");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/button")).click(); // submit
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/a")).click(); // back

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/input")).sendKeys("Peter Griffin");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/div/button")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/ul/a")).click();
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div[1]/div/div/input")).sendKeys("Lois Griffin");
        Thread.sleep(1000L);
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[1]/span[25]")); // select Safety Rating slider
        for (int i = 0; i < 1; i++ ) slider.sendKeys(Keys.ARROW_LEFT); // move to 4
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[2]/span[25]")); // select Responsiveness and Maintenance Rating slider
        for (int i = 0; i < 1; i++ ) slider.sendKeys(Keys.ARROW_LEFT); // move to 4
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[3]/span[25]")); // select Transparency and Trustworthiness Rating slider
        for (int i = 0; i < 1; i++ ) slider.sendKeys(Keys.ARROW_LEFT); // move to 4
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[4]/span[25]")); // select Organization Rating slider
        for (int i = 0; i < 1; i++ ) slider.sendKeys(Keys.ARROW_LEFT); // move to 4
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[5]/span[25]")); // select Student Friendliness Rating slider
        for (int i = 0; i < 1; i++ ) slider.sendKeys(Keys.ARROW_LEFT); // move to 4
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[2]/button/span[1]")).click(); // hit submit
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/a")).click(); // back to search
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/input")).sendKeys("Homer Simpson");
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div/div/button")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/ul/a")).click();
        Thread.sleep(1000L);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div[1]/div/div/input")).sendKeys("Marge Simpson");
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[1]/span[25]")); // select Safety Rating slider
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_RIGHT); // move to 10
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[2]/span[25]")); // select Responsiveness and Maintenance Rating slider
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_RIGHT); // move to 10
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[3]/span[25]")); // select Transparency and Trustworthiness Rating slider
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_RIGHT); // move to 10
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[4]/span[25]")); // select Organization Rating slider
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_RIGHT); // move to 10
        Thread.sleep(1000L);
        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[1]/span[5]/span[25]")); // select Student Friendliness Rating slider
        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_RIGHT); // move to 10
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div/div[2]/button/span[1]")).click(); // hit submit
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[4]/a")).click(); // back to search
        Thread.sleep(1000L);

        driver.navigate().to("http://127.0.0.1:8000/filter");
        Thread.sleep(1000L);

        slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/span")); // select rating scale
        
        // move to 0
        Actions action = new Actions(driver);
        action.click(slider).build().perform();
        for (int i = 0; i < 6; i++) {
            action.sendKeys(Keys.ARROW_LEFT).build().perform();
            Thread.sleep(200L);
        }
        String all_landlords = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/ul")).getText();
        Assert.assertTrue(all_landlords.contains("Homer Simpson") && all_landlords.contains("Paul Atreides") 
                          && all_landlords.contains("Peter Griffin") && all_landlords.contains("Shirley Ann Jackson"));
        Thread.sleep(1000L);
        
        // move to 2
        for (int i = 0; i < 2; i++) {
            action.sendKeys(Keys.ARROW_RIGHT).build().perform();
            Thread.sleep(200L);
        }
        all_landlords = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/ul")).getText();
        Assert.assertTrue(all_landlords.contains("Homer Simpson") && all_landlords.contains("Paul Atreides") 
                          && all_landlords.contains("Peter Griffin") && !all_landlords.contains("Shirley Ann Jackson"));
        Thread.sleep(1000L);

        // move to 5
        for (int i = 0; i < 4; i++) {
            action.sendKeys(Keys.ARROW_RIGHT).build().perform();
            Thread.sleep(200L);
        }
        all_landlords = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/ul")).getText();
        Assert.assertTrue(all_landlords.contains("Homer Simpson") && all_landlords.contains("Paul Atreides") 
                          && !all_landlords.contains("Peter Griffin") && !all_landlords.contains("Shirley Ann Jackson"));
        Thread.sleep(1000L);

        // move to 10
        for (int i = 0; i < 5; i++) {
            action.sendKeys(Keys.ARROW_RIGHT).build().perform();
            Thread.sleep(200L);
        }
        all_landlords = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/ul")).getText();
        Assert.assertTrue(all_landlords.contains("Homer Simpson") && !all_landlords.contains("Paul Atreides") 
                          && !all_landlords.contains("Peter Griffin") && !all_landlords.contains("Shirley Ann Jackson"));
        Thread.sleep(1000L);
        
        driver.close();
    }
    
    public static void illegal_url() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000/Obi-Wan:-It's over, Anakin! I have the high ground!-Anakin Skywalker:-You underestimate my power!-Obi-Wan:-Don't try it.");
        driver.manage().window().maximize();
        Thread.sleep(1000L);

        String page_not_found = driver.findElement(By.xpath("//*[@id=\"summary\"]/h1")).getText();
        Assert.assertTrue(page_not_found.contains("Page not found"));

        driver.close();
    }

    public static void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", directory);
        final WebDriver driver = (WebDriver)new ChromeDriver();

        driver.get("http://127.0.0.1:8000/landlord/search/7");
        driver.manage().window().maximize();
        Thread.sleep(1000L);

        WebElement slider = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div[1]/span[1]/span[1]")); // select Safety Rating slider
        //*[@id="app"]/div/div[1]/div/div[3]/div/div[1]/span[1]
        //*[@id="app"]/div/div[1]/div/div[3]/div/div[1]/span[1]/span[1]

        for (int i = 0; i < 5; i++ ) slider.sendKeys(Keys.ARROW_LEFT); // move to 0
        Thread.sleep(1000L);

        driver.close();
    }

    public static void main(final String[] args) throws InterruptedException {
        /*
        // TEST CASES FOR HOMEPAGE NAVIGATION
        homepage_search_by_name();
        homepage_search_by_filter();

        // TEST CASES FOR CREATING NEW LANDLORD
        create_new_landlord();
        backout_new_landlord();
        create_duplicate_landlord();
        create_empty_landlord();
        create_invalid_landlord();
        // add test where we don't add first or last name

        // TEST CASES FOR SEARCHING LANDLORD
        search_valid_landlord();
        search_invalid_landlord();

        // TEST CASES FOR REVIEWING A LANDLORD
        add_review_form_1();
        add_review_form_2();

        // TEST CASES FOR SEARCHING LANDLORD REVIEWS
        search_landlord_reviews_1();
        search_landlord_reviews_2();

        // TEST CASE FOR SEARCHING BY FILTER
        search_by_filter_1();
        search_by_filter_2();

        // MISCELLANEOUS TESTS
        illegal_url();
        */
        test();

        System.out.println("All tests are successful!");

    }
}