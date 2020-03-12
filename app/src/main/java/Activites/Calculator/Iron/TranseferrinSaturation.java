package Activites.Calculator.Iron;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.graduatioapp.R;

public class TranseferrinSaturation extends AppCompatActivity {
    EditText serumIronE;
    EditText tibcE;

    Button calc;
    TextView resultText;
    double serumIron,tibc,result,bodyWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transeferrin_saturation);

        serumIronE=findViewById(R.id.serumIronID);
        tibcE=findViewById(R.id.tibcID);
        calc=findViewById(R.id.calcID);
        resultText=findViewById(R.id.resultID);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(serumIronE.getText().toString().equals("") ||tibcE.getText().toString().equals("")))
                    calculate();
            }
        });


    }


    public void calculate(){
        serumIron=Double.parseDouble(serumIronE.getText().toString());
        tibc=Double.parseDouble(tibcE.getText().toString());
        result=(serumIron/tibc)*100;
        String string="TSAT % = "+String.format("%.2f",result)+"%" +"\n(Normal Male TSAT= 15 - 50%)\n"+"(Normal fEMale TSAT= 12 - 45%)";
        resultText.setText(string);

    }
}
