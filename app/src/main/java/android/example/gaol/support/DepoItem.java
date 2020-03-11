package android.example.gaol.support;

public class DepoItem {
   private String id_depo;
   private String nama_depo;

    public DepoItem(String id_depo, String nama_depo, String alamat_depo, String no_hp) {
        this.id_depo = id_depo;
        this.nama_depo = nama_depo;
        this.alamat_depo = alamat_depo;
        this.no_hp = no_hp;
    }

    private String alamat_depo;

    public String getId_depo() {
        return id_depo;
    }

    public void setId_depo(String id_depo) {
        this.id_depo = id_depo;
    }

    public String getNama_depo() {
        return nama_depo;
    }

    public void setNama_depo(String nama_depo) {
        this.nama_depo = nama_depo;
    }

    public String getAlamat_depo() {
        return alamat_depo;
    }

    public void setAlamat_depo(String alamat_depo) {
        this.alamat_depo = alamat_depo;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    private String no_hp;
}
