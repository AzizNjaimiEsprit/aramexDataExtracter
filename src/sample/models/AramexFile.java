package sample.models;

public class AramexFile {
    private String name;
    private String extension;

    public AramexFile(String name, String extension) {
        this.name = name;
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "File{" +
            "name='" + name + '\'' +
            ", extension='" + extension + '\'' +
            '}';
    }
}
