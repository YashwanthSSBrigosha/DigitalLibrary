package com.example.digitallibrary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>{

    ArrayList<Questions> questionInfo;

    public QuestionAdapter(ArrayList<Questions> questionInfo) {
        this.questionInfo = questionInfo;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_card,parent,false);
        QuestionViewHolder qvh = new QuestionViewHolder(view);
        return qvh;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {

        Questions currentQue = questionInfo.get(position);

        holder.queTitle.setText(currentQue.getTitle());
        holder.queIcon.setImageResource(currentQue.getImgRes());

    }

    @Override
    public int getItemCount() {
        return questionInfo.size();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder{

        ImageView queIcon;
        TextView queTitle;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);

            queIcon = itemView.findViewById(R.id.queIcon);
            queTitle = itemView.findViewById(R.id.queTitle);
        }
    }
}
