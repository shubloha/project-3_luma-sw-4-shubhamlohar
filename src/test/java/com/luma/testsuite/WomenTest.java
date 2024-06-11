package com.luma.testsuite;

import com.luma.pages.HomePage;
import com.luma.pages.WomenPage;
import com.luma.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Write down the following test into WomenTestclass
 * 1. verifyTheSortByProductNameFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click on Jackets
 * * Select Sort By filter “Product Name”
 * * Verify the products name display in
 * alphabetical order
 * 2. verifyTheSortByPriceFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click ok
 */
public class WomenTest extends BaseTest {
    HomePage homePage = new HomePage();
    WomenPage womenPage = new WomenPage();

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        //Mouse Hover on Women Menu
        homePage.mouseHoverOnWomenMenu();
        //Mouse Hover on Tops
        homePage.mouseHoverOntopMenu();
        //Click on Jackets
        homePage.clickOnJacketLink();
        List<String> actualText = womenPage.storeProductNamesInAscendingOrder();
        womenPage.selectFilterSortByNames();
        Thread.sleep(2000);
        List<String> expextedText = womenPage.storeProductNamesAfterFilterName();
        Assert.assertEquals(actualText, expextedText);
    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        //Mouse Hover on Women Menu
        homePage.mouseHoverOnWomenMenu();
        //Mouse Hover on Tops
        homePage.mouseHoverOntopMenu();
        //Click on Jackets
        homePage.clickOnJacketLink();
        List<Double> actualText = womenPage.storeProductsNamesByPriceinAscendingOrder();
        womenPage.selectFilterSortByPriceLowToHigh();
        Thread.sleep(2000);
        List<Double> expextedText = womenPage.storeProductsNamesByPriceAfterFilterPriceLowToHigh();
        Assert.assertEquals(actualText, expextedText);
    }
}