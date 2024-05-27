package goodsTst;

public class GoodsVO {
	private String gcode;
	private String gname;
	private String gprice;
	private String gtotal;
	
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	
	public String getGprice() {
		return gprice;
	}
	public void setGprice(String gprice) {
		this.gprice = gprice;
	}
	
	public String getGtotal() {
		return gtotal;
	}
	public void setGtotal(String gtotal) {
		this.gtotal = gtotal;
	}
	
	@Override
	public String toString() {
		return gcode + ":" + gname + ":" + gprice + ":" + gtotal;
	}
}
