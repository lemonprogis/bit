package com.backpack.model;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "people"
 *
 * @author ebriggler
 *
 */

@Entity
@Table(name="people", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="People.countAll", query="SELECT COUNT(x) FROM People x" )
} )
public class People implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="people_id_seq")
    @SequenceGenerator(name="people_id_seq", sequenceName="people_id_seq", allocationSize=1)
    @Column(name="id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="name", nullable=false, length=255)
    private String     name         ;

    @Column(name="email", nullable=false, length=255)
    private String     email        ;

    @Column(name="role", nullable=false, length=30)
    private String     role         ;

    @Column(name="username", nullable=false, length=255)
    private String     username     ;

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

	// "projectId" (column "project_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="people", targetEntity=Issue.class)
    private List<Issue> listOfIssue ;

    @ManyToOne
    @JoinColumn(name="project_id", referencedColumnName="id")
    private Project project     ;

    @OneToMany(mappedBy="people2", targetEntity=Issue.class)
    private List<Issue> listOfIssue2;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public People() {
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

    //--- DATABASE MAPPING : email ( varchar ) 
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    //--- DATABASE MAPPING : role ( varchar ) 
    public void setRole( String role ) {
        this.role = role;
    }
    public String getRole() {
        return this.role;
    }

    //--- DATABASE MAPPING : username ( varchar ) 
    public void setUsername( String username ) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
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

    public void setProject( Project project ) {
        this.project = project;
    }
    public Project getProject() {
        return this.project;
    }

    public void setListOfIssue2( List<Issue> listOfIssue2 ) {
        this.listOfIssue2 = listOfIssue2;
    }
    public List<Issue> getListOfIssue2() {
        return this.listOfIssue2;
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
        sb.append(email);
        sb.append("|");
        sb.append(role);
        sb.append("|");
        sb.append(username);
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
