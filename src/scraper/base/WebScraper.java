// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline, Nate Tyler
// RESOURCES: No external resources were referenced or used.

package scraper.base;
import scraper.utils.*;
/**
 *This class provides a simple mechanism to crawl a series of webpages recursively and extract 
 *all of the images that are found on the pages visited.
 * @author nytler, bcline
 */
public class WebScraper 
{
	/**
	 * Stores the URL of the site to be scraped
	 */
	private String url;
	/**
	 * Stores the value for how far the web scraper will scrape
	 */
	private int depth;
	
	/**
	 * Builds a new WebScraper that should start at the provided URL and will by default explore that page 
	 * at a depth of 0. This allows extracting just the details from this page and nothing else.
	 * @param urlIn - The URL to begin exploring for images.
	 */
	public WebScraper(String urlIn)
	{
		this.url = urlIn;
		this.depth = 0;
	}
	
	/**
	 * Builds a new WebScraper that should start at the provided URL and will explore recursively to a 
	 * specified depth.
	 * @param urlIn - The URL to begin exploring for images.
	 * @param depthIn - The recursive depth to explore, must be >= 0. Negative values will be 
	 * treated as equivalent to 0.
	 */
	public WebScraper(String urlIn, int depthIn)
	{
		this.url = urlIn;
		setDepth(depthIn);
	}
	
	/**
	 * Updates this WebScraper to explore to a new depth.
	 * @param depthIn - The recursive depth to explore, must be >= 0. Negative values will be treated 
	 * as equivalent to 0.
	 */
	public void setDepth(int depthIn)
	{
		if (depthIn >= 0)
		{
			this.depth = depthIn;
		}
		else
		{
			this.depth = 0;
		}
	}
	
	/**
	 * Retrieves the exploration depth of this WebScraper.
	 * @return The depth stored in this WebScraper.
	 */
	public int getDepth()
	{
		return this.depth;
	}
	
	/**
	 * Updates the base URL to explore for this WebScraper.
	 * @param urlIn - The new URL to explore. The WebScraper url is only changed if the url value 
	 * is valid (not null or empty).
	 */
	public void setURL(String urlIn)
	{
		if (urlIn != null && urlIn != "")
		{
			this.url = urlIn;
		}
	}
	
	/**
	 * Retrieves the base url for exploration by this WebScraper.
	 * @return The base url.
	 */
	public String getURL()
	{
		return this.url;
	}
	
	/**
	 * Retrieves the set of images found directly at the initial base URL for this WebScraper. 
	 * This method will not explore any links found at the base page. Image information should be 
	 * stored in the order in which their corresponding <img> tags appear in the source HTML code. 
	 * If an image appears more than once in a page, only one entry should appear in the ResultSet.
	 * @return
	 */
	public scraper.utils.ResultSet getImages()
	{
		Document page = new Document();
		page.loadPageFromURL(this.url);
		
		ResultSet result = new ResultSet();
		
		Elements img;
		
		img = page.getElementsByTag("img");
		while (img.hasNextElement())
		{
			ImageEntry ent = new ImageEntry(this.url, img.getNextElement().getInnerHTML());
			if (!result.contains(ent.getImgLocation()))
			{
				result.addResult(ent);
			}
		}
		
		return result;
	}
}
