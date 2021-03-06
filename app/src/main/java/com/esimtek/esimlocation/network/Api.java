package com.esimtek.esimlocation.network;


import com.esimtek.esimlocation.model.LocationAll;
import com.esimtek.esimlocation.model.LocationCode;
import com.esimtek.esimlocation.model.LocationOrder;
import com.esimtek.esimlocation.model.LoggedBean;
import com.esimtek.esimlocation.model.LoginBean;
import com.esimtek.esimlocation.model.OrderNumber;
import com.esimtek.esimlocation.model.PLCode;
import com.esimtek.esimlocation.model.ResultBean;
import com.esimtek.esimlocation.model.TokenBean;
import com.esimtek.esimlocation.model.UserManagerBean;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 网络接口类
 *
 * @author wang
 * @date 2018/12/12
 */

public interface Api {

    /**
     * 获取token
     *
     * @param staffId 识别码
     * @return token
     */
    @GET("GetToken")
    Call<TokenBean> getToken(@Query("staffId") String staffId);

    /**
     * 登录
     *
     * @param loginBean 登录信息 包含用户名、密码
     * @return 用户id和权限
     */
    @POST("ESIM/pm/post/retUserJurisdiction")
    Call<LoggedBean> login(@Body LoginBean loginBean);

    /**
     * 获取所有站点物料盒数量
     *
     * @return 所有站点物料盒数量
     */
    @GET("ESIM/pm/get/location")
    Call<LocationAll> location();

    /**
     * 根据纸质条码查询位置信息
     *
     * @param plc 纸质条码
     * @return 位置信息
     */
    @POST("ESIM/pm/post/locationByPLCode")
    Call<LocationCode> locationByPLCode(@Body PLCode plc);

    /**
     * 根据订单号查询位置信息
     *
     * @param ord 订单号
     * @return 位置信息
     */
    @POST("ESIM/pm/post/locationByOrderNumber")
    Call<LocationOrder> locationByOrderNumber(@Body OrderNumber ord);

    /**
     * 人员管理
     *
     * @param bean 用户名、密码、请求类型
     *             请求类型 1 添加用户
     *             请求类型 2 更新密码
     *             请求类型 3 删除用户 密码字段为空
     * @return 操作结果
     */
    @POST("ESIM/pm/post/SendUserRequest")
    Call<ResultBean> userManager(@Body UserManagerBean bean);

}