package com.example.news.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.newsprojectpractice.R
import com.example.newsprojectpractice.databinding.FragmentDetailBinding


class DetailFragment : Fragment(R.layout.fragment_detail) {

    lateinit var binding: FragmentDetailBinding
    val args : ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        val article = args.article

        val titleTextView: TextView = view.findViewById(R.id.title)
        val dateTextView: TextView = view.findViewById(R.id.date)
        val sourceTextView: TextView = view.findViewById(R.id.source)
        val descriptionTextView: TextView = view.findViewById(R.id.description)

        titleTextView.text = article.title
        dateTextView.text = article.publishedAt
        sourceTextView.text = article.source.name
        descriptionTextView.text = article.description


        val articleImage: ImageView = view.findViewById(R.id.image)
        Glide.with(requireContext())
            .load(article.urlToImage)
            .fitCenter()
            .into(articleImage)

        val goToWebsiteButton: Button = view.findViewById(R.id.goToWebsiteButton)
        goToWebsiteButton.setOnClickListener {
            // Burada article'ı kullanarak ilgili action'ı çağır
            val bundle = Bundle().apply {
                putSerializable("article", article)
            }
            findNavController().navigate(R.id.action_detailFragment_to_articleFragment, bundle)
        }
    }
}