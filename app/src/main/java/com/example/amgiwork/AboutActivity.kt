package com.example.amgiwork

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_about.*


class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        iv_ic_mail.setOnClickListener {
            openMail()
        }

        iv_ic_facebook.setOnClickListener {
            openFacebook()
        }

        iv_ic_github.setOnClickListener {
            openGitHub()
        }

        iv_ic_map.setOnClickListener {
            openMap()
        }
    }

    private fun openMap() {
        val gmmIntentUri =
            Uri.parse("geo:-6.180003,106.821421?q=Indosat KPPTI")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    private fun openGitHub() {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/oditouchiha"))
        startActivity(browserIntent)
    }

    //method to get the right URL to use in the intent

    @Suppress("LocalVariableName")
    private fun getFacebookPageURL(context: Context): String {
        val FACEBOOK_URL = "https://www.facebook.com/dyaksa"
        val FACEBOOK_PAGE_ID = "dyaksa"

        val packageManager = context.packageManager

        return try {
            val versionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                packageManager.getPackageInfo("com.facebook.katana", 0).longVersionCode.toInt()
            } else {
                packageManager.getPackageInfo("com.facebook.katana", 0).versionCode
            }

            //newer versions of fb app
            if (versionCode >= 3002850) "fb://facewebmodal/f?href=$FACEBOOK_URL"

            //older versions of fb app
            else "fb://page/$FACEBOOK_PAGE_ID"
        } catch (e: PackageManager.NameNotFoundException) {
            FACEBOOK_URL //normal web url
        }
    }

    private fun isAppInstalled(): Boolean {
        return try {
            applicationContext.packageManager.getApplicationInfo("com.facebook.katana", 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    private fun openFacebook() {
        val context = applicationContext

        if (isAppInstalled()) {
            val facebookIntent = Intent(Intent.ACTION_VIEW)
            val facebookUrl = getFacebookPageURL(context)
            facebookIntent.data = Uri.parse(facebookUrl)

            startActivity(facebookIntent)
        } else {
            Toast.makeText(
                applicationContext,
                "Facebook app not installed !",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun openMail() {
        val to = arrayOf(tv_dev_email.text.toString())
        val subject = "AMG iWork Feedback"
        val message = "Dear Dev, \n"

        val i = Intent(Intent.ACTION_SENDTO)
        i.data = Uri.parse("mailto:")
        i.putExtra(Intent.EXTRA_EMAIL, to)
        i.putExtra(Intent.EXTRA_SUBJECT, subject)
        i.putExtra(Intent.EXTRA_TEXT, message)

        try {
            startActivity(Intent.createChooser(i, "Choose email client..."))
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun showMainActivity() {
        val moveIntent = Intent(this@AboutActivity, MainActivity::class.java)
        startActivity(moveIntent)
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_employee_list -> {
                showMainActivity()
            }
            R.id.action_about -> {
            }
        }
    }
}
