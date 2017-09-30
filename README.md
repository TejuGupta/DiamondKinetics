# DiamondKinetics
Solution for the coding challenge round at DiamondKinetics



1. The source file which contains the API is "SensorDataAnalysis.java".  "SensorData.java" class holds the sensor data value which are retrieved from the csv file (the csv file is kept
   within the src folder for now, you can have many more csv files but kindly specify the path of the csv file as input to the APIs. The data attribute of the API takes in a string value
   which would be the path of the csv file on which the criteria has to be checked. This file can be changed at any point in time.  
   The values from any csv file given are added into an ArrayList<SensorData> which is later retrieved from indexBegin to indexEnd to check for the criteria as per each APIs requirement and
   an index value in returned as output. 
   
2. In case of the fourth operation since two index values have to returned I have considered the output to be a string wherein the values are separated by a space. 

3. Additionally, I have also written parametrized test cases for each one of the API to test them. You can add many more test data within the parameterized array to check 
   for the functional correctness of all four operations. Incase I have missed out on something or some of the scenario are incorrect or some edge conditions fail kindly help me with it.
   I owuld love to work with you to fix things.
   
4. In case, the indexEnd - indexBegin < winLength I have returned -1 value, similarly if am not able to find any samples within the winLength window I have returned -1. This is just to handle
   the edge conditions.
   
5. If am totally wrong with my approach, I would like to get some comments/feedback to improvize on the solution that I have obtained.

6. I have not uplaoded the latestSwing.csv file due to confidentiality reasons, kindly place the csv file in the src folder before executing the test cases otherwise it would throw 
   file not found exception



