package id.putraprima.skorbola;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 2;

    public static final String HOMENAME_KEY = "homename";
    public static final String AWAYNAME_KEY = "awayname";

    private ImageView avatarImage, avatarImage2;
    private EditText inputHome, inputAway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputHome = findViewById(R.id.home_team);
        inputAway = findViewById(R.id.away_team);
        avatarImage = findViewById(R.id.home_logo);
        avatarImage2 = findViewById(R.id.away_logo);

        //TODO
        //Fitur Main Activity
        //1. Validasi Input Home Team
        //2. Validasi Input Away Team
        //3. Ganti Logo Home Team
        //4. Ganti Logo Away Team
    }
    //5. Next Button Pindah Ke MatchActivity
    public void handleNext(View view) {
        String homeText = inputHome.getText().toString();
        String awayText = inputAway.getText().toString();

        if(!(homeText).equals("") && !(awayText).equals("")){
            Intent intent = new Intent(this,MatchActivity.class);
            intent.putExtra(HOMENAME_KEY, homeText);
            intent.putExtra(AWAYNAME_KEY, awayText);;
            startActivity(intent);
        }else{
            Toast.makeText(this, "Tolong Isi Nama Tim yang Kosong !",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            return;
        }

        if (requestCode == GALLERY_REQUEST_CODE) {
            if (data != null) {
                try {
                    Uri imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    avatarImage.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }

    public void handleImage1(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    public void handleImage2(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }
}
