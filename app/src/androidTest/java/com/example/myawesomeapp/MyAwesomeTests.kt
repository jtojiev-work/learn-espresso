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

    @Test
    fun checkMainScreenElementsAvailability() {
        homeScreenStep.homeScreenBodyTextIsDisplayed()
    }

    // Кейс 1. Проверка экрана Slideshow
    @Test
    fun checkSlideshowScreen() {
        homeScreenStep.homeScreenBurgerButtonClick()
        navMenuStep.slideShowScreenOptionClick()
        homeScreenStep.toolbarTitleIsDisplayed("Slideshow")
        slideshowScreenStep.slideshowScreenBodyTextIsDisplayed()
    }

    // Кейс 2. Проверка меню
    @Test
    fun checkToolbarAndNaviMenu() {
        homeScreenStep.homeScreenBurgerButtonIsDisplayed()
        homeScreenStep.toolbarTitleIsDisplayed("Home")
        homeScreenStep.homeScreenMoreActionButtonIsDisplayed()
        homeScreenStep.homeScreenBurgerButtonClick()
        navMenuStep.userProfilePhotoIsDisplayed()
        navMenuStep.userProfileNameIsDisplayed()
        navMenuStep.userProfileEmailIsDisplayed()
        navMenuStep.homeScreenOptionIsDisplayed()
        navMenuStep.galleryScreenOptionIsDisplayed()
        navMenuStep.slideShowScreenOptionIsDisplayed()
        navMenuStep.homeScreenOptionClick()
    }

    // Кейс 3. Проверка работы зеленой кнопки внизу экрана
    @Test
    fun checkEmailButtonFunctionality() {
        homeScreenStep.homeScreenGreenEmailButtonIsDisplayed()
        homeScreenStep.homeScreenGreenEmailButtonClick()
        homeScreenStep.homeScreenNotificationMessageIsDisplayed()
        homeScreenStep.homeScreenNotificationMessageSwipe()
        homeScreenStep.homeScreenNotificationMessageIsNotDisplayed()
    }

    // Кейс 4. Проверка экрана Gallery
    @Test
    fun checkGalleryScreen() {
        homeScreenStep.homeScreenBurgerButtonClick()
        navMenuStep.galleryScreenOptionIsDisplayed()
        navMenuStep.galleryScreenOptionClick()
        navMenuStep.galleryScreenOptionIsChecked()
        homeScreenStep.toolbarTitleIsDisplayed("Gallery")
        galleryScreenStep.galleryItemListIsDisplayed()
        galleryScreenStep.galleryItemClick("1")
        galleryScreenStep.gallerySelectedItemNotificationIsDisplayed("1")
        galleryScreenStep.galleryItemListSwipeUp()
        galleryScreenStep.galleryItemClick("10")
        galleryScreenStep.gallerySelectedItemNotificationIsDisplayed("10")
    }

    @After
    fun tearDown() {
        scenario.close()
    }
}
