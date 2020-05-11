package com.example.myapplication.subChapterDetail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSubchapterDetailBinding
import com.example.myapplication.utilities.InjectorUtils
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fragment_checklist.*
import kotlinx.android.synthetic.main.fragment_checklist.toolbar_layout
import kotlinx.android.synthetic.main.fragment_subchapter_detail.*


class SubChapterDetailFragment : Fragment() {

    private val args: SubChapterDetailFragmentArgs by navArgs()

    private val subChapterDetailViewModel: SubChapterDetailViewModel by viewModels () {
        InjectorUtils.provideSubChapterDetailViewModelFactory(requireActivity(), args.subChapterId, args.parentChapterId)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSubchapterDetailBinding = DataBindingUtil.inflate<FragmentSubchapterDetailBinding>(
            inflater, R.layout.fragment_subchapter_detail, container, false)

        .apply {
            viewModel = subChapterDetailViewModel
            lifecycleOwner = viewLifecycleOwner
            var isShow = true
            var scrollRange = -1
            appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
                if (scrollRange == -1){
                    scrollRange = barLayout?.totalScrollRange!!
                }
                if (scrollRange + verticalOffset == 0){
                    toolbar_layout.isTitleEnabled = true
                    subchapterTitle.visibility = View.GONE
                    isShow = true
                } else if (isShow){
                    toolbar_layout.isTitleEnabled = false
                    subchapterTitle.visibility = View.VISIBLE
                    isShow = false
                }
            })


            toolbar.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }

            toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_share -> {
                        createShareIntent()
                        true
                    }
                    else -> false
                }
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    // Helper function for calling a share functionality.
    // Should be used when user presses a share button/menu item.
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @Suppress("DEPRECATION")
    private fun createShareIntent() {
        val shareText = subChapterDetailViewModel.subChapter.value.let { subchapter ->
            if (subchapter == null) {
                ""
            } else {
                getString(R.string.share_message, subchapter.title)
            }
        }
        val shareIntent = activity?.let {
            ShareCompat.IntentBuilder.from(it)
                .setText(shareText)
                .setType("text/plain")
                .createChooserIntent()
                .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        }
        startActivity(shareIntent)
    }

}
