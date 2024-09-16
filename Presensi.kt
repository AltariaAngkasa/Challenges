package com.dicoding.kotlin
import java.time.LocalDate

//Menampilkan Menu
fun ShowMenu(){
    println("\n=====Selamat Datang di Absensi=====")
    println("1. Tambah Kehadiran")
    println("2. Lihat Daftar Kehadiran")
    println("3. Hitung Total Kehadiran")
    println("4. Keluar")
    println("Pilih Opsi: ")
}

//Memasukkan nama
fun AddPresence(prestList: MutableList<String>){
    print("\nMasukkan Nama: ")
    //Menginput nama yang hadir
    val presence = readLine()?:" "
    if (presence.isNotEmpty()){
        prestList.add(presence)
        println("Siswa $presence Berhasil Ditambahkan ke Daftar Hadir")
    }else{
        //Jika Tidak memasukkan Nama, Maka akan muncul Peringatan
        print("Kehadiran tidak boleh kosong")
    }
}

//Melihat Presensi pada hari ini
fun ShowPresence(prestList: List<String>){
    //Membuat Variabel Untuk Mengetahui Tanggal Hari ini
    var today = LocalDate.now()
    //Jika tidak ada data, Maka akan membuat output 'Tidak ada Kehadiran'
    if (prestList.isEmpty()){
        print("\nTidak ada kehadiran")
    }else{
        //Jika ada maka akan ditampilkan data kehadiran
        println("\nDaftar Hadir Pada Hari $today")
        // Mengambil data dari Variable prestlist
        prestList.forEachIndexed { index, presence ->
            println("${index + 1}.$presence")
        }
    }
}

//Menghitung Jumlah kehadiran pada hari ini
fun TotalPresenceToday(prestList: List<String>){
    var total = prestList.size
    println("Total hari ini yang sudah masuk sebanyak: $total")
}


//Fungsi dijalankan
fun main(){
    val prestList = mutableListOf<String>()
    var isRunning = true

    while (isRunning){
        ShowMenu()
        when (readLine()){
            "1" -> AddPresence(prestList)
            "2" -> ShowPresence(prestList)
            "3" -> TotalPresenceToday(prestList)
            "4" -> {
                println("Keluar dari program")
                isRunning = false
            }
        }
    }
}
