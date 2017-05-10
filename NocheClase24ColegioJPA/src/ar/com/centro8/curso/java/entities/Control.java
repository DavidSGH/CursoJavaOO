package ar.com.centro8.curso.java.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dsgonzalez
 */
@Entity
@Table(name = "control")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Control.findAll", query = "SELECT c FROM Control c")
    , @NamedQuery(name = "Control.findById", query = "SELECT c FROM Control c WHERE c.id = :id")
    , @NamedQuery(name = "Control.findByUsuario", query = "SELECT c FROM Control c WHERE c.usuario = :usuario")
    , @NamedQuery(name = "Control.findByTerminal", query = "SELECT c FROM Control c WHERE c.terminal = :terminal")
    , @NamedQuery(name = "Control.findByFechaHora", query = "SELECT c FROM Control c WHERE c.fechaHora = :fechaHora")
    , @NamedQuery(name = "Control.findByTabla", query = "SELECT c FROM Control c WHERE c.tabla = :tabla")
    , @NamedQuery(name = "Control.findByAccion", query = "SELECT c FROM Control c WHERE c.accion = :accion")
    , @NamedQuery(name = "Control.findByIdRegistro", query = "SELECT c FROM Control c WHERE c.idRegistro = :idRegistro")})
public class Control implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "terminal")
    private String terminal;
    @Basic(optional = false)
    @Column(name = "fechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @Basic(optional = false)
    @Column(name = "tabla")
    private String tabla;
    @Basic(optional = false)
    @Column(name = "accion")
    private String accion;
    @Column(name = "idRegistro")
    private Integer idRegistro;

    public Control() {
    }

    public Control(Integer id) {
        this.id = id;
    }

    public Control(String usuario, String terminal, Date fechaHora, String tabla, String accion, Integer idRegistro) {
        this.usuario = usuario;
        this.terminal = terminal;
        this.fechaHora = fechaHora;
        this.tabla = tabla;
        this.accion = accion;
        this.idRegistro = idRegistro;
    }

    public Control(Integer id, String usuario, String terminal, Date fechaHora, String tabla, String accion) {
        this.id = id;
        this.usuario = usuario;
        this.terminal = terminal;
        this.fechaHora = fechaHora;
        this.tabla = tabla;
        this.accion = accion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Control)) {
            return false;
        }
        Control other = (Control) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.centro8.curso.java.entities.Control[ id=" + id + " ]";
    }
    
}
