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
import androidx.core.content.ContextCompat
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
            openLocation()
        }
        binding.shareButton.setOnClickListener {
            shareText()
        }
        binding.takePhotoButton.setOnClickListener {
            takePhoto()
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

    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(
                this,
                permission
            ) == PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        } else {
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show()
        }
    }

    private fun takePhoto() {

        checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this address!")
        }
    }

    companion object {
        const val CAMERA_PERMISSION_CODE = 1
    }
}