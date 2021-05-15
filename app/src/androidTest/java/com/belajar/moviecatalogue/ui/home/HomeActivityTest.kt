package com.belajar.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.utils.Data
import com.belajar.moviecatalogue.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = Data.generateMovies()
    private val dummyTvShow = Data.generateTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp(){
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun bottomNavigationBehaviour(){
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()))
        onView(withId(R.id.navigationMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.navigationTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.navigationTvShow)).perform(ViewActions.click())
        onView(withId(R.id.navigationMovie)).perform(ViewActions.click())
    }

    @Test
    fun loadMovies(){
//        delayTwoSecond()
        onView(withId(R.id.mRecyclerView)).check(matches(isDisplayed()))
        onView(withId(R.id.mRecyclerView)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size - 1)
        )
    }

    @Test
    fun loadDetailMovie(){
//        delayTwoSecond()
        onView(withId(R.id.mRecyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.mRecyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
//        delayTwoSecond()
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tvReleaseDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseDate)).check(matches(withText(dummyMovie[0].release)))
        onView(withId(R.id.tvRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRating)).check(matches(withText(dummyMovie[0].rating)))
        onView(withId(R.id.tvOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverview)).check(matches(withText(dummyMovie[0].description)))
        onView(withId(R.id.mScrollView)).perform(ViewActions.swipeUp())
        onView(withId(R.id.rvCrew)).check(matches(isDisplayed()))
        onView(withId(R.id.rvCrew)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>((dummyMovie[0].crews?.size ?: 0) - 1)
        )
        pressBack()
    }

    @Test
    fun loadTvShows(){
//        delayTwoSecond()
        onView(withId(R.id.navigationTvShow)).perform(ViewActions.click())
        onView(withId(R.id.mRecyclerView)).check(matches(isDisplayed()))
        onView(withId(R.id.mRecyclerView)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size - 1)
        )
    }

    @Test
    fun loadDetailTvShow(){
        onView(withId(R.id.navigationTvShow)).perform(ViewActions.click())
//        delayTwoSecond()
        onView(withId(R.id.mRecyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.mRecyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
//        delayTwoSecond()
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tvReleaseDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseDate)).check(matches(withText(dummyTvShow[0].release)))
        onView(withId(R.id.tvRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRating)).check(matches(withText(dummyTvShow[0].rating)))
        onView(withId(R.id.tvOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverview)).check(matches(withText(dummyTvShow[0].description)))
        onView(withId(R.id.mScrollView)).perform(ViewActions.swipeUp())
        onView(withId(R.id.rvCrew)).check(matches(isDisplayed()))
        onView(withId(R.id.rvCrew)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>((dummyTvShow[0].crews?.size ?: 0) - 1)
        )
        pressBack()
    }

}   