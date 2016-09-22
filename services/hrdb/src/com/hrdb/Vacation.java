/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.hrdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Arrays;
import javax.persistence.Transient;
import javax.persistence.CascadeType;

/**
 * Vacation generated by hbm2java
 */
@Entity
@Table(name = "VACATION", schema = "PUBLIC", catalog = "PUBLIC")
public class Vacation implements java.io.Serializable {

    private Integer id;

    private Employee employee;

    private Date startdate;

    private Date enddate;

    private Integer tenantid;

    private int empid;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMPID", nullable = false)
    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "STARTDATE", length = 10)
    public Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "ENDDATE", length = 10)
    public Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Column(name = "TENANTID")
    public Integer getTenantid() {
        return this.tenantid;
    }

    public void setTenantid(Integer tenantid) {
        this.tenantid = tenantid;
    }

    @Column(name = "`EMPID`", nullable = false, precision = 19, scale = 0)
    public int getEmpid() {
        return this.empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public Vacation() {
    }

    public Vacation(Employee employee) {
        this.employee = employee;
    }

    public Vacation(Employee employee, Date startdate, Date enddate, Integer tenantid) {
        this.employee = employee;
        this.startdate = startdate;
        this.enddate = enddate;
        this.tenantid = tenantid;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null))
            return false;
        if (!(o instanceof Vacation))
            return false;
        Vacation that = (Vacation) o;
        return ((this.getId() == that.getId()) || (this.getId() != null && that.getId() != null && this.getId().equals(that.getId())));
    }

    public int hashCode() {
        int result = 17;
        result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
        return result;
    }
}
