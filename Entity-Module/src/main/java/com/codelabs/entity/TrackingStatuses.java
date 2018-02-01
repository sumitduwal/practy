/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sd14d
 */
@Entity
@Table(name = "tbl_tracking_statuses")
@NamedQueries({
    @NamedQuery(name = "TrackingStatuses.findAll", query = "SELECT t FROM TrackingStatuses t")})
public class TrackingStatuses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trackingStatusId")
    private List<Trackings> trackingsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trackingStatusId")
    private List<Tasks> tasksList;

    public TrackingStatuses() {
    }

    public TrackingStatuses(Integer id) {
        this.id = id;
    }

    public TrackingStatuses(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Trackings> getTrackingsList() {
        return trackingsList;
    }

    public void setTrackingsList(List<Trackings> trackingsList) {
        this.trackingsList = trackingsList;
    }

    public List<Tasks> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Tasks> tasksList) {
        this.tasksList = tasksList;
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
        if (!(object instanceof TrackingStatuses)) {
            return false;
        }
        TrackingStatuses other = (TrackingStatuses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.codelabs.entity.TrackingStatuses[ id=" + id + " ]";
    }
    
}
