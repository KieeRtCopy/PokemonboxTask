package com.example.pokemonlist.ui

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.FrameLayout
import coil.load
import com.example.common.base_component.BaseFrameLayout
import com.example.pokemonlist.databinding.ItemPokemonBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable

/**
 * Custom view per visualizzare l’item di un Pokémon, basata sul layout "item_pokemon.xml".
 *
 * Il layout contiene:
 * - Un'ImageView per l'icona (id: ivIcon)
 * - Un TextView per il titolo (id: tvTitle)
 * - Un ChipGroup per i tipi (id: chipGroupTypes)
 * - Un TextView per la descrizione (id: tvDescription)
 */
class PokemonItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    isForRecyclerView: Boolean = false
) : BaseFrameLayout<ItemPokemonBinding>(
    context,
    attrs,
    defStyleAttr,
    isForRecyclerView = !isForRecyclerView,
    inflateMethod = ItemPokemonBinding::inflate
) {

    init {
        layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
    }

    fun loadImage(url: String?){
        binding.ivIcon.load(url) {
            placeholder(com.example.common.R.drawable.ic_pokemon_placeholder)
            error(com.example.common.R.drawable.ic_pokemon_placeholder)
        }
    }


    fun setTitle(title: String) {
        binding.tvTitle.text = title
    }


    fun setDescription(description: String) {
        binding.tvDescription.text = description
    }


    fun setIcon(resourceId: Int) {
        binding.ivIcon.setImageResource(resourceId)
    }

    fun clearTypes() {
        binding.chipGroupTypes.removeAllViews()
    }


    fun addTypeChip(typeName: String) {
        val chip = Chip(context).apply {
            val chipDrawable = ChipDrawable.createFromAttributes(
                context,
                null,
                0,
                com.google.android.material.R.style.Widget_Material3_Chip_Suggestion_Elevated
            )
            this.setChipDrawable(chipDrawable)
            text = typeName
            isEnabled = false
            isSelected = true
            typeface = Typeface.DEFAULT_BOLD
        }
        binding.chipGroupTypes.addView(chip)
    }
}