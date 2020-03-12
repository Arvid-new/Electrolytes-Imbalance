package Activites.Iron;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.graduatioapp.R;

import Activites.SimpleViewHolder;
import de.blox.graphview.BaseGraphAdapter;
import de.blox.graphview.Graph;
import de.blox.graphview.GraphView;
import de.blox.graphview.Node;
import de.blox.graphview.ViewHolder;
import de.blox.graphview.energy.FruchtermanReingoldAlgorithm;
import de.blox.graphview.layered.SugiyamaAlgorithm;
import de.blox.graphview.layered.SugiyamaConfiguration;
import de.blox.graphview.tree.BuchheimWalkerAlgorithm;
import de.blox.graphview.tree.BuchheimWalkerConfiguration;
import de.blox.treeview.BaseTreeAdapter;
import de.blox.graphview.Node;
import de.blox.treeview.TreeView;

public class IronHypoTree extends AppCompatActivity {
    BaseGraphAdapter<ViewHolder> adapterG;
    BaseTreeAdapter<SimpleViewHolder> adapter1;
    BaseTreeAdapter<SimpleViewHolder> adapter2;
    BaseTreeAdapter<SimpleViewHolder> adapter3;
    BaseTreeAdapter<SimpleViewHolder> adapter4;
    BaseTreeAdapter<SimpleViewHolder> adapter5;
    Node root1;
    Node root2;
    Node root3;
    Node root4;
    Node root5;
    String type;
    TreeView treeView;
    Graph graph;
    GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iron_hypo_tree);
        //treeView=findViewById(R.id.treeView);
            graphView=findViewById(R.id.graphView);
          graph = new Graph();
        Bundle bundle=getIntent().getExtras();
        type=bundle.getString("type");
        final BuchheimWalkerConfiguration configuration = new BuchheimWalkerConfiguration.Builder()
                .setSiblingSeparation(100)
                .setLevelSeparation(300)
                .setSubtreeSeparation(300)
                .setOrientation(BuchheimWalkerConfiguration.ORIENTATION_TOP_BOTTOM)
                .build();
        switch (type){
            case "ed":{
                createEDTree();
                adapterG.setAlgorithm(new BuchheimWalkerAlgorithm(configuration));
                graphView.setAdapter(adapterG);


            }
            break;
            case "causes":{
                createCausesTree();
                adapterG.setAlgorithm(new BuchheimWalkerAlgorithm(configuration));
                graphView.setAdapter(adapterG);
            }
            break;
            case "treatment":{
                createTreatmentTree();
                adapterG.setAlgorithm(new BuchheimWalkerAlgorithm(configuration));
                graphView.setAdapter(adapterG);
            }
        }
    }


    public void createEDTree(){
         adapterG = new BaseGraphAdapter<ViewHolder>(graph) {

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.node, parent, false);
                return new SimpleViewHolder(view);
            }

            @Override
            public void onBindViewHolder(ViewHolder viewHolder, Object data, int position) {
                ((SimpleViewHolder)viewHolder).textView.setText(data.toString());
            }
        };

       Node X=new Node("Evaluation and diagnosis");
        //level 1

        Node A1=new Node("Is it Anemia?");
        Node B1=new Node("Is it iron deficiency anemia?");

        graph.addEdge(X,A1);
        graph.addEdge(X,B1);
        //level 2

        //for parent A1
        Node A2=new Node("Clinical signs and symptoms:\n" +
                "\uF0B7 Fatigue  " +
                "\uF0B7 Headache  " +
                "\uF0B7 Irritability  " +
                "\uF0B7 Exertional dyspnea  " +
                "\uF0B7 Vertigo\n" +
                "\uF0B7 Angina pectoris  " +
                "\uF0B7 Pallor  " +
                "\uF0B7 Dry or rough skin  " +
                "\uF0B7 Blue sclerae");
        graph.addEdge(A1,A2);

        //for parent B1
        Node B2=new Node("Suspected populations");
        graph.addEdge(B1,B2);


        //level 2 has A2 ---- B2

        // level 3

        // for parent A2
        Node A3=new Node("CBC: RBC count Hb and HCT \nAbsolute reticulocyte count \nMCV and MCH");
        graph.addEdge(A2,A3);

        // for parent B2
        Node B3=new Node("1. Anemia without reticulocytosis. 2. Pregnant women. 3. CKD + HD");
        graph.addEdge(B2,B3);


        //level 3 has A3-----B3

        // level 4

        // for parent A3 ----- no children
        //for parent B3
        Node B41=new Node("You may do a trial of iron therapy in:\n" +
                "\uF0B7 Poor resource settings  " +
                "\uF0B7 Young healthy pts\n" +
                "\uF0B7 Heavy menstruation  " +
                "\uF0B7 Pregnancy");
        Node B42=new Node("Iron studies (Serum iron, ferritin,TIBC, transferrin,TSAT)");
       graph.addEdge(B3,B41);
       graph.addEdge(B3,B42);

        //level 4 has B41----B42

        // level 5

        //for parent B41
        Node B511=new Node("Responded");
        Node B512=new Node("No response \n(investigate the reasons for lack of response by seeing the other child)");

        //for parent B42

        Node B52 =new Node("Low Ferritin? \n" +
                "Healthy Patient: Serum ferritin <15 ng/ml? \n" +
                "Patient with co morbidities: serum ferritin < 41 ng/ml?");

        Node B62=new Node("(TSAT) low? (S.Iron/TIBC)*100");
        graph.addEdge(B41,B511);
        graph.addEdge(B41,B512);
        graph.addEdge(B42,B52);
        graph.addEdge(B52,B62);
       Node W=new Node("Iron deficiency confirmed");
        Node W2=new Node("Iron deficiency confirmed ");
        Node W3=new Node("Iron deficiency confirmed  ");
        Node W4=new Node("For very strong suspicion of iron deficiency: \uF0B7sTfR or sTfR-ferritin index." +
                "\n \uF0B7Bone marrow iron stain. \uF0B7Hematology consultationmay be helpful.");
        Node W5=new Node("1.Identify source ofiron loss and/or bloodloss (causes section)\n2.Treat with iron(treatment section)");
        graph.addEdge(B62,W3);
        graph.addEdge(B52,W);
        graph.addEdge(B511,W2);
        graph.addEdge(B62,W4);
        graph.addEdge(W,W5);


    }


    public void createCausesTree(){




        adapterG = new BaseGraphAdapter<ViewHolder>(graph) {

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.node, parent, false);
                return new SimpleViewHolder(view);
            }

            @Override
            public void onBindViewHolder(ViewHolder viewHolder, Object data, int position) {
                ((SimpleViewHolder)viewHolder).textView.setText(data.toString());
            }
        };




        Node A=new Node("Causes");
        Node B=new Node("May be primary");
        Node C=new Node("May be secondary to anemia of chronic disease, anemia with co morbidities");
        Node M=new Node("Inadequate dietary intake");
        Node N=new Node("Blood loss");

        Node O=new Node("Reduced absorption (uncommon)");
        Node D=new Node("Hepatic problem");
        Node E=new Node("Renal Problem");
        Node F=new Node("Treat according to Child-Pugh score ");
        Node L=new Node("Treat with iron (treatment section)");
        Node O2=new Node("Pathological factors");
        Node O1=new Node("Dietary factors");
        Node Q=new Node("Is there overt bleeding?");
        Node P=new Node("Due to malnutrition in poor-resource settings");
        Node R=new Node("yes");
        Node S=new Node("No");
        Node T=new Node("1.Manage the condition.\n" +
                "2.Treat with iron (treatment section)");
        Node U=new Node("Stool analysis");
        Node O3=new Node("Ingestion of heme-iron (in meat, better absorbed)\n" +
                "Ingestion of mineral binding compounds (in whole grains, seeds)\n" +
                "Ingestion of foods high in calcium\n" +
                "Ingestion of acid-lowering foods or medications");
        Node O4=new Node("1. Celiac disease \n2. Atrophic gastritis \n" +
                "3. H. pylori \n 4. Bariatric Surgery");
        Node V=new Node("+ve occult bleeding");
        Node W=new Node("NO occult bleeding");
        Node X=new Node("1. GI endoscopy to investigate the GI disorder\n" +
                " 2. Treat with iron (treatment section)");
        Node Y=new Node("Male patient or postmenopausal woman?");
        Node Z=new Node("yes ");
        Node Z3=new Node("other population");
        Node Z2=new Node("1. GI endoscopy to investigate the GI disorder due to the high likelihood in this population.\n" +
                " 2. Treat with iron (treatment section)");
        Node Z4=new Node("Investigate other causes of iron deficiency anemia");
        Node G=new Node("A");
        Node H=new Node("B");
        Node I=new Node("C");
        Node J=new Node("Don't give Iron");
        Node K=new Node("Treat with Iron(Treatment Section)");
        Node empty=new Node("");
        graph.addEdge(A,B);
        graph.addEdge(A,C);
        graph.addEdge(B,M);
        graph.addEdge(B,N);
        graph.addEdge(B,O);
        graph.addEdge(C,D);
        graph.addEdge(C,E);
        graph.addEdge(M,P);
        graph.addEdge(N,Q);
        graph.addEdge(Q,R);
        graph.addEdge(Q,S);
        graph.addEdge(R,T);
        graph.addEdge(S,U);
        graph.addEdge(U,V);
        graph.addEdge(U,W);
        graph.addEdge(V,X);
        graph.addEdge(W,Y);
        graph.addEdge(Y,Z);
        graph.addEdge(Y,Z3);
        graph.addEdge(Z,Z2);
        graph.addEdge(Z3,Z4);
        graph.addEdge(E,L);
        graph.addEdge(D,F);
        graph.addEdge(F,G);
        graph.addEdge(F,H);
        graph.addEdge(F,I);
        graph.addEdge(G,J);
        graph.addEdge(H,K);
        graph.addEdge(I,empty);
        graph.addEdge(empty,K);




    }
    public void createMonitorTree(){

    }
    public void createTreatmentTree(){
        adapterG = new BaseGraphAdapter<ViewHolder>(graph) {

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.node, parent, false);
                return new SimpleViewHolder(view);
            }

            @Override
            public void onBindViewHolder(ViewHolder viewHolder, Object data, int position) {
                ((SimpleViewHolder)viewHolder).textView.setText(data.toString());
            }
        };


        Node A1=new Node("Treatment");
    Node A2=new Node("According to Transferrin saturation (TSAT)");
    Node A3=new Node("TSAT> 20% and < 30%");
    Node A4=new Node("Give oral iron");
    Node B1=new Node("TSAT< 20%");
    Node B2=new Node("Give IV iron"+"\nRequired IV dose = {(target Hb – actual Hb) * 2.4 * wt} + 500… (2)");
    Node A5=new Node("Products");
    Node B3=new Node("Iron dextran");
    Node B4=new Node("Iron Sucrose");
    Node B6=new Node("1. Sensitivity test: prior to first dose, [25 mg] slow IV over 30 sec.\n 2. Dosing: multiple doses:\n" +
            "\uF0B7 100 mg elemental iron/24 hrs\n" +
            "or \uF0B7 200 mg elemental iron/ 48 hrs\n" +
            "Single dose: 1000 mg elemental iron in 250 mL N.S over 1 hr. Once / month");
