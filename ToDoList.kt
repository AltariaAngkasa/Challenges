package com.dicoding.kotlin

fun showMenu(){
    println("\n====TO-DO List=====")
    println("1. Tambah Tugas Baru")
    println("2. Liat Semua Tugas")
    println("3. Hapus Tugas")
    println("4. Keluar")
    println("Pilih Opsi: ")
}

fun AddTask(taskLits: MutableList<String>){
    print("\nMasukkan Tugas Baru: ")
    val task = readLine() ?:""
    if (task.isNotEmpty()){
        taskLits.add(task)
        println("Tugas $task berhasil ditambahkan")
    }else{
        println("Tugas tidak boleh kosong!")
    }
}

fun ShowTask(taskList: List<String>){
    if (taskList.isEmpty()){
        println("\nTidak Ada Tugas yang perlu dilakukan")
    }else{
        println("\nDaftar Tugas")
        taskList.forEachIndexed { index, task ->
            println("${index + 1}. $task")
        }
    }
}

fun DeleteTask(taskList: MutableList<String>){
    ShowTask(taskList)
    if (taskList.isNotEmpty()){
        val taskNumber = readLine()?.toIntOrNull()
        if (taskNumber != null && taskNumber in 1..taskList.size){
            val RemoveTask = taskList.removeAt(taskNumber - 1)
            println("Tugas $RemoveTask berhasil dihapus")
        }else{
            println("Nomor Tugas Tidak Valid")
        }
    }
}

fun main(){
    val taskList = mutableListOf<String>()
    var isRunning = true

    while (isRunning){
        showMenu()
        when (readLine()){
            "1" -> AddTask(taskList)
            "2" -> ShowTask(taskList)
            "3" -> DeleteTask(taskList)
            "4" -> {
                println("Keluar dari program")
                isRunning = false
            }
            else -> println("Opsi tidak ada")
        }
    }
}
