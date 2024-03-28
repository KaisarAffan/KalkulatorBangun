package com.example.kalkulatorbangun.BangunRuang;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kalkulatorbangun.BangunDatar.BangunDatarChild.Lingkaran;
import com.example.kalkulatorbangun.BangunDatar.BangunDatarChild.Persegi;
import com.example.kalkulatorbangun.BangunDatar.BangunDatarChild.PersegiPanjang;
import com.example.kalkulatorbangun.BangunDatar.BangunDatarChild.Segitiga;
import com.example.kalkulatorbangun.BangunRuang.BangunRuangChild.Kerucut;
import com.example.kalkulatorbangun.BangunRuang.BangunRuangChild.Kubus;
import com.example.kalkulatorbangun.BangunRuang.BangunRuangChild.Tabung;
import com.example.kalkulatorbangun.BangunRuang.BangunRuangChild.ball;
import com.example.kalkulatorbangun.Item;
import com.example.kalkulatorbangun.MyAdapter;
import com.example.kalkulatorbangun.R;

import java.util.ArrayList;
import java.util.List;


public class BangunRuangParent extends Fragment  implements MyAdapter.ItemClickListener{

    List<Item> figure = new ArrayList<>();
    MyAdapter adapter;

    int[] ImageGeometry={R.drawable.bola,R.drawable.kubus,R.drawable.tabung,R.drawable.kerucut};

    public BangunRuangParent() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bangun_ruang_parent, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.RVbangunruang);

        menu();

        adapter = new MyAdapter(getContext(),figure);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setClickListener(this);
    }

    public void menu(){
        String[] geometryTitle = getResources().getStringArray(R.array.bangunRuangTitle);
        String[] geometryDesciption = getResources().getStringArray(R.array.bangunRuangDescription);

        for (int i = 0; i < geometryTitle.length;i++){
            figure.add(new Item(ImageGeometry[i],geometryTitle[i],geometryDesciption[i]));
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        if (adapter.getItem(position).getTitle().equals("Bola")) {
            Intent intent = new Intent(getActivity(), ball.class);
            startActivity(intent);
        }else if (adapter.getItem(position).getTitle().equals("Kubus")) {
            Intent intent = new Intent(getActivity(), Kubus.class);
            startActivity(intent);
        }else if (adapter.getItem(position).getTitle().equals("Tabung")) {
            Intent intent = new Intent(getActivity(), Tabung.class);
            startActivity(intent);
        }else if (adapter.getItem(position).getTitle().equals("Kerucut")) {
            Intent intent = new Intent(getActivity(), Kerucut.class);
            startActivity(intent);
        }
    }
}