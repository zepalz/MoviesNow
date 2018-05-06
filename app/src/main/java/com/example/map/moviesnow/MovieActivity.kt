package com.example.map.moviesnow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.map.moviesnow.adapter.MovieListAdapter
import com.example.map.moviesnow.models.MockMovieRepository
import com.example.map.moviesnow.models.Movie
import com.example.map.moviesnow.models.MovieRepository
import com.example.map.moviesnow.presenter.MoviePresenter
import com.example.map.moviesnow.presenter.MovieView
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity: AppCompatActivity(), MovieView {
    private lateinit var repository: MovieRepository
    private lateinit var presenter: MoviePresenter
    private lateinit var adapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        repository = MockMovieRepository()
        presenter = MoviePresenter(this, repository)
        presenter.start()
    }

    override fun setMovieList(movies: ArrayList<Movie>) {
        adapter = MovieListAdapter(this, movies)
        movieList.adapter = adapter
    }
}