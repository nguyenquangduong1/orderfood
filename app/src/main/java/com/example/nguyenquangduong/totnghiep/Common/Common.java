package com.example.nguyenquangduong.totnghiep.Common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.nguyenquangduong.totnghiep.Model.User;
import com.example.nguyenquangduong.totnghiep.Remote.APIService;
import com.example.nguyenquangduong.totnghiep.Remote.RetrofitClient;

import retrofit2.Retrofit;

public class Common {
    public static User currentUser;

    public static String convertCodeToStatus(String status) {
        if (status.equals("0"))
            return "Đã đặt";
        else if (status.equals("1"))
            return "Đang vận chuyển";
        else
            return "Đã nhận";

    }
    public  static final String UPDATE = "Chỉnh Sữa";

    public static final String INTENT_FOOD_ID = "FoodId";

    public static boolean isConnectedTonInterner(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
            if (info != null)
            {
                for (int i=0;i<info.length;i++)
                {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                        return true;
                }
            }
        }
        return false;
    }
    public static final String DELETE = "Xóa";
    public static final String USER_KEY = "User";
    public static final String PWD_KEY = "Password";

    private static final String BASE_URL = "https://fcm.googleapis.com/";

    public static APIService getFCMService()
    {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

    public static String PHONE_TEXT = "userPhone";


}
