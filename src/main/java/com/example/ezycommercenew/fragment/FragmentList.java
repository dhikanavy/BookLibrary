package com.example.ezycommercenew.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ezycommercenew.ListSorted;
import com.example.ezycommercenew.R;
import com.example.ezycommercenew.adapter.ProductAdapter;
import com.example.ezycommercenew.bookmodel.DetailProduct;
import com.example.ezycommercenew.bookmodel.ListProduct;
import com.example.ezycommercenew.retrofit.APIClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentList extends Fragment {
    RecyclerView recView;
    List<DetailProduct> listDp;
    ProductAdapter proAdapt;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAccessories.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentList newInstance(String param1, String param2) {
        FragmentList fragment = new FragmentList();
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
        listDp = new ArrayList<>();
        // Inflate the layout for this fragment]
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recView = view.findViewById(R.id.rv_accessories);
        LinearLayoutManager llManager = new LinearLayoutManager(requireContext());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        recView.setLayoutManager(llManager);
        proAdapt = new ProductAdapter(getContext(), listDp);
        recView.setAdapter(proAdapt);

        loadData();
        return view;
    }

    private void loadData(){
        Call<ListProduct> callLP = APIClient.loadBook().getAllBook("2201791093","Andhika Naafi Ramadhan");
        callLP.enqueue(new Callback<ListProduct>() {
            @Override
            public void onResponse(Call<ListProduct> call, Response<ListProduct> response) {
                ListProduct liPro = response.body();
                Log.d("(result)", "onResponse: "+new Gson().toJson(response.body()));
                listDp = liPro.getProducts();

                String category = getArguments() == null ? "none" : getArguments().getString("category");
                proAdapt.setDp(new ListSorted(listDp).getCategory(category));
                proAdapt.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ListProduct> call, Throwable t) {

            }
        });
    }



}