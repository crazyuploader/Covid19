package com.github.crazyuploader.covid19.indianStates.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.crazyuploader.covid19.indianStates.IndianStatesData;

public class IndianStatesDataAdapter extends RecyclerView.Adapter<IndianStatesDataAdapter.IndianStatesViewHolder> {

    private final IndianStatesData[] fetched;

    public IndianStatesDataAdapter(IndianStatesData[] fetched) {
        this.fetched = fetched;
    }

    @NonNull
    @Override
    public IndianStatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull IndianStatesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return fetched.length;
    }

    public class IndianStatesViewHolder extends RecyclerView.ViewHolder {
        public IndianStatesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
