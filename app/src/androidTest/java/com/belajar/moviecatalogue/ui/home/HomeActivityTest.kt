package com.belajar.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.utils.Data
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = Data.generateMovies()
    private val dummyTvShow = Data.generateTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

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
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size - 1)
        )
    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rvMovie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.rvMovie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyMovie[0].movieTitle)))
        onView(withId(R.id.tvReleaseDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseDate)).check(matches(withText(dummyMovie[0].movieRelease)))
        onView(withId(R.id.tvRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRating)).check(matches(withText(dummyMovie[0].movieRating)))
        onView(withId(R.id.tvOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverview)).check(matches(withText(dummyMovie[0].movieDescription)))
        onView(withId(R.id.mScrollView)).perform(ViewActions.swipeUp())
        onView(withId(R.id.rvCrew)).check(matches(isDisplayed()))
        onView(withId(R.id.rvCrew)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie[0].crews.size - 1)
        )
        pressBack()
    }

    @Test
    fun loadTvShows(){
        onView(withId(R.id.navigationTvShow)).perform(ViewActions.click())
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size - 1)
        )
    }

    @Test
    fun loadDetailTvShow(){
        onView(withId(R.id.navigationTvShow)).perform(ViewActions.click())
        onView(withId(R.id.rvTvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.rvTvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyTvShow[0].tvShowTitle)))
        onView(withId(R.id.tvReleaseDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseDate)).check(matches(withText(dummyTvShow[0].tvShowRelease)))
        onView(withId(R.id.tvRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRating)).check(matches(withText(dummyTvShow[0].tvShowRating)))
        onView(withId(R.id.tvOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverview)).check(matches(withText(dummyTvShow[0].tvShowDescription)))
        onView(withId(R.id.mScrollView)).perform(ViewActions.swipeUp())
        onView(withId(R.id.rvCrew)).check(matches(isDisplayed()))
        onView(withId(R.id.rvCrew)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow[0].crews.size - 1)
        )
        pressBack()
    }


}   