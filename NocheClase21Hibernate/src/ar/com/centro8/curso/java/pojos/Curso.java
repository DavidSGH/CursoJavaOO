package ar.com.centro8.curso.java.pojos;
// Generated 27/04/2017 21:20:43 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cursos generated by hbm2java
 */
@Entity
@Table(name="cursos"
    ,catalog="colegio"
)
public class Curso  implements java.io.Serializable {


     private Integer id;
     private String titulo;
     private String profesor;
     private String dia;
     private String turno;

    public Curso() {
    }

    public Curso(String titulo, String profesor, String dia, String turno) {
       this.titulo = titulo;
       this.profesor = profesor;
       this.dia = dia;
       this.turno = turno;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="titulo", length=50)
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    @Column(name="profesor", length=20)
    public String getProfesor() {
        return this.profesor;
    }
    
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    
    @Column(name="dia", length=20)
    public String getDia() {
        return this.dia;
    }
    
    public void setDia(String dia) {
        this.dia = dia;
    }

    
    @Column(name="turno", length=20)
    public String getTurno() {
        return this.turno;
    }
    
    public void setTurno(String turno) {
        this.turno = turno;
    }




}


