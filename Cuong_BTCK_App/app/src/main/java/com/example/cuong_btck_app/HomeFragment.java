package com.example.cuong_btck_app;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    private List<Photo> mListPhoto;
    private Timer mTimer;
    private RecyclerView rcvSpecialOffers;
    private SpecialOffersAdapter specialOffersAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.circle_indicator);

        mListPhoto = getListPhoto();
        photoAdapter = new PhotoAdapter(getContext(),mListPhoto);
        viewPager.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        autoSlideImages();

        rcvSpecialOffers = view.findViewById(R.id.rcv_special_offers);
        specialOffersAdapter = new SpecialOffersAdapter(getContext());

        GridLayoutManager gridLayoutManager =new GridLayoutManager(getContext(),2);
        rcvSpecialOffers.setLayoutManager(gridLayoutManager);

        specialOffersAdapter.setData(getListSO());
        rcvSpecialOffers.setAdapter(specialOffersAdapter);
        return view;


    }
    private List<SpecialOffers> getListSO(){
        List<SpecialOffers> list = new ArrayList<>();
        list.add(new SpecialOffers(R.drawable.bdmt_tcl,"M???t Th???p C???m 3 ng?????i","195000??"));
        list.add(new SpecialOffers(R.drawable.bdmt_tc_2n,"B??n ?????u + 2 N?????c","99000??"));
        list.add(new SpecialOffers(R.drawable.comtam1,"C??m T???m ","80000??"));
        list.add(new SpecialOffers(R.drawable.bunbo,"B??n B?? Hu???","65000??"));
        list.add(new SpecialOffers(R.drawable.phobo,"Ph??? B?? ","85000??"));
        list.add(new SpecialOffers(R.drawable.banhcanhcua,"B??nh Canh Cua","120000??"));
        return list;
    }
    private List<Photo> getListPhoto(){
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.bdmt1));
        list.add(new Photo(R.drawable.bdmt2));
        list.add(new Photo(R.drawable.bdmt3));
        list.add(new Photo(R.drawable.bdmt4));



        return list;

    }
    private void autoSlideImages(){
        if (mListPhoto == null || mListPhoto.isEmpty() || viewPager ==null){
            return;
        }

        if (mTimer == null){
            mTimer = new Timer();
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                       int  currentItem = viewPager.getCurrentItem();
                       int  totalItem = mListPhoto.size() -1;
                       if (currentItem < totalItem){
                           currentItem ++;
                           viewPager.setCurrentItem(currentItem);
                       }else {
                           viewPager.setCurrentItem(0);

                       }
                    }
                });

            }
        }, 500, 3000);



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTimer != null){
            mTimer.cancel();
            mTimer =null;
        }
    }
}
