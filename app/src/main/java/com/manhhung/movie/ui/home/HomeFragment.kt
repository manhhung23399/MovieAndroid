package com.manhhung.movie.ui.home

import android.graphics.Color
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.AppBarLayout
import com.manhhung.movie.R
import com.manhhung.movie.base.BaseFragment
import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.databinding.FragmentHomeBinding
import com.manhhung.movie.ui.adapter.MovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val actionAdapter = MovieAdapter(::onItemClick)
    private val fantasyAdapter = MovieAdapter(::onItemClick)
    private val animationAdapter = MovieAdapter(::onItemClick)
    private val horrorAdapter = MovieAdapter(::onItemClick)
    private val familyAdapter = MovieAdapter(::onItemClick)
    override val layoutId = R.layout.fragment_home
    override val viewModel by viewModel<HomeViewModel>()

    override fun initViews() {
        binding?.apply {
            nestedHome.setOnScrollChangeListener { _, _, scrollY, _, _ ->
                if (scrollY <= 56) {
                    val color1 = changeAlpha(
                        ContextCompat.getColor(requireActivity(), R.color.black_transparent),
                        (255 / 56) * (-scrollY)
                    )
                    appBar.setBackgroundColor(color1)
                } else {
                    val color2 = changeAlpha(
                        ContextCompat.getColor(requireActivity(), R.color.black_transparent),
                        (255 / 56) * (-56)
                    )
                    appBar.setBackgroundColor(color2)
                }
            }
        }
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            homeVM = viewModel
            recyclerMovie1.adapter = actionAdapter
            recyclerMovie2.adapter = fantasyAdapter
            recyclerMovie3.adapter = animationAdapter
            recyclerMovie4.adapter = familyAdapter
            recyclerMovie5.adapter = horrorAdapter
        }
    }

    override fun initActions() {
        binding?.apply {
            textMovie.setOnClickListener {
                Toast.makeText(context, "ajkshdlfkjha", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun onItemClick(movie: Movie) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToMovieDetailDialog(movie)
        findNavController().navigate(action)
    }

    private fun changeAlpha(color: Int, fraction: Int): Int {
        val red: Int = Color.red(color)
        val green: Int = Color.green(color)
        val blue: Int = Color.blue(color)
        val alpha: Int = (Color.alpha(color) * (fraction))
        return Color.argb(alpha, red, green, blue)
    }
}
