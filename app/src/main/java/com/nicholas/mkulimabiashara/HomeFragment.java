package com.nicholas.mkulimabiashara;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

import Datamodel.Data;

public class HomeFragment extends Fragment {
    //here we create the recycler view
    private RecyclerView homerecycler;
    private RecyclerView recyclerView2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //create an object of View class
        View myview=inflater.inflate(R.layout.fragment_home,container,false);

        //create a hook for the recycler
        homerecycler=myview.findViewById(R.id.recyclerview1);
        recyclerView2=myview.findViewById(R.id.recyclerview2);

        //this makes sure that our recyclerview is horinzontal
        // this the code for recyclerview1
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        homerecycler.setHasFixedSize(true);
        homerecycler.setLayoutManager(layoutManager);

        // this the code for recyclerview2 (adding the recycler item)
        LinearLayoutManager layoutManager1=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        layoutManager1.setReverseLayout(true);
        layoutManager1.setStackFromEnd(true);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(layoutManager1);

        return myview;
    }
    //create an on start method
    @Override
    public void onStart() {
        super.onStart();
        //In this part we are going to implement our firebase recycler adapter
        //homerecycler.setAdapter(adapterOne);

       //

    }

    public static class CatOneViewHolder extends RecyclerView.ViewHolder{
        //create an object of the View Class
        View myView;
        public CatOneViewHolder(@NonNull View itemView) {
            super(itemView);
            myView=itemView;
        }
        public void SetTitle(String title){
            TextView mTitle=myView.findViewById(R.id.title);
            mTitle.setText(title);
        }
        public void setDescription(String description){
            TextView mDescription=myView.findViewById(R.id.description);
            mDescription.setText(description);
        }
        public void SeTImage(String image){
            ImageView mImage=myView.findViewById(R.id.imageview);

            Picasso.get().load(image).networkPolicy(NetworkPolicy.OFFLINE).into(mImage, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {
                    Picasso.get().load(image).into(mImage);

                }
            });
        }

    }
}