Node B5=new Node("1. Sensitivity test: ONLY IF a patient has a history of drug allergies,[25 mg] slow IV push.\n" +
        " 2. Dosing:\n" +
        "or \uF0B7 100 mg elemental iron in 100 ml N.S over 1 hr each 24 hrs\n" +
        "or \uF0B7 200 mg elemental iron in 200 ml N.S over 2 hrs each 48 hrs\n" +
        "or \uF0B7 500 mg elemental iron in 500 ml N.S once / week 3. This product cannot be given IM");
Node B7=new Node(" NOTE: Iron sucrose has been shown to be safe and effective in settings of dialysis\n" +
        ", non-dialysis CKD, IBD, chemotherapy-induced anemia, \n" +
        "the peripartum period, gastric bypass, heavy uterine bleeding and others.");

Node A6=new Node("Ferrous fumarate 33% elemental iron per 100 mg of mineral salt");

Node A7=new Node("Ferrous gluconate 10 to 14% elemental iron per 100 mg of mineral salt");

Node A8=new Node("Ferrous sulfate 20 to 30% elemental iron per 100 mg of mineral salt");

Node A9=new Node("Dose and Adminstration:\n 150 to 200 mg elemental iron DAILY or \n" +
        "ALTERNATE DAY DOSING* for six to eight weeks … up to six months to replete iron stores. " +
        "\n*Alternate-day dosing (taking the iron every other day rather than everyday)." +
        "\n It may result in better iron absorption than daily dosing.");

