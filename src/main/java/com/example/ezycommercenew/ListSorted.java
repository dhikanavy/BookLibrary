package com.example.ezycommercenew;

import com.example.ezycommercenew.bookmodel.DetailProduct;

import java.util.ArrayList;
import java.util.List;

public class ListSorted {
    List<DetailProduct> mystery, business, cookbooks, accessories;
    List<DetailProduct> listDp;

    public ListSorted(List<DetailProduct> listDp) {
        this.listDp = listDp;
        mystery = new ArrayList<>();
        accessories = new ArrayList<>();
        cookbooks = new ArrayList<>();
        business = new ArrayList<>();
        sortData();
    }

    private void sortData(){
        for (DetailProduct dp : this.listDp){
            if(dp.getCategory().equalsIgnoreCase("mystery")){
                mystery.add(dp);
            }else if(dp.getCategory().equalsIgnoreCase("accessories")){
                accessories.add(dp);
            }else if(dp.getCategory().equalsIgnoreCase("cookbooks")){
                cookbooks.add(dp);
            }else if(dp.getCategory().equalsIgnoreCase("business")){
                business.add(dp);
            }
        }
    }

    public List<DetailProduct> getCategory(String category){
        if (category.equalsIgnoreCase("mystery")){
            return mystery;
        }else if (category.equalsIgnoreCase("business")){
            return business;
        }else if (category.equalsIgnoreCase("cookbooks")){
            return cookbooks;
        }else if (category.equalsIgnoreCase("accessories")){
            return accessories;
        }else return listDp;
    }


    public List<DetailProduct> getMystery() {
        return mystery;
    }

    public List<DetailProduct> getBusiness() {
        return business;
    }

    public List<DetailProduct> getCookbooks() {
        return cookbooks;
    }

    public List<DetailProduct> getAccessories() {
        return accessories;
    }
}
