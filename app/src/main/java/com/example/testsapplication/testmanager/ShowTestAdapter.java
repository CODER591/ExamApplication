package com.example.testsapplication.testmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testsapplication.R;
import com.example.testsapplication.modelspack.Test;

import java.util.List;

public class ShowTestAdapter  extends RecyclerView.Adapter<ShowTestAdapter.TestViewHolder>{
    private static int viewHolderCount;
    private static List<String> test_names;
    private int numberItems;
    //refactor this constructor
    public ShowTestAdapter(List<String> testnames) {
        viewHolderCount=0;
        test_names =testnames;
        numberItems = testnames.size();
    }
    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId=R.layout.test_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(layoutId,parent,false);
        TestViewHolder viewHolder = new TestViewHolder(view);
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

        TextView viewHolderIndex;
        public TestViewHolder(View itemView) {
            super(itemView);
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_number);
            viewHolderIndex.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        //move to fragment with all shiit
                    int positionIndex = getAdapterPosition(); //get element what we are just clicked
                    viewHolderIndex.setText("I was chosen!");

                }
              }
            );
        }
        void bind(int listIndex) {
            //listItemTestView.setText(test_names.get(listIndex));
            viewHolderIndex.setText(test_names.get(listIndex));
        }
    }

}
