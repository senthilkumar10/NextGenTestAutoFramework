package com.tac.pages;

import com.tac.enums.WaitStrategy;
import org.openqa.selenium.By;

public class AmazonHamburgerMainMenuPage extends BasePage{

    private By linkFilmTVMusicGame = By.xpath("//div[text()='Films, TV, Music & Games']/parent::a");
    private By LinkCDsVinyl = By.xpath("(//a[text()='CDs & Vinyl'])[2]");
    private By linkBooks = By.xpath("//div[text()='Books']/parent::a");
    private By linkSubMenuBooks = By.xpath("(//a[text()='Books'])[2]");
    private By linkElectronicsComputers = By.xpath("//div[text()='Electronics & Computers']/parent::a");
    private By linkCameraPhoto = By.xpath("//a[text()='Camera & Photo']");


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

    public AmazonCameraPhotoPage clicklinkElectronicsComputers(){
        click(linkElectronicsComputers, WaitStrategy.CLICKABLE,"Electronics Computers Link");
        click(linkCameraPhoto, WaitStrategy.CLICKABLE,"Camera & Photo Link");
        return new AmazonCameraPhotoPage();
    }



}
