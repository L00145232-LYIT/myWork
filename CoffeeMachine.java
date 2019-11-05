/*
COFFEE MACHINE
-------------------------
- maxWeight:double
- currentWeight: double
- BEAN_WEIGHT: double(7.5 grams)
- noOfEspressos: int
--------------------------
+ CoffeeMachine(double)
--------------------------
+ fill():void
+ empty():void
+ makeEspresso(String):String
+ getMaxWeight():double
+ getCurrentWeight():double
+ getBEAN_WEIGHT():double
+ getNoOfEspressos():int
+ getStats():
*/

public class CoffeeMachine
{
   //instance variables
   private double currentWeight;
   private double maxWeight;
   private final double BEAN_WEIGHT;
   private int noOfEspressos;

   //constructors
   public CoffeeMachine(double maxWeightIn)
   {
      currentWeight=0;
      maxWeight=maxWeightIn;
      BEAN_WEIGHT=7.5;
      noOfEspressos=0;
   }

   //methods
   public void fill()
   {
      currentWeight=maxWeight;
   }
  
   public void empty()
   {
      currentWeight=0;
   }
 
   public String makeEspresso(String coffeeSizeIn)
   {
      String m="";
      double weightRequired;
      if(coffeeSizeIn.equalsIgnoreCase("Regular") )
      {
         weightRequired=BEAN_WEIGHT;
      } 
      else 
      {
         m="Large";
         weightRequired=BEAN_WEIGHT*2;
      }
      if(currentWeight<weightRequired)
         m="INSUFFICENT COFFEE BEANS";
      else
      {
         m+= "Expresso made now";
         currentWeight-=weightRequired;
         noOfEspressos++;
      }
      
      
      return m;
   
   }
 
   public double getMaxWeight()
   {
      return maxWeight;
   }
 
   public double getCurrentWeight()
   {
      return currentWeight;
   }
 
   public double getBEAN_WEIGHT()
   {
      return BEAN_WEIGHT;
   }
 
   public int getNoOfEspressos()
   {
      return noOfEspressos;
   }
 
   public String getStats()
   {
      String s;
      s="Weight left in machine: "+ getCurrentWeight() +
         "No. of Expressos: " + getNoOfEspressos() + 
         " No Standard exp available: "+ ((int)currentWeight/BEAN_WEIGHT);
   
      if(currentWeight<(maxWeight*0.2) )
         s+= "level low ";
      else
         s+="level OK ";
      return s;
   }
 
}//end class