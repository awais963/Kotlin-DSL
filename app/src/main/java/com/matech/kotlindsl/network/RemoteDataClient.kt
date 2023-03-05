package com.matech.kotlindsl.network

import com.matech.kotlindsl.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class RemoteDataClient @Inject constructor() {

    /* companion object {
         private const val BASE_URL = BuildConfig.API_URL
     }*/

    fun <Api> buildApi(
        api: Class<Api>
    ): Api {

        return Retrofit.Builder()
            .baseUrl("https://matech.free.beeceptor.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient())
            .build()
            .create(api)
    }


    private fun okhttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.MINUTES) // connect timeout
            .writeTimeout(5, TimeUnit.MINUTES) // write timeout
            .readTimeout(5, TimeUnit.MINUTES) // read timeout
            .addNetworkInterceptor { chain ->
                val original = chain.request()


                val requestBuilder = original.newBuilder()
                    .method(original.method, original.body)
               /* if (!SharedPrefsHelper.getHwUserAuth().isNullOrEmpty()) {
                    SharedPrefsHelper.getHwUserAuth()?.let {
                        requestBuilder
                            .addHeader(APIKey.getUserEmailH(), SharedPrefsHelper.getHwUserEmail())
                            .addHeader(APIKey.getUserTokenH(), it)
                    }

                }*/
               /* requestBuilder.addHeader(
                    APIKey.getAuthSecretKeyName(),
                    APIKey.getAuthSecretKey()
                )
                requestBuilder.addHeader(
                    APIKey.getAuthPublicKeyName(),
                    APIKey.getAuthPublicKey()
                )*/
                requestBuilder.addHeader("cache-control", "no-cache")
                val request = requestBuilder.build()
                chain.proceed(request)
            }

        if (BuildConfig.DEBUG)
            okHttpClient.addInterceptor(logging)

        return okHttpClient.build()
    }

}
