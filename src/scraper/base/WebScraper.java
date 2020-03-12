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
	 * 
	 */
	private int depth;
	/**
	 * String object representing the url to scrape.
	 */
	private String url = "";
	
	/**
	 * Builds a new WebScraper that should start at the
	 * provided URL and will explore recursively to a
	 * specified depth.
	 * 
	 * @param urlIn The URL to begin exploring for images.
	 * @param depthIn The recursive depth to explore, must be >= 0.
	 * Negative values will be treated as equivalent to 0.
	 */
	public WebScraper(String urlIn, int depthIn)
	{
		this.setDepth(depthIn);
		this.setURL(urlIn);
	}
	
	/**
	 * Updates this WebScraper to explore to a newdepth.
	 * @param depthIn The recursive depth to explore, must be >= 0.
	 * Negative values will be treated as equivalent to 0.
	 */
	public void setDepth(int depthIn)
	{
		this.depth = (depthIn >= 0) ? depthIn : 0;
	}
	
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
	 * Retrieves the exploration depth of this WebScraper.
	 * @return The depth stored in this WebScraper.
	 */
	public int getDepth()
	{
		return this.depth;
	}
	
	/**
	 * Updates the base URL to explore for this WebScraper.
	 * 
	 * @param urlIn The new URL to explore. The WebScraper url is only
	 * changed if the url value is valid (not null or empty).
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
	 * This method will recursively explore pages starting at the
	 * base url defined for this WebScraper to the depth for which
	 * the scraper is configured.
	 * 
	 * The ResultSet will contain all images discovered along the way,
	 * with images from a page being explored stored in the ResultSet prior to any images
	 * found on linked pages. ImageEntries will always appear in the ResultSet
	 * in the order in which the corresponding <img> tags are given in
	 * the HTML files. Only the first occurrence of a particular image (by absolute
	 * URL) is stored in the ResultSet.
	 * 
	 * Links on a page will be explored in the sequential order in which their
	 * corresponding <a> tags appear in the HTML file. The same URL
	 * should never be crawled more than once, even if it is linked from itsel
	 * for another later page.
	 * 
	 * @return The set of ImageEntry objects resulting from this recursive crawl.
	 */
	public ResultSet crawlPage()
	{
		
	}
	
	/**
	 * Retrieves the historical trail of pages visited during the last
	 * top-level call to crawlPage.
	 * 
	 * @return The most recent collection of pages visited. If the crawlPage
	 * method has not been previously called, the PageHistory object will be empty.
	 */
	public PageHistory getPageHistory()
	{
		
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
