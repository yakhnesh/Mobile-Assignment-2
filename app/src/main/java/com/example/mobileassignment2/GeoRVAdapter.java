package com.example.mobileassignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GeoRVAdapter extends RecyclerView.Adapter<GeoRVAdapter.ViewHolder> {

    private ArrayList<GeoModel> geoModelArrayList;
    private Context context;

    public GeoRVAdapter(ArrayList<GeoModel> geoModelArrayList, Context context){
        this.geoModelArrayList = geoModelArrayList;
        this.context = context;
    }
@NonNull
@Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.geo_rv_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      GeoModel model = geoModelArrayList.get(position);
      holder.addressTV.setText(model.getAddress());
      holder.latitudeTV.setText(model.getLatitude());
      holder.longitudeTV.setText(model.getLongitude());
}
@Override
public int getItemCount(){
      return geoModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView addressTV,latitudeTV,longitudeTV;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            addressTV = itemView.findViewById(R.id.idTVAddress);
            latitudeTV = itemView.findViewById(R.id.idTVLatitude);
            longitudeTV = itemView.findViewById(R.id.idTVLongitude);
        }
    }
}
