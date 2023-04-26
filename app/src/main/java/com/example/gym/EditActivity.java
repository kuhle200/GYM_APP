package com.example.gym;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements PlanAdapter.RemovePlan {

    private TextView txtDay;
    private RecyclerView recyclerView;
    private Button btnAddPlan;

    private PlanAdapter planAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        initialViews();
        planAdapter = new PlanAdapter(this);
        planAdapter.setType("edit");
        recyclerView.setAdapter(planAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        if(intent != null){
             String day = intent.getStringExtra("day");
             if(null != day){
                 txtDay.setText(day);

                 ArrayList<Plan> plans = getPlanByDay(day);
                 planAdapter.setPlans(plans);

             }
        }

        btnAddPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPlanIntent = new Intent(EditActivity.this, AllTrainingsActivity.class);
                startActivity(addPlanIntent);
            }
        });
    }

    private ArrayList<Plan> getPlanByDay(String day){
        ArrayList<Plan> allPlans = Utils.getPlans();
        ArrayList<Plan> plans = new ArrayList<>();

        for(Plan p: allPlans){
            if(p.getDay().equalsIgnoreCase(day)){
                plans.add(p);
            }

        }

        return plans;
    }

    private void initialViews(){
        Log.d(TAG, "initial views called");
        txtDay = findViewById(R.id.txtDay);
        recyclerView = findViewById(R.id.recyclerViewEd);
        btnAddPlan = findViewById(R.id.addMoreButton);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        super.onBackPressed();
    }

    @Override
    public void onRemovePlanResults(Plan plan) {
        if(Utils.removePlan(plan)){
            Toast.makeText(this, "Training Removed Successfully", Toast.LENGTH_SHORT).show();
           planAdapter.setPlans(getPlanByDay(plan.getDay()));
        }
    }
}