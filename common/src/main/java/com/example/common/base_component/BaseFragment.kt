package com.example.common.base_component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.annotation.MenuRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.example.common.R
import com.example.common.databinding.FragmentBaseBinding

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment() {

    protected var binding: VB? = null
    private var baseBinding: FragmentBaseBinding? = null
    private var toolbarTitle: String = ""

    /**
     * Metodo invocato al click del tasto back sulla toolbar.
     * I Fragment possono sovrascriverlo per comportamenti specifici.
     */
    open fun onToolbarBackPressed() {
        navigateBack()
    }

    /**
     * Metodo invocato al click del tasto back fisico.
     */
    open fun onPhysicalBackPressed() {
        navigateBack()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Gonfia il layout base
        baseBinding = FragmentBaseBinding.inflate(inflater, container, false)
        // Gonfia il layout specifico del Fragment figlio nel container del base layout
        binding = inflate(inflater, baseBinding?.fragmentContainer, false)
        baseBinding?.fragmentContainer?.addView(binding?.root)
        return baseBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (isVisibleToolbar()) {
            showToolbar()
        } else {
            hideToolbar()
        }
        setupPhysicalBackPressed()
    }

    fun setupToolbarTitle(title: String) {
        toolbarTitle = title
        baseBinding?.materialToolbar?.title = title
    }

    fun hideToolbar() {
        baseBinding?.materialToolbar?.visibility = View.GONE
    }

    fun showToolbar() {
        setupNavigationBackIcon(isNavigationBackActiveOnToolbar())
        setupToolbarTitle(toolbarTitle())
        setupMenu()
        baseBinding?.materialToolbar?.visibility = View.VISIBLE
    }

    @MenuRes
    open fun provideMenuRes(): Int = -1

    open fun provideMenuClickListener(): Toolbar.OnMenuItemClickListener? = null

    open fun setupMenu() {
        baseBinding?.materialToolbar?.let { toolbar ->
            if (provideMenuRes() != -1) {
                toolbar.inflateMenu(provideMenuRes())
            }
            provideMenuClickListener()?.let { listener ->
                toolbar.setOnMenuItemClickListener(listener)
            }
        }
    }

    fun setupNavigationBackIcon(isActive: Boolean) {
        baseBinding?.materialToolbar?.let { toolbar ->
            if (isActive) {
                toolbar.navigationIcon = AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.arrow_back_ic
                )
                toolbar.setNavigationOnClickListener { onToolbarBackPressed() }
            } else {
                toolbar.navigationIcon = null
                toolbar.setNavigationOnClickListener(null)
            }
        }
    }

    open fun isNavigationBackActiveOnToolbar(): Boolean = false

    open fun isVisibleToolbar(): Boolean = false

    open fun toolbarTitle(): String = toolbarTitle

    private fun setupPhysicalBackPressed() {
        // Aggiunge il callback per il tasto back fisico
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            onPhysicalBackPressed()
        }
    }

    private fun navigateBack() {
        try {
            if (Navigation.findNavController(requireView()).navigateUp()) {
                return
            }
        } catch (e: IllegalStateException) {
            // Il Fragment non è in un NavGraph
        }
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        baseBinding = null
    }
}