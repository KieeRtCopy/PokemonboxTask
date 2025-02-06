package com.example.pokemonlist.presentation

import android.graphics.Typeface
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.StyleSpan
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.base_component.BaseFragment
import com.example.pokemonlist.R
import com.example.pokemonlist.adapter.MarginDividerItemDecoration
import com.example.pokemonlist.adapter.PokemonAdapter
import com.example.pokemonlist.databinding.FragmentPokemonListBinding
import com.example.pokemonlist.presentation.mvi.PokemonListIntent
import com.example.pokemonlist.presentation.mvi.PokemonListState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonListFragment : BaseFragment<FragmentPokemonListBinding>(FragmentPokemonListBinding::inflate) {

    private val viewModel: PokemonListViewModel by viewModels()
    private lateinit var adapter: PokemonAdapter

    fun setupTitle() :  SpannableString{
        val title = "PokemonBox";
        val spannableTitle = SpannableString(title)
        // Trova l'indice in cui compare la parola "Box"
        val startIndex = title.indexOf("Box")
        if (startIndex != -1) {
            // Applica uno span in grassetto dalla posizione startIndex alla fine della parola "Box"
            spannableTitle.setSpan(
                StyleSpan(Typeface.BOLD),
                startIndex,
                startIndex + "Box".length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        return spannableTitle
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbarTitle(setupTitle())
        showToolbar()

        binding?.rvPokemonList?.layoutManager = LinearLayoutManager(requireContext())

        adapter = PokemonAdapter(emptyList()) { pokemon -> }
        binding?.rvPokemonList?.adapter = adapter



        val dividerDecoration = MarginDividerItemDecoration(
            requireContext(),
            leftMargin = 32,
            rightMargin = 32
        )
        binding?.rvPokemonList?.addItemDecoration(dividerDecoration)

        binding?.rvPokemonList?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(rv: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(rv, dx, dy)
                if (!rv.canScrollVertically(1)) {
                    viewModel.processIntent(PokemonListIntent.LoadNextPage)
                }
            }
        })

        binding?.etSearch?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s?.toString()?.trim() ?: ""
                viewModel.processIntent(PokemonListIntent.Search(query))
            }
            override fun afterTextChanged(s: Editable?) { }
        })

        lifecycleScope.launch {
            viewModel.state.collect { state ->
                render(state)
            }
        }

        // Avvia il caricamento iniziale
        viewModel.processIntent(PokemonListIntent.InitialLoad)
    }

    private fun render(state: PokemonListState) {
        binding?.progressBar?.visibility = if (state.isLoading) View.VISIBLE else View.GONE

        adapter.setItems(state.pokemons)

        state.error?.let {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }.run {
            Log.i("MYTAG", "Caricato ${state.pokemons.size} elementi");
            Toast.makeText(requireContext(), "Caricato ${state.pokemons.size} elementi", Toast.LENGTH_SHORT).show()
        }

    }
}