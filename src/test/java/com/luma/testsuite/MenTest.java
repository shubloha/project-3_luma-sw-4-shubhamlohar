package com.luma.testsuite;

import com.luma.pages.HomePage;
import com.luma.pages.MenPage;
import com.luma.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenTest extends BaseTest {
    HomePage homePage = new HomePage();
    MenPage menPage = new MenPage();

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        //Mouse Hover on Men Menu
        homePage.mouseHoverOnmenMenu();
        //Mouse Hover on Bottoms
        homePage.mouseHoverOnBottomMenu();
        //Click on Pants
        homePage.clickOnPantsLink();
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32
        menPage.mouseHoverOnCronusYogaPants();
        menPage.selectSize32();
        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour Black.
        menPage.mouseHoverOnCronusYogaPants();
        menPage.selectColourBlack();
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        menPage.mouseHoverOnCronusYogaPants();
        menPage.clickOnAddToCartButton();
        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = menPage.addToShoppingCartText();
        Assert.assertEquals(actualText, expectedText);
        //Click on ‘shopping cart’ Link into message
        menPage.clickOnShoppingCartLink();
        //Verify the text ‘Shopping Cart.’
        expectedText = "Shopping Cart";
        actualText = menPage.shoppingCartText();
        Assert.assertEquals(actualText, expectedText);
        //Verify the product name ‘Cronus Yoga Pant’
        expectedText = "Cronus Yoga Pant";
        actualText = menPage.cronusYogaPantText();
        Assert.assertEquals(actualText, expectedText);
        //Verify the product size ‘32’
        expectedText = "32";
        actualText = menPage.size32Text();
        Assert.assertEquals(actualText, expectedText);
        Assert.assertEquals("32", getTextFromElement(By.xpath("//dd[contains(text(),'32')]")));
        //Verify the product colour ‘Black’
        expectedText = "Black";
        actualText = menPage.colourBlackText();
        Assert.assertEquals(actualText, expectedText);
    }

}
