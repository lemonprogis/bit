package com.backpack.model;

import java.io.Serializable;



import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "project"
 *
 * @author ebriggler
 *
 */

@Entity
@Table(name="project", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="Project.countAll", query="SELECT COUNT(x) FROM Project x" )
} )
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="project_id_seq")
    @SequenceGenerator(name="project_id_seq", sequenceName="project_id_seq", allocationSize=1)
    @Column(name="id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="name", nullable=false, length=255)
    private String     name         ;

    @Temporal(TemporalType.DATE)
    @Column(name="start_date", nullable=false)
    private Date       startDate    ;

    @Temporal(TemporalType.DATE)
    @Column(name="target_end_date", nullable=false)
    private Date       targetEndDate ;

    @Temporal(TemporalType.DATE)
    @Column(name="actual_end_date")
    private Date       actualEndDate ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_on")
    private Date       createdOn    ;

    @Column(name="created_by", nullable=false, length=255)
    private String     createdBy    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified_on")
    private Date       modifiedOn   ;

    @Column(name="modified_by", nullable=false, length=255)
    private String     modifiedBy   ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="project", targetEntity=Issue.class)
    private List<Issue> listOfIssue ;

    @OneToMany(mappedBy="project", targetEntity=People.class)
    private List<People> listOfPeople;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Project() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : name ( varchar ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : start_date ( date ) 
    public void setStartDate( Date startDate ) {
        this.startDate = startDate;
    }
    public Date getStartDate() {
        return this.startDate;
    }

    //--- DATABASE MAPPING : target_end_date ( date ) 
    public void setTargetEndDate( Date targetEndDate ) {
        this.targetEndDate = targetEndDate;
    }
    public Date getTargetEndDate() {
        return this.targetEndDate;
    }

    //--- DATABASE MAPPING : actual_end_date ( date ) 
    public void setActualEndDate( Date actualEndDate ) {
        this.actualEndDate = actualEndDate;
    }
    public Date getActualEndDate() {
        return this.actualEndDate;
    }

    //--- DATABASE MAPPING : created_on ( timestamp ) 
    public void setCreatedOn( Date createdOn ) {
        this.createdOn = createdOn;
    }
    public Date getCreatedOn() {
        return this.createdOn;
    }

    //--- DATABASE MAPPING : created_by ( varchar ) 
    public void setCreatedBy( String createdBy ) {
        this.createdBy = createdBy;
    }
    public String getCreatedBy() {
        return this.createdBy;
    }

    //--- DATABASE MAPPING : modified_on ( timestamp ) 
    public void setModifiedOn( Date modifiedOn ) {
        this.modifiedOn = modifiedOn;
    }
    public Date getModifiedOn() {
        return this.modifiedOn;
    }

    //--- DATABASE MAPPING : modified_by ( varchar ) 
    public void setModifiedBy( String modifiedBy ) {
        this.modifiedBy = modifiedBy;
    }
    public String getModifiedBy() {
        return this.modifiedBy;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfIssue( List<Issue> listOfIssue ) {
        this.listOfIssue = listOfIssue;
    }
    public List<Issue> getListOfIssue() {
        return this.listOfIssue;
    }

    public void setListOfPeople( List<People> listOfPeople ) {
        this.listOfPeople = listOfPeople;
    }
    public List<People> getListOfPeople() {
        return this.listOfPeople;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(name);
        sb.append("|");
        sb.append(startDate);
        sb.append("|");
        sb.append(targetEndDate);
        sb.append("|");
        sb.append(actualEndDate);
        sb.append("|");
        sb.append(createdOn);
        sb.append("|");
        sb.append(createdBy);
        sb.append("|");
        sb.append(modifiedOn);
        sb.append("|");
        sb.append(modifiedBy);
        return sb.toString(); 
    } 

}
