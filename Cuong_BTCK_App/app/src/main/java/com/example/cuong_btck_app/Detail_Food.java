package com.example.cuong_btck_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class Detail_Food extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    String name, price, img;

    public Detail_Food() {

    }
    public Detail_Food(String name, String price, String img ) {
        this.name = name;
        this.price = price;
        this.img = img;
    }



    public static Detail_Food newInstance(String param1, String param2) {
        Detail_Food fragment = new Detail_Food();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail__food, container, false);

        ImageView imageholder = view.findViewById(R.id.imagegholder);
        TextView nameholder = view.findViewById(R.id.nameholder);
        TextView priceholder = view.findViewById(R.id.priceholder);

        nameholder.setText(name);
        priceholder.setText(price);

        Glide.with(getContext()).load(img).into(imageholder);




        return view;
    }
    public void  onBackPressed(){
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.view_pager, new ListFragment()).addToBackStack(null).commit();
    }

}