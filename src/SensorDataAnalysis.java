import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class SensorDataAnalysis {

	static int searchContinuityAboveValue(String data, int indexBegin, int indexEnd, Double threshold,
			int winLength) {
		
		String csvFile = data;
		BufferedReader br = null;
		String line = "";

		ArrayList<SensorData> map = new ArrayList<SensorData>();
		int filecount = 0;
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				SensorData sensordata = new SensorData();
		
				String[] country = line.split(",");
				sensordata.setTimestamp(BigInteger.valueOf(Long.valueOf(country[0])));
				sensordata.setAx(Double.valueOf(country[1]));
				sensordata.setAy(Double.valueOf(country[2]));
				sensordata.setAz(Double.valueOf(country[3]));
				sensordata.setBx(Double.valueOf(country[4]));
				sensordata.setBy(Double.valueOf(country[5]));
				sensordata.setBz(Double.valueOf(country[6]));
				map.add(sensordata);

				filecount++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		int count = 0;
		int index = 0;
		if ((indexEnd - indexBegin) < winLength)
			return -1;
		ArrayList<Integer> samples = new ArrayList<Integer>();
		for (int i = indexBegin; i <= indexEnd; i++) {
			SensorData obj = map.get(i);
			if ((obj.getAx() >= threshold || obj.getAy() >= threshold || obj.getAz() >= threshold
					|| obj.getBx() >= threshold || obj.getBy() >= threshold || obj.getBz() >= threshold)
					&& count < winLength) {
				if ((index + 1) != i && index != 0 && index != indexBegin) {
					count = 0;
					index = 0;
					samples.removeAll(samples);
				} else {
					samples.add(i);
					index = i;
					count++;
				}
			} else {
				if (count >= winLength) {
					return samples.get(0);
				} else {
					return -1;
				}
			}
		}
		return 0;
	}

	static int backSearchContinuityWithinRange(String data, int indexBegin, int indexEnd, Double thresholdLo,
			Double thresholdHi, int winLength) {
		
		
		String csvFile = data;
		BufferedReader br = null;
		String line = "";

		ArrayList<SensorData> map = new ArrayList<SensorData>();
		int filecount = 0;
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				SensorData sensordata = new SensorData();
		
				String[] country = line.split(",");
				sensordata.setTimestamp(BigInteger.valueOf(Long.valueOf(country[0])));
				sensordata.setAx(Double.valueOf(country[1]));
				sensordata.setAy(Double.valueOf(country[2]));
				sensordata.setAz(Double.valueOf(country[3]));
				sensordata.setBx(Double.valueOf(country[4]));
				sensordata.setBy(Double.valueOf(country[5]));
				sensordata.setBz(Double.valueOf(country[6]));
				map.add(sensordata);

				filecount++;
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		int count = 0;
		int index = indexBegin;
		if ((indexBegin - indexEnd) < winLength)
			return -1;

		ArrayList<Integer> samples = new ArrayList<Integer>();

		for (int i = indexBegin; i >= indexEnd; i--) {
			SensorData obj = map.get(i);

			if (((obj.getAx() >= thresholdLo && obj.getAx() <= thresholdHi)
					|| (obj.getAy() >= thresholdLo && obj.getAy() <= thresholdHi)
					|| (obj.getAz() >= thresholdLo && obj.getAz() <= thresholdHi)
					|| (obj.getBx() >= thresholdLo && obj.getBx() <= thresholdHi)
					|| (obj.getBy() >= thresholdLo && obj.getBy() <= thresholdHi)
					|| (obj.getBz() >= thresholdLo && obj.getBz() <= thresholdHi)) && count < winLength) {
				if ((index - 1) != i && index != indexBegin) {
					count = 0;
					index = 0;
					samples.removeAll(samples);
				} else {
					samples.add(i);
					index = i;
					count++;
				}
			} else {
				if (count >= winLength) {
					return samples.get(0);
				} else {
					return -1;
				}
			}
		}
		return 0;
	}

	static int searchContinuityAboveValueTwoSignals(String data1,
			String data2, int indexBegin, int indexEnd, Double threshold1,
			Double threshold2, int winLength) {
		
		String csvFile1 = data1;
		String csvFile2 = data2;
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		String line = "";

		ArrayList<SensorData> map1 = new ArrayList<SensorData>();
		ArrayList<SensorData> map2 = new ArrayList<SensorData>();
		int filecount1 = 0,filecount2 =0;
		try {

			br1 = new BufferedReader(new FileReader(csvFile1));
			while ((line = br1.readLine()) != null) {
				SensorData sensordata = new SensorData();
		
				String[] country = line.split(",");
				sensordata.setTimestamp(BigInteger.valueOf(Long.valueOf(country[0])));
				sensordata.setAx(Double.valueOf(country[1]));
				sensordata.setAy(Double.valueOf(country[2]));
				sensordata.setAz(Double.valueOf(country[3]));
				sensordata.setBx(Double.valueOf(country[4]));
				sensordata.setBy(Double.valueOf(country[5]));
				sensordata.setBz(Double.valueOf(country[6]));
				map1.add(sensordata);

				filecount1++;
			}
			
			
			br2 = new BufferedReader(new FileReader(csvFile2));
			while ((line = br2.readLine()) != null) {
				SensorData sensordata = new SensorData();
		
				String[] country = line.split(",");
				sensordata.setTimestamp(BigInteger.valueOf(Long.valueOf(country[0])));
				sensordata.setAx(Double.valueOf(country[1]));
				sensordata.setAy(Double.valueOf(country[2]));
				sensordata.setAz(Double.valueOf(country[3]));
				sensordata.setBx(Double.valueOf(country[4]));
				sensordata.setBy(Double.valueOf(country[5]));
				sensordata.setBz(Double.valueOf(country[6]));
				map2.add(sensordata);

				filecount2++;
			}
			
			
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br1 != null) {
				try {
					br1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br2 != null) {
				try {
					br2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
		
		
		int count = 0;
		int index = 0;
		if ((indexEnd - indexBegin) < winLength)
			return -1;
		ArrayList<Integer> samples = new ArrayList<Integer>();
		for (int i = indexBegin; i <= indexEnd; i++) {
			SensorData obj1 = map1.get(i);
			SensorData obj2 = map2.get(i);
			if ((obj1.getAx() >= threshold1 || obj1.getAy() >= threshold1 || obj1.getAz() >= threshold1
					|| obj1.getBx() >= threshold1 || obj1.getBy() >= threshold1 || obj1.getBz() >= threshold1) 
					&& (obj2.getAx() >= threshold2 || obj2.getAy() >= threshold2 || obj2.getAz() >= threshold2
							|| obj2.getBx() >= threshold2 || obj2.getBy() >= threshold2 || obj2.getBz() >= threshold2)
					&& count < winLength) {
				if ((index + 1) != i && index != 0) {
					count = 0;
					index = 0;
					samples.removeAll(samples);
				} else {
					samples.add(i);
					index = i;
					count++;
				}
			} else {
				if (count >= winLength) {
					return samples.get(0);
				} else {
					return -1;
				}
			}
		}
		return 0;
	}


	static String searchMultiContinuityWithinRange(String data, int indexBegin, int indexEnd, Double thresholdLo, Double thresholdHi, int
	  winLength) {
		 
		 
		 String csvFile = data;
			BufferedReader br = null;
			String line = "";

			ArrayList<SensorData> map = new ArrayList<SensorData>();
			int filecount = 0;
			try {

				br = new BufferedReader(new FileReader(csvFile));
				while ((line = br.readLine()) != null) {
					SensorData sensordata = new SensorData();
			
					String[] country = line.split(",");
					sensordata.setTimestamp(BigInteger.valueOf(Long.valueOf(country[0])));
					sensordata.setAx(Double.valueOf(country[1]));
					sensordata.setAy(Double.valueOf(country[2]));
					sensordata.setAz(Double.valueOf(country[3]));
					sensordata.setBx(Double.valueOf(country[4]));
					sensordata.setBy(Double.valueOf(country[5]));
					sensordata.setBz(Double.valueOf(country[6]));
					map.add(sensordata);

					filecount++;
				}
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		 
		 
		 
		 int count = 0;
			int index = indexBegin;
			if ((indexEnd - indexBegin) < winLength)
				return "-1";

			ArrayList<Integer> samples = new ArrayList<Integer>();

			for (int i = indexBegin; i <= indexEnd; i++) {
				SensorData obj = map.get(i);

				if (((obj.getAx() >= thresholdLo && obj.getAx() <= thresholdHi)
						|| (obj.getAy() >= thresholdLo && obj.getAy() <= thresholdHi)
						|| (obj.getAz() >= thresholdLo && obj.getAz() <= thresholdHi)
						|| (obj.getBx() >= thresholdLo && obj.getBx() <= thresholdHi)
						|| (obj.getBy() >= thresholdLo && obj.getBy() <= thresholdHi)
						|| (obj.getBz() >= thresholdLo && obj.getBz() <= thresholdHi)) && count < winLength) {
					if ((index + 1) != i && index != 0) {
						count = 0;
						index = 0;
						samples.removeAll(samples);
					} else {
						samples.add(i);
						index = i;
						count++;
					}
				} else {
					if (count >= winLength) {
						return samples.get(0)+ " " +samples.get(samples.size()-1);
					} else {
						return "-1";
					}
				}
			}
			return "0";
	 }
	 
	public static void main(String[] args) {

	//	SensorDataAnalysis obj = new SensorDataAnalysis();

			int continuityVal = SensorDataAnalysis.searchContinuityAboveValue("../DiamondKinetics/src/latestSwing.csv", 139, 145, 0.4564, 3);
			System.out.println("Continuity above value: " + continuityVal);

			int continuityValWthRange = SensorDataAnalysis.backSearchContinuityWithinRange("../DiamondKinetics/src/latestSwing.csv", 90, 0, 0.2, 0.702148, 12);
			System.out.println("Continuity value within the given range: " + continuityValWthRange);
			
			
			int continuityAbvVal2Sig = SensorDataAnalysis.searchContinuityAboveValueTwoSignals("../DiamondKinetics/src/latestSwing.csv", "../DiamondKinetics/src/latestSwing.csv", 2, 90, 0.2, 0.3, 12);
			System.out.println("Continuity above two signal Value: " + continuityAbvVal2Sig);
			
			
			String multiContinuityWthRange = SensorDataAnalysis.searchMultiContinuityWithinRange("../DiamondKinetics/src/latestSwing.csv", 0, 90, 0.2, 0.702148, 12);
			System.out.println("Multi Continuity within the given range value: " + multiContinuityWthRange);
			
			/*
			  System.out.println("No. of sensor data:" + map.size());
			  Iterator<Entry<Integer, HashMap<BigInteger, Double[]>>> i =
			  map.entrySet().iterator(); while (i.hasNext()) { Map.Entry val =
			  (Map.Entry) i.next(); System.out.println("Key..." +
			  val.getKey());
			 
			  System.out.print("Value.."); HashMap<BigInteger, Double[]> t =
			  (HashMap<BigInteger, Double[]>) val.getValue(); for (int j = 0; j
			  < t.size(); j++) { Iterator<Entry<BigInteger, Double[]>> m =
			  t.entrySet().iterator(); while(m.hasNext()) { Map.Entry finalVal
			  = (Map.Entry) m.next(); System.out.print(finalVal.getKey());
			  
			  Double[] d = new Double[6]; d = (Double[]) finalVal.getValue();
			  for (int k=0; k< d.length; k++) { System.out.print(d[k]+","); } }
			  }
			  
			  }
			 */


	}

}
