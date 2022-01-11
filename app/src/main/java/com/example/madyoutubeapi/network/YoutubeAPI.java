package com.example.madyoutubeapi.network;

import com.example.madyoutubeapi.models.ModelHome;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class YoutubeAPI {

//API BROKEN DOWN
    //https://youtube.googleapis.com/youtube/v3/
    // activities?part=snippet%2CcontentDetails
    // &channelId=UC_x5XG1OV2P6uZZ5FSM9Ttw
    // &maxResults=2&
    // key=AIzaSyAEzHHqgVSq3eJoN04xa45gI9VarjlV_4I
    // API KEY THAT WE GET FROM YOUTUBE DATA API THAT I DEMONSTRATED YESTERDAY FROM GOOGLE CLOUD API
    //https://console.cloud.google.com/apis/credentials?authuser=1&project=stone-bongo-337804&supportedpurview=project

    public static final String BASE_URL = "https://youtube.googleapis.com/youtube/v3/";
    public static final String KEY= "key=AIzaSyAEzHHqgVSq3eJoN04xa45gI9VarjlV_4I";
    public static final String sch = "search?";
    public static final String chid = "&channelIdUC_x5XG1OV2P6uZZ5FSM9Ttw";
    public static final String mx = "&maxResults=10";
    public static final String ord = "&order=date";
    public static final String part = "&part=snippet";


    public interface HomeVideo{
        @GET
        Call<ModelHome> getYT(@Url String url);
    }

    private static HomeVideo homeVideo = null;

    //https://square.github.io/retrofit/
    //Retrofit turns your HTTP API into a Java interface.


    public static HomeVideo getHomeVideo(){
        if(homeVideo==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            homeVideo =retrofit.create(HomeVideo.class);
        }
        return homeVideo;
    }
}
