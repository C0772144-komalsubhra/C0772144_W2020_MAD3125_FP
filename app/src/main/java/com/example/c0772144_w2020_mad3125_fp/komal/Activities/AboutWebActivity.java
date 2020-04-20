package com.example.c0772144_w2020_mad3125_fp.komal.Activities;

class AboutWebActivity  : AppCompatActivity()  {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    val myWebView: WebView = findViewById(R.id.about)

    val mActionBar = supportActionBar
    mActionBar!!.hide()
    val assetManager = this.assets
}
