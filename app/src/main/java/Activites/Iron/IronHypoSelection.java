package Activites.Iron;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.graduatioapp.R;

import Activites.MainActivity;

public class IronHypoSelection extends AppCompatActivity implements View.OnClickListener {
private AlertDialog.Builder builder;
private Button responseB;
private Button edB;
private Button causesB;
private Button treatmentB;
private Button monitorB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iron_hypo_selection);
        responseB=findViewById(R.id.responseID);
        edB=findViewById(R.id.edID);
        causesB=findViewById(R.id.causesID);
        treatmentB=findViewById(R.id.treatmentID);
        monitorB=findViewById(R.id.monitorID);
        responseB.setOnClickListener(this);
        edB.setOnClickListener(this);
        causesB.setOnClickListener(this);
        treatmentB.setOnClickListener(this);
        monitorB.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.responseID:{
                builder=new AlertDialog.Builder(IronHypoSelection.this);
                builder.setTitle("Response note");
                builder.setCancelable(false);
                builder.setMessage("Approaches to lack of response:\n" +
                        "●Patient not taking oral iron (e.g. due to side effects) (compliance)\n" +
                        "●Reduced absorption of oral iron\n" +
                        "●Blood loss exceeds iron intake\n" +
                        "●Incorrect initial diagnosis\n" +
                        "●More than one diagnosis (especially relevant in older adults)\n" +
                        "●Inflammatory state with block in intestinal iron regulation (sepsis)\n" +
                        "●Therapy was effective but bleeding recurred.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(IronHypoSelection.this,IronHypoTree.class);
                        intent.putExtra("type","response");
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Return", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("TAG", "onClick: sa7 kda");
                        dialog.cancel();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
            break;
            case R.id.causesID:{
                Intent intent=new Intent(IronHypoSelection.this,IronHypoTree.class);
                intent.putExtra("type","causes");
                startActivity(intent);
            }
            break;
            case R.id.edID:{
                Intent intent=new Intent(IronHypoSelection.this,IronHypoTree.class);
                intent.putExtra("type","ed");
                startActivity(intent);
            }
            break;
            case R.id.treatmentID:{
                Intent intent=new Intent(IronHypoSelection.this,IronHypoTree.class);
                intent.putExtra("type","treatment");
                startActivity(intent);
            }
            break;

        }
    }
}
