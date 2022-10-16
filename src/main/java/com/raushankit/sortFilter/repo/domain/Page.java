package com.raushankit.sortFilter.repo.domain;


import java.util.List;


public class Page<T> {

    private int size;

    private int PageNumber;

    private List<T> data;

    private List<Sort> sortList;



}
