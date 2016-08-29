package adityagurjar.people;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by adi on 28/8/16.
 */
public class contactsListAdapter extends RecyclerView.Adapter<contactsListAdapter.MyViewHolder> {

    private List<contactitem> contactsList;
    Context context;
    View itemView;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, number, email;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            number = (TextView) view.findViewById(R.id.number_row);
            email = (TextView) view.findViewById(R.id.email_row);

        }

    }


    public contactsListAdapter(List<contactitem> contactsList, Context currentContext) {
        this.contactsList = contactsList;
        context=currentContext;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_row, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final contactitem contact = contactsList.get(position);

        holder.title.setText(contact.getTitle());
        holder.number.setText(contact.getNumber());
        holder.email.setText(contact.getEmail());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, contactInfoPage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("email",holder.email.getText());
                intent.putExtra("phone", holder.number.getText());
                intent.putExtra("name",holder.title.getText());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }
}