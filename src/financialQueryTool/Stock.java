package financialQueryTool;

public class Stock {
	public String prevClose;
	public String open;
	public String ask;
	public String oneYrTarg;
	public String beta;
	public String earnDate;
	public String daysRng;
	public String wk52Rng;
	public String vol;
	public String avgVol;
	public String mktCap;
	public String peTtm;
	public String epsTtm;
	public String divnYield;
	
	public String getPrevClose() {
		return prevClose;
	}
	public void setPrevClose(String prevClose) {
		this.prevClose = prevClose;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getAsk() {
		return ask;
	}
	public void setAsk(String ask) {
		this.ask = ask;
	}
	public String getOneYrTarg() {
		return oneYrTarg;
	}
	public void setOneYrTarg(String oneYrTarg) {
		this.oneYrTarg = oneYrTarg;
	}
	public String getBeta() {
		return beta;
	}
	public void setBeta(String beta) {
		this.beta = beta;
	}
	public String getEarnDate() {
		return earnDate;
	}
	public void setEarnDate(String earnDate) {
		this.earnDate = earnDate;
	}
	public String getDaysRng() {
		return daysRng;
	}
	public void setDaysRng(String daysRng) {
		this.daysRng = daysRng;
	}
	public String getWk52Rng() {
		return wk52Rng;
	}
	public void setWk52Rng(String wk52Rng) {
		this.wk52Rng = wk52Rng;
	}
	public String getVol() {
		return vol;
	}
	public void setVol(String vol) {
		this.vol = vol;
	}
	public String getAvgVol() {
		return avgVol;
	}
	public void setAvgVol(String avgVol) {
		this.avgVol = avgVol;
	}
	public String getMktCap() {
		return mktCap;
	}
	public void setMktCap(String mktCap) {
		this.mktCap = mktCap;
	}
	public String getPeTtm() {
		return peTtm;
	}
	public void setPeTtm(String peTtm) {
		this.peTtm = peTtm;
	}
	public String getEpsTtm() {
		return epsTtm;
	}
	public void setEpsTtm(String epsTtm) {
		this.epsTtm = epsTtm;
	}
	public String getDivnYield() {
		return divnYield;
	}
	public void setDivnYield(String divnYield) {
		this.divnYield = divnYield;
	}
	/**
	 * @param prevClose
	 * @param open
	 * @param ask
	 * @param oneYrTarg
	 * @param beta
	 * @param earnDate
	 * @param daysRng
	 * @param wk52Rng
	 * @param vol
	 * @param avgVol
	 * @param mktCap
	 * @param peTtm
	 * @param epsTtm
	 * @param divnYield
	 */
	public Stock(String prevClose, String open, String ask, String oneYrTarg,
			String beta, String earnDate, String daysRng, String wk52Rng,
			String vol, String avgVol, String mktCap, String peTtm,
			String epsTtm, String divnYield) {

		this.prevClose = prevClose;
		this.open = open;
		this.ask = ask;
		this.oneYrTarg = oneYrTarg;
		this.beta = beta;
		this.earnDate = earnDate;
		this.daysRng = daysRng;
		this.wk52Rng = wk52Rng;
		this.vol = vol;
		this.avgVol = avgVol;
		this.mktCap = mktCap;
		this.peTtm = peTtm;
		this.epsTtm = epsTtm;
		this.divnYield = divnYield;
	}
	@SuppressWarnings("unused")
	private Stock(){
		
	}

}
