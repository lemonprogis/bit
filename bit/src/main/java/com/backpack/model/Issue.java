package com.backpack.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "issue"
 *
 * @author ebriggler
 *
 */

@Entity
@Table(name="issue", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="Issue.countAll", query="SELECT COUNT(x) FROM Issue x" )
} )
public class Issue implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="issue_id_seq")
    @SequenceGenerator(name="issue_id_seq", sequenceName="issue_id_seq", allocationSize=1)
    @Column(name="id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="summary", nullable=false, length=255)
    private String     summary      ;

    @Column(name="description", length=2147483647)
    private String     description  ;

    @Temporal(TemporalType.DATE)
    @Column(name="identified_date", nullable=false)
    private Date       identifiedDate ;

    @Column(name="status", nullable=false, length=30)
    private String     status       ;

    @Column(name="priority", length=30)
    private String     priority     ;

    @Temporal(TemporalType.DATE)
    @Column(name="target_resolution_date")
    private Date       targetResolutionDate ;

    @Column(name="progress", length=2147483647)
    private String     progress     ;

    @Temporal(TemporalType.DATE)
    @Column(name="actual_resolution_date")
    private Date       actualResolutionDate ;

    @Column(name="resolution_summary", length=2147483647)
    private String     resolutionSummary ;

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

	// "identifiedPersonId" (column "identified_person_id") is not defined by itself because used as FK in a link 
	// "relatedProjectId" (column "related_project_id") is not defined by itself because used as FK in a link 
	// "assignedPersonId" (column "assigned_person_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="identified_person_id", referencedColumnName="id")
    private People people2     ;

    @ManyToOne
    @JoinColumn(name="assigned_person_id", referencedColumnName="id")
    private People people      ;

    @ManyToOne
    @JoinColumn(name="related_project_id", referencedColumnName="id")
    private Project project     ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Issue() {
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
    //--- DATABASE MAPPING : summary ( varchar ) 
    public void setSummary( String summary ) {
        this.summary = summary;
    }
    public String getSummary() {
        return this.summary;
    }

    //--- DATABASE MAPPING : description ( text ) 
    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    //--- DATABASE MAPPING : identified_date ( date ) 
    public void setIdentifiedDate( Date identifiedDate ) {
        this.identifiedDate = identifiedDate;
    }
    public Date getIdentifiedDate() {
        return this.identifiedDate;
    }

    //--- DATABASE MAPPING : status ( varchar ) 
    public void setStatus( String status ) {
        this.status = status;
    }
    public String getStatus() {
        return this.status;
    }

    //--- DATABASE MAPPING : priority ( varchar ) 
    public void setPriority( String priority ) {
        this.priority = priority;
    }
    public String getPriority() {
        return this.priority;
    }

    //--- DATABASE MAPPING : target_resolution_date ( date ) 
    public void setTargetResolutionDate( Date targetResolutionDate ) {
        this.targetResolutionDate = targetResolutionDate;
    }
    public Date getTargetResolutionDate() {
        return this.targetResolutionDate;
    }

    //--- DATABASE MAPPING : progress ( text ) 
    public void setProgress( String progress ) {
        this.progress = progress;
    }
    public String getProgress() {
        return this.progress;
    }

    //--- DATABASE MAPPING : actual_resolution_date ( date ) 
    public void setActualResolutionDate( Date actualResolutionDate ) {
        this.actualResolutionDate = actualResolutionDate;
    }
    public Date getActualResolutionDate() {
        return this.actualResolutionDate;
    }

    //--- DATABASE MAPPING : resolution_summary ( text ) 
    public void setResolutionSummary( String resolutionSummary ) {
        this.resolutionSummary = resolutionSummary;
    }
    public String getResolutionSummary() {
        return this.resolutionSummary;
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
    public void setPeople2( People people2 ) {
        this.people2 = people2;
    }
    public People getPeople2() {
        return this.people2;
    }

    public void setPeople( People people ) {
        this.people = people;
    }
    public People getPeople() {
        return this.people;
    }

    public void setProject( Project project ) {
        this.project = project;
    }
    public Project getProject() {
        return this.project;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(summary);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(identifiedDate);
        sb.append("|");
        sb.append(status);
        sb.append("|");
        sb.append(priority);
        sb.append("|");
        sb.append(targetResolutionDate);
        sb.append("|");
        sb.append(progress);
        sb.append("|");
        sb.append(actualResolutionDate);
        sb.append("|");
        sb.append(resolutionSummary);
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
