package com.github.crazyuploader.covid19;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.crazyuploader.covid19.R;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private final Data[] fetched;
    public DataAdapter(Data[] data)
    {
        this.fetched = data;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.country_data_layout, parent, false);
        view.setBackgroundColor(0);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Data country = fetched[position];
        holder.countryName.setText(country.getCountry());
        holder.countryTotalCases.setText(country.getCases().toString());
        holder.countryTotalDeaths.setText(country.getDeaths().toString());
        holder.countryRecovered.setText(country.getRecovered().toString());
        //Glide.with(holder.countryFlag.getContext()).load(country.getCountryInfo().getFlag()).into(holder.countryFlag);
    }

    @Override
    public int getItemCount() {
        return fetched.length;
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        TextView countryName;
        TextView countryTotalCases;
        TextView countryTotalDeaths;
        TextView countryRecovered;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            countryName = itemView.findViewById(R.id.countryName);
            countryTotalCases = itemView.findViewById(R.id.countryTotalCases);
            countryTotalDeaths = itemView.findViewById(R.id.countryTotalDeaths);
            countryRecovered = itemView.findViewById(R.id.countryRecovered);

        }
    }
}
