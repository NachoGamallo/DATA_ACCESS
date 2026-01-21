package mainFolder.Ejercicio.module;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuariorutaId implements Serializable {
    private static final long serialVersionUID = -7790503849133412599L;
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(name = "ruta_id", nullable = false)
    private Integer rutaId;

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getRutaId() {
        return rutaId;
    }

    public void setRutaId(Integer rutaId) {
        this.rutaId = rutaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuariorutaId entity = (UsuariorutaId) o;
        return Objects.equals(this.usuarioId, entity.usuarioId) &&
                Objects.equals(this.rutaId, entity.rutaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, rutaId);
    }

    @Override
    public String toString() {
        return "UsuariorutaId{" +
                "usuarioId=" + usuarioId +
                ", rutaId=" + rutaId +
                '}';
    }
}