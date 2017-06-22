package lt.akademija.resource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * resource class that holds all resource object information
 * 
 * @author orimkus
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "findAllResources", query = "select resource from Resource resource") })
public class Resource {
	/**
	 * Id of resource
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * title of resource
	 */
	private String resourceTitle;
	/**
	 * weight of resource
	 */
	private String resourceWeight;
	/**
	 * sector where is is being held
	 */
	private String resourceKeepingSector;
	/**
	 * date the keeping started
	 */
	private String dateOfKeepingStart;

	public Resource(String resourceTitle, String resourceWeight, String resourceKeepingSector,
			String dateOfKeepingStart) {
		super();
		this.resourceTitle = resourceTitle;
		this.resourceWeight = resourceWeight;
		this.resourceKeepingSector = resourceKeepingSector;
		this.dateOfKeepingStart = dateOfKeepingStart;
	}

	public Resource() {
	}

	public String getResourceTitle() {
		return resourceTitle;
	}

	public void setResourceTitle(String resourceTitle) {
		this.resourceTitle = resourceTitle;
	}

	public String getResourceWeight() {
		return resourceWeight;
	}

	public void setResourceWeight(String resourceWeight) {
		this.resourceWeight = resourceWeight;
	}

	public String getResourceKeepingSector() {
		return resourceKeepingSector;
	}

	public void setResourceKeepingSector(String resourceKeepingSector) {
		this.resourceKeepingSector = resourceKeepingSector;
	}

	public String getDateOfKeepingStart() {
		return dateOfKeepingStart;
	}

	public void setDateOfKeepingStart(String dateOfKeepingStart) {
		this.dateOfKeepingStart = dateOfKeepingStart;
	}

}
