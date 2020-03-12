package Activites.Calculator.Carbonate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.graduatioapp.R;

import Activites.Calculator.Carbonate.LowP.AnionGap;
import Activites.Calculator.Carbonate.LowP.BicarbonateDeficit;
import Activites.Calculator.Carbonate.LowP.UrineAnionGap;

public class Low extends AppCompatActivity {
Button anionGapB,biDeficitB,urineGapB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low);
        anionGapB=findViewById(R.id.aniongapID);
        biDeficitB=findViewById(R.id.bideficitID);
        urineGapB=findViewById(R.id.urineID);
        anionGapB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Low.this, AnionGap.class));
            }
        });

biDeficitB.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Low.this, BicarbonateDeficit.class));

    }
});

urineGapB.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Low.this, UrineAnionGap.class));
    }
});




    }
}
