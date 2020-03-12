package Activites.Calculator.Sodium.LowS;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.graduatioapp.R;

public class SodiumDeficit extends AppCompatActivity {
    String s;
   private EditText categoryE;
    private EditText bodyWeightE;
    private EditText desiredSodiumE;
    private EditText actualSodiumE;
    Button calculate;
    TextView bodyWaterText,sodiumDeficitText,amountOfSodiumText,infusionRateText,infusionTimeText;
    double category,bodyWeight,desiredSodium,actualSodium,totalBodyWater,sodiumDeficit,amountOfSodium,infusionRate,totalInfusion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sodium_deficit);
        categoryE=findViewById(R.id.categoryID);
        bodyWeightE=findViewById(R.id.bodyweightID);
        desiredSodiumE=findViewById(R.id.desiredsodiumID);
        actualSodiumE=findViewById(R.id.actualsodiumID);
        calculate=findViewById(R.id.calcID);
        bodyWaterText=findViewById(R.id.textView9);
        sodiumDeficitText=findViewById(R.id.textView10);
        amountOfSodiumText=findViewById(R.id.textView11);
        infusionRateText=findViewById(R.id.textView12);
        infusionTimeText=findViewById(R.id.textView13);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(categoryE.getText().toString().equals("")||bodyWeightE.getText().toString().equals("")||
                desiredSodiumE.getText().toString().equals("")||actualSodiumE.getText().toString().equals("")))
                  calculate();
                    Log.d("TAG", "onClick: ");
            }
        });

    }
    public void calculate(){
        category=Double.parseDouble(categoryE.getText().toString());
        bodyWeight=Double.parseDouble(bodyWeightE.getText().toString());
        desiredSodium=Double.parseDouble(desiredSodiumE.getText().toString());
        actualSodium=Double.parseDouble(actualSodiumE.getText().toString());
        totalBodyWater=bodyWeight*category;
        sodiumDeficit=totalBodyWater*(desiredSodium-actualSodium);
        amountOfSodium=totalBodyWater*0.5;
        infusionRate=(totalBodyWater*0.5*1000)/513;
        totalInfusion=sodiumDeficit/infusionRate;
        s="Total Body water = "+totalBodyWater+" L";
        bodyWaterText.setText(s);
        s="Sodium deficit = "+ sodiumDeficit+" mEq/L";
        sodiumDeficitText.setText(s);
        s="Amount of Na needed to increase\nserum Na by 0.5 mEq/L/hr =  "+amountOfSodium+ " mEq/L";
        amountOfSodiumText.setText(s);
        s="Infusion Rate of Hypertonic saline Solution = "+infusionRate+" mL/hr";
        infusionRateText.setText(s);
        s="Total Infusion Time = "+totalInfusion+" hr(s)";
        infusionTimeText.setText(s);



    }
}
