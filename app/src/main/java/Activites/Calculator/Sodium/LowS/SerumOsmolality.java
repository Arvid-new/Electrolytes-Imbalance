package Activites.Calculator.Sodium.LowS;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.graduatioapp.R;

public class SerumOsmolality extends AppCompatActivity {
EditText serumSodiumE;
    EditText potassiumSodiumE;
    EditText ureaNitrogenE;
    EditText glucoseserum;
    Button calculate;
    TextView resultText;
    Double ss,ps,un,gs,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serum_osmolality);
        serumSodiumE=findViewById(R.id.serumsodiumID);
        potassiumSodiumE=findViewById(R.id.serumpotassiumID);
        ureaNitrogenE=findViewById(R.id.ureanitrogenID);
        calculate=findViewById(R.id.calcID);
        resultText=findViewById(R.id.resultID);
        glucoseserum=findViewById(R.id.serumglucoseID);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(serumSodiumE.getText().toString().equals("")||ureaNitrogenE.getText().toString().equals("")
                ||ureaNitrogenE.getText().toString().equals("")|| glucoseserum.getText().toString().equals("")))
                    calculate();
            }
        });
    }
    public void calculate(){
        ss=Double.parseDouble(serumSodiumE.getText().toString());
        ps=Double.parseDouble(potassiumSodiumE.getText().toString());
        un=Double.parseDouble(ureaNitrogenE.getText().toString());
        gs=Double.parseDouble(glucoseserum.getText().toString());
        result=(2*(ss+ps))+(gs/18)+(un/2.8);
        String s="Serum Osmolality = "+result+" mOsm/Kg\n\n"+"(Normal adult osmolality = 285 - 295 mOsm/Kg)\n\n(Normal child osmolality = " +
                "275 - 290)";
        resultText.setText(s);


    }
}
