package pe.edu.cibertec.app_evaluacion_t2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductoAdapter(
    private val listaProductos: List<Producto>
) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgProducto: ImageView = itemView.findViewById(R.id.imgProducto)
        val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)
        val txtCategory: TextView = itemView.findViewById(R.id.txtCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)

        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {

        val producto = listaProductos[position]

        holder.txtTitle.text = producto.title
        holder.txtPrice.text = "Precio: S/ ${producto.price}"
        holder.txtCategory.text = "Categoría: ${producto.category}"

        Glide.with(holder.itemView.context)
            .load(producto.thumbnail)
            .into(holder.imgProducto)
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }
}