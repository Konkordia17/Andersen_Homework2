package com.example.andersen_homework2.lesson2

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ShareCompat
import com.example.andersen_homework2.databinding.ActivityImplicitsIntentsBinding

class ImplicitIntentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImplicitsIntentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImplicitsIntentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.wedsiteButton.setOnClickListener {
            openWebsite()
        }
        binding.locButton.setOnClickListener {
            checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION,
                { openLocation() }, LOCATION_PERMISSION_CODE)
        }
        binding.shareButton.setOnClickListener {
            shareText()
        }
        binding.takePhotoButton.setOnClickListener {
            checkPermission(Manifest.permission.CAMERA, { takePhoto() }, PERMISSION_CODE)
        }
    }

    private fun openWebsite() {
        val url = binding.wedsiteEditText.text.toString()
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this uri!")
        }
    }

    private fun openLocation() {

        val loc = binding.locEditText.text.toString()
        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this address!")
        }
    }

    private fun shareText() {
        val text = binding.shareEditText.text.toString()
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle("Share this text with: ")
            .setText(text)
            .startChooser()
    }

    private fun checkPermission(permission:String, function:()->Unit, code: Int) {
        val isPermissionGranted = ActivityCompat.checkSelfPermission(
            this, permission
        ) == PackageManager.PERMISSION_GRANTED
        if (isPermissionGranted) {
            function()
        } else {
            requestPermission(permission, code)
        }
    }

    private fun requestPermission(permission: String, code:Int) {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(permission), code
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }){
            if(requestCode== PERMISSION_CODE){
                takePhoto()
            } else {
                openLocation()
            }
        } else{
            Toast.makeText(this, "измените настройки", Toast.LENGTH_SHORT).show()
        }
    }

    private fun takePhoto() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this address!")
        }
    }

    companion object {
        const val PERMISSION_CODE = 5
        const val LOCATION_PERMISSION_CODE = 2
    }
}