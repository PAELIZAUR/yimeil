package edu.unsada.yimeil.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "destinatarios_from", schema = "yimeil", catalog = "")
public class DestinatariosFrom {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idfrom")
    private int idfrom;

    @Basic
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "correo_emailId", referencedColumnName = "emailId", nullable = false)
    private Correo correoByCorreoEmailId;

    // Getters y Setters
    public int getIdfrom() {
        return idfrom;
    }

    public void setIdfrom(int idfrom) {
        this.idfrom = idfrom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        DestinatariosFrom that = (DestinatariosFrom) o;
        return idfrom == that.idfrom &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfrom, email);
    }
}
