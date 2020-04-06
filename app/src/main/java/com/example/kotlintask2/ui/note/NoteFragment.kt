package com.example.kotlintask2.ui.note

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintask2.CustomAdapter
import com.example.kotlintask2.CustomAdapter.OnNoteListener
import com.example.kotlintask2.Item
import com.example.kotlintask2.Object
import com.example.kotlintask2.R
import com.example.kotlintask2.SecondActivity

class NoteFragment : Fragment(), OnNoteListener{

    private var noteViewModel: NoteViewModel? = null

    private val shopList = ArrayList<Item>()
    private val adapter = CustomAdapter(shopList, this)

//    val formatter: DateTimeFormatter.

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
        val root = inflater.inflate(R.layout.fragment_note, container, false)


        val recyclerView = root.findViewById(R.id.recyclerview) as RecyclerView
        addList()
        recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter


        return root
    }
    private fun addList() {
        shopList.add(Item("Bags", "This is the bag"))
        shopList.add(Item("Watches", "This is a watch"))
        shopList.add(Item("Book", "These are books"))
        shopList.add(Item("Shoes", "These contains shoes"))
    }

    override fun onNoteClick(position: Int) {
        Log.d("TAG", "OnNoteClick clicked position is = $position")
        val intent = Intent(this.context, SecondActivity::class.java)
        val bundle = Bundle()
        var parcel = Object(title = null, description = null, im = null)
        when(position) {
            0 -> parcel = Object(title = "This Is The Bag", description = "This contain the info for bags", im = "bag")
            1 -> parcel = Object(title = "This Is The Watch", description = "Watches, Different types are here", im = "watch")
            2 -> parcel = Object(title = "This Is The Book", description = "If you need goood books, they are here", im = "book")
            3 -> parcel = Object(title = "This Is The SHoe", description = "Amazing shoes can be found here", im = "shoe")
        }
        bundle.putParcelable("extra_object", parcel)
        intent.putExtra("Bundle", bundle)
        startActivity(intent)
    }


}
