import java.math.BigInteger;

public class SensorData {
	BigInteger timestamp;
	public BigInteger getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(BigInteger timestamp) {
		this.timestamp = timestamp;
	}
	public Double getAx() {
		return ax;
	}
	public void setAx(Double ax) {
		this.ax = ax;
	}
	public Double getAy() {
		return ay;
	}
	public void setAy(Double ay) {
		this.ay = ay;
	}
	public Double getAz() {
		return az;
	}
	public void setAz(Double az) {
		this.az = az;
	}
	public Double getBx() {
		return bx;
	}
	public void setBx(Double bx) {
		this.bx = bx;
	}
	public Double getBy() {
		return by;
	}
	public void setBy(Double by) {
		this.by = by;
	}
	public Double getBz() {
		return bz;
	}
	public void setBz(Double bz) {
		this.bz = bz;
	}
	Double ax, ay, az, bx, by, bz;
}
