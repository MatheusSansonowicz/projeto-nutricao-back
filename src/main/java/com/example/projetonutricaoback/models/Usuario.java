package com.example.projetonutricaoback.models;

import com.example.projetonutricaoback.security.domain.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String senha;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    //@GeneratedValue(strategy = GenerationType.UUID)
    //private String Login;

//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String Login;
//
//    public boolean Login() {
//        return false;
//    }
//
//    public boolean Deslogar() {
//        return false;
//    }

    @OneToMany(mappedBy = "usuarioCriadorIngrediente")
    private List<Ingrediente> ingredientesCriados;

    @OneToMany(mappedBy = "usuarioCriadorPreparacao")
    private List<Preparacao> preparacoesCriadas;

//    public boolean equals(String senha) {
//        if (senha == null) return false;
//        return Objects.equals(senha, this.senha);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(senha);
//    }

    public Usuario() {
    }

    public Usuario(String senha, String nome, String email, UserRole role) {
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.role = role;
    }

    public Usuario(List<Preparacao> preparacoesCriadas, List<Ingrediente> ingredientesCriados, String email, String senha, String nome, int id) {
        this.preparacoesCriadas = preparacoesCriadas;
        this.ingredientesCriados = ingredientesCriados;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Ingrediente> getIngredientesCriados() {
        return ingredientesCriados;
    }

    public void setIngredientesCriados(List<Ingrediente> ingredientesCriados) {
        this.ingredientesCriados = ingredientesCriados;
    }

    public List<Preparacao> getPreparacoesCriadas() {
        return preparacoesCriadas;
    }

    public void setPreparacoesCriadas(List<Preparacao> preparacoesCriadas) {
        this.preparacoesCriadas = preparacoesCriadas;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(
                new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_USER")
            );
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}