package com.michael.examattistation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
private const val Last_Rolled_coin_image="image"
class TossCoinFragment : Fragment() {
    lateinit var coinImageView: ImageView
    lateinit var rollButton: Button
    private val coinImageList: List<Int> = listOf(
        R.drawable.bed,
        R.drawable.bird,
        R.drawable.tails
    )
    var lastRolledImageRes=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_coin_roll, container, false)

        coinImageView = view.findViewById(R.id.coin_image)
        rollButton = view.findViewById(R.id.roll_button)
        rollButton.setOnClickListener {


            coinImageView.setImageResource(coinImageList.random())
        }

        return view
    }




}