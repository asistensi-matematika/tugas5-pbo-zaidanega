package TUGAS5;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PERPUSTAKAAN {
    public PERPUSTAKAAN() {
    }
    public void info(){
        
    }
     public static void header(String nama_file_txt){
        File file = new File(nama_file_txt);
        String encoding = "utf-8";
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), encoding)) {
            int data = isr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = isr.read();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
class BUKU extends PERPUSTAKAAN {

    private String Judul,Pengarang,Tipe;
    private int Halaman;

    public BUKU() {
        Judul = "null";
        Pengarang = "null";
        Halaman = 0;
        Tipe = "null";
    }

    public BUKU(String Judul, String Pengarang, String Tipe, int Halaman) {
        this.Judul = Judul;
        this.Pengarang = Pengarang;
        this.Halaman = Halaman;
        this.Tipe = Tipe;
    }

    public String getTipe() {
        return Tipe;
    }

    public void setTipe(String Tipe) {
        this.Tipe = Tipe;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

    public String getPengarang() {
        return Pengarang;
    }

    public void setPengarang(String Pengarang) {
        this.Pengarang = Pengarang;
    }

    public int getHalaman() {
        return Halaman;
    }

    public void setHalaman(int Halaman) {
        this.Halaman = Halaman;
    }
}
class FIKSI extends BUKU {
  private String BookTipe;
    
    public FIKSI() {
        super();
        BookTipe = "Fiksi";
    }

    public FIKSI(String BookTipe, String Judul, String Pengarang, String Tipe, int Halaman) {
        super(Judul, Pengarang, Tipe, Halaman);
        this.BookTipe = BookTipe;
    }

    public String getJenisBuku() {
        return BookTipe;
    }

    public void setJenisBuku(String BookTipe) {
        this.BookTipe = BookTipe;
    }
    
}

class NONFIKSI extends BUKU{
    private String BookTipe;

    public NONFIKSI() {
        super();
        BookTipe = "Non Fiksi";
    }

    public NONFIKSI(String BookTipe, String Judul, String Pengarang, String Tipe, int Halaman) {
        super(Judul, Pengarang, Tipe, Halaman);
        this.BookTipe = BookTipe;
    }

    public String getJenisBuku() {
        return BookTipe;
    }

    public void setJenisBuku(String BookTipe) {
        this.BookTipe = BookTipe;
    }
    
}