// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline, Nate Tyler
// RESOURCES: No external resources were referenced or used.

package scraper.base;
/**
 * This class stores information about each image found while crawling pages. Image URLs are saved along 
 * with the URL for the page on which the image appears.
 * @author tntcl
 *
 */
public class ImageEntry 
{
	/**
	 * Stores the address of the page to be scraped
	 */
	private String pageAddress;
	/**
	 * Stores the address of the image
	 */
	private String imgAddress;
	
	public ImageEntry(String pageAdIn, String imgAdIn)
	{
		if (pageAdIn != null && pageAdIn != "")
		{
			this.pageAddress = pageAdIn;
		}
		
		if (imgAdIn != null && imgAdIn != "")
		{
			this.imgAddress = imgAdIn;
		}
	}
	
	/**
	 * Retrieves the source page URL.
	 * @return The web page where the image of this ImageEntry can be found.
	 */
	public String getPageLocation()
	{
		return this.pageAddress;
	}
	
	/**
	 * Retrieves the direct image URL.
	 * @return The full URL of image file itself.
	 */
	public String getImgLocation()
	{
		return this.imgAddress;
	}
	
	/**
	 * Compares this ImageEntry to another object for equality based on the URL of the image file. 
	 * Two ImageEntries with the same image URL but different page URLs will be considered equivalent.
	 * @Overrides equals in class java.lang.Object
	 * @return true if this ImageEntry and other refer to the same image as file on the Web; false otherwise
	 */
	public boolean equals(Object o)
	{
		boolean temp = false;
		if (o instanceof ImageEntry)
		{
			ImageEntry other = (ImageEntry)o;
			temp = this.getImgLocation().equals(other.getImgLocation());
		}
		return temp;
	}
}
