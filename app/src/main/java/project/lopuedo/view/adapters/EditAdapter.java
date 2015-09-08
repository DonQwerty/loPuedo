package project.lopuedo.view.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.TextView;

import project.lopuedo.R;

public class EditAdapter extends CursorAdapter {

    final Context context;
    private TextView scoreTextView;

    public EditAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.context = context;
    }

    @Override
    public View newView(Context ctx, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(R.layout.list_item_edit_score,parent,false);
        //bindView(v,context,cursor);
        return v;
    }

    @Override
    public void bindView(View view, Context ctx , Cursor cursor) {

        TextView name = (TextView) view.findViewById(R.id.list_item_name);
        name.setText(cursor.getString(2));
        final TextView sco = (TextView) view.findViewById(R.id.list_item_score);

        Button button = (Button) view.findViewById(R.id.button_edit);

        button.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        // get prompts.xml view
                        LayoutInflater layoutInflater = LayoutInflater.from(context);
                        View dialogView = layoutInflater.inflate(R.layout.dialog_scores, null);
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                        // set prompts.xml to be the layout file of the alertdialog builder
                        alertDialogBuilder.setView(dialogView);
                        final EditText input = (EditText) dialogView.findViewById(R.id.editTextScore);

                        // setup a dialog window
                        // TODO Poner las strings en strings.xml
                        alertDialogBuilder
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // get user input and set it to result
                                        sco.setText(input.getText());
                                    }
                                })
                                .setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });

                        // create an alert dialog
                        AlertDialog alertD = alertDialogBuilder.create();
                        alertD.show();
                    }
                });
    }
}
