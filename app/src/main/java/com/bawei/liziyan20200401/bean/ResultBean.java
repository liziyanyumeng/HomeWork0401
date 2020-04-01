package com.bawei.liziyan20200401.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class ResultBean implements Serializable {
    public String categoryName;
    public ArrayList<ShoppingCartList> shoppingCartList;
    public boolean ischecked;
}
