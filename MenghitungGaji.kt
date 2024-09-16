package com.dicoding.kotlin


fun main(){
    //Memasukkan Nama
    print("Masukkan Nama: ")
    val nama = readLine()?: ""

    //Memasukkan Jumlah Jam Kerja
    print("Masukkan Jumlah Jam kerja: ")
    val JamKerja = readLine()?.toIntOrNull()?:0

    //Upah Per Jam
    val UpahPerJam = 100000

    //Menghitung Total Gaji
    val GajiTotal = if (JamKerja > 40){
        //Jika Jam Kerja Lebih dari 40 Jam akan ditambahkan 1.5
        val TarifLembur = JamKerja - 40
        (40 * UpahPerJam) + (TarifLembur * UpahPerJam *1.5)
    }else{
        //Jika Tidak maka Jam Kerja dikali Upah Per Jam
        JamKerja*UpahPerJam
    }

    print("Gaji Total $nama : $GajiTotal")
}
