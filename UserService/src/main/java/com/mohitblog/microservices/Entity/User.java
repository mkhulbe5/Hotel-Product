package com.mohitblog.microservices.Entity;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {


    @Id
    @Column(name = "ID")
    @NotNull
    private String userId;

    @Column(name = "NAME", length = 20)
    @NotNull
    private String name;

    @NotNull
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "ABOUT")
    @NotNull
    private String about;
    
    @Transient
    private List<Rating> ratings=new ArrayList<>();

}
