package com.matech.kotlindsl.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matech.kotlindsl.data.remote.dto.MoviesListDTO
import com.matech.kotlindsl.domain.Resource
import com.matech.kotlindsl.domain.models.usecases.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val useCase: GetMovieListUseCase) : ViewModel() {
    private var _moviesListLiveData = MutableLiveData<Resource<MoviesListDTO>>()

    val moviesListLiveData: LiveData<Resource<MoviesListDTO>> = _moviesListLiveData

    fun getMoviesList() = viewModelScope.launch {
        useCase().collect {
            _moviesListLiveData.postValue(it)
        }
    }

}