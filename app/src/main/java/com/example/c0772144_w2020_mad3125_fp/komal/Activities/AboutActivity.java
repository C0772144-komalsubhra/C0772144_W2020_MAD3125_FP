package com.example.c0772144_w2020_mad3125_fp.komal.Activities;

class AboutActivity : AppCompatActivity()  {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val myWebView: WebView = findViewById(R.id.about)

        val mActionBar = supportActionBar
        mActionBar!!.hide()
        val assetManager = this.assets

        try {
        val inputStream = assetManager.open("about.html")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val content = String(buffer, StandardCharsets.UTF_8)
        Log.d("DATA", content)
        myWebView?.loadData(content, "text/html", "utf-8")
        } catch (e: IOException) {
        e.printStackTrace()
        }
        }
}
