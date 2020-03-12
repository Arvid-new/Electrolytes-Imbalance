package Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.graduatioapp.R;

import Activites.Calculator.Carbonate.HighP.HighBiCarbonate;
import Activites.Calculator.Iron.TranseferrinSaturation;
import Activites.Calculator.Sodium.LowS.SerumOsmolality;
import Activites.Calculator.Sodium.LowS.SodiumDeficit;

import Trees.IronHyper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RadioGroup radioGroup;

    RadioButton radioButton;
    private Button ironB;
    private Button calciumB;
    private Button phosphateB;
    private Button magnesiumB;
    private Button sodiumB;
    private Button biB;
    private Button potassiumB;
    String radio="none";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //startActivity(new Intent(MainActivity.this, SodiumDeficit.class));
        setContentView(R.layout.activity_main);
radioGroup=findViewById(R.id.radioGroupID);
ironB=findViewById(R.id.ironID);
        calciumB=findViewById(R.id.calciumID);
        phosphateB=findViewById(R.id.phosphateID);
        magnesiumB=findViewById(R.id.magnesiumID);
        sodiumB=findViewById(R.id.sodiumID);
        biB=findViewById(R.id.biID);
        potassiumB=findViewById(R.id.potassiumID);
        findViewById(R.id.radioGroupID);
        //// Setting On click Listeners

        ironB.setOnClickListener(this);
        biB.setOnClickListener(this);
        calciumB.setOnClickListener(this);
        phosphateB.setOnClickListener(this);
        magnesiumB.setOnClickListener(this);
        sodiumB.setOnClickListener(this);
       potassiumB.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton=findViewById(checkedId);
                switch (radioButton.getId()) {
                    case R.id.hyperID:
                        radio = "hyper";


                        break;
                    case R.id.hypoID:
                        radio = "hypo";
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.ironID:
                openIron();
                break;
            case R.id.calciumID:
                openCa();
                break;
            case R.id.magnesiumID:
                openMg();
                break;
            case R.id.biID:
                openHCO3();
                break;
            case R.id.sodiumID:
                openNa();
                break;
            case R.id.phosphateID:
                openPO4();
                break;
            case R.id.potassiumID:
                 openK();
                 break;


        }

    }


    public void openIron(){
        final Intent intent = new Intent(MainActivity.this, IronHyper.class);

        if (!radio.equals("none")){
            String s="fe"+radio+".pdf";
            intent.putExtra("tree", s);
            startActivity(intent);

        }else
            Toast.makeText(this, "please choose a type!", Toast.LENGTH_SHORT).show();

    }

    public void openHCO3(){
        final Intent intent = new Intent(MainActivity.this, IronHyper.class);

        if (!radio.equals("none")){
            String s="hco3"+radio+".pdf";
            intent.putExtra("tree", s);
            startActivity(intent);

        }else
            Toast.makeText(this, "please choose a type!", Toast.LENGTH_SHORT).show();

    }



    public void openCa(){
        final Intent intent = new Intent(MainActivity.this, IronHyper.class);

        if (!radio.equals("none")){
            String s="ca"+radio+".pdf";
            intent.putExtra("tree", s);
            startActivity(intent);

        }else
            Toast.makeText(this, "please choose a type!", Toast.LENGTH_SHORT).show();

    }

    public void openK(){
        final Intent intent = new Intent(MainActivity.this, IronHyper.class);

        if (!radio.equals("none")){
            String s="khyperhypo.pdf";
            intent.putExtra("tree", s);
            startActivity(intent);

        }else
            Toast.makeText(this, "please choose a type!", Toast.LENGTH_SHORT).show();

    }

    public void openNa(){
        final Intent intent = new Intent(MainActivity.this, IronHyper.class);

        if (!radio.equals("none")){
            String s="na"+radio+".pdf";
            intent.putExtra("tree", s);
            startActivity(intent);

        }else
            Toast.makeText(this, "please choose a type!", Toast.LENGTH_SHORT).show();

    }


    public void openPO4(){
        final Intent intent = new Intent(MainActivity.this, IronHyper.class);

        if (!radio.equals("none")){
            String s="po4"+radio+".pdf";
            intent.putExtra("tree", s);
            startActivity(intent);

        }else
            Toast.makeText(this, "please choose a type!", Toast.LENGTH_SHORT).show();

    }


    public void openMg(){
        final Intent intent = new Intent(MainActivity.this, IronHyper.class);

        if (!radio.equals("none")){
            String s="mghyperhypo.pdf";
            intent.putExtra("tree", s);
            startActivity(intent);

        }else
            Toast.makeText(this, "please choose a type!", Toast.LENGTH_SHORT).show();

    }


}
