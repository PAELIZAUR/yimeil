package edu.unsada.yimeil.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

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
    private Timestamp receivedAt;
    @OneToMany(mappedBy = "correoByCorreoEmailId")
    private Collection<Attachments> attachmentsByEmailId;
    @OneToMany(mappedBy = "correoByCorreoEmailId")
    private Collection<DestinatariosFrom> destinatariosFromsByEmailId;

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

    public Timestamp getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Timestamp receivedAt) {
        this.receivedAt = receivedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Correo correo = (Correo) o;

        if (emailId != correo.emailId) return false;
        if (subject != null ? !subject.equals(correo.subject) : correo.subject != null) return false;
        if (body != null ? !body.equals(correo.body) : correo.body != null) return false;
        if (receivedAt != null ? !receivedAt.equals(correo.receivedAt) : correo.receivedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emailId;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (receivedAt != null ? receivedAt.hashCode() : 0);
        return result;
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
}
