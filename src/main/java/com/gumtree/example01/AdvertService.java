package com.gumtree.example01;

import com.gumtree.example03.model.Advert;

import java.util.List;

public interface AdvertService {

    List<Advert> getAdverts(long sellerId);

    boolean canRepostForFree(long advertId) throws RuntimeException;

    void repostForFree(long advertId) throws RuntimeException;
}


//Get the list of advert and assert it
//Get the empty list providing invalid seller id
//
//validate assert true and false
//use try catch to get runtime exception, pass integer
//
//
//verify by using mock
//use try catch to validate exception