package com.example.myawesomeapp

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myawesomeapp.steps.GalleryScreenSteps
import com.example.myawesomeapp.steps.HomeScreenSteps
import com.example.myawesomeapp.steps.NavMenuSteps
import com.example.myawesomeapp.steps.SlideshowScreenSteps
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyAwesomeTests {
    private lateinit var scenario: ActivityScenario<MainActivity>
    private var homeScreenStep = HomeScreenSteps()
    private var navMenuStep = NavMenuSteps()
    private var slideshowScreenStep = SlideshowScreenSteps()
    private var galleryScreenStep = GalleryScreenSteps()

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    // Здесь я проверил все существующие элементы на главном экране.
    @Test
    fun checkMainScreenElementsAvailability() {
        homeScreenStep.homeScreenBodyTextIsDisplayed()
    }

    // Кейс 1. Проверка экрана Slideshow
    @Test
    fun checkSlideshowScreen() {
        // Открыть меню.
        homeScreenStep.homeScreenBurgerButtonClick()

        // В меню нажать на опцию Slideshow.
        navMenuStep.slideShowScreenOptionClick()

        // Проверить, что мы оказались на экране с заголовком Slideshow и текстом This is slideshow Fragment.
        homeScreenStep.toolbarTitleIsDisplayed("Slideshow")
        slideshowScreenStep.slideshowScreenBodyTextIsDisplayed()
    }

    // Кейс 2. Проверка меню
    @Test
    fun checkToolbarAndNaviMenu() {
        // Проверить, что в верхней части экрана отображается тулбар с элементами: кнопка Меню, заголовок Home, кнопка Опции.
        homeScreenStep.homeScreenBurgerButtonIsDisplayed()
        homeScreenStep.toolbarTitleIsDisplayed("Home")
        homeScreenStep.homeScreenMoreActionButtonIsDisplayed()

        // Открыть меню и проверить, что в нем отображаются юзерпик, юзернейм и почта, кнопки Home, Gallery и Slideshow.
        homeScreenStep.homeScreenBurgerButtonClick()
        navMenuStep.userProfilePhotoIsDisplayed()
        navMenuStep.userProfileNameIsDisplayed()
        navMenuStep.userProfileEmailIsDisplayed()
        navMenuStep.homeScreenOptionIsDisplayed()
        navMenuStep.galleryScreenOptionIsDisplayed()
        navMenuStep.slideShowScreenOptionIsDisplayed()

        // Вернуться обратно на экран Home тапом по кнопке Home в меню.
        navMenuStep.homeScreenOptionClick()
    }

    // Кейс 3. Проверка работы зеленой кнопки внизу экрана
    @Test
    fun checkEmailButtonFunctionality() {
        // Проверить, что на экране отображается зеленая кнопка.
        homeScreenStep.homeScreenGreenEmailButtonIsDisplayed()

        // Нажать на зеленую кнопку и проверить, что отобразилась нотификация с текстом Replace with your own action.
        homeScreenStep.homeScreenGreenEmailButtonClick()
        homeScreenStep.homeScreenNotificationMessageIsDisplayed()

        // Смахнуть нотификацию свайпом и проверить, что она больше не отображается.
        homeScreenStep.homeScreenNotificationMessageSwipe()
        homeScreenStep.homeScreenNotificationMessageIsNotDisplayed()
    }

    // Кейс 4. Проверка экрана Gallery
    @Test
    fun checkGalleryScreen() {
        // Открыть меню.
        homeScreenStep.homeScreenBurgerButtonClick()

        // В меню нажать на опцию Gallery. Проверить, что после нажатия она становится активной.
        navMenuStep.galleryScreenOptionIsDisplayed()
        navMenuStep.galleryScreenOptionClick()
        navMenuStep.galleryScreenOptionIsChecked()

        // Проверить, что открылся экран Gallery: заголовок в тулбаре сменился с Home на Gallery, отображается список элементов.
        homeScreenStep.toolbarTitleIsDisplayed("Gallery")
        galleryScreenStep.galleryItemListIsDisplayed()

        // Нажать на первый элемент списка и проверить, что отобразилась нотификация с текстом Item #1 clicked successfully!
        galleryScreenStep.galleryItemClick("1")
        galleryScreenStep.gallerySelectedItemNotificationIsDisplayed("1")

        // Пролистать список до последнего элемента и тапнуть по нему. Проверить, что отобразилась нотификация с текстом Item #10 clicked successfully!
        galleryScreenStep.galleryItemListSwipeUp()
        galleryScreenStep.galleryItemClick("10")
        galleryScreenStep.gallerySelectedItemNotificationIsDisplayed("10")
    }

    @After
    fun tearDown() {
        Thread.sleep(2000)
        scenario.close()
    }
}
