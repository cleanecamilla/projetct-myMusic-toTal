@Entity
public class ArtistEntity extends Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    private String nome;

    public ArtistaEntity(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public ArtistaEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}