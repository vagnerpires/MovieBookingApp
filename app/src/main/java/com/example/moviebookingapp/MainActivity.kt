package com.example.moviebookingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

    }

    private fun getRandomIntRange(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return (start..end).random()
    }

    val movie = listOf(
            Movie(
                "Creed III",
                "https://www.myvue.com/-/media/images/film%20and%20events/feb%2023/film/creed3-panel.jpg?sc=.99",
                "TBC",
                "When a childhood friend and former boxing prodigy, Damian (Jonathan Majors), resurfaces after serving a long sentence in prison, he is eager to prove that he deserves his shot in the ring.",
                listOf("Michael B. Jordan", "Tessa Thompson", "Jonathan Majors") ,
                116,
                getRandomIntRange(0, 15),
                0
            ),
            Movie(
                "Jhon Wick: Chapter 4",
                "https://www.myvue.com/-/media/images/film%20and%20events/march%202023/films/john-wick-4---panel.jpg?sc=.99",
                "16",
                "John Wick (Keanu Reeves) uncovers a path to defeating The High Table. But before he can earn his freedom, Wick must face off against a new enemy with powerful alliances across the globe and forces that turn old friends into foes.",
                listOf("Keanu Reeves", "Donnie Yen", "Bill Skarsgård"),
                169,
                getRandomIntRange(0, 15),
                0
            ),
            Movie(
                "Dungeons & Dragons: Honour Among Thieves",
                "https://www.myvue.com/-/media/images/film%20and%20events/jan%2023/film/dnd-panel.jpg?sc=.99",
                "TBC",
                "A charming thief and a band of unlikely adventurers undertake an epic heist to retrieve a lost relic, but things go dangerously awry when they run afoul of the wrong people.",
                listOf("Chris Pine", "Michelle Rodriguez", "Justice Smith"),
                134,
                getRandomIntRange(0, 15),
                0
            ),
            Movie(
                "Scream VI",
                "https://www.myvue.com/-/media/images/film%20and%20events/jan%2023/film/scream-6-panel.jpg?sc=.99",
                "16",
                "Following the latest Ghostface killings, the four survivors leave Woodsboro behind and start a fresh chapter.",
                listOf("Melissa Barrera", "Jenna Ortega", "Courteney Cox"),
                122,
                getRandomIntRange(0, 15),
                0
            )
    )
}

