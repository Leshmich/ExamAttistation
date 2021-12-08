package com.michael.examattistation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Browser
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AboutFragment : Fragment() {
lateinit var showBrowser: Button
    lateinit var developersRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        val developersNames:List<String> = listOf("Michael L.")

        showBrowser=view.findViewById(R.id.google_button)
        developersRecyclerView = view.findViewById(R.id.developer_recycler_view)
        developersRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        developersRecyclerView.adapter=DeveloperAdapter(developersNames)
        showBrowser.setOnClickListener{
            val link=Uri.parse("https://google.com")
            val intentBrowser=Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intentBrowser)
        }


        return view
    }


}