package com.zisal.jelling;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tripoin.tripoin_rest.dto.response.location.DTOResponseLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 10/21/2016 : 5:25 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ForceAdapter extends ArrayAdapter<DTOResponseLocation> {

    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<DTOResponseLocation> items;

    public ForceAdapter(Context context, int resource, List<DTOResponseLocation> objects) {
        super(context, resource, objects);
        mContext = context;
        items = (ArrayList<DTOResponseLocation>) objects;
    }

    public ForceAdapter(Context context, List<DTOResponseLocation> dtoResponseLocations) {
        super(context, 0, dtoResponseLocations);
        mContext = context;
        items = (ArrayList<DTOResponseLocation>) dtoResponseLocations;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DTOResponseLocation dtoResponseLocation = getItem(position);
        ViewHolder holder;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {

            // 2
            convertView = mInflater.inflate(R.layout.item_force, parent, false);

            // 3
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.txtForceName);
            holder.txtImei = (TextView) convertView.findViewById(R.id.txtForceImei);

            convertView.setTag(holder);
        }
        else{
            // 5
            holder = (ViewHolder) convertView.getTag();
        }
        // Lookup view for data population
        TextView txtForceName = holder.txtName;
        TextView txtForceImei = holder.txtImei;

        txtForceName.setText(dtoResponseLocation.getName());
        try {
            txtForceImei.setText(dtoResponseLocation.getImeiNumber());
        }catch (Exception e){e.printStackTrace();}

        // Return the completed view to render on screen
        return convertView;
    }

    private static class ViewHolder {
        public TextView txtName;
        public TextView txtImei;
    }
}
