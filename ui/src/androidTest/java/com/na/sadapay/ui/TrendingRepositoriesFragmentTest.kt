package com.na.sadapay.ui

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.na.sadapay.ui.githubrepositories.TrendingRepositoriesFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TrendingRepositoriesFragmentTest {
    private lateinit var classUnderTest: TrendingRepositoriesFragment

    @Before
    fun setup(){
        classUnderTest = TrendingRepositoriesFragment()
    }

    @Test
    fun `when`(){
        classUnderTest.onDataLoading(true)
    }
}
