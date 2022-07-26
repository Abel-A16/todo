package com.example.todo

object DataObject {
    var listdata= mutableListOf<model>()
    fun setData(title: String, pr:Int){
        listdata.add(model(title,pr))
    }
    fun getAllData():List<model>{
        return listdata
    }
    fun deleteAll(){
        listdata.clear()
    }
    fun getData(pos:Int): model {
        return listdata[pos]
    }
    fun deleteData(pos: Int){
        listdata.removeAt(pos)
    }
    fun updateData(pos: Int,title: String, pr:Int){
        listdata[pos].title=title
        listdata[pos].priority = pr
    }

}