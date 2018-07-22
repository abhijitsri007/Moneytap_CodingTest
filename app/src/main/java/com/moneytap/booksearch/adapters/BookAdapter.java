package com.moneytap.booksearch.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.android.booksearch.R;
import com.moneytap.booksearch.models.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Abhijit on 21/07/18.
 */

public class BookAdapter extends ArrayAdapter<Book> {
    // View lookup cache
    private static class ViewHolder {
        public ImageView ivCover;
        public TextView tvTitle;
        public TextView tvAuthor;
    }

    public BookAdapter(Context context, ArrayList<Book> aBooks) {
        super(context, 0, aBooks);
    }

    // Translates a particular `Book` given a position
    // into a relevant row within an AdapterView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Book book = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_book, parent, false);
            viewHolder.ivCover = (ImageView)convertView.findViewById(R.id.ivBookCover);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
            viewHolder.tvAuthor = (TextView)convertView.findViewById(R.id.tvAuthor);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.tvTitle.setText(String.valueOf(book.getQuery().getPages().get(0).getTitle()));
        if(!book.getQuery().getPages().get(0).getTerms().getDescription().isEmpty())
            viewHolder.tvAuthor.setText(String.valueOf(book.getQuery().getPages().get(0).getTerms().getDescription().get(0)));
        Picasso.with(getContext()).load(Uri.parse(String.valueOf(book.getQuery().getPages().get(0).getThumbnail().getSource()))).error(R.drawable.ic_nocover).into(viewHolder.ivCover);
        // Return the completed view to render on screen
        return convertView;
    }
}