package org.tejas.expenditure;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ExpenditureAdapter extends RecyclerView.Adapter<ExpenditureAdapter.ExpenditureViewHolder> {

    private List<Expenditure> expenditureList;

    public ExpenditureAdapter(List<Expenditure> expenditureList) {
        this.expenditureList = expenditureList;
    }

    @NonNull
    @Override
    public ExpenditureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expenditure, parent, false);
        return new ExpenditureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenditureViewHolder holder, int position) {
        Expenditure expenditure = expenditureList.get(position);
        holder.description.setText(expenditure.getDescription());
        holder.amount.setText(String.valueOf(expenditure.getAmount()));
    }

    @Override
    public int getItemCount() {
        return expenditureList.size();
    }

    static class ExpenditureViewHolder extends RecyclerView.ViewHolder {
        TextView description, amount;

        ExpenditureViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.tvDescription);
            amount = itemView.findViewById(R.id.tvAmount);
        }
    }
}
