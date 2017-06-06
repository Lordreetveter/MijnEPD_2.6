package com.example.floorvanlieshout.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
public static final String EXTRA_PHOTO = "com.example.myfirstapp.BYTE";
    private static final int CAMERA_REQUEST = 1888;
    private boolean menuZichtbaar;
    private Uri photoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuZichtbaar = false;
        photoUri = null;
    }

    public void viewFolders(View view){
        Intent intent = new Intent(this, Folders.class);
        startActivity(intent);
    }

    public void makeMenuVisible(View view) {
        if (!menuZichtbaar) {
            View gallerijButton = findViewById(R.id.buttonNieuweMap);
            View tekstGallerij = findViewById(R.id.textKiesFoto);
            tekstGallerij.setVisibility(View.VISIBLE);
            gallerijButton.setVisibility(View.VISIBLE); //To set visible

            View nieuweFotoButton = findViewById(R.id.buttonNieuweFoto);
            View tekstNieuweFoto = findViewById(R.id.textMaakFoto);
            tekstNieuweFoto.setVisibility(View.VISIBLE);
            nieuweFotoButton.setVisibility(View.VISIBLE); //To set visible

            View notitieButton = findViewById(R.id.buttonNieuweNotitie);
            View tekstNotitie = findViewById(R.id.textMaakNotitie);
            tekstNotitie.setVisibility(View.VISIBLE);
            notitieButton.setVisibility(View.VISIBLE); //To set visible
            View plusButton = findViewById(R.id.floatingActionButton);
            plusButton.setRotation(45);
            menuZichtbaar = true;
        }
        else {
            View gallerijButton = findViewById(R.id.buttonNieuweMap);
            gallerijButton.setVisibility(View.INVISIBLE); //To set visible
            View tekstGallerij = findViewById(R.id.textKiesFoto);
            tekstGallerij.setVisibility(View.INVISIBLE);
            View nieuweFotoButton = findViewById(R.id.buttonNieuweFoto);
            nieuweFotoButton.setVisibility(View.INVISIBLE); //To set visible
            View tekstNieuweFoto = findViewById(R.id.textMaakFoto);
            tekstNieuweFoto.setVisibility(View.INVISIBLE);
            View notitieButton = findViewById(R.id.buttonNieuweNotitie);
            notitieButton.setVisibility(View.INVISIBLE); //To set visible
            View tekstNotitie = findViewById(R.id.textMaakNotitie);
            tekstNotitie.setVisibility(View.INVISIBLE);
            View plusButton = findViewById(R.id.floatingActionButton);
            plusButton.setRotation(0);
            menuZichtbaar = false;
        }
    }

    public void maakFoto(View view){
        dispatchTakePictureIntent();
    }

    private static final int REQUEST_TAKE_PHOTO = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photoFile = null;
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                photoUri = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);

            }
        }
    }

    protected void onActivityResult(int requestCode, int  resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == Activity.RESULT_OK) {
            //Uri photoUri = data.getData();
            //Uri photoUri = (Uri) data.getExtras().get("data");
            Intent nieuwBestandIntent = new Intent(this, bestandAanmaken.class);
            nieuwBestandIntent.putExtra("PICTURE_URI", photoUri.toString());
            startActivity(nieuwBestandIntent);
        }
    }

    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }
}
