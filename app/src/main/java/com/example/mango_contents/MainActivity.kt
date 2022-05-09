package com.example.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookmark = findViewById<TextView>(R.id.bookmarkBtn)
        bookmark.setOnClickListener {
            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/ByuIW33rXc",
                "https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/63176_1468144532794478.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "알라프리마"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/iMRRP69qtkeO",
                "https://mp-seoul-image-production-s3.mangoplate.com/281547/753280_1550146766591_11966?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "미라이"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/ugq5zpw24LjX",
                "https://mp-seoul-image-production-s3.mangoplate.com/844626_1508315202030131.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "스시키"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/Fy2Z5kqgi-7b",
                "https://mp-seoul-image-production-s3.mangoplate.com/495395_1614255254121795.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "따빠디또 디저트 따빠스바 "
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/ByuIW33rXc",
                "https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/63176_1468144532794478.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "알라프리마"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/iMRRP69qtkeO",
                "https://mp-seoul-image-production-s3.mangoplate.com/281547/753280_1550146766591_11966?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "미라이"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/ugq5zpw24LjX",
                "https://mp-seoul-image-production-s3.mangoplate.com/844626_1508315202030131.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "스시키"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/Fy2Z5kqgi-7b",
                "https://mp-seoul-image-production-s3.mangoplate.com/495395_1614255254121795.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "따빠디또 디저트 따빠스바 "
            )
        )

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val adapter = RVAdapter(baseContext, items)

        recyclerview.adapter = adapter

        adapter.itemClick = object: RVAdapter.ItemClick {
            override fun OnClick(view: View, position: Int) {

                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url", items[position].url)
                intent.putExtra("title", items[position].titleText)
                intent.putExtra("imageUrl", items[position].imageUrl)
                startActivity(intent)

            }

        }
        recyclerview.layoutManager = GridLayoutManager(this, 2)


    }
}