package model;

//import java.time.LocalDateTime;
import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;
//import java.util.SortedSet;
//import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

//WRONG: import com.sun.istack.internal.Nullable;
import javax.annotation.Nullable;

import model.Person;

@Entity
@Table(name="project")
public class Project implements Comparable<Project> {

	// CONSTRUCTORS:
	
	public Project() {
	}
	
	// DATABASE FIELDS
	
	@Id
	@Column(name="projectID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
    private String name;

	@Nullable
	@Column(name="planningStartYear")
	private Integer planningStartYear;
	@Nullable
	@Column(name="planningEndYear")
	private Integer planningEndYear;
	
	@Nullable
	@Column(name="buildingStartYear")
	private Integer buildingStartYear;
	@Nullable
	@Column(name="buildingEndYear")
	private Integer buildingEndYear;

	
	@Nullable
	@Column (name="sizeQuantity")
	private Float sizeQuantity;
	
	@Nullable
	@Column (name="sizeUnit")
	private String sizeUnit;
	
	@Nullable
	@Column(name="apartmentsQuantity")
	private Integer apartmentsQuantity;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@Nullable
    @Column(name="architects")
    @ManyToMany() //(fetch = FetchType.EAGER) // fetch = FetchType.LAZY // EAGER // TODO IMPROVE with a separate method in DAO? //@ManyToOne // (cascade={CascadeType.ALL}) // @OneToMany(fetch = FetchType.LAZY, mappedBy = "user???")
    @JoinTable(name="project_architect", joinColumns=@JoinColumn(name="personID"), inverseJoinColumns=@JoinColumn(name="projectID"))
	@Cascade(value = { CascadeType.ALL })
    //@JoinColumn(name = "id") // PROPERTY NOT ID FIELD NAME? //"personID") // not parent_sector duh // <key column="sector_id"
	private List<Person> architects = new ArrayList<>();
	//private Set<Person> architects = new HashSet<>();
	
	// (Hoone algne autor)
	@LazyCollection(LazyCollectionOption.FALSE)
	@Nullable
	@Column(name="originalAuthors")
	@ManyToMany()
	@JoinTable(name="project_originalAuthor", joinColumns=@JoinColumn(name="personID"), inverseJoinColumns=@JoinColumn(name="projectID"))
	@Cascade(value = { CascadeType.ALL })
	private List<Person> originalAuthors = new ArrayList<>();

	// Kaastöö?? / Extra comment ???: (nt koostöös arhitektuuribürooga X, … arhitekt Y)
	@LazyCollection(LazyCollectionOption.FALSE)
	@Nullable
    @Column(name="contributors")
    @ManyToMany()
	@JoinTable(name="project_contributor", joinColumns=@JoinColumn(name="personID"), inverseJoinColumns=@JoinColumn(name="projectID"))
    @Cascade(value = { CascadeType.ALL })
	private List<Person> contributors = new ArrayList<>();
	
	// Konstruktor
	@LazyCollection(LazyCollectionOption.FALSE)
	@Nullable
    @Column(name="constructors")
	@ManyToMany()
	@JoinTable(name="project_constructor", joinColumns=@JoinColumn(name="personID"), inverseJoinColumns=@JoinColumn(name="projectID"))
    @Cascade(value = { CascadeType.ALL })
	private List<Person> constructors = new ArrayList<>();
	
	// Sisekujundaja
	@LazyCollection(LazyCollectionOption.FALSE)
	@Nullable
    @Column(name="interiorDesigners")
	@ManyToMany()
	@JoinTable(name="project_interiorDesigner", joinColumns=@JoinColumn(name="personID"), inverseJoinColumns=@JoinColumn(name="projectID"))
    @Cascade(value = { CascadeType.ALL })
	private List<Person> interiorDesigners = new ArrayList<>();

	// Maastiku arhitekt
	@LazyCollection(LazyCollectionOption.FALSE)
	@Nullable
    @Column(name="landscapeArchitects")
    @ManyToMany()
	@JoinTable(name="project_landscapeArchitect", joinColumns=@JoinColumn(name="personID"), inverseJoinColumns=@JoinColumn(name="projectID"))
    @Cascade(value = { CascadeType.ALL })
	private List<Person> landscapeArchitects = new ArrayList<>();

	// Valgustid
	@LazyCollection(LazyCollectionOption.FALSE)
	@Nullable
    @Column(name="lightsDesigners")
    @ManyToMany()
	@JoinTable(name="project_lightsDesigner", joinColumns=@JoinColumn(name="personID"), inverseJoinColumns=@JoinColumn(name="projectID"))
    @Cascade(value = { CascadeType.ALL })
	private List<Person> lightsDesigners = new ArrayList<>();

	// String Prize (preemia): nt Konkursitöö I preemia
	@Column(name="prizeComment")
	private String prizeComment;

	// Address (multiple nt eramute kompleks!!!)
	@LazyCollection(LazyCollectionOption.FALSE)
	@Nullable
    @Column(name="addresses")
    @ManyToMany()
	@JoinTable(name="project_address", joinColumns=@JoinColumn(name="addressID"), inverseJoinColumns=@JoinColumn(name="projectID"))
    @Cascade(value = { CascadeType.ALL })
    //@JoinColumn(name = "id") //(name = "addressID")
    private List<Address> addresses = new ArrayList<>();
	
	// Image(s):  pics
	@LazyCollection(LazyCollectionOption.FALSE)
	@Nullable
    @Column(name="images")
    @ManyToMany()
	@JoinTable(name="project_images", joinColumns=@JoinColumn(name="imageID"), inverseJoinColumns=@JoinColumn(name="projectID"))
    @Cascade(value = { CascadeType.ALL })
	private List<Image> images = new ArrayList<>();
	
	// Image(s) drawings
	
	@LazyCollection(LazyCollectionOption.FALSE)
	////Project Group üks grupp, mitu projekti, OneToMany
	// ManyToOne siin
	@Nullable
    //@Column(name="projectGroup") // @Column(s) not allowed on a @ManyToOne property: model.Project.projectGroup
    @ManyToOne() 
    //@Cascade(value = { CascadeType.ALL })
    @JoinColumn(name = "id") //(name="projectGroupID")
	private ProjectGroup projectGroup;

	@Column(name="imagesRootFolder")
	private String imagesRootFolder;

	// GETTERS & SETTERS:
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPlanningStartYear() {
		return planningStartYear;
	}

	public void setPlanningStartYear(Integer planningStartYear) {
		this.planningStartYear = planningStartYear;
	}

	public Integer getPlanningEndYear() {
		return planningEndYear;
	}

	public void setPlanningEndYear(Integer planningEndYear) {
		this.planningEndYear = planningEndYear;
	}

	public Integer getBuildingStartYear() {
		return buildingStartYear;
	}

	public void setBuildingStartYear(Integer buildingStartYear) {
		this.buildingStartYear = buildingStartYear;
	}

	public Integer getBuildingEndYear() {
		return buildingEndYear;
	}

	public void setBuildingEndYear(Integer buildingEndYear) {
		this.buildingEndYear = buildingEndYear;
	}

	public Float getSizeQuantity() {
		return sizeQuantity;
	}

	public void setSizeQuantity(Float sizeQuantity) {
		this.sizeQuantity = sizeQuantity;
	}

	public String getSizeUnit() {
		return sizeUnit;
	}

	public void setSizeUnit(String sizeUnit) {
		this.sizeUnit = sizeUnit;
	}

	public Integer getApartmentsQuantity() {
		return apartmentsQuantity;
	}

	public void setApartmentsQuantity(Integer apartmentsQuantity) {
		this.apartmentsQuantity = apartmentsQuantity;
	}

	public List<Person> getArchitects() {
		return architects;
	}

	public void setArchitects(List<Person> architects) {
		this.architects = architects;
	}

	public List<Person> getOriginalAuthors() {
		return originalAuthors;
	}

	public void setOriginalAuthors(List<Person> originalAuthors) {
		this.originalAuthors = originalAuthors;
	}

	public List<Person> getContributors() {
		return contributors;
	}

	public void setContributors(List<Person> contributors) {
		this.contributors = contributors;
	}

	public List<Person> getConstructors() {
		return constructors;
	}

	public void setConstructors(List<Person> constructors) {
		this.constructors = constructors;
	}

	public List<Person> getInteriorDesigners() {
		return interiorDesigners;
	}

	public void setInteriorDesigners(List<Person> interiorDesigners) {
		this.interiorDesigners = interiorDesigners;
	}

	public List<Person> getLandscapeArchitects() {
		return landscapeArchitects;
	}

	public void setLandscapeArchitects(List<Person> landscapeArchitects) {
		this.landscapeArchitects = landscapeArchitects;
	}

	public List<Person> getLightsDesigners() {
		return lightsDesigners;
	}

	public void setLightsDesigners(List<Person> lightsDesigners) {
		this.lightsDesigners = lightsDesigners;
	}

	public String getPrizeComment() {
		return prizeComment;
	}

	public void setPrizeComment(String prizeComment) {
		this.prizeComment = prizeComment;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public ProjectGroup getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(ProjectGroup projectGroup) {
		this.projectGroup = projectGroup;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	
	public void setImagesArray(String folder, String[] imageNames) {
		List<Image> images = new ArrayList<Image>();
		for(String image : imageNames){
			images.add(new Image(folder,image));
		}
		this.images = images;
	}
	
	public String getImagesRootFolder() {
		return imagesRootFolder;
	}

	public void setImagesRootFolder(String imagesRootFolder) {
		this.imagesRootFolder = imagesRootFolder;
	}

	// EXTRA METHODS:
	@Override
	public int compareTo(Project o) {
		//System.out.println("[Project][compareTo] this name: " + this.name + " comparing to " + o.getName());
		return this.name.compareTo( o.getName() );
	}
	
}
