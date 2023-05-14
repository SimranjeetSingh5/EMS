package com.example.educationmanagementsystem.adapter

import android.app.DownloadManager
import android.content.Context.DOWNLOAD_SERVICE
import android.net.Uri
import android.os.Environment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.URLUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.educationmanagementsystem.databinding.ItemBookBinding
import com.example.educationmanagementsystem.models.BookData

class LibraryAdapter(val context: FragmentActivity?) : RecyclerView.Adapter<LibraryAdapter.MyViewHolder>() {
    var bookList: ArrayList<BookData> = arrayListOf()

    class MyViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val bookItem = bookList[position]
        val bookHolder: MyViewHolder = holder
        bookHolder.binding.bookName.text = bookItem.bookName
        bookHolder.binding.author.text = "Author: " + bookItem.authorName
        bookHolder.binding.pages.text = "Pages: " + bookItem.pages.toString()
        bookHolder.binding.downloadBtn.setOnClickListener {
            val request = DownloadManager.Request(Uri.parse(bookItem.downloadLink))
            val title = URLUtil.guessFileName(bookItem.downloadLink,null,null)
            request.setTitle(title)
            request.setDescription("Downloading file please wait.....")
            val cookie = CookieManager.getInstance().getCookie(bookItem.downloadLink)
            request.addRequestHeader("cookie",cookie)
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,title)

            val downloadManager:DownloadManager = context?.getSystemService(DOWNLOAD_SERVICE) as DownloadManager
            downloadManager.enqueue(request)
        }

    }

    override fun getItemCount(): Int {
        return bookList.size
    }

}