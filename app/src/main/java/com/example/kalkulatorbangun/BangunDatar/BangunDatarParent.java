package com.example.kalkulatorbangun.BangunDatar;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.kalkulatorbangun.BangunDatar.BangunDatarChild.Lingkaran;
import com.example.kalkulatorbangun.BangunDatar.BangunDatarChild.Persegi;
import com.example.kalkulatorbangun.BangunDatar.BangunDatarChild.PersegiPanjang;
import com.example.kalkulatorbangun.BangunDatar.BangunDatarChild.Segitiga;
import com.example.kalkulatorbangun.Item;
import com.example.kalkulatorbangun.MyAdapter;
import com.example.kalkulatorbangun.R;

import java.util.ArrayList;
import java.util.List;

public class BangunDatarParent extends Fragment implements MyAdapter.ItemClickListener{

    List<Item> geometry = new ArrayList<>();
    MyAdapter adapter;

    int[] ImageGeometry={R.drawable.lingkaran,R.drawable.persegi,R.drawable.persegipanjang,R.drawable.segitiga};

    public BangunDatarParent() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bangun_datar_parent, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.RVbangundatar);

        menu();

        adapter = new MyAdapter(getContext(), geometry);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setClickListener(this);

    }

    public void menu(){
        String[] geometryTitle = getResources().getStringArray(R.array.bangunDatarTitle);
        String[] geometryDesciption = getResources().getStringArray(R.array.bangunDatarDescription);

        for (int i = 0; i < geometryTitle.length;i++){
            geometry.add(new Item(ImageGeometry[i],geometryTitle[i],geometryDesciption[i]));
        }
    }


    @Override
    public void onItemClick(View view, int position) {
        if (adapter.getItem(position).getTitle().equals("Lingkaran")) {
            Intent intent = new Intent(getActivity(),Lingkaran.class);
            startActivity(intent);
        }else if (adapter.getItem(position).getTitle().equals("Persegi")) {
            Intent intent = new Intent(getActivity(), Persegi.class);
            startActivity(intent);
        }else if (adapter.getItem(position).getTitle().equals("Persegi Panjang")) {
            Intent intent = new Intent(getActivity(), PersegiPanjang.class);
            startActivity(intent);
        }else if (adapter.getItem(position).getTitle().equals("Segitiga")) {
            Intent intent = new Intent(getActivity(), Segitiga.class);
            startActivity(intent);
        }

    }
}