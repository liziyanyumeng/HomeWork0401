package com.bawei.liziyan20200401.util;

import com.bawei.liziyan20200401.bean.CreateBean;
import com.bawei.liziyan20200401.bean.RegisterBean;
import com.bawei.liziyan20200401.bean.ShopCarBean;
import com.bawei.liziyan20200401.bean.ShowBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("user/v1/register")
    @FormUrlEncoded//普通事件
    Observable<RegisterBean> register(@Field("phone")String phone, @Field("pwd")String pwd);

    //登录
    //使用POST请求
    @POST("user/v1/login")
    @FormUrlEncoded //普通事件
    Observable<RegisterBean> login(@Field("phone")String phone, @Field("pwd")String pwd);


    @GET("order/verify/v1/findShoppingCart")
    Observable<ShopCarBean> shopcar();

    @GET("order/verify/v1/findOrderListByStatus")
    Observable<ShowBean> show(@Query("page")int page, @Query("count") int count, @Query("status") int status);

    @POST("order/verify/v1/createOrder")
    @FormUrlEncoded
    Observable<CreateBean> create(@Field("orderInfo")String orderInfo,@Field("totalPrice") double totalPrice,@Field("addressId") int addressId);

}
