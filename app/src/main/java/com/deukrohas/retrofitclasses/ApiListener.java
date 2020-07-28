package com.deukrohas.retrofitclasses;

import com.deukrohas.retrofitclasses.models.CreateDeliverTaskModel;
import com.deukrohas.retrofitclasses.models.GetAllTaskModel;
import com.deukrohas.retrofitclasses.models.GetTaskDetailModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiListener {
    @FormUrlEncoded
    @POST("create_task")
    Call<CreateDeliverTaskModel> createTask
            (@Field("api_key") String api_key,
             @Field("order_id") String order_id,
             @Field("team_id") String team_id,
             @Field("auto_assignment") String auto_assignment,
             @Field("job_description") String job_description,
             @Field("job_pickup_phone") String job_pickup_phone,

             @Field("job_pickup_name") String job_pickup_name,
             @Field("job_pickup_email") String job_pickup_email,
             @Field("job_pickup_address") String job_pickup_address,
             @Field("job_pickup_latitude") String job_pickup_latitude,
             @Field("job_pickup_longitude") String job_pickup_longitude,
             @Field("job_pickup_datetime") String job_pickup_datetime,

             @Field("customer_email") String customer_email,
             @Field("customer_username") String customer_username,
             @Field("customer_phone") String customer_phone,
             @Field("customer_address") String customer_address,
             @Field("latitude") String latitude,
             @Field("longitude") String longitude,


             @Field("job_delivery_datetime") String job_delivery_datetime,
             @Field("has_pickup") String has_pickup,
             @Field("has_delivery") String has_delivery,
             @Field("layout_type") String layout_type,
             @Field("tracking_link") int tracking_link,
             @Field("timezone") String timezone,


             @Field("custom_field_template") String custom_field_template,
             @Field("pickup_custom_field_template") String pickup_custom_field_template,
             @Field("notify") int notify,
             @Field("tags") String tags,
             @Field("geofence") int geofence,
             @Field("ride_type") int ride_type
            );

//    @FormUrlEncoded
//    @POST("get_all_tasks")
//    Call<GetAllTaskModel> getAllTask
//            (@Field("api_key") String api_key,
//             @Field("job_status") int job_status,
//             @Field("job_type") int job_type,
//             @Field("start_date") String start_date,
//             @Field("end_date") String end_date,
//             @Field("custom_fields") int custom_fields,
//             @Field("is_pagination") int is_pagination,
//             @Field("requested_page") int requested_page,
//             @Field("customer_id") String customer_id,
//             @Field("fleet_id") int fleet_id,
//             @Field("team_id") int team_id
//            );

    @Headers("Content-Type: application/json")
    @POST("get_all_tasks")
    Call<GetAllTaskModel> getAllTask(@Body String body);


    @FormUrlEncoded
    @POST("get_job_details")
    Call<GetTaskDetailModel> getTaskDetails
            (@Field("api_key") String api_key,
             @Field("job_ids[]") ArrayList<Integer> job_ids,
             @Field("include_task_history") int include_task_history
             );

//    @Headers("Content-Type: application/json")
//    @POST("get_job_details")
//    Call<GetTaskDetailModel> getTaskDetails(@Body String body);



}