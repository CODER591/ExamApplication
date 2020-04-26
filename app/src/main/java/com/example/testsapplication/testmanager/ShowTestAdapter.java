package com.example.testsapplication.testmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testsapplication.R;

public class ShowTestAdapter  extends RecyclerView.Adapter<ShowTestAdapter.TestViewHolder>{
    private static int viewHolderCount;
    private int numberItems;
    public ShowTestAdapter(int numberOfIntems) {
        viewHolderCount=0;
        numberItems = numberOfIntems;
    }
    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId=R.layout.test_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(layoutId,parent,false);
        TestViewHolder viewHolder = new TestViewHolder(view);
        viewHolder.viewHolderIndex.setText("view holder index:"+viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
            holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class TestViewHolder extends RecyclerView.ViewHolder {

        TextView listItemNumberView;
        TextView viewHolderIndex;

        public TestViewHolder(View itemView) {
            super(itemView);

            listItemNumberView = itemView.findViewById(R.id.tv_number_item);
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_number);

        }
        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }
    }

}
