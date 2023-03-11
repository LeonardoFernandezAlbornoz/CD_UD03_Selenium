import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class pruebasPagina {

    WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Hpg2/Documents/DAW/ContornosDesenvolvemento/2ª Evaluación/Tareas/CD_UD03_Selenium/driver/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.coolmod.com/");

    }

    @Test
    public void CP1() throws InterruptedException {

        driver.findElement(By.name("seek")).click();

        driver.findElement(By.id("df-searchbox__dffullscreen")).sendKeys("Cougar Vortex RGB FCB 120 RGB");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(
                "[src='//www.coolmod.com/images/product/normal/cougar-vortex-rgb-fcb-120-rgb-ventilador-12cm-001.jpg']"))
                .click();
        driver.findElement(By.className("onlynumberinput")).sendKeys("50");
        driver.findElement(By.id("productbuybutton1")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("swal2-cancel")).click();

        driver.findElement(By.name("seek")).click();
        driver.findElement(By.id("df-searchbox__dffullscreen")).sendKeys("Cougar Vortex ARGB VX 120 PWM HDB");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(
                "[src='//www.coolmod.com/images/product/normal/cougar-vortex-argb-vx-120-pwm-hdb-ventilador-12-cm-001.jpg']"))
                .click();
        driver.findElement(By.className("onlynumberinput")).sendKeys("50");
        driver.findElement(By.id("productbuybutton1")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("swal2-confirm")).click();

        WebElement c1 = driver.findElement(By.cssSelector("[data-prod='66572']"));
        WebElement c2 = driver.findElement(By.cssSelector("[data-prod='136571']"));
        assertEquals(c1.getAttribute("value").equals("50") && c2.getAttribute("value").equals("50"), true);

        driver.close();

    }

    @Test
    public void CP2() throws InterruptedException {

        driver.findElement(By.className("fa-clipboard-check")).click();
        driver.findElement(By.className("smallertextsize")).click();

        driver.findElement(By.className("createaccount")).click();
        driver.findElement(By.id("inputEmail")).sendKeys("hola@gmail.com");
        driver.findElement(By.id("inputPassword")).sendKeys("Abc1234.");
        driver.findElement(By.id("inputPassword2")).sendKeys("Abc1234.");

        driver.findElement(By.id("privacitycheck")).click();
        driver.findElement(By.className("sendlogin")).click();

        Thread.sleep(1000);

        WebElement error = driver.findElement(By.className("swal2-html-container"));
        assertEquals("El email ya se encuentra en nuestra base de datos.", error.getText());
        driver.close();

    }

    @Test
    public void CP6() throws InterruptedException {

        driver.findElement(By.className("fa-clipboard-check")).click();
        driver.findElement(By.className("smallertextsize")).click();
        driver.findElement(By.id("inputEmail")).sendKeys("dajdshd@uhdue.com");
        driver.findElement(By.id("inputPassword")).sendKeys("abc1234.");
        driver.findElement(By.className("sendlogin")).click();

        Thread.sleep(1000);

        String titulo = driver.findElement(By.className("swal2-title")).getText();
        assertEquals("Datos de acceso incorrectos", titulo);
        driver.close();
    }

    @Test
    public void CP8() throws InterruptedException {

        driver.findElement(By.className("fa-clipboard-check")).click();
        driver.findElement(By.className("smallertextsize")).click();

        driver.findElement(By.className("createaccount")).click();
        driver.findElement(By.id("inputEmail")).sendKeys("hola@gmail.com");
        driver.findElement(By.id("privacitycheck")).click();
        driver.findElement(By.className("sendlogin")).click();

        assertEquals("NUEVA CUENTA", driver.findElement(By.tagName("h1")).getText());

        driver.close();

    }

    @Test
    public void CP9() throws InterruptedException {
        driver.findElement(By.className("fa-angle-down")).click();

        Thread.sleep(1000);

        driver.findElement(By.id("family9991")).click();

        Thread.sleep(1000);

        driver.findElement(By.linkText("Teclados")).click();

        assertEquals("Teclados", driver.findElement(By.tagName("h1")).getText());

        driver.close();

    }

}