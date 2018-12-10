package com.example.rokam.chatapp.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.rokam.chatapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class home extends AppCompatActivity {
    EditText edit_title, edit_content;
    Button btn_post;
    RecyclerView recyclerView;

    //Firebase
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    FirebaseRecyclerOptions<Post> options;
    FirebaseRecyclerAdapter<Post, MyRecyclerView> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        edit_content = (EditText)findViewById(R.id.txtPost);
        edit_title = (EditText)findViewById(R.id.Name);
        btn_post = (Button)findViewById(R.id.send);
        recyclerView = (RecyclerView)findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("CS 125");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                displayComment();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postComment();
            }
        });

        displayComment();

    }

    @Override
    protected void onStop() {
        if(adapter != null)
            adapter.stopListening();
        super.onStop();
    }

    private void postComment() {
        String title = edit_title.getText().toString();
        String content = edit_content.getText().toString();

        Post post = new Post(title, content);

        databaseReference.push() //use method to create new id of comment
             .setValue(post);


        adapter.notifyDataSetChanged();
    }
    private void displayComment() {
        options =
                new FirebaseRecyclerOptions.Builder<Post>()
                .setQuery(databaseReference, Post.class)
                .build();
        adapter =
                new FirebaseRecyclerAdapter<Post, MyRecyclerView>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull MyRecyclerView holder, int position, @NonNull final Post model) {
                        holder.txt_title.setText(model.getTitle());
                        holder.txt_comment.setText(model.getContent());
                    }

                    @NonNull
                    @Override
                    public MyRecyclerView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                        View itemView = LayoutInflater.from(getBaseContext()).inflate(R.layout.post_item, viewGroup, false);
                        return new MyRecyclerView(itemView);
                    }
                };

        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }
}
