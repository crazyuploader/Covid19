package com.example.covid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private Context context;
    private Data[] fetched;
    public DataAdapter(Context context, Data[] data)
    {
        this.context = context;
        this.fetched = data;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.country_data_layout, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Data country = fetched[position];
        holder.countryName.setText(country.getCountry());
        holder.countryTotalCases.setText(country.getCases().toString());
        holder.countryTotalDeaths.setText(country.getDeaths().toString());
        //Glide.with(holder.countryFlag.getContext()).load(country.getCountryInfo().getFlag()).into(holder.countryFlag);
    }

    @Override
    public int getItemCount() {
        return fetched.length;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        TextView countryName;
        TextView countryTotalCases;
        TextView countryTotalDeaths;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            countryName = itemView.findViewById(R.id.countryName);
            countryTotalCases = itemView.findViewById(R.id.countryTotalCases);
            countryTotalDeaths = itemView.findViewById(R.id.countryTotalDeaths);

        }
    }
}
