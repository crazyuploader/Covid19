package com.github.crazyuploader.covid19.globalData.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.crazyuploader.covid19.R;
import com.github.crazyuploader.covid19.globalData.Data;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private final onCountryClickListener onCountryClickListener;
    private final Data[] fetched;
    public DataAdapter(Data[] data, onCountryClickListener onCountryClickListener)
    {
        this.fetched = data;
        this.onCountryClickListener = onCountryClickListener;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.country_data_layout, parent, false);
        view.setBackgroundColor(0);
        return new DataViewHolder(view, onCountryClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Data country = fetched[position];
        holder.countryName.setText(country.getCountry());
        holder.countryTotalCases.setText(country.getCases().toString());
        holder.countryTotalDeaths.setText(country.getDeaths().toString());
        holder.countryRecovered.setText(country.getRecovered().toString());
        holder.countryTodayCases.setText("(+" + country.getTodayCases().toString()+ " new)");
        holder.countryTodayDeaths.setText("(+" + country.getTodayDeaths().toString()+ " new)");
        //Glide.with(holder.countryFlag.getContext()).load(country.getCountryInfo().getFlag()).into(holder.countryFlag);
    }

    @Override
    public int getItemCount() {
        return fetched.length;
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final TextView countryName;
        final TextView countryTotalCases;
        final TextView countryTotalDeaths;
        final TextView countryRecovered;
        final TextView countryTodayCases;
        final TextView countryTodayDeaths;
        final onCountryClickListener onCountryClickListener;

        public DataViewHolder(@NonNull View itemView, onCountryClickListener listener) {
            super(itemView);

            countryName = itemView.findViewById(R.id.countryName);
            countryTotalCases = itemView.findViewById(R.id.countryTotalCases);
            countryTotalDeaths = itemView.findViewById(R.id.countryTotalDeaths);
            countryRecovered = itemView.findViewById(R.id.countryRecovered);
            countryTodayCases = itemView.findViewById(R.id.countryTodayCases);
            countryTodayDeaths = itemView.findViewById(R.id.countryTodayDeaths);
            onCountryClickListener = listener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onCountryClickListener.onCountryClick(countryName.getText());

        }
    }

    public interface onCountryClickListener{
        void onCountryClick(CharSequence countryName);
    }
}
