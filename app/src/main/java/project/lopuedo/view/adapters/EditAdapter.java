package project.lopuedo.view.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import project.lopuedo.R;

public class EditAdapter extends CursorAdapter {

    public EditAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item_edit_score,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
//        ImageView iv = (ImageView) view.findViewById(R.id.list_item_imageview);
//        iv.setImageResource(R.drawable.ic_launcher);

        TextView name = (TextView) view.findViewById(R.id.list_item_name);
        name.setText(cursor.getString(2));


    }
}
