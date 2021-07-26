package sg.edu.rp.c346.id20046523.demotodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> toDoList;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<ToDoItem> objects) {
        super(context, resource, objects);

        parent_context=context;
        layout_id = resource;
        toDoList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent,false);

        TextView tvToDo = rowView.findViewById(R.id.tvToDo);
        TextView tvDate = rowView.findViewById(R.id.tvDate);

        ToDoItem items = toDoList.get(position);
        tvToDo.setText(items.getTitle());
        tvDate.setText(items.toString());
        return rowView;
    }
}
