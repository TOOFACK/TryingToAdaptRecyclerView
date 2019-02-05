package com.example.paulr.tryingtoadaptrecyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.paulr.tryingtoadaptrecyclerview.enities.User;

import java.io.Serializable;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MusicVH> {
    List<User> UserList;


    public UserAdapter(List<User> UserList) {
        this.UserList = UserList;
    }


    @Override
    public int getItemCount() {
        return UserList.size();
    }

    @NonNull
    @Override
    public MusicVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view = inflater.inflate(R.layout.nice_artist, viewGroup, false);

        return new MusicVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MusicVH musicVH, final int i) {
        final User user = UserList.get(i);

        musicVH.userName.setText(user.getName());
        musicVH.userId.setText(user.getId());
        musicVH.artistCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                UserList.remove(i);
                notifyItemRemoved(i);
                notifyItemChanged(i);
                return false;
            }
        });
        musicVH.artistCard.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Description.class);
               intent.putExtra("musicObject", user);
                v.getContext().startActivity(intent);
            }
        });
    }




    class MusicVH extends RecyclerView.ViewHolder implements Serializable{

        private TextView userName;
        private TextView userId;
        private CardView artistCard;

        public MusicVH(@NonNull View itemView,  TextView artist, TextView userId) {
            super(itemView);

            this.userName = artist;
            this.userId = userId;
        }

        public MusicVH(@NonNull View itemView) {
            super(itemView);




            userName = itemView.findViewById(R.id.UserName);
            userId = itemView.findViewById(R.id.UserId);
            artistCard = itemView.findViewById(R.id.musicCard);

        }
    }
}
