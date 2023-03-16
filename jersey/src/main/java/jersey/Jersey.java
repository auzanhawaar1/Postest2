
package jersey;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Jersey {
    private final String kodeJry = "Jry";
    private long noKodeJry;
    protected String namaJry, ukuran;
    public int stokAwal,stokMasuk,stokKeluar,hargaBeli,hargaJual;
    
    Jersey(String namaJry, String ukuran, int stokAwal, int stokMasuk, int stokKeluar, int hargaBeli, int hargaJual, long noKodeJry){
        this.namaJry = namaJry;
        this.ukuran = ukuran;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.stokAwal = stokAwal;
        this.stokMasuk = stokMasuk;
        this.stokKeluar = stokKeluar;
        this.noKodeJry = noKodeJry;
    }
    
    Jersey() {
        //UNTUK MENGATASI EROR DI MAIN
    }
     public String getKodeJry() {
        return kodeJry;
    }

    public long getNoKodeJry() {
        return noKodeJry;
    }

    public String getNamaJry() {
        return namaJry;
    }
    
    public void setnamaJry(String namaJry) {
        this.namaJry = namaJry;
    }

    public String getukuran() {
        return ukuran;
    }
    
    public void setukuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public int getstokAwal() {
        return stokAwal;
    }
    
    public void setstokAwal(int stokAwal) {
        this.stokAwal = stokAwal;
    }
    
    public int getstokMasuk() {
        return stokMasuk;
    }
    
    public void setstokMasuk(int stokMasuk) {
        this.stokMasuk = stokMasuk;
    }
    public int getstokKeluar() {
        return stokKeluar;
    }
    
    public void setstokKeluar(int stokKeluar) {
        this.stokKeluar = stokKeluar;
    }

    
    public int gethargaBeli() {
        return hargaBeli;
    }
    
    public void sethargaBeli(int hargaBeli) {
        this.hargaBeli = hargaBeli;
    }
    public int gethargaJual() {
        return hargaJual;
    }
    
    public void sethargaJual(int hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Jersey getJry() {
        return Jry;
    }

    public ArrayList<Jersey> getJryList() {
        return JryList;
    }

    public Scanner getInp() {
        return inp;
    }

    public Scanner getInputInt() {
        return inputInt;
    }
    
    Jersey Jry;
    ArrayList<Jersey> JryList = new ArrayList<>();
    InputStreamReader isr = new InputStreamReader (System.in);
    BufferedReader br = new BufferedReader(isr);
    Scanner inp = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);
    protected void tambahJersey () throws IOException{
        boolean ulang=true;
        System.out.println("\nMenambahkan jersey\n");
        System.out.print("Nama jersey : ");
        namaJry = inp.nextLine();
        System.out.print("ukuran : ");
        ukuran = inp.nextLine();
        System.out.print("Stok Awal  : ");
        stokAwal = Integer.parseInt(br.readLine());
        System.out.print("Stok Masuk  : ");
        stokMasuk = Integer.parseInt(br.readLine());
        System.out.print("Stok Keluar  : ");
        stokKeluar = Integer.parseInt(br.readLine());

        while(ulang){
            System.out.print("Harga Beli jersey : ");
            String strHargaBeli=inp.nextLine();
            System.out.print("Harga Jual jesey : ");
            String strHargaJual=inp.nextLine();
            if (strHargaJual.equals("0")){
                System.err.println("Data Ini Tidak Boleh Bernilai 0");
            }else if(strHargaBeli.equals("0")){
                System.err.println("Data Ini Tidak Boleh Bernilai 0");
            }
            else{
                try{
                    hargaBeli = (Integer.parseInt(strHargaBeli));
                    hargaJual = (Integer.parseInt(strHargaJual));
                    noKodeJry++;
                    System.out.println("No Kode jesery : " + kodeJry + noKodeJry);
                    Jry = new Jersey(namaJry, ukuran, stokAwal, stokMasuk, stokKeluar, hargaBeli, hargaJual, noKodeJry); // OBJEK ke - 1
                    JryList.add(Jry);
                    System.out.println("\n>> Tambah Data Berhasil <<");
                    ulang=false;
                }catch(NumberFormatException e){
                    System.err.println("Data Yang anda masukkan tidak sesuai");
                }
            }
        }
    }
    
    protected void tampilJersey(){
        System.out.println("\nMenampilkan Data \n");
        for (int i=0; i<JryList.size(); i++){
            System.out.println("No Kode Barang : " + Jry + JryList.get(i).getNoKodeJry());
            System.out.println("Nama Barang : " + JryList.get(i).getNamaJry());
            System.out.println("Jenis Ukuran : " + JryList.get(i).getukuran());
            System.out.println("Stok Awal : " + JryList.get(i).getstokAwal());
            System.out.println("Stok Masuk : " + JryList.get(i).getstokMasuk());
            System.out.println("Stok Keluar : " + JryList.get(i).getstokKeluar());
            System.out.println("Stok Akhir : " + (JryList.get(i).getstokAwal()+JryList.get(i).getstokMasuk()-JryList.get(i).getstokKeluar()));
            System.out.println("Harga Beli Barang : Rp" + JryList.get(i).hargaBeli);
            System.out.println("Harga Jual Barang : Rp" + JryList.get(i).hargaJual);
            System.out.println(" ");
        }
    }
    
    /**
     *
     * @param Jrylist
     * @return
     * @throws IOException
     */
    public ArrayList<Jersey> ubahJersey(ArrayList<Jersey> Jrylist)throws IOException {
        int ubah;
        System.out.println("\nMengubah Data \n");
        for (int i=0; i<JryList.size(); i++){
            System.out.println("No Kode jersey : " + kodeJry +
            JryList.get(i).getNoKodeJry());
            System.out.println("Nama jersey : " + JryList.get(i).getNamaJry());
            System.out.println(" ");
        }
        if (JryList.size() == 1){
            ubah = 0;
        } else {
            System.out.print("\nInput No Kode untuk Mengubah Data [Input Angka Saja] : ");
            ubah = inputInt.nextInt();
            ubah--;
        }
        System.out.print("\nUbah Nama jersey : ");
        JryList.get(ubah).setnamaJry(br.readLine());
        System.out.print("Ubah Ukuran : ");
        JryList.get(ubah).setukuran(br.readLine());
        System.out.print("Ubah Stok Awal : ");
        JryList.get(ubah).setstokAwal(Integer.parseInt(br.readLine()));
        System.out.print("Ubah Stok Masuk : ");
        JryList.get(ubah).setstokMasuk(Integer.parseInt(br.readLine()));
         System.out.print("Ubah Stok Keluar : ");
        JryList.get(ubah).setstokKeluar(Integer.parseInt(br.readLine()));
        System.out.print("Ubah Harga Beli Barang  : ");
        JryList.get(ubah).sethargaBeli(Integer.parseInt(br.readLine()));
        System.out.print("Ubah Harga Jual Barang  : ");
        JryList.get(ubah).sethargaJual(Integer.parseInt(br.readLine()));
        System.out.println("\n>> Data Jersey Berhasil Di Ubah <<\n");
        
        return JryList;
    }
    
    public void hapusJersey() {
        System.out.println("\nMenghapus jersey\n");
        for (int i=0; i<JryList.size(); i++){
            System.out.println("No Kode Barang : " + kodeJry +
            JryList.get(i).getNoKodeJry());
            System.out.println("Nama jersey : " + JryList.get(i).getNamaJry());
            System.out.println(" ");
        }
        int hapus;
        System.out.print("\nMasukan No Kode untuk Hapus jersey [Input Angka Belakang] : ");
        hapus = inputInt.nextInt();
        hapus--;
        JryList.remove(hapus);
        System.out.println("\n>> jersey Berhasil di Hapus <<\n");
    }

   

   

  
    
    
}
