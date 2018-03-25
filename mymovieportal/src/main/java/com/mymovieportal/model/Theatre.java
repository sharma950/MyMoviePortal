package com.mymovieportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "theatre")
public class Theatre {

    @Id
    @Column(name = "theatre_id")
    private String theatreId;

    @Column(name = "theatre_name")
    private String theatreName;


    public Theatre() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

}
