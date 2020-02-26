package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static id.putraprima.skorbola.MainActivity.AWAYNAME_KEY;
import static id.putraprima.skorbola.MainActivity.HOMENAME_KEY;

public class MatchActivity extends AppCompatActivity {

    private TextView homeTim, awayTim, angkaHome, angkaAway;
    private int nilaiHome=0, nilaiAway=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        homeTim = findViewById(R.id.txt_home);
        awayTim = findViewById(R.id.txt_away);
        angkaHome = findViewById(R.id.score_home);
        angkaAway = findViewById(R.id.score_away);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // TODO: display value here
            homeTim.setText(extras.getString(HOMENAME_KEY));
            awayTim.setText(extras.getString(AWAYNAME_KEY));
        }

        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }

    public void handleCek(View view) {
        String score;

        Intent intent =  new Intent(this, ResultActivity.class);

        if(nilaiHome > nilaiAway){
            score = angkaHome.getText().toString() + " Is Winner";
        }else if(nilaiHome < nilaiAway) {
            score = angkaAway.getText().toString() + " Is Winner";
        }
        else{
            score = " Is Draw";
        }
        startActivity(intent);
    }

    public void handleHomeScore(View view) {
        nilaiHome++;
        angkaHome.setText(String.valueOf(nilaiHome));

    }

    public void handleAwayScore(View view) {
        nilaiAway++;
        angkaAway.setText(String.valueOf(nilaiAway));
    }


}
