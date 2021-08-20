package code.sanky.todos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import code.sanky.todos.databinding.ActivityMainBinding
import code.sanky.todos.db.MyDBHelpher
import code.sanky.todos.db.TodoTable

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var todos = ArrayList<Todo>()

        val todoAdapter = ArrayAdapter<Todo>(this
            ,android.R.layout.simple_expandable_list_item_1
            ,android.R.id.text1 , todos )

        val db = MyDBHelpher(this).writableDatabase

        binding.lvTodos.adapter = todoAdapter

        fun refreshTodoList(){
            val todoList = TodoTable.getAllTodos(db)
            todos.clear()
            todos.addAll(todoList)
            todoAdapter.notifyDataSetChanged()
        }

        refreshTodoList()
        binding.btn1.setOnClickListener {
            val newTodo = Todo(binding.et1.text.toString() ,
                false
            )
            TodoTable.insertTodo(db , newTodo)
            refreshTodoList()
            binding.et1.text.clear()
        }

    }
}