package edu.unsada.yimeil.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Attachments {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idattachments")
    private int idattachments;

    @Basic
    @Column(name = "filename")
    private String filename;

    @Basic
    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "correo_emailId", referencedColumnName = "emailId", nullable = false)
    private Correo correoByCorreoEmailId;

    // Getters y Setters
    public int getIdattachments() {
        return idattachments;
    }

    public void setIdattachments(int idattachments) {
        this.idattachments = idattachments;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Correo getCorreoByCorreoEmailId() {
        return correoByCorreoEmailId;
    }

    public void setCorreoByCorreoEmailId(Correo correoByCorreoEmailId) {
        this.correoByCorreoEmailId = correoByCorreoEmailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attachments that = (Attachments) o;
        return idattachments == that.idattachments &&
                Objects.equals(filename, that.filename) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idattachments, filename, url);
    }
}
