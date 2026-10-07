package pe.edu.cibertec.app_evaluacion_t2

import retrofit2.Call
import retrofit2.http.GET

interface ProductoApi {

    @GET("products")
    fun getProductos(): Call<ProductsResponse>
}