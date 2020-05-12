package com.github.crazyuploader.covid19.indianStates.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.crazyuploader.covid19.R;
import com.github.crazyuploader.covid19.indianStates.IndianStatesData;
import com.github.crazyuploader.covid19.misc.Format;

public class IndianStatesDataAdapter
    extends RecyclerView
                .Adapter<IndianStatesDataAdapter.IndianStatesViewHolder> {

  private final IndianStatesData[] fetched;
  public IndianStatesDataAdapter(IndianStatesData[] fetched) {
    this.fetched = fetched;
  }

  @NonNull
  @Override
  public IndianStatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                   int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.indian_states_layout, parent, false);
    view.setBackgroundColor(0);
    return new IndianStatesViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull IndianStatesViewHolder holder,
                               int position) {

    IndianStatesData state = fetched[position];
    holder.indianStateName.setText(state.getLoc());
    holder.indianStateConfirmed.setText(
        Format.number(state.getTotalConfirmed()));
    holder.indianStateDischarged.setText(Format.number(state.getDischarged()));
    holder.indianStateDeaths.setText(Format.number(state.getDeaths()));
  }

  @Override
  public int getItemCount() {
    return fetched.length;
  }

  public static class IndianStatesViewHolder extends RecyclerView.ViewHolder {
    final TextView indianStateName;
    final TextView indianStateConfirmed;
    final TextView indianStateDischarged;
    final TextView indianStateDeaths;
    public IndianStatesViewHolder(@NonNull View itemView) {
      super(itemView);

      indianStateName = itemView.findViewById(R.id.indianStateName);
      indianStateConfirmed = itemView.findViewById(R.id.indianStateConfirmed);
      indianStateDischarged = itemView.findViewById(R.id.indianStateDischarged);
      indianStateDeaths = itemView.findViewById(R.id.indianStateDeaths);
    }
  }
}
