import java.sql.Blob;

public class MusicEntity {
    private String Id;
    private String Nome;
    private String ArtistaId;

    public String getArtistaId() {
        return ArtistaId;
    }

    public void setArtistaId(String artistaId) {
        ArtistaId = artistaId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}
