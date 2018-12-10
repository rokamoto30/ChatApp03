package com.example.rokam.chatapp.Activities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.rokam.chatapp.R;

public class MyRecyclerView extends RecyclerView.ViewHolder {
    TextView txt_title, txt_comment;
    public MyRecyclerView(@NonNull View itemView) {
        super(itemView);

        txt_comment =(TextView)itemView.findViewById(R.id.txt_content);
        txt_title = (TextView)itemView.findViewById(R.id.txt_title);
    }
    //hi
}
