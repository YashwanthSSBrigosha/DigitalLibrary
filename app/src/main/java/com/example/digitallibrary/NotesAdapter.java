package com.example.digitallibrary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> implements Filterable {

    ArrayList<Notes> notesInfo;
    ArrayList<Notes> notesInfoFull;

    public NotesAdapter(ArrayList<Notes> notesInfo) {
        this.notesInfo = notesInfo;
        notesInfoFull = new ArrayList<>(notesInfo);
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_card,parent,false);
        NotesViewHolder nvh = new NotesViewHolder(view);

        return nvh;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

        Notes currentNote = notesInfo.get(position);

        holder.notesTitle.setText(currentNote.getTitle());
        holder.notesIcon.setImageResource(currentNote.getImgRes());

    }

    @Override
    public int getItemCount() {
        return notesInfo.size();
    }

    @Override
    public Filter getFilter() {
        return notesFilter;
    }

    private Filter notesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Notes> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(notesInfoFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Notes note:notesInfoFull
                     ) {
                    if (note.getTitle().toLowerCase().contains(filterPattern)){
                        filteredList.add(note);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            notesInfo.clear();
            notesInfo.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

    public class NotesViewHolder extends RecyclerView.ViewHolder{

        ImageView notesIcon;
        TextView notesTitle;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            notesIcon = itemView.findViewById(R.id.notesIcon);
            notesTitle = itemView.findViewById(R.id.notesTitle);
        }
    }
}
