package com.example.a_fandy.traditionalfood;

import java.util.ArrayList;

public class FoodData {
    public static String[][] data= new String[][]{
            {"Rujak Cingur","rujak cingur itu terdiri dari potongan buah-buahan yang di beri Cingur (mulut sapi), sayur-sayuran, tahu, dan bumbu rujak cingur yang terdiri dari cabe, petis, gula merah, bawang putih, kacang goreng, di ulek lalu dicampur dengan seporsi rujak cingur yang merupakan kombinasi yang sempurna",
            "https://www.gotravelly.com/blog/wp-content/uploads/2018/02/rujak-cingur.jpg","Jawa timur terutama di Surabaya"},
            {"Lontong Balap","lotong balap itu terdiri dari lontong, touge, tahu goreng, lenthok, kecap, bawang goreng, sambal, dan siraman kuahnya yang khas rasanya, asin, manis, gurih, akan lebih nikmat jika dimakan saat hangat.","https://www.gotravelly.com/blog/wp-content/uploads/2018/02/lontong-balap.jpg","Jawa timur"},
            {"Tahu Tek","tek ini terdiri dari tahu goreng, lontong, tauge, kerupuk, kentang goreng, timun, telur, dan pastinya bumbu tahu tek yang terdiri dari bawang purih, petis, kecap, kacang goreng, cabai.","https://www.gotravelly.com/blog/wp-content/uploads/2018/02/tahu-tek.jpg","jawa timur, jawa tengah, dan jawa barat"},
            {"Nasi Pecel","nasi pecel ini adalah makanan khas jawa timur yang banyak ditemukan di surabaya, malang, dan jember.","https://www.gotravelly.com/blog/wp-content/uploads/2018/02/nasi-pecel.jpg","surabaya, malang, dan jember"},
            {"Lumpia Semarang"," lumpia itu berisi ayam, telur, udang, sayuran dan akan lebih nikmat jika di makan saat panas-panas lalu di cocol ke saus atau di makan dengan cabe hijau yang segar.","https://www.gotravelly.com/blog/wp-content/uploads/2018/02/lumpia-semarang.jpg","semarang"},

    };

    public static ArrayList<Food> getListData(){
        Food food = null;
        ArrayList<Food> list = new ArrayList<>();
        for (String[] aData : data) {
            food = new Food();
            food.setName(aData[0]);
            food.setRemarks(aData[3]);
            food.setPhoto(aData[2]);
            food.setDeskripsi(aData[1]);

            list.add(food);
        }

        return list;
    }

}
