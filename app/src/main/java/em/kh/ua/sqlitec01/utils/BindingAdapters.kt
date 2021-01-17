package em.kh.ua.sqlitec01.utils

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView

// BindingAdapter применяется к методам, которые используются для манипулирования тем,
// как значения с выражениями устанавливаются в представления.
// Вмешиваемся в процесс биндинга.
// Внимание на XML-файлы в папке layout.


// app:mutableVisibility=...
    @BindingAdapter("mutableVisibility")
    fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
        val parentActivity: AppCompatActivity? = view.getParentActivity()
        if(parentActivity != null && visibility != null) {
            visibility.observe(parentActivity,
                Observer { value -> view.visibility = value?: View.VISIBLE})
        }
    }

// app:mutableText=...
    @BindingAdapter("mutableText")
    fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
        val parentActivity:AppCompatActivity? = view.getParentActivity()
        if(parentActivity != null && text != null) {
            text.observe(parentActivity, Observer { value -> view.text = value?:""})
        }
    }

// app:adapter=...
    @BindingAdapter("adapter")
    fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        view.adapter = adapter
    }
