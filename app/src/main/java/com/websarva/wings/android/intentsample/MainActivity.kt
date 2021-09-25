package com.websarva.wings.android.intentsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 画面部品ListViewを取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        // SimpleAdapterで使用するMutableListオブジェクトを用意
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()
        // メニューのデータ登録
        var menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "850円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ステーキ定食", "price" to "1000円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "焼き肉定食", "price" to "900円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "焼き魚定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "野菜炒め定食", "price" to "700円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "天ぷら定食", "price" to "950円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "とんかつ定食", "price" to "900円")
        menuList.add(menu)
        // SimpleAdapter第4引数from用データ作成
        val from = arrayOf("name", "price")
        // SimpleAdapter第5引数to用データ作成
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        // SimpleAdapter作成
        val adapter = SimpleAdapter(this@MainActivity, menuList, android.R.layout.simple_list_item_2, from, to)
        // アダプタの登録
        lvMenu.adapter = adapter
        // リストタップのリスなクラス登録
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    // リストがタップされた時の処理が記述されたメンバクラス
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // タップされた行のデータを取得
            val item = parent.getItemAtPosition(position) as MutableMap<String, String>
            // 定食名を金額を取得
            val menuName = item["name"]
            val menuPrice = item["price"]
            // インデントオブジェクトを生成
            val intent2MenuThanks = Intent(this@MainActivity, MenuThanksActivity::class.java)
            // 第2画面に送るデータを格納
            intent2MenuThanks.putExtra("menuName", menuName)
            intent2MenuThanks.putExtra("menuPrice", menuPrice)
            // 第2画面の起動
            startActivity(intent2MenuThanks)
        }
    }
}