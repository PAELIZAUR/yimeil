package edu.unsada.yimeil.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Correo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "emailId")
    private int emailId;

    @Basic
    @Column(name = "subject")
    private String subject;

    @Basic
    @Column(name = "body")
    private String body;

    @Basic
    @Column(name = "receivedAt")
    private LocalDateTime receivedAt;  // Usamos LocalDateTime en vez de Timestamp

    @OneToMany(mappedBy = "correoByCorreoEmailId")
    private Collection<Attachments> attachmentsByEmailId;

    @OneToMany(mappedBy = "correoByCorreoEmailId")
    private Collection<DestinatariosFrom> destinatariosFromsByEmailId;

    // Getters y Setters
    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    public Collection<Attachments> getAttachmentsByEmailId() {
        return attachmentsByEmailId;
    }

    public void setAttachmentsByEmailId(Collection<Attachments> attachmentsByEmailId) {
        this.attachmentsByEmailId = attachmentsByEmailId;
    }

    public Collection<DestinatariosFrom> getDestinatariosFromsByEmailId() {
        return destinatariosFromsByEmailId;
    }

    public void setDestinatariosFromsByEmailId(Collection<DestinatariosFrom> destinatariosFromsByEmailId) {
        this.destinatariosFromsByEmailId = destinatariosFromsByEmailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correo correo = (Correo) o;
        return emailId == correo.emailId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailId);
    }
}
