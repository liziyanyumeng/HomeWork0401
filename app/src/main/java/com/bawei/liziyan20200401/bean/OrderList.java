package com.bawei.liziyan20200401.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderList implements Serializable {
    public String expressCompName;
    public String orderId;
    public ArrayList<DetailList> detailList;
}
