package com.messieyawo.com.artbook.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import com.google.common.truth.Truth.assertThat
import com.messieyawo.com.artbook.getOrAwaitValueTest
import com.messieyawo.com.artbook.repo.FakeArtRepository
import com.messieyawo.com.artbook.utils.Status
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ArtViewModelTest {

    //this means that just run everything on the main thread
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    /*
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

     */

    private lateinit var viewModel : ArtViewModel

    @Before
    fun setup() {
        viewModel = ArtViewModel(FakeArtRepository())
    }

    @Test
    fun `insert art without year returns error`() {
        viewModel.makeArt("Mona Lisa","Da Vinci","")
                                               //this turn liveData to real data
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()

        assertThat(value.status).isEqualTo(Status.ERROR)
    }


    @Test
    fun `insert art without name returns error`() {
        viewModel.makeArt("","Da Vinci","1500")

        val value = viewModel.insertArtMessage.getOrAwaitValueTest()

        assertThat(value.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert art without artistName returns error`() {
        viewModel.makeArt("Mona Lisa","","1500")

        val value = viewModel.insertArtMessage.getOrAwaitValueTest()

        assertThat(value.status).isEqualTo(Status.ERROR)
    }
}