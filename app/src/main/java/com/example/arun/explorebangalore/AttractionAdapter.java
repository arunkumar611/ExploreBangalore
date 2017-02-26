package com.example.arun.explorebangalore;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by Arun on 2/24/2017.
 */

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    private int mColorResourceId;

    public AttractionAdapter(Context context, ArrayList<Attraction> attraction, int colorResourceId) {
        super(context, 0, attraction);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.attraction_list, parent, false);
        }

        Attraction currentAttraction = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentAttraction.getImageResourceId());

        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentAttraction.getTitleId());

        TextView descriptionView = (TextView) listItemView.findViewById(R.id.description);
        descriptionView.setText(currentAttraction.getDescriptionId());

        View textContainer = listItemView.findViewById(R.id.details_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        final int link = currentAttraction.getLinkId();

        ImageView linkView = (ImageView) listItemView.findViewById(R.id.link);
        linkView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent openLink = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(getContext().getString(link)));
                getContext().startActivity(openLink);
            }
        });

        final int location = currentAttraction.getLocationId();

        ImageView locationView = (ImageView) listItemView.findViewById(R.id.location);
        locationView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent openLocation = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(getContext().getString(location)));
                getContext().startActivity(openLocation);
            }
        });

        return listItemView;
    }

}