Node empty=new Node("");
Node Ad=new Node("Dose and Adminstration:\n 150 to 200 mg elemental iron DAILY or \n" +
        "ALTERNATE DAY DOSING* for six to eight weeks … up to six months to replete iron stores.\n" +
        " *Alternate-day dosing (taking the iron every other day rather than everyday)." +
        "\n It may result in better iron absorption than daily dosing.");
Node A10=new Node("Side effects\n" +
        "Metallic taste, nausea, flatulence, constipation,\n" +
        " diarrhea, epigastric distress, and/or vomiting, Itching , black/green or tarry stools");

        graph.addEdge(A1,A2);
        graph.addEdge(A2,A3);
        graph.addEdge(A2,B1);
        graph.addEdge(A3,A4);
        graph.addEdge(B1,B2);
        graph.addEdge(A4,A5);
        graph.addEdge(B2,B3);
        graph.addEdge(B2,B4);
        graph.addEdge(B3,B6);
        graph.addEdge(B4,B5);
        graph.addEdge(B5,B7);
        graph.addEdge(A5,A6);
        graph.addEdge(A5,A7);
        graph.addEdge(A5,A8);
        graph.addEdge(A6,empty);
        graph.addEdge(empty,A9);
        graph.addEdge(A7,A9);
        graph.addEdge(A8,Ad);
        Node empty1=new Node(" ");
        graph.addEdge(A9,empty1);
        graph.addEdge(empty1,A10);
        graph.addEdge(Ad,A10);

    }
    public void createResponseTree(){
        adapter1=new BaseTreeAdapter<SimpleViewHolder>(this,R.layout.node){

            @NonNull
            @Override
            public SimpleViewHolder onCreateViewHolder(View view) {
                return new SimpleViewHolder(view);
            }

            @Override
            public void onBindViewHolder(SimpleViewHolder simpleViewHolder, Object data, int position) {
                simpleViewHolder.textView.setText(data.toString());
            }
        };












    }


}
