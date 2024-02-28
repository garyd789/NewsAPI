package com.example.newsapi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newsapi.api.NewsAPI
import com.example.newsapi.databinding.FragmentNewsArticleBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.create


private const val TAG = "NewsArticleFragment"

class NewsArticleFragment : Fragment() {
    private var _binding: FragmentNewsArticleBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentNewsArticleBinding.inflate(inflater, container, false)
        binding.photoGrid.layoutManager = GridLayoutManager(context, 3)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            val response = NewsRepository().fetchContent()
            Log.d(TAG, "Response received: $response")
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}