package com.disasterhelp.webapp.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by jovin on 23/12/15.
 */
@MappedSuperclass
public abstract class SuperEntity {

    private Integer id;
    private Disaster disaster;

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disaster")
    public Disaster getDisaster() {
        return this.disaster;
    }

    public void setDisaster(Disaster disaster) {
        this.disaster = disaster;}


}
