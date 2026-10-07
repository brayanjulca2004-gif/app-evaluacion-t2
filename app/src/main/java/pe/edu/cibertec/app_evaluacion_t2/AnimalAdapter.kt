package pe.edu.cibertec.app_evaluacion_t2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.cibertec.app_evaluacion_t2.databinding.ItemAnimalBinding

class AnimalAdapter(
    private val listaAnimales: List<Animal>
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(
        val binding: ItemAnimalBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalViewHolder {

        val binding = ItemAnimalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: AnimalViewHolder,
        position: Int
    ) {

        val animal = listaAnimales[position]

        holder.binding.txtNombreAnimal.text = animal.nombre
        holder.binding.txtTipoAnimal.text = animal.tipo

        Glide.with(holder.itemView.context)
            .load(animal.imagen)
            .centerCrop()
            .into(holder.binding.imgAnimal)
    }

    override fun getItemCount(): Int {
        return listaAnimales.size
    }
}