package code.sanky.todos.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelpher(context: Context) : SQLiteOpenHelper(context,
    "todos.db" ,
    null , 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
       p0?.execSQL(TodoTable.CMD_CREATE_TABLE)
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    /**
     * Schema -- Means Number of column and rows put together
     */



}