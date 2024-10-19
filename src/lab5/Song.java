package lab5;

// TODO 4.1: Create Song as a concrete class and
//  Album as an abstract class
public class Song {
    private String name;
    private Integer id;
    private String composer;

    public Song(String name, Integer id, String composer) {
        this.id = id;
        this.name = name;
        this.composer = composer;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", composer='" + composer + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getComposer() {
        return composer;
    }
}
