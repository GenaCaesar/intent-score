package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static id.putraprima.skorbola.MainActivity.AWAYNAME_KEY;
import static id.putraprima.skorbola.MainActivity.HOMENAME_KEY;

public class MatchActivity extends AppCompatActivity {

    private static final String HASIL_KEY = "results";
    private TextView namaHome;
    private TextView namaAway;
    private TextView scoreHome;
    private TextView scoreAway;
    private int hasilHome=0, hasilAway=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        namaHome = findViewById(R.id.txt_home);
        namaAway = findViewById(R.id.txt_away);
        scoreHome = findViewById(R.id.score_home);
        scoreAway = findViewById(R.id.score_away);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // TODO: display value here
            namaHome.setText(extras.getString("homename"));
            namaAway.setText(extras.getString("awayname"));
        }

        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }

    public void handleHomeScore(View view) {
        hasilHome++;
        scoreHome.setText(String.valueOf(hasilHome));
    }

    public void handleAwayScore(View view) {
        hasilAway++;
        scoreAway.setText(String.valueOf(hasilAway));
    }

    public void handleCek(View view) {
        String hasilTanding;
        Intent intent =  new Intent(this, ResultActivity.class);

        if(hasilHome > hasilAway){
            hasilTanding = namaHome.getText().toString() + " Menang, Congratulations !";
        }else if(hasilHome < hasilAway) {
            hasilTanding = namaAway.getText().toString() + " Menang, Congratulations !";
        }
        else{
            hasilTanding = "Pertandingan Seri";
        }
        intent.putExtra(HASIL_KEY, hasilTanding);
        startActivity(intent);
    }
}
