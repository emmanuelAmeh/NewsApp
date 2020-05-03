package com.example.android.newsapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * The part of the publication date string from the Guardian service that we use to determine
     * Only the date and not the time of publication
     */
    private static final String DATE_SEPARATOR = "T";
    private static final String TIME_SEPARATOR = "Z";

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context  of the app
     * @param newsList is the list of earthquakes, which is the data source of the adapter
     */
    public NewsAdapter(@NonNull Context context, @NonNull List<News> newsList) {
        super(context, 0, newsList);
    }

    /**
     * Returns a list item view that displays information about the news at the given position
     * in the newsList.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the news at the given position in the newsList
        News currentNews = getItem(position);

        //finding views
        TextView tvSection = listItemView.findViewById(R.id.section);
        TextView tvTitle = listItemView.findViewById(R.id.title);
        TextView tvAuthor = listItemView.findViewById(R.id.author);
        TextView tvPublicationDate = listItemView.findViewById(R.id.date);
        TextView tvPublicationTime = listItemView.findViewById(R.id.time);

        //linking views
        tvSection.setText(currentNews.getSectionName());
        tvTitle.setText(currentNews.getTitle());
        //tvPublicationDate.setText(currentNews.getPublicationDate());

        //linking author
        Boolean hasAuthor = currentNews.getAuthor() != null;



        if (hasAuthor) {
            tvAuthor.setText(currentNews.getAuthor());
        } else {
            tvAuthor.setText(parent.getResources().getString(R.string.unknown_author));
        }


        // Get the original date string from the News object,
        String originalDate = currentNews.getPublicationDate();

        // Check whether the original Date string contains the "T" text
        if (originalDate.contains(DATE_SEPARATOR)) {
            // Split the string into different parts (as an array of Strings)
            // based on the "T" text. We expect an array of 2 Strings, where
            String[] parts = originalDate.split(DATE_SEPARATOR);
            // Date should not contain time element
            tvPublicationDate.setText(parts[0]);

            //For time
            String timeSubString = parts[1].replace(TIME_SEPARATOR, "");
            tvPublicationTime.setText(timeSubString);



        } else {
            Log.i("News Adapter", "no date element in Guardian response");
        }

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
