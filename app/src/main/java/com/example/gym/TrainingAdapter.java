package com.example.gym;

import static com.example.gym.TrainingActivity.TRAINING_KEY;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.ViewHolder> {

    public static final String TAG = "TrainingAdapter";

    private ArrayList<Training> trainings = new ArrayList<>();
    private Context context;

    public TrainingAdapter (Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");

        //setting up data in my cardView
        holder.textName.setText(trainings.get(position).getName());
        holder.textDescription.setText(trainings.get(position).getShortDescription());
        Glide.with(context)
                .asBitmap()
                .load(trainings.get(position).getImageURL())
                .into(holder.image);

        //creating an onclick listener for the cardView
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2023/04/20  Navigate the user
                Intent intent = new Intent(context, TrainingActivity.class);
                intent.putExtra(TRAINING_KEY,trainings.get(holder.getBindingAdapterPosition()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }

    public void setTrainings(ArrayList<Training> trainings) {
        this.trainings = trainings;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView parent;
        private ImageView image;
        private TextView textName, textDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.parent);
            image = itemView.findViewById(R.id.image);
            textName = itemView.findViewById(R.id.textName);
            textDescription = itemView.findViewById(R.id.textDescription);
        }
    }
}
