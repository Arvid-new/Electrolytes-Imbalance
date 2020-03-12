package Activites.Calculator.Sodium.LowS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.graduatioapp.R;

public class LowS extends AppCompatActivity {
Button correctedSodium,serumOsmolality,sodiumDeficit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_s);

        correctedSodium=findViewById(R.id.correctedsodiumID);
        serumOsmolality=findViewById(R.id.serumosmolalityID);
        sodiumDeficit=findViewById(R.id.sodiumdeficitID);
        correctedSodium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LowS.this,CorrectedSodium.class));
            }
        });

        serumOsmolality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LowS.this,SerumOsmolality.class));
            }
        });

        sodiumDeficit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LowS.this,SodiumDeficit.class));
            }
        });

    }
}
