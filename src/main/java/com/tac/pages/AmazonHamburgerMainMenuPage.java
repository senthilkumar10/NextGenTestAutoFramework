package com.tac.pages;

import com.tac.enums.WaitStrategy;
import com.tac.utility.DynamicXpathUtils;
import org.openqa.selenium.By;

public class AmazonHamburgerMainMenuPage extends BasePage{

    private By linkFilmTVMusicGame = By.xpath("//div[text()='Films, TV, Music & Games']/parent::a");
    private By LinkCDsVinyl = By.xpath("(//a[text()='CDs & Vinyl'])[2]");
    private By linkBooks = By.xpath("//div[text()='Books']/parent::a");
    private By linkSubMenuBooks = By.xpath("(//a[text()='Books'])[2]");


    private String linkSubMenu = "(//a[text()='%s'])[2]";

    public void clickOnSubMenuItem(String menutext){
        String newXpath = DynamicXpathUtils.clickOnSubMenuItem(linkSubMenu,menutext);
        click(By.xpath(newXpath),WaitStrategy.CLICKABLE,menutext);

    }

    public AmazonCDsVinylPage clicklinkFilmTVMusicGame(){
        click(linkFilmTVMusicGame, WaitStrategy.CLICKABLE,"Flim TV Music Game Link");
        click(LinkCDsVinyl, WaitStrategy.CLICKABLE,"CDs and Vinyl Link");
        return new AmazonCDsVinylPage();
    }

    public AmazonBooksPage clicklinkBooks(){
        click(linkBooks, WaitStrategy.CLICKABLE,"Books Link");
        click(linkSubMenuBooks, WaitStrategy.CLICKABLE,"Sub Menu Books Link");
        return new AmazonBooksPage();
    }





}
